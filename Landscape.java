import java.awt.Graphics;

public class Landscape {
    private int[] data;
    private int blockLength;
    private int height;
    public Landscape(int width, int height) {
        blockLength = width/2;
        data = new int[width];
        this.height = height;
        data[0] = 0;
        for (int i = 1; i < width; i++) data[i] = (int) (Math.random() * 30) - 15 + i;
    }
    public int[] generate(int xDiff) {
        int[] newArray = new int[blockLength];
        for (int i = 0; i < blockLength; i++) {
            newArray[i] = xDiff >= 0 ? data[(i + xDiff) % data.length] : data[Math.abs(xDiff - i) % data.length];
        }
        return newArray;
    }
    public int[] getLandscape() {
        return data;
    }
    public void drawLandscape(Graphics g, Vector2D pos) {
        int[] landscape = generate((int) pos.getX());
        int alt = (int) pos.getY();
        for (int i = 0; i < landscape.length; i++) {
            if (landscape[i] >= alt - height/2) {
                g.drawLine(i*2, landscape[i], i*2 + 1, landscape[i]);
                if (i > 0 && data[i - 1] < alt - height/2) {
                    g.drawLine(i*2 - 1, i, alt + height/2, data[i]);
                }
            }
        }
    }
}
