import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Main {

    private static char turn = 'X';
    private static JLabel title2;
    private static ArrayList<JLabel> labels = new ArrayList<JLabel>();
    private static String winner = " ";
    private static char[][] chars = new char[3][3];
    private static boolean enabled = true;

    public static void main(String[] args) {

        // Jframe
        JFrame frame = new JFrame("Tic-Tac-Toe");
        frame.setSize(340, 490);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.setBackground(Color.white);

        // Jlable
        JLabel title = new JLabel("Tic-Tac-Toe");
        title.setForeground(new Color(127, 85, 57));
        title.setBackground(new Color(237, 224, 212));
        title.setOpaque(true);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        title.setFont(new Font("Tahoma", Font.BOLD, 25));
        frame.add(title, BorderLayout.NORTH);

        // Jpanel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3, 7, 7));
        panel.setBackground(new Color(237, 224, 212));
        panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(237, 224, 212), 15));

        title2 = new JLabel("Player 1, it's your turn");
        title2.setHorizontalAlignment(SwingConstants.CENTER);
        title2.setBackground(Color.white);
        title2.setForeground(new Color(127, 85, 57));
        title2.setOpaque(true);
        title2.setFont(new Font("Tahoma", Font.BOLD, 25));
        title2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JLabel label = new JLabel(" ");
                label.setOpaque(true);
                label.setBackground(Color.white);
                label.setFont(new Font("Tahoma", Font.BOLD, 50));
                label.setHorizontalAlignment(SwingConstants.CENTER);
                int m = i;
                int n = j;
                label.addMouseListener(new MouseListener() {

                    @Override
                    public void mouseReleased(MouseEvent e) {
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                    }

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (enabled) {
                            if (label.getText().toString().equals(" ")) {
                                label.setText(String.valueOf(turn));
                                chars[m][n] = turn;

                                if (turn == 'X') {
                                    label.setForeground(new Color(199, 81, 70));
                                    turn = 'O';
                                    title2.setText("Player 2, it's your turn");
                                    title2.setForeground(new Color(246, 189, 96));
                                } else {
                                    label.setForeground(new Color(246, 189, 96));
                                    turn = 'X';
                                    title2.setText("Player 1, it's your turn");
                                    title2.setForeground(new Color(173, 46, 36));
                                }

                            } else {
                                title2.setText("Position taken!");
                            }
                            if (checkWinner() && winner.equals("X")) {
                                title2.setText("Player 1 wins!");
                                title2.setForeground(new Color(173, 46, 36));
                                enabled = false;
                            } else if (checkWinner() && winner.equals("O")) {
                                title2.setText("Player 2 wins!");
                                title2.setForeground(new Color(246, 189, 96));
                                enabled = false;
                            } else if (!draw()) {
                                title2.setText("Draw");
                                enabled = false;
                            }
                        }
                    }
                });
                labels.add(label);
                panel.add(label);
            }
        }

        frame.add(panel, BorderLayout.CENTER);

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2, 1));
        p.add(title2);

        JButton btn = new JButton("Restart");
        btn.setBackground(new Color(173, 46, 36));
        btn.setForeground(Color.white);
        btn.setFont(new Font("Tahoma", Font.BOLD, 30));
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                reboot();
            }
        });

        p.add(btn);

        frame.add(p, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private static boolean checkWinner() {
        boolean win = false;
        if (chars[0][0] == chars[0][1] && chars[0][0] == chars[0][2] && chars[0][0] != 0) {
            win = true;
            winner = String.valueOf(chars[0][0]);
        } else if (chars[1][0] == chars[1][1] && chars[1][0] == chars[1][2] && chars[1][0] != 0) {
            win = true;
            winner = String.valueOf(chars[1][0]);
        } else if (chars[2][0] == chars[2][1] && chars[2][0] == chars[2][2] && chars[2][0] != 0) {
            win = true;
            winner = String.valueOf(chars[2][0]);
        } else if (chars[0][0] == chars[1][0] && chars[0][0] == chars[2][0] && chars[0][0] != 0) {
            win = true;
            winner = String.valueOf(chars[0][0]);
        } else if (chars[0][1] == chars[1][1] && chars[0][1] == chars[2][1] && chars[0][1] != 0) {
            win = true;
            winner = String.valueOf(chars[0][1]);
        } else if (chars[0][2] == chars[1][2] && chars[0][2] == chars[2][2] && chars[0][2] != 0) {
            win = true;
            winner = String.valueOf(chars[0][2]);
        } else if (chars[0][0] == chars[1][1] && chars[0][0] == chars[2][2] && chars[0][0] != 0) {
            win = true;
            winner = String.valueOf(chars[0][0]);
        } else if (chars[2][0] == chars[1][1] && chars[2][0] == chars[0][2] && chars[2][0] != 0) {
            win = true;
            winner = String.valueOf(chars[2][0]);
        }
        return win;
    }

    private static void reboot() {
        chars = new char[3][3];
        winner = " ";
        title2.setText("Player 1, it's your turn");
        title2.setForeground(new Color(173, 46, 36));
        turn = 'X';
        enabled = true;
        for (JLabel label : labels) {
            label.setText(" ");
        }
    }

    private static boolean draw() {
        boolean draw = false;
        for (char[] a : chars) {
            for (char b : a) {
                if (b == 0) {
                    draw = true;
                    break;
                }
            }
        }
        return draw;
    }
}
