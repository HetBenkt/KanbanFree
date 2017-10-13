package nl.bos.repositories;

import nl.bos.models.Board;
import nl.bos.models.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by bosa on 21-9-2017.
 */
@RepositoryRestResource(exported = true)
public interface IBoardRepository extends CrudRepository<Board, Long> {
    List<Board> findByNameIgnoreCase(@Param("name") String name);
    List<Board> findAll();
}