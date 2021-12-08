package github.apearc03;

import java.util.Map;

public class TextFileStatistics {

    private final int wordCount;
    private final float avgWordLength;
    private final Map<Integer, Integer> wordLengthToCount;

    public TextFileStatistics(final int wordCount,
                              final Map<Integer, Integer> wordLengthToCount) {
        this.wordCount = wordCount;
        this.avgWordLength = 0; //TODO
        this.wordLengthToCount = wordLengthToCount;
    }
}
