package nl.bos.config;

import nl.bos.components.MyAccessDeniedHandler;
import nl.bos.components.MyAuthenticationSuccessHandler;
import nl.bos.models.Member;
import nl.bos.repositories.IMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by bosa on 27-9-2017.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyAccessDeniedHandler accessDeniedHandler;
    @Autowired
    private IMemberRepository memberRepository;
    @Autowired
    private MyAuthenticationSuccessHandler authenticationSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/app", "/app/features", "/app/pricing", "/app/press", "/app/login", "/app/signup", "/webjars/**", "/app/css/**", "/app/js/**", "/login", "/api/test/**").permitAll()
                .antMatchers("/app/admin/**", "/h2", "/members/**", "/boards/**", "/profile/**").hasAnyRole("ADMIN")
                .antMatchers("/app/boards/**").hasAnyRole("USER")
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/app/login").permitAll().successHandler(authenticationSuccessHandler)
                .and().logout().permitAll()
                .and().exceptionHandling().accessDeniedHandler(accessDeniedHandler);

        http.headers().frameOptions().disable();
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(inMemoryUserDetailsManager());
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        List<Member> members = memberRepository.findAll();
        Collection<UserDetails> users = new ArrayList();
        for (Member member:members) {
            final Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + member.getRole().toUpperCase()));
            UserDetails user = new User(member.getNickName(), member.getPassword(),grantedAuthorities);
            users.add(user);
        }
        return new InMemoryUserDetailsManager(users);
    }

}
