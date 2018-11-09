package MainFiles;

import jslEngine.jslObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Field extends jslObject {

    private MainClass main;

    private MainClass.Type type = MainClass.Type.empty;
    private BufferedImage img = null;

    public Field(float x, float y, float w, float h, MainClass main) {
        super(x, y, w, h);

        this.main = main;
    }

    public void update(float et) {

    }

    public void render(Graphics g) {
        if(hover || main.status != MainClass.Status.game) {
            g.setColor(new Color(214, 210, 190));
        }else {
            g.setColor(new Color(226, 223, 204));
        }
        g.fillRect((int)getX(), (int)getY(), (int)w, (int)h);

        g.setColor(new Color(94, 93, 89));
        g.drawRect((int)getX(), (int)getY(), (int)w, (int)h);

        if(img != null) {
            g.drawImage(img, (int)x, (int)y, null);
        }
    }

    public void onPress() {
        if(main.status == MainClass.Status.game) {
            if (type == MainClass.Type.empty) {
                type = main.round;
                img = type == MainClass.Type.x ? main.imgX : main.imgO;
                main.nextRound();
            }
        }
    }

    public void reset() {
        type = MainClass.Type.empty;
        img = null;
    }

    public MainClass.Type getType() { return type; }
}
