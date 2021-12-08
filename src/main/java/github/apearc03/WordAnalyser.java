package github.apearc03;


import java.io.IOException;

public class WordAnalyser {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please append a single path of a text file.");
        } else {
            try {
                final TextFileStatistics stats = TextFileStatisticExtractor.extract(args[0]);
                System.out.println(StatisticsOutput.output(stats));
            } catch (final IOException e) {
                System.out.println("Error occurred handling text file");
                e.printStackTrace();
            }
        }
    }
}
