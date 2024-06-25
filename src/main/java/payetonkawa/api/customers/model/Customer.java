package payetonkawa.api.customers.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
public class Customer {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name="last_name", nullable = false)
    private String lastName;

    @Column(name="user_name", nullable = false)
    private String userName;

    @Column(name = "mail")
    private String mail;

    @Column(name="address", nullable = false)
    private String address;

    @Column(name="company", nullable = false)
    private String company;
}
