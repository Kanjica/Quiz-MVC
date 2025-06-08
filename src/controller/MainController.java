package controller;

import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import util.UIUtils;
import view.GameModesView;
import view.InitialScreenView;
import view.QuizView;
import view.ResultsView;
import view.ThemeSelectionView;
import view.TransitionPanel;

public class MainController {
	 private JFrame mainFrame;
	 private TransitionPanel transitionPanel;
	 
	 private InitialScreenController initialScreenController;
	 private GameModesController gameModesController;
	 private ThemeSelectionController themeSelectionController;
	 private QuizController quizController;
	 private ResultsController resultsController;
	 
	 public MainController() {
		 
		//------------------------- Registrando fontes
		 try {
			 InputStream is = UIUtils.class.getResourceAsStream("/assets/fonts/Perfect Delight 1992.otf");
			 System.out.println("InputStream é null? " + (is == null));

			 UIUtils.registrarFonte("/assets/fonts/Perfect Delight 1992.otf");
			 UIUtils.registrarFonte("/assets/fonts/Minecraftia-Regular.ttf");
			 UIUtils.registrarFonte("/assets/fonts/SpecialExit.ttf");
			 System.out.println("Teste imagem: " + UIUtils.class.getResource("/assets/images/alien_background.gif"));
			 System.out.println("Teste fonte: " + UIUtils.class.getResource("/assets/font/Perfect Delight 1992.otf"));
		 } catch (FontFormatException | IOException e) {
			 e.printStackTrace();
		 }
		 
		//------------------------- Trocando o look and fell padrão pelo Nimbus
		 try {
		    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }

		 } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
		    e.printStackTrace();
		 }
		 
		 //------------------------- Settando as fontes
		 UIManager.put("Button.font", UIUtils.obterFonte("/font/Minecraftia 2.0.ttf",20f));
         UIManager.put("Label.font", UIUtils.obterFonte("/font/Minecraftia 2.0.ttf",20f));
         UIManager.put("TextField.font", UIUtils.obterFonte("/font/Minecraftia 2.0.ttf",20f));
         UIManager.put("TextArea.font", UIUtils.obterFonte("/font/Minecraftia 2.0.ttf",20f));
         UIManager.put("CheckBox.font", UIUtils.obterFonte("/font/Minecraftia 2.0.ttf",20f));
         
         //------------------------- Inicializando o mainFrame
		 this.mainFrame = new JFrame("Quiz Game");
		 this.mainFrame.setSize(580, 400);
		 this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.mainFrame.setLocationRelativeTo(null);
		 this.mainFrame.setResizable(true);
		 
		 this.transitionPanel = new TransitionPanel();
		 this.mainFrame.setContentPane(this.transitionPanel);
		 
		 //------------------------- Inicializando as view's
		 InitialScreenView initialScreenView = new InitialScreenView(
				 new ImageIcon(MainController.class.getResource(
						 "/assets/images/start_screen_background.jpg")).getImage());
		 
		 GameModesView gameModesView = new GameModesView(
				 new ImageIcon(MainController.class.getResource(
						 "/assets/images/start_screen_background.jpg")).getImage());
		 
		 ThemeSelectionView themeSelectionView = new ThemeSelectionView(
				 new ImageIcon(MainController.class.getResource(
						 "/assets/images/theme_selection_background.jpg")).getImage());
		 
		 QuizView quizView = new QuizView(
				 new ImageIcon(MainController.class.getResource(
						 "/assets/images/alien_background.jpg")).getImage());
		 
		 ResultsView resultsView = new ResultsView(
				 new ImageIcon(MainController.class.getResource(
						 "/assets/images/start_screen_background.jpg")).getImage());
		 
		//------------------------- Inicializando os controller's
		 this.initialScreenController = new InitialScreenController(this, initialScreenView);
	     this.gameModesController = new GameModesController(this, gameModesView);
		 this.themeSelectionController = new ThemeSelectionController(this, themeSelectionView);
		 this.quizController = new QuizController(this, quizView);
		 this.resultsController = new ResultsController(this, resultsView);
		 
		//------------------------- Settando os controller's das view's
		 initialScreenView.setController(initialScreenController);
		 gameModesView.setController(gameModesController);
		 themeSelectionView.setController(themeSelectionController);
		 quizView.setController(quizController);
		 resultsView.setController(resultsController);  
	     
		 this.transitionPanel.setPanel(initialScreenView);
		 

		 this.mainFrame.setVisible(true);
		 showInitialScreen();
	 }
	 
	 public void showInitialScreen() {//-1, voltando no caso
		 transitionPanel.transitionTo(initialScreenController.getView(), -1);
	 }
	 
	 public void showGameModesScreen() {
		 transitionPanel.transitionTo(gameModesController.getView(), 1);
	 }
	 
	 public void showThemeSelectionScreen() {
		 transitionPanel.transitionTo(themeSelectionController.getView(), 1);
	 }
	 
	 public void showQuizScreen() {
        //vou precisar passar os temas selecionados caso tenha
	 }
	 
	 public void showResultsScreen() {
		 transitionPanel.transitionTo(resultsController.getView(), 1);
	 }
	 
	 public void exitApplication() {
	        mainFrame.dispose(); 
	        System.exit(0);     
	    }
	 
}
