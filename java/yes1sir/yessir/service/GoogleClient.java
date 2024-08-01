package yes1sir.yessir.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import yes1sir.yessir.dto.GoogleAccessTokenRequest;
import yes1sir.yessir.dto.GoogleAccessTokenResponse;
import yes1sir.yessir.dto.GoogleAccountProfileResponse;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Component
public class GoogleClient {

    @Value("${spring.security.oauth2.client.registration.google.client-id}")
    private String clientId;
    @Value("${spring.security.oauth2.client.registration.google.client-secret}")
    private String clientSecret;
    @Value("${spring.security.oauth2.client.registration.google.redirect-uri}")
    private String redirectUri;
    @Value("${url.access-token}")
    private String accessTokenUrl;

    private final RestTemplate restTemplate;

    @Autowired
    public GoogleClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getGoogleAccessToken(final String code) {
        final String decodedCode = URLDecoder.decode(code, StandardCharsets.UTF_8);
        final HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        final GoogleAccessTokenRequest tokenRequest = new GoogleAccessTokenRequest(decodedCode, clientId, clientSecret, redirectUri, "authorization_code");
        final HttpEntity<GoogleAccessTokenRequest> httpEntity = new HttpEntity<>(tokenRequest, headers);
        final GoogleAccessTokenResponse response = restTemplate.exchange(
                accessTokenUrl, HttpMethod.POST, httpEntity, GoogleAccessTokenResponse.class
        ).getBody();
        return Optional.ofNullable(response)
                .orElseThrow(() -> new RuntimeException("NOT_FOUND_GOOGLE_ACCESS_TOKEN_RESPONSE"))
                .getAccessToken();
    }

    public GoogleAccountProfileResponse getGoogleAccountProfile(final String accessToken) {
        final HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
        final HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        return restTemplate.exchange("https://www.googleapis.com/userinfo/v2/me", HttpMethod.GET, httpEntity, GoogleAccountProfileResponse.class)
                .getBody();
    }
}
