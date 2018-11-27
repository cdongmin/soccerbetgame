package GUI;

import Exceptions.NothingFoundException;
import model.League;
import model.Standings;
import model.Team;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

public class ComboBox extends JPanel {
    ArrayList<String> strings = new ArrayList<>();
    JComboBox comboBox;
    JTextArea label = new JTextArea();
    JFrame jFrame = new JFrame();

    public ComboBox(Standings league){
        this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        for (Team team : league.getTeams().values())
            strings.add(team.getTeamName());
        String[] array = new String[strings.size()];
        array = strings.toArray(array);
        comboBox = new JComboBox(array);
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED){
                    String st = strings.get(comboBox.getSelectedIndex());
                    Team t = null;
                    try {
                        t = league.lookForTeam(st);
                    } catch (NothingFoundException e1) {
                        e1.printStackTrace();
                    }
                    label.setText(t.printTeamPlayers());
                    label.setRows(t.getPlayers().size());
                    label.setColumns(20);
                    label.setLineWrap(true);
                    label.setWrapStyleWord(true);
                    label.setOpaque(false);
                    label.setEditable(false);
                    label.paintImmediately(label.getVisibleRect());
                    jFrame.setTitle(t.getTeamName()+" Players Info");
                    jFrame.add(label);
                    jFrame.pack();
                    jFrame.setVisible(true);
                }
            }
        });
        this.add(comboBox);
    }

}
