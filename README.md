# Spring-Boot Project Clone Coding

본 프로젝트는 
'스프링 부트와 AWS로 혼자 구현하는 웹 서비스, 이동욱, 프리렉'
의 내용의 clone coding입니다.

## 환경 구성  

gradle 기반의 spring-boot 프로젝트 세팅
- Java 8
- Spring boot 2.1.7.RELEASE
- gradle-4.10.2-all

## 테스트 코드 작성  

- Junit을 통한 단위 테스트 코드 작성
- lombok 적용

## 게시글 CRUD 구현

- Spring data JPA를 사용한 CRUD 구현
- JPA Auditing을 사용한 time log 자동화

## Template  

- mustache template을 사용한 화면 구현

## 로그인 기능 개발
- Spring Security & Oauth2를 활용한 google, naver 로그인 기능 구현
- 권한 설정을 통한 access control
- HandlerMethodArgumentResolver를 사용, Annotation 기반의 Session Check
- Session을 DB에 올려서 다중 WAS 환경에서도 동작
- Mock User를 통한 테스트 환경 구성