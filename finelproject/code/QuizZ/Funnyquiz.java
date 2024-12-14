package QuizZ;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Funnyquiz extends JFrame {
	 public Funnyquiz() {
	        super("Funnyquiz Page");
	        initUI();
	    }
    private int current = 0; // the current question
    private int correctAnswers = 0; // correct answers
    private int timeLeft = 10; // Time for the question use the swing timer
    private Timer timer; // Timer object fromswing timer

    private JLabel label; // Label for questions
    private JLabel timerLabel; // Label for the timer
    private JRadioButton[] radioButton = new JRadioButton[4]; // Radio buttons for options
    private ButtonGroup bg = new ButtonGroup(); // ButtonGroup for grouping options
//question
    private String[] funnyQuestions = {
        "1. What chases you but can't be seen?",
        "2. What has teeth but can't bite?",
        "3. What breaks but never falls?",
        "4. What gets bigger the more you take?",
        "5. What hears without ears and speaks without a tongue?",
        "6. What vanishes when you turn on the light?",
        "7. What is in your hand but belongs to others?",
        "8. What comes once in a minute, twice in a moment?",
        "9. What has keys but can't open locks?",
        "10. What has a head, tail, but no body?"
    };
//answers option
    private String[][] funnyOptions = {
        {"a) Shadow", "b) Air", "c) Light", "d) Camera"},
        {"a) Saw", "b) Clamps", "c) Comb", "d) Scissors"},
        {"a) Promise", "b) Glass", "c) Pen", "d) Stone"},
        {"a) Hole", "b) Book", "c) Clouds", "d) Sea"},
        {"a) Phone", "b) Echo", "c) Radio", "d) TV"},
        {"a) Stars", "b) Moon", "c) Clouds", "d) Darkness"},
        {"a) Watch", "b) Pen", "c) Key", "d) Phone"},
        {"a) The letter 'M'", "b) A blink", "c) A second", "d) A breath"},
        {"a) A piano", "b) A map", "c) A computer", "d) A phone"},
        {"a) A snake", "b) A coin", "c) A fish", "d) A pencil"}
    };
//answers
    private String[] funnyCorrectAnswers = {
        "a", "c", "a", "a", "b", "d", "c", "a", "a", "b"
    };

   

    private void initUI() {
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Main panel with a background image
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon("D:/ihmproject/assets/img/questionpage.png");
                Image img = icon.getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        mainPanel.setLayout(null);
        label = new JLabel();
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setBounds(30, 60, 540, 40);
        mainPanel.add(label);

        timerLabel = new JLabel();
        timerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        timerLabel.setBounds(480, 20, 100, 30);
        timerLabel.setForeground(Color.GREEN);

        mainPanel.add(timerLabel);

        int yPosition = 120;
        for (int i = 0; i < 4; i++) {
            radioButton[i] = new JRadioButton();
            radioButton[i].setForeground(Color.WHITE);
            radioButton[i].setFont(new Font("Arial", Font.PLAIN, 16));
            radioButton[i].setBounds(30, yPosition, 540, 30);
            radioButton[i].setOpaque(false);
            radioButton[i].setBackground(new Color(0, 0, 0, 0));
            bg.add(radioButton[i]);
            mainPanel.add(radioButton[i]);
            yPosition += 40;
        }

        // Next button
        JButton nextButton = new JButton("Next");
        nextButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        nextButton.setBounds(350, 300, 80, 30);
        nextButton.setBackground(Color.decode("#ffdc70"));
        nextButton.setForeground(Color.decode("#0b4272"));
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop(); // Stop timer on button click
                checkAnswer();
                showNextQuestion(1);

            }
        });
        mainPanel.add(nextButton);

        add(mainPanel);
        showNextQuestion(0);
    }

    private void startTimer() {
        timeLeft = 10; // Reset the time for each question
        timerLabel.setText("Time: " + timeLeft + "s");

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeLeft--;
                timerLabel.setText("Time: " + timeLeft + "s");
               
                if (timeLeft <= 0) {
                    timer.stop();
                    showNextQuestion(1);
                }
                if(timeLeft<5) {
                	timerLabel.setForeground(Color.RED);
                }else {
                	timerLabel.setForeground(Color.GREEN);
                }
                
            }
        });
        timer.start();
    }

    private void checkAnswer() {
        String selectedAnswer = "";
        for (int i = 0; i < 4; i++) {
            if (radioButton[i].isSelected()) {
                selectedAnswer = radioButton[i].getText().substring(0, 1); // Get the first letter 'a', 'b', 'c', or 'd'
            }
        }
        if (selectedAnswer.equals(funnyCorrectAnswers[current])) {
            correctAnswers++;
        }
    }

    private void showNextQuestion(int direction) {
        current += direction;
       
        if (current < 0) {
            current = 0;
            return;
        } else if (current >= funnyQuestions.length) {
            current = funnyQuestions.length - 1;
            displayResult();
            return;
        }

        label.setText(funnyQuestions[current]);
        for (int i = 0; i < 4; i++) {
            radioButton[i].setText(funnyOptions[current][i]);
        }
        bg.clearSelection();

        startTimer();
    }

    private void displayResult() {
        if (correctAnswers >= 5) {
            new Winepage(getCorrectAnswersCount()).setVisible(true);
        } else {
            new LosePage(getCorrectAnswersCount()).setVisible(true);
        }
        dispose();
    }

    public int getCorrectAnswersCount() {
        return correctAnswers;
    }
   
}
