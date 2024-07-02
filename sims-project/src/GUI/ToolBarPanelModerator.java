package GUI;

import Models.Comment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBarPanelModerator extends JPanel {

    private JPanel contentPanel;
    private JPanel mainPanel;

    public ToolBarPanelModerator(JPanel mainPanel) {
        this.mainPanel=mainPanel;
        setLayout(new GridBagLayout());
        initToolBar();
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }

    private void initToolBar() {

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridBagLayout());
        optionsPanel.setBackground(new Color(39,47,78));

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.gridwidth = 1; // Širina 1 kolona
        c.gridheight = 1;
        c.insets = new Insets(5, 0, 5, 0);


        JButton albums = createStyledButton("Albums");
        c.gridx = 0;
        c.gridy = 0;

        albums.addActionListener(e -> contentPanel = new AlbumsPanelModerator());
        optionsPanel.add(albums,c);


        JButton songs = createStyledButton("Songs");
        c.gridx = 0;
        c.gridy = 1;

        songs.addActionListener(e -> contentPanel = new SongsPanelModerator());
        optionsPanel.add(songs,c);

        JButton comments = createStyledButton("Comments");
        c.gridx = 0;
        c.gridy = 2;

        comments.addActionListener(e -> contentPanel = new CommentsPanelModerator());
        optionsPanel.add(comments,c);

        JButton activeUsers = createStyledButton("Active users");
        c.gridx = 0;
        c.gridy = 3;

        activeUsers.addActionListener(e -> contentPanel = new ActiveUsersPanelModerator());
        optionsPanel.add(activeUsers,c);

        JButton blockedUsers = createStyledButton("Blocked users");
        c.gridx = 0;
        c.gridy = 4;

        blockedUsers.addActionListener(e -> contentPanel = new BlockedUsersPanelModerator());
        optionsPanel.add(blockedUsers,c);

        JButton reports = createStyledButton("Reports");
        c.gridx = 0;
        c.gridy = 5;

        reports.addActionListener(e -> contentPanel = new ReportsPanelModerator());
        optionsPanel.add(reports,c);

        GridBagConstraints panelConstraints = new GridBagConstraints();
        panelConstraints.gridx = 0;
        panelConstraints.gridy = 0;
        panelConstraints.weighty = 1.0;
        panelConstraints.insets = new Insets(15, 0, 500, 100);
        panelConstraints.anchor = GridBagConstraints.PAGE_START;
        panelConstraints.fill = GridBagConstraints.BOTH;
        add(optionsPanel, panelConstraints);
    }



    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setForeground(Color.WHITE); // Postavi boju teksta na belu
        button.setFont(new Font("Dialog", Font.PLAIN, 16)); // Postavi font i veličinu
        button.setHorizontalAlignment(SwingConstants.LEFT); // Poravnaj tekst na levo
        button.setBackground(new Color(39, 47, 78)); // Postavi pozadinsku boju
        button.setBorderPainted(false); // Ukloni granicu
        button.setFocusPainted(false); // Ukloni fokus obrub
        button.setContentAreaFilled(false); // Ukloni content area
        return button;
    }


}
