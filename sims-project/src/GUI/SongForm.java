package GUI;

import Models.SingleArtist;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SongForm extends JFrame {

    private AlbumForm albumFrame; //ako se poziva iz album forme


    public SongForm(AlbumForm albumFrame) {
        this.albumFrame = albumFrame;
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

         JTextField titleField ;
         JTextField coverField;
         JTextArea lyricsField;
         JTextArea descriptionField;
         JComboBox<SingleArtist> composerBox;
         JComboBox<SingleArtist> lyricistBox;
         //JList<Genre> genreList;
        String[] genresStrings = {"zanr1","zanr2"};
         JList<String> genreList = new JList<String>(genresStrings);
        //JList<Artist> artistList;
        String[] artistsStrings = {"artist1","artist2"};
         JList<String> artistList= new JList<String>(artistsStrings);
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

        composerBox = new JComboBox<>();
        c.gridx = 1;
        formPanel.add(composerBox, c);


        // Lyricist
        c.gridx = 0;
        c.gridy = 5;
        JLabel lyricistLabel = new JLabel("Lyricist: ");
        lyricistLabel.setForeground(Color.WHITE);
        lyricistLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        formPanel.add(lyricistLabel, c);

        lyricistBox = new JComboBox<>();
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
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String cover = coverField.getText();
                SingleArtist composer = (SingleArtist) composerBox.getSelectedItem();
                SingleArtist lyricist = (SingleArtist) lyricistBox.getSelectedItem();
                String lyrics = lyricsField.getText();
                String description = descriptionField.getText();

                String genres[] = new String[genreList.getSelectedValuesList().size()];
                int i = 0;
                for(Object o: genreList.getSelectedValuesList()){
                    genres[i] = (String) o;
                    i++;
                }

                String artists[] = new String[artistList.getSelectedValuesList().size()];
                i = 0;
                for(Object o: artistList.getSelectedValuesList()){
                    artists[i] = (String) o;
                    i++;
                }

                // Process the input data as needed
                System.out.println("Title: " + title);
                System.out.println("Cover: " + cover);
                System.out.println("Genres: " + genres);
                System.out.println("Artists: " + artists);
                System.out.println("Composer: " + composer);
                System.out.println("Lyricist: " + lyricist);
                System.out.println("Lyrics: " + lyrics);
                System.out.println("Description: " + description);

                if (albumFrame != null){
                    albumFrame.addSong(title);

                }
                setVisible(false);
                dispose();
            }
        });
        c.gridx = 1;
        c.gridy = 8;
        c.fill = GridBagConstraints.NONE;
        formPanel.add(submitButton, c);

        add(formPanel, BorderLayout.CENTER);


    }
}

