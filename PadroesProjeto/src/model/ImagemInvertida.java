package model;

import controller.MainController;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import marvin.image.MarvinImage;
import marvin.util.MarvinPluginLoader;
import observer.Observer;
import view.JanelaInvertida;

public class ImagemInvertida implements Observer{
    private JanelaInvertida janelaInvertida;
    
    @Override
    public void processar() {
        janelaInvertida = new JanelaInvertida();
        
        MarvinImage image = MainController.marvinImage.clone();
        MainController.imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.color.invert.jar");
        MainController.imagePlugin.process(image, image);
        
        image.update();
        
        BufferedImage buffImg = image.getBufferedImage();
        
        ImageIcon temp = new ImageIcon(buffImg);
        
        janelaInvertida.setJLabelIcon(temp);
    }

    @Override
    public void exibir() {
        System.out.println("exibir()");
        janelaInvertida.setVisible(true);
    }


}
