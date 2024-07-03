package View.Moderator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Properties;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class HomePanel extends JPanel {

    ToolBarPanelModerator parentPanel ;
    public HomePanel(ToolBarPanelModerator parenPanel) {
        this.parentPanel = parenPanel;
        setLayout(new GridBagLayout());
        initHomePanel();
    }

    public void initHomePanel() {
        this.setBackground(new Color(32, 38, 61));

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(25, 5, 15, 10);

        // Naslov "Home"
        JLabel home = new JLabel("Home");
        home.setFont(new Font("Dialog", Font.BOLD, 24));
        home.setForeground(Color.WHITE);
        home.setHorizontalAlignment(SwingConstants.LEFT);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        c.weightx = 1.0;
        c.weighty = 0.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(home, c);

        // Krug panel
        JPanel circlePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int diameter = Math.min(getWidth(), getHeight());
                g.setColor(Color.white);
                g.fillOval((getWidth() - diameter) / 2, (getHeight() - diameter) / 2, diameter, diameter);

            }
        };
        circlePanel.setPreferredSize(new Dimension(55, 55));
        circlePanel.setBackground(new Color(32, 38, 61));
        circlePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        c.gridx = 3;
        c.gridy = 0;
        c.gridwidth = 1;
        c.weightx = 0.0;
        add(circlePanel, c);



        JPanel reportPanel = createReportPanel();
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        add(reportPanel, c);

        JPanel emptyPanel = new JPanel();
        emptyPanel.setBackground(new Color(32, 38, 61));
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        c.weightx = 0.0;
        c.weighty = 0.0;
        c.fill = GridBagConstraints.VERTICAL;
        add(emptyPanel, c);

    }

    private JPanel createReviewPanel() {
        JPanel panel = new JPanel(){
            @Override protected void paintComponent(Graphics g) {
                if (!isOpaque() && getBorder() instanceof RoundBorder) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setPaint(getBackground());
                    g2.fill(((RoundBorder) getBorder()).getBorderShape(
                            0, 0, getWidth() - 1, getHeight() - 1));
                    g2.dispose();
                }
                super.paintComponent(g);
            }
            @Override public void updateUI() {
                super.updateUI();
                setOpaque(false);
                setBorder(new RoundBorder());
            }
        };

        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(39, 47, 78));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(1, 1, 1, 1);

        JLabel title = new JLabel("Create review");
        title.setBackground(new Color(39, 47, 78));
        title.setPreferredSize(new Dimension(80, 160));
        title.setFont(new Font("Dialog", Font.BOLD, 20));
        title.setForeground(Color.white);
        title.setHorizontalAlignment(SwingConstants.LEFT);
        title.setVerticalAlignment(SwingConstants.TOP);

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.weightx = 1.0;
        c.weighty = 0.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        panel.add(title, c);


        JTextField reviewText = createReviewTextField();
        reviewText.setHorizontalAlignment(SwingConstants.LEFT);
        c.gridx = 0;
        c.gridy = 1;
        c.gridheight = 2;
        c.gridwidth = 3;
        c.weightx = 1.0;
        c.weighty = 0.0;
        c.insets = new Insets(5,25,5,25);
        c.fill = GridBagConstraints.BOTH;
        panel.add(reviewText, c);



        JLabel grader = new JLabel("Enter grade: ");
        grader.setBackground(new Color(144, 148, 196));
        grader.setForeground(Color.white);
        grader.setFont(new Font("Dialog", Font.BOLD, 20));
        grader.setHorizontalAlignment(SwingConstants.LEFT);
        c.gridx = 0;
        c.gridy = 3;
        c.gridheight = 1;
        c.gridwidth = 1;
        panel.add(grader, c);

        ButtonGroup group = new ButtonGroup();
        JPanel graderPanel = new JPanel();
        graderPanel.setLayout(new GridBagLayout());
        graderPanel.setBackground(new Color(39, 47, 78));
        graderPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        c.gridy=0;
        c.gridx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;

        for (int i = 1; i <= 5; i++) {
            JRadioButton radioButton = new JRadioButton(String.valueOf(i));
            radioButton.setFont(new Font("Dialog", Font.BOLD, 20));
            radioButton.setForeground(Color.WHITE);
            radioButton.setBackground(new Color(39, 47, 78));
            group.add(radioButton);
            graderPanel.add(radioButton);
            c.gridx+=1;
        }

        c.gridy=4;
        c.gridx = 0;
        c.fill = GridBagConstraints.BOTH;
        panel.add(graderPanel, c);

        JLabel submit = new JLabel("Submit"){
            @Override protected void paintComponent(Graphics g) {
                if (!isOpaque() && getBorder() instanceof RoundBorder) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setPaint(getBackground());
                    g2.fill(((RoundBorder) getBorder()).getBorderShape(
                            0, 0, getWidth() - 1, getHeight() - 1));
                    g2.dispose();
                }
                super.paintComponent(g);
            }
            @Override public void updateUI() {
                super.updateUI();
                setOpaque(false);
                setBorder(new RoundBorder());
            }
        };
        submit.setBackground(new Color(39, 47, 78)) ;
        submit.setForeground(Color.white);
        submit.setHorizontalAlignment(SwingConstants.LEFT);
        c.gridy = 5;
        c.gridx = 2;
        c.gridwidth = 1;
        c.gridheight =1;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 0.0;


        panel.add(submit,c);


        submit.addMouseListener(new MouseAdapter() {
        @Override
            public void mouseClicked(MouseEvent e) {

            }
        });

        return panel;
    }

    private JTextField createReviewTextField() {
        JTextField textField = new JTextField("Enter the review..."){
            @Override protected void paintComponent(Graphics g) {
                if (!isOpaque() && getBorder() instanceof RoundBorder) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setPaint(getBackground());
                    g2.fill(((RoundBorder) getBorder()).getBorderShape(
                            0, 0, getWidth() - 1, getHeight() - 1));
                    g2.dispose();
                }
                super.paintComponent(g);
            }
            @Override public void updateUI() {
                super.updateUI();
                setOpaque(false);
                setBorder(new RoundBorder());
            }
        };

        textField.setFont(new Font("Dialog", Font.PLAIN, 17));
        textField.setForeground(Color.LIGHT_GRAY);
        textField.setBackground(new Color(144, 148, 196));
        textField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        textField.setBorder(new RoundBorder());


        return textField;
    }

    private JPanel createReportPanel() {
        JPanel panel = new JPanel(){
            @Override protected void paintComponent(Graphics g) {
                if (!isOpaque() && getBorder() instanceof RoundBorder) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setPaint(getBackground());
                    g2.fill(((RoundBorder) getBorder()).getBorderShape(
                            0, 0, getWidth() - 1, getHeight() - 1));
                    g2.dispose();
                }
                super.paintComponent(g);
            }
            @Override public void updateUI() {
                super.updateUI();
                setOpaque(false);
                setBorder(new RoundBorder());
            }
        };

        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(39, 47, 78));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(1, 1, 1, 1);

        JLabel title = new JLabel("Generate report");
        title.setBackground(new Color(39, 47, 78));
        title.setPreferredSize(new Dimension(80, 160));
        title.setFont(new Font("Dialog", Font.BOLD, 20));
        title.setForeground(Color.white);
        title.setHorizontalAlignment(SwingConstants.LEFT);

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.weightx = 1.0;
        c.weighty = 0.0;
        c.fill = GridBagConstraints.BOTH;

        panel.add(title, c);

        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl startingDate = new JDatePickerImpl(datePanel, new DateComponentFormatter());

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.weightx = 1.0;
        c.weighty = 0.0;

        c.fill = GridBagConstraints.BOTH;
        panel.add(startingDate);

        UtilDateModel model2 = new UtilDateModel();
        Properties p2 = new Properties();
        p2.put("text.today", "Today");
        p2.put("text.month", "Month");
        p2.put("text.year", "Year");
        JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p2);
        JDatePickerImpl endingDate = new JDatePickerImpl(datePanel2, new DateComponentFormatter());


        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.weightx = 1.0;
        c.weighty = 0.0;
        c.fill = GridBagConstraints.BOTH;
        panel.add(endingDate);

        JLabel submit = new JLabel("Submit"){
            @Override protected void paintComponent(Graphics g) {
                if (!isOpaque() && getBorder() instanceof RoundBorder) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setPaint(getBackground());
                    g2.fill(((RoundBorder) getBorder()).getBorderShape(
                            0, 0, getWidth() - 1, getHeight() - 1));
                    g2.dispose();
                }
                super.paintComponent(g);
            }
            @Override public void updateUI() {
                super.updateUI();
                setOpaque(false);
                setBorder(new RoundBorder());
            }
        };
        submit.setBackground(new Color(39, 47, 78)) ;
        submit.setForeground(Color.white);
        submit.setHorizontalAlignment(SwingConstants.LEFT);
        c.gridy = 5;
        c.gridx = 2;
        c.gridwidth = 1;
        c.gridheight =1;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 0.0;

        panel.add(submit,c);


        submit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        return panel;
    }
}
