package pl.lkre.tv.teleman.parser;

public class EpisodeParser {

    public static String parse(String textFromNode0, String title) {
        final String trimmed = textFromNode0.replace(title, "").trim();

        return trimmed.isEmpty() ? null : trimmed;
    }
}
