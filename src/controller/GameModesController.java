package controller;

import view.GameModesView;

public class GameModesController {
	private MainController controller;
	private GameModesView view;
	
	public GameModesController(MainController controller, GameModesView view) {
		this.controller = controller;
		this.view = view;
	}

	public MainController getController() {
		return controller;
	}

	public void setController(MainController controller) {
		this.controller = controller;
	}

	public GameModesView getView() {
		return view;
	}

	public void setView(GameModesView view) {
		this.view = view;
	}
	
	
}
