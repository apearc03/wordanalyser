package github.apearc03;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class StatisticsOutputTest {

    @Test
    public void output(){
        final Map<Integer, Integer> words = new HashMap();
        words.put(1, 1);
        words.put(2, 1);
        words.put(3, 1);
        words.put(4, 2);
        words.put(5, 2);
        words.put(7, 1);
        words.put(10, 1);

        final TextFileStatistics stats = new TextFileStatistics(9, words);
        String s = StatisticsOutput.output(stats);
        assertThat(StatisticsOutput.output(stats))
                .isEqualTo("Word count = 9\n" +
                          "Average word length = 4.556\n" +
                          "Number of words of length 1 is 1\n" +
                          "Number of words of length 2 is 1\n" +
                          "Number of words of length 3 is 1\n" +
                          "Number of words of length 4 is 2\n" +
                          "Number of words of length 5 is 2\n" +
                          "Number of words of length 7 is 1\n" +
                          "Number of words of length 10 is 1\n" +
                          "The most frequently occurring word length is 2, for word lengths of 4 & 5"
                );
    }
}
