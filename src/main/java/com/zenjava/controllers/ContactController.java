package com.zenjava.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * Controller for the contact view
 */
public class ContactController {

    @FXML
    private TextField adresse;

    @FXML
    private TextField message;

    @FXML
    private TextField sujet;

    @FXML
    private Button envoyer;

    @FXML
    private Button annuler;

    @FXML
    private void annulerButton() throws IOException {

    }

    @FXML
    private void envoyerButton(){
        Dialog dialog = new Dialog();
        if (adresse.getCharacters().length()==0 || sujet.getCharacters().length()==0 || message.getCharacters().length()==0){
            dialog.setContentText("il faut remplir toutes les cases");
        }
        else{
            dialog.setContentText("message envoyé");
        }
        dialog.show();
    }
}
