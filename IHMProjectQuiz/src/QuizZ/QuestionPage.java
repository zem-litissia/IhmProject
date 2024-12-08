package QuizZ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuestionPage extends JFrame {
    private int current = 0; // Track the current question
    private int correctAnswers = 0; // Track correct answers

    private JLabel label; // Label for questions
    private JRadioButton[] radioButton = new JRadioButton[4]; // Radio buttons for options
    private ButtonGroup bg = new ButtonGroup(); // ButtonGroup for grouping options

    private String[] questions = {
        "1. What is the primary purpose of an operating system?",
        "2. What does 'HTML' stand for in web development?",
        "3. Which data structure uses the LIFO (Last In, First Out) principle?",
        "4. What is the time complexity of searching for an element in a balanced binary search tree (BST)?",
        "5. In object-oriented programming (OOP), what is inheritance?",
        "6. Which of the following is NOT a valid programming language?",
        "7. Which algorithm is commonly used for finding the shortest path in a graph?",
        "8. What does SQL stand for?",
        "9. What is the function of a DNS (Domain Name System)?",
        "10. Which of the following is a type of NoSQL database?"
    };

    private String[][] options = {
        {"a) To manage hardware and software resources", "b) To run applications and games", "c) To perform mathematical calculations", "d) To design websites"},
        {"a) Hyper Text Markup Language", "b) High-level Technical Machine Language", "c) Hyperlink Text Manipulation Language", "d) Home Tool Markup Language"},
        {"a) Queue", "b) Stack", "c) Linked list", "d) Array"},
        {"a) O(1)", "b) O(log n)", "c) O(n)", "d) O(n log n)"},
        {"a) The process of creating new objects from existing ones", "b) The ability to restrict access to class members", "c) The mechanism of hiding the complexity of an operation", "d) The ability for one class to inherit properties and methods of another class"},
        {"a) Python", "b) JavaScript", "c) Java", "d) InternetScript"},
        {"a) QuickSort", "b) MergeSort", "c) Dijkstra’s Algorithm", "d) Binary Search"},
        {"a) Structured Query Language", "b) Simple Query Language", "c) Sequential Query Logic", "d) Simple Query Logic"},
        {"a) To assign IP addresses to devices", "b) To convert domain names to IP addresses", "c) To send data packets to their destination", "d) To encrypt web traffic"},
        {"a) MySQL", "b) MongoDB", "c) Oracle Database", "d) PostgreSQL"}
    };

    private String[] correctAnswersArray = {
        "a", "a", "b", "b", "d", "d", "c", "a", "b", "b"
    };

    public QuestionPage() {
        super("Question Page");
        initUI();
    }

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
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setBounds(30, 60, 540, 40);
        mainPanel.add(label);

        int yPosition = 120;
        for (int i = 0; i < 4; i++) {
            radioButton[i] = new JRadioButton();
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
        nextButton.setBounds(440, 300, 110, 30);
        Color customColor = Color.decode("#ffdc70");
        nextButton.setBackground(customColor);
        nextButton.setForeground(Color.decode("#0b4272"));
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
                showNextQuestion(1);
            }
        });
        mainPanel.add(nextButton);

        add(mainPanel);
        showNextQuestion(0);
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
            JOptionPane.showMessageDialog(this, "Quiz Completed!");
            displayResult();
            return;
        }

        label.setText(questions[current]);
        for (int i = 0; i < 4; i++) {
            radioButton[i].setText(options[current][i]);
        }
        bg.clearSelection();
    }

    public int getCorrectAnswersCount() {
        return correctAnswers;
    }

    private void displayResult() {
        if (correctAnswers > 5) {
            new Winepage(getCorrectAnswersCount()).setVisible(true);
        } else {
            new LosePage(getCorrectAnswersCount()).setVisible(true);
        }
        dispose();
    }
}
