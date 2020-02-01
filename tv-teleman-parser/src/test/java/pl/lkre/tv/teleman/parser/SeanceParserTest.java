package pl.lkre.tv.teleman.parser;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.junit.jupiter.api.Test;
import pl.lkre.tv.schedule.model.Seance;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.lkre.tv.teleman.parser.constants.FileNames.*;

class SeanceParserTest {

    @Test
    void shouldReturnSeanceDiscoGramy() throws IOException, ParseException {
        //given
        final Document document = HtmlFileReader.read(POLSAT);
        final Node node = new HtmlParserImpl().parse(document).get(0);

        final SeanceParser seanceParser = new SeanceParser(node);

        //when
        final Seance actual = seanceParser.parse();
        final Seance expect = new Seance(
                "Disco Gramy"
                , new SimpleDateFormat("yyyy.MM.dd h:mm").parse("2020.01.31 4:55")
                , "program muzyczny"
                , null
                , null
                , null
                , "Polsat"
                , "Pełna gama rozrywki: humor, cięte komentarze prowadzącego Roberta 'Mykee' Jarka, sonda uliczna Mariana Skowronka, nasz typ, czyli piosenka wybrana przez..."
        );
        //then
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    void shouldReturnSeanceTerminator2() throws IOException, ParseException {
        //given
        final Document document = HtmlFileReader.read(TVN);
        final Node node = new HtmlParserImpl().parse(document).get(21);

        final SeanceParser seanceParser = new SeanceParser(node);

        //when
        final Seance actual = seanceParser.parse();
        final Seance expect = new Seance(
                "Terminator 2: Dzień sądu"
                , new SimpleDateFormat("yyyy.MM.dd h:mm").parse("2020.01.31 22:40")
                , "film SF"
                , null
                , "1991"
                , "Francja/USA"
                , "TVN"
                , "Jeden z najlepszych filmów akcji w historii światowego kina."
        );
        //then
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    void shouldReturnSeanceKompaniaX() throws IOException, ParseException {
        //given
        final Document document = HtmlFileReader.read(TVP_1);
        final Node node = new HtmlParserImpl().parse(document).get(37);

        final SeanceParser seanceParser = new SeanceParser(node);

        //when
        final Seance actual = seanceParser.parse();
        final Seance expect = new Seance(
                "Kompania X 3"
                , new SimpleDateFormat("yyyy.MM.dd h:mm").parse("2020.01.31 1:50")
                , "serial wojenny"
                , "(1/10)"
                , null
                , null
                , "TVP 1"
                , "Grupa tajnych agentów szpieguje Niemców w Europie podczas II wojny światowej."
        );
        //then
        assertThat(actual).isEqualTo(expect);
    }
}
