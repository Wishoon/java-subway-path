package subway.domain.station;

import java.util.Objects;

public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public static Station from(String name) {
        return new Station(name);
    }

    public String getName() {
        return name;
    }

    public boolean equalsName(String name) {
        return this.name.equals(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Station))
            return false;
        Station station = (Station)o;
        return Objects.equals(name, station.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
