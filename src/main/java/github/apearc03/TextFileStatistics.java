package github.apearc03;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TextFileStatistics {

    private final int wordCount;
    private final Map<Integer, Integer> wordLengthToCount;
    private final float avgWordLength;
    private final int maxOccurrence;
    private final List<Integer> frequentlyOccurringLengths;

    public TextFileStatistics(final int wordCount,
                              final Map<Integer, Integer> wordLengthToCount) {
        this.wordCount = wordCount;
        this.wordLengthToCount = wordLengthToCount;
        this.maxOccurrence = maxOccurrence();
        this.avgWordLength = avgWordLength();
        this.frequentlyOccurringLengths = frequentlyOccurringLengths();
    }

    private int maxOccurrence() {
        return wordLengthToCount.values().stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new RuntimeException("Error occurred finding max occurrence of a word."));
    }

    private float avgWordLength() {
        final int sumOfWordLengths = wordLengthToCount.entrySet().stream()
                .map(entry -> entry.getKey() * entry.getValue())
                .reduce(Integer::sum)
                .orElseThrow(() -> new RuntimeException("Error occurred summing word lengths from file."));
        return new BigDecimal((float) sumOfWordLengths / wordCount).setScale(3, BigDecimal.ROUND_HALF_UP).floatValue();
    }

    private List<Integer> frequentlyOccurringLengths() {
        return wordLengthToCount.entrySet().stream()
                .filter(entry -> entry.getValue() == maxOccurrence)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public int getWordCount() {
        return wordCount;
    }

    public Map<Integer, Integer> getWordLengthToCount() {
        return wordLengthToCount;
    }

    public float getAvgWordLength() {
        return avgWordLength;
    }

    public int getMaxOccurrence() {
        return maxOccurrence;
    }

    public List<Integer> getFrequentlyOccurringLengths() {
        return frequentlyOccurringLengths;
    }
}
