package QuizZ;

import javax.swing.*;
import java.awt.*;

public class AboutPage extends JFrame {
    public AboutPage() {
        super("About Page");
        initUI();
    }

    private void initUI() {
        // Set frame properties
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Main panel with a custom background
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon("/root/eclipse-workspace/IhmProject-main/assets/About.png");
                Image img = icon.getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        mainPanel.setLayout(null); // Use null layout for manual positioning

        // Create labels for the title and paragraph
        JLabel H1 = new JLabel("About Us");
        H1.setFont(new Font("Arial", Font.BOLD, 28));
        H1.setForeground(Color.decode("#0b4272")); // Title text color
        H1.setBounds(340, 60, 200, 40); // Position for the title

        JLabel p = new JLabel(
            "<html><div style='text-align: center;'>Made by:<br>Tahraoui Bochra <br>Zemmour Litissia <br>L3 informatique G4</div></html>"
        );
        p.setFont(new Font("Tahoma", Font.PLAIN, 16));
        p.setForeground(Color.BLACK); // Paragraph text color
        p.setBounds(340, 140, 300, 80); // Position for the paragraph (centered)

        // Add labels to the main panel
        mainPanel.add(H1);
        mainPanel.add(p);

        // Create the "Home" button
        JButton home = new JButton("Home");
        home.setFont(new Font("Tahoma", Font.BOLD, 16));
        home.setBounds(70, 280, 100, 30); // Centered at the bottom
        home.setBackground(Color.decode("#ffdc70")); // Button background color
        home.setForeground(Color.decode("#0b4272")); // Button text color

        // Add action listener to return to Homepage
        home.addActionListener(e -> {
            new Homepage().setVisible(true); // Open Homepage
            this.dispose(); // Close AboutPage
        });

        // Add button to main panel
        mainPanel.add(home);

        // Add main panel to frame
        add(mainPanel);
    }}