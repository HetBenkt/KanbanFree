package nl.bos.repositories;

import nl.bos.models.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by bosa on 21-9-2017.
 */
public interface IMemberRepository extends CrudRepository<Member, Long> {
    List<Member> findByLastNameIgnoreCase(@Param("lastName") String lastName);
    Member findByNickName(@Param("nickName") String nickName);
    List<Member> findAll();
}