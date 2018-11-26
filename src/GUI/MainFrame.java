package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MainFrame extends JFrame {
    private JLabel jLabel;
    private JTextField jTextField;

    public MainFrame() {
        setTitle("Canada Soccer League Bet");
        setSize(2000, 450);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());
        jLabel = new JLabel("Welcome!");
        JLabel viewTeamInfo = new JLabel("Would you like to view team information (Y or N)");
        add(jLabel);
        add(viewTeamInfo);
        jTextField = new JTextField(5);
        add(jTextField);
        JButton startButton = new JButton("Answer");
        startButton.setSize(300, 150);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (startButton.getText().equals("Answer")) {
                    if(jTextField.getText().equals("Y")){
                        JLabel teamInfo = new JLabel("Select a team");
                        add(teamInfo);
                        JTextField selectTeam = new JTextField(10);
                        add(selectTeam);
                        if(selectTeam.getText().equals("Vancouver Greens")){
                            JLabel greens = new JLabel("Hi");
                        }
                    }
                    else if (jTextField.getText().equals("N")){

                    }
                }
            }
        });

        add(startButton);

        pack();

    }
}
