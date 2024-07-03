package View.Moderator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlbumForm extends JFrame {

    private JFrame parentFrame;
    private DefaultListModel<String> songListModel;
    private JList<String> songList;


    public AlbumForm() {
        //parentFrame = parentFrame;
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

        JTextField titleField ;
        JTextField coverField;
        String[] genresStrings = {"zanr1","zanr2"};
        JList<String> genreList = new JList<String>(genresStrings);
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

        // Add Song Button
        AlbumForm albumForm = this;
        JButton addSongButton = new JButton("Add Song");
        addSongButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SongForm songForm = new SongForm(albumForm);
                songForm.setVisible(true);
            }
        });
        c.gridx = 2;
        c.gridy = 4;
        formPanel.add(addSongButton, c);


        // Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String cover = coverField.getText();


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

    public void addSong(String song) {
        songListModel.addElement(song);

    }
}

