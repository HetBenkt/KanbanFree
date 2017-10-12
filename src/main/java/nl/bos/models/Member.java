package nl.bos.models;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by bosa on 21-9-2017.
 */
@Data
@Entity
@Table(name = "MEMBERS")
public class Member {
    public Member() {
    }

    public Member(String nickName, String password, String role, String firstName, String lastName, String mailAddress) {
        this.nickName = nickName;
        this.password = password;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mailAddress = mailAddress;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "NICK_NAME")
    @NotEmpty
    private String nickName;

    @Column(name = "PASSWORD")
    @NotEmpty
    private String password;

    @Column(name = "ROLE")
    @NotEmpty
    private String role;

    @Column(name = "FIRST_NAME")
    @NotEmpty
    private String firstName;

    @Column(name = "LAST_NAME")
    @NotEmpty
    private String lastName;

    @Column(name = "MAIL_ADDRESS")
    @NotEmpty
    private String mailAddress;
}
