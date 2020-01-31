package pl.lkre.tv.teleman.parser.stations;

import org.jsoup.nodes.Document;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StationParser {
    public static List<String> parse(Document document) {
        return document.select("a[href]")
                .stream()
                .map(o -> o.attr("href"))
                .collect(Collectors.toList());
    }

    public static String parseFromUrl(String urlString) {
        String regex = "^/program-tv/stacje/(.*)$";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(urlString);
        if (matcher.matches()) {
            return matcher.group(1);
        } else return null;
    }
}
