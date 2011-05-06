import java.applet.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

class Main extends Applet implements Runnable, MouseListener {
    private Ball blueball, redball;
    private Player player;
    boolean isStopped=true;
    Cursor c;
    Thread th;
    private Image dbImage;
    private Graphics dbg;
    public void init() {
        c=new Cursor(Cursor.CROSSHAIR_CURSOR);
        this.setCursor(c);
        addMouseListener(this);
        player = new Player();
        redball = new Ball();
        blueball = new Ball();
    }
    public void start() {
        th = new Thread(this);
        th.start();
    }
    public void stop() {
        th.stop();
    }
    public void run() {
        while(true) {
            if(player.getLives()>=0 && !isStopped) {
                redball.move();
                blueball.move();
            }
        }
    }
    public void paint(Graphics g) {
        if(player.getLives()>=0) {
            // Paint the two balls, score ...
            if(isStopped) {
                // paint information: "Start game with a double click"
            }
        }
        else if(player.getLives()<0) {
            // Paint final score, set isStopped true
        }
    }
    public void mouseClicked(MouseEvent e) {
        if(!isStopped) {
            if(redball.userHit()) {
                //-=Sound=-
                redball.ballWasHit();
            }
            if(blueball.userHit()) {
                //-=Sound=-
                blueball.ballWasHit();
            }
            else {
                //-=Sound=-
            }
        }
        else if(isStopped && e.getClickCount()==2) {
            isStopped=false;
            init();
        }
        return;
    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
}
