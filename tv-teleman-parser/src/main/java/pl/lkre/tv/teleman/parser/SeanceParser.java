package pl.lkre.tv.teleman.parser;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import pl.lkre.tv.schedule.model.Seance;

import java.util.Date;

public class SeanceParser {

    public static Seance parse(Node node) {
        String genre = null;
        String originDate = null;
        String originCountry = null;
        final String textFromNode0 = takeTextFromNode(node, 0);
        final String textFromGenre = takeTextFromGenre(node);
        final String title = TitleParser.parse(textFromNode0);
        final Date date = DateParser.parse(node);
        if (textFromGenre != null) {
            genre = GenreParser.parse(textFromGenre);
            originDate = OriginDateParser.parse(textFromGenre);
            originCountry = OriginCounrtryParser.parse(textFromGenre);
        }
        String episode = EpisodeParser.parse(textFromNode0, title);

        String station = node.ownerDocument().select("div.stationTitle > h1").first().childNode(0).outerHtml().trim();
        final String description = takeDescription(node);
        return new Seance(title, date, genre, episode, originDate, originCountry, station, description);
    }

    private static String takeTextFromGenre(Node node) {
        final Element element = ((Element) node).select("div.detail>p.genre").first();
        return element != null ? element.childNode(0).outerHtml().trim() : null;
    }

    private static String takeDescription(Node node) {
        final Element element = ((Element) node).select("div.detail>p").not("[class]").first();
        return element != null ? element.childNode(0).outerHtml().trim() : null;
    }

    private static String takeTextFromNode(Node node, int index) {
        return ((Element) node).select("div.detail").first().childNode(index).childNode(0).outerHtml().trim();
    }
}
