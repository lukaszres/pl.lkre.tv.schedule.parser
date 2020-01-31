package pl.lkre.tv.teleman.parser;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateParser {
    public static Date parse(Node node) throws ParseException {
        Date actual = generateDate(node);
        final Node previousSibling = node.previousSibling();
        if (previousSibling != null) {
            final Date previous = generateDate(previousSibling);
            if (actual.before(previous)) {
                final Calendar calendar = Calendar.getInstance();
                calendar.setTime(actual);
                calendar.add(Calendar.DAY_OF_MONTH, 1);
                actual = calendar.getTime();
            }
        }
        return actual;
    }

    private static Date generateDate(Node node) throws ParseException {
        String time = ((Element) node).select("em").first().childNode(0).outerHtml();
        String dayMonth = node.ownerDocument().select("div#date-slider-dates").first().childNode(3).childNode(1).childNode(0).outerHtml();
        String year = generateYear(node);
        String date = dayMonth + "." + year;
        return new SimpleDateFormat("dd.MM.yyyy h:mm")
                .parse(date + " " + time);
    }

    private static String generateYear(Node node) {
        final String href = node.ownerDocument().select("div#date-slider-dates").first().childNode(1).attr("href");
        final String pattern = "/program-tv/stacje/.*\\?date=(\\d{4})-\\d{2}-\\d{2}&hour=-1";
        final Pattern pattern1 = Pattern.compile(pattern);
        final Matcher matcher = pattern1.matcher(href);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return null;
    }
}
