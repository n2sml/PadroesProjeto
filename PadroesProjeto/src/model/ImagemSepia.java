package model;

import adapter.Adapter;
import controller.MainController;
import marvin.image.MarvinImage;
import marvin.util.MarvinPluginLoader;
import observer.Observer;
import view.JanelaSepia;

public class ImagemSepia implements Observer{
    private JanelaSepia janelaSepia;
    
    @Override
    public void processar() {        
        MarvinImage image = MainController.marvinImage.clone();
        MainController.imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.color.sepia.jar");
        MainController.imagePlugin.process(image, image);
        
        image.update();
                
        janelaSepia.setJLabelIcon(Adapter.marvinImageToIcon(image));
    }

    @Override
    public void exibir() {
        System.out.println("exibir()");        
        janelaSepia = new JanelaSepia();
        janelaSepia.setVisible(true);
    }
}
