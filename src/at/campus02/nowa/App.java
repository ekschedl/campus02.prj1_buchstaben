package at.campus02.nowa;

import at.campus02.nowa.figures.*;

import java.io.PrintStream;
import java.util.Scanner;

public class App {
    private final Scanner input;
    private final PrintStream output;
    private boolean exit = false;
    private int figureNr;
    private Figure figure;

    // Konstruktor
    // input wird verwendet um Daten vom Benutzer einzulesen (verwendet scanner)
    // output wird verwendet um Text auf der Konsole auszugeben (verwendet sysout)
    public App(Scanner input, PrintStream output){
        this.input = input;
        this.output = output;
    }

    //die Gameloop
    public void Run() {
        initialize();
        printState();

        while(!exit) {
            readUserInput();
            updateState();
            printState();
            askForScale();
        }
    }

    private void initialize() {
        output.println("Willkommen zu dem Figuren-Programm!");
        output.println("Wählen Sie eine der folgenden Figuren aus, um sie anzuzeigen:");
        output.println("1 - H");
        output.println("2 - I");
        output.println("3 - L");
        output.println("4 - Minus");
        output.println("5 - O");
        output.println("6 - O2");


    }

    private void readUserInput() {
        //TODO: Alle Eingaben der Benutzer einlesen
        inputFigure();
    }

    private void updateState() {
        //TODO: Benutzereingaben verarbeiten

        switch (figureNr){
            case 1:
                figure = new FigureH();
                break;
            case 2:
                figure = new FigureI();
                break;
            case 3:
                figure = new FigureL();
                break;
            case 4:
                figure = new FigureMinus();
                break;
            case 5:
                figure = new FigureO();
                break;
            case 6:
                figure = new FigureO2();
                break;
            default: break;
        }
    }

    private void printState() {
        //TODO: Ausgabe des aktuellen Zustands
        if (figure != null){
            output.println(figure);
        }
    }

    private void inputFigure() {
        // Hier sehen Sie ein Pattern für Benutzereingaben
        // Solange kein gültiger Wert eingegeben wurde, wird die Eingabe wiederholt
        do {
            output.println("Welche Grafik möchten Sie anzeigen (1-6)");
            figureNr = input.nextInt();
            if (figureNr < 1 || figureNr > 6) {
                output.println("Dies ist keine gültige Grafik!");
            } else {
                break;
            }
        } while (true);
    }

    private void askForScale() {
        output.println("Möchten Sie die Grafik skalieren? Geben Sie den Skalierungsfaktor ein (1 für keine Skalierung, 2 oder mehr für Skalierung):");
        int scaleFactor = input.nextInt();
        if (scaleFactor > 1) {
            figure.scale(scaleFactor); // Применяем масштабирование
            output.println("Skalierte Grafik:");
            output.println(figure);
        } else {
            output.println("Keine Skalierung angewendet.");
        }
    }
}
