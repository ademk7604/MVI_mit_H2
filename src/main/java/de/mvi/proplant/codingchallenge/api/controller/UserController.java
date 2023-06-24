package de.mvi.proplant.codingchallenge.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import de.mvi.proplant.codingchallenge.api.model.User;
import de.mvi.proplant.codingchallenge.api.model.dto.UserDto;
import de.mvi.proplant.codingchallenge.api.model.dto.UserMapper;
import de.mvi.proplant.codingchallenge.api.repository.UserRepository;

@RestController
@CrossOrigin(origins="http://localhost:3000")

public class UserController {
    
    @Autowired
    private UserRepository userRepository;

    UserController() {
        
    }
    
    @GetMapping(value="/users", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<UserDto> listUsers() {

        List<User> users = userRepository.findAll();

        List<UserDto> usersDto = UserMapper.INSTANCE.map(users);

        return usersDto;
    }

    @GetMapping(value="/users/{uuid}")
    public ResponseEntity<?> getUser(@PathVariable String uuid) {

        try {
            UUID realUUID = UUID.fromString(uuid);

            Optional<User> user = userRepository.findById(realUUID);

            if(user.isPresent()) {
                
                UserDto userDto = UserMapper.INSTANCE.userToUserDto(user.get());

                return new ResponseEntity<>(userDto, HttpStatus.OK);
            }
            else
            { 
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("message", "User not found.");

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
            }

        } catch (Exception e) {

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", "User ID is not valid.");
            
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
        }
    }

}
