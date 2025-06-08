package view;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import controller.InitialScreenController;

public class InitialScreenView extends JPanel{
	private InitialScreenController controller;
	private Image backgroundImage;
	
	public InitialScreenView(Image backgroundImage) {
		this.backgroundImage = backgroundImage;
		
		setLayout(new BorderLayout());
	}
	
	public InitialScreenController getController() {
		return controller;
	}


	public void setController(InitialScreenController controller) {
		this.controller = controller;
	}


	@Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

    }
}
