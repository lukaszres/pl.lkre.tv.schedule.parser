package pl.lkre.tv.teleman.utils;

import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;
import pl.lkre.tv.schedule.model.Seance;
import pl.lkre.tv.teleman.HtmlFileReader;
import pl.lkre.tv.teleman.parser.DocumentParser;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static pl.lkre.tv.teleman.parser.constants.FileNames.*;

class DateChangerTest {

    @Test
    void shouldReturnChangedDateFromPolsatFile() throws IOException, ParseException {
        //given
        final DocumentParser parser = new DocumentParser();
        final Document document = HtmlFileReader.read(POLSAT);
        final List<Seance> seances = parser.parse(document);
        DateChanger dateChanger = new DateChanger();
        //when
        List<Seance> actual = dateChanger.proceed(seances);
        //then
        assertThat(actual).hasSize(25);
        assertThat(actual.get(0).getDate()).isEqualTo(new SimpleDateFormat("yyyy.MM.dd H:mm")
                .parse("2020.01.31 04:55"));
        assertThat(actual.get(23).getDate()).isEqualTo(new SimpleDateFormat("yyyy.MM.dd H:mm")
                .parse("2020.02.01 01:30"));
        assertThat(actual.get(24).getDate()).isEqualTo(new SimpleDateFormat("yyyy.MM.dd H:mm")
                .parse("2020.02.01 03:20"));
    }

    @Test
    void shouldReturnChangedDateFromTVNFile() throws IOException, ParseException {
        //given
        final DocumentParser parser = new DocumentParser();
        final Document document = HtmlFileReader.read(TVN);
        final List<Seance> seances = parser.parse(document);
        DateChanger dateChanger = new DateChanger();
        //when
        List<Seance> actual = dateChanger.proceed(seances);
        //then
        assertThat(actual).hasSize(26);
        assertThat(actual.get(0).getDate()).isEqualTo(new SimpleDateFormat("yyyy.MM.dd H:mm")
                .parse("2020.01.31 04:50"));
        assertThat(actual.get(22).getDate()).isEqualTo(new SimpleDateFormat("yyyy.MM.dd H:mm")
                .parse("2020.02.01 01:25"));
        assertThat(actual.get(25).getDate()).isEqualTo(new SimpleDateFormat("yyyy.MM.dd H:mm")
                .parse("2020.02.01 03:45"));
    }

    @Test
    void shouldReturnChangedDateFromTVP1File() throws IOException, ParseException {
        //given
        final DocumentParser parser = new DocumentParser();
        final Document document = HtmlFileReader.read(TVP_1);
        final List<Seance> seances = parser.parse(document);
        DateChanger dateChanger = new DateChanger();
        //when
        List<Seance> actual = dateChanger.proceed(seances);
        //then
        assertThat(actual).hasSize(42);
        assertThat(actual.get(0).getDate()).isEqualTo(new SimpleDateFormat("yyyy.MM.dd H:mm")
                .parse("2020.01.31 05:40"));
        assertThat(actual.get(37).getDate()).isEqualTo(new SimpleDateFormat("yyyy.MM.dd H:mm")
                .parse("2020.02.01 01:50"));
        assertThat(actual.get(41).getDate()).isEqualTo(new SimpleDateFormat("yyyy.MM.dd H:mm")
                .parse("2020.02.01 04:50"));
    }
}