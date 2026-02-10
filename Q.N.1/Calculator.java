//Write a Java program that works as a simple calculator. Use a grid layout to arrange buttons for the digits and for the +, -, , % operations. Add a text field to display the result. Handle any possible exceptions like divided by zero.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

    JTextField input = new JTextField();
    JTextField result = new JTextField("0");

    double num1 = 0;
    String op = "";

    public Calculator() {
        setTitle("Calculator");
        setSize(350, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Display panel (2 lines)
        JPanel displayPanel = new JPanel(new GridLayout(2, 1));
        displayPanel.setBackground(Color.DARK_GRAY);

        input.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        input.setHorizontalAlignment(JTextField.RIGHT);
        input.setEditable(false);
        input.setBackground(Color.DARK_GRAY);
        input.setForeground(Color.LIGHT_GRAY);
        input.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));

        result.setFont(new Font("Segoe UI", Font.BOLD, 32));
        result.setHorizontalAlignment(JTextField.RIGHT);
        result.setEditable(false);
        result.setBackground(Color.DARK_GRAY);
        result.setForeground(Color.WHITE);
        result.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        displayPanel.add(input);
        displayPanel.add(result);
        add(displayPanel, BorderLayout.NORTH);

        // Buttons
        JPanel panel = new JPanel(new GridLayout(5, 4, 10, 10));
        panel.setBackground(Color.BLACK);

        String[] btns = {
                "C","←","%","/",
                "7","8","9","*",
                "4","5","6","-",
                "1","2","3","+",
                "0",".","=",""
        };

        for (String b : btns)
            panel.add(b.isEmpty() ? new JLabel() : button(b));

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    JButton button(String t) {
        JButton b = new JButton(t);
        b.setFont(new Font("Segoe UI", Font.BOLD, 18));
        b.setFocusPainted(false);
        b.setBackground("=+-*/".contains(t) ? Color.ORANGE :
                        t.equals("C") ? Color.RED : Color.GRAY);
        b.setForeground(Color.WHITE);
        b.addActionListener(this);
        return b;
    }

    public void actionPerformed(ActionEvent e) {
        String c = e.getActionCommand();

        if (c.matches("[0-9.]")) {
            result.setText(result.getText().equals("0") ? c : result.getText() + c);
        }
        else if (c.equals("C")) {
            input.setText("");
            result.setText("0");
            op = "";
        }
        else if (c.equals("←")) {
            result.setText(result.getText().length() > 1 ?
                    result.getText().substring(0, result.getText().length() - 1) : "0");
        }
        else if (c.equals("=")) {
            calculate();
        }
        else { // operator
            num1 = Double.parseDouble(result.getText());
            op = c;
            input.setText(num1 + " " + op);
            result.setText("0");
        }
    }

    void calculate() {
        double num2 = Double.parseDouble(result.getText());
        double res = 0;

        switch (op) {
            case "+" -> res = num1 + num2;
            case "-" -> res = num1 - num2;
            case "*" -> res = num1 * num2;
            case "/" -> res = (num2 == 0) ? 0 : num1 / num2;
        }

        input.setText(num1 + " " + op + " " + num2);
        result.setText(String.valueOf(res));
        op = "";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calculator::new);
    }
}
