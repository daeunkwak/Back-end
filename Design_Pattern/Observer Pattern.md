## 💡 About Observer Pattern
 
옵저버 패턴은 간단히 얘기하자면 어떤 객체의 상태가 변할 때 그와 연관된 객체들에게 알림을 보내는 디자인 패턴이다.
 
-   pull → 데이터를 받아온다
-   push → 데이터를 입력한다
 
기본적으로 데이터의 변경값을 반영하거나 추가할 때, pull보다 push를 통해 처리해주는게 더 빠르다는 아이디어에서 시작된 패턴 !
 
-   One-To-Many Relationship
 
→ 하나의 신문사에서 구독자를 계속 수정하고, 추가해준다고 생각하면 쉽다.
 
## 💡 Observer Pattern Structure
 
![Observer](https://user-images.githubusercontent.com/77181984/136444248-0fe26301-22bf-4b24-a81e-deb46e1a3163.png)
 
**Subject**  
→ 신문사 역할, ConcreteSubject의 상위 클래스
 
-   subject 객체에서 데이터를 관리한다.
-   데이터가 달라지면 observer에게 notify를 보낸다.
 
**Observer**  
→ 구독자 역할, ConcreteObserver의 상위 클래스
 
-   update() 메소드를 통해 데이터를 push한다.
 
**ConcreteSubject**  
→ Subject의 하위 클래스
 
**ConcreteObserver**  
→ Observer의 상위 클래스
 
-   자유도를 높이기 위하여 상위/하위구조로 클래스를 독립시킨다  
    ↔ Dependency Inversion Principle
-   ConcreteObserver 객체는 여러개가 만들어질 수 있지만, Observer는 interface이므로 여러개의 객체가 만들어질 수 없는 구조이다.
-   일반적으로 옵저버 패턴은 push를 통해 데이터를 전달하는 구조이지만, 자유도를 높이기 위해 특정 상황에서는 정보를 가져올 수 있도록 pull할 수도 있다.
 
## 💡 Java's Observer
 
자바에서는 자체적으로 옵저버 패턴을 지원하는 라이브러리가 있다. Observable 인터페이스와 Observable클래스를 제공하므로 우리는 위 그림의 Concrete부분만 구현하면 옵저버 패턴을 쉽게 구현할 수 있다!
 
-   **Observer 인터페이스** → 위 그림의 ConcreteSubject와 같은 역할  
    Observser 인터페이스를 구현하여 신문사 클래스를 만들 수 있다.
-   **Observable 클래스** → 위 그림의 Observer클래스와 같은 역할  
    Observable 객체의 addObserver() 메소드 호출을 통해 객체를 생성하고, One-To-Many Relationship을 구현할 수 있다.
 
## 💡 Practice Observer Pattern
 
**다음 코드에 Observer Pattern을 적용해보자**. (일부 메소드 구현은 생략한 코드)
 
```
import java.util.ArrayList;
 
public class WeatherData {
    private float temperature;
    private float humidity;
    private float pressure;
 
    public WeatherData() { }
 
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }
 
    public float getTemperature() {
        return temperature;
    }
 
    public float getHumidity() {
        return humidity;
    }
 
    public float getPressure() {
        return pressure;
    }
}
 
class WeatherStation {
 
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
 
        CurrentConditionsDisplay currentDisplay =
                new CurrentConditionsDisplay();
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay();
        ForecastDisplay forecastDisplay = new ForecastDisplay();
 
        weatherData.setMeasurements(80, 65, 30.4f);
        currentDisplay.update(weatherData.getTemperature(), weatherData.getHumidity(), weatherData.getPressure());
        statisticsDisplay.update(weatherData.getTemperature(), weatherData.getHumidity(), weatherData.getPressure());
        forecastDisplay.update(weatherData.getTemperature(), weatherData.getHumidity(), weatherData.getPressure());
 
        weatherData.setMeasurements(82, 70, 29.2f);
        currentDisplay.update(weatherData.getTemperature(), weatherData.getHumidity(), weatherData.getPressure());
        statisticsDisplay.update(weatherData.getTemperature(), weatherData.getHumidity(), weatherData.getPressure());
        forecastDisplay.update(weatherData.getTemperature(), weatherData.getHumidity(), weatherData.getPressure());
 
        weatherData.setMeasurements(78, 90, 29.2f);
        currentDisplay.update(weatherData.getTemperature(), weatherData.getHumidity(), weatherData.getPressure());
        statisticsDisplay.update(weatherData.getTemperature(), weatherData.getHumidity(), weatherData.getPressure());
        forecastDisplay.update(weatherData.getTemperature(), weatherData.getHumidity(), weatherData.getPressure());
    }
}
 
class StatisticsDisplay {
    private float maxTemp = 0.0f;
    private float minTemp = 200;
    private float tempSum= 0.0f;
    private int numReadings;
 
    public StatisticsDisplay() {
    }
 
    public void update(float temp, float humidity, float pressure) {
        display();
    }
 
    public void display() {
    }
}
 
class CurrentConditionsDisplay {
    private float temperature;
    private float humidity;
 
    public CurrentConditionsDisplay() {
    }
 
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }
 
    public void display() {
    }
}
 
class ForecastDisplay {
    private float currentPressure = 29.92f;
    private float lastPressure;
 
    public ForecastDisplay() {
    }
 
    public void update(float temp, float humidity, float pressure) {
        lastPressure = currentPressure;
        currentPressure = pressure;
        display();
    }
 
    public void display() {
    }
}
```
 
1.  DisplayElements, Observer 인터페이스를 추가하여 3개의 Display 클래스(StatisticsDisplay, CurrentConditionDisplay, ForecastDisplay)에서 상속받아 구현하도록 한다.
 
```
interface Observer {
    public void update(float temp, float humidity, float pressure);
}
 
interface DisplayElements{
    public void display();
}
 
class StatisticsDisplay implements Observer, DisplayElements{
    private float maxTemp = 0.0f;
    private float minTemp = 200;
    private float tempSum= 0.0f;
    private int numReadings;
 
    public StatisticsDisplay() {
    }
 
    public void update(float temp, float humidity, float pressure) {
    }
 
    public void display() {
    }
}
 
class CurrentConditionsDisplay implements Observer, DisplayElements{}
 
class ForecastDisplay implements Observer, DisplayElements{}
```
 
2.  Observer Pattern Structure 그림의 Subject 인터페이스를 작성해주고, WeatherData 클래스가 이를 상속받아 등록, 삭제, 업데이트 메소드를 구현한다.  
    Subject는 인터페이스로 구현하는 방법 외에도 추상클래스로 작성하는 방법 그리고 자바에서 제공하는 Observable 클래스를 사용하는 방법이 있다.
 
```
    interface Subject {
        public void registerObserver(Observer o); // 구독
        public void removeObserver(Observer o);   // 구독 해지
        public void notifyObservers();
    }
 
    public class WeatherData implements Subject{
        private float temperature;
        private float humidity;
        private float pressure;
        // Observer 객체들을 관리해줄 리스트 생성
        private ArrayList<Observer> observers = new ArrayList<Observer>();
 
        // 생성자
        public WeatherData(){
            observers = new ArrayList<Observer>();
        }
 
        public void setMeasurements(float temperature, float humidity, float pressure) {
            this.temperature = temperature;
            this.humidity = humidity;
            this.pressure = pressure;
 
            // 변화가 생기면 notifyObservers() 호출!
            notifyObservers();
 
        }
 
            // 생략
 
        // 리스트를 관리해야함 -> 구독자 등록, 삭제, 업데이트 메소드 구현
        @Override
        public void registerObserver(Observer o) {
            // Observer객체 ArrayList에 등록
        }
 
        @Override
        public void removeObserver(Observer o) {
            // 리스트에서 제거하기 -> 인덱스 찾아서 지우기
        }
 
        @Override
        public void notifyObservers() {
            // loop를 돌면서 변경된 객체마다 한번씩 update 메소드를 호출해줌
        }
    }
```
 
결과적으로, 객체가 등록되거나 삭제될 때, 변경될 때 각각 registerObserver, removeObserver, notifyObserver 메소드만 호출하면 되므로 WeatherStation 클래스의 코드가 다음과 같이 간단해진다.
 
```
class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
 
        CurrentConditionsDisplay currentDisplay =
                new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
 
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
    }
}
```
 
push를 통해 데이터를 입력, 수정하기 간편하면서도 기존의 get 메소드들도 유지하여 필요에 의해 pull을 통해 데이터들을 불러올 수도 있는 구조가 되었다🤗🤗