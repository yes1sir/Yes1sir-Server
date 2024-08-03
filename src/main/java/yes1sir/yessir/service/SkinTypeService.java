package yes1sir.yessir.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yes1sir.yessir.model.SkinType;
import yes1sir.yessir.model.User;
import yes1sir.yessir.repository.SkinTypeRepository;
import yes1sir.yessir.repository.UserRepository;

import java.util.Optional;

@Service
public class SkinTypeService {
    private final SkinTypeRepository skinTypeRepository;
    private final UserRepository userRepository;

    @Autowired
    public SkinTypeService(SkinTypeRepository skinTypeRepository, UserRepository userRepository) {
        this.skinTypeRepository = skinTypeRepository;
        this.userRepository = userRepository;
    }

    public Optional<SkinType> getSkinTypeByUserId(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.map(User::getSkinType);
    }
}
