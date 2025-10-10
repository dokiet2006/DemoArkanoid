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
    private JButton tutorialButton;
    private JButton exitButton;
    private JButton bagButton;

    private Image backgroundImage;

    private Sound clickStart;
    private Sound clickBag;

    // Ảnh mặc định và hover
    private ImageIcon startIcon, startHoverIcon;
    private ImageIcon tutorialIcon, tutorialHoverIcon;
    private ImageIcon exitIcon, exitHoverIcon;
    private ImageIcon bagCloseIcon, bagOpenIcon;

    public Menu() {
        setTitle("ARKANOID");
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // sound
        clickStart = new Sound("sound/click.wav");
        clickBag = new Sound("sound/bag.wav");

        // background
        backgroundImage = new ImageIcon("img/background.jpg").getImage();

        // img button
        startIcon = new ImageIcon("img/start_button.png");
        startHoverIcon = new ImageIcon("img/start_hover.png");

        tutorialIcon = new ImageIcon("img/tutorial_button.png");
        tutorialHoverIcon = new ImageIcon("img/tutorial_hover.png");

        exitIcon = new ImageIcon("img/exit_button.png");
        exitHoverIcon = new ImageIcon("img/exit_hover.png");

        bagCloseIcon = new ImageIcon("img/bag_close.png");
        bagOpenIcon = new ImageIcon("img/bag_open.png");

        // panel
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(null);

        // button
        startButton = new JButton(startIcon);
        tutorialButton = new JButton(tutorialIcon);
        exitButton = new JButton(exitIcon);
        bagButton = new JButton(bagCloseIcon);

        // xoa vien va nen
        for (JButton btn : new JButton[]{startButton, tutorialButton, exitButton, bagButton}) {
            btn.setBorderPainted(false);
            btn.setContentAreaFilled(false);
            btn.setFocusPainted(false);
            btn.setOpaque(false);
        }

        // toa do nut
        startButton.setBounds(500, 180, 200, 110);
        exitButton.setBounds(500, 420, 200, 110);
        bagButton.setBounds(1050, 640, 100, 120);
        tutorialButton.setBounds(1050, 550, 100, 100);

        // su kien Click
        startButton.addActionListener(this::startGame);
        tutorialButton.addActionListener(this::showTutorial);
        exitButton.addActionListener(this::exitGame);
        bagButton.addActionListener(this::openBag);

        // Hover Start
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

        // Hover Tutorial
        tutorialButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                tutorialButton.setIcon(tutorialHoverIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                tutorialButton.setIcon(tutorialIcon);
            }
        });

        // Hover Exit
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

        // Hover Bag
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

        // them nut vao pannel
        backgroundPanel.add(startButton);
        backgroundPanel.add(tutorialButton);
        backgroundPanel.add(exitButton);
        backgroundPanel.add(bagButton);

        // gan pannel vao frame
        setContentPane(backgroundPanel);
        setVisible(true);
    }

    // Click Start
    private void startGame(ActionEvent e) {
        clickStart.play();
        JOptionPane.showMessageDialog(this, "Comming Soon");
    }

    // Click Tutorial
    private void showTutorial(ActionEvent e) {
        clickStart.play();
        String tutorialText = """
                * Hướng dẫn sử dụng :
                    + Nhấn SPACE để bắt đầu
                    + Sử dụng phím A/D hoặc trái/phải để di chuyển sang trái hoặc phải
                    + Khi thanh Energy sẵn sàng có thể nhấn "Q" để kích hoạt Artifact
                                   
                * Nhiệm vụ
                    + Diểu khiển thanh Paddle linh hoạt để đỡ bóng
                    + Phá hủy toàn bộ Bricks để qua màn
                    + Đỡ thất bại hoặc chịu sát thương quá số lượng cho phép, nhiệm vụ thất bại
                """
                ;
        JOptionPane.showMessageDialog(this, tutorialText, "Hướng Dẫn", JOptionPane.INFORMATION_MESSAGE);
    }

    // Click Exit
    private void exitGame(ActionEvent e) {
        System.exit(0);
    }

    // Click Bag
    private void openBag(ActionEvent e) {
        clickBag.play();
        JOptionPane.showMessageDialog(this, "Comming Soon");
    }

    // Render
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Menu::new);
    }
}
