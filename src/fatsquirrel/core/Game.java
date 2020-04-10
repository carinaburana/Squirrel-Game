package fatsquirrel.core;

public abstract class Game {

    public Game(){

    }

    public abstract void render();
    //stellt Spielzustand auf Ausgabemedium dar

    public abstract void processInput();
    //verarbeitet Benutzereingaben

    public void update(){
        //verändert Spielzustandt(evtl +Eingaben) bereitet render vor


    }

//späterer loop
    public void run() {
        while (true) {
            render();
            processInput();
            update();
        }
    }

}
