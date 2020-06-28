# Spring-Boot Project Clone Coding

본 프로젝트는 
'스프링 부트와 AWS로 혼자 구현하는 웹 서비스, 이동욱, 프리렉'
내용의 clone coding입니다.

```
springboot_intro
|   .gitignore
|   build.gradle
|   gradlew
|   gradlew.bat
|   README.md
|   settings.gradle
|           
\---src
    +---main
    |   +---java
    |   |   \---com
    |   |       \---springboot
    |   |           |   Application.java
    |   |           |   
    |   |           +---config
    |   |           |   |   JpaConfig.java
    |   |           |   |   WebConfig.java
    |   |           |   |   
    |   |           |   \---auth
    |   |           |       |   CustomOAuth2UserService.java
    |   |           |       |   LoginUser.java
    |   |           |       |   LoginUserArgumentResolver.java
    |   |           |       |   SecurityConfig.java
    |   |           |       |   
    |   |           |       \---dto
    |   |           |               OAuthAttributes.java
    |   |           |               SessionUser.java
    |   |           |               
    |   |           +---domain
    |   |           |   |   BaseTimeEntity.java
    |   |           |   |   
    |   |           |   +---posts
    |   |           |   |       Posts.java
    |   |           |   |       PostsRepository.java
    |   |           |   |       
    |   |           |   \---user
    |   |           |           Role.java
    |   |           |           User.java
    |   |           |           UserRepository.java
    |   |           |           
    |   |           +---service
    |   |           |   \---posts
    |   |           |           PostsService.java
    |   |           |           
    |   |           \---web
    |   |               |   HelloController.java
    |   |               |   IndexController.java
    |   |               |   PostsApiController.java
    |   |               |   
    |   |               \---dto
    |   |                       HelloResponseDto.java
    |   |                       PostsListResponseDto.java
    |   |                       PostsResponseDto.java
    |   |                       PostsSaveRequestDto.java
    |   |                       PostsUpdateRequestDto.java
    |   |                       
    |   \---resources
    |       |   application-oauth.properties
    |       |   application-real-db.properties
    |       |   application-real.properties
    |       |   application.properties
    |       |   
    |       +---static
    |       |   \---js
    |       |       \---app
    |       |               index.js
    |       |               
    |       \---templates
    |           |   index.mustache
    |           |   posts-save.mustache
    |           |   posts-update.mustache
    |           |   
    |           \---layout
    |                   footer.mustache
    |                   header.mustache
    |                   
    \---test
        +---java
        |   \---com
        |       \---springboot
        |           +---domain
        |           |   \---posts
        |           |           PostsRepositoryTest.java
        |           |           
        |           \---web
        |               |   HelloControllerTest.java
        |               |   IndexControllerTest.java
        |               |   PostsApiControllerTest.java
        |               |   
        |               \---dto
        |                       HelloResponseDtoTest.java
        |                       
        \---resources
```

---------------- 

### 환경 구성  

gradle 기반의 spring-boot 프로젝트 세팅
- Java 8
- Spring boot 2.1.7.RELEASE
- gradle-4.10.2-all

<br/>

### 테스트 코드 작성  

- Junit을 통한 단위 테스트 코드 작성
- lombok 적용

<br/>

### 게시글 CRUD 구현

- Spring data JPA를 사용한 CRUD 구현
- JPA Auditing을 사용한 time log 자동화

<br/>

### Template  

- mustache template을 사용한 화면 구현

<br/>

### 로그인 기능 개발
- Spring Security & Oauth2를 활용한 google, naver 로그인 기능 구현
- 권한 설정을 통한 access control
- HandlerMethodArgumentResolver를 사용, Annotation 기반의 Session Check
- Session을 DB에 올려서 다중 WAS 환경에서도 동작
- Mock User를 통한 테스트 환경 구성

<br/>

## CI/CD의 구현
- AWS EC2 Instance 생성 및 설정
- AWS RDS 세팅 및 EC2 연동
- 배포 스크립트 작성
- 