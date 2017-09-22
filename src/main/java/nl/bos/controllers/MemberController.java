package nl.bos.controllers;

import nl.bos.models.Member;
import nl.bos.services.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by bosa on 21-9-2017.
 */
@RestController
@RequestMapping("/api/members")
public class MemberController {
    @Autowired
    private IMemberService memberService;

    @GetMapping("/{id}")
    Member getMemberById(@PathVariable("id") final long id) {
        return memberService.findById(id);
    }

    @GetMapping("/q")
    List<Member> getMemberByLastName(@RequestParam("lastName") final String lastName) {
        return memberService.findByLastName(lastName);
    }

    @GetMapping("/")
    List<Member> getAllMembers() {
        return memberService.findAll();
    }

    @PostMapping("/")
    Member addNewMember(@RequestBody Member member) {return memberService.save(member.getFirstName(), member.getLastName(), member.getMailAddress()); }

    @DeleteMapping("/{id}")
    Member deleteMember(@PathVariable("id") final long id) {
        Member member = memberService.findById(id);
        if(member != null)
            memberService.deleteById(id);
        return member;
    }
}
