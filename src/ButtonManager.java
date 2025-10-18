package arkanoid;

import javax.swing.*;
import java.awt.event.*;
import arkanoid.Sound;

/**
 * Lớp tiện ích quản lý việc tạo các JButton bằng hình ảnh
 * Dùng chung cho Menu, MapMenu, v.v...
 */
public class ButtonManager {

    /**
     * Tạo nút hình ảnh có hoặc không có hiệu ứng hover
     *
     * @param imagePath đường dẫn ảnh chính
     * @param hoverPath đường dẫn ảnh khi hover
     * @param x tọa độ X
     * @param y tọa độ Y
     * @param click âm thanh click
     * @param action hành động khi nhấn nút
     * @return JButton đã cấu hình
     */
    public static JButton createImageButton(String imagePath, String hoverPath,
                                            int x, int y, Sound click,
                                            ActionListener action) {
        ImageIcon icon = new ImageIcon(imagePath);
        JButton btn = new JButton(icon);
        btn.setBounds(x, y, icon.getIconWidth(), icon.getIconHeight());

        // loại bỏ viền & nền
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        btn.setFocusPainted(false);
        btn.setOpaque(false);

        // hover
        if (hoverPath != null) {
            ImageIcon hoverIcon = new ImageIcon(hoverPath);
            btn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    btn.setIcon(hoverIcon);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btn.setIcon(icon);
                }
            });
        }

        // click
        btn.addActionListener(e -> {
            if (click != null) click.play();
            action.actionPerformed(e);
        });

        return btn;
    }
}
