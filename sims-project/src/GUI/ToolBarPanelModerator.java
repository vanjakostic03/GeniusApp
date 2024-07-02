package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ToolBarPanelModerator extends JPanel {

    private JPanel contentPanel;
    private JPanel mainPanel;
    private ModeratorFrame moderatorFrame;

    public ToolBarPanelModerator(ModeratorFrame moderatorFrame) {
        this.moderatorFrame = moderatorFrame;
        setLayout(new GridBagLayout());
        initToolBar();
    }


    public void setContentPanel(JPanel newPanel) {
        if (moderatorFrame.contentPanel != null) {
            moderatorFrame.mainPanel.remove(moderatorFrame.contentPanel);
            JOptionPane.showMessageDialog(this, "Enter a valid String",
                    "WARNING", JOptionPane.WARNING_MESSAGE);
        }
        moderatorFrame.contentPanel = newPanel;
        moderatorFrame.contentPanel.setBackground(new Color(255, 255, 255));
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1; // Širina 1 kolona
        c.gridheight = 1; // Visina 1 red
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.85; // 85% dodatnog prostora u širini
        c.weighty = 1;
        moderatorFrame.contentPanel.setVisible(true);
        moderatorFrame.mainPanel.add(moderatorFrame.contentPanel, c);
        moderatorFrame.mainPanel.revalidate();
        moderatorFrame.mainPanel.repaint();
    }

    private void initToolBar() {
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridBagLayout());
        optionsPanel.setBackground(new Color(39, 47, 78));

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.gridwidth = 1; // Širina 1 kolona
        c.gridheight = 1;
        c.insets = new Insets(5, 0, 5, 0);

        JButton albums = createStyledButton("Albums");
        c.gridx = 0;
        c.gridy = 0;
        albums.addActionListener(e -> setContentPanel(new AlbumsPanelModerator()));
        optionsPanel.add(albums, c);

        JButton songs = createStyledButton("Songs");
        c.gridx = 0;
        c.gridy = 1;
        songs.addActionListener(e -> setContentPanel(new SongsPanelModerator()));
        optionsPanel.add(songs, c);

        JButton comments = createStyledButton("Comments");
        c.gridx = 0;
        c.gridy = 2;
        comments.addActionListener(e -> setContentPanel(new CommentsPanelModerator()));
        optionsPanel.add(comments, c);

        JButton activeUsers = createStyledButton("Active users");
        c.gridx = 0;
        c.gridy = 3;
        activeUsers.addActionListener(e -> setContentPanel(new ActiveUsersPanelModerator()));
        optionsPanel.add(activeUsers, c);

        JButton blockedUsers = createStyledButton("Blocked users");
        c.gridx = 0;
        c.gridy = 4;
        blockedUsers.addActionListener(e -> setContentPanel(new BlockedUsersPanelModerator()));
        optionsPanel.add(blockedUsers, c);

        JButton reports = createStyledButton("Reports");
        c.gridx = 0;
        c.gridy = 5;
        reports.addActionListener(e -> setContentPanel(new ReportsPanelModerator()));
        optionsPanel.add(reports, c);

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
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Dialog", Font.PLAIN, 16));
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setBackground(new Color(39, 47, 78));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setPreferredSize(new Dimension(150, 20));
        // Dodavanje MouseListener za hover efekat
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setFont(button.getFont().deriveFont(Font.BOLD));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setFont(button.getFont().deriveFont(Font.PLAIN));
            }
        });

        return button;
    }
}
