package adapter;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import marvin.image.MarvinImage;

public class MarvinAdapter{
    private MarvinImage marvinImage;

    public MarvinImage getMarvinImage() {
        return marvinImage;
    }

    public void setMarvinImage(MarvinImage marvinImage) {
        this.marvinImage = marvinImage;
    }
    
    public MarvinAdapter(){
        this.marvinImage = new MarvinImage();
    }
    
    public ImageIcon getIcon() {
        //Adapter 1:
        BufferedImage buffImg = marvinImage.getBufferedImage();
        
        //Adapter 2:
        ImageIcon temp = new ImageIcon(buffImg);
        
        return temp;
    }
    
    public MarvinImage clone(){
        return this.marvinImage.clone();
    }
    
    public void update(){
        this.marvinImage.update();
    }
    
}
