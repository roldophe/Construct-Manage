package dev.radom.constructmanage.app.auth.web;


import lombok.Builder;

@Builder
public record AuthDto(String accessToken,
                      String refreshToken,
                      String type) {
}