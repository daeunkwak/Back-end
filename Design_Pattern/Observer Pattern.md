## ๐ก About Observer Pattern
 
์ต์ ๋ฒ ํจํด์ ๊ฐ๋จํ ์๊ธฐํ์๋ฉด ์ด๋ค ๊ฐ์ฒด์ ์ํ๊ฐ ๋ณํ  ๋ ๊ทธ์ ์ฐ๊ด๋ ๊ฐ์ฒด๋ค์๊ฒ ์๋ฆผ์ ๋ณด๋ด๋ ๋์์ธ ํจํด์ด๋ค.
 
-   pull โ ๋ฐ์ดํฐ๋ฅผ ๋ฐ์์จ๋ค
-   push โ ๋ฐ์ดํฐ๋ฅผ ์๋ ฅํ๋ค
 
๊ธฐ๋ณธ์ ์ผ๋ก ๋ฐ์ดํฐ์ ๋ณ๊ฒฝ๊ฐ์ ๋ฐ์ํ๊ฑฐ๋ ์ถ๊ฐํ  ๋, pull๋ณด๋ค push๋ฅผ ํตํด ์ฒ๋ฆฌํด์ฃผ๋๊ฒ ๋ ๋น ๋ฅด๋ค๋ ์์ด๋์ด์์ ์์๋ ํจํด !
 
-   One-To-Many Relationship
 
โ ํ๋์ ์ ๋ฌธ์ฌ์์ ๊ตฌ๋์๋ฅผ ๊ณ์ ์์ ํ๊ณ , ์ถ๊ฐํด์ค๋ค๊ณ  ์๊ฐํ๋ฉด ์ฝ๋ค.
 
## ๐ก Observer Pattern Structure
 
