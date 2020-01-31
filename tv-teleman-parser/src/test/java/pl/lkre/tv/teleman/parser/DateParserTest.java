package pl.lkre.tv.teleman.parser;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.lkre.tv.teleman.parser.constants.FileNames.*;

class DateParserTest {

    @Test
    void shouldReturnCorrectDateFromPolsatFile() throws IOException, ParseException {
        //given
        final Document document = HtmlFileReader.read(POLSAT);
        final Node node = new HtmlParserImpl().parse(document).get(0);
        //when
        final Date actual = DateParser.parse(node);
        final Date expected = new SimpleDateFormat("yyyy.MM.dd h:mm")
                .parse("2020.01.31 4:55");
        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldReturnCorrectDateFromTVNFile() throws IOException, ParseException {
        //given
        final Document document = HtmlFileReader.read(TVN);
        final Node node = new HtmlParserImpl().parse(document).get(5);
        //when
        final Date actual = DateParser.parse(node);
        final Date expected = new SimpleDateFormat("yyyy.MM.dd h:mm")
                .parse("2020.01.31 11:00");
        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldReturnCorrectDateFromTVP1File() throws IOException, ParseException {
        //given
        final Document document = HtmlFileReader.read(TVP_1);
        final Node node = new HtmlParserImpl().parse(document).get(36);
        //when
        final Date actual = DateParser.parse(node);
        final Date expected = new SimpleDateFormat("yyyy.MM.dd h:mm")
                .parse("2020.02.01 0:55");
        //then
        assertThat(actual).isEqualTo(expected);
    }
}
