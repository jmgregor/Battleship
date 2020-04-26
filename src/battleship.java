//1 2-block, 2 3-block, 1 4-block, 1 5-block

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class battleship extends JFrame implements ActionListener {

    JPanel panel = new JPanel();

    int turn = 1, p1hits = 0, p2hits = 0, v, z, m, n;
    boolean won = false;
    //panel 1
    JButton spot1[][] = new JButton[11][11];
    int ships1[][] = new int[11][11];
    JPanel p1 = new JPanel();

    //panel 2
    JButton spot2[][] = new JButton[11][11];
    int ships2[][] = new int[11][11];
    JPanel p2 = new JPanel();

    //both
    //   JLabel title = new JLabel("Welcome to Battleship!!");
    JTextArea text = new JTextArea("");
    JTextArea text2 = new JTextArea("");
    CardLayout cl = new CardLayout();

    public battleship() {
        //Frame
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(780, 600);
        //setSize(800, 598);
        setTitle("Battleship");

        setup();
    }

    public void setup() {

        int y;

        for (int r = 0; r < 11; r++) {
            for (int c = 0; c < 11; c++) {
                ships1[r][c] = 0;
                ships2[r][c] = 0;

            }
        }

        //layout
        panel.setBounds(0, 0, 580, 598);
        p1.setBounds(0, 0, 580, 598);
        p2.setBounds(0, 0, 580, 598);

        p1.setBackground(new Color(209, 58, 239));
        p2.setBackground(new Color(90, 200, 237));

        getContentPane().add(panel);
        getContentPane().add(p1);
        getContentPane().add(p2);

        panel.setLayout(cl);
        p1.setLayout(null);
        p2.setLayout(null);

        cl.show(panel, "1");

        panel.add(p1, "1");
        panel.add(p2, "2");

        add(panel);
//        //default
//        title.setBounds(605, 50, 300, 100);
//        p1.add(title);
//        p2.add(title);
        text.setBounds(570, 100, 180, 260);
        text.setLineWrap(true);
        text.setEditable(false);
        text.setBackground(Color.white);
        text.setText("       Welcome to Battleship!!"
                + "\n ***********************************"
                + "\n               Player 1's turn!"
                + "\n ***********************************"
                + "\n Begin setting up your board:"
                + "\n\n Aircraft Carrier- 5 blocks"
                + "\n Battleship- 4 blocks"
                + "\n Destroyer- 3 blocks"
                + "\n Cruiser- 3 blocks"
                + "\n Submarine- 2 blocks"
                + "\n\nClick the top left corner of your \nship and either go right a "
                + "certain number of blocks or down a \ncertain number of blocks.");

        p1.add(text);
        text.setVisible(false);
        text.setVisible(true);

        text2.setBounds(570, 100, 180, 260);
        text2.setLineWrap(true);
        text2.setEditable(false);
        text2.setBackground(Color.white);
        text2.setText("       Welcome to Battleship!!"
                + "\n ***********************************"
                + "\n               Player 2's turn!"
                + "\n ***********************************"
                + "\n Begin setting up your board:"
                + "\n\n Aircraft Carrier- 5 blocks"
                + "\n Battleship- 4 blocks"
                + "\n Destroyer- 3 blocks"
                + "\n Cruiser- 3 blocks"
                + "\n Submarine- 2 blocks"
                + "\n\nClick the top left corner of your \nship and either go right a "
                + "certain number of blocks or down a \ncertain number of blocks.");

        p2.add(text2);
        text2.setVisible(false);
        text2.setVisible(true);
        //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
        //panel 1
        //create buttons
        for (int r = 0; r < 11; r++) {
            for (int c = 0; c < 11; c++) {
                spot1[r][c] = new JButton();
                String s = "1" + Integer.toString(r) + Integer.toString(c);
                spot1[r][c].addActionListener(this);
                spot1[r][c].setActionCommand(s);
            }
        }

        //set sides
        y = 5;
        for (int r = 0; r < 11; r++) {
            int x = 5;
            for (int c = 0; c < 11; c++) {
                spot1[c][r].setBounds(x, y, 50, 50);
                spot1[c][r].setBackground(Color.white);
                if (r == 0 || c == 0) {
                    spot1[c][r].setEnabled(false);
                    spot1[c][r].setBackground(Color.lightGray);
                    spot1[0][r].setText(Integer.toString(r));
                    spot1[c][0].setText(Integer.toString(c));
                }
                x += 50;
            }
            y += 50;
        }

        //add to panel
        for (int r = 0; r < 11; r++) {
            for (int c = 0; c < 11; c++) {
                p1.add(spot1[r][c]);
            }
        }
        //add
        //   add(p1);
        //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
        //panel 2

        //create buttons
        for (int r = 0; r < 11; r++) {
            for (int c = 0; c < 11; c++) {
                spot2[r][c] = new JButton();
                String s = "2" + Integer.toString(r) + Integer.toString(c);
                spot2[r][c].addActionListener(this);
                spot2[r][c].setActionCommand(s);
            }
        }

        //set sides
        y = 5;
        for (int r = 0; r < 11; r++) {
            int x = 5;
            for (int c = 0; c < 11; c++) {
                spot2[c][r].setBounds(x, y, 50, 50);
                spot2[c][r].setBackground(Color.white);
                if (r == 0 || c == 0) {
                    spot2[c][r].setEnabled(false);
                    spot2[c][r].setBackground(Color.lightGray);
                    spot2[0][r].setText(Integer.toString(r));
                    spot2[c][0].setText(Integer.toString(c));
                }
                x += 50;
            }
            y += 50;
        }

        //add to panel
        for (int r = 0; r < 11; r++) {
            for (int c = 0; c < 11; c++) {
                p2.add(spot2[r][c]);
            }
        }
        //add
        // add(p2);

        //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
        for (int r = 0; r < 11; r++) {
            for (int c = 0; c < 11; c++) {
                spot1[r][c].setVisible(false);
                spot2[r][c].setVisible(false);
                spot1[r][c].setVisible(true);
                spot2[r][c].setVisible(true);
            }
        }
    }

    public void checkwin() {
        if (p1hits == 17) {
            text.setText("       Player 1 wins!\n       Player 1 wins!\n       Player 1 wins!");
            won = true;
        }
        if (p2hits == 17) {
            text2.setText("       Player 2 wins!\n       Player 2 wins!\n       Player 2 wins!");
            won = true;
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();

        for (int x = 1; x <= 2; x++) {
            for (int r = 0; r < 11; r++) {
                for (int c = 0; c < 11; c++) {
                    if (action.equals(Integer.toString(x) + Integer.toString(r) + Integer.toString(c))) {

                        if (x == 1) {
                            if (turn <= 10) {
                                if (turn % 2 == 0) {
                                    z = r;
                                    v = c;
                                } else {
                                    m = r;
                                    n = c;
                                    z = r;
                                    v = c;
                                }
                                for (int a = m; a <= z; a++) {
                                    for (int b = n; b <= v; b++) {
                                        ships1[a][b] = 1;
                                        spot1[a][b].setBackground(new Color(209, 58, 239));
                                        spot1[a][b].setEnabled(false);
                                    }
                                }
                                if (turn == 10) {
                                    for (int z = 0; z < 11; z++) {
                                        for (int s = 0; s < 11; s++) {
                                            spot1[s][z].setBackground(Color.white);
                                            spot1[s][z].setEnabled(true);
                                            if (z == 0 || s == 0) {
                                                spot1[s][z].setEnabled(false);
                                                spot1[s][z].setBackground(Color.lightGray);
                                            }
                                        }
                                    }

                                    //for (int z = 0; z < 11; z++) {
//                                        for (int s = 0; s < 11; s++) {
//                                            if (z == 0 || s == 0) {
//                                                spot2[z][s].setEnabled(false);
//                                                spot2[z][s].setBackground(Color.lightGray);
//                                            } else {
//                                                spot1[z][s].setBackground(Color.white);
//                                                spot1[z][s].setEnabled(true);
//                                            }
//                                        }
//                                    }
                                    cl.show(panel, "2");
                                }
                            }
                            //setup
                            if (turn > 20) {
                                if (ships2[r][c] == 1) {
                                    spot1[r][c].setBackground(Color.red);
                                    spot1[r][c].setEnabled(false);
                                    p1hits++;
                                    text.setText("              HIT!!"
                                            + "\n ***********************************"
                                            + "\n               Player 1's turn!");
                                } else {
                                    spot1[r][c].setBackground(new Color(209, 58, 239));
                                    spot1[r][c].setEnabled(false);
                                    text.setText("              miss!!"
                                            + "\n ***********************************"
                                            + "\n               Player 1's turn!");
                                }
                                checkwin();
                                if (won == true) {
                                    for (int a = 0; a < 11; a++) {
                                        for (int b = 0; b < 11; b++) {
                                            spot1[a][b].setEnabled(false);
                                            spot2[a][b].setEnabled(false);
                                        }
                                    }
                                } else {
                                    cl.show(panel, "2");
                                }
                            }
                            turn++;

                        }//end player 1

                        if (x == 2) {
                            if (turn <= 20) {
                                if (turn % 2 == 0) {
                                    z = r;
                                    v = c;
                                } else {
                                    m = r;
                                    n = c;
                                    z = r;
                                    v = c;
                                }
                                for (int a = m; a <= z; a++) {
                                    for (int b = n; b <= v; b++) {
                                        ships2[a][b] = 1;
                                        spot2[a][b].setBackground(new Color(90, 200, 237));
                                        spot2[a][b].setEnabled(false);
                                    }
                                }
                                if (turn == 20) {
                                    for (int z = 0; z < 11; z++) {
                                        for (int s = 0; s < 11; s++) {
                                            spot2[s][z].setBackground(Color.white);
                                            spot2[s][z].setEnabled(true);
                                            if (z == 0 || s == 0) {
                                                spot2[s][z].setEnabled(false);
                                                spot2[s][z].setBackground(Color.lightGray);
                                            }
                                        }
                                    }
                                    cl.show(panel, "1");
                                }
                            }
//                            
                            if (turn > 20) {
                                if (ships1[r][c] == 1) {
                                    spot2[r][c].setBackground(Color.red);
                                    spot2[r][c].setEnabled(false);
                                    p2hits++;
                                    text2.setText("              HIT!!"
                                            + "\n ***********************************"
                                            + "\n               Player 2's turn!");
                                } else {
                                    spot2[r][c].setBackground(new Color(90, 200, 237));
                                    spot2[r][c].setEnabled(false);
                                    text2.setText("              miss!!"
                                            + "\n ***********************************"
                                            + "\n               Player 2's turn!");
                                }
                                checkwin();
                                if (won == true) {
                                    for (int a = 0; a < 11; a++) {
                                        for (int b = 0; b < 11; b++) {
                                            spot1[a][b].setEnabled(false);
                                            spot2[a][b].setEnabled(false);
                                        }
                                    }
                                } else {
                                    cl.show(panel, "1");
                                }
                            }
                            turn++;

                        }//end player 2

                    }//end if
                }//end c
            }//end r
        }//end x

    }

    public static void main(String[] args) {
        battleship battleship = new battleship();
    }
}
