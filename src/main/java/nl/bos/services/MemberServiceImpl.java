package nl.bos.services;

import nl.bos.models.Member;
import nl.bos.repositories.IMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bosa on 21-9-2017.
 */
@Service
public class MemberServiceImpl implements IMemberService {

    @Autowired
    private IMemberRepository memberRepository;

    @Override
    public Member findById(long id) {
        return memberRepository.findOne(id);
    }

    @Override
    public List<Member> findByLastName(String lastName) {
        return memberRepository.findByLastNameIgnoreCase(lastName);
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member save(String firstName, String lastName, String mailAddress) {
        Member member = new Member(firstName, lastName, mailAddress);
        return memberRepository.save(member);
    }

    @Override
    public void deleteById(long id) {
        memberRepository.delete(id);
    }
}
