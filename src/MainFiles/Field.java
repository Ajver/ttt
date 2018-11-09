package MainFiles;

import jslEngine.jslObject;

import java.awt.*;

public class Field extends jslObject {

    private Color[] colors = new Color[2];
    private int colorNr = 0;

    public Field(float x, float y, float w, float h) {
        super(x, y, w, h);

        colors[0] = new Color(226, 223, 204);
        colors[1] = new Color(214, 210, 190);
    }

    public void update(float et) {

    }

    public void render(Graphics g) {
        g.setColor(colors[colorNr]);
        g.fillRect((int)x, (int)y, (int)w, (int)h);

        g.setColor(new Color(94, 93, 89));
        g.drawRect((int)x, (int)y, (int)w, (int)h);
    }

    public void onEnter() {
        colorNr = 1;
    }

    public void onLeave() {
        colorNr = 0;
    }
}
