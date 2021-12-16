//package uz.dosya.marketapp.customService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import uz.dosya.marketapp.enam.Status;
//import uz.dosya.marketapp.entity.Role;
//import uz.dosya.marketapp.entity.User;
//import uz.dosya.marketapp.repository.UserRepository;
//@Service
//public class UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//
//    public User create(User user){
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setStatus(Status.ACTIVE);
//        user.setRoles(user.getRoles());
//        return userRepository.save(user);
//    }
//
//    public boolean checkUserName(String username){
////        return userRepository.existsByUserName(username);
////    }
//}
