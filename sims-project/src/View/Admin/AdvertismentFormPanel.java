package View.Admin;

import Models.Advertisment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AdvertismentFormPanel extends JPanel {

    private JTextField idField;
    private JTextField titleField;
    private JTextField imageField;
    private JTextField descriptionField;
    private JTextField startDateField;
    private JTextField endDateField;
    private JTextField profitField;
    private DefaultListModel<String> listModel;

    public AdvertismentFormPanel() {
        setLayout(new GridBagLayout());
        initFormPanel();
    }

    private void initFormPanel() {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);

        JLabel idLabel = new JLabel("Advertisment ID:");
        c.gridx = 0;
        c.gridy = 0;
        add(idLabel, c);

        idField = new JTextField(20);
        c.gridx = 1;
        c.gridy = 0;
        add(idField, c);

        JLabel titleLabel = new JLabel("Title:");
        c.gridx = 0;
        c.gridy = 1;
        add(titleLabel, c);

        titleField = new JTextField(20);
        c.gridx = 1;
        c.gridy = 1;
        add(titleField, c);

        JLabel imageLabel = new JLabel("Image URL:");
        c.gridx = 0;
        c.gridy = 2;
        add(imageLabel, c);

        imageField = new JTextField(20);
        c.gridx = 1;
        c.gridy = 2;
        add(imageField, c);

        JLabel descriptionLabel = new JLabel("Description:");
        c.gridx = 0;
        c.gridy = 3;
        add(descriptionLabel, c);

        descriptionField = new JTextField(20);
        c.gridx = 1;
        c.gridy = 3;
        add(descriptionField, c);

        JLabel startDateLabel = new JLabel("Start Date (yyyy-MM-dd):");
        c.gridx = 0;
        c.gridy = 4;
        add(startDateLabel, c);

        startDateField = new JTextField(20);
        c.gridx = 1;
        c.gridy = 4;
        add(startDateField, c);

        JLabel endDateLabel = new JLabel("End Date (yyyy-MM-dd):");
        c.gridx = 0;
        c.gridy = 5;
        add(endDateLabel, c);

        endDateField = new JTextField(20);
        c.gridx = 1;
        c.gridy = 5;
        add(endDateField, c);

        JLabel profitLabel = new JLabel("Profit:");
        c.gridx = 0;
        c.gridy = 6;
        add(profitLabel, c);

        profitField = new JTextField(20);
        c.gridx = 1;
        c.gridy = 6;
        add(profitField, c);

        JButton addButton = new JButton("Add Advertisment");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAdvertisment();
            }
        });
        c.gridx = 0;
        c.gridy = 7;
        c.gridwidth = 2;
        add(addButton, c);

        listModel = new DefaultListModel<>();
        JList<String> advertismentList = new JList<>(listModel);
        advertismentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane listScrollPane = new JScrollPane(advertismentList);
        c.gridx = 0;
        c.gridy = 8;
        c.gridwidth = 2;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        add(listScrollPane, c);
    }

    private void addAdvertisment() {
        String id = idField.getText();
        String title = titleField.getText();
        String image = imageField.getText();
        String description = descriptionField.getText();
        Date startDate = parseDate(startDateField.getText());
        Date endDate = parseDate(endDateField.getText());
        Double profit = parseDouble(profitField.getText());

        if (!id.isEmpty() && startDate != null && endDate != null && profit != null) {
            Advertisment advertisment = new Advertisment(id, title, image, description, startDate, endDate, profit);
            listModel.addElement(advertisment.getId() + " - " + advertisment.getTitle());
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Please fill in all fields correctly.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Date parseDate(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }

    private Double parseDouble(String doubleStr) {
        try {
            return Double.parseDouble(doubleStr);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private void clearFields() {
        idField.setText("");
        titleField.setText("");
        imageField.setText("");
        descriptionField.setText("");
        startDateField.setText("");
        endDateField.setText("");
        profitField.setText("");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Advertisment Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.add(new AdvertismentFormPanel());
        frame.setVisible(true);
    }
}