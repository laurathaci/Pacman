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
 
public class Dot extends Players
{
    private Location loc;
    public Dot(){
         
    }
     
    public void setLocation(Location k)
    {
        loc = new Location(k);
    }
         
     
    public Location getLocation()
    {
        return loc;
    }
     
    public void paintComponent(Graphics g)
    {g.setColor(Color.BLACK);
      g.fillRect(0, 0, 60, 60);}
   // public ImageIcon getImage()
    //{
     //   return new ImageIcon("dot.png");
   // }
}
