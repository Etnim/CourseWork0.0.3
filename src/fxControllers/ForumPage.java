package fxControllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeView;
import model.Comment;
import model.Forum;

public class ForumPage {
    public TreeView<Comment> commentTree;
    public ListView<Forum> forumList;
    public TextArea commentText;
    public Button replyBut;
    public Button commentBut;
    public Button returnMainBut;

    public void returnMain(ActionEvent actionEvent) {
    }

    public void replyComment(ActionEvent actionEvent) {
    }

    public void addComment(ActionEvent actionEvent) {
    }
}
