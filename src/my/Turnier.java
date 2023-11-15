package my;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Turnier {

    private ArrayList<Team> turnierListe;
    private static String logString ="Begegnung :";
    private static FileWriter fw;

    Turnier() {
        this.turnierListe = createPlan();
    }

    /**
     * Diese Methode stellt die Teams des Tuniers zusammen und gibt die Liste zurück
     *
     * @return ArrayList<Team>
     */
    private ArrayList<Team> createPlan() {
        turnierListe = new ArrayList<>();
        for (int i = 0; i < TunierConstant.ANZ; i++) {
            turnierListe.add(new Team("Nation " + (i+1) + " "));
        }
        return turnierListe;
    }

    /**
     * Methode playsAll
     * Legt eine log.txt - Datei an (oder überschreibt die Vorhandene und ruft die Methode plays() solange auf bis die
     * Liste nur noch eine Mannschaft hat (die Gesamt-Sieges-Mannschaft)
     * das Endergebnis wird in einen String geschrieben, dieser wird über ein FileWriter-Objekt
     * in die Log-Datei geschrieben.
     */
    public void playsAll(){
        try{
            fw = new FileWriter("log.txt",TunierConstant.APPEND);
        while (turnierListe.size() >= 2){
            plays();
        }
        logString += "****************************************************************\n";
        logString += "Der Tuniersieger ist : " + turnierListe.get(0).getNation() +   "\n";
        logString += "****************************************************************\n\n";

        fw.write(logString);
        fw.flush();
        fw.close();

        }catch(IOException e){
            System.out.println("Leider ist ein Fehler beim Schreiben aufgetreten");
        }

    }

    /**
     * Methode plays (nimmt zwei "zufällig" ausgewählte Mannschaften und ermittelt dann den Sieger)
     * die Teams (mit Spielern) und das Ergebnis der Partie wird in einem Log - String gespeichert.
     */
    private void plays() {
            int[] rdIndex = new int[2];
           do {
               for (int i = 0; i < 2; i++) {
                   rdIndex[i] = (int) (Math.random() * turnierListe.size());
               }
           }while (rdIndex[0] == rdIndex[1]);


            logString += "Es spielt : " + turnierListe.get(rdIndex[0]).getNation() + " - " + turnierListe.get(rdIndex[1]).getNation() +"\n";
            logString += "----------------------------------------------------------------------------------------------------------------\n";
            logString += turnierListe.get(rdIndex[0]) + "\n" + turnierListe.get(rdIndex[1]) +"\n";
            logString += "----------------------------------------------------------------------------------------------------------------\n";
            logString += "Gewinner Einzeilspiel: " + getWinner(turnierListe.get(rdIndex[0]), turnierListe.get(rdIndex[1])).getNation() + "\n\n";
            logString += "******************************************************************************************************************\n";
    }

    /**
     * Methode getWinner multipliziert die jeweiligen(gesamt) Stärken mit einem Zufallswert zwischen 55-100% und ermittelt dann
     * das Team, welches Gewonnen hat und liefert das Gewinner Team zurück.
     *
     * @param teamA vom Typ Team
     * @param teamB vom Typ Team
     * @return winner vom Typ Team
     */
    private Team getWinner(Team teamA, Team teamB) {
        Team winner = null;
        double powerA, powerB;
        double powerArandom = ((Math.random() * 46) + 55) / 100;
        double powerBrandom = ((Math.random() * 46) + 55) / 100;

        powerA = (int) (teamA.getPower() * powerArandom);
        powerB = (int) (teamB.getPower() * powerBrandom);

        if (powerA > powerB) {
            winner = teamA;
            turnierListe.remove(teamB);
            return teamA;
        } else if (powerA < powerB) {
            winner = teamB;
            turnierListe.remove(teamA);
            return teamB;
        } else {
           winner =  getWinner(teamA, teamB);
        }
        return winner;
    }


    @Override
    public String toString() {
        return "Im Tunier sind: " + turnierListe + "\n";
    }
}
