package controller;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.filechooser.FileSystemView;
import view.JanelaSelecionarImagemJF;

public class MainController {

    public static void carregarImagem() {
        System.out.println("CarregarImagem");
        JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
        j.setMultiSelectionEnabled(false); 
        j.showSaveDialog(null);        
        
    }

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
}
