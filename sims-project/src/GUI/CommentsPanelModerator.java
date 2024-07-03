package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CommentsPanelModerator extends JPanel {

    ToolBarPanelModerator parentPanel ;

    public CommentsPanelModerator(ToolBarPanelModerator parenPanel) {

        this.parentPanel = parenPanel;
        setLayout(new GridBagLayout());
        initCommentsPanel();
    }

    public void initCommentsPanel() {
        this.setBackground(new Color(32, 38, 61));

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(25, 15, 15, 10);

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
        circlePanel.setPreferredSize(new Dimension(55, 55));
        circlePanel.setBackground(new Color(32, 38, 61));
        circlePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        c.gridx = 4;
        c.gridy = 0; // Prvi red
        c.gridwidth = 1; // Zauzima 1 kolonu
        c.weightx = 0.0;
        add(circlePanel, c);

        // Naslov "Comments to approve"
        JLabel titleLabel = new JLabel("Comments to approve");
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

        int commentCount = 30;
        int commentsPerRow = 1;
        int startingRow = 2;
        for (int i = 0; i < commentCount; i++) {
            JPanel commentPanelPanel = createCommentPanel("Cover " + (i + 1), "Comment " + (i + 1));
            c.gridx = i % commentsPerRow; // Redni broj kolone u trenutnom redu
            c.gridy = startingRow + i / commentsPerRow; // Redni broj reda
            c.gridwidth = 4; // Zauzima 1 kolonu
            c.weightx = 1.0;
            c.weighty = 1.0;
            c.fill = GridBagConstraints.BOTH;
            add(commentPanelPanel, c);
        }

    }

    private JPanel createCommentPanel(String coverText, String comment) {
        JPanel panel = new JPanel(){
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
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(39, 47, 78));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(1, 1, 1, 1);

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
        circlePanel.setBackground(new Color(39, 47, 78));
        circlePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.weightx = 0.0;
        c.fill = GridBagConstraints.BOTH;
        panel.add(circlePanel, c);

        JLabel author = new JLabel(  "Author");
        author.setBackground(new Color( 39,47,78));
        author.setFont(new Font("Dialog", Font.BOLD, 24));
        author.setForeground(Color.WHITE);
        author.setHorizontalAlignment(SwingConstants.LEFT);

        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.VERTICAL;
        panel.add(author, c);

        JLabel date = new JLabel(  "12.12.2020.");
        date.setBackground(new Color( 39,47,78));
        date.setFont(new Font("Dialog", Font.PLAIN, 18));
        date.setForeground(Color.WHITE);
        date.setHorizontalAlignment(SwingConstants.LEFT);

        c.gridx = 2;
        c.gridy = 0;
        c.gridwidth = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.VERTICAL;
        panel.add(date, c);

        JLabel grade = new JLabel(  "4.5"){
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
        grade.setBackground(new Color(32, 38, 61));
        grade.setFont(new Font("Dialog", Font.PLAIN, 18));
        grade.setForeground(Color.WHITE);
        grade.setHorizontalAlignment(SwingConstants.LEFT);

        c.gridx = 3;
        c.gridy = 0;
        c.gridwidth = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.VERTICAL;
        panel.add(grade, c);




        JTextArea textLabel = new JTextArea("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        textLabel.setLineWrap(true);
        textLabel.setForeground(Color.WHITE);
        textLabel.setBackground(new Color( 39,47,78));
        textLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 4;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        panel.add(textLabel, c);

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int result = JOptionPane.showOptionDialog(null, // roditelj komponenta, null za centriranje
                        "Do you want to approve comment?", // poruka koja se prikazuje
                        "Approvement", // naslov messagebox-a
                        JOptionPane.YES_NO_OPTION, // tip messagebox-a (yes/no)
                        JOptionPane.QUESTION_MESSAGE, // tip ikonice (pitanje)
                        null, // koristi default ikonicu
                        new String[]{"Yes", "No"}, // opcije koje se prikazuju
                        "Yes"); // podrazumevana opcija

            }
        });

        return panel;
    }

    private JTextField createSearchBar() {
        JTextField searchBar = new JTextField("      Search comments"){
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
