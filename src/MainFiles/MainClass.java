package MainFiles;

import jslEngine.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainClass extends jslEngine {

    private int fieldSize = 96;
    public Type round = Type.x;
    public Status status = Status.game;
    private Field[][] board = new Field[3][3];

    private int roundNr = 0;

    public BufferedImage imgX, imgO;

    public enum Type {
        empty,
        x,
        o
    }

    public enum Status {
        game,
        draw,
        winX,
        winO
    }

    private MainClass() {
        start("Tic Tac Toe", fieldSize*6, fieldSize*4);

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                board[i][j] = new Field(j*fieldSize, i*fieldSize, fieldSize, fieldSize, this);
                jsl.add(board[i][j]);
            }
        }

        jslObject btn = new jslObject(WW()-250, 240, 150, 30) {
            private String title = "Again!";
            public void onPress() {
                resetBoard();
            }
            public void render(Graphics g) {
                if(hover) {
                    g.setColor(new Color(232, 153, 120));
                }else {
                    g.setColor(new Color(214, 197, 190));
                }
                g.fillRect((int)getX(), (int)getY(), (int)getW(), (int)getH());

                g.setFont(new Font("arial", 0, 20));
                g.setColor(new Color(72, 72, 72));
                g.drawString(title, (int)getX()+45, (int)(getY()+getH()-8));
            }
        };

        jsl.add(btn);

        resetBoard();

        jsl.translateX(fieldSize*0.5f);
        jsl.translateY(fieldSize*0.5f);

        try {
            imgX = ImageIO.read(new File("res/x.png"));
            imgO = ImageIO.read(new File("res/o.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void resetBoard() {
        roundNr = 0;
        status = Status.game;
        round = Type.x;

        for(int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j].reset();
            }
        }
    }

    protected void update(float et) {

    }

    protected void render(Graphics g) {
        g.setColor(new Color(226, 223, 204));
        g.setFont(new Font("arial", 0, 30));

        if(status == Status.game) {
            g.drawString("Round: ", WW() - 180, 100);
            g.drawImage((round == Type.x ? imgX : imgO), WW() - 180, 110, null);
        }else {
            if (status == Status.draw) {
                g.drawString("Draw!", WW() - 180, 100);
            } else {
                g.drawImage((status == Status.winX ? imgX : imgO), WW() - 180, 110, null);
                g.drawString("Wins!", WW() - 170, 100);
            }
        }
    }

    protected void onKeyPressed() {
        if(key.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(144);
        }
    }

    public void nextRound() {
        roundNr++;

        if(round == Type.o) {
            round = Type.x;
        }else {
            round = Type.o;
        }

        // Checking
        if(roundNr > 8) {
            status = Status.draw;
        }

        if(     board[0][0].getType() == board[1][0].getType() &&
                board[0][0].getType() == board[2][0].getType() &&
                board[0][0].getType() != Type.empty ||

                board[0][1].getType() == board[1][1].getType() &&
                        board[0][1].getType() == board[2][1].getType() &&
                        board[0][1].getType() != Type.empty ||

                board[0][2].getType() == board[1][2].getType() &&
                        board[0][2].getType() == board[2][2].getType() &&
                        board[0][2].getType() != Type.empty ||

                board[0][0].getType() == board[0][1].getType() &&
                        board[0][0].getType() == board[0][2].getType() &&
                        board[0][0].getType() != Type.empty ||

                board[1][0].getType() == board[1][1].getType() &&
                        board[1][0].getType() == board[1][2].getType() &&
                        board[1][0].getType() != Type.empty ||

                board[2][0].getType() == board[2][1].getType() &&
                        board[2][0].getType() == board[2][2].getType() &&
                        board[2][0].getType() != Type.empty ||

                board[0][0].getType() == board[1][1].getType() &&
                        board[0][0].getType() == board[2][2].getType() &&
                        board[0][0].getType() != Type.empty ||

                board[2][0].getType() == board[1][1].getType() &&
                        board[2][0].getType() == board[0][2].getType() &&
                        board[2][0].getType() != Type.empty
        ) {
            status = round == Type.x ? Status.winO : Status.winX;
        }
    }


    public static void main(String[] args) {
        new MainClass();
    }
}
