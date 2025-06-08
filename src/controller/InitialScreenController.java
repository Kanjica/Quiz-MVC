package controller;

import view.InitialScreenView;

public class InitialScreenController{
	private MainController controller;
	private InitialScreenView view;
	
	public InitialScreenController(MainController controller, InitialScreenView view) {
		this.controller = controller;
		this.view = view;
	}

	public MainController getController() {
		return controller;
	}

	public void setController(MainController controller) {
		this.controller = controller;
	}

	public InitialScreenView getView() {
		return view;
	}

	public void setView(InitialScreenView view) {
		this.view = view;
	}
	
	
}
