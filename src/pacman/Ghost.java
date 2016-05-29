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
import javax.swing.*;
import java.awt.*;
 
 
public class Ghost extends Players
{
    private Location loc;
    public int index;
    public Ghost()
    {
        loc = new Location(-1,-1);
    }
     
    public void setLocation(Location k)
    {
        loc.set(k.getRow(), k.getCol());
    }
     
    public void setIndex(int i)
    {
        index = i;
    }   
     
    public Location getLocation()
    {
        return loc;
    }
     
    public ImageIcon getImage()
    {
        return new ImageIcon("Ghost.png");
    }
}
