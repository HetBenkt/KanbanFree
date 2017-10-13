package nl.bos.models;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by bosa on 21-9-2017.
 */
@Data
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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "TITLE")
    @NotEmpty
    private String title;

    @OneToOne
    private Member member;

    @OneToOne
    private Board board;

}
