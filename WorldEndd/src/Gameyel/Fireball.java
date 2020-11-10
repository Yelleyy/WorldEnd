package Gameyel;

import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fireball extends JPanel {

    public ImageIcon fire = new ImageIcon();

    public int y;

    public int x;

    public int count = 0;

    Fireball(int x, int y) {
        String imageLocation = "fire.gif";
        fire = new ImageIcon(this.getClass().getResource(imageLocation));
        this.x = x;
        this.y = y;
    }

    public void move() {
        this.x -= 5;
    }

    public Rectangle2D getbound() {
        return (new Rectangle2D.Double(x, y, 30, 30));
    }
}
