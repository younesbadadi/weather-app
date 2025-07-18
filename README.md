# Java Weather App 🌤️

A simple and clean desktop application developed in Java using the Swing library. It allows users to check the current weather for any city in the world by fetching real-time data from the OpenWeatherMap API.

This project was created as part of my personal portfolio to showcase skills in Java desktop development, consuming REST APIs, and handling JSON data.

---
## 📸 Screenshot
<img width="449" height="347" alt="Captura de pantalla 2025-07-17 a las 11 28 26" src="https://github.com/user-attachments/assets/9a0bf523-1e43-42f9-ba9b-d07808c6d262" />
---

## ✨ Key Features

* **Search by City:** Enter any city name to get its weather data.
* **Real-Time Data:** Displays up-to-date information on:
    * Current temperature.
    * "Feels like" temperature.
    * Humidity.
    * A textual description of the weather (e.g., "scattered clouds").
* **Simple GUI:** Built with Java Swing for a straightforward and functional user experience.
* **Error Handling:** Notifies the user if the city is not found or if there's a connection issue.

---
## 🛠️ Tech Stack

* **Language:** Java 11 (or higher).
* **GUI Framework:** Java Swing.
* **JSON Parsing:** Google's [Gson](https://github.com/google/gson) library.
* **External API:** [OpenWeatherMap API](https://openweathermap.org/api) for weather data.
* **IDE:** Visual Studio Code.

---
# 🚀 Getting Started

To get a local copy up and running, follow these simple steps.

### Prerequisites

Make sure you have the Java Development Kit (JDK) installed on your system.
* [Download JDK](https://adoptium.net/)

### Installation & Setup

1.  **Clone the repo**
    ```bash
    git clone [https://github.com/your-username/your-repository.git](https://github.com/your-username/your-repository.git)
    ```

2.  **Set up your API Key**
    This project requires an OpenWeatherMap API key to function.
    * Create a copy of the `config.properties.example` file and rename it to `config.properties`.
    * Open `config.properties` and replace the placeholder text with your actual API key.
    ```properties
    # config.properties
    API_KEY=YOUR_API_KEY_GOES_HERE
    ```

3.  **Run the Application**
    * Open the project in your favorite IDE (e.g., VS Code, Eclipse, IntelliJ).
    * Ensure the `gson-....jar` library is added to the project's build path or referenced libraries.
    * Run the `main` method located in the `WeatherApp.java` class.

---

