package View.User;

import Controler.LoginController;
import Controler.RegisterController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ToolBarPanelUser extends JPanel {

    private JPanel contentPanel;
    private JPanel mainPanel;
    private UserFrame userFrame;

    public ToolBarPanelUser(UserFrame userFrame) {
        this.userFrame = userFrame;
        setLayout(new GridBagLayout());
        initToolBar();
    }

    public void setContentPanel(JPanel newPanel) {

        userFrame.mainPanel.remove(userFrame.scrollPane); // Uklanjamo prethodni contentPanel
        userFrame.contentPanel = newPanel; // Postavljamo novi contentPanel
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

        JScrollPane scrollPane = new JScrollPane(userFrame.contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Dodajemo JScrollPane u mainPanel
        userFrame.scrollPane = scrollPane;
        userFrame.mainPanel.add(scrollPane, c);

        // Ponovno validiramo i osvežavamo mainPanel
        userFrame.mainPanel.revalidate();
        userFrame.mainPanel.repaint();
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

        JButton explore = createStyledButton("Explore");
        c.gridx = 0;
        c.gridy = 0;
        System.out.println(userFrame.getArtistService().getSingleArtists().size());
        explore.addActionListener(e -> setContentPanel (new UserView(this,userFrame.getArtistService().getSingleArtists(),userFrame.getPublishedWorkService().getAlbums())));
        optionsPanel.add(explore, c);


        JButton artists = createStyledButton("Artists");
        c.gridx = 0;
        c.gridy = 1;
        artists.addActionListener(e -> setContentPanel(new ArtistsPanel(this,userFrame.getArtistService().getSingleArtists())));
        optionsPanel.add(artists, c);

        JButton albums = createStyledButton("Albums");
        c.gridx = 0;
        c.gridy = 2;
        albums.addActionListener(e -> setContentPanel(new AlbumsPanel(this,userFrame.getPublishedWorkService().getAlbums())));
        optionsPanel.add(albums, c);

        JButton bands = createStyledButton("Bands");
        c.gridx = 0;
        c.gridy = 3;
        bands.addActionListener(e -> setContentPanel(new BandsPanel(this,userFrame.getArtistService().getBands())));
        optionsPanel.add(bands, c);

        JButton register = createStyledButton("Register");
        c.gridx = 0;
        c.gridy = 10;
        register.addActionListener(e -> {
            RegisterView registerView = new RegisterView();
            new RegisterController(registerView, userFrame.getAcountService());
            registerView.setVisible(true);
        });
       optionsPanel.add(register, c);



        JButton login = createStyledButton("Login");
        c.gridx = 0;
        c.gridy = 11;
        login.addActionListener(e -> {
            LoginView loginView = new LoginView();
            new LoginController(userFrame.getAcountService(),loginView);
            loginView.setVisible(true);
        });
        optionsPanel.add(login, c);


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
}
