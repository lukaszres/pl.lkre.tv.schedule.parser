package pl.lkre.tv.schedule.model;

import lombok.Value;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Value
public class Seance {

    private String title;
    private Date time;
    private String genre;
    private String episode;
    private String channel;
    private String description;

    Optional<String> getEpisode() {
        return Optional.ofNullable(episode);
    }

    Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("HH:mm");
        String episodeString = episode == null ? "" : " :: " + episode;
        return df.format(time) + " :: " + channel + " :: " + genre + " :: " + title + episodeString;
    }
}
