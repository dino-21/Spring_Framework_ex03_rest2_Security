#  Spring_Framework_ex03_rest2_Security # 

# 구멍가게코딩단 - 스프링레거시 시큐리티 7장까지 # 


## 개발 환경 ##

| 항목 | 버전 |
|------|------|
| IDE | Spring Tool Suite (STS 4) |
| JDK | Java 11 |
| 빌드 도구 | Maven |
| 서버 | Tomcat 9 (내장 or 외부 사용 가능) |
| DBMS | Oracle 11g Express Edition |
| 프레임워크 | Spring 5, Spring MVC, Spring Security |
| ORM | MyBatis |
| 프론트 | JSP, JSTL, Bootstrap |
| 기타 | Lombok, log4j |



## 주요 기능 ##
| 기능 | 설명 |
|------|------|
| 로그인 인증 | Spring Security의 **Form 로그인 방식** 사용 |
| 권한 제어 | ROLE_USER, ROLE_ADMIN 등 권한별 접근 제어 |
| 댓글 기능 (REST) | 댓글 등록/조회/수정/삭제 기능을 **REST API 방식(AJAX)** 으로 구현 |
| Access Denied 처리 | 접근 거부 시 custom 접근 거부 페이지로 리다이렉트 |
| 게시판 기능 | 일반 게시글 CRUD는 JSP 기반 Form 방식 |
| CSRF 대응 | CSRF 토큰 적용 및 인터셉터 처리 포함 |

## 프로젝트 구조 ##
![36-2](https://github.com/user-attachments/assets/1a9764ec-5131-4473-a745-d9e0d37e3062)

<img width="773" height="737" alt="32" src="https://github.com/user-attachments/assets/1a80ad46-7e70-42a2-9271-dd322c35af45" />

## 페이징  ##
<img width="773" height="639" alt="image01" src="https://github.com/user-attachments/assets/ff4b8191-cdf4-484a-8d8c-f5e03681e461" />




## 화면구현 시큐리티 ##
![1](https://github.com/user-attachments/assets/d3ebec01-ef1d-4d7d-a2aa-2651a8c31a02)

![2](https://github.com/user-attachments/assets/abfa924c-6cbf-4a10-bf88-0d786554273d)
