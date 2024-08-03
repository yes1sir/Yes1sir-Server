package yes1sir.yessir.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yes1sir.yessir.model.User;
import yes1sir.yessir.repository.UserRepository;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createOrUpdateUser(Payload payload) {
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
        }
        return user;
    }
}
