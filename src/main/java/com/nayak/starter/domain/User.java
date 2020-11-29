package com.nayak.starter.domain;

import java.time.Instant;
import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Builder;
import lombok.Getter;

import com.nayak.starter.domain.common.CommonField;

@Table
@Getter
public class User extends CommonField implements UserDetails {

    @Id
    private Long id;
    private final String email;
    private final String password;
    private final String name;
    private final String role;

    @Builder
    @PersistenceConstructor
    public User(Instant createAt, Instant modifyAt, boolean isUsed, String email, String password, String name, String role) {
        super(createAt, modifyAt, isUsed);
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
