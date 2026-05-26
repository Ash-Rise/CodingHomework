package cn.edu.ncu.lzc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class TVController {

    @FXML private MediaView mediaView;
    @FXML private Label statusLabel;

    private boolean power = false;
    private int channel = 1;
    private int volume = 60;
    private MediaPlayer mediaPlayer;
    
    private String[] videos = {
        "cartoon.mp4",
        "lec.mp4",
        "news.mp4",
        "rec.mp4"
    };

    @FXML
    public void initialize() {
        mediaView.setVisible(false);
        statusLabel.setText("已关机");
    }

    @FXML
    public void onPower() {
        power = !power;
        
        if (!power) {
            if (mediaPlayer != null) mediaPlayer.stop();
            mediaView.setVisible(false);
            statusLabel.setText("已关机");
        } else {
            mediaView.setVisible(true);
            playVideo();
        }
    }

    @FXML
    public void onChUp() {
        channel++;
        if (channel > videos.length) channel = 1;
        playVideo();
    }

    @FXML
    public void onChDown() {
        channel--;
        if (channel < 1) channel = videos.length;
        playVideo();
    }

    @FXML
    public void onVolUp() {
        volume += 10;
        if(volume > 100) volume = 100;
        updateStatus();
    }

    @FXML
    public void onVolDown() {
        volume -= 10;
        if(volume < 0) volume = 0;
        updateStatus();
    }

    @FXML
    public void onNumClick(ActionEvent e) {
        Button btn = (Button) e.getSource();
        String text = btn.getText();
        
        int num = Integer.parseInt(text);
        channel = num;
        playVideo();
    }

    private void playVideo() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        
        if (channel < 1 || channel > videos.length) {
            updateStatus();
            return;
        }
        
        java.net.URL resource = getClass().getResource(videos[channel - 1]);
        Media media = new Media(resource.toExternalForm());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();
        
        updateStatus();
    }

    private void updateStatus() {
        mediaPlayer.setVolume(volume/100.0);

        if (power) {
            if (channel < 1 || channel > videos.length) {
                statusLabel.setText("找不到频道：" + channel + "  音量： " + volume);
            } else {
                statusLabel.setText("当前频道： " + channel + "  音量： " + volume);
            }
        }
    }
}
