## 스프링 부트와 AWS로 혼자 구현하는 웹 서비스 학습
* 일반적으로 패키지명은 웹 사이트 주소의 역순으로 한다.
* MyBatis, iBatis는 ORM이 아니다. SQL Mapper다. ORM은 객체를 매핑하는 것이고 
SQL Mapper는 쿼리를 매핑하는 것이다.
* Spring Web Layer
![](../../spring-web-layer.png)
* Web Layer 
  * 컨트롤러와 뷰 템플릿, 필터, 인터셉터 등 외부 요청과 응답에 대한 전반적인 영역
* Service Layer 
  * Controller와 Dao의 중간 영역으로 @Service나 @Transactional
* Repository Layer
  * Dao 영역 같이 DB 저장소에 접근하는 영역
* DTOs
  * 계층 간에 데이터 교환을 위한 객체
* Domain Model
  * 개발 대상을 모든 사람이 동일한 관점에서 이해할 수 있게 단순화 시킨 영역, @Entity나 VO 등이 위치
* LocalDate
  * Java8 지원, LocalDate와 LocalDateTime으로 Date 타입 개선
  * 기존의 Date 객체는 불변 객체가 아니며, Month 설계가 잘못됨

* 머스테치(Mustache)
  * 수많은 언어를 지원하는 가장 심플한 템플릿 엔진

* Spring Sequrity
  * 막강한 인증(Authentication)과 인가(Authorization) 기능을 가진 프레임워크. 인터셉터, 필터 기반의 보안 기능
구현보다 시큐리티를 통해 구현하는 것을 적극 권장하고 있다.

* 세션 저장소로 데이터베이스 사용하기
  * 톰캣 세션 이용하기
  * MySQL 같은 DB를 세션 저장소 사용하기
  * Redis, Memcached 같은 메모리 DB를 세션 저장소로 사용

