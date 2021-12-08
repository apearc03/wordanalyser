package github.apearc03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TextFileReader {

    private static final String WORD_SEPARATOR_REGEX = "[\\s.;,]+";

    private static final Map<Integer, Integer> WORD_LENGTH_TO_COUNT = new HashMap<>();

    private static int WORD_COUNT = 0;

    static TextFileStatistics readFile(final String textFilePath) throws IOException {
        Files.lines(Paths.get(textFilePath))
                .flatMap(line -> Arrays.stream(line.split(WORD_SEPARATOR_REGEX)))
                .forEach(TextFileReader::analyseWord);

        return new TextFileStatistics(WORD_COUNT, WORD_LENGTH_TO_COUNT);
    }

    private static void analyseWord(final String word){
        WORD_COUNT++;
        WORD_LENGTH_TO_COUNT.compute(word.length(),
                (k, v) -> v == null ? 1 : v + 1);
    }


}