package agh.ics.oop;

public class Vector2d {
    public final int x;
    public final int y;

    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString() {
        String s = "("+this.x+","+this.y+")";
        return s;
    }
    public boolean precedes(Vector2d other){
        if((this.x <= other.x) && (this.y <= other.y))
            return true;
        return false;

    }
    public boolean follows(Vector2d other){
        if((this.x >= other.x) && (this.y >= other.y))
            return true;
        return false;
    }
    public Vector2d upperRight(Vector2d other){
        int x1;
        int y1;
        if (this.x== other.x){
            x1 = this.x;
        } else if (this.x > other.x){
            x1= this.x;
        } else {
            x1 = other.x;
        }
        if (this.y== other.y){
            y1 = this.y;
        } else if (this.y > other.y){
            y1= this.y;
        } else {
            y1 = other.y;
        }
        Vector2d upperR = new Vector2d(x1, y1);
        return upperR;
    }

    public Vector2d lowerLeft(Vector2d other){
        int x1;
        int y1;
        if (this.x== other.x){
            x1 = this.x;
        } else if (this.x < other.x){
            x1= this.x;
        } else {
            x1 = other.x;
        }
        if (this.y== other.y){
            y1 = this.y;
        } else if (this.y < other.y){
            y1= this.y;
        } else {
            y1 = other.y;
        }
        Vector2d lowerL = new Vector2d(x1, y1);
        return lowerL;
    }
    public Vector2d add(Vector2d other){
        int x1= this.x + other.x;
        int y1 = this.y + other.y;
        Vector2d sum = new Vector2d(x1, y1);
        return sum;
    }
    public Vector2d subtract(Vector2d other){
        int x1= this.x - other.x;
        int y1 = this.y - other.y;
        Vector2d sub = new Vector2d(x1, y1);
        return sub;
    }
    public boolean equals(Object other){
        if (this == other)
            return true;
        if (!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d) other;
        if (this.x == that.x && this.y==that.y)
            return true;
        else return false;
    }
    public Vector2d opposite(){
        int x1 = (-1)*this.x;
        int y1 = (-1)*this.y;
        Vector2d oppo = new Vector2d(x1, y1);
        return oppo;
    }

}
// pakiety w javie