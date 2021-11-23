# [Design Pattern] Adapter Pattern

## 💡 About Adapter Pattern

Adapter Pattern은 인터페이스와 인터페이스간의 호환성 문제를 해결해주는 패턴이다. 콘센트에 사용하는 그 어뎁터의 역할과 동일!

호환되지 않는 인터페이스를 사용하는 코드들은 Adapter Class를 만들어 활용할 수 있다.

- My existing system → Adapter → Vendor class
- **Object Adapter**와 **Class Adapter**로 구현방법이 나누어진다.
- 인터페이스가 호환되지 않는 문제가 발생해도 Adapter Pattern을 통해 기존의 코드를 수정하지 않고도 문제를 해결할 수 있다.

## 💡 Adapter Pattern Structure

### **Object Adapter Pattern**

![adapter1](https://user-images.githubusercontent.com/77181984/143028269-653f660f-ddab-41a3-85fb-568dc64377ae.png)

**Client**

→ Target Interface를 요구하는 클래스

**Adaptee**

→ 적용할 외부시스템, 코드

**Target Interface**

→ Adapter가 implements하는 인터페이스

- 클라이언트는 Target Interface를 통해 Adaptee를 사용할 수 있게 된다.

**Adapter**

→ 클라이언트와 Adaptee를 연결시켜주는 Adapter

- 클라이언트의 요청을 Adaptee가 이해할 수 있는 방법으로 전달
- Adaptee 클래스를 Target Interface에 맞추어 제공

### **Class Adapter Pattern**

![adapter2](https://user-images.githubusercontent.com/77181984/143028287-e5de8789-fbaf-49bd-aa08-1ae527d558db.png)

클래스 어댑터는 다중 상속을 지원하여 Adapter가 Target 클래스와 Adaptee 클래스를 둘 다 상속한다.

## 💡 Practice Adapter Pattern

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

Turkey객체를 사용하여 Turkey의 gooble메소드를 Duck의 quack메소드로 맞추어준다.

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

TurkeyAdapter를 통해 Duck interface객체로 Turkey를 생성해준다.

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

Duck 인터페이스와 WildTurkey 클래스를 모두 상속받는 WildTurkeyAdapter

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

**Object Adapter**는 상속이 아닌 구성을 사용하기 때문에 Adaptee에 대한 모든 서브클래스에 어댑터를 적용할 수 있는 등 비교적 유연하게 사용이 가능한 반면, **Class Adapter**는 Adapter가 Adaptee의 서브클래스이기 때문에 Adaptee를 오버라이드 할 수 있고, Main코드에서 볼 수 있듯 Adaptee 객체를 만들지 않아도 된다는 장점이 있다🤗🤗

