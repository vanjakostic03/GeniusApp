package View.Moderator;

import Models.PublishedWork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SongsPanelModerator extends JPanel {

    private ToolBarPanelModerator parentPanel;
    private ArrayList<PublishedWork> songs = new ArrayList<>();

    public SongsPanelModerator(ToolBarPanelModerator parentPanel,ArrayList<PublishedWork> songs) {
        this.parentPanel = parentPanel;
        this.songs = songs;
        setLayout(new GridBagLayout());
        initSongsPanel();
    }

    public void initSongsPanel() {
        this.setBackground(new Color(32, 38, 61));

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(25, 5, 15, 15);

        // Search polje
        JTextField searchBar = createSearchBar();
        c.gridx = 0;
        c.gridy = 0; // Prvi red
        c.gridwidth = 4; // Zauzima 4 kolone
        c.weightx = 1.0;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(searchBar, c);

        // Krug panel
        JPanel circlePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int diameter = Math.min(getWidth(), getHeight());
                g.setColor(Color.white);
                g.fillOval((getWidth() - diameter) / 2, (getHeight() - diameter) / 2, diameter, diameter);

            }
        };
        circlePanel.setPreferredSize(new Dimension(60, 60));
        circlePanel.setBackground(new Color(32, 38, 61));
        circlePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        c.gridx = 4;
        c.gridy = 0; // Prvi red
        c.gridwidth = 1; // Zauzima 1 kolonu
        c.weightx = 0.0;
        add(circlePanel, c);

        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/img/plus.png")); // Postavite putanju do vaše ikonice

        Image scaledImage = originalIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon plusIcon = new ImageIcon(scaledImage);

        JButton plusIconButton = new JButton(plusIcon);
        plusIconButton.setOpaque(false);
        plusIconButton.setContentAreaFilled(false);
        plusIconButton.setBorderPainted(false);
        plusIconButton.setFocusPainted(false);
        plusIconButton.setBackground(new Color(240, 240, 240));
        plusIconButton.setBorder(BorderFactory.createEmptyBorder());

        c.gridx = 4;
        c.gridy = 1;
        c.gridwidth = 1;
        c.weightx = 1.0;
        c.weighty = 0.0;
        c.fill = GridBagConstraints.HORIZONTAL;

        add(plusIconButton,c);

        plusIconButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SongForm songForm = new SongForm(null);
                songForm.setVisible(true);
            }
        });


        JLabel titleLabel = new JLabel("Songs");
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        c.gridx = 0;
        c.gridy = 1; // Drugi red
        c.gridwidth = 4; // Zauzima 4 kolona
        c.weightx = 1.0;
        c.weighty = 0.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(titleLabel, c);

        int i = 0;
        int j = 0;
        for (PublishedWork song :this.songs) {
            JPanel songPanel = createSongPanel(song.getCover(), song.getTitle());
            c.gridx = i % 4; // Redni broj kolone u trenutnom redu
            c.gridy = 2 + j ; // Redni broj reda
            c.gridwidth = 1; // Zauzima 1 kolonu
            c.weightx = 1.0;
            c.weighty = 1.0;
            c.fill = GridBagConstraints.BOTH;
            add(songPanel, c);
            i++;
            if(i%4==0){
                j++;
            }
        }

        while(j!=3){
            JPanel songPanel = createEmptyPanel();
            c.gridx = i % 4; // Redni broj kolone u trenutnom redu
            c.gridy = 2 + j ; // Redni broj reda
            c.gridwidth = 1; // Zauzima 1 kolonu
            c.weightx = 1.0;
            c.weighty = 1.0;
            c.fill = GridBagConstraints.BOTH;
            add(songPanel, c);
            i++;
            if(i%4==0){
                j++;
            }
        }
    }

    private JPanel createSongPanel(String coverText, String songTitle) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(32,38,61));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(2, 2, 2, 2);

        // Cover songa
        ImageIcon icon = new ImageIcon(getClass().getResource(coverText));

// Dobijte Image objekat iz ImageIcon-a
        Image image = icon.getImage();

