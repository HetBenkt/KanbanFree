package nl.bos.services;

import nl.bos.models.Member;
import nl.bos.repositories.IMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bosa on 21-9-2017.
 */
@Service
public class MemberServiceImpl implements IMemberService {

    @Autowired
    private IMemberRepository memberRepository;

    @Override
    public List<Member> getMySpecialMember() {
        List<Member> result = new ArrayList<>();

        List<Member> members = memberRepository.findAll();
        for (Member member: members) {
            if(member.getMailAddress().endsWith(".nl")) {
                result.add(member);
            }
        }
        return result;
    }
}
