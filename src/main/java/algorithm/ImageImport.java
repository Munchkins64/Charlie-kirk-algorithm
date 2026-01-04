package algorithm;

import javax.swing.*;
import java.awt.*;

public class ImageImport {

    public static ImageIcon pngimport(String path ){
        ImageIcon plus0 = new ImageIcon(
                Window.class.getResource(path)
        );
        Image plus1 = plus0.getImage().getScaledInstance(16,16,Image.SCALE_SMOOTH);
        ImageIcon plus = new ImageIcon(plus1);
        return plus;
    }

    public static ImageIcon pngimport_s(String path, int width, int height ){
        ImageIcon plus0 = new ImageIcon(
                Window.class.getResource(path)
        );
        Image plus1 = plus0.getImage().getScaledInstance(width,height,Image.SCALE_REPLICATE);
        ImageIcon plus = new ImageIcon(plus1);
        return plus;
    }

    public static ImageIcon pngimport_d(String path ){
        ImageIcon plus0 = new ImageIcon(
                Window.class.getResource(path)
        );
        Image plus1 = plus0.getImage().getScaledInstance(16,16,Image.SCALE_FAST);
        ImageIcon plus = new ImageIcon(plus1);
        return plus;
    }

    public static ImageIcon pngimport_no(String path ){
        ImageIcon plus0 = new ImageIcon(
                Window.class.getResource(path)
        );
        return plus0;
    }
}
