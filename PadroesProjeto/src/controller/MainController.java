package controller;

import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.filechooser.FileSystemView;
import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;
import marvin.plugin.MarvinImagePlugin;
import observer.Observer;
import view.*;
import model.*;

public class MainController {

    public static String enderecoImagemOriginal;
    private static ArrayList<Observer> minhasJanelas;
    public static MarvinImage marvinImage;
    public static MarvinImagePlugin imagePlugin;

    public static void openJanelaSelecionarImagem() {
        JanelaSelecionarImagemJF selecionarImagem = new JanelaSelecionarImagemJF();
        selecionarImagem.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        selecionarImagem.setVisible(true);
    }

    public static void carregarImagem() {
        System.out.println("CarregarImagem");
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setMultiSelectionEnabled(false);
        //fileChooser.showSaveDialog(null);        
        
        
        
        int returnVal = fileChooser.showOpenDialog(null);

        if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            enderecoImagemOriginal = file.getAbsolutePath();
            
            marvinImage = MarvinImageIO.loadImage(MainController.enderecoImagemOriginal);
            
            System.out.println("Imagem carregada.");

            ImagemSemEfeito imagemSemEfeitoWindow = new ImagemSemEfeito();
            imagemSemEfeitoWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            ImageIcon adapter = new ImageIcon(file.getAbsolutePath());
            imagemSemEfeitoWindow.setImagemSemEfeito(adapter);

            imagemSemEfeitoWindow.setVisible(true);

            adicionarAoArray();
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
        
        runJanelas();
    }

    public static void runJanelas() {
        System.out.println("runJanelas()");
        for (Observer temp : minhasJanelas) {
            temp.processar();
            temp.exibir();
        }
    }
}
