package nl.bos.models;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by bosa on 21-9-2017.
 */
@Data
@Entity
@Table(name = "MEMBERS")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "MAIL_ADDRESS")
    private String mailAddress;
}
