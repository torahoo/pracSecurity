23-11-10
스프링 시큐리티를 연습하며 작성한 노트

참고 자료 url : https://www.youtube.com/watch?v=ry2pRoAnrIc

index 완성 후 application을 실행시키기 위해 log level을 변셩하여 콘솔에 비밀번호가 나오게끔 한다.
 - 로그인 ID : user
 - Password : 콘솔에 나옴
password는 매번 부팅때마다 다름

Spring Security Customizing
시큐리티를 커스터마이징하여 사용한다.

ERROR 사항 정리

[23-11-10]
lombok 설정 오류
 - sl4j 어노테이션 오류가 생김
   - 인텔리 자체 해결방법 lombok 새로고침 밑 다른 클래스 빌드 추가로 해결
 - Test 클래스
   - MySQL을 연결했기 때문에 H2와는 달리
     @DataJpaTest
     @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
     를 넣어줘야 Test코드가 정상 작동한다.

[23-11-13]
PasswordEncoder 에러
 - UnsatisfiedDependencyException
   - @Autowired 동일한 타입의 Bean객체가 2개 이상일때 injection of autiwired dependencies failed 에러 
   - Test가 돌아갈때 @Autowired로 주입된 객체 중 PasswordEncoder가 에러를 발생함
   - 해결 법 : 순환참조 오류
   - spring:
     main:
     allow-circular-references: true
   - 스프링 부트 2.7.XX 버전 부터는 순환참조를 위해 위의 yml 설정을 넣어야 한다.
   - 전에 했던 프로젝트 처럼 mysql test전용
     @DataJpaTest
     @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
     을 쓸 수 없다. bean create 에러가 발생한다.

 - login페이지에서 값을 보내줄 때 username값 안 넘어옴
   - UserDetailServiceImpl 에서 값을 처리하는데 이때 UserDetailService 에 선언된 username 이름과 
     login.html 폼 데이터로 보내주는 값이 동일하지 않으면 서로 인식되지 않음.
   - password 또한 동일