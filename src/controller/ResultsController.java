package controller;

import view.ResultsView;

public class ResultsController {
	private ResultsView view;
	private MainController controller;
	
	public ResultsController(MainController controller, ResultsView view) {
		this.controller = controller;
		this.view = view;
	}

	public ResultsView getView() {
		return view;
	}

	public void setView(ResultsView view) {
		this.view = view;
	}

	public MainController getController() {
		return controller;
	}

	public void setController(MainController controller) {
		this.controller = controller;
	}
	
	
}
