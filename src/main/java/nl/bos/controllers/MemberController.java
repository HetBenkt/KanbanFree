package nl.bos.controllers;

import nl.bos.models.Member;
import nl.bos.services.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * Created by bosa on 21-9-2017.
 */
@RestController
@RequestMapping("/api/test")
public class MemberController {
    @Autowired
    private IMemberService memberService;

    @GetMapping(value = "/string", produces = "application/json")
    @ResponseBody ResponseEntity<String> getString() {
        return new ResponseEntity<String>("{  \"response\" : \"your string value\" }", HttpStatus.OK);
    }

    @GetMapping(value = "/map", produces = "application/json")
    @ResponseBody ResponseEntity<HashMap> getMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("key", "value");
        map.put("foo", "bar");
        map.put("aa", "bb");
        return new ResponseEntity<HashMap>(map, HttpStatus.OK);
    }

    @GetMapping(value = "/member", produces = "application/json")
    @ResponseBody ResponseEntity<Member> getMember() {
        Member member = new Member("Test", "123", "test@123.org");
        return new ResponseEntity<Member>(member, HttpStatus.OK);
    }

    @GetMapping(value = "/service", produces = "application/json")
    @ResponseBody ResponseEntity<Member> getSpecialMember() {
        Member member = memberService.getMySpecialMember();
        return new ResponseEntity<Member>(member, HttpStatus.OK);
    }

}
