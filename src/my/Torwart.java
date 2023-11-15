package my;

/**
 * Klasse Torwart, die Erweiterung der Klasse Player
 */
public class Torwart extends Player{

    Torwart(String name, int gebDatumYear) {
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
