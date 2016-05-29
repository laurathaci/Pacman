/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

/**
 *
 * @author laura
 */
public class Location{
    private int row, col;
    public static final int RIGHT = 0, LEFT = 180, UP = 90, DOWN = 270;
     
    public Location(int r, int c){
        row = r;
        col = c;
    }
     
    public Location (Location loc) {
        row = loc.getRow();
        col = loc.getCol();
    }
     
    public boolean isEqual(Location c)
    {
        if(row == c.getRow() && col == c.getCol())
            return true;
        return false;
    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }
     
    public void set(int i, int x){
        row = i;
        col = x;
    }
 
}
