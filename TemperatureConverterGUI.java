
import java.awt.*;          
import javax.swing.*;       

public class TemperatureConverterGUI extends JFrame {               

   
    private static final Color BACKGROUND_COLOR = new Color(45, 52, 54);
    private static final Color BUTTON_COLOR = new Color(255, 118, 117);
    private static final Color TEXT_COLOR = Color.WHITE;

    public TemperatureConverterGUI() {              

        
        setTitle("Temperature Converter");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(BACKGROUND_COLOR);

       
        JLabel titleLabel = new JLabel("Temperature Converter");
        titleLabel.setForeground(TEXT_COLOR);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(CENTER_ALIGNMENT);

       
        JTextField inputField = new JTextField();
        inputField.setMaximumSize(new Dimension(300, 40));
        inputField.setFont(new Font("Arial", Font.PLAIN, 18));

        
        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setForeground(TEXT_COLOR);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 18));
        resultLabel.setAlignmentX(CENTER_ALIGNMENT);

        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 2, 10, 10));
        buttonPanel.setBackground(BACKGROUND_COLOR);

       
        JButton cToFButton = createButton("C to F", BUTTON_COLOR);
        JButton fToCButton = createButton("F to C", BUTTON_COLOR);
        JButton cToKButton = createButton("C to K", BUTTON_COLOR);
        JButton kToCButton = createButton("K to C", BUTTON_COLOR);
        JButton fToKButton = createButton("F to K", BUTTON_COLOR);
        JButton kToFButton = createButton("K to F", BUTTON_COLOR);

        
        cToFButton.addActionListener(e -> {
            double celsius = Double.parseDouble(inputField.getText());
            double fahrenheit = (celsius * 9 / 5) + 32;
            resultLabel.setText("Result: " + fahrenheit + " F");
        });

        fToCButton.addActionListener(e -> {
            double fahrenheit = Double.parseDouble(inputField.getText());
            double celsius = (fahrenheit - 32) * 5 / 9;
            resultLabel.setText("Result: " + celsius + " C");
        });

        cToKButton.addActionListener(e -> {
            double celsius = Double.parseDouble(inputField.getText());
            double kelvin = celsius + 273.15;
            resultLabel.setText("Result: " + kelvin + " K");
        });

        kToCButton.addActionListener(e -> {
            double kelvin = Double.parseDouble(inputField.getText());
            double celsius = kelvin - 273.15;
            resultLabel.setText("Result: " + celsius + " C");
        });

        fToKButton.addActionListener(e -> {
            double fahrenheit = Double.parseDouble(inputField.getText());
            double kelvin = ((fahrenheit - 32) * 5 / 9) + 273.15;
            resultLabel.setText("Result: " + kelvin + " K");
        });

        kToFButton.addActionListener(e -> {
            double kelvin = Double.parseDouble(inputField.getText());
            double fahrenheit = ((kelvin - 273.15) * 9 / 5) + 32;
            resultLabel.setText("Result: " + fahrenheit + " F");
        });

        
        buttonPanel.add(cToFButton);
        buttonPanel.add(fToCButton);
        buttonPanel.add(cToKButton);
        buttonPanel.add(kToCButton);
        buttonPanel.add(fToKButton);
        buttonPanel.add(kToFButton);

        
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(inputField);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(buttonPanel);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(resultLabel);

       
        add(mainPanel);
    }

    
    private JButton createButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setBackground(color);
        button.setForeground(TEXT_COLOR);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        return button;
    }

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            TemperatureConverterGUI frame = new TemperatureConverterGUI();
            frame.setVisible(true);
        });
    }
}


