package core;


public class HandOperatedMasterSquirrel extends MasterSquirrel {

    private XY moveCommand = new XY(0, 0);

    public HandOperatedMasterSquirrel(int id, XY position) {
        super(id, position);
    }


    public void nextStep(EntityContext context) {
        if (getWaitTime() == 0) {
            context.tryMove(this, moveCommand);
            moveCommand = new XY(0, 0);
        }
        else {
            reduceWaitTime();
        }
    }

    public void setMoveCommand(XY moveCommand) {
        this.moveCommand = moveCommand;
    }


}
