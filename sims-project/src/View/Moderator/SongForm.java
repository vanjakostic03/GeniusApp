package View.Moderator;

import Enums.TypeOfArtist;
import Models.Artist;
import Models.Bend;
import Models.Data.ArtistService;
import Models.SingleArtist;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SongForm extends JFrame {


    private JTextField titleField ;
    private JTextField coverField;
    private JTextArea lyricsField;
    private JTextArea descriptionField;
    private JComboBox<String> composerBox;
    private JComboBox<String> lyricistBox;
    private String[] genresStrings = {"zanr1","zanr2","zanr3","zanr4","zanr5"};
    private JList<String> genreList = new JList<String>(genresStrings);
    private String[] artistsStrings;
    private JList<String> artistList= new JList<String>();
    //private JList<String> artistList= new JList<String>(artistsStrings);

    private JButton submitButton = new JButton("Submit");


    private ArrayList<Artist> artists = new ArrayList<>();
    private AlbumForm albumFrame; //ako se poziva iz album forme




    public SongForm(AlbumForm albumFrame, ArrayList<Artist> artists) {
        this.albumFrame = albumFrame;
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

        setTitle("Song Entry Form");
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


        // Composer
        c.gridx = 0;
        c.gridy = 4;
        JLabel composerLabel = new JLabel("Composer: ");
        composerLabel.setForeground(Color.WHITE);
        composerLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        formPanel.add(composerLabel, c);

        composerBox = new JComboBox<>(artistsStrings);
        c.gridx = 1;
        formPanel.add(composerBox, c);


        // Lyricist
        c.gridx = 0;
        c.gridy = 5;
        JLabel lyricistLabel = new JLabel("Lyricist: ");
        lyricistLabel.setForeground(Color.WHITE);
        lyricistLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        formPanel.add(lyricistLabel, c);

        lyricistBox = new JComboBox<>(artistsStrings);
        c.gridx = 1;
        formPanel.add(lyricistBox, c);


        // Lyrics
        c.gridx = 0;
        c.gridy = 6;

        JLabel lyricsLabel = new JLabel("Lyrics: ");
        lyricsLabel.setForeground(Color.WHITE);
        lyricsLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        formPanel.add(lyricsLabel, c);

        lyricsField = new JTextArea(5, 20);
        JScrollPane lyricsScrollPane = new JScrollPane(lyricsField);
        c.gridx = 1;
        c.fill = GridBagConstraints.BOTH;
        formPanel.add(lyricsScrollPane, c);

        // Description
        c.gridx = 0;
        c.gridy = 7;

        JLabel descriptionLabel = new JLabel("Description: ");
        descriptionLabel.setForeground(Color.WHITE);
        descriptionLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        formPanel.add(descriptionLabel, c);

        descriptionField = new JTextArea(5, 20);
        JScrollPane descriptionScrollPane = new JScrollPane(descriptionField);
        c.gridx = 1;
        c.fill = GridBagConstraints.BOTH;
        formPanel.add(descriptionScrollPane, c);

        // Submit Button
        c.gridx = 1;
        c.gridy = 8;
        c.fill = GridBagConstraints.NONE;
        formPanel.add(submitButton, c);

        add(formPanel, BorderLayout.CENTER);
    }

    public String getTitle(){return titleField.getText(); }
    public String getCoverURL(){return coverField.getText(); }
    public String getComposer(){return composerBox.getSelectedItem().toString(); }
    public String getLyricist(){return lyricistBox.getSelectedItem().toString(); }
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
    public String getLyrics(){return  lyricsField.getText(); }
    public String getDescription(){return descriptionField.getText(); }

    public void addSubmitListener(ActionListener listener) {
        submitButton.addActionListener(listener);

    }

//    submitButton.addActionListener(new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            String title = titleField.getText();
//            String cover = coverField.getText();
//            SingleArtist composer = (SingleArtist) composerBox.getSelectedItem();
//            SingleArtist lyricist = (SingleArtist) lyricistBox.getSelectedItem();
//            String lyrics = lyricsField.getText();
//            String description = descriptionField.getText();
//
//            String genres[] = new String[genreList.getSelectedValuesList().size()];
//            int i = 0;
//            for(Object o: genreList.getSelectedValuesList()){
//                genres[i] = (String) o;
//                i++;
//            }
//
//            String artists[] = new String[artistList.getSelectedValuesList().size()];
//            i = 0;
//            for(Object o: artistList.getSelectedValuesList()){
//                artists[i] = (String) o;
//                i++;
//            }
//
//            // Process the input data as needed
//            System.out.println("Title: " + title);
//            System.out.println("Cover: " + cover);
//            System.out.println("Genres: " + genres);
//            System.out.println("Artists: " + artists);
//            System.out.println("Composer: " + composer);
//            System.out.println("Lyricist: " + lyricist);
//            System.out.println("Lyrics: " + lyrics);
//            System.out.println("Description: " + description);
//
//            if (albumFrame != null){
//                albumFrame.addSong(title);
//
//            }
//            setVisible(false);
//            dispose();
//        }
//    });


}

