package yes1sir.yessir;

import lombok.Data;

@Data
public class GoogleAccountProfileResponse {
    private String id;
    private String email;
    private boolean verifiedEmail;
    private String name;
    private String givenName;
    private String familyName;
    private String picture;
    private String locale;

    // 추가된 getter 메서드
    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
