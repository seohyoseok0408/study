package com.cos.blog.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@Service
public class PrincipalDetailService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	// 스프링이 로그인 요청을 가로찰 때, username, password 변수 2개 가로채는데
	// password 부분처리는 알아서 함
	// username이 DB에 있는지만 확인해주면 됨.
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User principal = userRepository.findByUsername(username)
				.orElseThrow(()->{ // Optional 타입이여서 함.
					return new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다.:"+username);
				});
		return new PrincipalDetail(principal); // 이때, 시큐리티 세션에 유저 정보가 저장 
	}
	
}
