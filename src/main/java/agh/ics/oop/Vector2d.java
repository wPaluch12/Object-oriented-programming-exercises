package agh.ics.oop;

import java.util.Objects;

public class Vector2d {
    public final int x;
    public final int y;

    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "("+ this.x+","+ this.y+")";
    }
    public boolean precedes(Vector2d other){
        return (this.x <= other.x) && (this.y <= other.y);

    }
    public boolean follows(Vector2d other){
        return (this.x >= other.x) && (this.y >= other.y);
    }

    public Vector2d upperRight(Vector2d other){
        int x1;
        int y1;
        if (this.x== other.x){
            x1 = this.x;
        } else x1 = Math.max(this.x, other.x);
        if (this.y== other.y){
            y1 = this.y;
        } else y1 = Math.max(this.y, other.y);
        return new Vector2d(x1, y1);
    }

    public Vector2d lowerLeft(Vector2d other){
        int x1;
        int y1;
        if (this.x== other.x){
            x1 = this.x;
        } else x1 = Math.min(this.x, other.x);
        if (this.y== other.y){
            y1 = this.y;
        } else y1 = Math.min(this.y, other.y);
        return new Vector2d(x1, y1);
    }
    public Vector2d add(Vector2d other){
        int x1 = this.x + (other.x);
        int y1 = this.y + (other.y);
        return new Vector2d(x1, y1);
    }
    public Vector2d subtract(Vector2d other){
        int x1= this.x - (other.x);
        int y1 = this.y - (other.y);
        return new Vector2d(x1, y1);
    }
    public boolean equals(Object other){
        if (this == other)
            return true;
        if (!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d)other;
        if (this.x == that.x && this.y==that.y)
            return true;
        if(this.hashCode()==that.hashCode())
            return true;
        else
            return false;
    }
    public Vector2d opposite(){
        int x1 = (-1)*this.x;
        int y1 = (-1)*this.y;
        return new Vector2d(x1, y1);
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }

}