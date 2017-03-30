package application;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SheetGenerator {
    private static final int WIDTH = 255 * 10;
    private static final int HEIGHT = 255 * 10;

    public static void main(String[] args) {
        BufferedImage bufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

        Graphics2D graphics = bufferedImage.createGraphics();

        int yRectangleEdge = HEIGHT / 255;
        int xRectangleEdge = WIDTH / 255;

        for (int y = 0; y < HEIGHT; y += yRectangleEdge) {
            for (int x = 0; x < WIDTH; x += xRectangleEdge) {
                graphics.setPaint(new Color(x / xRectangleEdge, y / yRectangleEdge, 255));
                graphics.drawRect(x, y, xRectangleEdge, yRectangleEdge);
            }
        }

        File output = new File("saved.png");
        try {
            ImageIO.write(bufferedImage, "png", output);
        } catch (IOException e) {
            System.out.println("ERROR: cannot write image file to disk");
            e.printStackTrace();
        }
    }
}
