package com.saga.kursayin.service.dto;

import com.saga.kursayin.persistence.entity.UserDetailsEntity;
import com.saga.kursayin.persistence.entity.UserEntity;
import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.util.CollectionUtils;

@Data
public class UserDto {

    private Long id;

    @NotNull
    private String username;

    @NotNull
    private String password;

    private String status;

    private UserDetailsDto userDetails;

    public static UserDto mapEntityToDto(UserEntity userEntity){
        UserDto dto = new UserDto();
        dto.setId(userEntity.getId());
        dto.setUsername(userEntity.getUsername());
        dto.setPassword(userEntity.getPassword());
        dto.setStatus(userEntity.getStatus());
        UserDetailsEntity userDetailsEntity = userEntity.getUserDetailsEntity();
        if(userDetailsEntity!=null){
            dto.setUserDetails(UserDetailsDto.mapEntityToDto(userEntity.getUserDetailsEntity()));
        }
        return dto;
    }

    public static UserEntity mapDtoToEntity(UserDto userDto){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDto.getUsername());
        userEntity.setStatus(userDto.getStatus());
        return userEntity;
    }
}
