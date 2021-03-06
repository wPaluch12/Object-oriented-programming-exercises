package agh.ics.oop;

import java.awt.*;
import java.util.ArrayList;

public class SimulationEngine implements IEngine{
    private MoveDirection[] moves;
    private IWorldMap map;
    private Vector2d[] startingPoints;
    private ArrayList<Animal> animals = new ArrayList<>();
    private ArrayList<Grass> grasses = new ArrayList<>();

    public SimulationEngine(MoveDirection[] moves,  IWorldMap map, Vector2d[] startingPoints) {
        this.moves = moves;
        this.map = map;
        this.startingPoints = startingPoints;
        for(Vector2d position: this.startingPoints){
            map.place(new Animal(map, position));
        }

    }

    public ArrayList<Animal> getAnimals(){
        return animals;
    }


    @Override
    public void run(){
        //RectangularMap rec = (RectangularMap)map;
        GrassField rec = (GrassField)map;
        int w = rec.getWidth();
        int h = rec.getHeight();
        for(int k = 0; k <= w; k++) {
            for (int j = 0; j <= h; j++) {
                Vector2d test = new Vector2d(k, j);
                Object anim = this.map.objectAt(test);
                if( anim != null){
                    if (anim  instanceof Animal ) {
                        this.animals.add((Animal) anim);
                    }
                }

            }
        }
        System.out.println(map.toString());
        for(int i = 0; i < moves.length; i++) {
            if(moves[i] != null) {
                if(i%2 == 0){
                    for( int k =0; k < animals.size(); k+=2){
                        //Vector2d old = animals.get(k).getPosition();
                        animals.get(k).move(moves[i]);
                        //((GrassField) map).positionChanged(old,animals.get(k).getPosition() );
                    }
                }
                else {
                    for( int k =1; k < animals.size(); k+=2)
                    {
                        //Vector2d old = animals.get(k).getPosition();
                        animals.get(k).move(moves[i]);
                        //((GrassField) map).positionChanged(old,animals.get(k).getPosition());
                    }
                }

                //System.out.println(map.toString());
            }
        }
        System.out.println(map.toString());

    }

}
