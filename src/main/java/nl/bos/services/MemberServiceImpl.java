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
    public Member getMySpecialMember() {
        //return memberRepository.getMySpecialMember();
        return new Member(); //TODO Create a custom method for Spring rest Data!
    }
}
