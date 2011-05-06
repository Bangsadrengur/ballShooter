import java.applet.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

class Ball extends Applet implements Runnable, MouseListener{
    int x_pos, x_speed;
    int y_pos, y_speed;
    int radius;
    // Gæti þurft að breyta.
    int x_appsize=300, y_appsize=300;
    int x_mouse, y_mouse;
    Random rnd=new Random();
    Player player;
    public Ball() {
        x_pos=150;
        y_pos=150;
        radius=20;
    }
    public void move() {
        x_pos+=x_speed;
        y_pos+=y_speed;
        // See if ball is still in area
        isOut();
    }
    public void ballWasHit() {
        x_pos=150;
        y_pos=150;
        // Hraði kúlunnar handahófsgerður að hámarki +/-4.
        x_speed=(rnd.nextInt())%4;
    }
    public boolean userHit() {
        double x=x_mouse-x_pos;
        double y=y_mouse-y_pos;
        double distance = Math.sqrt((x*x)+(y*y));
        if(distance<20) {
            player.addScore(10*Math.abs(x_speed)+10);
            return true;
        }
        else return false;
    }
    public void isOut() {
        if(x_pos>x_appsize+radius||x_pos<-radius) {
            x_pos=150; y_pos=150;
            player.looseLife();
        }
        if(y_pos>y_appsize+radius||y_pos<-radius) {
            x_pos=150; y_pos=150;
            player.looseLife();
        }
    }
    public void DrawBall(Graphics g) {}
    public void run() {}
    public void mouseClicked(MouseEvent e) {
        x_mouse=e.getX();
        y_mouse=e.getX();
    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}

}
