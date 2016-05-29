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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
 
public class Grid implements KeyListener{
 //   private static ArrayList<Ghost> enemies;
    private static Pacman Player;
    private static ArrayList<Dot> food;
    private static Container pane;
    private static int index;
    private JFrame game;
    public Grid()
        {
   //         enemies = new ArrayList<Ghost>();
            game = new JFrame();
            game.setFocusable(true);
            game.setResizable(false);
            game.setTitle("Pac-Man 2.0");
            game.setPreferredSize(new Dimension(1000, 450));
            game.setBackground(Color.BLACK);
            game.addKeyListener(this);
            food = new ArrayList<Dot>();
            Player = new Pacman();
            int row = 10, col = 25;
            index = 0;
            game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
            pane = game.getContentPane();
            pane.setBackground(Color.white);
            pane.setLayout(new GridLayout(row, col, 0, 0));
            for(int i = 0; i < row; i++)
            {
                for(int a = 0; a < col; a++)
                {
                if(getGrid()[i][a] == 0){
                   //Adding Dot Images to Grid
                   Dot d = new Dot();
                   d.setLocation(new Location(i, a));
                   food.add(d);
                   pane.add(new JLabel(d.paintComponent(g)));
                }
                 
                             
                else
                    //Adding Boundery Images to Grid
                    pane.add(new JLabel(new ImageIcon("Wall.gif")));
                                 
                }
                 
            }
            game.pack(); 
             
        }
         
        private static int[][] getGrid(){
            //Creating Layout of grid
            int[][] gr = {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                          {1,0,0,0,0,0,1,1,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,1},
                          {1,0,1,1,1,0,1,1,0,0,0,0,0,0,0,0,1,1,1,1,1,0,1,0,1},
                          {1,0,0,0,0,0,0,0,0,0,0,1,1,0,1,0,0,0,0,0,0,0,0,0,1},
                          {1,0,1,1,1,0,1,1,0,0,0,0,0,0,1,0,1,1,1,1,0,0,1,0,1},
                          {1,0,1,1,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,1,0,1},
                          {1,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,1,1,1,1,1,0,1,0,1},
                          {1,0,1,1,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1},
                          {1,0,0,0,0,0,1,1,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,1},
                          {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
            return gr;
        }
         
     //   public ArrayList<Ghost> getActors(){
            //Returns array of ghosts
       //     return enemies;
       // }
         
        public Pacman getPac()
        {
            //Returns pacman
            return Player;
        }
         
        public static void move(int direction)
        {
            //Move method for pacman
            Location nw = new Location(getLocationInDirection(direction, Player.getLocation()));
            Location old = new Location(Player.getLocation());
            if(isValid(nw))
            {
                replace(old);
                movePac(nw);
                Player.setLocation(nw);
            }
                 
        }
         
       /* public static void move(int direction, int g)
        {
            Move method for Ghosts
            Location nw = new Location(getLocationInDirection(direction, enemies.get(g).getLocation()));
            Location old = new Location(enemies.get(g).getLocation());
            if(isValid(nw))
            {
                int num = (old.getRow() * 25) + old.getCol();
                boolean found = false;
                for(int i = 0; i < food.size(); i++){
                    if(food.get(i).getLocation().isEqual(old)){
                        pane.remove(num);
                        pane.add(new JLabel(new ImageIcon("dot.gif")), num);
                        found = true;
                    }
                         
                }
                if(!found) replace(old);
                     
                moveTo(nw, g);
                enemies.get(g).setLocation(nw);
            }
                 
        }
         */
        private static boolean isValid(Location loc)
        {
            //Checks if location is a wall
            int r = loc.getRow(), c = loc.getCol();
            if(getGrid()[r][c] == 0) return true;
 
            return false;
        }
         
        public static void movePac(Location x)
        {
            //moves pacman to location
            for(int i = 0; i < food.size(); i++)
                if(food.get(i).getLocation().isEqual(x))
                    food.remove(i);
            if(isValid(x))
            {
            int num = (x.getRow() * 25) + x.getCol();
            pane.remove(num);
            pane.add(new JLabel(Player.getImage()), num);
            Player.setLocation(x);
            }
 
        }
         
        public static void moveTo(Location x, int value)
        {
            //Moves ghost to location
            if(isValid(x))
            {
            int num = (x.getRow() * 25) + x.getCol();
            pane.remove(num);
        //    pane.add(new JLabel(enemies.get(value).getImage()), num);
      //      enemies.get(value).setLocation(x);
            }
        }
         
        public static void addGhost(Location x)
        {
            //Adds Ghost into game
            if(isValid(x)){
            Ghost g = new Ghost();
            int num = (x.getRow() * 25) + x.getCol();
            pane.remove(num);
            pane.add(new JLabel(g.getImage()), num);
            g.setLocation(x);
            g.setIndex(index);
          //  enemies.add(g);
            index++;
            }
             
        }
         
        public static void replace(Location loc)
        {
            //Replaces spot on grid with floor piece
            int num = (loc.getRow() * 25) + loc.getCol();
            pane.remove(num);
            pane.add(new JLabel(new ImageIcon("Floor.gif")), num);
        }
         
        public void show()
        {
            //Displays Grid
            game.setVisible(true); 
        }
         
        public static Location getLocationInDirection(int d, Location b)
        {
            if(d == Location.RIGHT)
                return new Location(b.getRow(), b.getCol() + 1);
            else if(d == Location.LEFT)
                return new Location(b.getRow(), b.getCol() - 1);
            else if(d == Location.UP)
                return new Location(b.getRow() - 1, b.getCol());
            else if(d == Location.DOWN)
                return new Location(b.getRow() + 1, b.getCol());
            else return null;   
        }

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
         
 
 
 
         
}
