package com.saga.kursayin.controller;

import com.saga.kursayin.service.dto.UserDetailsDto;
import com.saga.kursayin.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user_details")
public class UserDetailsController {

    private final UserDetailsService userDetailsService;

    @Autowired
    public UserDetailsController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDetailsDto> updateUserDetails(@PathVariable Long id, @RequestBody UserDetailsDto userDetailsDto){
        UserDetailsDto dto = userDetailsService.updateUserDetails(id,userDetailsDto);
        return ResponseEntity.ok(dto);
    }
}
