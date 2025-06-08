package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import controller.ResultsController;
import controller.ThemeSelectionController;

public class ThemeSelectionView extends JPanel{
	private ThemeSelectionController controller;
	private Image backgroundImage;
	
	public ThemeSelectionView(Image backgroundImage) {
		this.backgroundImage = backgroundImage;
	}
	
	public ThemeSelectionController getController() {
		return controller;
	}


	public void setController(ThemeSelectionController controller) {
		this.controller = controller;
	}


	@Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

    }	
}
