package yes1sir.yessir;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final GoogleClient googleClient;
    private final JwtTokenGenerator jwtTokenGenerator;
    private final UserService userService;

    @Autowired
    public AuthController(GoogleClient googleClient, JwtTokenGenerator jwtTokenGenerator, UserService userService) {
        this.googleClient = googleClient;
        this.jwtTokenGenerator = jwtTokenGenerator;
        this.userService = userService;
    }

    @PostMapping("/google")
    public String googleLogin(@RequestBody Map<String, String> request) {
        String code = request.get("code");
        String accessToken = googleClient.getGoogleAccessToken(code);
        GoogleAccountProfileResponse profile = googleClient.getGoogleAccountProfile(accessToken);
        User user = userService.findOrCreateUser(profile);
        return jwtTokenGenerator.generateToken(user.getId());
    }
}
