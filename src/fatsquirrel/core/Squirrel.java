package fatsquirrel.core;

public abstract class Squirrel extends Entity {

    private  int startEnergy;
   private String type;
    private int id;
    XY xy;
    int timeOut;

    public Squirrel(XY startXy, int id, String type, int energy) {
        super(startXy, id, type, energy);
        this.timeOut = 0;
    }

    public void updateEnergy(int deltaEnergy) {
        this.energy += deltaEnergy;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    public int getTimeOut() {
        return timeOut;
    }


    public XY nextStep() {
        if (timeOut > 0) {
            timeOut--;
            return this.getXy();
        }
        return super.nextStep();
    }

    public void collision(Entity eOnNewPos, Board board, EntitySet entities) {

        String type = eOnNewPos.getType();

        if (!(eOnNewPos instanceof Squirrel)) {
            updateEnergy(eOnNewPos.getEnergy());
        }
        switch (type) {
            case "WA":
                this.timeOut = 3;
                break;
            case "BP":
                entities.remove(eOnNewPos);
                entities.add(new BadPlant(board.generateXY(), entities.generateId()));
                break;
            case "GP":
                entities.remove(eOnNewPos);
                entities.add(new GoodPlant(board.generateXY(), entities.generateId()));
                break;
            case "BB":
                BadBeast bb = ((BadBeast) eOnNewPos);
                bb.setBites(bb.getBites() - 1);
                if (bb.getBites() > 1){
                entities.remove(eOnNewPos);}
                 break;
            case "GB":



            this.updateEnergy(eOnNewPos.getEnergy());

            //de.hsa.games.fatsquirrel.core.GoodPlant, de.hsa.games.fatsquirrel.core.GoodBeast, de.hsa.games.fatsquirrel.core.BadPlant: Positionsänderung + updateEnergy()
            if (eOnNewPos.getType().equals(BadPlant.getTYPE())
                    || eOnNewPos.getType().equals(GoodPlant.getTYPE())
                    || eOnNewPos.getType().equals(GoodBeast.getTYPE())) {
                this.updateEnergy(eOnNewPos.getEnergy());
                XY newPos = eOnNewPos.getXy();
                entities.remove(eOnNewPos);
                this.setXy(newPos);

            } else if (eOnNewPos.getType().equals(MiniSquirrel.getTYPE())
                    && ((MasterSquirrel) this).checkMini(eOnNewPos)) {
                //wenn de.hsa.games.fatsquirrel.core.MiniSquirrel aus eigener Produktion
            } else {
                //keine collision
            }
        }
    }
}
