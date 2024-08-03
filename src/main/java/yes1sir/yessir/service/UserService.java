package yes1sir.yessir.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yes1sir.yessir.dto.GoogleAccountProfileResponse;
import yes1sir.yessir.model.GoogleLogin;
import yes1sir.yessir.model.User;
import yes1sir.yessir.repository.GoogleLoginRepository;
import yes1sir.yessir.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GoogleLoginRepository googleLoginRepository;

    public User findOrCreateUser(GoogleAccountProfileResponse profile) {
        GoogleLogin googleLogin = googleLoginRepository.findByGoogleId(profile.getId());

        if (googleLogin != null) {
            return googleLogin.getUser();
        }

        User user = new User();
        user.setEmail(profile.getEmail());
        userRepository.save(user);

        GoogleLogin newGoogleLogin = new GoogleLogin();
        newGoogleLogin.setGoogleId(profile.getId());
        newGoogleLogin.setUser(user);
        googleLoginRepository.save(newGoogleLogin);

        return user;
    }
}
