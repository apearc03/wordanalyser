package github.apearc03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TextFileStatisticExtractor {

    static final String WORD_SEPARATOR_REGEX = "[\\s.;:,*(){}]+";

    private final Map<Integer, Integer> wordLengthToCount;
    private int wordCount;

    public TextFileStatisticExtractor() {
        wordLengthToCount = new HashMap<>();
        wordCount = 0;
    }

    public TextFileStatistics extract(final String textFilePath) throws IOException {
        Files.lines(Paths.get(textFilePath))
                .flatMap(line -> Arrays.stream(line.split(WORD_SEPARATOR_REGEX)))
                .filter(word -> !word.isEmpty())
                .forEach(this::processWord);

        return new TextFileStatistics(wordCount, wordLengthToCount);
    }

    private void processWord(final String word) {
        wordCount++;
        wordLengthToCount.compute(word.length(),
                (k, v) -> v == null ? 1 : v + 1);
    }

}
