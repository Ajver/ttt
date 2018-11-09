package MainFiles;

import jslEngine.*;

import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.Color;

public class MainClass extends jslEngine {

    private Field[][] board = new Field[3][3];

    private MainClass() {
        start("Tic Tac Toe", 480, 384);

        int fieldSize = 96;

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                board[i][j] = new Field(j*fieldSize, i*fieldSize, fieldSize, fieldSize);
                jsl.add(board[i][j]);
            }
        }

        jsl.translateX(200);
        jsl.translateY(fieldSize*1.5f);
    }

    protected void update(float et) {

    }

    protected void render(Graphics g) {

    }

    protected void onPress(jslObject o) {

    }

    protected void onKeyPressed() {
        if(key.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(144);
        }
    }



    public static void main(String[] args) {
        new MainClass();
    }
}
