# [Design Pattern] Command Pattern

## ๐ก About Command Pattern

์ปค๋งจ๋ ํจํด์ ์ฃผ์ด์ง ๊ธฐ๋ฅ๋ค์ ์บก์ํํจ์ผ๋ก์จ ์๋ก ๋ค๋ฅธ ์์ฒญ๋ค์ ์คํํ  ์ ์๋๋ก ํ๋ ํจํด์ด๋ค. 

๊ฐ๋จํ ๋งํ์๋ฉด ๊ฐ์ฒด์ ํ์(๋ฉ์๋)๋ฅผ ํด๋์ค๋ก ๋ง๋ค์ด ์บก์ํํ๋ ํจํด์ธ๋ฐ, A ๊ฐ์ฒด์์ B ๊ฐ์ฒด์ ๋ฉ์๋๋ฅผ ์คํํ๋ ค๋ฉด B ๊ฐ์ฒด๋ฅผ ์ฐธ์กฐํ๊ณ  ์์ด์ผํ๋ ์์กด์ฑ์ด ๋ฐ์ํ๋ค.

โ ์ปค๋งจ๋ ํจํด์ ์ ์ฉํ๋ฉด ์ด๋ฐ ์์กด์ฑ์ ์ ๊ฑฐํ๊ณ , ๊ธฐ๋ฅ๋ค์ ์์ , ์ถ๊ฐํ  ๋ ํ์ฅ์ฑ๊ณผ ์ ์ฐ์ฑ์ด ์ข์์ง๋ค.

## ๐ก Command Pattern Structure

![Untitled](%5BDesign%20Pattern%5D%20Command%20Pattern%20f9b3cbc8a9c041bb8be6857552d1942a/Untitled.png)

**Invoker**

โ ๊ธฐ๋ฅ์ ์คํ์ ์์ฒญํ๋ ํธ์ถ์ ํด๋์ค

**Command**

โ ์คํ๋  ๊ธฐ๋ฅ์ ๋ํ ์ธํฐํ์ด์ค

- ์คํ๋  ๊ธฐ๋ฅ์ execute ๋ฉ์๋๋ก ๊ตฌํ

**ConcreteCommand**

โ Command ์ธํฐํ์ด์ค ๊ตฌํ

**Receiver**

โ ConcreteCommand์์ execute ๋ฉ์๋๋ฅผ ๊ตฌํํ  ๋ ํ์ํ ํด๋์ค

## ๐ก Practice Command Pattern

![Untitled](%5BDesign%20Pattern%5D%20Command%20Pattern%20f9b3cbc8a9c041bb8be6857552d1942a/Untitled%201.png)

์ฃผ์ด์ง ๋ค์ด์ด๊ทธ๋จ๊ณผ ๊ฐ์ด RemoteControl์์ Light๋ฅผ on/offํ๋ ๋ฑ์ ์คํ์ ์์ฒญํ๊ณ , ๊ทธ ๊ณผ์ ์ด Command๋ฅผ ์์๋ฐ์ LightOnCommand์์ ๊ตฌํ๋ ํ๋ก๊ทธ๋จ์ ๋ง๋ค์ด๋ณด์.

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

Light๊ฐ์ฒด๋ฅผ ๊ฐ์ ธ์์ Light์ ๋ฉ์๋๋ฅผ ์ฌ์ฉํจ์ผ๋ก์จ LightOnCommand์์๋ execute() ๋ฉ์๋๋ง์ ์ฌ์ฉํ  ์ ์๋ค. โ LightOnCommand์์ Light์ ๋ฉ์๋๋ฅผ ์คํํ๋๋ฐ ์์กด์ฑ์ ์ ๊ฑฐํ๋ค.

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

- RemoteControl โญ

Command๊ฐ์ฒด ๋ฐฐ์ด์ ์ ์ธํ์ฌ main์์ ์ธ๋ฑ์ค๋ฅผ ์๋ ฅํ๋ฉด ๊ฐ์ฒด๋ฅผ ์์ฑํ๊ณ , ์ํํ  ๊ฐ์ฒด๋ณ๋ก setCommand๊น์ง ํ  ์ ์๋๋ก ํ๋ค.

์๋ฅผ๋ค๋ฉด,RemoteControl ๊ฐ์ฒด๋ฅผ ์์ฑํ ํ, lightCommand์ on์ executeํ๋ค

