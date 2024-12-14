package QuizZ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuestionPage extends JFrame {
    private int current = 0; // count the current question
    private int correctAnswers = 0; // count correct answers
    private int timeLeft = 10; //time
    private Timer timer; // Timer object from the timer swing
    private JLabel timerLabel; // Label for the timer
    private JLabel label; // Label for questions
    private JRadioButton[] radioButton = new JRadioButton[4]; // Radio buttons for options de quesion
    private ButtonGroup bg = new ButtonGroup(); // ButtonGroup for grouping options
//les question dans un array
    private String[] questions = {
    	    "1. What is an OS's main purpose?",
    	    "2. What does 'HTML' stand for?",
    	    "3. Which structure uses LIFO?",
    	    "4. Time complexity for searching in BST?",
    	    "5. What is inheritance in OOP?",
    	    "6. Which is NOT a programming language?",
    	    "7. Algorithm for shortest path in a graph?",
    	    "8. What does SQL mean?",
    	    "9. Function of DNS?",
    	    "10. Example of a NoSQL database?"
    	};
//les option de question dans array
    private String[][] options = {
    	    {"a) Manage hardware/software", "b) Run apps and games", "c) Perform calculations", "d) Design websites"},
    	    {"a) Hyper Text Markup Language", "b) High-level Machine Language", "c) Hyperlink Manipulation Language", "d) Home Tool Markup Language"},
    	    {"a) Queue", "b) Stack", "c) Linked list", "d) Array"},
    	    {"a) O(1)", "b) O(log n)", "c) O(n)", "d) O(n log n)"},
    	    {"a) Create objects from others", "b) Restrict access to members", "c) Hide complexity of operations", "d) Inherit properties and methods"},
    	    {"a) Python", "b) JavaScript", "c) Java", "d) InternetScript"},
    	    {"a) QuickSort", "b) MergeSort", "c) Dijkstra's Algorithm", "d) Binary Search"},
    	    {"a) Structured Query Language", "b) Simple Query Language", "c) Sequential Query Logic", "d) Simple Query Logic"},
    	    {"a) Assign IP addresses", "b) Convert domain names to IPs", "c) Send data packets", "d) Encrypt web traffic"},
    	    {"a) MySQL", "b) MongoDB", "c) Oracle Database", "d) PostgreSQL"}
    	};
//answers
    	private String[] correctAnswersArray = {
    	    "a", "a", "b", "b", "d", "d", "c", "a", "b", "b"
    	};


    public QuestionPage() {
        super("CS Quiz");
        initUI();
    }

    private void initUI() {
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // background image
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
        //label de question
        label = new JLabel();
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setBounds(30, 60, 540, 40);
        mainPanel.add(label);
        //label de timer
        timerLabel = new JLabel();
        timerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        timerLabel.setBounds(480, 20, 100, 30);
        timerLabel.setForeground(Color.GREEN);
        mainPanel.add(timerLabel);
        //les option des question 
        int yPosition = 120;
        for (int i = 0; i < 4; i++) {
            radioButton[i] = new JRadioButton();
            radioButton[i].setForeground(Color.WHITE);
            radioButton[i].setFont(new Font("Arial", Font.PLAIN, 16));
            radioButton[i].setBounds(30, yPosition, 540, 30);
            radioButton[i].setOpaque(false);  // Make the background transparent
            radioButton[i].setBackground(new Color(0, 0, 0, 0));  // Optional: Set transparent background
            bg.add(radioButton[i]);
            mainPanel.add(radioButton[i]);
            yPosition += 40;
        }

        // Next button
        JButton nextButton = new JButton("Next");
        nextButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        nextButton.setBounds(350, 300, 80, 30);
        Color customColor = Color.decode("#ffdc70");
        nextButton.setBackground(customColor);
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
        timeLeft = 10; 
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
                selectedAnswer = radioButton[i].getText().substring(0, 1); // get the first letter 'a', 'b', 'c', or 'd'
            }
        }
        if (selectedAnswer.equals(correctAnswersArray[current])) {
            correctAnswers++;
        }
    }

    private void showNextQuestion(int direction) {
        current += direction;

        if (current < 0) {
            current = 0;
            return;
        } else if (current >= questions.length) {
            current = questions.length - 1;
            displayResult();
            return;
        }

        label.setText(questions[current]);
        for (int i = 0; i < 4; i++) {
            radioButton[i].setText(options[current][i]);
        }
        bg.clearSelection();
        startTimer();
    }

    public int getCorrectAnswersCount() {
        return correctAnswers;
    }

    private void displayResult() {
        if (correctAnswers >= 5) {
            new Winepage(getCorrectAnswersCount()).setVisible(true);
        } else {
            new LosePage(getCorrectAnswersCount()).setVisible(true);
        }
        dispose();
    }
}
