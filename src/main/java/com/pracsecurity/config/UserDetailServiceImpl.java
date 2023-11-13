package com.pracsecurity.config;

import com.pracsecurity.domain.Member;
import com.pracsecurity.repository.MemberRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Log4j2
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> op = memberRepository.findById(username);
        log.info("username="+username);
        Member member = op.orElseThrow(() -> new UsernameNotFoundException("사용자 없음"));
        return new SecurityUser(member);
    }

}
