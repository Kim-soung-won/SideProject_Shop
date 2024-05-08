## 프로젝트 기획 의도
* JPA, SpringBoot심화에 대한 학습 내용 실습을 위한 사이드 프로젝트
* 이후 실시할 팀 프로젝트에서 팀원을 리드함에 있어 막힘이 없을 수 있도록 다양한 트러블 슈팅 경험
* 팀원들이 SpringBoot 프로젝트 간에 예시 및 참고 용으로 활용할 수 있는 가이드 제공  

<hr>

### <a href="https://github.com/Kim-soung-won/Team_Idle/tree/Readme">팀 프로젝트 Git 링크</a>  

<hr>

### 트러블 슈팅1 [JPA 동적 쿼리 작성 문제]
<a href="https://rlatmddnjs0103.tistory.com/214">작성한 블로그 링크</a>  
🚨 **문제 배경**
실습용 프로젝트에서 JPA 사용간에 동적 쿼리 작성에 어려움을 겪었다. JPA가 Select 결과를 정렬하는 과정에서 Join을 통해 가져온 Column을 기준으로 정렬을 수행하지 못하였다.
JPA는 Pageable을 통해 정렬을 수행하는데 Join을 통해 가져온 Entity에 속하지 않은 Column은 대상으로 지정이 안되었다.

⭐️ **해결 방법**

JPA와 MyBatis를 하나의 프로젝트에서 같이 사용하여서 해결하였다. Join과 다양한 정렬 조건을 함께 요구하는 조회쿼리에 대해서는 MyBatis를 사용하여 따로 select문을 작성하였다.

🤩 **해당 경험을 통해 알게된 점**

MyBatis가 갖는 장점에 대해서 느끼게 되었다. 컴파일 과정에서 Query의 유효성을 알 수 있는 기능은 놓쳤지만 비교적 빠르게 기능 구현을 해야하는 상황에서는 직관적이라서 쉽게 사용할 수 있는 것 같다. 아마 JPA의 심화과정인 QueryDSL을 사용하면 동일한 작업을 JPA로도 할 수 있다고 하는데, 추가적인 학습이 필요할 것 같다.  

<hr>

### 트러블 슈팅2 [다량의 User 조회 쿼리 발생]
<a href="https://rlatmddnjs0103.tistory.com/189">작성한 블로그 링크</a>  
🚨 **문제 배경**

쇼핑몰 특성상 사용자 정보를 요구하는 요청이 많이 존재했습니다. 그래서 매번 DB에서 User에 대한 Select 쿼리가 발생했습니다. 
 원인은 SpringSecurity를 활용한 Authentication 객체에는 다른 Entity에서 외래키로 사용되는 PK 데이터가 담기지 않았기 때문이었습니다. 그래서 객체에 담긴 데이터로 DB에서 일련번호를 가져오기 위한 작업이 요구되었습니다.

⭐️ **해결 방법**

로그인 시, 해당 로그인 유저에 대한 값 데이터를 세션에 담고 로그아웃 혹은 세션이 만료될 때까지 유지하여 사용자 정보가 요구될 때마다 DB와 통신과정 없이 세션에서 데이터를 출력한다.

🤩 **해당 경험을 통해 알게된 점**

보안, 생명 주기등을 고려해 설계를 수행하면 세션을 통해 반복되는 쿼리를 줄일 수 있다.

결과적으로 유저가 페이지에 접근해 로그인한 뒤 발생하는 상호작용에서 약 10번의 User 데이터 조회 쿼리가 줄어들 수 있었다.