# [Design Pattern] Adapter Pattern

## ๐ก About Adapter Pattern

Adapter Pattern์ ์ธํฐํ์ด์ค์ ์ธํฐํ์ด์ค๊ฐ์ ํธํ์ฑ ๋ฌธ์ ๋ฅผ ํด๊ฒฐํด์ฃผ๋ ํจํด์ด๋ค. ์ฝ์ผํธ์ ์ฌ์ฉํ๋ ๊ทธ ์ด๋ํฐ์ ์ญํ ๊ณผ ๋์ผ!

ํธํ๋์ง ์๋ ์ธํฐํ์ด์ค๋ฅผ ์ฌ์ฉํ๋ ์ฝ๋๋ค์ Adapter Class๋ฅผ ๋ง๋ค์ด ํ์ฉํ  ์ ์๋ค.

- My existing system โ Adapter โ Vendor class
- **Object Adapter**์ **Class Adapter**๋ก ๊ตฌํ๋ฐฉ๋ฒ์ด ๋๋์ด์ง๋ค.
- ์ธํฐํ์ด์ค๊ฐ ํธํ๋์ง ์๋ ๋ฌธ์ ๊ฐ ๋ฐ์ํด๋ Adapter Pattern์ ํตํด ๊ธฐ์กด์ ์ฝ๋๋ฅผ ์์ ํ์ง ์๊ณ ๋ ๋ฌธ์ ๋ฅผ ํด๊ฒฐํ  ์ ์๋ค.

## ๐ก Adapter Pattern Structure

### **Object Adapter Pattern**

![adapter1](https://user-images.githubusercontent.com/77181984/143028269-653f660f-ddab-41a3-85fb-568dc64377ae.png)

**Client**

โ Target Interface๋ฅผ ์๊ตฌํ๋ ํด๋์ค

**Adaptee**

โ ์ ์ฉํ  ์ธ๋ถ์์คํ, ์ฝ๋

**Target Interface**

โ Adapter๊ฐ implementsํ๋ ์ธํฐํ์ด์ค

- ํด๋ผ์ด์ธํธ๋ Target Interface๋ฅผ ํตํด Adaptee๋ฅผ ์ฌ์ฉํ  ์ ์๊ฒ ๋๋ค.

**Adapter**

โ ํด๋ผ์ด์ธํธ์ Adaptee๋ฅผ ์ฐ๊ฒฐ์์ผ์ฃผ๋ Adapter

- ํด๋ผ์ด์ธํธ์ ์์ฒญ์ Adaptee๊ฐ ์ดํดํ  ์ ์๋ ๋ฐฉ๋ฒ์ผ๋ก ์ ๋ฌ
- Adaptee ํด๋์ค๋ฅผ Target Interface์ ๋ง์ถ์ด ์ ๊ณต

### **Class Adapter Pattern**

![adapter2](https://user-images.githubusercontent.com/77181984/143028287-e5de8789-fbaf-49bd-aa08-1ae527d558db.png)

ํด๋์ค ์ด๋ํฐ๋ ๋ค์ค ์์์ ์ง์ํ์ฌ Adapter๊ฐ Target ํด๋์ค์ Adaptee ํด๋์ค๋ฅผ ๋ ๋ค ์์ํ๋ค.

## ๐ก Practice Adapter Pattern

### **Object Adapter Pattern**

![adapter3](https://user-images.githubusercontent.com/77181984/143028303-4ca1051c-4621-43bf-b632-7ec3f8e8010c.png)

- Duck

```java
package Adapter;

public interface Duck {
    public void quack();
    public void fly();
}
```

- Turkey

```java
package Adapter;

public interface Turkey {
    public void gobble();
    public void fly();
}
```

- TurkeyAdapter

Turkey๊ฐ์ฒด๋ฅผ ์ฌ์ฉํ์ฌ Turkey์ gooble๋ฉ์๋๋ฅผ Duck์ quack๋ฉ์๋๋ก ๋ง์ถ์ด์ค๋ค.

```java
package Adapter;

public class TurkeyAdapter implements Duck{
    Turkey turkey;

    public TurkeyAdapter(Turkey turkey){
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        for(int i = 0; i < 5; i++){
            turkey.fly();
        }
    }
}
```

- Main

TurkeyAdapter๋ฅผ ํตํด Duck interface๊ฐ์ฒด๋ก Turkey๋ฅผ ์์ฑํด์ค๋ค.

```java
public class Main {
    public static void main(String[] args) {
        Duck turkey = new TurkeyAdapter(new Turkey());

        System.out.println("I am a duck");
        duck.quack();
        duck.fly();

        System.out.println("I am a turkey");
        turkey.quack();
        turkey.fly();
    }
}
```

### Class **Adapter Pattern**

![adapter4](https://user-images.githubusercontent.com/77181984/143028311-56b9293c-23bd-4107-90ea-2b068058fcf7.png)

- WildTurkeyAdapter

Duck ์ธํฐํ์ด์ค์ WildTurkey ํด๋์ค๋ฅผ ๋ชจ๋ ์์๋ฐ๋ WildTurkeyAdapter

```java
package Adapter;

public class WildTurkeyAdapter extends WildTurkey implements Duck{
    @Override
    public void quack() {
        gobble();
    }

    @Override
    public void fly() {
        for (int i = 0; i < 5; i++){
            super.fly();
        }
    }
}
```

- Main

```java
package Adapter;

public class Main {
    public static void main(String[] args) {
        Duck turkey = new WildTurkeyAdapter();

        System.out.println("I am a duck");
        duck.quack();
        duck.fly();

        System.out.println("I am a turkey");
        turkey.quack();
        turkey.fly();
    }
}
```

**Object Adapter**๋ ์์์ด ์๋ ๊ตฌ์ฑ์ ์ฌ์ฉํ๊ธฐ ๋๋ฌธ์ Adaptee์ ๋ํ ๋ชจ๋  ์๋ธํด๋์ค์ ์ด๋ํฐ๋ฅผ ์ ์ฉํ  ์ ์๋ ๋ฑ ๋น๊ต์  ์ ์ฐํ๊ฒ ์ฌ์ฉ์ด ๊ฐ๋ฅํ ๋ฐ๋ฉด, **Class Adapter**๋ Adapter๊ฐ Adaptee์ ์๋ธํด๋์ค์ด๊ธฐ ๋๋ฌธ์ Adaptee๋ฅผ ์ค๋ฒ๋ผ์ด๋ ํ  ์ ์๊ณ , Main์ฝ๋์์ ๋ณผ ์ ์๋ฏ Adaptee ๊ฐ์ฒด๋ฅผ ๋ง๋ค์ง ์์๋ ๋๋ค๋ ์ฅ์ ์ด ์๋ค๐ค๐ค

