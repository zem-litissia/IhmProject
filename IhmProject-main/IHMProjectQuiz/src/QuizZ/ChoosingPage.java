package QuizZ;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChoosingPage extends JFrame {
	public ChoosingPage() {
        super("choosing Page");
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
                ImageIcon icon = new ImageIcon("/root/eclipse-workspace/IhmProject-main/assets/ChoosingPage2.png");
                Image img = icon.getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        mainPanel.setLayout(new BorderLayout());


        // Start button

        JButton home = new JButton("home");//creat button
        home.setFont(new  Font("Tahoma", Font.BOLD , 16)); // Set font to Arial, bold, size 16
        home.setBounds(50,240,100,30);//x=lignposition y=vertecalposition ,wight, height
        
        Color customColor = Color.decode("#ffdc70");//set the button bckround to #ffdc70
        home.setBackground(customColor);
        
        Color textColor = Color.decode("#0b4272");//set the text in the button to #0b4272
        home.setForeground(textColor);
        
        //backround yellow
        //border blue
        this.add(home);//set visibilite de button
        home.addActionListener(e -> {
            
            new Homepage().setVisible(true);
            this.dispose(); // Close Homepage
        });
       
       
       

       JButton about = new JButton("about");//creat button
       about.setFont(new  Font("Tahoma", Font.BOLD , 16)); // Set font to Arial, bold, size 16
       about.setBounds(450,240,100,30);//x=lignposition y=vertecalposition ,wight, height
       
       Color customsColor = Color.decode("#ffdc70");//set the button bckround to #ffdc70
       about.setBackground(customsColor);
       
       Color textsColor = Color.decode("#0b4272");//set the text in the button to #0b4272
       about.setForeground(textsColor);
       
       //backround yellow
       //border blue
       this.add(about);//set visibilite de button
       
       about.addActionListener(e -> {
           
           new AboutPage().setVisible(true);
           this.dispose(); // Close Homepage
       });
      
      
      

      JButton funnyquiz = new JButton("funnyquiz");//creat button
      funnyquiz.setFont(new  Font("Tahoma", Font.BOLD , 16)); // Set font to Arial, bold, size 16
      funnyquiz.setBounds(220,200,150,30);//x=lignposition y=vertecalposition ,wight, height
      
      Color customssColor = Color.decode("#ffdc70");//set the button bckround to #ffdc70
      funnyquiz.setBackground(customssColor);
      
      Color textssColor = Color.decode("#0b4272");//set the text in the button to #0b4272
      funnyquiz.setForeground(textssColor);
      
      //backround yellow
      //border blue
      this.add(funnyquiz);//set visibilite de button
      funnyquiz.addActionListener(e -> JOptionPane.showMessageDialog(this, "Start Quiz!"));
     //action de button 
     
     
     

     JButton csquiz = new JButton("csquiz");//creat button
     csquiz.setFont(new  Font("Tahoma", Font.BOLD , 16)); // Set font to Arial, bold, size 16
     csquiz.setBounds(220,280,150,30);//x=lignposition y=vertecalposition ,wight, height
     
     Color customsssColor = Color.decode("#ffdc70");//set the button bckround to #ffdc70
     csquiz.setBackground(customsssColor);
     
     Color textsssColor = Color.decode("#0b4272");//set the text in the button to #0b4272
     csquiz.setForeground(textsssColor);
     
     //backround yellow
     //border blue
     this.add(csquiz);//set visibilite de button
     csquiz.addActionListener(e -> JOptionPane.showMessageDialog(this, "Start Quiz!"));
    //action de button 

        // Add main panel to frame
        add(mainPanel);
    }

    
}
