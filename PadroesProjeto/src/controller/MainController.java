package controller;

import adapter.MarvinAdapter;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;
import marvin.io.MarvinImageIO;
import marvin.plugin.MarvinImagePlugin;
import observer.Observer;
import view.*;
import model.*;

public class MainController {

    public static String enderecoImagemOriginal;
    private static ArrayList<Observer> minhasJanelas;
    public static MarvinAdapter myMarvin;
    public static MarvinImagePlugin imagePlugin;

    public static void openJanelaSelecionarImagem() {
        JanelaDescricao selecionarImagem = new JanelaDescricao();
        selecionarImagem.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        selecionarImagem.setVisible(true);
    }

    public static void instanciarJanelas(){
        adicionarAoArray();
    }
    
    public static void carregarImagem() {
        System.out.println("CarregarImagem");
        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.home"));
        fileChooser.setMultiSelectionEnabled(false);
        
        int returnVal = fileChooser.showOpenDialog(null);

        if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            enderecoImagemOriginal = file.getAbsolutePath();
            myMarvin = new MarvinAdapter();
            myMarvin.setMarvinImage(MarvinImageIO.loadImage(MainController.enderecoImagemOriginal));
            
            System.out.println("Imagem carregada.");

            ImagemSemEfeito imagemSemEfeitoWindow = new ImagemSemEfeito();
            imagemSemEfeitoWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            runJanelas();
        }
    }

    public static void adicionarAoArray() {
        System.out.println("adicionarAoArray()");
        minhasJanelas = new ArrayList();

        Observer pretoBranco = new ImagemPretoBranco();
        minhasJanelas.add(pretoBranco);        
        
        Observer sepia = new ImagemSepia();
        minhasJanelas.add(sepia);
        
        Observer invertida = new ImagemInvertida();
        minhasJanelas.add(invertida);
        
        Observer original = new ImagemOriginal();
        minhasJanelas.add(original);
        
        exibirJanelas();
        //runJanelas();
    }
    
    public static void exibirJanelas(){
        for (Observer temp : minhasJanelas) {
            temp.exibir();
        }
    }

    public static void runJanelas() {
        System.out.println("runJanelas()");
        for (Observer temp : minhasJanelas) {
            temp.processar();
            //temp.exibir();
        }
    }
}
