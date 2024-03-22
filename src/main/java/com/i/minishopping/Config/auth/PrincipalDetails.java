package com.i.minishopping.Config.auth;


import com.i.minishopping.Domains.User.User_account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class PrincipalDetails implements UserDetails {
// Security가 주소 요청이 오면 낚아채서 로그인을 진행시킨다.
// 로그인을 진행이 완료가 되면 시큐리티 session을 만들어준다. (Security ContextHolder)
// 오브젝트 => Authentication 타입 객체

    private User_account user;

    public PrincipalDetails(User_account user){
        this.user = user;
    }
    @Override
    //해당 유저의 권한을 return함
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collet = new ArrayList<>();
        collet.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getRole().toString();
            }
        });
        return collet;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    //비밀번호가 잠겼니
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    //비밀번호가 너무 오래됐는지
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    //계정이 활성화 되어있니
    public boolean isEnabled() {
        return true;
    }
}
