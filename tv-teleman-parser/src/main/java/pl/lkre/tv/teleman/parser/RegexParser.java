package pl.lkre.tv.teleman.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexParser {
    public static String parse(String value, Pattern pattern) {
        final Matcher matcher = pattern.matcher(value);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return null;
    }
}
