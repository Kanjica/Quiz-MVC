package controller;

import view.QuizView;

public class QuizController {
	private MainController controller;
	private QuizView view;
	
	public QuizController(MainController controller, QuizView view) {
		this.controller = controller;
		this.view = view;
	}

	public MainController getController() {
		return controller;
	}

	public void setController(MainController controller) {
		this.controller = controller;
	}

	public QuizView getView() {
		return view;
	}

	public void setView(QuizView view) {
		this.view = view;
	}
	
	
}
