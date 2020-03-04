package pl.lkre.tv.teleman;

import org.jsoup.nodes.Document;
import pl.lkre.tv.schedule.model.Seance;
import pl.lkre.tv.schedule.model.Station;
import pl.lkre.tv.teleman.parser.DocumentParser;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StationFactory {
    private DocumentParser documentParser = new DocumentParser();

    public Station build(Document document) {
        List<Seance> seances = documentParser.parse(document);
        return fromSeancesList(seances);
    }

    private Station fromSeancesList(List<Seance> seances) {
        Set<String> genres = seances.stream()
                .map(Seance::getGenre)
                .collect(Collectors.toSet());
        return new Station(seances, genres);
    }
}
