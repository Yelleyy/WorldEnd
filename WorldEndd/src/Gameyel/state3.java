package Gameyel;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;
import javax.swing.*;

public class state3 extends JPanel implements ActionListener, MouseListener, MouseMotionListener {

    private final ImageIcon imgstate3 = new ImageIcon(this.getClass().getResource("space4.gif"));
    ImageIcon gover=new ImageIcon(this.getClass().getResource("gameover.gif"));
    public ImageIcon imgwe = new ImageIcon(this.getClass().getResource("worldend.gif"));
    public ImageIcon next3 = new ImageIcon(this.getClass().getResource("nextstate.png"));
    public ImageIcon nextc3 = new ImageIcon(this.getClass().getResource("nextstateclick.png"));
    public ImageIcon trya=new ImageIcon(this.getClass().getResource("exit1.png"));
    public ImageIcon tryaclick=new ImageIcon(this.getClass().getResource("exitclick.png"));
    public JButton Bnext3 = new JButton(next3);
    public JButton Bnextc3 = new JButton(nextc3);
    public JButton Btry3 = new JButton(trya);
    public JButton Btryc3 = new JButton(tryaclick);
    public ArrayList<ball1> ba1 = new ArrayList<ball1>();
    public ArrayList<ball2> ba2 = new ArrayList<ball2>();
    public ArrayList<ball3> ba3 = new ArrayList<ball3>();
    public ArrayList<Fireball> fireball = new ArrayList<Fireball>();
    spacecraft m = new spacecraft();
    state2 st2 = new state2();
    boolean timestart3 = true;
    boolean startball3 = false;
    public int times3;
    public int countt3 = 0;
    public int HP = 5;
    public int scor = 0;
    public int destroy3 = 20;
    public boolean boss = false;
    public int ball4x = -500;
    public boolean blankcursor=true;
    public int getScore() {
        return scor;
    }
    public state3() {
        st2.ball1st2.stop();
        st2.ball2st2.stop();
        st2.ball3st2.stop();
        st2.t2.stop();
        st2.time2.stop();
        this.setFocusable(true);
        this.setLayout(null);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        Bnext3.setBounds(300, 400, 355, 130);
        Btry3.setBounds(800, 450, 335, 110);
        Bnext3.addActionListener(this);
        Bnext3.setBorderPainted(false);
        Bnext3.setContentAreaFilled(false);
        Bnext3.addMouseListener(this);
        Bnextc3.addActionListener((ActionListener) this);
        Bnextc3.setBorderPainted(false);
        Bnextc3.setContentAreaFilled(false);
        Bnextc3.addMouseListener(this);
        Btry3.addActionListener(this);
        Btry3.setBorderPainted(false);
        Btry3.setContentAreaFilled(false);
        Btry3.addMouseListener(this);
        Btryc3.addActionListener(this);
        Btryc3.setBorderPainted(false);
        Btryc3.setContentAreaFilled(false);
        Btryc3.addMouseListener(this);
        m.x = 1100;
        m.y = 340;
        time3.start();
        t3.start();
        ball1st3.start();
        ball2st3.start();
        ball3st3.start();
    }

