import java.awt.BorderLayout;

import javax.swing.*;
import java.awt.GridLayout;

class gui {
    public static void main(String args[]) {
        JFrame frame = new JFrame("Recipe book");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1334, 750);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 10));
        // 1 ROW 3 COLUMNS
        // panel.setLayout(new Gridlayout(0, 1));

        frame.add(panel, BorderLayout.CENTER);

        JButton button = new JButton("Press");
        frame.getContentPane().add(button); // Adds Button to content pane of frame
        frame.setVisible(true);
    }
}