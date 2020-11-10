package Gameyel;

import java.awt.event.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.*;
import javax.swing.*;

public class state2 extends JPanel implements ActionListener, MouseListener, MouseMotionListener {

    public ImageIcon imgstate2 = new ImageIcon(this.getClass().getResource("space3.gif"));
    public ImageIcon next2 = new ImageIcon(this.getClass().getResource("nextstate.png"));
    public ImageIcon nextc2 = new ImageIcon(this.getClass().getResource("nextstateclick.png"));
    public ImageIcon imgwe = new ImageIcon(this.getClass().getResource("worldend.gif"));
    public ImageIcon trya=new ImageIcon(this.getClass().getResource("exit1.png"));
    public ImageIcon tryaclick=new ImageIcon(this.getClass().getResource("exitclick.png"));
    ImageIcon gover=new ImageIcon(this.getClass().getResource("gameover.gif"));
    public JButton Bnext2 = new JButton(next2);
    public JButton Bnextc2 = new JButton(nextc2);
    public JButton Btry2 = new JButton(trya);
    public JButton Btryc2 = new JButton(tryaclick);
    public ArrayList<ball1> ba1 = new ArrayList<ball1>();
    public ArrayList<ball2> ba2 = new ArrayList<ball2>();
    public ArrayList<ball3> ba3 = new ArrayList<ball3>();
    public ArrayList<Fireball> fireball = new ArrayList<Fireball>();
    spacecraft m = new spacecraft();
    state1 st1 = new state1();
    public int times2;
    boolean timestart2 = true;
    boolean startball2 = false;
    public int HP = 5;
    public int scor = 0;
    public int destroy2 = 15;
    public int countt = 0;
    public boolean blankcursor=true;
    public int getScore() {
        return scor;
    }
    Thread time2 = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
                if (timestart2 == false) {
                    repaint();
                }
            }
        }
    });
    Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                if (timestart2 == false) {
                    times2 = (times2 - 1);
                }
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {}
            }
        }
    });
    Thread ball1st2 = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    if (startball2 == false) {
                        Thread.sleep((long) (Math.random() * 7000) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startball2 == false) {
                    ba1.add(new ball1());
                }
            }
        }
    });
    Thread ball2st2 = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (startball2 == false) {
                        Thread.sleep((long) (Math.random() * 7000) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startball2 == false) {
                    ba2.add(new ball2());
                }
            }
        }
    });
    Thread ball3st2 = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    if (startball2 == false) {
                        Thread.sleep((long) (Math.random() * 7000) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startball2 == false) {
                    ba3.add(new ball3());
                }
            }
        }
    });
    state2() {
        st1.ball1st1.stop();
        st1.ball2st1.stop();
        this.setFocusable(true);
        this.setLayout(null);
        Bnext2.setBounds(300, 400, 355, 130);
        Btry2.setBounds(800, 450, 335, 110);
        Bnext2.addActionListener(this);
        Bnext2.setBorderPainted(false);
        Bnext2.setContentAreaFilled(false);
        Bnext2.addMouseListener(this);
        Bnextc2.addActionListener(this);
        Bnextc2.setBorderPainted(false);
        Bnextc2.setContentAreaFilled(false);
        Bnextc2.addMouseListener(this);
        Btry2.addActionListener(this);
        Btry2.setBorderPainted(false);
        Btry2.setContentAreaFilled(false);
        Btry2.addMouseListener(this);
        Btryc2.addActionListener(this);
        Btryc2.setBorderPainted(false);
        Btryc2.setContentAreaFilled(false);
        Btryc2.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        m.x = 1100;
        m.y = 340;
        time2.start();
        t2.start();
        ball1st2.start();
        ball2st2.start();
        ball3st2.start();
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imgstate2.getImage(), 0, 0, 1200, 700, this);
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
            if (ba.x < 0) {
                fireball.remove(i);
            }
        }
        for (int i = 0; i < ba1.size(); i++) {
            g.drawImage(ba1.get(i).getImage(), ba1.get(i).getX(), ba1.get(i).getY(), 250, 250, this);
            if (Intersect(ba1.get(i).getbound(), m.getbound())) {
                HP--;
                ba1.remove(i);
            }
        }
        for (int i = 0; i < fireball.size(); i++) {
            for (int j = 0; j < ba1.size(); j++) {
                if (Intersect(fireball.get(i).getbound(), ba1.get(j).getbound())) {
                    destroy2 -= 1;
                    ba1.remove(j);
                    fireball.remove(i);
                    scor += 5;
                }
            }
        }
        for (int i = 0; i < ba2.size(); i++) {
            g.drawImage(ba2.get(i).getImage(), ba2.get(i).getX(), ba2.get(i).getY(), 200, 200, this);
            if (Intersect(ba2.get(i).getbound(), m.getbound())) {
                HP--;
                ba2.remove(i);
            }
        }
        for (int i = 0; i < fireball.size(); i++) {
            for (int j = 0; j < ba2.size(); j++) {
                if (Intersect(fireball.get(i).getbound(), ba2.get(j).getbound())) {
                    destroy2 -= 1;
                    ba2.remove(j);
                    fireball.remove(i);
                    scor += 10;
                }
            }
        }
        for (int i = 0; i < ba3.size(); i++) {
            g.drawImage(ba3.get(i).getImage(), ba3.get(i).getX(), ba3.get(i).getY(), 300, 200, this);
            if (Intersect(ba3.get(i).getbound(), m.getbound())) {
                HP--;
                ba3.remove(i);
                countt = 0;
            }
        }
        for (int i = 0; i < fireball.size(); i++) {
            for (int j = 0; j < ba3.size(); j++) {
                if (Intersect(fireball.get(i).getbound(), ba3.get(j).getbound())) {
                    countt++;
                    fireball.remove(i);
                    if (countt >= 3) {
                        destroy2 -= 1;
                        ba3.remove(j);
                        scor += 15;
                        countt = 0;
                    }
                }
            }
        }
        g.setFont(new Font("2005_iannnnnAMD", Font.BOLD, 95));
        g.setColor(Color.YELLOW);
        g.drawString("SCORE = " + scor, 80, 90);
        g.setColor(Color.cyan);
        g.drawString("STATE 2", 455, 90);
        g.setColor(Color.GREEN);
        g.drawString("TIME " + times2, 410, 170);
        g.setColor(Color.RED);
        g.drawString("HP " + HP, 100, 170);
        g.setColor(Color.MAGENTA);
        g.drawString("REMAIN " + destroy2, 800, 90);
        if ((destroy2 <=0) && (times2 >= 0)) {
            super.paintComponent(g);
            ball1st2.stop();
            ball2st2.stop();
            ball3st2.stop();
            t2.stop();
            time2.stop();
            this.add(Bnext2);
            super.setBackground(Color.black);
            g.setColor(Color.WHITE);
            g.setFont(new Font("2005_iannnnnAMD", Font.BOLD, 70));
            g.drawString("SCORE   " + scor, 300, 200);
            g.setFont(new Font("2005_iannnnnAMD", Font.BOLD, 100));
            g.drawString("STATE 2 CLEAR!!", 250, 150);
        } else if (HP <= 0 || (times2 <= 0)) {
            ball1st2.stop();
            ball2st2.stop();
            ball3st2.stop();
            t2.stop();
            time2.stop();
            this.add(Btry2);
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
        if (e.getSource() == Bnext2) {
            remove(Bnext2);
            add(Bnextc2);
            Bnextc2.setBounds(300, 400, 355, 130);
        }
        else if(e.getSource()==Btry2){
            remove(Btry2);
            add(Btryc2);
            Btryc2.setBounds(800, 450, 335, 110);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == Bnextc2) {
            remove(Bnextc2);
            add(Bnext2);
            Bnext2.setBounds(300, 400, 355, 130);
        }
        else if(e.getSource()==Btryc2){
            remove(Btryc2);
            add(Btry2);
            Btry2.setBounds(800, 450, 335, 110);
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
