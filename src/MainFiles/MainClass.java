package MainFiles;

import jslEngine.*;

import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.Color;

public class MainClass extends jslEngine {

    private MainClass() {
        start("Tic Tac Toe", 600, 400);


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
