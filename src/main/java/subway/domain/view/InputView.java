package subway.domain.view;

import java.util.Scanner;

public class InputView {
	private static final String LINE_SEPARATOR = System.lineSeparator();

	public static String getInputStartStation() {
		System.out.println("## 출발역을 입력하세요.");
		final String input = new Scanner(System.in).nextLine();
		System.out.print(LINE_SEPARATOR);
		return input;
	}

	public static String getInputEndStation() {
		System.out.println("## 도착역을 입력하세요.");
		final String input = new Scanner(System.in).nextLine();
		System.out.print(LINE_SEPARATOR);
		return input;
	}

	public static String getInputFunction() {
		System.out.println("## 원하는 기능을 선택하세요.");
		final String command = new Scanner(System.in).nextLine();
		System.out.print(LINE_SEPARATOR);
		return command;
	}
}
