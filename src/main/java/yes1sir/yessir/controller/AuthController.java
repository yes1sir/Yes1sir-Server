package yes1sir.yessir.controller;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yes1sir.yessir.model.GoogleLogin;
import yes1sir.yessir.model.User;
import yes1sir.yessir.repository.GoogleLoginRepository;
import yes1sir.yessir.repository.UserRepository;
import yes1sir.yessir.service.GoogleClient;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("${app.base.url}/api/google_login")
public class AuthController {

    private final GoogleClient googleClient;
    private final GoogleLoginRepository googleLoginRepository;
    private final UserRepository userRepository;

    @Autowired
    public AuthController(GoogleClient googleClient, GoogleLoginRepository googleLoginRepository, UserRepository userRepository) {
        this.googleClient = googleClient;
        this.googleLoginRepository = googleLoginRepository;
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<?> googleLogin(@RequestBody GoogleLoginRequest request) {
        try {
            GoogleIdToken.Payload payload = googleClient.verifyToken(request.getToken());
            String googleId = payload.getSubject();
            String email = payload.getEmail();

            Optional<User> optionalUser = userRepository.findByGoogleId(Long.parseLong(googleId));
            User user;
            if (optionalUser.isPresent()) {
                user = optionalUser.get();
            } else {
                user = new User();
                user.setGoogleId(Long.parseLong(googleId));
                user.setEmail(email);
                user = userRepository.save(user);

                GoogleLogin googleLogin = new GoogleLogin();
                googleLogin.setGoogleId(Long.parseLong(googleId));
                googleLogin.setUserId(user.getId());
                googleLoginRepository.save(googleLogin);
            }

            String jwtToken = createJwtToken(user.getId());
            return ResponseEntity.ok(new LoginResponse(user.getId(), jwtToken, LocalDateTime.now().plusHours(1)));
        } catch (Exception e) {
            e.printStackTrace(); // 로그에 예외를 출력하여 문제를 파악
            return ResponseEntity.status(400).body(new ErrorResponse("인증에 실패하였습니다: " + e.getMessage()));
        }
    }

    private String createJwtToken(Long userId) {
        return "generated-jwt-token";
    }

    static class GoogleLoginRequest {
        private String token;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }

    static class LoginResponse {
        private Long userId;
        private String token;
        private LocalDateTime expiresAt;

        public LoginResponse(Long userId, String token, LocalDateTime expiresAt) {
            this.userId = userId;
            this.token = token;
            this.expiresAt = expiresAt;
        }
    }

    static class ErrorResponse {
        private String detail;

        public ErrorResponse(String detail) {
            this.detail = detail;
        }

        public String getDetail() {
            return detail;
        }
    }
}
