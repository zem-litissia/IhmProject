package QuizZ;

import javax.swing.SwingUtilities;

public class TestJFrame {

	public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	Homepage frame = new Homepage();
            frame.setVisible(true);
//        	AboutPage about=new AboutPage();
//        	about.setVisible(true);
//            LosePage lose = new LosePage(0);
//            lose.setVisible(true);
//            QuestionPage question=new QuestionPage();
//            question.setVisible(true);
//            Winepage win = new Winepage(0);
//            win.setVisible(true);
//            
//            QuestionPage questionPage = new QuestionPage();
//            questionPage.setVisible(true);
        });
    }

}