package model;

import adapter.Adapter;
import controller.MainController;
import marvin.image.MarvinImage;
import marvin.util.MarvinPluginLoader;
import observer.Observer;
import view.ImagemSemEfeito;

public class ImagemOriginal implements Observer{
    private ImagemSemEfeito janelaSemEfeito;
    
    @Override
    public void processar() {        
        MarvinImage image = MainController.marvinImage.clone();
        image.update();
        
        janelaSemEfeito.setJLabelIcon(Adapter.marvinImageToIcon(image));
    }

    @Override
    public void exibir() {
        System.out.println("exibir()");        
        janelaSemEfeito = new ImagemSemEfeito();
        janelaSemEfeito.setVisible(true);
    }


}
