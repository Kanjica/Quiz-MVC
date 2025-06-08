package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import controller.GameModesController;

public class GameModesView extends JPanel{
	private GameModesController controller;
	private Image backgroundImage;
	
	public GameModesView(Image backgroundImage) {
		this.backgroundImage = backgroundImage;
	}
	
	public GameModesController getController() {
		return controller;
	}


	public void setController(GameModesController controller) {
		this.controller = controller;
	}


	@Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

    }
}
