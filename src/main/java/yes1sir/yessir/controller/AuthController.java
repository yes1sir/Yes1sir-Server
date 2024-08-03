package yes1sir.yessir.controller;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yes1sir.yessir.model.GoogleLogin;
import yes1sir.yessir.model.User;
import yes1sir.yessir.repository.GoogleLoginRepository;
import yes1sir.yessir.repository.UserRepository;
import yes1sir.yessir.service.GoogleClient;
import yes1sir.yessir.service.UserService;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/google_login")
public class AuthController {

    private final GoogleClient googleClient;
    private final GoogleLoginRepository googleLoginRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public AuthController(GoogleClient googleClient, GoogleLoginRepository googleLoginRepository, UserRepository userRepository, UserService userService) {
        this.googleClient = googleClient;
        this.googleLoginRepository = googleLoginRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> googleLogin(@RequestBody GoogleLoginRequest request) {
        try {
            GoogleIdToken.Payload payload = googleClient.verifyToken(request.getToken());
            User user = userService.createOrUpdateUser(payload);
            String jwtToken = createJwtToken(user.getUserID());
            return ResponseEntity.ok(new LoginResponse(user.getUserID(), jwtToken, LocalDateTime.now().plusHours(1)));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(new ErrorResponse("인증에 실패하였습니다."));
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
