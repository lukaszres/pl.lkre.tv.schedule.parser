package pl.lkre.tv.schedule.model;

import lombok.Value;

import java.util.List;
import java.util.Set;

@Value
public class Station {

    List<Seance> seances;
    Set<String> genres;

}
