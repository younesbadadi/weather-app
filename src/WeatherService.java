import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WeatherService {

    private static final String API_KEY = "API_KEY"; // ← YOUR API KEY
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather?q=%s&units=metric&lang=es&appid=%s";

    public static String getWeather(String city) {
        try {
            String urlString = String.format(BASE_URL, city, API_KEY);
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode == 404) {
                return "❌ Ciudad no encontrada. Intenta con el nombre oficial en inglés o en formato \"Ciudad,PAÍS\".\nEj: Phnom Penh,KH";
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
            reader.close();

            JsonObject jsonObject = JsonParser.parseString(json.toString()).getAsJsonObject();
            JsonObject main = jsonObject.getAsJsonObject("main");
            double temp = main.get("temp").getAsDouble();
            int humidity = main.get("humidity").getAsInt();
            String description = jsonObject.getAsJsonArray("weather")
                                           .get(0).getAsJsonObject()
                                           .get("description").getAsString();

            return String.format(
                "🌍 Clima en %s:\n🌡️ Temperatura: %.1f°C\n💧 Humedad: %d%%\n📋 Descripción: %s",
                jsonObject.get("name").getAsString(), temp, humidity, capitalizar(description)
            );

        } catch (Exception e) {
            e.printStackTrace();
            return "⚠️ Error al obtener el clima. Verifica tu conexión a internet o intenta con otro nombre.";
        }
    }

    private static String capitalizar(String texto) {
        if (texto == null || texto.isEmpty()) return texto;
        return texto.substring(0, 1).toUpperCase() + texto.substring(1);
    }
}