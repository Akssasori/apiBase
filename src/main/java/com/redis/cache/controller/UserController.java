package com.redis.cache.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.redis.cache.dto.UserDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class UserController {

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody
                                @Validated(UserDTO.UserView.Login.class)
                                @JsonView(UserDTO.UserView.Login.class)
                                UserDTO userDTO) {

        log.info(userDTO);

        return ResponseEntity.ok().body(userDTO);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody
                                   @Validated(UserDTO.UserView.Register.class)
                                   @JsonView(UserDTO.UserView.Register.class)
                                   UserDTO userDTO) {

        log.info(userDTO);

        return ResponseEntity.ok().body(userDTO);
    }
}
