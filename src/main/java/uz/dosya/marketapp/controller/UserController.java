package uz.dosya.marketapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.dosya.marketapp.customService.UserService;
import uz.dosya.marketapp.model.User;

@RestController
@RequestMapping("/api/register")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping()
    public ResponseEntity create(@RequestBody User user){
        if (!checkPassword(user.getPassword())){
            return new ResponseEntity("parol 4 tadan ko'p bo'lishi lozim//", HttpStatus.BAD_REQUEST);
        }

        if (userService.checkUserName(user.getUserName())){
            return new ResponseEntity("Ushbu foydalanuvchi oldin ro'yxatdan o'tgan//", HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(userService.create(user));

    }


    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }



    private boolean checkPassword(String password) {
        return password.length()>=4;
    }

}

