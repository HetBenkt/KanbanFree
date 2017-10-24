package nl.bos.models;

import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

/**
 * Created by bosa on 21-9-2017.
 */
@Entity
@Table(name = "BOARDS")
public class Board {
    public Board() {
    }

    public Board(String name, Member member) {
        this.name = name;
        this.member = member;
    }

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Setter
    @Getter
    @Column(name = "NAME")
    @NotEmpty
    private String name;

    @Setter
    @Getter
    @OneToOne
    private Member member;

    @Setter
    @Getter
    @OneToMany(mappedBy = "board")
    List<Card> cards;
}
