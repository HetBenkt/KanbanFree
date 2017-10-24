package nl.bos.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by bosa on 21-9-2017.
 */
@Entity
@Table(name = "CARDS")
public class Card {
    public Card() {
    }

    public Card(String title, Member member, Board board) {
        this.title = title;
        this.member = member;
        this.board = board;
    }

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Setter
    @Getter
    @Column(name = "TITLE")
    @NotEmpty
    private String title;

    @Setter
    @Getter
    @OneToOne
    private Member member;

    @Setter
    @Getter
    @OneToOne
    private Board board;

}
