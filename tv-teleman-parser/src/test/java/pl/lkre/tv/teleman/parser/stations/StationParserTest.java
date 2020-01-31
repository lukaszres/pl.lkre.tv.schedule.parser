package pl.lkre.tv.teleman.parser.stations;

import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;
import pl.lkre.tv.teleman.parser.HtmlFileReader;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StationParserTest {

    @Test
    void parse() throws IOException {
        //given
        Document document = HtmlFileReader.read("station-index.html");
        //when
        List<String> actual = StationParser.parse(document);
        //then
        assertThat(actual).hasSize(141);
        assertThat(actual)
                .as("description")
                .filteredOn(o -> !o.contains("href"))
                .hasSize(141);
    }

    @Test
    void parseFromString() throws IOException {
        //given
        Document document = HtmlFileReader.read("station-index.html");
        //when
        String stationURI = StationParser.parse(document).get(0);
        String stationName = StationParser.parseFromUrl(stationURI);
        //then
        assertThat(stationName).isEqualTo("13-Ulica");
    }
}
