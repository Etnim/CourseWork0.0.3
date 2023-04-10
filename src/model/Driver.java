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
public class Driver extends User{
    private int exprYears;
    private String medCertificateNum;
    private String driveLicenseNum;
    @OneToOne()
    @JoinColumn(name="tripD_id")
    private Trip tripD;

    public Driver(String login, String password, String name, String surname, String email, LocalDate birthDate, int exprYears, String medCertificateNum, String driveLicenseNum) {
        super(login, password, name, surname, email, birthDate);
        this.exprYears = exprYears;
        this.medCertificateNum = medCertificateNum;
        this.driveLicenseNum = driveLicenseNum;
    }


}
