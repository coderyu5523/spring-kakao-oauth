package org.example.loginapp.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

import java.sql.Timestamp;

public class KakaoResponse {
    @Data
    public static class TokenDTO{
        @JsonProperty("access_token")
        private String accessToken;
        @JsonProperty("token_type")
        private String tokenType;
        @JsonProperty("refresh_token")
        private String refreshToken;
        @JsonProperty("expires_in")
        private Integer expiresIn;
        private String scope ;  // scope 는 배열이기 떄문에 선택한 갯수에 따라 파싱이 달라질 수 있음.
        @JsonProperty("refresh_token_expires_in")
        private Integer refreshTokenExpiresIn;
    }

//    {
//        "access_token": "cF8KxpGGr_PZ6RQhX6VW7qy9kAcKPhMJAAAAAQo9c-wAAAGPzRoMqcYNwJ_muSR4",
//        "token_type": "bearer",
//        "refresh_token": "CkRmjTlcVkiVgvedDVGT7eCd9LK-T0UbAAAAAgo9c-wAAAGPzRoMpsYNwJ_muSR4",
//        "expires_in": 21599,
//        "scope": "profile_nickname",
//        "refresh_token_expires_in": 5183999
//    }

    @Data
    public static class KakaoUserDTO {
        private Long id;
        @JsonProperty("connected_at")
        private Timestamp connectedAt;
        private Properties properties;

        @Data
        class Properties {
            private String nickname;
        }
    }

//    {
//        "id":3506279095,
//        "connected_at":"2024-05-31T05:23:08Z",
//        "properties":{
//            "nickname":"최주호"
//        }
//    }

}
