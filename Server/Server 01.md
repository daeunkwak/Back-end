# Server 01

## ๐ก ์๋ฒ ์๋์๋ฆฌ

**Apache** : ์น ์๋ฒ

**Php** : ๋ฐฑ์๋ ํ๋ก๊ทธ๋๋ฐ ์ธ์ด

**Mysql** : ๋ฐ์ดํฐ๋ฒ ์ด์ค ๊ด๋ฆฌ ์์คํ

![https://user-images.githubusercontent.com/77181984/126592612-b178a174-bbd6-4815-9816-2c5477c49019.png](https://user-images.githubusercontent.com/77181984/126592612-b178a174-bbd6-4815-9816-2c5477c49019.png)

1. ์๋์ด ํ์๋น์๊ฒ ์ฃผ๋ฌธ
โ ํด๋ผ์ด์ธํธ์ธก์ ์ฌ์ฉ์๊ฐ ์ํ๋ ์ ๋ณด๋ฅผ apache์ ์์ฒญ
2. ํ์๋น์ด ์ฃผ๋ฐฉ์ฅ์๊ฒ ์ ๋ฌํจ
โ apache๊ฐ php์๊ฒ ํด๋น์ ๋ณด๋ฅผ ์์ฒญ
3. ์ฃผ๋ฐฉ์ฅ์ด ๋์ฅ๊ณ ์์ ์ฌ๋ฃ๋ฅผ ๊ฐ์ ธ์์ ์๋ฆฌํจ
โ mysql์ ํตํด ๋ฐ์ดํฐ๋ฅผ ๊ฐ์ ธ์์ php์ฝ๋๋ฅผ htmlํํ๋ก ๋ณํํจ
4. ์์ฑ๋ ์๋ฆฌ๋ฅผ ํ์๋น์ ํตํด ์๋์๊ฒ ์ ๋ฌํจ
โ ํด๋น html์ apache์ ์ ์กํ๊ณ , ํด๋ผ์ด์ธํธ์๊ฒ ์ ๋ฌ

Apache, Php, Mysql ์ด์ธ์๋ ๋ง์ ํ๋ก๊ทธ๋จ๋ค์ ์ฌ์ฉํ  ์ ์๋ค.

**Server Program**  : `Apache`, `ngingx`

**Backend Language**  : `PHP`, `Django`, `Nodejs`, `Java`

**DBMS**  : `mySQL`, `Oracle`, `NoSQL`

## ๐ก Web Server / Web Application Server(WAS)

**์น ์๋ฒ**

- ์ ์ ์ธ ์ปจํ์ธ ๋ฅผ ์ ๊ณตํ๋ ์๋ฒ โ ํญ์ ๋์ผํ ํ์ด์ง๋ฅผ ๋ฐํํจ
   ex) html, css, js
- ํด๋ผ์ด์ธํธ์ ์ํตํ๋ ์ญํ ์ ๋ด๋น
- `Apache`, `Nginx`

**WAS**

- ๋์ ์ธ ์ปจํ์ธ ๋ฅผ ์ ๊ณตํ๋ ์๋ฒ โ ๋ด์ฉ์ ๋ง๋ ๋์  ๋ด์ฉ๋ค์ ๋ฐํํจ
   ex) DB์กฐํ, ์๋ฌด๋ฅผ ์ฒ๋ฆฌํ๋ ๋ก์ง ์ํ
- `Tomcat`

**WAS๊ฐ ์กด์ฌํ๋ ์ด์ ?**

์น ์๋ฒ๋ง์ ์ด์ฉํ๋ค๋ฉด, ์ฌ์ฉ์์ ์์ฒญ์ ๋ํ ๊ฒฐ๊ณผ๊ฐ์ ๋ชจ๋ ๋ฏธ๋ฆฌ ๋ง๋ค์ด๋๊ณ  ์๋น์ค๋ฅผ ํด์ผํ์ง๋ง ๊ทธ๋ฌ๊ธฐ์ ์์์ด ์ ๋์ ์ผ๋ก ๋ถ์กฑํ๋ค.

โ WAS๋ฅผ ํตํด ์์ฒญ์ ๋ง๋ ๋ฐ์ดํฐ๋ฅผ DB์์ ๊ฐ์ ธ์ ๋ก์ง์ ๋ง๊ฒ ๊ทธ๋๊ทธ๋ ๊ฒฐ๊ณผ๋ฅผ ๋ง๋ค์ด์ ์ ๊ณตํจ์ผ๋ก์จ ์์์ ํจ์จ์ ์ผ๋ก ์ฌ์ฉํ  ์ ์๋ค.

์ฐธ๊ณ  : [https://gmlwjd9405.github.io/2018/10/27/webserver-vs-was.html](https://gmlwjd9405.github.io/2018/10/27/webserver-vs-was.html)