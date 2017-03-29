package application;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SheetGenerator {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;

    public static void main(String[] args) {
        BufferedImage bufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

        Graphics2D graphics = bufferedImage.createGraphics();

        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                graphics.setPaint(new Color(55 + (y * 200) / HEIGHT, 55 + (x * 200) / WIDTH, 255));
                graphics.drawLine(x, y, x, y);
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
