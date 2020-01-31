package pl.lkre.tv.teleman.parser;

import java.util.regex.Pattern;

public class GenreParser {
    public static final Pattern GENRE_PATTERN = Pattern.compile("^(.*), .*$");

    public static String parse(String value) {
        if (value.contains(",")) {
            return RegexParser.parse(value, GENRE_PATTERN);
        }
        return value;
    }
}
