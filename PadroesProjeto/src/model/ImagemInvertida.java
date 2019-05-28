package model;

import adapter.MarvinAdapter;
import controller.MainController;
import marvin.image.MarvinImage;
import marvin.util.MarvinPluginLoader;
import observer.Observer;
import view.JanelaInvertida;

public class ImagemInvertida implements Observer{
    private JanelaInvertida janelaInvertida;
    
    @Override
    public void processar() {     
        MarvinAdapter image = new MarvinAdapter();
        image.setMarvinImage((MarvinImage) MainController.myMarvin.clone());
        MainController.imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.color.invert.jar");
        MainController.imagePlugin.process(image.getMarvinImage(), image.getMarvinImage());
        
        image.update();
        
        janelaInvertida.setJLabelIcon(image.getIcon());
    }

    @Override
    public void exibir() {
        System.out.println("exibir()");        
        janelaInvertida = new JanelaInvertida();
        janelaInvertida.setVisible(true);
    }


}
