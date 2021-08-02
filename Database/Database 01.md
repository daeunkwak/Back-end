# Database 01

## Database & SQL (Structured Query Language)

`데이터베이스`는 `엑셀`과 비슷한 구조이다. 엑셀에서의 페이지 단위인 sheet가 데이터베이스의 table과 대응되고, sheet안의 데이터들이 각 table안의 데이터들이 된다.

이러한 데이터베이스는 `SQL`이라는 언어로 표현이 되고, SQL은 크게 세가지 종류의 명령어로 나눌 수 있다.

### 💡 1. DDL (Data Definition Language)

→ 데이터베이스의 **테이블**들을 정의하는 명령어이다.

- CREATE : 테이블 / 데이터베이스 생성
- DROP : 테이블 / 데이터베이스 삭제
- ALTER : 테이블 수정

### 💡 2. DML (Data Manipulation Language)

→ 테이블의 **데이터**들을 조작하는 명령어이다.

- SELECT : 데이터 조회
- UPDATE : 데이터 수정
- INSERT : 데이터 생성
- DELETE : 데이터 삭제

### 💡 3. DCL (Data Control Language)

→ 데이터베이스에 접근하거나 특정 사용자의 권한을 관리한다.

→ 데이터의 보안, 무결성을 정의하는데 사용된다.

- TRANSACTION → COMMIT, ROLLBACK : 트랜잭션이 성공적으로 완료된 경우는 COMMIT, 중간에 에러가 나서 취소된 경우이는 ROLLBACK 사용
- GRANT : 사용자에게 특정 권한 부여
- REVOKE : 사용자에게 특정 권한 회수