// Skalirajte sliku na željene dimenzije
        Image scaledImage = image.getScaledInstance(160, 160, Image.SCALE_SMOOTH);

// Kreirajte novu ImageIcon sa skaliranom slikom
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel coverLabel = new JLabel(scaledIcon){
            @Override protected void paintComponent(Graphics g) {
                if (!isOpaque() && getBorder() instanceof RoundBorder) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setPaint(getBackground());
                    g2.fill(((RoundBorder) getBorder()).getBorderShape(
                            0, 0, getWidth() - 1, getHeight() - 1));
                    g2.dispose();
                }
                super.paintComponent(g);
            }
            @Override public void updateUI() {
                super.updateUI();
                setOpaque(false);
                setBorder(new RoundBorder());
            }
        };
        coverLabel.setBackground(new Color( 39,47,78));
        coverLabel.setPreferredSize(new Dimension(80, 160));
        c.gridx = 0;
        c.gridy = 0; // Prvi red
        c.gridwidth = 1; // Zauzima 1 kolonu
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        panel.add(coverLabel, c);

        // Naslov songa
        JLabel titleLabel = new JLabel(songTitle);
        titleLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
        titleLabel.setForeground(Color.white);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        c.gridx = 0;
        c.gridy = 1; // Drugi red
        c.gridwidth = 1; // Zauzima 1 kolonu
        c.weightx = 0.0;
        c.weighty = 0.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        panel.add(titleLabel, c);

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SongPanel newPanel = new SongPanel();
                parentPanel.setContentPanel(newPanel);

            }
        });

        return panel;
    }

    public JPanel createEmptyPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        panel.setPreferredSize(new Dimension(80, 160));
        panel.setBackground(new Color(32,38,61));
        return panel;
    }

    private JTextField createSearchBar() {
        JTextField searchBar = new JTextField("      Search songs"){
            @Override protected void paintComponent(Graphics g) {
                if (!isOpaque() && getBorder() instanceof RoundBorder) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setPaint(getBackground());
                    g2.fill(((RoundBorder) getBorder()).getBorderShape(
                            0, 0, getWidth() - 1, getHeight() - 1));
                    g2.dispose();
                }
                super.paintComponent(g);
            }
            @Override public void updateUI() {
                super.updateUI();
                setOpaque(false);
                setBorder(new RoundBorder());
            }
        };

        searchBar.setFont(new Font("Dialog", Font.BOLD, 17));
        searchBar.setForeground(Color.LIGHT_GRAY);
        searchBar.setBackground(new Color(39, 47, 78));
        searchBar.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        searchBar.setBorder(new RoundBorder()); // Postavljamo zaobljeni okvir

        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/img/search.png")); // Postavite putanju do vaše ikonice

        if (originalIcon.getImageLoadStatus() == MediaTracker.COMPLETE) {
            // Promena veličine ikonice
            Image scaledImage = originalIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            ImageIcon searchIcon = new ImageIcon(scaledImage);

            // Kreiranje buttona za ikonicu lupe
            JButton searchIconButton = new JButton(searchIcon);
            searchIconButton.setOpaque(false);
            searchIconButton.setContentAreaFilled(false);
            searchIconButton.setBorderPainted(false);
            searchIconButton.setFocusPainted(false);
            searchIconButton.setBackground(new Color(240, 240, 240));
            searchIconButton.setBorder(BorderFactory.createEmptyBorder());

            searchBar.setLayout(new BorderLayout());
            searchBar.add(searchIconButton, BorderLayout.WEST);
        } else {
            System.err.println("Ikonica nije učitana.");
        }

        return searchBar;
    }


    private JButton createSearchButton() {
        JButton searchButton = new JButton("<html><b>Search</b></html>");
        searchButton.setForeground(Color.LIGHT_GRAY);
        searchButton.setBackground(new Color(240, 240, 240));
        searchButton.setBorder(BorderFactory.createEmptyBorder());
        searchButton.setFocusPainted(false);
        searchButton.setFont(new Font("Dialog", Font.PLAIN, 14));
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Search button clicked");
            }
        });
        return searchButton;
    }


}
