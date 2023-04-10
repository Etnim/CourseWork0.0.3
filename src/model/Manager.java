package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Manager extends User{
    private boolean isAdmin;
    private String phoneNum;
    public boolean isAdmin(){
        return isAdmin;
    }
    public void setAdmin(boolean admin){
        isAdmin = admin;
    }
    @ManyToOne()
    @JoinColumn(name="tripM_id")
    private Trip tripM;
    public Manager(String login, String password, String name, String surname, String email, LocalDate birthDate, boolean isAdmin, String phoneNum) {
        super(login, password, name, surname, email, birthDate);
        this.isAdmin = isAdmin;
        this.phoneNum = phoneNum;
    }

}
