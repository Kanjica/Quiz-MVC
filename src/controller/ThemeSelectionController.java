package controller;

import view.ThemeSelectionView;

public class ThemeSelectionController {
	private MainController controller;
	private ThemeSelectionView view;
	
	public ThemeSelectionController(MainController controller, ThemeSelectionView view) {
		this.controller = controller;
		this.view = view;
	}

	public MainController getController() {
		return controller;
	}

	public void setController(MainController controller) {
		this.controller = controller;
	}

	public ThemeSelectionView getView() {
		return view;
	}

	public void setView(ThemeSelectionView view) {
		this.view = view;
	}
	
}
