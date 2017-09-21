package nl.bos.repositories;

import nl.bos.models.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by bosa on 21-9-2017.
 */
@RepositoryRestResource
public interface IMemberRepository extends CrudRepository<Member, Long> {
}
