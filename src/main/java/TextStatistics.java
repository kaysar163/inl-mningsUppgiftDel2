import java.util.StringTokenizer;

// Klass som ansvarar för att hålla koll på rader, tecken, ord och längsta ordet
// Klass som ansvarar för att hålla koll på rader, tecken, ord och längsta ordet
class TextStatistics {
    private int lineCount;
    private int characterCount;
    private int wordCount;
    private String longestWord;
    private boolean containsStop;

    public TextStatistics() {
        this.lineCount = 0;
        this.characterCount = 0;
        this.wordCount = 0;
        this.longestWord = "";
        this.containsStop = false;
    }

    // Lägg till rad och uppdatera statistik
    public void addLine(String line) {
        this.lineCount++;  // Räkna rader
        this.characterCount += line.length();  // Räkna tecken

        // Dela upp raden i ord och räkna orden
        StringTokenizer tokenizer = new StringTokenizer(line, " ");
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            this.wordCount++;  // Räkna ord

            // Uppdatera det längsta ordet
            if (word.length() > this.longestWord.length()) {
                this.longestWord = word;
            }

            // Kontrollera om användaren har skrivit "stop"
            if (word.equalsIgnoreCase("stop")) {
                this.containsStop = true;
            }
        }
    }

    // Getters för statistik
    public int getLineCount() {
        return this.lineCount;
    }

    public int getCharacterCount() {
        return this.characterCount;
    }

    public int getWordCount() {
        return this.wordCount;
    }

    public String getLongestWord() {
        return this.longestWord;
    }

    public boolean containsStop() {
        return this.containsStop;
    }
}