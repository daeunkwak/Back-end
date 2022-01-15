# [Design Pattern] Command Pattern

## 💡 About Command Pattern

커맨드 패턴은 주어진 기능들을 캡슐화함으로써 서로 다른 요청들을 실행할 수 있도록 하는 패턴이다. 

간단히 말하자면 객체의 행위(메소드)를 클래스로 만들어 캡슐화하는 패턴인데, A 객체에서 B 객체의 메소드를 실행하려면 B 객체를 참조하고 있어야하는 의존성이 발생한다.

→ 커맨드 패턴을 적용하면 이런 의존성을 제거하고, 기능들을 수정, 추가할 때 확장성과 유연성이 좋아진다.

## 💡 Command Pattern Structure

![Untitled](%5BDesign%20Pattern%5D%20Command%20Pattern%20f9b3cbc8a9c041bb8be6857552d1942a/Untitled.png)

**Invoker**

→ 기능의 실행을 요청하는 호출자 클래스

**Command**

→ 실행될 기능에 대한 인터페이스

- 실행될 기능을 execute 메소드로 구현

**ConcreteCommand**

→ Command 인터페이스 구현

**Receiver**

→ ConcreteCommand에서 execute 메소드를 구현할 때 필요한 클래스

## 💡 Practice Command Pattern

![Untitled](%5BDesign%20Pattern%5D%20Command%20Pattern%20f9b3cbc8a9c041bb8be6857552d1942a/Untitled%201.png)

주어진 다이어그램과 같이 RemoteControl에서 Light를 on/off하는 등의 실행을 요청하고, 그 과정이 Command를 상속받은 LightOnCommand에서 구현된 프로그램을 만들어보자.

- Command

```java
package Command;

public interface Command {
    public void execute();
    public void undo();
}
```

- Light

```java
public class Light {
    String location = "";

    public Light(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + " light is on");
    }

    public void off() {
        System.out.println(location + " light is off");
    }
}
```

- LightOnCommand

Light객체를 가져와서 Light의 메소드를 사용함으로써 LightOnCommand에서는 execute() 메소드만을 사용할 수 있다. ↔ LightOnCommand에서 Light의 메소드를 실행하는데 의존성을 제거한다.

```java
package Command;

public class LightOnCommand implements Command{
    Light light;

    public LightOnCommand(Light light){
        this.light = light;
    }

    public void execute(){
        light.on();
    }

    @Override
    public void undo() {

    }
}
```

- LightOffCommand

```java
package Command;

public class LightOffCommand implements Command{
    Light light;

    public LightOffCommand(Light light){
        this.light = light;
    }

    public void execute(){
        light.on();
    }
}
```

- RemoteControl ⭐

Command객체 배열을 선언하여 main에서 인덱스를 입력하면 객체를 생성하고, 수행할 객체별로 setCommand까지 할 수 있도록 한다.

예를들면,RemoteControl 객체를 생성한 후, lightCommand의 on을 execute한다

```java
package Command;

public class RemoteControl {
    // on/off 메소드가 구현된 7개의 객체가 있는 상황 ex) Light, TV
    Command[] onCommand = new Command[7];
    Command[] offCommand = new Command[7];
    Command undoCommand = new NullCommand();

    // NullCommand -> Null로 setting
    RemoteControl(){
        for(int i = 0; i < 7; i++){
            onCommand[i] = new NullCommand();
            offCommand[i] = new NullCommand();
        }
    }

   // 구현된 메소드가 모두 on/off로 같음 -> command array로 구현 가능
   public void setOnCommand(int num, Command myCommand){
        onCommand[num] = myCommand;
    }

    public void setOffCommand(int num, Command myCommand){
        offCommand[num] = myCommand;
    }

    public void onButtonWasPushed(int num) {
        // button1 눌렸을 때 코드
        // Light myLight = new Light("Living Room");
        // myLight.on();
        // command1on.execute();
        onCommand[num].execute();
    }

   public void offButtonWasPushed(int num) {
        // myLight를 알아야 키고 끌 수 있는 상황
        // <-> 리모컨을 작동할 때 어떤 객체를 만들어야할지 다 알아야한다
        // myLight.off();
        offCommand[num].execute();
    }

    public String toString() {
        StringBuffer stringBuff = new StringBuffer();
        stringBuff.append("\n------ Remote Control -------\n");
        return stringBuff.toString();
    }
}
```

- Main

```java
package Command;

public class Main {
    // RemoteController의 기능들을 모두 밖으로 빼버린것!
    public static void main(String[] args) {
        Light livingRoomLight = new Light("Living Room");
        Light bedRoomLight = new Light("Bed Room");
        TV myTV = new TV("Living Room");
        RemoteControl myRemote = new RemoteControl();

        // Setting 하고
        myRemote.setOnCommand(0, new LightOnCommand(livingRoomLight));
        myRemote.setOnCommand(1, new TVOnCommand(myTV));
        myRemote.setOffCommand(1, new TVOffCommand(myTV));
        myRemote.setOnCommand(5, new enterCommand(livingRoomLight, myTV));

        // 버튼을 누르는것
        myRemote.onButtonWasPushed(0);
        myRemote.onButtonWasPushed(1);
        myRemote.offButtonWasPushed(0);
        myRemote.onButtonWasPushed(5);
    }
}
```

- LivingRoom의 램프를 켜고 싶다면
    1. remoteControl 객체 생성
    2. Light 객체 생성
    3. remoteControl의 setOnCommand 메소드를 통해 Light에 해당하는 객체로 setting
    4. remoteControl의 onButtonPushed 메소드 호출
- TV 전원을 끄고 싶다면
    1. 이미 생성된 remoteControl객체 사용 가능
    2. TV 객체 생성
    3. remoteControl의 setOffCommand 메소드를 통해 TV에 해당하는 객체로 setting
    4. remoteControl의 offButtonPushed 메소드 호출

이런식으로 커맨드 패턴을 이용하면 on/off button과 같이 겹치는 동작들의 코드를 변경하지 않으면서 다양한 객체의 동작을 구현할 수 있게 된다🤗

참고

[[Design Pattern] 커맨드 패턴이란 - Heee's Development Blog (gmlwjd9405.github.io)](https://gmlwjd9405.github.io/2018/07/07/command-pattern.html)