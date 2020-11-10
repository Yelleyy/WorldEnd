package Gameyel;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;
import javax.swing.*;

public class stateboss extends JPanel implements MouseListener,MouseMotionListener,ActionListener{

    private final ImageIcon imgstate3 = new ImageIcon(this.getClass().getResource("space4.gif"));
    public ImageIcon imgwe=new ImageIcon(this.getClass().getResource("worldend.gif"));
    public ImageIcon gover=new ImageIcon(this.getClass().getResource("gameover.gif"));
    public ImageIcon trya=new ImageIcon(this.getClass().getResource("exit1.png"));
    public ImageIcon tryaclick=new ImageIcon(this.getClass().getResource("exitclick.png"));
    public JButton Btry4 = new JButton(trya);
    public JButton Btryc4 = new JButton(tryaclick);
    public ArrayList<Fireball> fireball = new ArrayList<Fireball>();
    public ball4 ba4=new ball4();
    spacecraft m = new spacecraft(); 
    state3 st3=new state3();
    boolean timestart4 = true;
    boolean startball4 = false;
    public int times4 ;
    public int countt4=0;
    public int HP = 5;
    public int scor=0;
    public boolean boss=false;
    public int ball4x= -600;
    public int hpme=400;
    public int a=0,b=0,c=0,d=0;
    public int bar=1;
    public boolean blankcursor=true;
    public stateboss() { 
        ba4.x= ball4x;
        ba4.y=170;
        st3.ball1st3.stop();
        st3.ball2st3.stop();
        st3.ball3st3.stop();
        st3.t3.stop();
        st3.time3.stop();
        Btry4.setBounds(800, 450, 335, 110);
        Btry4.addActionListener(this);
        Btry4.setBorderPainted(false);
        Btry4.setContentAreaFilled(false);
        Btry4.addMouseListener(this);
        Btryc4.addActionListener(this);
        Btryc4.setBorderPainted(false);
        Btryc4.setContentAreaFilled(false);
        Btryc4.addMouseListener(this);
        this.setFocusable(true);
        this.setLayout(null);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        m.x = 1100;
        m.y=340;
        time4.start();   
        t4.start();
        ball4st3.start();
        
    }
    Thread time4 = new Thread(new Runnable(){
            @Override
            public void run(){
		while(true){
                    try{
			Thread.sleep(10);
                    }catch(InterruptedException e){ }
                    
                    if(timestart4 == false){
			repaint();
                    }
		}
            }
	});
    Thread t4 = new Thread(new Runnable(){
        @Override
        public void run() {
            while(true){
                if(timestart4 == false){
                    times4 = (times4-1) ;                      
                }
                try{
                    Thread.sleep(700);
                }catch(InterruptedException e){}
            }
        }
    });  
    Thread ball4st3=new Thread(new Runnable() {
        @Override
        public void run() {
            while(true){
                if(timestart4 == false){
                    ba4.x+=3 ;                      
                }
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){}
            }
        }
    });  
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);  
        g.drawImage(imgstate3.getImage(),0,0,1200,700,this);          
        g.drawImage(m.c.getImage(), m.x, m.y-50,200,200, this); 
        if(m.x<0){
            m.x=this.getWidth()-10;
        }
        if(m.x>this.getWidth()){
            m.x=20;
        }
        for(int i=0;i<fireball.size();i++){
            Fireball ba = fireball.get(i);
            g.drawImage(ba.fire.getImage(), ba.x, ba.y+50,130,70, null);
            ba.move();
            if(ba.x<-50){
                fireball.remove(i);
            }
        }
        //=================================boss=============
        for(int i=0 ; i<fireball.size();i++){                                                  
            if(Intersect(fireball.get(i).getbound(),ba4.getbound())){
                if(bar==1){
                    hpme-=5;
                    a=400-hpme;
                    if(a==100){
                        bar++;
                    }
                }
                else if(bar==2){
                    hpme-=5;
                    b=300-hpme;
                    if(b==100){
                        bar++;
                    }
                }
                else if(bar==3){
                    hpme-=5;
                    c=200-hpme;
                    if(c==100){
                        bar++;
                    }
                }
                else if(bar==4){
                    hpme-=5;
                    d=100-hpme;
                }              
                fireball.remove(i); 
                if(hpme<=0){                                                               
                    scor +=200;    
                }  
            }
        } 
        g.setColor(Color.red);      
        g.setFont(new Font("2005_iannnnnAMD",Font.BOLD,80));
        g.setColor(Color.YELLOW);
        g.drawString("SCORE = "+scor,100, 90);	     
        g.setColor(Color.cyan);
        g.drawString("BOSS STATE ",440,90);
        g.setColor(Color.GREEN);
        g.drawString("TIME "+times4,450,170);
        g.setColor(Color.RED);
        g.drawString("HP "+HP,170,170);                
        g.setFont(new Font("2005_iannnnnAMD",Font.BOLD,40));
        g.setColor(Color.white);
        g.drawImage(ba4.getImage(),ba4.getX(),ba4.getY()-140,700,700, this);
        g.drawString("BOSS HP: " +hpme,300, 595);  
        g.setColor(Color.white);
        g.fillRect(300,600, 400, 20);
        g.setColor(Color.yellow);
        g.fillRect(300,600, 400 - (d * 4), 20);
        g.setColor(Color.orange);
        g.fillRect(300,600, 400 - (c * 4), 20);
        g.setColor(Color.red);
        g.fillRect(300,600, 400 - (b * 4), 20);
        g.setColor(Color.MAGENTA);
        g.fillRect(300,600, 400 - (a * 4), 20);
        if(hpme<=0&&times4>=0){
            t4.stop();
            time4.stop();
            ball4st3.stop();
            ba4.x=2000;
            super.paintComponent(g);
            setBackground(Color.black);
            g.setFont(new Font("2005_iannnnnAMD",Font.BOLD,150));
            g.setColor(Color.white);
            g.drawString("GAME COMPLETE!",200,200);           
            g.drawString("YOUR SCORE  " + scor, 200, 400);
        }
        else if(HP<=0||(times4<=0)){
            t4.stop();
            time4.stop();
            ball4st3.stop();
            ba4.x=2000;
            super.paintComponent(g);
            this.add(Btry4);
            g.drawImage(imgwe.getImage(),0,0, 1200, 700, this);
            g.setColor(Color.YELLOW);
            g.setFont(new Font("2005_iannnnnAMD",Font.BOLD,70));		
            g.drawString("SCORE  "+scor,250, 150);	    
            g.setFont(new Font("2005_iannnnnAMD",Font.BOLD,100));
            g.drawImage(gover.getImage(), getHeight()/2+70,500, this);
        }                    
    }   
    public boolean Intersect(Rectangle2D a, Rectangle2D b){
        return (a.intersects(b));
    }
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
        fireball.add(new Fireball(m.x-100,m.y));

    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource()==Btry4){
            remove(Btry4);
            add(Btryc4);
            Btryc4.setBounds(800, 450, 335, 110);
        }
    }
    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==Btryc4){
            remove(Btryc4);
            add(Btry4);
            Btry4.setBounds(800, 450, 335, 110);
        }
    }
    @Override
    public void mouseMoved(MouseEvent e) {               
        m.x=e.getX()-100;
        m.y=e.getY()-50;
        repaint();
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
