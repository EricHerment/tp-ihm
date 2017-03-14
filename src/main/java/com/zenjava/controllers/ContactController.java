package com.zenjava.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;

/**
 * Controller for the contact view
 */
public class ContactController {

    @FXML
    private TextField adresse;

    @FXML
    private TextArea message;

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
        Alert alert;
        if (adresse.getCharacters().length() == 0 || sujet.getCharacters().length()== 0 || message.getText().isEmpty()){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Informations manquantes");
            alert.setContentText("Il faut remplir toutes les cases");
        }
        else {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Message envoyé");
        }
        alert.showAndWait();
    }

    private boolean isAMail(String texte){
        boolean deuxPoints = false;
        String[] texte2 = texte.split("@");
        if (texte2.length!=2) return false;
        if (texte2[texte2.length-1]==".") return false;
        for (int i=0;i<texte2.length;i++){
            if (deuxPoints==true && texte2[i]==".") return false;
            if (texte2[i]==".") deuxPoints = true;
            else deuxPoints = false;
        }
        String[] texte3 = texte2[1].split(".");
        if (texte3.length!=2) return false;
        if (!StringUtils.isAlpha(texte3[0])) return false;
        if (!StringUtils.isAlpha(texte3[1])) return false;
        return true;

    }
}
