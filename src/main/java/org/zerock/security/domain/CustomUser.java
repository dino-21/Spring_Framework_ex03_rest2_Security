package org.zerock.security.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.zerock.domain.MemberVO;

public class CustomUser extends User {

	private MemberVO member;

	// 생성자 3개, 사용자 이름, 비밀번호 및 권한을 가지고 있는 생성자
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	// MemberVO 객체를 받는 생성자
	public CustomUser(MemberVO vo) {
		// MemberVO에서 파생된 사용자 이름, 비밀번호 및 권한으로 슈퍼클래스 User 생성자를 호출
		super(vo.getUserid(), vo.getUserpw(), vo.getAuthList().stream()
				.map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));
		this.member = vo; // MemberVO 객체를 CustomUser 클래스의 멤버 변수에 저장
	}
}
