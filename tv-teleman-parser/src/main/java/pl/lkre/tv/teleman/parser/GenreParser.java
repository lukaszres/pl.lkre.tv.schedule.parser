package pl.lkre.tv.teleman.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenreParser {
    public static String parse(String value) {
        if (value.contains(",")) {
            final String pattern = "^(.*), .*$";
            final Pattern pattern1 = Pattern.compile(pattern);
            final Matcher matcher = pattern1.matcher(value);
            if (matcher.matches()) {
                return matcher.group(1);
            }
            return null;
        }
        return value;
    }
}
