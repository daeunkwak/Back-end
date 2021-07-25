# Server 01

## 💡 서버 작동원리

**Apache** : 웹 서버

**Php** : 백엔드 프로그래밍 언어

**Mysql** : 데이터베이스 관리 시스템

![https://user-images.githubusercontent.com/77181984/126592612-b178a174-bbd6-4815-9816-2c5477c49019.png](https://user-images.githubusercontent.com/77181984/126592612-b178a174-bbd6-4815-9816-2c5477c49019.png)

1. 손님이 홀서빙에게 주문
↔ 클라이언트측의 사용자가 원하는 정보를 apache에 요청
2. 홀서빙이 주방장에게 전달함
↔ apache가 php에게 해당정보를 요청
3. 주방장이 냉장고에서 재료를 가져와서 요리함
↔ mysql을 통해 데이터를 가져와서 php코드를 html형태로 변환함
4. 완성된 요리를 홀서빙을 통해 손님에게 전달함
↔ 해당 html을 apache에 전송하고, 클라이언트에게 전달

Apache, Php, Mysql 이외에도 많은 프로그램들을 사용할 수 있다.

**Server Program**  : `Apache`, `ngingx`

**Backend Language**  : `PHP`, `Django`, `Nodejs`, `Java`

**DBMS**  : `mySQL`, `Oracle`, `NoSQL`

## 💡 Web Server / Web Application Server(WAS)

**웹 서버**

- 정적인 컨텐츠를 제공하는 서버 → 항상 동일한 페이지를 반환함
   ex) html, css, js
- 클라이언트와 소통하는 역할을 담당
- `Apache`, `Nginx`

**WAS**

- 동적인 컨텐츠를 제공하는 서버 → 내용에 맞는 동적 내용들을 반환함
   ex) DB조회, 업무를 처리하는 로직 수행
- `Tomcat`

**WAS가 존재하는 이유?**

웹 서버만을 이용한다면, 사용자의 요청에 대한 결과값을 모두 미리 만들어놓고 서비스를 해야하지만 그러기엔 자원이 절대적으로 부족하다.

→ WAS를 통해 요청에 맞는 데이터를 DB에서 가져와 로직에 맞게 그때그때 결과를 만들어서 제공함으로써 자원을 효율적으로 사용할 수 있다.

참고 : [https://gmlwjd9405.github.io/2018/10/27/webserver-vs-was.html](https://gmlwjd9405.github.io/2018/10/27/webserver-vs-was.html)