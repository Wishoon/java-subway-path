package subway.domain.controller;

import java.util.Arrays;

public enum MainMenu {
	PATH_INQUIRY("1", MainHandler::pathManage),
	EXIT("2", MainHandler::programExit);

	private final String command;
	private final Runnable runnable;

	MainMenu(String command, Runnable runnable) {
		this.command = command;
		this.runnable = runnable;
	}

	public static MainMenu findByCommand(String command) {
		return Arrays.stream(MainMenu.values())
			.filter(mainMenu -> mainMenu.command.equals(command))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("해당하는 명령 키워드가 없습니다."));
	}

	public void run() {
		this.runnable.run();
	}
}
