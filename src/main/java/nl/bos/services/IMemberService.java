package nl.bos.services;

import nl.bos.models.Member;

import java.util.List;

/**
 * Created by bosa on 21-9-2017.
 */
public interface IMemberService {
    Member findById(long id);
    List<Member> findByLastName(String lastName);
    List<Member> findAll();
    Member save(String firstName, String lastName, String mailAddress);
    void deleteById(long id);
}
