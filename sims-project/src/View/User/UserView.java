package View.User;

import Models.PublishedWork;
import Models.SingleArtist;
import View.Moderator.RoundBorder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class UserView extends JPanel {

    private ToolBarPanelUser parentPanel;

    private ArrayList<PublishedWork> albums;
    private ArrayList<SingleArtist> artists;

    public UserView(ToolBarPanelUser parentPanel, ArrayList<SingleArtist> singleArtists, ArrayList<PublishedWork> albums) {
        this.parentPanel = parentPanel;
        this.albums = albums;
        this.artists = singleArtists;
        initHomePanel();
    }

    public void initHomePanel() {
        setBackground(new Color(32, 38, 61));
        setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(25, 5, 15, 10);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 4;
        c.weightx = 1.0;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;

        // Search polje
        JTextField searchBar = createSearchBar();
        add(searchBar, c);

        // Naslov "EXPLORE"
        JLabel explore = new JLabel("EXPLORE");
        explore.setFont(new Font("Dialog", Font.BOLD, 32));
        explore.setForeground(Color.WHITE);
        explore.setHorizontalAlignment(SwingConstants.LEFT);
        c.gridy++;
        c.gridwidth = 3;
        c.weightx = 1.0;
        c.weighty = 0.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(explore, c);

        // Panel za Žanrove
        JPanel genresPanel = createCategoryPanel("Genres", new String[]{"Pop", "Rock", "Hip-Hop", "Electronic"});
        c.gridy++;
        c.gridwidth = 4;
        c.weightx = 0.5;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        add(genresPanel, c);

        // Panel za Pesme
        PublishedWork album1 = (albums.size() >= 1) ? albums.get(0) : null;
        PublishedWork album2 = (albums.size() >= 2) ? albums.get(1) : null;
        PublishedWork album3 = (albums.size() >= 3) ? albums.get(2) : null;
        JPanel songsPanel = createCategoryPanelSongs("Popular songs", new PublishedWork[]{album1, album2, album3});
        c.gridx = 1;
        c.gridy++;
        c.gridwidth = 1;
        c.weightx = 0.5;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        add(songsPanel, c);

        // Panel za Popularne Izvođače
        JPanel popularArtistsPanel = createCategoryPanelArtist("Popular Artists", artists.getFirst());
        c.gridx = 2;
        c.gridy = 2;
        c.gridwidth = 1;
        c.weightx = 0.5;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        add(popularArtistsPanel, c);
    }

    private JPanel createCategoryPanelArtist(String categoryTitle, SingleArtist artist) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(32, 38, 61));
        panel.setPreferredSize(new Dimension(250, 150));
        panel.setMaximumSize(new Dimension(250, 150));
        panel.setMinimumSize(new Dimension(250, 150));

        // Učitavanje slike izvođača
        ImageIcon artistImage = loadImage(artist.getPicture());
        if (artistImage != null) {
            JLabel imageLabel = new JLabel(artistImage);
            imageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            panel.add(imageLabel, BorderLayout.CENTER);
        }

        // Naziv izvođača
        JLabel nameLabel = new JLabel(artist.getName());
        nameLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
        nameLabel.setForeground(Color.white);
        nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        nameLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        panel.add(nameLabel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createCategoryPanel(String categoryTitle, String[] genres) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(32, 38, 61));
        panel.setPreferredSize(new Dimension(250, 150));
        panel.setMaximumSize(new Dimension(250, 150));
        panel.setMinimumSize(new Dimension(250, 150));

        // Naslov kategorije
        JLabel titleLabel = new JLabel(categoryTitle);
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        titleLabel.setForeground(Color.white);
        titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(titleLabel, BorderLayout.NORTH);

        // Panel za prikaz stavki
        JPanel itemsPanel = new JPanel(new GridLayout(1, genres.length, 10, 10));
        itemsPanel.setBackground(new Color(32, 38, 61));
        itemsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (String genre : genres) {
            JPanel itemPanel = createItemPanel(genre);
            itemsPanel.add(itemPanel);
        }

        panel.add(itemsPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createItemPanel(String genreName) {
        JPanel itemPanel = new JPanel(new BorderLayout());
        itemPanel.setBackground(new Color(32, 38, 61));
        itemPanel.setBorder(new RoundBorder());
        itemPanel.setPreferredSize(new Dimension(200, 100)); // Podešavanje veličine kvadrata

        // Učitavanje slike za žanr
        ImageIcon genreImage = loadImageForGenre(genreName);
        if (genreImage != null) {
            JLabel imageLabel = new JLabel(new ImageIcon(getScaledImage(genreImage.getImage(), 150, 100)));
            imageLabel.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
            itemPanel.add(imageLabel, BorderLayout.CENTER);
        }

        // Naziv žanra
        JLabel nameLabel = new JLabel(genreName);
        nameLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
        nameLabel.setForeground(Color.white);
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        itemPanel.add(nameLabel, BorderLayout.SOUTH);

        return itemPanel;
    }

    private ImageIcon loadImageForGenre(String genreName) {
        // Učitavanje slike na osnovu imena žanra
        String imagePath = "";
        switch (genreName.toLowerCase()) {
            case "pop":
                imagePath = "/img/fame.png";
                break;
            case "rock":
                imagePath = "/img/fame.png";
                break;
            case "hip-hop":
                imagePath = "/img/fame.png";
                break;
            case "electronic":
                imagePath = "/img/fame.png";
                break;
            default:
                System.err.println("Unknown genre: " + genreName);
                return null;
        }
        URL imageURL = getClass().getResource(imagePath);
        System.out.println(imageURL);
        if (imageURL != null) {
            return new ImageIcon(imageURL);
        } else {
            System.err.println("Image resource not found: " + imagePath);
        }
        return null;

    }

    private JPanel createCategoryPanelSongs(String categoryTitle, PublishedWork[] items) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(32, 38, 61));
        panel.setPreferredSize(new Dimension(250, 300));
        panel.setMaximumSize(new Dimension(250, 300));
        panel.setMinimumSize(new Dimension(250, 300));

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

        for (PublishedWork item : items) {
            JPanel itemPanel = createItemPanelSongs(item);
            itemsPanel.add(itemPanel);
        }

        panel.add(itemsPanel, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createItemPanelSongs(PublishedWork item) {
        JPanel itemPanel = new JPanel(new BorderLayout());
        itemPanel.setBackground(new Color(39, 47, 78));
        itemPanel.setBorder(new RoundBorder());
        itemPanel.setPreferredSize(new Dimension(200, 80)); // Podešavanje veličine kvadrata

        // Učitavanje slike za album
        ImageIcon albumImage = loadImage(item.getCover());
        if (albumImage != null) {
            JLabel imageLabel = new JLabel(new ImageIcon(getScaledImage(albumImage.getImage(), 150, 80)));
            imageLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            itemPanel.add(imageLabel, BorderLayout.WEST);
        }

        // Naziv pesme
        JLabel nameLabel = new JLabel(item.getTitle());
        nameLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
        nameLabel.setForeground(Color.white);
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        itemPanel.add(nameLabel, BorderLayout.CENTER);

        return itemPanel;
    }

    private ImageIcon loadImage(String imagePath) {
        try {
            return new ImageIcon(ImageIO.read(getClass().getResource(imagePath)));
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
        JTextField searchBar = new JTextField("Search artist, genre, album, band...") {
            @Override
            protected void paintComponent(Graphics g) {
                if (!isOpaque() && getBorder() instanceof RoundBorder) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setPaint(getBackground());
                    g2.fill(((RoundBorder) getBorder()).getBorderShape(
                            0, 0, getWidth() - 1, getHeight() - 1));
                    g2.dispose();
                }
                super.paintComponent(g);
            }

            @Override
            public void updateUI() {
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

        // Učitavanje ikonice za pretragu
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/img/search.png"));
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
