package subway.domain.controller;

import java.util.List;

import subway.domain.section.SectionService;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.domain.view.InputView;
import subway.domain.view.OutputView;

public class PathHandler {

	public static void shortDistanceManage() {
		Station startStation = StationRepository.findStation(InputView.getInputStartStation());
		Station endStation = StationRepository.findStation(InputView.getInputEndStation());

		final List<Station> path = SectionService.findDistanceShortPath(startStation, endStation);
		final int totalDistance = SectionService.calculateTotalDistance(path);
		final int totalTime = SectionService.calculateTotalTime(path);

		OutputView.printResultMessage(path, totalDistance, totalTime);
	}
	
	public static void minimumTimeManage() {
		Station startStation = StationRepository.findStation(InputView.getInputStartStation());
		Station endStation = StationRepository.findStation(InputView.getInputEndStation());

		final List<Station> path = SectionService.findTimeShortPath(startStation, endStation);
		final int totalDistance = SectionService.calculateTotalDistance(path);
		final int totalTime = SectionService.calculateTotalTime(path);

		OutputView.printResultMessage(path, totalDistance, totalTime);
	}

	public static void backMain() {
		return;
	}
}
