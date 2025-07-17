import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeatherApp {

    public static void main(String[] args) {
        JFrame frame = new JFrame("🌦️ Aplicación del Clima");
        frame.setSize(450, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel label = new JLabel("Ciudad:");
        label.setBounds(20, 20, 100, 25);
        frame.add(label);

        JTextField cityField = new JTextField();
        cityField.setBounds(80, 20, 250, 25);
        frame.add(cityField);

        JButton button = new JButton("Buscar");
        button.setBounds(340, 20, 80, 25);
        frame.add(button);

        JTextArea resultArea = new JTextArea();
        resultArea.setBounds(20, 60, 400, 230);
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        frame.add(resultArea);

        JLabel help = new JLabel("Ejemplo: Madrid | Paris,FR | Phnom Penh,KH");
        help.setBounds(20, 295, 400, 25);
        frame.add(help);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String city = cityField.getText().trim();
                if (!city.isEmpty()) {
                    resultArea.setText("🔍 Buscando clima en " + city + "...");
                    String result = WeatherService.getWeather(city);
                    resultArea.setText(result);
                } else {
                    resultArea.setText("⚠️ Por favor, introduce una ciudad.");
                }
            }
        });

        frame.setVisible(true);
    }
}