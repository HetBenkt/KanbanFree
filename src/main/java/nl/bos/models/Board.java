package nl.bos.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

/**
 * Created by bosa on 21-9-2017.
 */
@Data
@Entity
@Table(name = "BOARDS")
public class Board {
    public Board() {
    }

    public Board(String name, Member member) {
        this.name = name;
        this.member = member;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "NAME")
    @NotEmpty
    private String name;

    @OneToOne
    private Member member;
}
