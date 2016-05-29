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
import java.awt.event.*;
import java.awt.event.KeyEvent;
 
public class PacRunner implements KeyListener
{
        private static Grid gr;
        public static void main (String[] args)
        {   
        gr = new Grid();
        gr.addGhost(new Location(1,1));
        gr.movePac(new Location(4,1));
        gr.show();
        }
     
        public void keyPressed(KeyEvent e)
        {
            if(e.getKeyCode() == KeyEvent.VK_LEFT);          
            else if(e.getKeyCode() == KeyEvent.VK_RIGHT);
            else if(e.getKeyCode() == KeyEvent.VK_UP);
            else if(e.getKeyCode() == KeyEvent.VK_DOWN);
             
        }
 
     
        public void keyReleased(KeyEvent e)
        {
             
        }
         
        public void keyTyped(KeyEvent e)
        {
         
        }
}
