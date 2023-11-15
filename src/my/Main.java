package my;

public class Main {

    /**
     * Main-Klasse:
     * Erstellt erst ein Tunier-Objekt, dann wird die Objekt-Methode playsAll() aufgerufen
     * Im Anschluss wird ein Thread erzeugt durch die Implementation des Interface "Runnable"
     *
     */


    public static void main(String[] args) {

        Turnier turnier = new Turnier();
        turnier.playsAll();

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                UI.init();
            }
        });
    }
}
