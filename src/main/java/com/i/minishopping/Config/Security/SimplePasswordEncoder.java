package com.i.minishopping.Config.Security;

import org.springframework.security.crypto.password.PasswordEncoder;

public class SimplePasswordEncoder implements PasswordEncoder {

    @Override
// 암호화한 문자열을 리턴해준다. DB에 넣기 전에 활용
    public String encode(CharSequence rawPassword) {
// rawPassword = 사용자가 입력한 비밀번호
        return rawPassword.toString();
    }

    @Override
// UserDetails에서 넣어준 password와 DB에 있는 password를 비교한다.
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return false;
    }
}
