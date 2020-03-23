public class EntitySet {

    BoardGame boardGame;
    
    
    public void add(Entity entity, XY pos){
        boardGame.setEntity(pos,entity,true);
    }
    
    
    public void remove(Entity entity,XY pos){
        boardGame.setEntity(pos,null,true);
    }

}
