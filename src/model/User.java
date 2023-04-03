package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,orhap)
    protected int id;

    @Column(unique = true)
    private String login;
    private String password;
    private String name;
    private String surname;
    @Column(unique = true)
    private String email;
    @Column(name="birth_date")
    private LocalDate birthDate;


    public User(String login, String password, String name, String surname, String email, LocalDate birthDate) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthDate = birthDate;
    }

    public String toString()
    {
        return this.name + " " + this.id;
    }

}
