import java.awt.Graphics;

public class Landscape {
    private int[] data;
    private int blockLength;
    private int height;
    public Landscape(int width, int height) {
        blockLength = width/2;
        this.height = height;
        generateMore(true);
    }
    public void generateMore(boolean direction) {
        // false = left, true = right
        int oldArrayLen = data == null ? 0 : data.length;
        int[] newArr = new int[oldArrayLen + blockLength];
        if (!direction) {
            for (int i = oldArrayLen - 1; i >= 0; i--) {
                newArr[i + blockLength] = data[i];
            }
            for (int i = blockLength - 1; i >= 0; i--) {
                newArr[i] = (int) (Math.random() * 30) - 15 + newArr[i + 1];
            }
        } else {
            for (int i = 0; i < oldArrayLen; i++) {
                newArr[i] = data[i];
            }
            for (int i = oldArrayLen; i < oldArrayLen + blockLength; i++) {
                newArr[i] = (int) (Math.random() * 30) - 15 + (oldArrayLen == 0 ? (int) (Math.random() * 30) - 15 : newArr[i - 1]);
            }
        }
        data = newArr;
    }
    public int[] getLandscape() {
        return data;
    }
    public void drawLandscape(Graphics g, Vector2D pos) {
        int[] bounds = {(int) pos.getX() - blockLength, (int) pos.getX() + blockLength};
        int alt = (int) pos.getY();
        for (int i = bounds[0] + blockLength; i <= bounds[1]/2; i++) {
            if (data[i] >= alt - height/2) {
                g.drawLine(i*2, data[i], i*2 + 1, data[i]);
                if (i > 0 && data[i - 1] < alt - height/2) {
                    g.drawLine(i*2 - 1, i, alt + height/2, data[i]);
                }
            }
        }
    }
}
