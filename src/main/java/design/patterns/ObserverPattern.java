package design.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * The observer pattern defines a one-to-many dependency between objects so that when one object changes state,
 * all its dependents are notified and updated automatically 
 */
public class ObserverPattern {

	interface Subject {
		void registerObserver(Observer o);

		void removeObserver(Observer o);

		void notifyObservers();
	}

	interface Observer {
		void update();
	}

	
	static class WeatherData implements Subject {

		private final List<Observer> observers;
		private final float temperature;
		private final float humidity;
		private final float pressure;

		WeatherData() {
			this.observers = new ArrayList<>();
			temperature = 50;
			humidity = 50;
			pressure = 1;
		}

		@Override
		public void registerObserver(Observer o) {
			observers.add(o);
		}

		@Override
		public void removeObserver(Observer o) {
			observers.remove(o);
		}

		@Override
		public void notifyObservers() {
			for (Observer observer : observers) {
				observer.update();
			}
		}

		public void measurementsChanged() {
			notifyObservers();
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

	static class ForecastDisplay implements Observer {

		private float temperature;
		private float humidity;
		private final WeatherData weatherData;

		ForecastDisplay(WeatherData weatherData) {
			this.weatherData = weatherData;
			weatherData.registerObserver(this);
		}

		@Override
		public void update() {
			temperature = weatherData.getTemperature();
			humidity = weatherData.getHumidity();
			display();
		}

		public void display() {
			System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
		}
	}

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
		forecastDisplay.display();
		weatherData.measurementsChanged();
	}
}