    Thread time3 = new Thread(new Runnable() {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
                if (timestart3 == false) {
                    repaint();
                }
            }
        }
    });

    Thread t3 = new Thread(new Runnable() {

        @Override
        public void run() {
            while (true) {
                if (timestart3 == false) {
                    times3 = (times3 - 1);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }
    });

    Thread ball1st3 = new Thread(new Runnable() {

        @Override
        public void run() {
            while (true) {
                try {
                    if (startball3 == false) {
                        Thread.sleep((long) (Math.random() * 7000) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startball3 == false) {
                    ba1.add(new ball1());
                }
            }
        }
    });

    Thread ball2st3 = new Thread(new Runnable() {

        public void run() {
            while (true) {
                try {
                    if (startball3 == false) {
                        Thread.sleep((long) (Math.random() * 7000) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startball3 == false) {
                    ba2.add(new ball2());
                }
            }
        }
    });

    Thread ball3st3 = new Thread(new Runnable() {

        @Override
        public void run() {
            while (true) {
                try {
                    if (startball3 == false) {
                        Thread.sleep((long) (Math.random() * 7000) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startball3 == false) {
                    ba3.add(new ball3());
                }
            }
        }
    });

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imgstate3.getImage(), 0, 0, 1200, 700, this);
        g.drawImage(m.c.getImage(), m.x, m.y - 50, 200, 200, this);
        for (int i = 0; i < fireball.size(); i++) {
            Fireball ba = fireball.get(i);
            g.drawImage(ba.fire.getImage(), ba.x, ba.y + 50, 130, 70, null);
            ba.move();
            if (ba.x < -100) {
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
                    ba1.remove(j);
                    destroy3 -= 1;
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
                    destroy3 -= 1;
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
                countt3 = 0;
            }
        }
        for (int i = 0; i < fireball.size(); i++) {
            for (int j = 0; j < ba3.size(); j++) {
                if (Intersect(fireball.get(i).getbound(), ba3.get(j).getbound())) {
                    countt3++;
                    fireball.remove(i);
                    if (countt3 >= 3) {
                        destroy3 -= 1;
                        ba3.remove(j);
                        scor += 15;
                        countt3 = 0;
                    }
                }
            }
        }
        g.setFont(new Font("2005_iannnnnAMD", Font.BOLD, 80));
        g.setColor(Color.YELLOW);
        g.drawString("SCORE = " + scor, 80, 90);
        g.setColor(Color.cyan);
        g.drawString("STATE 3", 420, 90);
        g.setColor(Color.GREEN);
        g.drawString("TIME " + times3, 375, 170);
        g.setColor(Color.RED);
        g.drawString("HP " + HP, 100, 170);
        g.setColor(Color.MAGENTA);
        g.drawString("REMAIN " + destroy3, 800, 90);
        if (destroy3 <= 0&&times3>=0) {
            super.paintComponent(g);
            ball1st3.stop();
            ball2st3.stop();
            ball3st3.stop();
            t3.stop();
            time3.stop();
            this.add(Bnext3);
            super.setBackground(Color.black);
            g.setColor(Color.WHITE);
            g.setFont(new Font("2005_iannnnnAMD", Font.BOLD, 70));
            g.drawString("SCORE   " + scor, 300, 200);
            g.setFont(new Font("2005_iannnnnAMD", Font.BOLD, 100));
            g.drawString("STATE 3 CLEAR!!", 250, 150);
        } else if (HP <= 0 || (times3 <= 0)) {
            ball1st3.stop();
            ball2st3.stop();
            ball3st3.stop();
            t3.stop();
            time3.stop();
            this.add(Btry3);
            g.drawImage(imgwe.getImage(), 0, 0, 1200, 700, this);
            g.setColor(Color.YELLOW);
            g.setFont(new Font("2005_iannnnnAMD", Font.BOLD, 70));
            g.drawString("SCORE  " + scor, 250, 150);
            g.setFont(new Font("2005_iannnnnAMD", Font.BOLD, 100));
            g.drawImage(gover.getImage(), getHeight()/2+70,500, this);
           // g.drawString("GAME OVER", 250, 150);
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
        if (e.getSource() == Bnext3) {
            remove(Bnext3);
            add(Bnextc3);
            Bnextc3.setBounds(300, 400, 355, 130);
        }
        else if(e.getSource()==Btry3){
            remove(Btry3);
            add(Btryc3);
            Btryc3.setBounds(800, 450, 335, 110);
        }
    } 

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == Bnextc3) {
            remove(Bnextc3);
            add(Bnext3);
            Bnext3.setBounds(300, 400, 355, 130);
        }
       
        else if(e.getSource()==Btryc3){
            remove(Btryc3);
            add(Btry3);
            Btry3.setBounds(800, 450, 335, 110);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        m.x = e.getX() - 100;
        m.y = e.getY() - 50;
        m.count++;
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

}
