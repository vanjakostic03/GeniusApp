package Models.Data;

import Models.Comment;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CommentService {

    private ArrayList<Comment> comments;

    public CommentService() {
        this.comments = new ArrayList<>();
        loadCommentsFromXML();
    }

    public void addComment(Comment comment) {
        comments.add(comment);
        saveCommentsToXML();
    }

    public void approveComment(String commentId) {
        for (Comment comment : comments) {
            if (comment.getId().equals(commentId)) {
                comment.approve();
                saveCommentsToXML(); // Save after modification
                return;
            }
        }
    }

    public Comment findCommentById(String commentId) {
        for (Comment comment : comments) {
            if (comment.getId().equals(commentId)) {
                return comment;
            }
        }
        return null;
    }

    public String getFreeID() {
        int maxId = 0;
        for (Comment comment : comments) {
            try {
                int id = Integer.parseInt(comment.getId().substring(1));
                if (id > maxId) {
                    maxId = id;
                }
            } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                // Ignore invalid IDs or IDs without proper format
            }
        }
        return "C" + String.format("%03d", maxId + 1);
    }

    public void saveCommentsToXML() {
        XStream xstream = new XStream();
        xstream.alias("comment", Comment.class);
        xstream.addPermission(AnyTypePermission.ANY); // Adding permission for serialization

        try (FileWriter writer = new FileWriter("./Data/comments.xml")) {
            xstream.toXML(comments, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadCommentsFromXML() {
        XStream xstream = new XStream();
        xstream.alias("comment", Comment.class);
        xstream.addPermission(AnyTypePermission.ANY); // Adding permission for deserialization

        try (FileReader reader = new FileReader("./Data/comments.xml")) {
            comments = (ArrayList<Comment>) xstream.fromXML(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Additional methods as needed

}
