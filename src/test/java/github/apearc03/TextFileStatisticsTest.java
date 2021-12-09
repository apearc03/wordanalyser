package github.apearc03;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class TextFileStatisticsTest {

    @Test
    public void stats() {
        final Map<Integer, Integer> words = new HashMap();
        words.put(1, 1);
        words.put(2, 1);
        words.put(3, 1);
        final ArrayList<Integer> lengths = new ArrayList();
        lengths.add(1);
        lengths.add(2);
        lengths.add(3);
        final TextFileStatistics stats = new TextFileStatistics(3, words);

        assertThat(stats)
                .extracting(
                        TextFileStatistics::getWordCount,
                        TextFileStatistics::getWordLengthToCount,
                        TextFileStatistics::getAvgWordLength,
                        TextFileStatistics::getMaxOccurrence,
                        TextFileStatistics::getFrequentlyOccurringLengths)
                .containsExactly(
                        3,
                        words,
                        2.0f,
                        1,
                        lengths);
    }
}
