# Spring-Boot Project Clone Coding

본 프로젝트는 
'스프링 부트와 AWS로 혼자 구현하는 웹 서비스, 이동욱, 프리렉'
내용의 clone coding입니다

---------------- 

### 학습 내용
- Spring Boot & Gralde 기반의 환경 구성
- JUnit을 통한 단위 테스트 코드 작성
- JPA를 사용한 CRUD 구현
- mustache를 사용한 template 작성
- Spring Security & OAuth2를 사용한 google, naver 로그인 기능 구현
- AWS EC2 Instance 생성 및 설정
- AWS RDS 세팅 및 EC2 연동
- Github Action, AWS S3, AWS CodeDeploy를 사용한 CI/CD 구축
- nginx를 사용한 무중단 배포 환경 구축

<br/>


### Project 구조

```
springboot_intro
|   .gitignore
|   appspec.yml
|   build.gradle
|   gradlew
|   gradlew.bat
|   README.md
|   settings.gradle
|  
+---.github
|   \---workflows
|           deploy.yml
|
+---scripts
|       health.sh
|       profile.sh
|       start.sh
|       stop.sh
|       switch.sh
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
