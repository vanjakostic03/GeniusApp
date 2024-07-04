package View.User;

import View.Moderator.RoundBorder;
import View.User.ToolBarPanelUser;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class UserView extends JPanel {

    ToolBarPanelUser parentPanel;

    public UserView(ToolBarPanelUser parentPanel) {
        this.parentPanel = parentPanel;
        setLayout(new GridBagLayout());
        initHomePanel();
    }

    public void initHomePanel() {
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

        // Naslov "EXPLORE"
        JLabel explore = new JLabel("EXPLORE");
        explore.setFont(new Font("Dialog", Font.BOLD, 32));
        explore.setForeground(Color.WHITE);
        explore.setHorizontalAlignment(SwingConstants.LEFT);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        c.weightx = 1.0;
        c.weighty = 0.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(explore, c);

        // Panel za Zanrove
        JPanel genresPanel = createCategoryPanel("Genres", "genre_image.jpg", new String[]{"Pop", "Rock", "Hip-Hop","trala la"});
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 4;
        c.weightx = 0.5;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        add(genresPanel, c);

        // Panel za Pesme
        JPanel songsPanel = createCategoryPanelSongs("Popular songs", "song_image.jpg", new String[]{"Song 1", "Song 2", "Song 3"});
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 1;
        c.weightx = 0.5;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        add(songsPanel, c);

        // Panel za Popularne Izvođače
        JPanel popularArtistsPanel = createCategoryPanel("Popular Artists", "artist_image.jpg", new String[]{"Artist 1"});
        c.gridx = 2;
        c.gridy = 2;
        c.gridwidth = 1;
        c.weightx = 0.5;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        add(popularArtistsPanel, c);
    }

    private JPanel createCategoryPanel(String categoryTitle, String imagePath, String[] items) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(32, 38, 61));
        panel.setPreferredSize(new Dimension(250, 150));
        panel.setMaximumSize(new Dimension(250, 150));
        panel.setMinimumSize(new Dimension(250, 150));

        // Učitavanje slike za kategoriju
        BufferedImage image = loadImage(imagePath);
        if (image != null) {
            JLabel imageLabel = new JLabel(new ImageIcon(getScaledImage(image, 100, 100)));
            imageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            panel.add(imageLabel, BorderLayout.CENTER);
        }

        // Naslov kategorije
        JLabel titleLabel = new JLabel(categoryTitle);
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        titleLabel.setForeground(Color.white);
        titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        //titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(titleLabel, BorderLayout.NORTH);

        // Panel za prikaz stavki
        JPanel itemsPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        itemsPanel.setBackground(new Color(32, 38, 61));
        itemsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (String item : items) {
            JPanel itemPanel = createItemPanel(item);
            itemsPanel.add(itemPanel);
        }

        panel.add(itemsPanel, BorderLayout.SOUTH);

        return panel;
    }


    private JPanel createItemPanel(String itemName) {
        JPanel itemPanel = new JPanel(new BorderLayout());
        itemPanel.setBackground(new Color(39, 47, 78));
        itemPanel.setBorder(new RoundBorder());
        itemPanel.setPreferredSize(new Dimension(50, 80)); // Podešavanje veličine kvadrata

        // Učitavanje slike za stavku (ovde se može implementirati funkcija za učitavanje slike)
        JLabel imageLabel = new JLabel(new ImageIcon("putanja_do_slike"));
        imageLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        itemPanel.add(imageLabel, BorderLayout.CENTER);

        // Naziv stavke
        JLabel nameLabel = new JLabel(itemName);
        nameLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
        nameLabel.setForeground(Color.white);
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        itemPanel.add(nameLabel, BorderLayout.SOUTH);

        return itemPanel;
    }

    private JPanel createCategoryPanelSongs(String categoryTitle, String imagePath, String[] items) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(32, 38, 61));
        panel.setPreferredSize(new Dimension(250, 300));
        panel.setMaximumSize(new Dimension(250, 300));
        panel.setMinimumSize(new Dimension(250, 300));

        // Učitavanje slike za kategoriju
        BufferedImage image = loadImage(imagePath);
        if (image != null) {
            JLabel imageLabel = new JLabel(new ImageIcon(getScaledImage(image, 100, 100)));
            imageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            panel.add(imageLabel, BorderLayout.CENTER);
        }

        // Naslov kategorije
        JLabel titleLabel = new JLabel(categoryTitle);
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        titleLabel.setForeground(Color.white);
        titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(titleLabel, BorderLayout.NORTH);

        // Panel za prikaz stavki
        JPanel itemsPanel = new JPanel(new GridLayout(items.length, 1, 10, 10)); // Promenjen layout za vertikalni raspored
        itemsPanel.setBackground(new Color(32, 38, 61));
        itemsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (String item : items) {
            JPanel itemPanel = createItemPanelSongs(item);
            itemsPanel.add(itemPanel);
        }

        panel.add(itemsPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createItemPanelSongs(String itemName) {
        JPanel itemPanel = new JPanel(new BorderLayout());
        itemPanel.setBackground(new Color(39, 47, 78));
        itemPanel.setBorder(new RoundBorder());
        itemPanel.setPreferredSize(new Dimension(50, 80)); // Podešavanje veličine kvadrata

        // Učitavanje slike za stavku (ovde se može implementirati funkcija za učitavanje slike)
        JLabel imageLabel = new JLabel(new ImageIcon("putanja_do_slike"));
        imageLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        itemPanel.add(imageLabel, BorderLayout.CENTER);

        // Naziv stavke
        JLabel nameLabel = new JLabel(itemName);
        nameLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
        nameLabel.setForeground(Color.white);
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        itemPanel.add(nameLabel, BorderLayout.SOUTH);

        return itemPanel;
    }


    private BufferedImage loadImage(String imagePath) {
        try {
            return ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Image getScaledImage(Image srcImg, int width, int height) {
        BufferedImage resizedImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, width, height, null);
        g2.dispose();
        return resizedImg;
    }

    private JTextField createSearchBar() {
        JTextField searchBar = new JTextField("      Search artist, genre, album, band..."){
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
