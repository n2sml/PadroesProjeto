package model;

import adapter.MarvinAdapter;
import controller.MainController;
import marvin.image.MarvinImage;
import observer.Observer;
import view.ImagemSemEfeito;

public class ImagemOriginal implements Observer{
    private ImagemSemEfeito janelaSemEfeito;
    
    @Override
    public void processar() {        
        MarvinAdapter image = new MarvinAdapter();        
        image.setMarvinImage((MarvinImage) MainController.myMarvin.clone());
        
        janelaSemEfeito.setJLabelIcon(image.getIcon());
    }
    
    @Override
    public void exibir() {
        System.out.println("exibir()");        
        janelaSemEfeito = new ImagemSemEfeito();
        janelaSemEfeito.setVisible(true);
    }


}
