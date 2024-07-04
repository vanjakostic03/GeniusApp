package View.Moderator;

import Enums.TypeOfArtist;
import Models.Artist;
import Models.Bend;
import Models.SingleArtist;
import Models.Song;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SongPanel extends JPanel {
    private Song song;
    //private String songTitle;
    public SongPanel(Song song){
        this.song = song;
        setLayout(new GridBagLayout());
        initSongPanel();
    }

    public void initSongPanel(){
        this.setBackground(new Color(32, 38, 61));

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(25, 15, 15, 25);

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

        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/img/minus.png")); // Postavite putanju do vaše ikonice

        // Promena veličine ikonice
        Image scaledImage = originalIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon minusIcon = new ImageIcon(scaledImage);

        // Kreiranje buttona za ikonicu lupe
        JButton minusIconButton = new JButton(minusIcon);
        minusIconButton.setOpaque(false);
        minusIconButton.setContentAreaFilled(false);
        minusIconButton.setBorderPainted(false);
        minusIconButton.setFocusPainted(false);
        minusIconButton.setBackground(new Color(240, 240, 240));
        minusIconButton.setBorder(BorderFactory.createEmptyBorder());

        c.gridx = 3;
        c.gridy = 1;
        c.gridwidth = 1;
        c.weightx = 1.0;
        c.weighty = 0.0;
        c.fill = GridBagConstraints.HORIZONTAL;

        add(minusIconButton,c);

        minusIconButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showOptionDialog(null,
                        "Do you want to delete song?",
                        "song",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new String[]{"Yes", "No"},
                        "Yes");
            }
        });



        originalIcon = new ImageIcon(getClass().getResource("/img/edit.png"));

        scaledImage = originalIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon editIcon = new ImageIcon(scaledImage);

        JButton editIconButton = new JButton(editIcon);
        editIconButton.setOpaque(false);
        editIconButton.setContentAreaFilled(false);
        editIconButton.setBorderPainted(false);
        editIconButton.setFocusPainted(false);
        editIconButton.setBackground(new Color(240, 240, 240));
        editIconButton.setBorder(BorderFactory.createEmptyBorder());

        c.gridx = 3;
        c.gridy = 2;
        c.gridwidth = 1;
        c.weightx = 1.0;
        c.weighty = 0.0;
        c.fill = GridBagConstraints.HORIZONTAL;

        add(editIconButton,c);

        editIconButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showOptionDialog(null,
                        "Update?",
                        "song",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new String[]{"Yes", "No"},
                        "Yes");
            }
        });

        originalIcon = new ImageIcon(getClass().getResource("/img/review.png"));

        scaledImage = originalIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon reviewIcon = new ImageIcon(scaledImage);

        JButton reviewIconButton = new JButton(reviewIcon);
        reviewIconButton.setOpaque(false);
        reviewIconButton.setContentAreaFilled(false);
        reviewIconButton.setBorderPainted(false);
        reviewIconButton.setFocusPainted(false);
        reviewIconButton.setBackground(new Color(240, 240, 240));
        reviewIconButton.setBorder(BorderFactory.createEmptyBorder());

        c.gridx = 3;
        c.gridy = 3;
        c.gridwidth = 1;
        c.weightx = 1.0;
        c.weighty = 0.0;
        c.fill = GridBagConstraints.HORIZONTAL;

        add(reviewIconButton,c);

        reviewIconButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ReviewForm reviewForm = new ReviewForm();
                reviewForm.setVisible(true);
            }
        });

        ImageIcon icon = new ImageIcon(getClass().getResource(song.getCover()));
        Image image = icon.getImage();

        Image scaledcoverImage = image.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledcoverImage);

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
        coverLabel.setBackground(new Color(32, 38, 61));
        coverLabel.setPreferredSize(new Dimension(160, 120));
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1; // Zauzima 1 kolonu
        c.gridheight = 4;
        c.weightx = 1.0;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.BOTH;
        add(coverLabel, c);


        JTextArea description= new JTextArea(song.getDescription());
        description.setBackground(new Color(32, 38, 61));
        description.setFont(new Font("Dialog", Font.PLAIN, 18));
        description.setForeground(Color.WHITE);
        description.setLineWrap(true);

        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 1.0;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.BOTH;
        add(description, c);



        JTextArea title= new JTextArea(song.getTitle());
        title.setBackground(new Color(32, 38, 61));
        title.setFont(new Font("Dialog", Font.BOLD, 25));
        title.setForeground(Color.WHITE);
        title.setLineWrap(true);

        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1; // Zauzima 1 kolonu
        c.gridheight = 1;
        c.weightx = 1.0;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.BOTH;
        add(title, c);

        String artists ="";
        if(song.getArtists()!=null){
            for(Artist a: song.getArtists()) {
                if(a.getTypeOfArtist() == TypeOfArtist.BAND){
                    Bend b = (Bend)a;
                    artists+= b.getName() + "\n";
                }else{
                    SingleArtist sa = (SingleArtist) a;
                    artists+= sa.getName() + "\n";
                }
            }
        }

        JTextArea artist= new JTextArea(artists);
        artist.setBackground(new Color(32, 38, 61));
        artist.setFont(new Font("Dialog", Font.PLAIN, 25));
        artist.setForeground(Color.WHITE);
        artist.setLineWrap(true);

        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 1; // Zauzima 1 kolonu
        c.gridheight = 1;
        c.weightx = 1.0;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.BOTH;
        add(artist, c);

        JTextArea views= new JTextArea(String.valueOf(song.getViews()));
        views.setBackground(new Color(32, 38, 61));
        views.setFont(new Font("Dialog", Font.PLAIN, 16));
        views.setForeground(Color.WHITE);
        views.setLineWrap(true);

        c.gridx = 2;
        c.gridy = 1;
        c.gridwidth = 1; // Zauzima 1 kolonu
        c.gridheight = 1;
        c.weightx = 1.0;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.BOTH;
        add(views, c);

        JTextArea releaseDate= new JTextArea(String.valueOf(song.getReleaseDate()));
        releaseDate.setBackground(new Color(32, 38, 61));
        releaseDate.setFont(new Font("Dialog", Font.PLAIN, 16));
        releaseDate.setForeground(Color.WHITE);
        releaseDate.setLineWrap(true);

        c.gridx = 2;
        c.gridy = 2;
        c.gridwidth = 1; // Zauzima 1 kolonu
        c.gridheight = 1;
        c.weightx = 1.0;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.BOTH;
        add(releaseDate, c);

        JPanel associates = createAssociatesPanel();
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.weightx = 1.0;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.BOTH;
        add(associates, c);


        JTextArea lyrics = new JTextArea(song.getLyrics()){
            @Override protected void paintComponent(Graphics g) {
                if (!isOpaque() && getBorder() instanceof RoundBorder) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setPaint(getBackground());
                    g2.fill(((RoundBorder) getBorder()).getBorderShape(
                            0, 0, getWidth() - 1, getHeight() - 50));
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
        lyrics.setBorder(new EmptyBorder(10, 10, 10, 10));

        lyrics.setFont(new Font("Dialog", Font.BOLD, 18));
        lyrics.setForeground(Color.WHITE);
        lyrics.setBackground(new Color(39, 47, 78));
        lyrics.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        lyrics.setBorder(new RoundBorder()); // Postavljamo zaobljeni okvir
        lyrics.setLineWrap(true);
        lyrics.setWrapStyleWord(true);
        lyrics.setAlignmentX(CENTER_ALIGNMENT);
        lyrics.setMargin(new Insets(100, 10, 10, 10));


        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 2;
        c.gridheight = 2;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.insets = new Insets(10, 10, 10, 10);
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

        //JTextArea composer = new JTextArea(song.getComposer().getName());
        JTextArea composer = new JTextArea("song.getComposer().getName()");
        composer.setBackground(new Color(32, 38, 61));
        composer.setFont(new Font("Dialog", Font.PLAIN, 16));
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

        JTextArea lyricist = new JTextArea("efjlesfjfe");
       // JTextArea lyricist = new JTextArea(song.getLyricist().getName());
        lyricist.setBackground(new Color(32, 38, 61));
        lyricist.setFont(new Font("Dialog", Font.PLAIN, 16));
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
