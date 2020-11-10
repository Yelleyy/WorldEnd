package Gameyel;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;

public class ball4{

    Image  imgg = Toolkit.getDefaultToolkit().getImage( this.getClass().getResource( "meteor2 (2).gif"));
    int x, y = 170;
    ball4() {
    }
    public Image getImage() {
        return imgg;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public Rectangle2D getbound() {
        return (new Rectangle2D.Double(x, y, 650, 400));
    }
}