```java
package Command;

public class RemoteControl {
    // on/off ๋ฉ์๋๊ฐ ๊ตฌํ๋ 7๊ฐ์ ๊ฐ์ฒด๊ฐ ์๋ ์ํฉ ex) Light, TV
    Command[] onCommand = new Command[7];
    Command[] offCommand = new Command[7];
    Command undoCommand = new NullCommand();

    // NullCommand -> Null๋ก setting
    RemoteControl(){
        for(int i = 0; i < 7; i++){
            onCommand[i] = new NullCommand();
            offCommand[i] = new NullCommand();
        }
    }

   // ๊ตฌํ๋ ๋ฉ์๋๊ฐ ๋ชจ๋ on/off๋ก ๊ฐ์ -> command array๋ก ๊ตฌํ ๊ฐ๋ฅ
   public void setOnCommand(int num, Command myCommand){
        onCommand[num] = myCommand;
    }

    public void setOffCommand(int num, Command myCommand){
        offCommand[num] = myCommand;
    }

    public void onButtonWasPushed(int num) {
        // button1 ๋๋ ธ์ ๋ ์ฝ๋
        // Light myLight = new Light("Living Room");
        // myLight.on();
        // command1on.execute();
        onCommand[num].execute();
    }

   public void offButtonWasPushed(int num) {
        // myLight๋ฅผ ์์์ผ ํค๊ณ  ๋ ์ ์๋ ์ํฉ
        // <-> ๋ฆฌ๋ชจ์ปจ์ ์๋ํ  ๋ ์ด๋ค ๊ฐ์ฒด๋ฅผ ๋ง๋ค์ด์ผํ ์ง ๋ค ์์์ผํ๋ค
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
    // RemoteController์ ๊ธฐ๋ฅ๋ค์ ๋ชจ๋ ๋ฐ์ผ๋ก ๋นผ๋ฒ๋ฆฐ๊ฒ!
    public static void main(String[] args) {
        Light livingRoomLight = new Light("Living Room");
        Light bedRoomLight = new Light("Bed Room");
        TV myTV = new TV("Living Room");
        RemoteControl myRemote = new RemoteControl();

        // Setting ํ๊ณ 
        myRemote.setOnCommand(0, new LightOnCommand(livingRoomLight));
        myRemote.setOnCommand(1, new TVOnCommand(myTV));
        myRemote.setOffCommand(1, new TVOffCommand(myTV));
        myRemote.setOnCommand(5, new enterCommand(livingRoomLight, myTV));

        // ๋ฒํผ์ ๋๋ฅด๋๊ฒ
        myRemote.onButtonWasPushed(0);
        myRemote.onButtonWasPushed(1);
        myRemote.offButtonWasPushed(0);
        myRemote.onButtonWasPushed(5);
    }
}
```

- LivingRoom์ ๋จํ๋ฅผ ์ผ๊ณ  ์ถ๋ค๋ฉด
    1. remoteControl ๊ฐ์ฒด ์์ฑ
    2. Light ๊ฐ์ฒด ์์ฑ
    3. remoteControl์ setOnCommand ๋ฉ์๋๋ฅผ ํตํด Light์ ํด๋นํ๋ ๊ฐ์ฒด๋ก setting
    4. remoteControl์ onButtonPushed ๋ฉ์๋ ํธ์ถ
- TV ์ ์์ ๋๊ณ  ์ถ๋ค๋ฉด
    1. ์ด๋ฏธ ์์ฑ๋ remoteControl๊ฐ์ฒด ์ฌ์ฉ ๊ฐ๋ฅ
    2. TV ๊ฐ์ฒด ์์ฑ
    3. remoteControl์ setOffCommand ๋ฉ์๋๋ฅผ ํตํด TV์ ํด๋นํ๋ ๊ฐ์ฒด๋ก setting
    4. remoteControl์ offButtonPushed ๋ฉ์๋ ํธ์ถ

์ด๋ฐ์์ผ๋ก ์ปค๋งจ๋ ํจํด์ ์ด์ฉํ๋ฉด on/off button๊ณผ ๊ฐ์ด ๊ฒน์น๋ ๋์๋ค์ ์ฝ๋๋ฅผ ๋ณ๊ฒฝํ์ง ์์ผ๋ฉด์ ๋ค์ํ ๊ฐ์ฒด์ ๋์์ ๊ตฌํํ  ์ ์๊ฒ ๋๋ค๐ค

์ฐธ๊ณ 

[[Design Pattern] ์ปค๋งจ๋ ํจํด์ด๋ - Heee's Development Blog (gmlwjd9405.github.io)](https://gmlwjd9405.github.io/2018/07/07/command-pattern.html)