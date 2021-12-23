package subway;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import subway.domain.controller.MainMenu;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.section.Section;
import subway.domain.section.SectionRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.domain.view.InputView;
import subway.domain.view.OutputView;

public class SubwayController {
	public void run() {
		init();
		while (true) {
			try {
				OutputView.printMainPageMessage();
				MainMenu.findByCommand(InputView.getInputFunction()).run();
			} catch (IllegalArgumentException e) {
				OutputView.printErrorMessage(e);
			}
		}
	}

	public void init() {
		initStations();
		initLines();
	}

	private void initStations() {
		String stationsName = "교대역,강남역,역삼역,남부터미널역,양재역,양재시민의숲역,매봉역,부산역";
		Arrays.stream(stationsName.split(","))
			.map(Station::new)
			.forEach(station -> StationRepository.addStation(station));
	}

	private void initLines() {
		initTwoLine();
		initThreeLine();
		initShinbundangLine();
		initTestLine();
	}

	private void initTwoLine() {
		String stationsName = "교대역,강남역,역삼역";
		List<Station> stations = Arrays.stream(stationsName.split(","))
			.map(Station::new)
			.collect(Collectors.toList());

		Line line = new Line("2호선");
		line.addStations(stations);
		LineRepository.addLine(line);

		SectionRepository.addSection(Section.of(new Station("교대역"), new Station("강남역"), 2, 3));
		SectionRepository.addSection(Section.of(new Station("강남역"), new Station("역삼역"), 2, 3));
	}

	private void initThreeLine() {
		String stationsName = "교대역,남부터미널역,양재역,매봉역";
		List<Station> stations = Arrays.stream(stationsName.split(","))
			.map(Station::new)
			.collect(Collectors.toList());

		Line line = new Line("3호선");
		line.addStations(stations);
		LineRepository.addLine(line);

		SectionRepository.addSection(Section.of(new Station("교대역"), new Station("남부터미널역"), 3, 2));
		SectionRepository.addSection(Section.of(new Station("남부터미널역"), new Station("양재역"), 6, 5));
		SectionRepository.addSection(Section.of(new Station("양재역"), new Station("매봉역"), 1, 1));
	}

	private void initShinbundangLine() {
		String stationsName = "강남역,양재역,양재시민의숲역";
		List<Station> stations = Arrays.stream(stationsName.split(","))
			.map(Station::new)
			.collect(Collectors.toList());

		Line line = new Line("신분당선");
		line.addStations(stations);
		LineRepository.addLine(line);

		SectionRepository.addSection(Section.of(new Station("강남역"), new Station("양재역"), 2, 8));
		SectionRepository.addSection(Section.of(new Station("양재역"), new Station("양재시민의숲역"), 10, 3));
	}

	private void initTestLine() {
		String stationsName = "부산역,서면역";
		List<Station> stations = Arrays.stream(stationsName.split(","))
			.map(Station::new)
			.collect(Collectors.toList());

		Line line = new Line("10호선");
		line.addStations(stations);
		LineRepository.addLine(line);

		SectionRepository.addSection(Section.of(new Station("부산역"), new Station("서면역"), 1, 1));
	}
}
