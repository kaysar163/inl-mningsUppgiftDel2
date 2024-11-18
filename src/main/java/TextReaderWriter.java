import java.util.Scanner;
import java.util.StringTokenizer;

// Klass som ansvarar för att läsa och skriva ut texten
class TextReaderWriter {
    private TextStatistics stats;

    public TextReaderWriter() {
        this.stats = new TextStatistics();
    }

    public void readInput() {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Skriv in text rad för rad. Skriv 'stop' för att avsluta:");

        while (true) {
            input = scanner.nextLine();
            stats.addLine(input);  // Uppdatera statistiken

            // Kontrollera om användaren har skrivit "stop"
            if (stats.containsStop()) {
                break;
            }

            System.out.println("Du skrev: " + input);
        }

        // Skriv ut resultat när användaren avslutar
        System.out.println("Programmet är avslutat.");
        System.out.println("Totalt antal rader (inkl. 'stop'): " + stats.getLineCount());
        System.out.println("Totalt antal tecken (inkl. 'stop'): " + stats.getCharacterCount());
        System.out.println("Totalt antal ord (inkl. 'stop'): " + stats.getWordCount());
        System.out.println("Längsta ordet: " + stats.getLongestWord());
    }
}