package subway.domain.line;

import java.util.List;

import subway.domain.station.Station;

public class Line {
    private String name;
    private List<Station> stations;

    public Line(String name) {
        this.name = name;
    }

    public void addStations(List<Station> stations) {
        stations.addAll(stations);
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
