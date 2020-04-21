package fatsquirrel.core;

public class Character extends Entity{

    protected Character(XY startXy, String type, int energy) {
        super(startXy, type, energy);
    }

    public void nextStep(){ super.nextStep(); }

    public void collision(Entity eOnNewPos, Board board, EntitySet entities) {
        updateEnergy(eOnNewPos.getEnergy());
        if(getEnergy() <= 0){
            entities.remove(this);
        }

        //energie update
        //entity fukken dies(
        //ggf entityOnNewPos löschen
        //ggf Beast timeOut+
        //zug auf neue Pos
        //spawnen neuer Entity)
    }
}
