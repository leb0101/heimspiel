package my;

import java.util.ArrayList;

/**
 * Klasse Team hat als Instanzvariablen ein String nation,eine interne ID, eine ArrayList<Player>, sowie
 * eine statische Zählvariable counter (um die jeweiligen automatisch hochzuzählen)
 */
public class Team {

    private ArrayList<Player> playerList = new ArrayList<>();
    private String nation;
    private int id;
    private static int counter = 1;

    Team(String nation){
        this.playerList = create();
        this.nation = nation;
        id = counter;
        counter++;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public int getId() {
        return id;
    }

    /**
     * Methode create() erstellt 5 Abwehrspieler, 5 Mittelfeldspieler und 1 Torwart.
     * @return ArrayList<Player>
     */
    public ArrayList<Player> create(){
        for (int i=0; i <= 5; i++){
            playerList.add(new Abwehrspieler("Abwehr"+i,1980+i));
        }

        for (int i=0; i <=5; i++){
            playerList.add(new Mittelfeldspieler("Mittel" + i, 1980 + i));
        }

        playerList.add(new Torwart("Keeper",1977));

        return playerList;
    }

    public int getPower(){
       int allPlayerStrength=0;
        for(Player p : playerList) {
          allPlayerStrength += p.getPlayerStrength();
       }
        return allPlayerStrength;
    }

    @Override
    public String toString(){
        return getId() +". "+ nation + " Stärke:" + getPower() + "\n" + playerList + "\n";
    }

}
