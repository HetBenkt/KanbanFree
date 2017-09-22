package nl.bos.repositories;

import nl.bos.models.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by bosa on 21-9-2017.
 */
public interface IMemberRepository extends CrudRepository<Member, Long> {
    List<Member> findByLastNameIgnoreCase(String lastName);
    List<Member> findAll();
}