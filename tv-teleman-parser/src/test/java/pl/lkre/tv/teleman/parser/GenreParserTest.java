package pl.lkre.tv.teleman.parser;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GenreParserTest {

    @Test
    void shouldReturnGenre() {
        //given
        String expected = "film dokumentalny";
        //when
        final String actual = GenreParser.parse("film dokumentalny, Japonia 2016");
        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldReturnValueFromArgument() {
        //given
        String expected = "telenowela historyczna";
        //when
        final String actual = GenreParser.parse("telenowela historyczna");
        //then
        assertThat(actual).isEqualTo(expected);
    }
}
