/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JFrame;
import javax.swing.UIManager;
import view.JanelaSelecionarImagemJF;

/**
 *
 * @author nicolas
 */
public class MainController {

    public static void carregarImagem() {
        System.out.println("CarregarImagem");
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
