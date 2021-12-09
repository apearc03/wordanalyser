package github.apearc03;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple WordAnalyser.
 */
public class WordAnalyserTest {

    private static final String WORD_SEPARATOR_REGEX = "[\\s.;:,*(){}]+";

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {

        String[] s = "******* December 31 *******".split(WORD_SEPARATOR_REGEX);
        assertTrue( true );
    }
}
