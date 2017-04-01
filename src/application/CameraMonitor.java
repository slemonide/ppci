package application;

import com.github.sarxos.webcam.Webcam;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CameraMonitor {
    public static void main(String[] args) {
        Webcam webcam = Webcam.getDefault();
        webcam.setViewSize(new Dimension(640, 480));
        webcam.open();
        try {
            ImageIO.write(webcam.getImage(), "PNG", new File("hello-world.png"));
        } catch (IOException e) {
            System.out.println("ERROR: Cannot save image");
            e.printStackTrace();
        }
    }
}
