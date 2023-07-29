package com.mycompany.brick_breake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePlay extends JPanel implements KeyListener, ActionListener {

    private boolean playn = false;
    private int score=0;
    private int TotalBricks=21;
    private Timer timer;
    private int delay=0;
    private int playerX=310;
    private int ballPosX=120;
    private  int ballPosY=350;
    private int ballXDir=-1;
    private int ballYDir=-2;
    private MapGenerator map;

    public GamePlay(){
        map=new MapGenerator(3,7);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer =new Timer(delay,this);
        timer.start();
    }
    public void paint(Graphics g){
        g.setColor(Color.black);
        g.fillRect(1,1,692,592);
        map.draw((Graphics2D)g);
        g.setColor(Color.yellow);
        g.fillRect(0,0,3,592);
        g.fillRect(0,0,692,3);
        g.fillRect(691,0,3,592);
        g.setColor(Color.white);
        g.setFont(new Font("serif",Font.BOLD,25));
        g.drawString(""+score,590,30);
        g.setColor(Color.yellow);
        g.fillRect(playerX,550,100,8);
        g.setColor(Color.green);
        g.fillOval(ballPosX,ballPosY,20,20);
        if(ballPosY>570){
            playn=false;
            ballXDir=0;
            ballYDir=0;
            g.setColor(Color.red);
            g.setFont(new Font("serif",Font.BOLD,30));
            g.drawString("Game over Score : "+score,190,300);

            g.setFont(new Font("serif",Font.BOLD,30));
            g.drawString("Press Enter to Restart "+score,190,340);
        }
        if(TotalBricks==0){
            playn=false;
            ballYDir=-2;
            ballXDir=-1;
            g.setColor(Color.red);
            g.setFont(new Font("serif",Font.BOLD,30));
            g.drawString("congratulations: "+score,190,300);

            g.setFont(new Font("serif",Font.BOLD,30));
            g.drawString("Press Enter to play again: "+score,190,340);

        }
        g.dispose();


    }










    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if(playn){
            if(new Rectangle(ballPosX,ballPosY,20,20).intersects(new Rectangle(playerX,550,100,8))){
                ballYDir=-ballYDir;
            }
            A:
            for (int i=0; i<map.map.length;i++){
                for(int j=0 ;j<map.map[0].length;j++){
                    if(map.map[i][j]>0){
                        int brickx=j*map.brickwidth+80;
                        int bricky=i*map.brickheight+50;
                        int brickWidth=map.brickwidth;
                        int brickHeight=map.brickheight;
                        Rectangle rect=new Rectangle(brickx,bricky,brickWidth,brickHeight);
                        Rectangle ballrect=new Rectangle(ballPosX,ballPosY,20,20);
                        Rectangle brickrect=rect;
                        if(ballrect.intersects(brickrect)){
                            map.setBrickValue(0,i,j);
                            TotalBricks--;
                            score+=5;
                            if(ballPosX+19<= brickrect.x || ballPosX+1 >= brickrect.x +brickWidth){
                                ballXDir=-ballXDir;
                            }else{
                                ballYDir=-ballYDir;
                            }
                            break A;
                        }
                    }
                }
            }
            ballPosX+=ballXDir;
            ballPosY+=ballYDir;
            if(ballPosX<0)
            {
                ballXDir=-ballXDir;
            }
            if(ballPosY<0){
                ballYDir=-ballYDir;
            }
            if(ballPosX>670)
            {
                ballXDir=-ballXDir;
            }
        }
        repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            if(playerX>=600){
                playerX=600;

            }else{
                moveRight();
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            if(playerX<10){
                playerX=10;

            }else{
                moveLeft();
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            if(!playn){
                ballPosX=120;
                ballPosY=350;
                ballXDir=-1;
                ballYDir=-2;
                score=0;
                playerX=310;
                TotalBricks=21;
                map=new MapGenerator(3,7);
                repaint();
            }
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    public void moveRight(){
        playn=true;
        playerX+=20;
    }
    public void moveLeft(){
        playn=true;
        playerX-=20;
    }

}
