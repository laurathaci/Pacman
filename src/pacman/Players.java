package pacman;

/**
 *
 * @author laura
 */
import javax.swing.*;
import java.awt.*;
 
public class Players{
    private Location loc;
    public Players(){
     
    }
     
    public Location getLocation(){
        return loc;
    }
     
    public void setLocation(Location k)
    {
        loc.set(k.getRow(), k.getCol());
    }
         
}
