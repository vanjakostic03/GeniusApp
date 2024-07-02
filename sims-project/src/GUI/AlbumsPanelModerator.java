package GUI;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlbumsPanelModerator extends JPanel {

    public AlbumsPanelModerator() {
        setLayout(new GridBagLayout());
        initAlbumsPanel();
    }

    public void initAlbumsPanel() {
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
                g.setColor(Color.BLUE);
                g.fillOval((getWidth() - diameter) / 2, (getHeight() - diameter) / 2, diameter, diameter);
            }
        };
        circlePanel.setPreferredSize(new Dimension(30, 30));
        circlePanel.setBackground(Color.WHITE);
        circlePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        c.gridx = 4;
        c.gridy = 0; // Prvi red
        c.gridwidth = 1; // Zauzima 1 kolonu
        c.weightx = 0.0;
        add(circlePanel, c);

        // Naslov "Albums"
        JLabel titleLabel = new JLabel("Albums");
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        c.gridx = 0;
        c.gridy = 1; // Drugi red
        c.gridwidth = 4; // Zauzima 5 kolona
        c.weightx = 1.0;
        c.weighty = 0.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(titleLabel, c);

        int albumCount = 30; // Primer: prikazuje do 20 albuma
        int albumsPerRow = 4; // Broj albuma po redu
        int startingRow = 2;
        for (int i = 0; i < albumCount; i++) {
            JPanel albumPanel = createAlbumPanel("Cover " + (i + 1), "Album " + (i + 1));
            c.gridx = i % albumsPerRow; // Redni broj kolone u trenutnom redu
            c.gridy = startingRow + i / albumsPerRow; // Redni broj reda
            c.gridwidth = 1; // Zauzima 1 kolonu
            c.weightx = 1.0;
            c.weighty = 1.0;
            c.fill = GridBagConstraints.BOTH;
            add(albumPanel, c);
        }




    }

    private JPanel createAlbumPanel(String coverText, String albumTitle) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(32,38,61));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(2, 2, 2, 2);

        // Cover albuma
        JLabel coverLabel = new JLabel(coverText){
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
        //coverLabel.setBorder(b);
        c.gridx = 0;
        c.gridy = 0; // Prvi red
        c.gridwidth = 1; // Zauzima 1 kolonu
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        panel.add(coverLabel, c);

        // Naslov albuma
        JLabel titleLabel = new JLabel(albumTitle);
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

        return panel;
    }

    private JTextField createSearchBar() {
        JTextField searchBar = new JTextField("Search albums"){
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
        searchBar.setFont(new Font("Dialog", Font.BOLD, 14));
        searchBar.setForeground(Color.LIGHT_GRAY);
        searchBar.setBackground(new Color(39, 47, 78));
        searchBar.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
//        searchBar.setOpaque(false);
        searchBar.setBorder(new RoundBorder()); // Postavljamo zaobljeni okvir

        // Kreiranje ikonice lupe
        ImageIcon searchIcon = new ImageIcon("search_icon.png"); // Postavite putanju do vaše ikonice

        // Kreiranje buttona za ikonicu lupe
        JButton searchIconButton = new JButton(searchIcon);
        searchIconButton.setBackground(new Color(240, 240, 240));
        searchIconButton.setBorder(BorderFactory.createEmptyBorder());
        searchBar.setLayout(new BorderLayout());
        searchBar.add(searchIconButton, BorderLayout.WEST);

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
                // Handle search action here
                System.out.println("Search button clicked");
            }
        });
        return searchButton;
    }

}
