package github.apearc03;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static github.apearc03.TextFileStatisticExtractor.WORD_SEPARATOR_REGEX;
import static org.assertj.core.api.Assertions.assertThat;

public class TextFileStatisticExtractorTest {

    @Test
    public void one_line_file() throws IOException {
        final Map<Integer, Integer> expected = new HashMap();
        expected.put(1, 1);
        expected.put(2, 1);
        expected.put(3, 1);
        expected.put(4, 2);
        expected.put(5, 2);
        expected.put(7, 1);
        expected.put(10, 1);
        final Path resourceDirectory = Paths.get("src", "test", "resources", "oneline.txt");
        final TextFileStatistics stats = new TextFileStatisticExtractor().extract(resourceDirectory.toString());

        assertThat(stats)
                .extracting(TextFileStatistics::getWordCount, TextFileStatistics::getAvgWordLength, TextFileStatistics::getWordLengthToCount)
                .containsExactly(9, 4.556f, expected);
    }

    @Test
    public void multi_line_file() throws IOException {
        final Map<Integer, Integer> expected = new HashMap();
        expected.put(1, 3);
        expected.put(2, 3);
        expected.put(3, 6);
        expected.put(4, 6);
        expected.put(5, 6);
        expected.put(7, 3);
        expected.put(10, 3);
        final Path resourceDirectory = Paths.get("src", "test", "resources", "multiline.txt");
        final TextFileStatistics stats = new TextFileStatisticExtractor().extract(resourceDirectory.toString());

        assertThat(stats)
                .extracting(TextFileStatistics::getWordCount, TextFileStatistics::getAvgWordLength, TextFileStatistics::getWordLengthToCount)
                .containsExactly(30, 4.4f, expected);
    }

    @Test
    public void regex_brackets(){
        assertThat(Arrays.stream("(this (is) a sentence.)" .split(WORD_SEPARATOR_REGEX)).filter(s -> !s.isEmpty()))
                .containsExactly("this", "is", "a", "sentence");
    }

    @Test
    public void regex_colons(){
        assertThat(Arrays.stream("this: is; a ;;sentence." .split(WORD_SEPARATOR_REGEX)).filter(s -> !s.isEmpty()))
                .containsExactly("this", "is", "a", "sentence");
    }

    @Test
    public void regex_valid_non_letter_chars(){
        assertThat(Arrays.stream("this-is a sentence. 09/12/2021" .split(WORD_SEPARATOR_REGEX)).filter(s -> !s.isEmpty()))
                .containsExactly("this-is", "a", "sentence", "09/12/2021");
    }

}
