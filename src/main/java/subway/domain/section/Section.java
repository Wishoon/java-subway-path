package subway.domain.section;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import subway.domain.station.Station;

public class Section {
	private Station from;
	private Station to;
	private int distance;
	private int time;

	public Section(Station from, Station to, int distance, int time) {
		this.from = from;
		this.to = to;
		this.distance = distance;
		this.time = time;
	}

	public static Section of(Station from, Station to, int distance, int time) {
		return new Section(from, to, distance, time);
	}

	public void updateDistanceGraph(WeightedMultigraph<Station, DefaultWeightedEdge> graph) {
		graph.addVertex(from);
		graph.addVertex(to);
		graph.setEdgeWeight(graph.addEdge(from, to), distance);
	}

	public void updateTimeGraph(WeightedMultigraph<Station, DefaultWeightedEdge> graph) {
		graph.addVertex(from);
		graph.addVertex(to);
		graph.setEdgeWeight(graph.addEdge(from, to), time);
	}

	public boolean isEqualTo(Station startStation, Station endStation) {
		return this.from.equals(startStation) && this.to.equals(endStation);
	}

	public int getDistance() {
		return distance;
	}

	public int getTime() {
		return time;
	}
}