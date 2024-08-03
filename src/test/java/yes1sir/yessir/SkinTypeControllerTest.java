package yes1sir.yessir;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import yes1sir.yessir.controller.SkinTypeController;
import yes1sir.yessir.model.SkinType;
import yes1sir.yessir.service.SkinTypeService;

@WebMvcTest(SkinTypeController.class)
public class SkinTypeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SkinTypeService skinTypeService;

    @Test
    public void testGetSkinTypeByUserId_Success() throws Exception {
        // Mock data
        SkinType mockSkinType = new SkinType();
        mockSkinType.setSkinTypeID(4L);
        mockSkinType.setSkinTypeName("DRPT");
        mockSkinType.setDescription("Oily skin is characterized by excess sebum production.");

        // Mock service response
        when(skinTypeService.getSkinTypeByUserId(7L)).thenReturn(Optional.of(mockSkinType));

        // Perform the request and check the response
        mockMvc.perform(get("/api/skin_types/7"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.body.userId").value(7))
                .andExpect(jsonPath("$.body.skinTypeID").value(4))
                .andExpect(jsonPath("$.body.skinTypeName").value("DRPT"))
                .andExpect(jsonPath("$.body.description").value("Oily skin is characterized by excess sebum production."));
    }

    @Test
    public void testGetSkinTypeByUserId_UserNotFound() throws Exception {
        // Mock service response
        when(skinTypeService.getSkinTypeByUserId(999L)).thenReturn(Optional.empty());

        // Perform the request and check the response
        mockMvc.perform(get("/api/skin_types/999"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.detail").value("사용자를 찾을 수 없습니다."));
    }
}