![Observer](https://user-images.githubusercontent.com/77181984/136444248-0fe26301-22bf-4b24-a81e-deb46e1a3163.png)
 
**Subject**  
โ ์ ๋ฌธ์ฌ ์ญํ , ConcreteSubject์ ์์ ํด๋์ค
 
-   subject ๊ฐ์ฒด์์ ๋ฐ์ดํฐ๋ฅผ ๊ด๋ฆฌํ๋ค.
-   ๋ฐ์ดํฐ๊ฐ ๋ฌ๋ผ์ง๋ฉด observer์๊ฒ notify๋ฅผ ๋ณด๋ธ๋ค.
 
**Observer**  
โ ๊ตฌ๋์ ์ญํ , ConcreteObserver์ ์์ ํด๋์ค
 
-   update() ๋ฉ์๋๋ฅผ ํตํด ๋ฐ์ดํฐ๋ฅผ pushํ๋ค.
 
**ConcreteSubject**  
โ Subject์ ํ์ ํด๋์ค
 
**ConcreteObserver**  
โ Observer์ ์์ ํด๋์ค
 
-   ์์ ๋๋ฅผ ๋์ด๊ธฐ ์ํ์ฌ ์์/ํ์๊ตฌ์กฐ๋ก ํด๋์ค๋ฅผ ๋๋ฆฝ์ํจ๋ค  
    โ Dependency Inversion Principle
-   ConcreteObserver ๊ฐ์ฒด๋ ์ฌ๋ฌ๊ฐ๊ฐ ๋ง๋ค์ด์ง ์ ์์ง๋ง, Observer๋ interface์ด๋ฏ๋ก ์ฌ๋ฌ๊ฐ์ ๊ฐ์ฒด๊ฐ ๋ง๋ค์ด์ง ์ ์๋ ๊ตฌ์กฐ์ด๋ค.
-   ์ผ๋ฐ์ ์ผ๋ก ์ต์ ๋ฒ ํจํด์ push๋ฅผ ํตํด ๋ฐ์ดํฐ๋ฅผ ์ ๋ฌํ๋ ๊ตฌ์กฐ์ด์ง๋ง, ์์ ๋๋ฅผ ๋์ด๊ธฐ ์ํด ํน์  ์ํฉ์์๋ ์ ๋ณด๋ฅผ ๊ฐ์ ธ์ฌ ์ ์๋๋ก pullํ  ์๋ ์๋ค.
 
## ๐ก Java's Observer
 
์๋ฐ์์๋ ์์ฒด์ ์ผ๋ก ์ต์ ๋ฒ ํจํด์ ์ง์ํ๋ ๋ผ์ด๋ธ๋ฌ๋ฆฌ๊ฐ ์๋ค. Observable ์ธํฐํ์ด์ค์ Observableํด๋์ค๋ฅผ ์ ๊ณตํ๋ฏ๋ก ์ฐ๋ฆฌ๋ ์ ๊ทธ๋ฆผ์ Concrete๋ถ๋ถ๋ง ๊ตฌํํ๋ฉด ์ต์ ๋ฒ ํจํด์ ์ฝ๊ฒ ๊ตฌํํ  ์ ์๋ค!
 
-   **Observer ์ธํฐํ์ด์ค** โ ์ ๊ทธ๋ฆผ์ ConcreteSubject์ ๊ฐ์ ์ญํ   
    Observser ์ธํฐํ์ด์ค๋ฅผ ๊ตฌํํ์ฌ ์ ๋ฌธ์ฌ ํด๋์ค๋ฅผ ๋ง๋ค ์ ์๋ค.
-   **Observable ํด๋์ค** โ ์ ๊ทธ๋ฆผ์ Observerํด๋์ค์ ๊ฐ์ ์ญํ   
    Observable ๊ฐ์ฒด์ addObserver() ๋ฉ์๋ ํธ์ถ์ ํตํด ๊ฐ์ฒด๋ฅผ ์์ฑํ๊ณ , One-To-Many Relationship์ ๊ตฌํํ  ์ ์๋ค.
 
## ๐ก Practice Observer Pattern
 
**๋ค์ ์ฝ๋์ Observer Pattern์ ์ ์ฉํด๋ณด์**. (์ผ๋ถ ๋ฉ์๋ ๊ตฌํ์ ์๋ตํ ์ฝ๋)
 
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
 
1.  DisplayElements, Observer ์ธํฐํ์ด์ค๋ฅผ ์ถ๊ฐํ์ฌ 3๊ฐ์ Display ํด๋์ค(StatisticsDisplay, CurrentConditionDisplay, ForecastDisplay)์์ ์์๋ฐ์ ๊ตฌํํ๋๋ก ํ๋ค.
 
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
 
2.  Observer Pattern Structure ๊ทธ๋ฆผ์ Subject ์ธํฐํ์ด์ค๋ฅผ ์์ฑํด์ฃผ๊ณ , WeatherData ํด๋์ค๊ฐ ์ด๋ฅผ ์์๋ฐ์ ๋ฑ๋ก, ์ญ์ , ์๋ฐ์ดํธ ๋ฉ์๋๋ฅผ ๊ตฌํํ๋ค.  
    Subject๋ ์ธํฐํ์ด์ค๋ก ๊ตฌํํ๋ ๋ฐฉ๋ฒ ์ธ์๋ ์ถ์ํด๋์ค๋ก ์์ฑํ๋ ๋ฐฉ๋ฒ ๊ทธ๋ฆฌ๊ณ  ์๋ฐ์์ ์ ๊ณตํ๋ Observable ํด๋์ค๋ฅผ ์ฌ์ฉํ๋ ๋ฐฉ๋ฒ์ด ์๋ค.
 
```
    interface Subject {
        public void registerObserver(Observer o); // ๊ตฌ๋
        public void removeObserver(Observer o);   // ๊ตฌ๋ ํด์ง
        public void notifyObservers();
    }
 
    public class WeatherData implements Subject{
        private float temperature;
        private float humidity;
        private float pressure;
        // Observer ๊ฐ์ฒด๋ค์ ๊ด๋ฆฌํด์ค ๋ฆฌ์คํธ ์์ฑ
        private ArrayList<Observer> observers = new ArrayList<Observer>();
 
        // ์์ฑ์
        public WeatherData(){
            observers = new ArrayList<Observer>();
        }
 
        public void setMeasurements(float temperature, float humidity, float pressure) {
            this.temperature = temperature;
            this.humidity = humidity;
            this.pressure = pressure;
 
            // ๋ณํ๊ฐ ์๊ธฐ๋ฉด notifyObservers() ํธ์ถ!
            notifyObservers();
 
        }
 
            // ์๋ต
 
        // ๋ฆฌ์คํธ๋ฅผ ๊ด๋ฆฌํด์ผํจ -> ๊ตฌ๋์ ๋ฑ๋ก, ์ญ์ , ์๋ฐ์ดํธ ๋ฉ์๋ ๊ตฌํ
        @Override
        public void registerObserver(Observer o) {
            // Observer๊ฐ์ฒด ArrayList์ ๋ฑ๋ก
        }
 
        @Override
        public void removeObserver(Observer o) {
            // ๋ฆฌ์คํธ์์ ์ ๊ฑฐํ๊ธฐ -> ์ธ๋ฑ์ค ์ฐพ์์ ์ง์ฐ๊ธฐ
        }
 
        @Override
        public void notifyObservers() {
            // loop๋ฅผ ๋๋ฉด์ ๋ณ๊ฒฝ๋ ๊ฐ์ฒด๋ง๋ค ํ๋ฒ์ฉ update ๋ฉ์๋๋ฅผ ํธ์ถํด์ค
        }
    }
```
 
๊ฒฐ๊ณผ์ ์ผ๋ก, ๊ฐ์ฒด๊ฐ ๋ฑ๋ก๋๊ฑฐ๋ ์ญ์ ๋  ๋, ๋ณ๊ฒฝ๋  ๋ ๊ฐ๊ฐ registerObserver, removeObserver, notifyObserver ๋ฉ์๋๋ง ํธ์ถํ๋ฉด ๋๋ฏ๋ก WeatherStation ํด๋์ค์ ์ฝ๋๊ฐ ๋ค์๊ณผ ๊ฐ์ด ๊ฐ๋จํด์ง๋ค.
 
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
 
push๋ฅผ ํตํด ๋ฐ์ดํฐ๋ฅผ ์๋ ฅ, ์์ ํ๊ธฐ ๊ฐํธํ๋ฉด์๋ ๊ธฐ์กด์ get ๋ฉ์๋๋ค๋ ์ ์งํ์ฌ ํ์์ ์ํด pull์ ํตํด ๋ฐ์ดํฐ๋ค์ ๋ถ๋ฌ์ฌ ์๋ ์๋ ๊ตฌ์กฐ๊ฐ ๋์๋ค๐ค๐ค