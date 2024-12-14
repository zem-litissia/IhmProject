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

public class LosePage extends JFrame {
    public LosePage(int correctAnswers) {
        super("Quiz Application");
        initUI(correctAnswers);
    }

    private void initUI(int correctAnswers) {
        // Set frame properties
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Main panel with a background color
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon("D:/ihmproject/assets/img/losepage.png");
                Image img = icon.getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        mainPanel.setLayout(null);

        // "Home" button
        JButton startButton = new JButton("Home");
        startButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        startButton.setBounds(40, 300, 100, 30);
        Color customColor = Color.decode("#ffdc70");
        startButton.setBackground(customColor);
        startButton.setForeground(Color.decode("#0b4272"));

        // "Try Again" button
        JButton tryAgainButton = new JButton("Try Again");
        tryAgainButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        tryAgainButton.setBounds(440, 300, 110, 30);
        tryAgainButton.setBackground(customColor);
        tryAgainButton.setForeground(Color.decode("#0b4272"));

        // Score label
        JLabel scoreLabel = new JLabel("Score: " + correctAnswers);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 28));
        scoreLabel.setForeground(Color.decode("#ffdc70"));
        scoreLabel.setBounds(240, 290, 200, 40);

        // Add components to the main panel
        mainPanel.add(scoreLabel);
        mainPanel.add(startButton);
        mainPanel.add(tryAgainButton);

        // Button actions
        startButton.addActionListener(e -> {
            new Homepage().setVisible(true);
            this.dispose(); // Close LosePage
        });

        tryAgainButton.addActionListener(e -> {
            new ChoosingPage().setVisible(true);
            this.dispose(); // Close LosePage
        });

        // Add the main panel to the frame
        add(mainPanel);
    }
}
