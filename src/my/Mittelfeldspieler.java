package my;

/**
 * Klasse Mittelfeldspieler erweitert die Klasse Player
 */
public class Mittelfeldspieler extends Player{
    Mittelfeldspieler(String name, int gebDatumYear) {
        super(name, gebDatumYear);
    }

    @Override
    public String getFunction(){
        return getClass().getSimpleName();
    }

    @Override
    public String toString(){
        return getName() + " " + getGebDatumYear() + " " + getGebDatumYear() + " " + getFunction();
    }
}
