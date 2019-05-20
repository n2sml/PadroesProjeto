package model;

import controller.MainController;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import marvin.image.MarvinImage;
import marvin.util.MarvinPluginLoader;
import observer.Observer;
import view.JanelaSepia;

public class ImagemSepia implements Observer{
    private JanelaSepia janelaSepia;
    
    @Override
    public void processar() {
        janelaSepia = new JanelaSepia();
        
        MarvinImage image = MainController.marvinImage.clone();
        MainController.imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.color.sepia.jar");
        MainController.imagePlugin.process(image, image);
        
        image.update();
        
        BufferedImage buffImg = image.getBufferedImage();
        
        ImageIcon temp = new ImageIcon(buffImg);
        
        janelaSepia.setJLabelIcon(temp);
    }

    @Override
    public void exibir() {
        System.out.println("exibir()");
        janelaSepia.setVisible(true);
    }


}
