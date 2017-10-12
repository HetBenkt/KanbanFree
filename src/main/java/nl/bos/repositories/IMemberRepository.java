package nl.bos.repositories;

import nl.bos.models.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by bosa on 21-9-2017.
 */
@RepositoryRestResource
public interface IMemberRepository extends CrudRepository<Member, Long> {
    List<Member> findByLastNameIgnoreCase(@Param("lastName") String lastName);
    Member findByNickName(@Param("nickName") String nickName);
    List<Member> findAll();
}