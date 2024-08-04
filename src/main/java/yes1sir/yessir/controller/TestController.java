package yes1sir.yessir.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${app.base.url}")
    private String baseUrl;

    @GetMapping("/test-url")
    public String getBaseUrl() {
        return baseUrl;
    }

}
