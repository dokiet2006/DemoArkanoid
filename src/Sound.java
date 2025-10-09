package arkanoid;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound {
    private Clip clip;

    /**
     * Khởi tạo âm thanh từ đường dẫn file .wav
     */
    public Sound(String filePath) {
        try {
            File soundFile = new File(filePath);

            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    /**
     * Phát âm thanh một lần
     */
    public void play() {
        if (clip != null) {
            if (clip.isRunning()) clip.stop();
            clip.setFramePosition(0);
            clip.start();
        }
    }

    /**
     * Phát lặp liên tục (ví dụ cho nhạc nền)
     */
    public void loop() {
        if (clip != null) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    /**
     * Dừng âm thanh
     */
    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    /**
     * Giải phóng tài nguyên
     */
    public void close() {
        if (clip != null) {
            clip.close();
        }
    }
}
