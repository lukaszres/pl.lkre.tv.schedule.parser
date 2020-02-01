package pl.lkre.tv.teleman.parser;

import org.jsoup.nodes.Node;
import org.junit.jupiter.api.Test;
import pl.lkre.tv.teleman.NodeReader;

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
        final Node node = NodeReader.read(POLSAT, 0);
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
        final Node node = NodeReader.read(TVN, 5);
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
        final Node node = NodeReader.read(TVP_1, 36);
        //when
        final Date actual = DateParser.parse(node);
        final Date expected = new SimpleDateFormat("yyyy.MM.dd h:mm")
                .parse("2020.01.31 0:55");
        //then
        assertThat(actual).isEqualTo(expected);
    }
}
