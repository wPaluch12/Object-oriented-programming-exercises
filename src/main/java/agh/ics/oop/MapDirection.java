package agh.ics.oop;

public enum MapDirection {
    NORTH, SOUTH, WEST, EAST;

    public String toString(){
        switch (this){
            case EAST: return "Wschód";
            case NORTH: return "Północ";
            case SOUTH: return "Południe";
            case WEST: return "Zachód";
            default: throw new IllegalArgumentException();
        }
    }
    public MapDirection next(){
        switch(this){
            case EAST: return SOUTH;
            case SOUTH: return WEST;
            case WEST:return NORTH;
            case NORTH: return EAST;
            default: throw new IllegalArgumentException();
        }
    }
    public MapDirection previous(){
        switch(this){
            case EAST: return NORTH;
            case SOUTH: return EAST;
            case WEST:return SOUTH;
            case NORTH: return WEST;
            default: throw new IllegalArgumentException();
        }
    }
    public Vector2d toUnitVector(){
        switch(this){
            case EAST: return new Vector2d(1,0);
            case SOUTH: return new Vector2d(0,-1);
            case WEST:return new Vector2d(-1,0);
            case NORTH: return new Vector2d(0,1);
            default: throw new IllegalArgumentException();
        }
    }

}
