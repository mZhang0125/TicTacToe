import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.*;

public class MengZhangISU implements ActionListener {

    private int count = 0;
    private JButton b[] = new JButton[9];

    private int[][] winCombo = new int[][]{
        	{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}
        };
    private String winner = " ";
    private String player1 = JOptionPane.showInputDialog (null, "Enter the name of Player 1", "Player Name", JOptionPane.INFORMATION_MESSAGE);
    private String player2 = JOptionPane.showInputDialog (null, "Enter the name of Player 2", "Player Name", JOptionPane.INFORMATION_MESSAGE);


    public MengZhangISU() {
    					
        JFrame frame = new JFrame("Tic - Tac - Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(400, 400);
        frame.setLocation(500, 200);

        JPanel p1 = new JPanel();

        p1.setLayout(new GridLayout(3, 3));


        for (int i = 0; i < b.length; i++) {

            b[i] = new JButton();
            p1.add(b[i]);

            b[i].addActionListener(this);
        }

        frame.add(p1);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent a) {
        count++;

        boolean win = false;

        ImageIcon x = new ImageIcon("x.png");
        ImageIcon o = new ImageIcon("o.jpg");

        JButton pressed = (JButton) a.getSource();
        pressed.setEnabled(false);

        if (count % 2 == 1) {
            pressed.setIcon(x);
            winner = player1;
        } else {
            pressed.setIcon(o);
            winner = player2;
        }


        for(int i = 0; i < 8; i++){
        	
            if(("" + b[winCombo[i][0]].getIcon()).equals("" + b[winCombo[i][1]].getIcon()) &&
               ("" + b[winCombo[i][2]].getIcon()).equals("" + b[winCombo[i][1]].getIcon()) &&
               ("" + b[winCombo[i][0]].getIcon()).equals("" + x)){
				win = true;
        	}
        	if(("" + b[winCombo[i][0]].getIcon()).equals("" + b[winCombo[i][1]].getIcon()) &&
               ("" + b[winCombo[i][2]].getIcon()).equals("" + b[winCombo[i][1]].getIcon()) &&
               ("" + b[winCombo[i][0]].getIcon()).equals("" + o)){
               	win = true;
        	}
        }


        if (win == true) {
            JOptionPane.showMessageDialog(null, winner + " wins!");

            int reply = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Tic - Tac - Toe ", JOptionPane.YES_NO_OPTION);

            if (reply == JOptionPane.YES_OPTION) {
                new MengZhangISU();
            } else {
                System.exit(0);

            }

        } else if (count == 9 && win == false) {
            JOptionPane.showMessageDialog(null, "The game was tied");
            int reply = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Tic - Tac - Toe ", JOptionPane.YES_NO_OPTION);

            if (reply == JOptionPane.YES_OPTION) {
                new MengZhangISU();
            } else {
                System.exit(0);

            }
        }

    }

    public static void main(String[] args) {
    	
    	new MengZhangISU();

    } //end main

} //end class