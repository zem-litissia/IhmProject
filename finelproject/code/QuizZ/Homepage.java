package QuizZ;
import javax.swing.*;
import java.awt.*;

public class Homepage extends JFrame {
    
    public Homepage() {
        super("Quiz Application");
        initUI();
    }

    private void initUI() {
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);
        
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon("D:/ihmproject/assets/img/homepage.png");
                Image img = icon.getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        mainPanel.setLayout(new BorderLayout());


        // Start button
        JButton startButton = new JButton("Start");//creat button
        startButton.setFont(new  Font("Tahoma", Font.BOLD , 16)); // Set font to Arial, bold, size 16
        startButton.setBounds(220,320,150,30);//x=lignposition y=vertecalposition ,wight, height
        
        Color customColor = Color.decode("#ffdc70");
        startButton.setBackground(customColor);//for the backround yellow
        
        Color textColor = Color.decode("#0b4272");//the text in the button to blue
        startButton.setForeground(textColor);
        this.add(startButton);//set visibilite de button
        
        startButton.addActionListener(e -> {
           
            new ChoosingPage().setVisible(true);
            this.dispose(); // Close Homepage
        });

        // Add main panel to frame
        add(mainPanel);
    }

    
}
