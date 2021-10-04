# 리눅스 명령어 정리

### 💡  Fundamental Concepts of Linux

**Kernel (커널) : The Core of Operating System** 

- OS (운영체제)는 핵심적인 부분을 담당하는 커널과 여러 다른 프로그램들(쉘, GCC, 패키지 등)로 이루어진다.
- linking, unlinking을 왔다갔다 하는 동적 소프트웨어는 주로 커널모드에서 실행된다.

**Shell (쉘) : 명령어 해석기**

- 명령들을 읽어들이고 인터프리터에 전달한다.
- 리눅스에서는 GNU라는 쉘을 사용한다.

**Programs (프로그램) : 살아움직이는 객체**

- 어떻게 수행되는지에 대한 인스트럭션들의 집합이다.
- 소스코드와 바이너리(machine language) 형태로 나뉜다.

**Processes (프로세스)** 

- 프로그램 실행 객체이다.
- 프로세스마다 할당된 가상 메모리가 있다.

### 💡  How to use commands in Linux

**File related command**

- create → `vi`, `gcc`, `mknod`
- copy/move → `cp`, `mv`, `ln`
- delete → `rm`
- listing → `ls`  (ls . → 현재 디렉토리 / ls .. → 상위 디렉토리)
- file content view → `cat`, `more`, less, head, tail, `objdump`
- redirection → >

**Directory**

- home directory, root directory, current directory
- relative path (상대경로) → 현재위치부터 찾아감
absolute path (절대경로) → root부터 찾아감

**Directory related command**

- create → `mkdir`
- change → `cd`
- delete → `rmdir`
- current position → `pwd`

**Process related command**

- `ps` → 현재 실행중인 process 보여줌
↔ 로그인 된 터미널, processID, 수행시간
- `cat` → 파일내용을 처음부터 끝까지 모두 보여줌
- `more` → 파일내용을 윈도우 크기에 맞추어서 보여줌 (enter → 다음 페이지)
- `gcc` → (highlevel → assembly → 재배치가능 → 수행가능 파일)로 컴파일
- `./a.out` → 현재 디렉토리에서 a.out을 실행시킴
- `&` → background로 수행시킴
- `kill -9 9271` → 9271 프로세스를 명시적으로 죽임
- pipe ( | ) → | 앞의 수행결과가 | 뒤의 명령어의 입력으로 전달됨
`ls -l | sort -k5n` → 5번째 항목을 기준으로 정렬하여 출력하라.
- `grep` → 특정 키워드가 파일 어디에 있는지 출력해줌
- `objdump` → binary형태를 보기쉽게 분석해줌