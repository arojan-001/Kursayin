package com.saga.kursayin.service.dto;

import com.saga.kursayin.persistence.entity.UserDetailsEntity;
import lombok.Data;

@Data
public class UserDetailsDto {

    private Long id;

    private String  firstName;

    private String lastName;

    private String email;

    private Long phoneNumber;

    private Integer age;

    public static UserDetailsDto mapEntityToDto(UserDetailsEntity userDetailsEntity){
        UserDetailsDto dto = new UserDetailsDto();
        dto.setId(userDetailsEntity.getId());
        dto.setFirstName(userDetailsEntity.getFirstName());
        dto.setLastName(userDetailsEntity.getLastName());
        dto.setEmail(userDetailsEntity.getEmail());
        dto.setAge(userDetailsEntity.getAge());
        dto.setPhoneNumber(userDetailsEntity.getPhoneNumber());
        return dto;
    }

    public static UserDetailsEntity mapDtoToEntity(UserDetailsDto userDetailsDto){
        UserDetailsEntity userDetailsEntity = new UserDetailsEntity();
        userDetailsEntity.setFirstName(userDetailsDto.getFirstName());
        userDetailsEntity.setLastName(userDetailsDto.getLastName());
        userDetailsEntity.setEmail(userDetailsDto.getEmail());
        userDetailsEntity.setAge(userDetailsDto.getAge());
        userDetailsEntity.setPhoneNumber(userDetailsDto.getPhoneNumber());
        return userDetailsEntity;
    }
}
