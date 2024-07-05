package View.Moderator;

import Enums.TypeOfArtist;
import Models.Artist;
import Models.Bend;
import Models.SingleArtist;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AlbumForm extends JFrame {

    private JTextField titleField ;
    private JTextField coverField;
    private String[] genresStrings = {"zanr1","zanr2"};
    private JList<String> genreList = new JList<String>(genresStrings);
    private String[] artistsStrings = {"artist1","artist2"};
    private JList<String> artistList= new JList<String>(artistsStrings);
    private JTextArea descriptionField;

    private DefaultListModel<String> songListModel;
    private JList<String> songList;

    private JButton submitButton = new JButton("Submit");
    private JButton addSongButton = new JButton("Add Song");


    private ArrayList<Artist> artists = new ArrayList<>();


    public AlbumForm(ArrayList<Artist> artists) {
        //parentFrame = parentFrame;

        this.artists = artists;
        artistsStrings = new String[artists.size()];

        int i = 0;
        for(Artist a : artists){
            if (a.getTypeOfArtist() == TypeOfArtist.SINGLE_ARTIST) {
                SingleArtist sa = (SingleArtist) a;
                artistsStrings[i] = sa.getId()+","+sa.getName();
            }else{
                Bend b = (Bend) a;
                artistsStrings[i] = b.getId()+","+b.getName();
            }
            i++;
        }
        artistList= new JList<String>(artistsStrings);

        setTitle("Album Entry Form");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        initGUI();

    }

    private void initGUI(){
        JPanel formPanel = new JPanel();
        formPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        formPanel.setLayout(new GridBagLayout());

        genreList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        artistList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);



        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.HORIZONTAL;

        formPanel.setBackground(new Color(39, 47, 78));

        // Title
        c.gridx = 0;
        c.gridy = 0;
        JLabel titleLabel = new JLabel("Title");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        formPanel.add(titleLabel, c);

        titleField = new JTextField(20);
        c.gridx = 1;
        formPanel.add(titleField, c);

        // Cover
        c.gridx = 0;
        c.gridy = 1;

        JLabel coverLabel = new JLabel("Cover URL: ");
        coverLabel.setForeground(Color.WHITE);
        coverLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        formPanel.add(coverLabel, c);

        coverField = new JTextField(20);
        c.gridx = 1;
        formPanel.add(coverField, c);



        // Zanrovi
        c.gridx = 0;
        c.gridy = 2;
        JLabel genresLabel = new JLabel("Genres: ");
        genresLabel.setForeground(Color.WHITE);
        genresLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        formPanel.add(genresLabel, c);


        JScrollPane genresScrollPane = new JScrollPane(genreList);
        genresScrollPane.setPreferredSize(new Dimension(200, 100));
        c.gridx = 1;
        formPanel.add(genresScrollPane, c);

        // Izvođači
        c.gridx = 0;
        c.gridy = 3;

        JLabel artistsLabel = new JLabel("Artists: ");
        artistsLabel.setForeground(Color.WHITE);
        artistsLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        formPanel.add(artistsLabel, c);

        JScrollPane artistScrollPane = new JScrollPane(artistList);
        artistScrollPane.setPreferredSize(new Dimension(200, 100));
        c.gridx = 1;
        formPanel.add(artistScrollPane, c);

        // Songs
        c.gridx = 0;
        c.gridy = 4;
        JLabel songsLabel = new JLabel("Songs: ");
        songsLabel.setForeground(Color.WHITE);
        songsLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        formPanel.add(songsLabel, c);

        songListModel = new DefaultListModel<>();
        songList = new JList<>(songListModel);
        JScrollPane songScrollPane = new JScrollPane(songList);
        songScrollPane.setPreferredSize(new Dimension(200, 100));
        c.gridx = 1;
        formPanel.add(songScrollPane, c);

        //Description
        c.gridx = 0;
        c.gridy = 5;

        JLabel descriptionLabel = new JLabel("Description: ");
        descriptionLabel.setForeground(Color.WHITE);
        descriptionLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        formPanel.add(descriptionLabel, c);

        descriptionField = new JTextArea(5, 20);
        JScrollPane descriptionScrollPane = new JScrollPane(descriptionField);
        c.gridx = 1;
        c.fill = GridBagConstraints.BOTH;
        formPanel.add(descriptionScrollPane, c);

        // Add Song Button
        //AlbumForm albumForm = this;
//        addSongButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                SongForm songForm = new SongForm(albumForm,artists);
//                songForm.setVisible(true);
//            }
//        });
        c.gridx = 2;
        c.gridy = 4;
        formPanel.add(addSongButton, c);

        // Submit Button

        c.gridx = 1;
        c.gridy = 8;
        c.fill = GridBagConstraints.NONE;
        formPanel.add(submitButton, c);

        add(formPanel, BorderLayout.CENTER);
    }

    public String getTitle(){return titleField.getText(); }
    public String getCoverURL(){return coverField.getText(); }

    public String[] getGenres(){
        String genres[] = new String[genreList.getSelectedValuesList().size()];
        int i = 0;
        for(Object o: genreList.getSelectedValuesList()) {
            genres[i] = (String) o;
            i++;
        }
        return genres;
    }
    public String[] getArtists(){
        String artists[] = new String[artistList.getSelectedValuesList().size()];
        int i = 0;
        for(Object o: artistList.getSelectedValuesList()){
            artists[i] = (String) o;
            i++;
        }
        return artists;
    }

    public String getDescription(){return descriptionField.getText(); }

    public String[] getSongsStrings(){
        String[] strings= new String[songListModel.size()];
        for(int i=0; i<songListModel.size(); i++){
            strings[i] = (String) songListModel.getElementAt(i);
        }
        return strings;
    }


    public void addSong(String song) {
        songListModel.addElement(song);

    }

    public void addSubmitListener(ActionListener listener) {
        submitButton.addActionListener(listener);

    }
    public void addSongListener(ActionListener listener) {
        addSongButton.addActionListener(listener);

    }
}

