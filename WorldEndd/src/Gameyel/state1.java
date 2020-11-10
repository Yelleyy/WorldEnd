package Gameyel;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.geom.*;

import java.net.*;
import java.util.*;
import javax.swing.*;

public class state1 extends JPanel implements ActionListener, MouseListener, MouseMotionListener {

    public ImageIcon imgstate1 = new ImageIcon(this.getClass().getResource("space2.gif"));
    public ImageIcon imgwe = new ImageIcon(this.getClass().getResource("worldend.gif"));
    public ImageIcon boom = new ImageIcon(this.getClass().getResource("boom.png"));
    public ImageIcon trya=new ImageIcon(this.getClass().getResource("exit1.png"));
    public ImageIcon tryaclick=new ImageIcon(this.getClass().getResource("exitclick.png"));
    public ImageIcon gover=new ImageIcon(this.getClass().getResource("gameover.gif"));
    spacecraft m = new spacecraft();
    public ImageIcon next = new ImageIcon(this.getClass().getResource("nextstate.png"));
    public ImageIcon nextc = new ImageIcon(this.getClass().getResource("nextstateclick.png"));
    public JButton Bnext = new JButton(next);
    public JButton Bnextc = new JButton(nextc);
    public JButton Btry = new JButton(trya);
    public JButton Btryc = new JButton(tryaclick);
    public ArrayList<Fireball> fireball = new ArrayList<Fireball>();
    public ArrayList<ball1> ba1 = new ArrayList<>();
    public ArrayList<ball2> ba2 = new ArrayList<>();
    public ArrayList<ball3> ba3 = new ArrayList<>();
    public int times;
    public int HP = 5;
    boolean timestart = true;
    boolean startball = false;
    public int scor = 0;
    public int destroy1 = 10;  
    public int getScore() {
        return scor;
    }
    Thread time = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
                if (timestart == false) {
                    repaint();
                }
            }
        }
    });
    Thread ball1st1 = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    if (startball == false) {
                        Thread.sleep((long) (Math.random() * 7000) + 2000);
                    }
                } catch (InterruptedException e) {}
                if (startball == false) {
                    ba1.add(new ball1());
                }
            }
        }
    });

    Thread ball2st1 = new Thread(new Runnable() {

        public void run() {
            while (true) {
                try {
                    if (startball == false) {
                        Thread.sleep((long) (Math.random() * 7000) + 2000);
                    }
                } catch (InterruptedException e) {}
                if (startball == false) {
                    ba2.add(new ball2());
                }
            }
        }
    });

    Thread t = new Thread(new Runnable() {

        @Override
        public void run() {
            while (true) {
                if (timestart == false) {
                    times = (times - 1);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });

    state1() {      
        this.setFocusable(true);
        this.setLayout(null);
        Bnext.setBounds(300, 400, 355, 130);
        Btry.setBounds(800, 450, 335, 110);
        Bnext.addActionListener(this);
        Bnext.setBorderPainted(false);
        Bnext.setContentAreaFilled(false);
        Bnext.addMouseListener(this);
        Bnextc.addActionListener(this);
        Bnextc.setBorderPainted(false);
        Bnextc.setContentAreaFilled(false);
        Bnextc.addMouseListener(this);
        Btry.addActionListener(this);
        Btry.setBorderPainted(false);
        Btry.setContentAreaFilled(false);
        Btry.addMouseListener(this);
        Btryc.addActionListener(this);
        Btryc.setBorderPainted(false);
        Btryc.setContentAreaFilled(false);
        Btryc.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        m.x = 1100;
        m.y = 340;
        time.start();
        t.start();
        ball1st1.start();
        ball2st1.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imgstate1.getImage(), 0, 0, 1200, 700, this);
        g.drawImage(m.c.getImage(), m.x, m.y - 50, 200, 200, this);
        if (m.x < 0) {
            m.x = this.getWidth() - 10;
        }
        if (m.x > this.getWidth()) {
            m.x = 20;
        }
        for (int i = 0; i < fireball.size(); i++) {
            Fireball ba = fireball.get(i);
            g.drawImage(ba.fire.getImage(), ba.x, ba.y + 50, 130, 70, null);
            ba.move();
            ba.count++;
            if (ba.x < 0) {
                fireball.remove(i);
            }
        }
        for (int i = 0; i < ba1.size(); i++) {
            g.drawImage(ba1.get(i).getImage(), ba1.get(i).getX(), ba1.get(i).getY(), 250, 250, this);
            if (Intersect(ba1.get(i).getbound(), m.getbound())) {
                g.drawImage(boom.getImage(), m.x, m.y, 150, 150, this);
                HP--;
                ba1.remove(i);
            }
        }
        for (int i = 0; i < fireball.size(); i++) {
            for (int j = 0; j < ba1.size(); j++) {
                if (Intersect(fireball.get(i).getbound(), ba1.get(j).getbound())) {
                    destroy1 -= 1;
                    ba1.remove(j);
                    fireball.remove(i);
                    scor += 5;
                }
            }
        }
        for (int i = 0; i < ba2.size(); i++) {
            g.drawImage(ba2.get(i).getImage(), ba2.get(i).getX(), ba2.get(i).getY(), 200, 200, this);
            if (Intersect(ba2.get(i).getbound(), m.getbound())) {
                g.drawImage(boom.getImage(), m.x, m.y, 150, 150, this);
                HP--;
                ba2.remove(i);
            }
        }
        for (int i = 0; i < fireball.size(); i++) {
            for (int j = 0; j < ba2.size(); j++) {
                if (Intersect(fireball.get(i).getbound(), ba2.get(j).getbound())) {
                    destroy1 -= 1;
                    ba2.remove(j);
                    fireball.remove(i);
                    scor += 10;
                }
            }
        }
        g.setFont(new Font("2005_iannnnnAMD", Font.BOLD, 95));
        g.setColor(Color.YELLOW);
        g.drawString("SCORE = " + scor, 80, 90);
        g.setColor(Color.cyan);
        g.drawString("STATE 1", 455, 90);
        g.setColor(Color.GREEN);
        g.drawString("TIME " + times, 410, 170);
        g.setColor(Color.RED);
        g.drawString("HP " + HP, 100, 170);
        g.setColor(Color.MAGENTA);
        g.drawString("REMAIN " + destroy1, 800, 90);
        if ((destroy1 <= 0) && (times >= 0)) {
            super.paintComponent(g);
            this.add(Bnext);
            ball1st1.stop();
            ball2st1.stop();
            t.stop();
            time.stop();
            setBackground(Color.black);
            g.setColor(Color.WHITE);
            g.setFont(new Font("2005_iannnnnAMD", Font.BOLD, 70));
            g.drawString("YOUR SCORE  " + scor, 300, 200);
            g.setFont(new Font("2005_iannnnnAMD", Font.BOLD, 100));
            g.drawString("STATE CLEAR!!", 250, 150);
        } else if (HP <= 0 || (times <= 0)) {
            ball1st1.stop();
            ball2st1.stop();
            t.stop();
            time.stop();
            this.add(Btry);
            g.drawImage(imgwe.getImage(), 0, 0, 1200, 700, this);
            g.setColor(Color.YELLOW);
            g.setFont(new Font("2005_iannnnnAMD", Font.BOLD, 70));
            g.drawString("SCORE  " + scor, 250, 150);
            g.setFont(new Font("2005_iannnnnAMD", Font.BOLD, 100));
            g.drawImage(gover.getImage(), getHeight()/2+70,500, this);
        }
    }

    public boolean Intersect(Rectangle2D a, Rectangle2D b) {
        return (a.intersects(b));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        fireball.add(new Fireball(m.x - 100, m.y));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == Bnext) {
            remove(Bnext);
            add(Bnextc);
            Bnextc.setBounds(300, 400, 355, 130);
        }
        else if(e.getSource()==Btry){
            remove(Btry);
            add(Btryc);
            Btryc.setBounds(800, 450, 335, 110);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == Bnextc) {
            remove(Bnextc);
            add(Bnext);
            Bnext.setBounds(300, 400, 355, 130);
        }
        else if(e.getSource()==Btryc){
            remove(Btryc);
            add(Btry);
            Btry.setBounds(800, 450, 335, 110);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        m.x = e.getX() - 100;
        m.y = e.getY() - 50;
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }
}
