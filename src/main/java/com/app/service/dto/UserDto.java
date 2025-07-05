package com.app.service.dto;

import com.app.model.UserRole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String uid;
    private String firstName;
    private String profileImageUrl;
    private String lastName;
    private boolean enabled;
    @Enumerated(EnumType.STRING)
    private UserRole primaryRole;
    private String email;
    private String fcmToken;
    private String phone;
    private String password;
    private Set<UserRole> roles;
}
