package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import controller.ResultsController;

public class ResultsView extends JPanel{
	private ResultsController controller;
	private Image backgroundImage;
	
	public ResultsView(Image backgroundImage) {
		this.backgroundImage = backgroundImage;
	}
	
	public ResultsController getController() {
		return controller;
	}


	public void setController(ResultsController controller) {
		this.controller = controller;
	}


	@Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

    }	
}
