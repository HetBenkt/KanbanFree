package nl.bos.controllers;

import nl.bos.models.Member;
import nl.bos.services.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * Created by bosa on 21-9-2017.
 */
@RestController
@RequestMapping("/api/test")
public class MemberController {
    public static final String APPLICATION_JSON = "application/json";
    @Autowired
    private IMemberService memberService;

    @GetMapping(value = "/string", produces = APPLICATION_JSON)
    @ResponseBody ResponseEntity<String> getString() {
        return new ResponseEntity<String>("{  \"response\" : \"your string value\" }", HttpStatus.OK);
    }

    @GetMapping(value = "/map", produces = APPLICATION_JSON)
    @ResponseBody ResponseEntity<HashMap> getMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("key", "value");
        map.put("foo", "bar");
        map.put("aa", "bb");
        return new ResponseEntity<HashMap>(map, HttpStatus.OK);
    }

    @GetMapping(value = "/member", produces = APPLICATION_JSON)
    @ResponseBody ResponseEntity<Member> getMember() {
        Member member = new Member("Test", "123", "test@123.org");
        return new ResponseEntity<Member>(member, HttpStatus.OK);
    }

    @GetMapping(value = "/service", produces = APPLICATION_JSON)
    @ResponseBody ResponseEntity<List<Member>> getSpecialMember() {
        List<Member> members = memberService.getMySpecialMember();
        return new ResponseEntity<List<Member>>(members, HttpStatus.OK);
    }
}
