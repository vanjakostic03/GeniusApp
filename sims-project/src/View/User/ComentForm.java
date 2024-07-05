package View.User;

import Models.Comment;
import Models.Data.CommentService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class ComentForm extends JFrame {

    private JTextArea reviewTextArea;
    private JComboBox<Integer> ratingComboBox;
    private CommentService commentService;

    public ComentForm(CommentService commentService) {
        this.commentService = commentService;

        setTitle("Comment Form");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        initGUI();
    }

    private void initGUI() {
        JPanel formPanel = new JPanel();
        formPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        formPanel.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.HORIZONTAL;

        formPanel.setBackground(new Color(39, 47, 78));

        // Review Label
        c.gridx = 0;
        c.gridy = 0;
        JLabel reviewLabel = new JLabel("Comment:");
        reviewLabel.setForeground(Color.WHITE);
        reviewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        formPanel.add(reviewLabel, c);

        // Review Text Area
        reviewTextArea = new JTextArea(5, 20);
        JScrollPane reviewScrollPane = new JScrollPane(reviewTextArea);
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.BOTH;
        formPanel.add(reviewScrollPane, c);

        // Rating Label
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        JLabel ratingLabel = new JLabel("Rating:");
        ratingLabel.setForeground(Color.WHITE);
        ratingLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        formPanel.add(ratingLabel, c);

        // Rating Combo Box
        Integer[] ratings = {1, 2, 3, 4, 5};
        ratingComboBox = new JComboBox<>(ratings);
        c.gridx = 1;
        c.gridy = 1;
        formPanel.add(ratingComboBox, c);

        // Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String reviewText = reviewTextArea.getText();
                Integer rating = (Integer) ratingComboBox.getSelectedItem();

                // Create a new comment
                String commentId = commentService.getFreeID();
                Comment comment = new Comment(commentId, reviewText, rating, false, new Date(), null, null);

                // Add comment to CommentService
                commentService.addComment(comment);

                // Process the input data as needed
                System.out.println("Review: " + reviewText);
                System.out.println("Rating: " + rating);

                setVisible(false);
                dispose();
            }
        });
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.NONE;
        formPanel.add(submitButton, c);

        add(formPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CommentService commentService = new CommentService(); // Create CommentService instance
                new ComentForm(commentService).setVisible(true);
            }
        });
    }
}
