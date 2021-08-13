# [Network] Restful API 설계하기

# 💡 1. API란?

**Application Programming Interface** 

### API 작동원리

![api그림](https://user-images.githubusercontent.com/77181984/129401732-8a0a0e2f-68ef-4b61-8b86-920e8179f81a.png)

**Route** : 외부에서 요청이 들어오면 해당 URI에 맞는 Controller로 연결
    ↔ 키오스크가 주문을 받아서 종업원에게 주문 전달

**Controller** : Route로부터 받은 데이터를 받고, Service / Provider에게 데이터를 넘겨주어 로직을 수행할 수 있도록 함, validation확인 (트랜잭션, 유효성 검사)
    ↔ 종업원은 주문이 적절한지, 누락된 사항은 없는지 확인하고 요리사에게 주문 전달

**Service / Provider** : 실제 핵심적으로 로직을 수행하는 영역 

**Dao** : 데이터베이스와 실질적으로 연결되어 있는 객체 → 쿼리 수행
    ↔ 요리사는 요리를 하고, 이 과정에서 냉장고에서 재료를 꺼냄 → 다시 주문자에게  전달  

### API의 역할

- 클라이언트와 서버간의 데이터를 주고받는 형식을 의미한다.
- `HTTP URI`를 통해 데이터를 명시하고, `메소드`(GET, POST, PUT, PATCH, DELETE)를 통해 해당 데이터를 `CRUD`(Create, Read, Update, Delete) 한다. 
→ 메소드들을 통해 HTTP와 통신한다.
    - GET : 조회
    - POST : 생성
    - PUT : 전체 수정 (테이블 전체 수정)
    - PATCH : 부분 수정 (특정 칼럼 수정)
    - DELETE : 삭제

# 💡 2. 데이터 전송 방법

클라이언트와 서버는 데이터를 `packet`형태로 담아서 전달한다. packet은 `header`와 `body`로 구성되어 있는데, 부수적인 데이터는 header, 중요한 진짜 데이터는 body에 담아 전달한다.

### **Query String**

- `key`, `value`값을 통해 전달하고 응답하는 방식
- URL 뒤에 입력 데이터를 함께 제공한다.
→ 보여져도 되는 값들을 쿼리스트링 방법으로 보낸다.

```java
http://daeunn.shop/app/users?userEmail=daeun@naver.com
```

![오늘날씨](https://user-images.githubusercontent.com/77181984/129401743-fb52ceeb-87dd-4f53-b8c4-4d18ea83adb0.png)


### **Path Variable**

- URL 뒤에 /1, /2와 같이 경로를 지정하여 요청하고 제공하는 방식
- 데이터의 위치를 특정해서 보여줘야 할 경우 사용한다.

```java
http://daeunn.shop/app/users/123
```

# 💡 3. REST API

REST API는 웹의 장점을 최대한으로 반영할 수 있는 API 설계방식으로, 이 규칙이 잘 지켜진 API를 Restful API라고 한다.

### REST API 구성

- **자원(Resource)** : URI
- **행위(Verb)** : HTTP Method

→ URI는 정보의 자원을 표현하고, 이 자원에 대한 행위는 Method를 통해 구현한다 !

### REST API 규칙

1. URI는 정보의 자원을 표현 / 자원에 대한 행위는 HTTP Method로 표현
→ 동사보다는 명사형, 복수형 사용
2. 슬래시 구분자로 계층관계를 나타냄
3. URI 마지막 문자로 슬래시 사용 X

```java
http://daeunn/shop/app/users
```

1. 하이픈(-)은 URI의 가독성을 높이는데 사용 (밑줄(_) 사용 지양)
2. URI 경로에는 되도록 소문자 사용
3. URI에 파일확장자 포함 X

```
http://daeunn/shop/app/users-daeun (O)
http://daeunn/shop/app/users_daeun (X)
```

---

참고

[https://sanghaklee.tistory.com/57](https://sanghaklee.tistory.com/57)

[https://meetup.toast.com/posts/92](https://meetup.toast.com/posts/92)