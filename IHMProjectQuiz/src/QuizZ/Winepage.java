package QuizZ;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Winepage extends JFrame {
    public Winepage(int correctAnswers) { // Accept correctAnswers as a parameter
        super("Quiz Application");
        initUI(correctAnswers);
    }

    private void initUI(int correctAnswers) {
        // Set frame properties
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        // Main panel with a background color
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon("D:/ihmproject/assets/img/youWin.png");
                Image img = icon.getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        mainPanel.setLayout(null);

        // "Home" button
        JButton startButton = new JButton("Home");
        startButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        startButton.setBounds(70, 300, 80, 30);

        // "Try Again" button
        JButton tryAgainButton = new JButton("Try Again");
        tryAgainButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        tryAgainButton.setBounds(440, 300, 110, 30);

        // Customize button colors
        Color customColor = Color.decode("#ffdc70");
        startButton.setBackground(customColor);
        tryAgainButton.setBackground(customColor);
        Color textColor = Color.decode("#0b4272");
        startButton.setForeground(textColor);
        tryAgainButton.setForeground(textColor);

        // Display the score
        JLabel scoreLabel = new JLabel("Score: " + correctAnswers); // Show the correctAnswers
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 28));
        scoreLabel.setForeground(Color.decode("#0b4272"));
        scoreLabel.setBounds(220, 290, 200, 40);

        mainPanel.add(scoreLabel);

        // Add action listeners to buttons
        startButton.addActionListener(e -> {
            new Homepage().setVisible(true);
            this.dispose(); // Close the current page
        });

        tryAgainButton.addActionListener(e -> {
            new ChoosingPage().setVisible(true);
            this.dispose(); // Close the current page
        });

        // Add buttons and panel
        mainPanel.add(startButton);
        mainPanel.add(tryAgainButton);
        add(mainPanel);
    }
}
