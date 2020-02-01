package pl.lkre.tv.teleman.parser;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TitleParserTest {

    @Test
    void whenOneWOrdShouldReturnTheSame() {
        //given
        final String expected = "Klan";
        //when
        final String actual = TitleParser.parse("Klan");
        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void whenNumberShouldReturnTheSame() {
        //given
        final String expected = "2012";
        //when
        final String actual = TitleParser.parse("2012");
        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void whenOneWordWithEpisodeShouldReturnOneWord() {
        //given
        final String expected = "Klan";
        //when
        final String actual = TitleParser.parse("Klan (2042)");
        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldReturnTheSameString() {
        //given
        final String expected = "Jaka to melodia?";
        //when
        final String actual = TitleParser.parse("Jaka to melodia?");
        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void ShouldReturnOnlyTitle() {
        //given
        final String expected = "Ojciec Mateusz 21: Gniew";
        //when
        final String actual = TitleParser.parse("Ojciec Mateusz 21: Gniew (266)");
        //then
        assertThat(actual).isEqualTo(expected);
    }
}
