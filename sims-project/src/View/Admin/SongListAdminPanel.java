package View.Admin;

import Models.Song;
import Models.SingleArtist;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SongListAdminPanel extends JPanel {

    private JTable songTable;
    private DefaultTableModel tableModel;

    public SongListAdminPanel() {
        setLayout(new BorderLayout());

        initSongList();
    }

    private void initSongList() {
        String[] columnNames = {"Title", "Lyricist", "Composer", "Views"};
        tableModel = new DefaultTableModel(columnNames, 0);
        songTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(songTable);
        add(scrollPane, BorderLayout.CENTER);

        // Add test songs
        addTestSongs();
    }

    private void addTestSongs() {
        SingleArtist lyricist1 = new SingleArtist("1", null, "Bio", "pick", "Lyricist 1");
        SingleArtist composer1 = new SingleArtist("1", null, "Bio", "pick", "Lyricist 1");
        Song song1 = new Song(lyricist1, composer1, "Lyrics 1", "Description 1");
        song1.setViews(100);

        SingleArtist lyricist2 = new SingleArtist("1", null, "Bio", "pick", "Lyricist 1");
        SingleArtist composer2 = new SingleArtist("1", null, "Bio", "pick", "Lyricist 1");
        Song song2 = new Song(lyricist2, composer2, "Lyrics 2", "Description 2");
        song2.setViews(200);

        addSongToTable(song1);
        addSongToTable(song2);
    }

    private void addSongToTable(Song song) {
        Object[] rowData = {
                song.getTitle(),
                song.getLyricist().getName(),
                song.getComposer().getName(),
                song.getViews()
        };
        tableModel.addRow(rowData);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
    }
}
