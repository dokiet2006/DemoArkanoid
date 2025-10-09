import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import arkanoid.Sound;

import static arkanoid.GameObject.GAME_HEIGHT;
import static arkanoid.GameObject.GAME_WIDTH;

public class Menu extends JFrame {
    private JButton startButton;
    private JButton exitButton;
    private JButton bagButton;
    private Image backgroundImage;
    private Sound clickStart;
    private Sound clickBag;

    // Khai bao anh mac dinh va anh hover
    private ImageIcon startIcon, startHoverIcon;
    private ImageIcon exitIcon, exitHoverIcon;
    private ImageIcon bagCloseIcon, bagOpenIcon;

    public Menu() {
        setTitle("ARKANOID");
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Tai anh nen
        backgroundImage = new ImageIcon("img/background.jpg").getImage();

        clickStart = new Sound("sound/click.wav");
        clickBag = new Sound("sound/bag.wav");

        // Tai anh nut
        startIcon = new ImageIcon("img/start_button.png");
        startHoverIcon = new ImageIcon("img/start_hover.png");

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
        startButton = new JButton(startIcon);
        exitButton = new JButton(exitIcon);
        bagButton = new JButton(bagCloseIcon);

        // Tat vien va nen de hien thi anh dep
        for (JButton btn : new JButton[]{startButton, exitButton, bagButton}) {
            btn.setBorderPainted(false);
            btn.setContentAreaFilled(false);
            btn.setFocusPainted(false);
            btn.setOpaque(false);
        }

        // Dat vi tri nut
        startButton.setBounds(500, 200, 200, 120);
        exitButton.setBounds(500, 400, 200, 130);
        bagButton.setBounds(1050, 640, 100, 120);

        // Them su kien click
        startButton.addActionListener(this::startGame);
        exitButton.addActionListener(this::exitGame);
        bagButton.addActionListener(this::openBag);

        // Them su kien hover cho start
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                startButton.setIcon(startHoverIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                startButton.setIcon(startIcon);
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
        backgroundPanel.add(startButton);
        backgroundPanel.add(exitButton);
        backgroundPanel.add(bagButton);

        // Gan panel vao frame
        setContentPane(backgroundPanel);
        setVisible(true);
    }

    // Khi nhan nut start
    private void startGame(ActionEvent e) {
        clickStart.play();
        JOptionPane.showMessageDialog(this, "Game Started!");
    }

    // Khi nhan nut exit
    private void exitGame(ActionEvent e) {
        System.exit(0);
    }

    // Khi nhan nut bag
    private void openBag(ActionEvent e) {
        clickBag.play();
        JOptionPane.showMessageDialog(this, "Bag Clicked!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Menu::new);
    }
}
