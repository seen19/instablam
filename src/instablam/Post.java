/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instablam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author cdonahue
 */
public class Post {
    private String imageFile;
    private User postingAccount;
    private boolean publicPost;
    private int likes;
    private String caption;
    private ArrayList<String> comments;
    private LocalDateTime postingTime;
    
    public Post(/*User posting,*/ String file, boolean publicPost) {
        //this.postingAccount = posting;
        this.imageFile = file;
        likes = 0;
        comments = new ArrayList<>();
        this.postingTime = LocalDateTime.now();//.format(DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm:ss"));
        this.publicPost = publicPost;
    }
    /**
     * @return the imageFile
     */
    public String getImageFile() {
        return imageFile;
    }

    /**
     * @return the postingAcount
     */
    public User getPostingAccount() {
        return postingAccount;
    }

    /**
     * @return the likes
     */
    public int getLikes() {
        return likes;
    }
    
    public void addComment(String comment) {
        comments.add(comment);
    }

    /**
     * @return the comments
     */
    public ArrayList<String> getComments() {
        return comments;
    }
    
    /**
     * @return the caption
     */
    public String getCaption() {
        return caption;
    }

    /**
     * @param caption the caption to set
     */
    public void setCaption(String caption) {
        this.caption = caption;
    }
    
    /**
     * Add a like to the post
     */
    public void like() {
        likes++;
    }

    /**
     * @return the publicPost
     */
    public boolean isPublicPost() {
        return publicPost;
    }

    /**
     * @param publicPost the publicPost to set
     */
    public void setPublicPost(boolean publicPost) {
        this.publicPost = publicPost;
    }
}
