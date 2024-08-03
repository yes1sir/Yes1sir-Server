package yes1sir.yessir.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yes1sir.yessir.model.SkinType;
import yes1sir.yessir.repository.UserRepository;

import java.util.Optional;

@Service
public class SkinTypeService {

    private final UserRepository userRepository;

    @Autowired
    public SkinTypeService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<SkinType> getSkinTypeByUserId(Long userId) {
        return userRepository.findById(userId)
                .flatMap(user -> Optional.ofNullable(user.getSkinType()));
    }
}
