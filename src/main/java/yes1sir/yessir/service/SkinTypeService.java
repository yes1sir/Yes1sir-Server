package yes1sir.yessir.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yes1sir.yessir.model.SkinType;
import yes1sir.yessir.repository.SkinTypeRepository;

import java.util.Optional;

@Service
public class SkinTypeService {

    private final SkinTypeRepository skinTypeRepository;

    @Autowired
    public SkinTypeService(SkinTypeRepository skinTypeRepository) {
        this.skinTypeRepository = skinTypeRepository;
    }

    public Optional<SkinType> findById(Long id) {
        return skinTypeRepository.findById(id);
    }
}
