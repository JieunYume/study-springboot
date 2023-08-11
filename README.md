## 상품, 주문, 사용자 등의 엔터티와 그들 사이의 관계를 정의 ERD 설계

<img src = "https://github.com/ApptiveDev/study-springboot/assets/64734115/1dba8972-76cb-4ef7-b5af-9ce6ba671f69" width="600" height="370">

## PK

primary kay로 테이블 행의 여러 정보들 중 행을 식별할 수 있어야 하기 때문에 비어있으면 안되고
중복 되어도 안된다. 빠르게 식별해야하기 때문에 간단한 정보일 수록 좋다

## KF

* foreign key로 외부 식별자 키이다 테이블간의 관계가 어떠한지 체크할수있다.
* 두 테이블 간의 종속이 필요한 관계이면 그 접점이 되는 칼럼을 FK로 지정하여 서로 참조할 수 있도록 관계를 맺어준다.
* KF로 정의돈 테이블이 자식 테이블이고 참조되는 테이블을 부모 테이블이라고 한다.

## 관계 유형의 종류

* 1대1: 테이블 A의 로우와 테이블 B의 로우가 일대일 매칭되는 관계
* 1대N : 테이블 A의 로우가 테이블 B의 여러 로우와 연결이 되는 관계 (테이블 A의 PK와 테이블 B의 FK 여러개가 매칭되는 것이다.)
* N대M : 테이블 A의 여러 로우와 테이블 B의 여러 로우가 연결이 되는 관계 (ex) 한 작가는 여러개의 책을 쓸수 있고 한 책에도 작가는 여러명이 될 수가 있다.)

## ERD

Entity Relationship Diagram로 데이터베이스 구조를 한눈에 알아보기 위해서 쓰이는 것이다.
ERD의 핵심은Entity, relationship, Attribute 이다.
* Entity = 객체 테이블이다
* Relationship = Entity간의 관계이다
* Attribute = Entity를 구성하고 있는 구성 요소이다.

#러프한 ERD
*키 속성 - 타원에 밑줄
<img src = "https://github.com/ApptiveDev/study-springboot/assets/64734115/be0a3c4f-4685-4ff1-811e-f558b4e62d17" width="600" height="370">

1. 영화는 제목, 발매년원 등의 속성이 필요하다.
2. 영화는 장르로 구분할 수 있다.
3. 영화는 감독으로 구분할 수 있다.
4. 영화는 배우로 구분할 수 있다.
5. 감독, 배우, 장르로 구분을 하였지만 왜 발매년원로는 따로 속성을 만들지 않을까?
-> 엔터티는 반드시 속성을 가져야 하는데 발매년월은 가질 속성이 없다.

