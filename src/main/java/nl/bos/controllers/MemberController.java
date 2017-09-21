package nl.bos.controllers;

import nl.bos.models.Member;
import nl.bos.services.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bosa on 21-9-2017.
 */
@RepositoryRestController
@RequestMapping("/api")
public class MemberController {
    @Autowired
    IMemberService memberService;

    @GetMapping("/member/{id}")
    Member getMember(@PathVariable("id") final long id) {
        return memberService.findById(id);
    }

    @RequestMapping("/")
    String defaultMapping() {
        return "Default mapping";
    }
}
