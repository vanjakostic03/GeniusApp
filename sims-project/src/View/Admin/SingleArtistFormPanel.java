package View.Admin;

import Models.Data.ArtistService;
import Models.RecordLabel;
import Models.SingleArtist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SingleArtistFormPanel extends JPanel {

    private JTextField idField;
    private JTextField nameField;
    private JTextField biographyField;
    private JTextField pictureField;
    private DefaultListModel<String> listModel;
    private ArtistService artistService;
    private JList<String> artistList;

    public SingleArtistFormPanel() {
        this.artistService = new ArtistService();
        setLayout(new GridBagLayout());
        initFormPanel();
        loadSingleArtistsFromXML();
    }

    private void initFormPanel() {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);

        JLabel idLabel = new JLabel("Artist ID:");
        c.gridx = 0;
        c.gridy = 0;
        add(idLabel, c);

        idField = new JTextField(20);
        c.gridx = 1;
        c.gridy = 0;
        add(idField, c);

        JLabel nameLabel = new JLabel("Name:");
        c.gridx = 0;
        c.gridy = 1;
        add(nameLabel, c);

        nameField = new JTextField(20);
        c.gridx = 1;
        c.gridy = 1;
        add(nameField, c);

        JLabel biographyLabel = new JLabel("Biography:");
        c.gridx = 0;
        c.gridy = 2;
        add(biographyLabel, c);

        biographyField = new JTextField(20);
        c.gridx = 1;
        c.gridy = 2;
        add(biographyField, c);

        JLabel pictureLabel = new JLabel("Picture:");
        c.gridx = 0;
        c.gridy = 3;
        add(pictureLabel, c);

        pictureField = new JTextField(20);
        c.gridx = 1;
        c.gridy = 3;
        add(pictureField, c);

        JButton addButton = new JButton("Add Single Artist");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSingleArtist();
            }
        });
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        add(addButton, c);

        JButton updateButton = new JButton("Update Single Artist");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateSingleArtist();
            }
        });
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 2;
        add(updateButton, c);

        JButton deleteButton = new JButton("Delete Single Artist");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSingleArtist();
            }
        });
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 2;
        add(deleteButton, c);

        listModel = new DefaultListModel<>();
        artistList = new JList<>(listModel);
        artistList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane listScrollPane = new JScrollPane(artistList);
        c.gridx = 0;
        c.gridy = 7;
        c.gridwidth = 2;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        add(listScrollPane, c);
    }

    private void addSingleArtist() {
        String id = idField.getText();
        String name = nameField.getText();
        String biography = biographyField.getText();
        String picture = pictureField.getText();

        if (!id.isEmpty() && !name.isEmpty() && !biography.isEmpty() && !picture.isEmpty()) {
            SingleArtist singleArtist = new SingleArtist(id, new RecordLabel(), biography, picture, name);
            artistService.addArtist(singleArtist);
            listModel.addElement(singleArtist.getId() + ", " + singleArtist.getName());
            idField.setText("");
            nameField.setText("");
            biographyField.setText("");
            pictureField.setText("");
        }
    }

    private void updateSingleArtist() {
        String id = idField.getText();
        String name = nameField.getText();
        String biography = biographyField.getText();
        String picture = pictureField.getText();

        if (!id.isEmpty() && !name.isEmpty() && !biography.isEmpty() && !picture.isEmpty()) {
            SingleArtist singleArtist = new SingleArtist(id, new RecordLabel(), biography, picture, name);
            artistService.updateArtist(singleArtist);
            loadSingleArtistsFromXML();
        }
    }

    private void deleteSingleArtist() {
        String selectedValue = artistList.getSelectedValue();
        if (selectedValue != null) {
            String id = selectedValue.split(",")[0];
            artistService.deleteArtist(id);
            loadSingleArtistsFromXML();
        }
    }

    private void loadSingleArtistsFromXML() {
        listModel.clear();
        for (SingleArtist singleArtist : artistService.getSingleArtists()) {
            listModel.addElement(singleArtist.getId() + ", " + singleArtist.getName());
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Single Artist Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.add(new SingleArtistFormPanel());
        frame.setVisible(true);
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
