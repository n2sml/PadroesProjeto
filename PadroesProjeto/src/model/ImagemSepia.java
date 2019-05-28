package model;

import adapter.MarvinAdapter;
import controller.MainController;
import marvin.image.MarvinImage;
import marvin.util.MarvinPluginLoader;
import observer.Observer;
import view.JanelaSepia;

public class ImagemSepia implements Observer{
    private JanelaSepia janelaSepia;
        
    @Override
    public void processar() {         
        MarvinAdapter image = new MarvinAdapter();
        image.setMarvinImage((MarvinImage) MainController.myMarvin.clone());
        MainController.imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.color.sepia.jar");        
        MainController.imagePlugin.process(image.getMarvinImage(), image.getMarvinImage());
        
        image.update();
        
        janelaSepia.setJLabelIcon(image.getIcon());
    }

    @Override
    public void exibir() {
        System.out.println("exibir()");        
        janelaSepia = new JanelaSepia();
        janelaSepia.setVisible(true);
    }
}
