package com.pracsecurity.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@Entity
@Table(name="member")
@NoArgsConstructor
public class Member implements Serializable {

    @Id
    private String id;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private boolean enabled;

    private String dname;

    @Builder
    public Member (String id, String password, Role role, boolean enabled, String dname) {
        this.id = id;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
        this.dname = dname;
    }

}
