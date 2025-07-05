package com.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class User extends Auditable implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String uid;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "otp")
    private String otp;

    @Column(name = "expiry_time")
    private LocalDateTime expiryTime;

    @NotBlank
    @Email(message = "Must be a well-formed email address")
    @Column(unique = true)
    private String email;

    @NotBlank
    @Column(name = "phone", nullable = false)
    private String phone;

    @JsonIgnore
    @NotBlank(message = "Password cannot be blank")
    private String password;

    private String profileImageUrl;

    @Enumerated(EnumType.STRING)
    private UserRole primaryRole;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<UserRole> roles = new HashSet<>();

    private boolean enabled;

    private boolean emailVerified;

    private boolean phoneVerified;

    private boolean documentVerified;

    @Column(name = "verification_token")
    private String verificationToken;

    @Column(name = "verification_token_expiry")
    private LocalDateTime verificationTokenExpiryDate;

    @Column(name = "reset_password_token")
    private String resetPasswordToken;

    @Column(name = "reset_password_token_expiry")
    private LocalDateTime resetPasswordTokenExpiryDate;

    @Column(name = "password_last_changed_at")
    private LocalDateTime passwordLastChangedAt;

    @Column(name = "disabled_at")
    private LocalDateTime disabledAt;


    @Column(name = "disabled_reason")
    private String disabledReason;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    private boolean emailNotificationsEnabled;

    private boolean pushNotificationsEnabled;

    private String fcmToken;

    public boolean hasRole(UserRole role) {
        return roles.contains(role);
    }

    public void addRole(UserRole role) {
        roles.add(role);
    }

    public void removeRole(UserRole role) {
        roles.remove(role);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (UserRole role : roles) {
            authorities.add(() -> role.name());
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
