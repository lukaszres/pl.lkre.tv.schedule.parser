package pl.lkre.tv.schedule.model;

import lombok.Value;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Value
public class Seance {
    public static final String SEPARATOR = " :: ";

    private String title;
    private Date date;
    private String genre;
    private String episode;
    private String originDate;
    private String originCountry;
    private String station;
    private String description;

    Optional<String> getEpisode() {
        return Optional.ofNullable(episode);
    }

    Optional<String> getOriginDate() {
        return Optional.ofNullable(originDate);
    }

    Optional<String> getOriginCountry() {
        return Optional.ofNullable(originCountry);
    }

    Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }


    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("HH:mm");
        String episodeString = episode == null ? "" : SEPARATOR + episode;
        String originCountryString = originCountry == null ? "" : SEPARATOR + originCountry;
        String originDateString = originDate == null ? "" : SEPARATOR + originDate;
        return df.format(date)
                + SEPARATOR + station
                + SEPARATOR + genre
                + SEPARATOR + title
                + episodeString
                + originCountryString
                + originDateString
                + SEPARATOR + description;
    }
}
