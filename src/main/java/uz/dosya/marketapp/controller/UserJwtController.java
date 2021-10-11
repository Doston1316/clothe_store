package uz.dosya.marketapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.dosya.marketapp.model.AuthRequest;
import uz.dosya.marketapp.model.User;
import uz.dosya.marketapp.repository.UserRepository;
import uz.dosya.marketapp.security.JwtTokenProvider;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/token")
@RequiredArgsConstructor
public class UserJwtController {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;



    @PostMapping()
    public ResponseEntity createToken(@RequestBody AuthRequest authRequest){
        User user=userRepository.findByUserName(authRequest.getUserName());
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(),authRequest.getPassword()));
        }catch (Exception e){
            throw new IllegalStateException("Invalid username or password");
        }
        String token=jwtTokenProvider.createToken(user.getUserName(),user.getRoles());
        Map<Object,Object>map=new HashMap<>();
        map.put("username",user.getUserName());
        map.put("token",token);
        return ResponseEntity.ok(map);
    }


}
