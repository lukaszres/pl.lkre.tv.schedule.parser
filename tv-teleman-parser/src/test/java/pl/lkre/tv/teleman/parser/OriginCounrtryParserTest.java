package pl.lkre.tv.teleman.parser;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OriginCounrtryParserTest {

    @Test
    void shouldReturnHiszpania() {
        //when
        final String actual = OriginCounrtryParser.parse("komedia, Hiszpania 2013");
        final String expected = "Hiszpania";
        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldReturnUSA() {
        //when
        final String actual = OriginCounrtryParser.parse("dramat SF, USA 2014");
        final String expected = "USA";
        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldReturnWielkaBrytania() {
        //when
        final String actual = OriginCounrtryParser.parse("film dokumentalny, Wielka Brytania 2018");
        final String expected = "Wielka Brytania";
        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void when_StringWithSpace_shouldReturnNull() {
        //when
        final String actual = OriginCounrtryParser.parse("magazyn muzyczny");
        //then
        assertThat(actual).isNull();
    }

    @Test
    void when_stringWithDash_shouldReturnNull() {
        //when
        final String actual = OriginCounrtryParser.parse("serial fabularno-dokumentalny");
        //then
        assertThat(actual).isNull();
    }
}
