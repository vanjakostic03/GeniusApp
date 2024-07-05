package View.User;
import Models.*;
import View.Moderator.RoundBorder;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ArtistsPanel extends JPanel {


    ToolBarPanelUser parentPanel ;
    ArrayList<SingleArtist> artists = new ArrayList<>() ;

    public void setAlbums(ArrayList<SingleArtist> artists) {
        this.artists = artists;
    }

    public ArtistsPanel(ToolBarPanelUser parenPanel, ArrayList<SingleArtist> artists) {

        this.parentPanel = parenPanel;
        this.artists = artists;
        setLayout(new GridBagLayout());
        initArtistPanel();
    }

    public void initArtistPanel() {
        this.setBackground(new Color(32, 38, 61));

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(25, 5, 15, 10);

        // Search polje
        JTextField searchBar = createSearchBar();
        c.gridx = 0;
        c.gridy = 0; // Prvi red
        c.gridwidth = 4; // Zauzima 4 kolone
        c.weightx = 1.0;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(searchBar, c);

        // Naslov "Artists"
        JLabel titleLabel = new JLabel("Artists");
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 4;
        c.weightx = 1.0;
        c.weighty = 0.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(titleLabel, c);


        int i = 0;
        int j = 0;
        for (SingleArtist a :this.artists) {
            System.out.println(a.getPicture());
            System.out.println("slikaaa");
            JPanel artistPanel = createArtistPanel(a.getPicture(), a.getName());
            c.gridx = i % 4; // Redni broj kolone u trenutnom redu
            c.gridy = 2 + j ; // Redni broj reda
            c.gridwidth = 1; // Zauzima 1 kolonu
            c.weightx = 1.0;
            c.weighty = 1.0;
            c.fill = GridBagConstraints.BOTH;
            add(artistPanel, c);
            i++;
            if(i%4==0){
                j++;
            }
        }

        while(j!=3){
            JPanel albumPanel = createEmptyPanel();
            c.gridx = i % 4; // Redni broj kolone u trenutnom redu
            c.gridy = 2 + j ; // Redni broj reda
            c.gridwidth = 1; // Zauzima 1 kolonu
            c.weightx = 1.0;
            c.weighty = 1.0;
            c.fill = GridBagConstraints.BOTH;
            add(albumPanel, c);
            i++;
            if(i%4==0){
                j++;
            }
        }
    }
    private JPanel createArtistPanel(String coverText, String name) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(32,38,61));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(1, 1, 1, 1);
        System.out.println(coverText);
        ImageIcon icon = new ImageIcon(getClass().getResource(coverText));

        Image image = icon.getImage();

        Image scaledImage = image.getScaledInstance(160, 160, Image.SCALE_SMOOTH);

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
        //coverLabel.setBackground(new Color( 39,47,78));
        coverLabel.setPreferredSize(new Dimension(80, 160));

        c.gridx = 0;
        c.gridy = 0; // Prvi red
        c.gridwidth = 1; // Zauzima 1 kolonu
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        panel.add(coverLabel, c);

        // Naslov albuma
        JLabel titleLabel = new JLabel(name);
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

        //panel.addMouseListener(new MouseAdapter() {
        //    @Override
        //    public void mouseClicked(MouseEvent e) {
        //        AlbumPanel newPanel = new AlbumPanel();
        //        parentPanel.setContentPanel(newPanel);
        //   }
        //});

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
        JTextField searchBar = new JTextField("      Search artists"){
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

}
