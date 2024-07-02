package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SongPanel extends JPanel {
    public SongPanel(){
        setLayout(new GridBagLayout());
        initSongPanel();
    }

    public void initSongPanel(){
        this.setBackground(new Color(32, 38, 61));

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(25, 5, 15, 10);

        JTextField searchBar = createSearchBar();
        c.gridx = 0;
        c.gridy = 0; // Prvi red
        c.gridwidth = 3; // Zauzima 4 kolone
        c.weightx = 1.0;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(searchBar, c);

        JPanel circlePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int diameter = Math.min(getWidth(), getHeight());
                g.setColor(Color.white);
                g.fillOval((getWidth() - diameter) / 2, (getHeight() - diameter) / 2, diameter, diameter);

            }
        };

        circlePanel.setPreferredSize(new Dimension(55, 55));
        circlePanel.setBackground(new Color(32, 38, 61));
        circlePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        c.gridx = 3;
        c.gridy = 0; // Prvi red
        c.gridwidth = 1; // Zauzima 1 kolonu
        c.weightx = 0.0;
        add(circlePanel, c);

        JLabel coverLabel = new JLabel("cover pesme"){
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
        coverLabel.setPreferredSize(new Dimension(100, 160));
        //coverLabel.setBorder(b);
        c.gridx = 0;
        c.gridy = 1; // Prvi red
        c.gridwidth = 1; // Zauzima 1 kolonu
        c.gridheight = 4;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        add(coverLabel, c);


        JTextArea description= new JTextArea("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        description.setBackground(new Color(32, 38, 61));
        description.setFont(new Font("Dialog", Font.PLAIN, 18));
        description.setForeground(Color.WHITE);
        description.setLineWrap(true);

        c.gridx = 0;
        c.gridy = 5; // Prvi red
        c.gridwidth = 1; // Zauzima 1 kolonu
        c.gridheight = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        add(description, c);



        JTextArea title= new JTextArea("Title");
        title.setBackground(new Color(32, 38, 61));
        title.setFont(new Font("Dialog", Font.BOLD, 55));
        title.setForeground(Color.WHITE);
        title.setLineWrap(true);

        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1; // Zauzima 1 kolonu
        c.gridheight = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        add(title, c);

        JTextArea artist= new JTextArea("Artist name");
        artist.setBackground(new Color(32, 38, 61));
        artist.setFont(new Font("Dialog", Font.PLAIN, 30));
        artist.setForeground(Color.WHITE);
        artist.setLineWrap(true);

        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 1; // Zauzima 1 kolonu
        c.gridheight = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        add(artist, c);

        JTextArea views= new JTextArea("73984834");
        views.setBackground(new Color(32, 38, 61));
        views.setFont(new Font("Dialog", Font.PLAIN, 30));
        views.setForeground(Color.WHITE);
        views.setLineWrap(true);

        c.gridx = 2;
        c.gridy = 1;
        c.gridwidth = 1; // Zauzima 1 kolonu
        c.gridheight = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        add(views, c);

        JTextArea releaseDate= new JTextArea("12.12.2012.");
        releaseDate.setBackground(new Color(32, 38, 61));
        releaseDate.setFont(new Font("Dialog", Font.PLAIN, 30));
        releaseDate.setForeground(Color.WHITE);
        releaseDate.setLineWrap(true);

        c.gridx = 2;
        c.gridy = 2;
        c.gridwidth = 1; // Zauzima 1 kolonu
        c.gridheight = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        add(releaseDate, c);

        JPanel associates = createAssociatesPanel();
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        add(associates, c);


        JTextArea lyrics = new JTextArea("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."){
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

        lyrics.setFont(new Font("Dialog", Font.BOLD, 18));
        lyrics.setForeground(Color.WHITE);
        lyrics.setBackground(new Color(39, 47, 78));
        lyrics.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        lyrics.setBorder(new RoundBorder()); // Postavljamo zaobljeni okvir
        lyrics.setLineWrap(true);


        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 2;
        c.gridheight = 2;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        add(lyrics, c);


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

    private JPanel createAssociatesPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(32,38,61));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(1, 1, 1, 1);

        JTextArea composer = new JTextArea("Composer name");
        composer.setBackground(new Color(32, 38, 61));
        composer.setFont(new Font("Dialog", Font.PLAIN, 20));
        composer.setForeground(Color.WHITE);
        composer.setLineWrap(true);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        panel.add(composer, c);

        JTextArea lyricist = new JTextArea("Lyricist name");
        lyricist.setBackground(new Color(32, 38, 61));
        lyricist.setFont(new Font("Dialog", Font.PLAIN, 20));
        lyricist.setForeground(Color.WHITE);
        lyricist.setLineWrap(true);
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        panel.add(lyricist, c);


        return panel;
    }

}
