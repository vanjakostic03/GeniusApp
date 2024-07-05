package View.User;

import Controler.LoginController;
import Models.Data.AccountService;
import Models.Data.ArtistService;
import Models.Data.CommentService;
import Models.Data.PublishedWorkService;

import javax.swing.*;
import java.awt.*;

public class UserFrame extends JFrame {

    private String user;
    private PublishedWorkService publishedWorkService;
    private ArtistService artistService;
    private CommentService commentService;
    public JPanel mainPanel;
    public JPanel contentPanel;
    public JScrollPane scrollPane;
    public AccountService accountService;
    private LoginController loginController;

    public PublishedWorkService getPublishedWorkService() {
        return publishedWorkService;
    }

    public ArtistService getArtistService() {
        return artistService;
    }
    public AccountService getAcountService() {
        return accountService;
    }

    public CommentService getCommentService() {
        return commentService;
    }

    public UserFrame(String userName, PublishedWorkService publishedWorkService, ArtistService artistService, CommentService commentService, AccountService accountService,LoginController loginController) {
        this.publishedWorkService = publishedWorkService;
        this.artistService = artistService;
        this.commentService = commentService;
        this.accountService = accountService;
        user = userName;
        this.loginController = loginController;
        userUI();
    }

    public void userUI() {
        setTitle("Genius App");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1440, 1024);
        getContentPane().setBackground(new Color(32, 38, 61));
        initUserFrame();
        setVisible(true);
    }

    public void initUserFrame() {
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(32, 38, 61));
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        ToolBarPanelUser toolBarPanel = new ToolBarPanelUser(this);
        toolBarPanel.setBackground(new Color(39, 47, 78));

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.15;
        c.weighty = 1;
        c.insets = new Insets(0, 166, 0, 0);
        mainPanel.add(toolBarPanel, c);

        contentPanel = new UserView(toolBarPanel,artistService.getSingleArtists(),publishedWorkService.getAlbums());
        contentPanel.setBackground(new Color(32, 38, 61));
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.85;
        c.weighty = 1;
        c.insets = new Insets(0, 0, 0, 0);

        scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        mainPanel.add(scrollPane, c);

        this.add(mainPanel);
    }

    public void switchToLoggedInToolbar() {
        ToolBarPanelLoggedIn toolbar = new ToolBarPanelLoggedIn(this);
        getContentPane().remove(0); // Pretpostavka: toolbar je prvi dodat panel
        getContentPane().add(toolbar, 0);
        validate();
        repaint();
    }
}
