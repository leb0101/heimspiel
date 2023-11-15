package my;

/**
 * Klasse Abwehrspieler, die Erweiterung der Klasse Player
 */
public class Abwehrspieler extends Player{
    Abwehrspieler(String name, int gebDatumYear) {
        super(name, gebDatumYear);
    }

    @Override
    public String getFunction(){
        return getClass().getSimpleName();
    }

    @Override
    public String toString(){
        return getName() + " " + getGebDatumYear() + " " + getPlayerStrength() + " " + getFunction();
    }
}
