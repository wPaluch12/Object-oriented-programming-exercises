package agh.ics.oop;
import java.util.*;

public class MapBoundary implements IPositionChangeObserver{
    private final SortedSet<Object> xObjects;
    private final SortedSet<Object> yObjects;

    public MapBoundary() {
        xObjects = new TreeSet<>(new Comparator<Object>() {
            @Override
            public int compare(Object compared, Object compared_to) {
                Vector2d compared_position = null ;
                Vector2d compared_to_position = null;

                if(compared instanceof Animal){
                    compared_position = ((Animal) compared).getPosition();
                }
                else if (compared instanceof  Grass){
                    compared_position =  ((Grass) compared).getGrass_position();
                }
                if(compared_to instanceof Animal){
                    compared_to_position =  ((Animal) compared_to).getPosition();
                }
                else if (compared_to instanceof  Grass){
                    compared_to_position =  ((Grass) compared_to).getGrass_position();
                }

                int compare_result = Integer.compare(compared_position.x, compared_to_position.x);

                if(compare_result != 0)
                    return compare_result;

                compare_result = Integer.compare(compared_position.y, compared_to_position.y);

                if(compare_result != 0)
                    return compare_result;

                if( compared instanceof Animal && compared_to instanceof Grass )
                    return -1;
                else if ( compared instanceof Grass && compared_to instanceof Animal )
                    return 1;
                else return 0;


            }
        });
        yObjects = new TreeSet<>(new Comparator<Object>() {
            @Override
            public int compare(Object compared, Object compared_to) {
                Vector2d compared_position = null ;
                Vector2d compared_to_position = null;

                if(compared instanceof Animal){
                    compared_position = ((Animal) compared).getPosition();
                }
                else if (compared instanceof  Grass){
                    compared_position =  ((Grass) compared).getGrass_position();
                }
                if(compared_to instanceof Animal){
                    compared_to_position =  ((Animal) compared_to).getPosition();
                }
                else if (compared_to instanceof  Grass){
                    compared_to_position =  ((Grass) compared_to).getGrass_position();
                }

                int compare_result = Integer.compare(compared_position.y, compared_to_position.y);
                if(compare_result != 0)
                    return compare_result;

                compare_result = Integer.compare(compared_position.x, compared_to_position.x);
                if(compare_result != 0)
                    return compare_result;

                if( compared instanceof Animal && compared_to instanceof Grass )
                    return -1;
                else if ( compared instanceof Grass && compared_to instanceof Animal )
                    return 1;
                else return 0;


            }
        });
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for (Object item : xObjects) {
            if (item instanceof Animal) {
                if(((Animal)item).getPosition() == oldPosition){
                    xObjects.remove((item));
                    xObjects.add(item);
                    break;
                };
            }
        }
        for (Object item : yObjects) {
            if (item instanceof Animal) {
                if(((Animal)item).getPosition() == oldPosition){
                    yObjects.remove(item);
                    yObjects.add(item);
                    break;
                };
            }
        }
    }

    public void placeAnimal(Animal animal){
        xObjects.add(animal);
        yObjects.add(animal);
    }

    public void removeObject(Object object){
        xObjects.remove(object);
        yObjects.remove(object);
    }

    public void placeGrass(Grass grass){
        xObjects.add(grass);
        yObjects.add( grass);
    }

    public Vector2d getLeftCorner(){
        Object object_left = yObjects.first();
        Object object_right = xObjects.first();
        if(object_left instanceof Animal && object_right instanceof Animal){
            return ((Animal) object_left).getPosition().lowerLeft(((Animal) object_right).getPosition());
        }
        else if(object_left instanceof Animal && object_right instanceof Grass){
            return ((Animal) object_left).getPosition().lowerLeft(((Grass) object_right).getGrass_position());
        }
        else if(object_left instanceof Grass && object_right instanceof Animal){
            return ((Grass) object_left).getGrass_position().lowerLeft(((Animal) object_right).getPosition());
        }
        else if(object_left instanceof Grass && object_right instanceof Grass){
            return ((Grass) object_left).getGrass_position().lowerLeft(((Grass) object_right).getGrass_position());
        }
        else
            return new Vector2d(0,0);
    }

    public Vector2d getRightCorner(){
        Object object_left = yObjects.last();
        Object object_right = xObjects.last();
        if(object_left instanceof Animal && object_right instanceof Animal){
            return ((Animal) object_left).getPosition().upperRight(((Animal) object_right).getPosition());
        }
        else if(object_left instanceof Animal && object_right instanceof Grass){
            return ((Animal) object_left).getPosition().upperRight(((Grass) object_right).getGrass_position());
        }
        else if(object_left instanceof Grass && object_right instanceof Animal){
            return ((Grass) object_left).getGrass_position().upperRight(((Animal) object_right).getPosition());
        }
        else if(object_left instanceof Grass && object_right instanceof Grass){
            return ((Grass) object_left).getGrass_position().upperRight(((Grass) object_right).getGrass_position());
        }
        else
            return new Vector2d(10,10);
    }
}



