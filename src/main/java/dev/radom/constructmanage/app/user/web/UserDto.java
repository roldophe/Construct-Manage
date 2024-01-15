package dev.radom.constructmanage.app.user.web;

import java.time.LocalDateTime;
import java.util.List;

public record UserDto(String uuid,
                      String username,
                      String email,
                      String avatar,
                      LocalDateTime creationAt,
                      LocalDateTime updatedAt,
                      List<String> roles) {
}
