package pl.lkre.tv.teleman.parser;

import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;
import pl.lkre.tv.schedule.model.Seance;
import pl.lkre.tv.teleman.HtmlFileReader;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.lkre.tv.teleman.parser.constants.FileNames.*;

class DocumentParserTest {

    @Test
    void shouldReturn25() throws IOException {
        //given
        final DocumentParser parser = new DocumentParser();
        final Document document = HtmlFileReader.read(POLSAT);
        //when
        final List<Seance> actual = parser.parse(document);
        //then
        assertThat(actual).hasSize(25);
        assertThat(actual.get(0).getTitle()).isEqualTo("Disco Gramy");
        assertThat(actual.get(24).getTitle()).isEqualTo("Tajemnice losu");
    }

    @Test
    void shouldReturn26() throws IOException {
        //given
        final DocumentParser parser = new DocumentParser();
        final Document document = HtmlFileReader.read(TVN);
        //when
        final List<Seance> actual = parser.parse(document);
        //then
        assertThat(actual).hasSize(26);
        assertThat(actual.get(0).getTitle()).isEqualTo("Uwaga!");
        assertThat(actual.get(25).getTitle()).isEqualTo("NOC Magii");
    }

    @Test
    void shouldReturn42() throws IOException {
        //given
        final DocumentParser parser = new DocumentParser();
        final Document document = HtmlFileReader.read(TVP_1);
        //when
        final List<Seance> actual = parser.parse(document);
        //then
        assertThat(actual).hasSize(42);
        assertThat(actual.get(0).getTitle()).isEqualTo("Jaka to melodia?");
        assertThat(actual.get(41).getTitle()).isEqualTo("Zakończenie programu");
    }
}
