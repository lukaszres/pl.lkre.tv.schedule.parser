package pl.lkre.tv.teleman.parser;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class DateParser {

    private static final Pattern DATE_PATTERN = Pattern.compile("/program-tv/stacje/.*\\?date=(\\d{4})-\\d{2}-\\d{2}&hour=-1");

    public static Date parse(Node node) {
        return generateDate(node);
    }

    private static Date generateDate(Node node) {
        String time = ((Element) node).select("em").first().childNode(0).outerHtml();
        String dayMonth = node.ownerDocument().select("div#date-slider-dates").first().childNode(3).childNode(1).childNode(0).outerHtml();
        String year = generateYear(node);
        String date = dayMonth + "." + year;
        try {
            return new SimpleDateFormat("dd.MM.yyyy h:mm")
                    .parse(date + " " + time);
        } catch (ParseException e) {
            return null;
        }
    }

    private static String generateYear(Node node) {
        final String href = node.ownerDocument().select("div#date-slider-dates").first().childNode(1).attr("href");
        return RegexParser.parse(href, DATE_PATTERN);
    }
}
