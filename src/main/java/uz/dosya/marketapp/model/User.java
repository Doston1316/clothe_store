package uz.dosya.marketapp.model;

import lombok.Data;
import uz.dosya.marketapp.enam.Status;

import javax.persistence.*;
import java.util.Set;
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private Status status;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_name",referencedColumnName = "name"))
    private Set<Role> roles;



}
