package subway.domain.view;

import java.util.List;

import subway.domain.station.Station;

public class OutputView {
	private static final String ERROR = "[ERROR] ";
	private static final String INFO = "[INFO] ";
	private static final String TOTAL_DISTANCE = "총 거리: ";
	private static final String TOTAL_TIME = "총 소요 시간: ";
	private static final String KILOMETER = "km";
	private static final String MINUTE = "분";
	private static final String LINE_SEPARATOR = System.lineSeparator();

	public static void printMainPageMessage() {
		System.out.println("## 메인 화면");
		System.out.println("1. 경로 조회" + LINE_SEPARATOR + "Q. 종료");
		System.out.print(LINE_SEPARATOR);
	}

	public static void printErrorMessage(Exception e) {
		System.out.println(ERROR + e.getMessage());
		System.out.print(LINE_SEPARATOR);
	}

	public static void printPathPageMessage() {
		System.out.println("## 경로 기준");
		System.out.println("1. 최단 거리" + LINE_SEPARATOR + "2. 최소 시간" + LINE_SEPARATOR + "B. 돌아가기");
		System.out.print(LINE_SEPARATOR);
	}

	public static void printResultMessage(List<Station> path, int totalDistance, int totalTime) {
		System.out.println("## 조회 결과");
		System.out.println(INFO + "---");
		System.out.println(INFO + TOTAL_DISTANCE + totalDistance + KILOMETER);
		System.out.println(INFO + TOTAL_TIME + totalTime + MINUTE);
		System.out.println(INFO + "---");
		path.stream()
			.map(station -> INFO + station.getName())
			.forEach(System.out::println);
		System.out.print(LINE_SEPARATOR);
	}
}
