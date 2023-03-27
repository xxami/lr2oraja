package bms.player.beatoraja.launcher;

import bms.player.beatoraja.PlayerConfig;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MultiPlayerConfigurationView implements Initializable {

    @FXML
    private TextField multiplayerUser;
    @FXML
    private TextField multiplayerServer;
    @FXML
    private TextField multiplayerLobby;
    @FXML
    private TextField multiplayerPassword;
    
    private PlayerConfig player;

    public void initialize(URL arg0, ResourceBundle arg1) {
    }

    public void update(PlayerConfig player) {
        this.player = player;
        if(this.player == null) {
            return;
        }
        multiplayerUser.setText(this.player.getMultiplayerUsername());
        multiplayerServer.setText(this.player.getMultiplayerServer());
        multiplayerLobby.setText(this.player.getMultiplayerLobby());
        multiplayerPassword.setText(this.player.getMultiplayerLobbyPassword());
    }

    public void commit() {
        if(this.player == null) {
            return;
        }
        player.setMultiplayerUsername(multiplayerUser.getText());
        player.setMultiplayerServer(multiplayerServer.getText());
        player.setMultiplayerLobby(multiplayerLobby.getText());
        player.setMultiplayerLobbyPassword(multiplayerPassword.getText());
    }
}
