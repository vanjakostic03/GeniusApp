package View.Admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AdvertismentListPanel extends JPanel {

    private JTable advertismentTable;
    private DefaultTableModel tableModel;

    public AdvertismentListPanel() {
        setLayout(new BorderLayout());

        initAdvertismentList();
    }

    private void initAdvertismentList() {
        String[] columnNames = {"Title", "Profit"};
        tableModel = new DefaultTableModel(columnNames, 0);
        advertismentTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(advertismentTable);
        add(scrollPane, BorderLayout.CENTER);

        // Add test advertisments
        addTestAdvertisments();
    }

    private void addTestAdvertisments() {
        Object[] ad1 = {"Ad 1", 500.0};
        Object[] ad2 = {"Ad 2", 300.0};

        tableModel.addRow(ad1);
        tableModel.addRow(ad2);
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
