package com.callor.todo.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.callor.todo.model.UserVO;

@Service("authenticationProvider")
public class AuthenticationProviderImpl implements AuthenticationProvider{

	@Qualifier("userDetailsService")
	@Autowired
	private UserDetailsService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String username = (String)authentication.getPrincipal();
		String password = (String)authentication.getCredentials();
		
		UserVO user = (UserVO)userService.loadUserByUsername(username);
		
		
		// 입력된 비밀번호와 DB 로 부터 SELECT 한 비밀번호를
		// PasswordEncoder 를 사용하여 비교
		if(passwordEncoder.matches(password,user.getPassword()) == false) {
			// Password 가 일치하지 않으면
			// Exception 을 발생시켜 Security 에게 알린다
			throw new BadCredentialsException("비밀번호가 잘못되었습니다");
			
		}
		
		if(user.isEnabled() == false) {
			throw new BadCredentialsException(username + "은 회원가입절차가 완료되지 않음");
		}
		
		// 정상적으로 사용자가 로그인하면
		// 인증 token 발행
		UsernamePasswordAuthenticationToken token = 
				new UsernamePasswordAuthenticationToken(user, password, user.getAuthorities());
		
		return token;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
