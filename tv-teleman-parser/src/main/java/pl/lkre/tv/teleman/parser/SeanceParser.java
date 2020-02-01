package pl.lkre.tv.teleman.parser;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import pl.lkre.tv.schedule.model.Seance;

import java.text.ParseException;
import java.util.Date;

public class SeanceParser {
    private Node node;

    public SeanceParser(Node node) {
        this.node = node;
    }

    public Seance parse() throws ParseException {
        final String textFromNode0 = takeTextFromNode(0);
        final String textFromNode1 = takeTextFromNode(1);

        final String title = TitleParser.parse(textFromNode0);
        final Date date = DateParser.parse(node);
        final String genre = GenreParser.parse(textFromNode1);
        String episode = EpisodeParser.parse(textFromNode0, title);
        String originDate = OriginDateParser.parse(textFromNode1);
        String originCountry = OriginCounrtryParser.parse(textFromNode1);
        String station = node.ownerDocument().select("div.stationTitle > h1").first().childNode(0).outerHtml().trim();
        final String description = takeTextFromNode(2);
        return new Seance(title, date, genre, episode, originDate, originCountry, station, description);
    }

    private String takeTextFromNode(int index) {
        return ((Element) node).select("div.detail").first().childNode(index).childNode(0).outerHtml().trim();
    }
}
