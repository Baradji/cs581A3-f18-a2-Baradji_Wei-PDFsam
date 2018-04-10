package org.pdfsam;


import javafx.stage.Stage;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import org.pdfsam.ui.StageStatus;
import java.util.Optional;

public class WindowStatusControllerProduct {
	private Stage stage;

	public void defaultStageStatus() {
		Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
		stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
		stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 4);
		stage.setMaximized(true);
	}

	public void setStage(Stage stage, WindowStatusController windowStatusController) {
		this.stage = stage;
		windowStatusController.initUi();
	}

	public void restore(StageStatus latestStatus) {
		stage.setX(latestStatus.getX());
		stage.setY(latestStatus.getY());
		stage.setWidth(latestStatus.getWidth());
		stage.setHeight(latestStatus.getHeight());
		if (isNotMac()) {
			latestStatus.getMode().restore(stage);
		}
	}

	public boolean isNotMac() {
		return !Optional.of(System.getProperty("os.name")).orElse("").toLowerCase().contains("mac");
	}
}