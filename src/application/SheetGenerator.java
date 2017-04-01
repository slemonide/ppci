package application;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SheetGenerator {
    public static void main(String[] args) {
        BufferedImage bufferedImage = new BufferedImage(255, 255, BufferedImage.TYPE_INT_RGB);

        Graphics2D graphics = bufferedImage.createGraphics();

        for (int y = 0; y < 255; y ++) {
            for (int x = 0; x < 255; x ++) {
                graphics.setPaint(new Color(x, y, 0));
                graphics.drawRect(x, y, x, y);
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
