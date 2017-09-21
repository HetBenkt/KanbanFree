package nl.bos.services;

import nl.bos.models.Member;
import nl.bos.repositories.IMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by bosa on 21-9-2017.
 */
public class MemberServiceImpl implements IMemberService {

    @Autowired
    private IMemberRepository memberRepository;

    @Override
    public Member findById(long id) {
        return memberRepository.findOne(id);
    }

    @Override
    public List<Member> findByLastName(String lastName) {
        return memberRepository.findByLastName(lastName);
    }
}
