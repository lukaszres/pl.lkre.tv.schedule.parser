package pl.lkre.tv.teleman.parser;

import java.util.regex.Pattern;

public class TitleParser {
    private static final Pattern TITLE_PATTERN = Pattern.compile("^(.*) \\(.*[0-9].*\\)$");
    public static String parse(String value) {
        if (value.contains("(")) {
            return RegexParser.parse(value, TITLE_PATTERN);
        }
        return value;
    }
}
