package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.web.HTMLEditor;

public class Controller {

    public Button changeLayoutButton;
    @FXML
    HTMLEditor htmlEditor1;

    @FXML
    HTMLEditor htmlEditor2;


    public void click(ActionEvent actionEvent) {
        String text = Utility.getTextFromHTML(htmlEditor1.getHtmlText());
        text = Utility.changeLanguage(text);
        htmlEditor2.setHtmlText(text);
    }
}
