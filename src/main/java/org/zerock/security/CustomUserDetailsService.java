package org.zerock.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.MemberMapper;
import org.zerock.security.domain.CustomUser;

import lombok.extern.log4j.Log4j;

//Spring Security에서 사용자 인증 및 권한 부여를 위한 사용자 정의 서비스 구현
@Log4j
public class CustomUserDetailsService  implements UserDetailsService{
	
	@Autowired
	private MemberMapper memberMapper;  // 회원정보와 권한정보

	@Override
            //loadUserByUsername 메서드를 통해 사용자 이름을 입력, 입력받은 이름으로 DB에서 사용자 정보를 조회
            //조회된 사용자 정보를 Spring Security의 UserDetails 객체로 변환하여 반환
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.warn("Load User By Username : " + username);
		
		// 사용자 이름으로 데이터베이스에서 회원 정보를 조회
		MemberVO vo = memberMapper.read(username);
	
		log.warn("queried by member mapper: " + vo);
                       // 조회된 MemberVO를 기반으로 CustomUser 객체를 생성하여 반환 (조회 결과가 없을 경우 null 반환)
		return vo == null ? null : new CustomUser(vo);
	} 
}
