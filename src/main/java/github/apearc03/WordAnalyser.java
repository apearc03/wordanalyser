package github.apearc03;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.String.format;

public class WordAnalyser
{
    public static void main( String[] args )
    {
        if(args.length != 1){
            System.out.println("Please append a single path of a text file.");
        }
        else{
            try {
                final TextFileStatistics stats = TextFileReader.readFile(args[0]);
                System.out.println();
            } catch (final IOException e) {
                System.out.println("Error occurred handling text file");
                e.printStackTrace();
            }
        }
    }
}
