package pl.lkre.tv.teleman;

import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;
import pl.lkre.tv.schedule.model.Station;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.lkre.tv.teleman.parser.constants.FileNames.*;

class StationFactoryTest {

    @Test
    void buildPolsat() throws IOException {
        //given
        final Document document = HtmlFileReader.read(POLSAT);
        StationFactory stationFactory = new StationFactory();
        //when
        Station actual = stationFactory.build(document);
        //then
        assertThat(actual.getSeances()).hasSize(25);
        assertThat(actual.getGenres()).hasSize(14);
    }

    @Test
    void buildTVN() throws IOException {
        //given
        final Document document = HtmlFileReader.read(TVN);
        StationFactory stationFactory = new StationFactory();
        //when
        Station actual = stationFactory.build(document);
        //then
        assertThat(actual.getSeances()).hasSize(26);
        assertThat(actual.getGenres()).hasSize(13);
    }

    @Test
    void buildTVP1() throws IOException {
        //given
        final Document document = HtmlFileReader.read(TVP_1);
        StationFactory stationFactory = new StationFactory();
        //when
        Station actual = stationFactory.build(document);
        //then
        assertThat(actual.getSeances()).hasSize(42);
        assertThat(actual.getGenres()).hasSize(23);
    }
}