package at.campus02.nowa.figures;

public abstract class Figure {
    protected char[][] symbol = new char[3][3];


    // Methode zum Skalieren der Figur
    public void scale(int factor) {
        // Überprüfen, ob der Skalierungsfaktor gültig ist (muss mindestens 1 sein)
        if (factor < 1) {
            System.out.println("Ungültiger Skalierungsfaktor!"); // Fehlerausgabe, wenn der Faktor ungültig ist
            return;
        }

        // Speichern der ursprünglichen Dimensionen der Figur
        int originalRows = symbol.length;  // Anzahl der Zeilen der ursprünglichen Figur
        int originalCols = symbol[0].length;  // Anzahl der Spalten der ursprünglichen Figur

        // Berechnen der neuen Dimensionen nach der Skalierung
        int newRows = originalRows * factor;  // Neue Anzahl der Zeilen
        int newCols = originalCols * factor;  // Neue Anzahl der Spalten

        // Erstellen eines neuen Arrays für die skalierte Figur
        char[][] scaledSymbol = new char[newRows][newCols];

        // Skalieren der Figur: Die ursprünglichen Symbole werden auf die neuen Positionen kopiert
        for (int i = 0; i < originalRows; i++) {
            for (int j = 0; j < originalCols; j++) {
                // Jedes Symbol aus der ursprünglichen Figur wird auf ein größeres Array abgebildet
                for (int m = i * factor; m < (i + 1) * factor; m++) {
                    for (int n = j * factor; n < (j + 1) * factor; n++) {
                        scaledSymbol[m][n] = symbol[i][j];  // Kopieren des Symbols an die neue Position
                    }
                }
            }
        }

        // Aktualisieren des symbol-Arrays mit der skalierten Figur
        symbol = scaledSymbol;
    }

    // Methode zum Umwandeln der Figur in einen String, der angezeigt werden kann
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        // Iterieren über die Zeilen der Figur
        for (int row = 0; row < symbol.length; row++) {
            // Iterieren über die Spalten der aktuellen Zeile
            for (int col = 0; col < symbol[row].length; col++) {
                sb.append(symbol[row][col]);  // Hinzufügen des Symbols zur StringBuilder-Instanz
            }
            sb.append('\n');  // Hinzufügen eines Zeilenumbruchs nach jeder Zeile
        }
        // Rückgabe des endgültigen Strings, der die gesamte Figur darstellt
        return sb.toString();
    }
}
