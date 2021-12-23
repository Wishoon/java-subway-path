package subway.domain.section;

import java.util.List;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import subway.domain.station.Station;

public class SectionService {
	private static final int ZERO = 0;

	public static List<Station> findDistanceShortPath(Station startStation, Station endStation) {
		isValidateSameStation(startStation, endStation);
		WeightedMultigraph<Station, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
		List<Section> sections = SectionRepository.sections();
		sections.stream()
			.forEach(section -> section.updateDistanceGraph(graph));

		return calculateDistanceShortPath(startStation, endStation, graph);
	}

	private static List<Station> calculateDistanceShortPath(Station startStation, Station endStation,
		WeightedMultigraph<Station, DefaultWeightedEdge> graph) {
		try {
			DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
			List<Station> shortPath = dijkstraShortestPath.getPath(startStation, endStation).getVertexList();

			return shortPath;
		} catch (NullPointerException e) {
			throw new IllegalArgumentException(startStation.getName() + ", " +
				endStation.getName() + "은 연결되어 있지 않습니다.");
		}
	}

	public static List<Station> findTimeShortPath(Station startStation, Station endStation) {
		isValidateSameStation(startStation, endStation);
		WeightedMultigraph<Station, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
		List<Section> sections = SectionRepository.sections();
		sections.stream()
			.forEach(section -> section.updateTimeGraph(graph));

		return calculateTimeShortPath(startStation, endStation, graph);
	}

	private static List<Station> calculateTimeShortPath(Station startStation, Station endStation,
		WeightedMultigraph<Station, DefaultWeightedEdge> graph) {
		try {
			DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
			List<Station> shortPath = dijkstraShortestPath.getPath(startStation, endStation).getVertexList();

			return shortPath;
		} catch (NullPointerException e) {
			throw new IllegalArgumentException(e);
		}
	}

	private static void isValidateSameStation(Station startStation, Station endStation) {
		if (startStation.equals(endStation)) {
			throw new IllegalArgumentException(startStation.getName() + ", " +
				endStation.getName() + "은 연결되어 있지 않습니다.");
		}
	}

	public static int calculateTotalDistance(List<Station> path) {
		List<Section> sections = SectionRepository.sections();

		int totalDistance = ZERO;
		for (int i = 0; i < path.size() - 1; i++) {
			totalDistance += getDistance(path.get(i), path.get(i + 1), sections);
		}

		return totalDistance;
	}

	private static int getDistance(Station startStation, Station endStation, List<Section> sections) {
		for (Section section : sections) {
			if (section.isEqualTo(startStation, endStation)) {
				return section.getDistance();
			}
		}

		return ZERO;
	}

	public static int calculateTotalTime(List<Station> path) {
		List<Section> sections = SectionRepository.sections();

		int totalTime = ZERO;
		for (int i = 0; i < path.size() - 1; i++) {
			totalTime += getTime(path.get(i), path.get(i + 1), sections);
		}

		return totalTime;
	}

	private static int getTime(Station startStation, Station endStation, List<Section> sections) {
		for (Section section : sections) {
			if (section.isEqualTo(startStation, endStation)) {
				return section.getTime();
			}
		}

		return ZERO;
	}
}
