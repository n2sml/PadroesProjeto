package model;

import adapter.MarvinAdapter;
import controller.MainController;
import marvin.image.MarvinImage;
import marvin.util.MarvinPluginLoader;
import observer.Observer;
import view.JanelaPretoBranco;

public class ImagemPretoBranco implements Observer{
    private JanelaPretoBranco janelaPretoBranco;
    
    @Override
    public void processar() {          
        MarvinAdapter image = new MarvinAdapter();
        image.setMarvinImage((MarvinImage) MainController.myMarvin.clone());
        MainController.imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.color.grayScale.jar");
        MainController.imagePlugin.process(image.getMarvinImage(), image.getMarvinImage());
        
        image.update();
        
        janelaPretoBranco.setJLabelIcon(image.getIcon());
    }

    @Override
    public void exibir() {
        System.out.println("exibir()");        
        janelaPretoBranco = new JanelaPretoBranco();
        janelaPretoBranco.setVisible(true);
    }


}
