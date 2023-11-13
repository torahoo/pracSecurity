package com.pracsecurity.repository;


import com.pracsecurity.config.SecurityConfig;
import com.pracsecurity.domain.Member;
import com.pracsecurity.domain.Role;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.*;

@Slf4j
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void 사용자_등록 () {
        //given
        Member member01 = new Member("admin",
                "admin",
                Role.ROLE_ADMIN,
                true, "admin 부서");
        Member member02 = new Member("manager",
                "manager",
                Role.ROLE_MANAGER,
                true, "manager 부서");
        Member member03 = new Member("member",
                "member",
                Role.ROLE_MEMBER,
                true, "member 부서");

        log.info("member01 password = " + member01.getPassword());

        //when
        Member save01 = memberRepository.save(member01);
        Member save02 = memberRepository.save(member02);
        Member save03 = memberRepository.save(member03);
        //then
        assertThat(save01.getId()).isEqualTo(member01.getId());
        assertThat(save02.getId()).isEqualTo(member02.getId());
        assertThat(save03.getId()).isEqualTo(member03.getId());

    }

    @Test
    public void 사용자_등록_PasswordEncoder () {
        //given
        Member member01 = new Member("admin",
                passwordEncoder.encode("admin"),
                Role.ROLE_ADMIN,
                true, "admin 부서");
        Member member02 = new Member("manager",
                passwordEncoder.encode("manager"),
                Role.ROLE_MANAGER,
                true, "manager 부서");
        Member member03 = new Member("member",
                passwordEncoder.encode("member"),
                Role.ROLE_MEMBER,
                true, "member 부서");

        System.out.println("member01 password = "+member01.getPassword());
        //when
        Member save01 = memberRepository.save(member01);
        Member save02 = memberRepository.save(member02);
        Member save03 = memberRepository.save(member03);
        //then
        assertThat(save01.getId()).isEqualTo(member01.getId());
        assertThat(save02.getId()).isEqualTo(member02.getId());
        assertThat(save03.getId()).isEqualTo(member03.getId());
    }
}
