package pl.lkre.tv.teleman.parser;

import java.util.regex.Pattern;

public class OriginCounrtryParser {
    private static final Pattern ORIGIN_COUNTRY_PATTERN = Pattern.compile("^.*, (.*) \\d{4}$");

    public static String parse(String value) {
        if (value.contains(",")) {
            return RegexParser.parse(value, ORIGIN_COUNTRY_PATTERN);
        }
        return null;
    }
}
