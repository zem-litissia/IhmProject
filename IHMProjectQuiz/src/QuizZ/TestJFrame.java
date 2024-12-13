package QuizZ;

import javax.swing.SwingUtilities;

public class TestJFrame {

	public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	Homepage frame = new Homepage();
            frame.setVisible(true);
        });
    }

}