package subway.domain.controller;

import subway.domain.view.InputView;
import subway.domain.view.OutputView;

public class MainHandler {

	public static void pathManage() {
		OutputView.printPathPageMessage();
		PathMenu.findCommand(InputView.getInputFunction()).run();
	}

	public static void programExit() {
		System.exit(0);
	}
}
