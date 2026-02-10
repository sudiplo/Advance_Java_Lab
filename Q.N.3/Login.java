// Create a login page in Swing and add events to it on click of login button.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    JTextField user;
    JPasswordField pass;
    JButton login;

    Login() {
        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 10, 10));

        add(new JLabel("Username:"));
        user = new JTextField();
        add(user);

        add(new JLabel("Password:"));
        pass = new JPasswordField();
        add(pass);

        login = new JButton("Login");
        add(new JLabel());
        add(login);

        login.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String u = user.getText();
        String p = new String(pass.getPassword());

        if (u.equals("Sudip") && p.equals("1234"))
            JOptionPane.showMessageDialog(this, "Login Successful");
        else
            JOptionPane.showMessageDialog(this, "Invalid Login");
    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}
