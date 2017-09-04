package pl.akademiakodu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class MainFrane extends JFrame implements ActionListener {

    enum PLAYER {O, X}

    ;
    private List<JButton> buttons;
    private Container container;
    private final static int NUM_OF_BUTTONS = 9;
    private String player;
    private PLAYER currentPlayer = PLAYER.O;
    private int turn = 1;

    private void createButtons() {
        for (int i = 0; i < NUM_OF_BUTTONS; i++) {
            JButton b = new JButton("");
            buttons.add(b);
            container.add(b);

            // TODO: add event  (clic) listening for buttons
            // dodanie nasłuchiwania przez metode actionPerformed
            b.addActionListener(this);
        }
    }

    public MainFrane(String title) {
        super(title);
        buttons = new ArrayList<>();
        container = getContentPane();
        setLayout(new GridLayout(3, 3));
        createButtons();
        setMinimumSize(new Dimension(300, 300));
        setLocation(100, 100);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JButton button = (JButton) event.getSource();
        if (currentPlayer == PLAYER.O) {
            button.setText("O");
            currentPlayer = PLAYER.X;
        } else {
            button.setText("X");
            currentPlayer = PLAYER.O;
        }
        turn++;

        button.setEnabled(false);
        int q = checkWinner(PLAYER.O);
        if (q == 1) {
            JOptionPane.showMessageDialog(null, "Wygrał gracz O");
            System.exit(0);
        } else {
            q = checkWinner(PLAYER.X);
            if (q == 1) {
                JOptionPane.showMessageDialog(null, "Wygrał gracz X");
                System.exit(0);
            }
            if (q == 2) {
                JOptionPane.showMessageDialog(null, "Remis");
                System.exit(0);
            }
        }
    }

    private int checkWinner(PLAYER player) {
        String s = player.toString();
        boolean winner = false;

        // sprawdzenie wygranej w kolumnie albo wierszu
        for (int i = 0; i<3; i++) {
            if (buttons.get(i).getText().equals(s) &&
                    buttons.get(i + 3).getText().equals(s) &&
                    buttons.get(i + 6).getText().equals(s)) {
                winner = true;
                break;
            }
            if (buttons.get(i * 3).getText().equals(s) &&
                    buttons.get(i * 3 + 1).getText().equals(s) &&
                    buttons.get(i * 3 + 2).getText().equals(s)) {
                winner = true;
                break;
            }
        }

        if(buttons.get(0).getText().equals(s) &&
                buttons.get(4).getText().equals(s) &&
                buttons.get(8).getText().equals(s)
                ||
                buttons.get(2).getText().equals(s) &&
                        buttons.get(4).getText().equals(s) &&
                        buttons.get(6).getText().equals(s)
                )
            winner = true;

        if (winner) {
            return 1;
        } else
            if (turn == 10) {
            return 2;
            }
            else
                return 0;


        }
}
