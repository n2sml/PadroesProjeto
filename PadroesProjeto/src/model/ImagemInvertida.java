package model;

import adapter.Adapter;
import controller.MainController;
import marvin.image.MarvinImage;
import marvin.util.MarvinPluginLoader;
import observer.Observer;
import view.JanelaInvertida;

public class ImagemInvertida implements Observer{
    private JanelaInvertida janelaInvertida;
    
    @Override
    public void processar() {        
        MarvinImage image = MainController.marvinImage.clone();
        MainController.imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.color.invert.jar");
        MainController.imagePlugin.process(image, image);
        
        image.update();
        
        janelaInvertida.setJLabelIcon(Adapter.marvinImageToIcon(image));
    }

    @Override
    public void exibir() {
        System.out.println("exibir()");        
        janelaInvertida = new JanelaInvertida();
        janelaInvertida.setVisible(true);
    }


}
