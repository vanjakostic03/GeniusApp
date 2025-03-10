package View.Moderator;

import Models.Data.ArtistService;
import Models.Data.CommentService;
import Models.Data.PublishedWorkService;

import javax.swing.*;
import java.awt.*;

public class ModeratorFrame extends JFrame {

    private String moderator;
    private PublishedWorkService publishedWorkService;
    private ArtistService artistService;
    private CommentService commentService;
    public JPanel mainPanel;
    public JPanel contentPanel;
    public JScrollPane scrollPane;

    public PublishedWorkService getPublishedWorkService() {
        return publishedWorkService;
    }

    public ArtistService getArtistService() {
        return artistService;
    }

    public CommentService getCommentService() {
        return commentService;
    }

    public ModeratorFrame(String userName, PublishedWorkService publishedWorkService, ArtistService artistService, CommentService commentService) {
        this.publishedWorkService = publishedWorkService;
        this.artistService = artistService;
        this.commentService = commentService;

        moderator = userName;
        moderatorUI();
    }

    public void moderatorUI() {
        setTitle("Genius App");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1440, 1024);
        getContentPane().setBackground(new Color(32, 38, 61));
        initModeratorFrame();
        setVisible(true);
    }

    public void initModeratorFrame() {
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(32, 38, 61));
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        ToolBarPanelModerator toolBarPanel = new ToolBarPanelModerator(this);
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

        contentPanel = new HomePanel(toolBarPanel);
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
}
