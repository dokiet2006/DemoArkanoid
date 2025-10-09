import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static arkanoid.GameObject.GAME_HEIGHT;
import static arkanoid.GameObject.GAME_WIDTH;

public class Menu extends JFrame {
    private JButton playButton;
    private JButton exitButton;
    private JButton bagButton;
    private Image backgroundImage;

    // Khai bao anh mac dinh va anh hover
    private ImageIcon playIcon, playHoverIcon;
    private ImageIcon exitIcon, exitHoverIcon;
    private ImageIcon bagCloseIcon, bagOpenIcon;

    public Menu() {
        setTitle("ARKANOID");
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Tai anh nen
        backgroundImage = new ImageIcon("img/background.png").getImage();

        // Tai anh nut
        playIcon = new ImageIcon("img/play_button.png");
        playHoverIcon = new ImageIcon("img/play_hover.png");

        exitIcon = new ImageIcon("img/exit_button.png");
        exitHoverIcon = new ImageIcon("img/exit_hover.png");

        bagCloseIcon = new ImageIcon("img/bag_close.png");
        bagOpenIcon = new ImageIcon("img/bag_open.png");

        // Tao panel nen
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(null);

        // Tao cac nut voi anh mac dinh
        playButton = new JButton(playIcon);
        exitButton = new JButton(exitIcon);
        bagButton = new JButton(bagCloseIcon);

        // Tat vien va nen de hien thi anh dep
        for (JButton btn : new JButton[]{playButton, exitButton, bagButton}) {
            btn.setBorderPainted(false);
            btn.setContentAreaFilled(false);
            btn.setFocusPainted(false);
            btn.setOpaque(false);
        }

        // Dat vi tri nut
        playButton.setBounds(500, 200, 200, 80);
        exitButton.setBounds(500, 400, 200, 80);
        bagButton.setBounds(1050, 640, 100, 100);

        // Them su kien click
        playButton.addActionListener(this::playGame);
        exitButton.addActionListener(this::exitGame);
        bagButton.addActionListener(this::openBag);

        // Them su kien hover cho play
        playButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                playButton.setIcon(playHoverIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                playButton.setIcon(playIcon);
            }
        });

        // Them su kien hover cho exit
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                exitButton.setIcon(exitHoverIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton.setIcon(exitIcon);
            }
        });

        // Them su kien hover cho bag
        bagButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bagButton.setIcon(bagOpenIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                bagButton.setIcon(bagCloseIcon);
            }
        });

        // Them nut vao panel
        backgroundPanel.add(playButton);
        backgroundPanel.add(exitButton);
        backgroundPanel.add(bagButton);

        // Gan panel vao frame
        setContentPane(backgroundPanel);
        setVisible(true);
    }

    // Khi nhan nut play
    private void playGame(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Game Started!");
    }

    // Khi nhan nut exit
    private void exitGame(ActionEvent e) {
        System.exit(0);
    }

    // Khi nhan nut bag
    private void openBag(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Bag Clicked!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Menu::new);
    }
}
