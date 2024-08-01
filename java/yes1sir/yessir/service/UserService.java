package yes1sir.yessir.service;

import org.springframework.stereotype.Service;
import yes1sir.yessir.dto.GoogleAccountProfileResponse;
import yes1sir.yessir.model.User;

@Service
public class UserService {

    public User findOrCreateUser(GoogleAccountProfileResponse profile) {
        return new User(profile.getId(), profile.getEmail(), profile.getName());
    }
}
