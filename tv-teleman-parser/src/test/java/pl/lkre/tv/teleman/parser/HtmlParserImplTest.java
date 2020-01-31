package pl.lkre.tv.teleman.parser;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.lkre.tv.teleman.parser.constants.FileNames.*;

class HtmlParserImplTest {

    @Test
    void shouldReturn25() throws IOException {
        //given
        final HtmlParserImpl parser = new HtmlParserImpl();
        final Document document = HtmlFileReader.read(POLSAT);
        //when
        final List<Node> actual = parser.parse(document);
        //then
        assertThat(actual).hasSize(25);
    }

    @Test
    void shouldReturn26() throws IOException {
        //given
        final HtmlParserImpl parser = new HtmlParserImpl();
        final Document document = HtmlFileReader.read(TVN);
        //when
        final List<Node> actual = parser.parse(document);
        //then
        assertThat(actual).hasSize(26);
    }

    @Test
    void shouldReturn42() throws IOException {
        //given
        final HtmlParserImpl parser = new HtmlParserImpl();
        final Document document = HtmlFileReader.read(TVP_1);
        //when
        final List<Node> actual = parser.parse(document);
        //then
        assertThat(actual).hasSize(42);
    }
}
