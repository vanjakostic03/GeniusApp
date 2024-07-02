package GUI;

import Models.GeniusApp;

import javax.swing.*;
import java.awt.*;

public class ModeratorFrame extends JFrame {

    private String moderator;


    public ModeratorFrame(String userName) {
        moderator = userName;
        moderatorUI();
    }

    public void moderatorUI() {
        setTitle("Genius App");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(1440, 1024);
        initModeratorFrame();
        getContentPane().setBackground(new Color(32, 38, 61));

    }

//    public void initModeratorFrame() {
//        JPanel panel = new JPanel();
//        panel.setLayout(new GridBagLayout());
//        GridBagConstraints c = new GridBagConstraints();
//
//        // Postavljanje prve kolone (toolBar)
//        JPanel toolBar = new JPanel();
//        toolBar.setBackground(new Color(39, 47, 78));
//        toolBar.setPreferredSize(new Dimension(200, 1024)); // Postavi dimenzije toolBar-a
//        c.gridx = 0;
//        c.gridy = 0;
//        c.fill = GridBagConstraints.VERTICAL;
//        c.anchor = GridBagConstraints.WEST;
//        c.insets = new Insets(0, 166, 0, 0); // Pomeri udesno za 166 piksela
//        panel.add(toolBar, c);
//
//        // Postavljanje druge kolone (contentPanel)
//        JPanel contentPanel = new JPanel();
//        contentPanel.setBackground(new Color(32, 38, 61));
//        contentPanel.setPreferredSize(new Dimension(1240, 1024)); // Postavi dimenzije contentPanel-a
//        c.gridx = 1;
//        c.gridy = 0;
//        c.fill = GridBagConstraints.BOTH;
//        panel.add(contentPanel, c);
//
//        // Dodavanje panela u JFrame
//        add(panel);
//    }

    public void initModeratorFrame() {

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(32, 38, 61));

        GridBagLayout layout = new GridBagLayout();
        mainPanel.setLayout(layout);
        GridBagConstraints c = new GridBagConstraints();

        ToolBarPanelModerator toolBarPanel = new ToolBarPanelModerator(mainPanel);
        //toolBarPanel.setBackground(new Color(255, 0, 0));
        toolBarPanel.setBackground(new Color(39, 47, 78));
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1; // Širina 1 kolona
        c.gridheight = 1; // Visina 1 red
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.15; // 15% dodatnog prostora u širini
        c.weighty = 1;
        c.insets = new Insets(0, 166, 0, 0);
        mainPanel.add(toolBarPanel, c);
        c.insets = new Insets(0, 0, 0, 0);

        //JPanel contentPanel =  toolBarPanel.getContentPanel();
        JPanel contentPanel =  new JPanel();
        contentPanel.setBackground(new Color(32, 38, 61));
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1; // Širina 1 kolona
        c.gridheight = 1; // Visina 1 red
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.85; // 85% dodatnog prostora u širini
        c.weighty = 1;

        mainPanel.add(contentPanel, c);

        this.add(mainPanel);
        mainPanel.setVisible(true);



    }

}