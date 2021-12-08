package github.apearc03;

import java.util.stream.Collectors;

import static java.lang.String.format;

public class StatisticsOutput {

    private static final String COUNT = "Word count = %d \n";
    private static final String AVG_WORD_LENGTH = "Average word length = %.3f \n";
    private static final String NUMBER_OF_WORDS_OF_LENGTH = "Number of words of length %d is %d";
    private static final String FREQUENTLY_OCCURRED = "\nThe most frequently occurring word length is %d, for word lengths of %s";

    public static String output(final TextFileStatistics stats) {
        final StringBuilder output = new StringBuilder()
                .append(format(COUNT, stats.getWordCount()))
                .append(format(AVG_WORD_LENGTH, stats.getAvgWordLength()))
                .append(wordLengths(stats))
                .append(frequentlyOccurringWordLengths(stats));
        return output.replace(output.lastIndexOf(","), output.lastIndexOf(",") + 1, " &").toString();
    }

    //need the ampersand instead of last comma
    private static String frequentlyOccurringWordLengths(final TextFileStatistics stats) {
        final String wordLengths = stats.getFrequentlyOccurringLengths().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        return format(FREQUENTLY_OCCURRED, stats.getMaxOccurrence(), wordLengths);
    }

    private static String wordLengths(final TextFileStatistics stats) {
        return stats.getWordLengthToCount().entrySet().stream()
                .map(entry -> format(NUMBER_OF_WORDS_OF_LENGTH, entry.getKey(), entry.getValue()))
                .collect(Collectors.joining("\n"));
    }

}
