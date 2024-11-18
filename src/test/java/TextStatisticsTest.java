import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TextStatisticsTest {

    @Test
    public void testWordCountAndLongestWord() {
        TextStatistics stats = new TextStatistics();
        stats.addLine("Hej världen");
        assertEquals(2, stats.getWordCount());
        assertEquals("världen", stats.getLongestWord());
    }

    @Test
    public void testMultipleLines() {
        TextStatistics stats = new TextStatistics();
        stats.addLine("Hej");
        stats.addLine("Detta är en test");

        assertEquals(5, stats.getWordCount());

        // Nu kontrollerar vi att det längsta ordet är antingen "Detta" eller "test"
        String longestWord = stats.getLongestWord();
        assertTrue(longestWord.equals("Detta") || longestWord.equals("test"));
    }


    @Test
    public void testContainsStop() {
        TextStatistics stats = new TextStatistics();
        stats.addLine("stop");
        assertTrue(stats.containsStop());
    }
}