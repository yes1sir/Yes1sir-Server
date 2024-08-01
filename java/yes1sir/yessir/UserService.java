package yes1sir.yessir;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User findOrCreateUser(GoogleAccountProfileResponse profile) {
        return new User(profile.getId(), profile.getEmail(), profile.getName());
    }
}
