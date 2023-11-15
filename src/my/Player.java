package my;

/**
 * Klasse Player die Ein Spieler-Objekt definiert
 */
public class Player {

    private String name;
    private int gebDatumYear;
    private int playerStrength;

    Player(String name, int gebDatumYear){
        this.name = name;
        this.gebDatumYear = gebDatumYear;
        this.playerStrength = (int) (Math.random()*9) +1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGebDatumYear() {
        return gebDatumYear;
    }

    public void setGebDatumYear(int gebDatumYear) {
        this.gebDatumYear = gebDatumYear;
    }

    public int getPlayerStrength() {
        return playerStrength;
    }

    public void setPlayerStrength(int playerStrength) {
        this.playerStrength = playerStrength;
    }

    public String getFunction(){
        return "Spieler";
    }

    @Override
    public String toString(){
        return name + " " + gebDatumYear + " " + playerStrength + " " + getFunction();
    }
}
