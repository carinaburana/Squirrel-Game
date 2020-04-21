package fatsquirrel.core;

import UI.ConsoleUI;

public class HandOperatedMS extends MasterSquirrel {

    public static final int START_ENERGY = 1000;
    private final static String TYPE = "HO";
ConsoleUI consoleUI = new ConsoleUI();

    public HandOperatedMS(XY startXy) {
        super(startXy, TYPE, START_ENERGY);
    }

    //fürs MiniSquirrels
    public HandOperatedMS(XY startXy, String type, int energy) {
        super(startXy, type, energy);
    }

    public static String getTYPE() { return TYPE; }

    public boolean checkMini(Entity entity) {
        if (entity instanceof MiniSquirrel) {
            return (((MiniSquirrel) entity).getPATRON() == this);
        } else return false;
    }

    public void nextStep(){
     xy.addDirection(consoleUI.nextStepVectorHOMS());
    }

}

