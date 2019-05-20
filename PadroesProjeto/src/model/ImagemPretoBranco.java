package model;

import controller.MainController;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import marvin.image.MarvinImage;
import marvin.util.MarvinPluginLoader;
import observer.Observer;
import view.JanelaPretoBranco;

public class ImagemPretoBranco implements Observer{
    private JanelaPretoBranco janelaPretoBranco;
    
    @Override
    public void processar() {
        janelaPretoBranco = new JanelaPretoBranco();
        
        MarvinImage image = MainController.marvinImage.clone();
        MainController.imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.color.grayScale.jar");
        MainController.imagePlugin.process(image, image);
        
        image.update();
        
        //Adapter 1:
        BufferedImage buffImg = image.getBufferedImage();
        
        //Adapter 2:
        ImageIcon temp = new ImageIcon(buffImg);
        
        janelaPretoBranco.setJLabelIcon(temp);
    }

    @Override
    public void exibir() {
        System.out.println("exibir()");
        janelaPretoBranco.setVisible(true);
    }


}
