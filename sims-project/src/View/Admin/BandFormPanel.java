package View.Admin;

import Models.Bend;
import Models.Data.ArtistService;
import Models.RecordLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class BandFormPanel extends JPanel {

    private JTextField idField;
    private JTextField nameField;
    private JTextField descriptionField;
    private JTextField dateOfEstablishmentField;
    private DefaultListModel<String> listModel;
    private ArtistService artistService;
    private JList<String> artistList;

    public BandFormPanel() {
        this.artistService = new ArtistService();
        setLayout(new GridBagLayout());
        initFormPanel();
        loadBandsFromXML();
    }

    private void initFormPanel() {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);

        JLabel idLabel = new JLabel("Band ID:");
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

        JLabel descriptionLabel = new JLabel("Description:");
        c.gridx = 0;
        c.gridy = 2;
        add(descriptionLabel, c);

        descriptionField = new JTextField(20);
        c.gridx = 1;
        c.gridy = 2;
        add(descriptionField, c);

        JLabel dateOfEstablishmentLabel = new JLabel("Date of Establishment (YYYY-MM-DD):");
        c.gridx = 0;
        c.gridy = 3;
        add(dateOfEstablishmentLabel, c);

        dateOfEstablishmentField = new JTextField(20);
        c.gridx = 1;
        c.gridy = 3;
        add(dateOfEstablishmentField, c);

        JButton addButton = new JButton("Add Band");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBand();
            }
        });
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        add(addButton, c);

        JButton updateButton = new JButton("Update Band");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBand();
            }
        });
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 2;
        add(updateButton, c);

        JButton deleteButton = new JButton("Delete Band");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteBand();
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

    private void addBand() {
        String id = idField.getText();
        String name = nameField.getText();
        String description = descriptionField.getText();
        String dateOfEstablishment = dateOfEstablishmentField.getText();

        if (!id.isEmpty() && !name.isEmpty() && !description.isEmpty() && !dateOfEstablishment.isEmpty()) {
            LocalDate date = LocalDate.parse(dateOfEstablishment);
            Bend band = new Bend(id, new RecordLabel(), name, description, date);
            artistService.addArtist(band);
            listModel.addElement(band.getId() + ", " + band.getName());
            idField.setText("");
            nameField.setText("");
            descriptionField.setText("");
            dateOfEstablishmentField.setText("");
        }
    }

    private void updateBand() {
        String id = idField.getText();
        String name = nameField.getText();
        String description = descriptionField.getText();
        String dateOfEstablishment = dateOfEstablishmentField.getText();

        if (!id.isEmpty() && !name.isEmpty() && !description.isEmpty() && !dateOfEstablishment.isEmpty()) {
            LocalDate date = LocalDate.parse(dateOfEstablishment);
            Bend band = new Bend(id, new RecordLabel(), name, description, date);
            artistService.updateArtist(band);
            loadBandsFromXML();
        }
    }

    private void deleteBand() {
        String selectedValue = artistList.getSelectedValue();
        if (selectedValue != null) {
            String id = selectedValue.split(",")[0];
            artistService.deleteArtist(id);
            loadBandsFromXML();
        }
    }

    private void loadBandsFromXML() {
        listModel.clear();
        for (Bend band : artistService.getBands()) {
            listModel.addElement(band.getId() + ", " + band.getName());
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Band Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.add(new BandFormPanel());
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
