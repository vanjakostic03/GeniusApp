package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ToolBarPanelAdmin extends JPanel {
    private JPanel contentPanel;
    private JPanel mainPanel;
    private AdminFrame adminFrame;

    public ToolBarPanelAdmin(AdminFrame adminFrame) {
        this.adminFrame = adminFrame;
        setLayout(new GridBagLayout());
        initToolBar();
    }
    public void setContentPanel(JPanel newPanel) {

        adminFrame.mainPanel.remove(adminFrame.scrollPane); // Uklanjamo prethodni contentPanel
        adminFrame.contentPanel = newPanel; // Postavljamo novi contentPanel
        // Postavljamo GridBagConstraints za JScrollPane
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.85;
        c.weighty = 1;
        c.insets = new Insets(0, 0, 30, 0);

        JScrollPane scrollPane = new JScrollPane(adminFrame.contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Dodajemo JScrollPane u mainPanel
        adminFrame.scrollPane = scrollPane;
        adminFrame.mainPanel.add(scrollPane, c);

        // Ponovno validiramo i osvežavamo mainPanel
        adminFrame.mainPanel.revalidate();
        adminFrame.mainPanel.repaint();
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

        JButton albums = createStyledButton("Artists");
        c.gridx = 0;
        c.gridy = 0;
        albums.addActionListener(e -> setContentPanel(new ArtistFormPanel()));
        optionsPanel.add(albums, c);

        JButton songs = createStyledButton("Create adv");
        c.gridx = 0;
        c.gridy = 1;
        songs.addActionListener(e -> setContentPanel(new AdvertismentFormPanel()));
        optionsPanel.add(songs, c);

        JButton comments = createStyledButton("Adv profits");
        c.gridx = 0;
        c.gridy = 2;
        comments.addActionListener(e -> setContentPanel(new AdvertismentListPanel()));
        optionsPanel.add(comments, c);

        JButton activeUsers = createStyledButton("Songs views");
        c.gridx = 0;
        c.gridy = 3;
        activeUsers.addActionListener(e -> setContentPanel(new SongListAdminPanel()));
        optionsPanel.add(activeUsers, c);

        JButton home = createStyledButton("HOME");
        c.gridx = 0;
        c.gridy = 4;
        home.addActionListener(e -> setContentPanel(new HomePanelAdmin(this)));
        optionsPanel.add(home, c);

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
                button.setFont(button.getFont().deriveFont(Font.ITALIC));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setFont(button.getFont().deriveFont(Font.PLAIN));
            }
        });

        return button;
    }
    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
    }
}
