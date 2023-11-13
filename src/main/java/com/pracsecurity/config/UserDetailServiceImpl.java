package com.pracsecurity.config;

import com.pracsecurity.domain.Member;
import com.pracsecurity.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> op = memberRepository.findById(username);
        if(op.isPresent()){
            throw new UsernameNotFoundException("사용자 없음");
        }
        Member member = op.get();
        return new SecurityUser(member);
    }

}
