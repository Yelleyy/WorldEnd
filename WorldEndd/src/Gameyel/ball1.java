package Gameyel;

import java.awt.*;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;

public class ball1 {

    Image img = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("meteor.gif"));
    public int x = 0;
    public int y = (int) ((Math.random() * 300) + 20);
    public int count = 0;
    ball1() {       
        b1.start();
    }
    Thread b1 = new Thread(new Runnable() {

        @Override
        public void run() {
            while (true) {
                x += 2;
                if (x >= 1200) {
                    img = null;
                    b1 = null;
                    x = -500;
                    y = -500;
                }
                try {
                    b1.sleep(10);
                } catch (InterruptedException e) {
                }
            }
        }
    });
    public Image getImage() {
        return img;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Rectangle2D getbound() {
        return (new Rectangle2D.Double(x, y, 150, 140));
    }
}
