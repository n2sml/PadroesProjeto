package adapter;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import marvin.image.MarvinImage;

public class Adapter {
    public static ImageIcon marvinImageToIcon(MarvinImage image){
        //Adapter 1:
        BufferedImage buffImg = image.getBufferedImage();
        
        //Adapter 2:
        ImageIcon temp = new ImageIcon(buffImg);
        
        return temp;
    }
}
