package com.pracsecurity.config;

import com.pracsecurity.domain.Member;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class SecurityUser extends User {

    private Member member;

    public SecurityUser (Member member) {
        super(member.getId(), member.getPassword(), AuthorityUtils.createAuthorityList(member.getRole().toString()));
        this.member = member;
    }

}
