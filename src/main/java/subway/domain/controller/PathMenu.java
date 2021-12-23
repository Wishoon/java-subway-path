package subway.domain.controller;

import java.util.Arrays;

public enum PathMenu {
	SHORT_DISTANCE("1", PathHandler::shortDistanceManage),
	MINIMUM_TIME("2", PathHandler::minimumTimeManage),
	BACK("B", PathHandler::backMain);

	private final String command;
	private final Runnable runnable;

	PathMenu(String command, Runnable runnable) {
		this.command = command;
		this.runnable = runnable;
	}

	public static PathMenu findCommand(String command) {
		return Arrays.stream(PathMenu.values())
			.filter(pathMenu -> pathMenu.command.equals(command))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("해당하는 명령 키워드가 없습니다."));
	}

	public void run() {
		this.runnable.run();
	}
}
