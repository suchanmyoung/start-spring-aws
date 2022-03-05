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