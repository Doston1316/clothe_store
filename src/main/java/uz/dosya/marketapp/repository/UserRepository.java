package uz.dosya.marketapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.dosya.marketapp.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsByUserName(String username);
    User findByUserName(String username);
}
