# [Study1 과제]
## 1. ERD 설계
![shoppingMallErd.png](shoppingMallErd.png)
회원과 장바구니를 일대일/일대다 중 고민됨


## 2. 키워드 정리
- PK(Primary Key)
    - 테이블의 **유일한 값**을 가지는 필드
    - **중복된 값 X**: 중복된 값을 가질 수 없음
    - **NOT NULL**
    - 후보키 중 **개발자가 선택한 키**
    - 테이블 1개당 PK 필드 1개 이상 (권장)
    - PK필드는 다른테이블의 필드에서 참조당한다
- FK(Foreign Key)
    - **다른 테이블의 PK필드와 연결**
    - FK필드명은 PK필드명과 동일하게 사용 (권장)
    - FK필드의 타입은 PK필드의 타입과 동일 (필수)
    - 참조하는 테이블에서 FK 필드를 선언 ( 1:M 관계에서 M쪽이 참조하는 테이블 )
    - 중복 , null 가능
  - ![PK, FK](https://velog.velcdn.com/images%2Fjch9537%2Fpost%2Feffa8fe7-fa6e-474f-bf9d-fc30f53b9cf8%2Fimage.png)
- 관계 유형의 종류
  - 일대일
    - 어느 엔티티 쪽에서 상대 엔티티와 반드시 단 하나의 관계를 가지는 것
    - 일부일처제 
    - ![일대일](https://velog.velcdn.com/images%2Fgillog%2Fpost%2F296d4f71-8eba-4353-bf3a-4d9b342695df%2F11.PNG)
  - 일대다
    - 한 쪽 엔티티가 관계를 맺은 엔티티 쪽의 여러 객체를 가질 수 있는 것
    - 부모와 자식 관계
    - ![일대다](https://velog.velcdn.com/images%2Fgillog%2Fpost%2F8977abf9-f56e-46b0-8764-cf6446af1daf%2F22.PNG)
  - 다대다
    - 관계를 가진 양쪽 엔티티 모두에서 1:N관계를 가지는 것
    - 학원과 학생 관계 : 한 학원에는 여러 학생이 수강, 한 학생도 여러 개의 학원을 수강할 수 있음
    - ![다대다](https://velog.velcdn.com/images%2Fgillog%2Fpost%2F33a5d121-a58d-4791-a2f7-d1243e954d21%2F33.PNG)
- ERD(Entity Relationship Diagram)
  - 존재하고 있는 것(Entity)들의 관계(Relationship)을 나타낸 도표(Diagram) => 데이터들의 관계를 나타낸 도표
  - 용도
    - 데이터 베이스 모델링
    - 소프트웨어 엔지니어링 : data flow diagram 의 기초로써 종종 사용
  - 구성
    - 개체 (Entity)
      - 단독으로 존재하는 객체
    - 속성 (Attribute)
      - 개체가 가지고 있는 속성
    - 관계 (Relationship)
  - 기호
    ![표기법](https://velog.velcdn.com/images/mong9_s/post/6407a362-71d6-4941-b9a3-62f9ac16ed44/image.PNG)