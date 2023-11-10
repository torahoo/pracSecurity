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