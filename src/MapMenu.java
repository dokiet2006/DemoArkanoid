import javax.swing.*;
import java.awt.*;
import arkanoid.Sound;
import arkanoid.ButtonManager;

import static arkanoid.GameObject.GAME_HEIGHT;
import static arkanoid.GameObject.GAME_WIDTH;

public class MapMenu extends JFrame {

    private Sound click;
    private Image mapImage;

    public MapMenu() {
        setTitle("SELECT MAP");
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        click = new Sound("sound/click.wav");
        mapImage = new ImageIcon("img/background.jpg").getImage();

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(mapImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(null);

        // Thêm các nút level
        panel.add(ButtonManager.createImageButton("img/button/1.png", null,
                200, 300, click, e -> openLevel(1)));
        panel.add(ButtonManager.createImageButton("img/button/2.png", null,
                450, 280, click, e -> openLevel(2)));
        panel.add(ButtonManager.createImageButton("img/button/3.png", null,
                700, 260, click, e -> openLevel(3)));
        panel.add(ButtonManager.createImageButton("img/button/4.png", null,
                950, 330, click, e -> openLevel(4)));

        // Nút Back
        JButton back = ButtonManager.createImageButton(
                "img/back_button.png", null,
                0, 680, click, e -> {
                    this.dispose();
                    new Menu();
                });
        panel.add(back);

        JButton gacha = ButtonManager.createImageButton(
                "img/gacha_button.png", "img/gacha_hover.png",
                1135, 670, click, e -> {
                    JOptionPane.showMessageDialog(this, "Comming soon");
                }
        );
        panel.add(gacha);

        setContentPane(panel);
        setVisible(true);
    }

    private void openLevel(int level) {
        JOptionPane.showMessageDialog(this, "Comming soon");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MapMenu::new);
    }
}
