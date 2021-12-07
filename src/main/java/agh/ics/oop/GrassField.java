package agh.ics.oop;

import java.util.ArrayList;
import java.lang.Math;

public class GrassField extends AbstractWorldMap{

    private  Integer grassfield_number;

    private ArrayList<Grass> grassfield = new ArrayList<>();
    /*private ArrayList<Animal> animals = new ArrayList<>();

    private Integer width = 0;
    private Integer height = 0;*/

    public GrassField(int grassfield_number){

        this.height= grassfield_number;
        this.width=grassfield_number;
        this.grassfield_number = grassfield_number;

        int max_gras = (int)(Math.sqrt(grassfield_number *10));
        for (int i=0; i<this.grassfield_number; i++){

            int x = (int)Math.floor(Math.random()*(max_gras+1)+0);
            int y = (int)Math.floor(Math.random()*(max_gras+1)+0);

            Grass grass = new Grass(new Vector2d(x,y));

            while( this.GrassAt(grass.getGrass_position())){
                x = (int)Math.floor(Math.random()*(max_gras+1)+0);
                y = (int)Math.floor(Math.random()*(max_gras+1)+0);
                grass = new Grass(new Vector2d(x,y));
            }
            this.grassfield.add(grass);

        }
    }


    public Integer getWidth(){
        return this.width;
    }
    public Integer getHeight(){
        return this.height;
    }

    public ArrayList<Grass> getGrass(){
        return this.grassfield;
    }

    public boolean GrassAt(Vector2d position){
        for (Grass gras: grassfield) {
            if(gras.getGrass_position().equals(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if(super.isOccupied(position)){
            return true;
        }
        for(Grass grass : this.grassfield){
            if(grass.getGrass_position().equals(position))
                return true;
        }
        return false;
    }


    @Override
    public Object objectAt(Vector2d position) {
        Object object =  super.objectAt(position);
        if(object instanceof Animal){
            return object;
        }
        for (Grass grass: this.grassfield) {
            if (grass.getGrass_position().equals(position)) {
                return grass;
            }
        }
        return null;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(this.isOccupied(position)){
            return false;
        }
        if(position.x < 0 || position.y < 0) {
            return false;
        }
        if (position.x > this.width ){
            this.width=position.x;
        }
        if(position.y > this.height){
            this.height=position.y;
        }
        return true;
    }


}
