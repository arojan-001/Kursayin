package com.saga.kursayin.service;

import com.saga.kursayin.common.exeptions.UserNotFoundException;
import com.saga.kursayin.persistence.entity.UserDetailsEntity;
import com.saga.kursayin.persistence.entity.UserEntity;
import com.saga.kursayin.persistence.repository.UserRepository;
import com.saga.kursayin.service.dto.UserDetailsDto;
import com.saga.kursayin.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }

    public UserDto addUser(UserDto userDto) {
        UserEntity userEntity = UserDto.mapDtoToEntity(userDto);
        UserDetailsDto userDetailsDto = userDetailsService.addUserDetails(userDto.getUserDetails());
        UserDetailsEntity userDetailsEntity = UserDetailsDto.mapDtoToEntity(userDetailsDto);
        userDetailsEntity.setId(userDetailsDto.getId());
        userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userEntity.setUserDetailsEntity(userDetailsEntity);
        UserEntity savedEntity = userRepository.save(userEntity);
        return UserDto.mapEntityToDto(savedEntity);
    }

    public UserDto getUser(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return UserDto.mapEntityToDto(userEntity);
    }

    public UserDto updateUser(Long id, UserDto userDto) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        userEntity.setUsername(userDto.getUsername());
        userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));
        UserEntity updatedUser = userRepository.save(userEntity);
        return UserDto.mapEntityToDto(updatedUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
