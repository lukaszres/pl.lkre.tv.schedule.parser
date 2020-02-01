package pl.lkre.tv.teleman.parser;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OriginDateParserTest {

    @Test
    void shouldReturn2013() {
        //when
        final String actual = OriginDateParser.parse("komedia, Hiszpania 2013");
        final String expected = "2013";
        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldReturn2014() {
        //when
        final String actual = OriginDateParser.parse("dramat SF, USA 2014");
        final String expected = "2014";
        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldReturn2018() {
        //when
        final String actual = OriginDateParser.parse("film dokumentalny, Wielka Brytania 2018");
        final String expected = "2018";
        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void when_StringWithSpace_shouldReturnNull() {
        //when
        final String actual = OriginDateParser.parse("magazyn muzyczny");
        //then
        assertThat(actual).isNull();
    }

    @Test
    void when_stringWithDash_shouldReturnNull() {
        //when
        final String actual = OriginDateParser.parse("serial fabularno-dokumentalny");
        //then
        assertThat(actual).isNull();
    }
}
