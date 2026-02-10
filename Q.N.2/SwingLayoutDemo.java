import javax.swing.*;
import java.awt.*;

public class SwingLayoutDemo {

    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Swing Components & Layout Managers");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set BorderLayout for frame
        frame.setLayout(new BorderLayout(10, 10));

        // ===== NORTH (FlowLayout) =====
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(new JLabel("Enter Name:"));
        topPanel.add(new JTextField(15));
        frame.add(topPanel, BorderLayout.NORTH);

        // ===== CENTER (GridLayout) =====
        JPanel centerPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        centerPanel.setBorder(BorderFactory.createTitledBorder("Options"));

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

        centerPanel.add(new JLabel("Course:"));
        JComboBox<String> courseBox = new JComboBox<>(
                new String[]{"Java", "Python", "C++"}
        );
        centerPanel.add(courseBox);

        centerPanel.add(new JLabel("Subscribe:"));
        JCheckBox subscribe = new JCheckBox("Yes");
        centerPanel.add(subscribe);

        frame.add(centerPanel, BorderLayout.CENTER);

        // ===== SOUTH (FlowLayout) =====
        JPanel bottomPanel = new JPanel(new FlowLayout());
        JButton submitBtn = new JButton("Submit");
        JButton resetBtn = new JButton("Reset");
        bottomPanel.add(submitBtn);
        bottomPanel.add(resetBtn);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Make frame visible
        frame.setVisible(true);
    }
}
