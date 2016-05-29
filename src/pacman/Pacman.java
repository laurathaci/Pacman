package pacman;
import javax.swing.*;
import java.awt.*;
 
public class Pacman extends Players
{
    private Location loc;
    private int life;
    public Pacman()
    {
        life = 0;
        loc = new Location(-1,-1);
    }
     
    public ImageIcon getImage()
    {
        return new ImageIcon("pac.png");
    }
     
 
    public Location getLocation(){
        return loc;
    }
     
    public void setLocation(Location k)
    {
        loc.set(k.getRow(), k.getCol());
    }
         
}