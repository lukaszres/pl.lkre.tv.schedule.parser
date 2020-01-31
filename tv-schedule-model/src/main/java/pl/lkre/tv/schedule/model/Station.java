package pl.lkre.tv.schedule.model;

import lombok.Value;

import java.util.List;

@Value
public class Station {

    private List<Seance> seances;
    private List<String> genres;

}
