package nl.bos.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

/**
 * Created by bosa on 21-9-2017.
 */
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

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Setter
    @Getter
    @Column(name = "NICK_NAME")
    @NotEmpty
    private String nickName;

    @Setter
    @Getter
    @Column(name = "PASSWORD")
    @NotEmpty
    private String password;

    @Setter
    @Getter
    @Column(name = "ROLE")
    @NotEmpty
    private String role;

    @Setter
    @Getter
    @Column(name = "FIRST_NAME")
    @NotEmpty
    private String firstName;

    @Setter
    @Getter
    @Column(name = "LAST_NAME")
    @NotEmpty
    private String lastName;

    @Setter
    @Getter
    @Column(name = "MAIL_ADDRESS")
    @NotEmpty
    private String mailAddress;

    @Setter
    @Getter
    @OneToMany(mappedBy = "member")
    List<Board> boards;
}
