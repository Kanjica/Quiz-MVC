package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import controller.QuizController;

public class QuizView extends JPanel{
	private QuizController controller;
	private Image backgroundImage;
	
	public QuizView(Image backgroundImage) {
		this.backgroundImage = backgroundImage;
	}
	
	public QuizController getController() {
		return controller;
	}


	public void setController(QuizController controller) {
		this.controller = controller;
	}


	@Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

    }
}
