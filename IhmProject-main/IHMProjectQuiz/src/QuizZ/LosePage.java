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
	 public LosePage() {
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
	                ImageIcon icon = new ImageIcon("/root/eclipse-workspace/IhmProject-main/assets/youlose3.png");
	                Image img = icon.getImage();
	                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	            }
	        };
	        mainPanel.setLayout(null);


	        // Start button

	        JButton startButton = new JButton("home");//creat button
	        startButton.setFont(new  Font("Tahoma", Font.BOLD , 16)); // Set font to Arial, bold, size 16
	        startButton.setBounds(70,300,80,30);//x=lignposition y=vertecalposition ,wight, height
	        //try again button 
	        JButton TryAgainButton = new JButton("ty again");//creat button
	        TryAgainButton.setFont(new  Font("Tahoma", Font.BOLD , 16)); // Set font to Arial, bold, size 16
	        TryAgainButton.setBounds(440,300,100,30);//x=lignposition y=vertecalposition ,wight, height
	        //costimize the buttons
	        Color customColor = Color.decode("#ffdc70");
	        startButton.setBackground(customColor);
	        TryAgainButton.setBackground(customColor);
	        Color textColor = Color.decode("#0b4272");//set the text in the button to 
	        startButton.setForeground(textColor);
	        TryAgainButton.setForeground(textColor);
	        //backround yellow
	        //border blue
	        
	        //creat scor label
	        JLabel displayscore=new JLabel("0");
	        displayscore.setFont(new Font("Arial", Font.BOLD, 28));
	        displayscore.setForeground(Color.decode("#0b4272")); // Title text color
	        displayscore.setBounds(340, 290, 200, 40); // Position for the title
	        JLabel score = new JLabel("score :");
	        score.setFont(new Font("Arial", Font.BOLD, 28));
	        score.setForeground(Color.decode("#0b4272")); // Title text color
	        score.setBounds(220, 290, 200, 40); 
	        mainPanel.add(score);
	        
	        mainPanel.add(displayscore);
	        
	        
	        this.add(startButton);//set visibilite de button
	        this.add(TryAgainButton);
	        startButton.addActionListener(e -> {
	           
	            new Homepage().setVisible(true);
	            this.dispose(); // Close Homepage
	        });
	        TryAgainButton.addActionListener(e -> {
		           
	            new ChoosingPage().setVisible(true);
	            this.dispose(); // Close Homepage
	        });

	        // Add main panel to frame
	        add(mainPanel);
	    }

	    
}
