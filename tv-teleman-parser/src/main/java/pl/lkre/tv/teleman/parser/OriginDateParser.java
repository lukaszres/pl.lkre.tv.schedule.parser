package pl.lkre.tv.teleman.parser;

import java.util.regex.Pattern;

public class OriginDateParser {
    private static final Pattern ORIGIN_DATE_PARSER = Pattern.compile("^.*, .* (\\d{4})");

    public static String parse(String value) {
        if (value.contains(",")) {
            return RegexParser.parse(value, ORIGIN_DATE_PARSER);
        }
        return null;
    }
}
