package yes1sir.yessir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yes1sir.yessir.model.SkinType;
import yes1sir.yessir.service.SkinTypeService;

@RestController
@RequestMapping("${app.base.url}/api/skin_types")
public class SkinTypeController {

    private final SkinTypeService skinTypeService;

    @Autowired
    public SkinTypeController(SkinTypeService skinTypeService) {
        this.skinTypeService = skinTypeService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getSkinTypeByUserId(@PathVariable Long userId) {
        return skinTypeService.getSkinTypeByUserId(userId)
                .map(skinType -> ResponseEntity.ok(new SkinTypeResponse(userId, skinType)))
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("사용자를 찾을 수 없습니다.")));
    }

    static class SkinTypeResponse {
        private Long userId;
        private Long skinTypeID;
        private String skinTypeName;
        private String description;

        public SkinTypeResponse(Long userId, SkinType skinType) {
            this.userId = userId;
            this.skinTypeID = skinType.getSkinTypeID();
            this.skinTypeName = skinType.getSkinTypeName();
            this.description = skinType.getDescription();
        }

        // Getters and setters
        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public Long getSkinTypeID() {
            return skinTypeID;
        }

        public void setSkinTypeID(Long skinTypeID) {
            this.skinTypeID = skinTypeID;
        }

        public String getSkinTypeName() {
            return skinTypeName;
        }

        public void setSkinTypeName(String skinTypeName) {
            this.skinTypeName = skinTypeName;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    static class ErrorResponse {
        private String detail;

        public ErrorResponse(String detail) {
            this.detail = detail;
        }

        // Getter and setter
        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }
    }
}
