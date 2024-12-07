package QuizZ;
import javax.swing.*;
import java.awt.*;

public class Homepage extends JFrame {
    
    public Homepage() {
        super("Quiz Application");
        initUI();
    }

    private void initUI() {
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
                ImageIcon icon = new ImageIcon("/root/eclipse-workspace/IhmProject-main/assets/ihmproject6.png");
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
        startButton.setBackground(customColor);
        
        Color textColor = Color.decode("#0b4272");//set the text in the button to 
        startButton.setForeground(textColor);
        
        //backround yellow
        //border blue
        this.add(startButton);//set visibilite de button
        
        startButton.addActionListener(e -> {
           
            new ChoosingPage().setVisible(true);
            this.dispose(); // Close Homepage
        });

        // Add main panel to frame
        add(mainPanel);
    }

    
}
