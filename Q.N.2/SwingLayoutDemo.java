import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingLayoutDemo {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Student Registration Form");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setLayout(new BorderLayout(10, 10));

        // ===== NORTH (FlowLayout) =====
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.setBackground(new Color(220, 230, 241));

        JLabel nameLabel = new JLabel("Enter Name:");
        JTextField nameField = new JTextField(15);

        topPanel.add(nameLabel);
        topPanel.add(nameField);
        frame.add(topPanel, BorderLayout.NORTH);

        // ===== CENTER (GridLayout) =====
        JPanel centerPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        centerPanel.setBorder(BorderFactory.createTitledBorder("Options"));
        centerPanel.setBackground(Color.WHITE);

        // Gender
        centerPanel.add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel(new FlowLayout());
        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        genderPanel.add(male);
        genderPanel.add(female);
        centerPanel.add(genderPanel);

        // Course
        centerPanel.add(new JLabel("Course:"));
        JComboBox<String> courseBox =
                new JComboBox<>(new String[]{"Java", "Python", "C++"});
        centerPanel.add(courseBox);

        // Subscribe
        centerPanel.add(new JLabel("Subscribe:"));
        JCheckBox subscribe = new JCheckBox("Yes");
        centerPanel.add(subscribe);

        frame.add(centerPanel, BorderLayout.CENTER);

        // ===== SOUTH (FlowLayout) =====
        JPanel bottomPanel = new JPanel(new FlowLayout());
        bottomPanel.setBackground(new Color(220, 230, 241));

        JButton submitBtn = new JButton("Submit");
        JButton resetBtn = new JButton("Reset");

        bottomPanel.add(submitBtn);
        bottomPanel.add(resetBtn);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // ===== Button Actions =====

        submitBtn.addActionListener(e -> {
            String name = nameField.getText();
            String gender = male.isSelected() ? "Male" :
                            female.isSelected() ? "Female" : "Not Selected";
            String course = (String) courseBox.getSelectedItem();
            String sub = subscribe.isSelected() ? "Yes" : "No";

            JOptionPane.showMessageDialog(frame,
                    "Name: " + name +
                    "\nGender: " + gender +
                    "\nCourse: " + course +
                    "\nSubscribed: " + sub,
                    "Submitted Data",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        resetBtn.addActionListener(e -> {
            nameField.setText("");
            bg.clearSelection();
            courseBox.setSelectedIndex(0);
            subscribe.setSelected(false);
        });

        frame.setVisible(true);
    }
}
