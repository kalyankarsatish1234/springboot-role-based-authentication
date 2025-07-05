package com.app.service.mapper;

import com.app.model.User;
import com.app.model.UserRole;
import com.app.service.dto.UserDto;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-04T16:01:04+0530",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.2.jar, environment: Java 17.0.14 (JetBrains s.r.o.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setId( dto.getId() );
        user.setUid( dto.getUid() );
        user.setFirstName( dto.getFirstName() );
        user.setLastName( dto.getLastName() );
        user.setEmail( dto.getEmail() );
        user.setPhone( dto.getPhone() );
        user.setPassword( dto.getPassword() );
        user.setProfileImageUrl( dto.getProfileImageUrl() );
        user.setPrimaryRole( dto.getPrimaryRole() );
        Set<UserRole> set = dto.getRoles();
        if ( set != null ) {
            user.setRoles( new LinkedHashSet<UserRole>( set ) );
        }
        user.setEnabled( dto.isEnabled() );
        user.setFcmToken( dto.getFcmToken() );

        return user;
    }

    @Override
    public UserDto toDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserDto.UserDtoBuilder userDto = UserDto.builder();

        userDto.id( entity.getId() );
        userDto.uid( entity.getUid() );
        userDto.firstName( entity.getFirstName() );
        userDto.profileImageUrl( entity.getProfileImageUrl() );
        userDto.lastName( entity.getLastName() );
        userDto.enabled( entity.isEnabled() );
        userDto.primaryRole( entity.getPrimaryRole() );
        userDto.email( entity.getEmail() );
        userDto.fcmToken( entity.getFcmToken() );
        userDto.phone( entity.getPhone() );
        userDto.password( entity.getPassword() );
        Set<UserRole> set = entity.getRoles();
        if ( set != null ) {
            userDto.roles( new LinkedHashSet<UserRole>( set ) );
        }

        return userDto.build();
    }

    @Override
    public List<User> toEntity(List<UserDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( dtoList.size() );
        for ( UserDto userDto : dtoList ) {
            list.add( toEntity( userDto ) );
        }

        return list;
    }

    @Override
    public List<UserDto> toDto(List<User> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( entityList.size() );
        for ( User user : entityList ) {
            list.add( toDto( user ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(User entity, UserDto dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getUid() != null ) {
            entity.setUid( dto.getUid() );
        }
        if ( dto.getFirstName() != null ) {
            entity.setFirstName( dto.getFirstName() );
        }
        if ( dto.getLastName() != null ) {
            entity.setLastName( dto.getLastName() );
        }
        if ( dto.getEmail() != null ) {
            entity.setEmail( dto.getEmail() );
        }
        if ( dto.getPhone() != null ) {
            entity.setPhone( dto.getPhone() );
        }
        if ( dto.getPassword() != null ) {
            entity.setPassword( dto.getPassword() );
        }
        if ( dto.getProfileImageUrl() != null ) {
            entity.setProfileImageUrl( dto.getProfileImageUrl() );
        }
        if ( dto.getPrimaryRole() != null ) {
            entity.setPrimaryRole( dto.getPrimaryRole() );
        }
        if ( entity.getRoles() != null ) {
            Set<UserRole> set = dto.getRoles();
            if ( set != null ) {
                entity.getRoles().clear();
                entity.getRoles().addAll( set );
            }
        }
        else {
            Set<UserRole> set = dto.getRoles();
            if ( set != null ) {
                entity.setRoles( new LinkedHashSet<UserRole>( set ) );
            }
        }
        entity.setEnabled( dto.isEnabled() );
        if ( dto.getFcmToken() != null ) {
            entity.setFcmToken( dto.getFcmToken() );
        }
    }
}
