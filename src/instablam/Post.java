/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instablam;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author cdonahue
 */
public class Post {
    private String imageFile;
    private User postingAccount;
    private int likes;
    private ArrayList<String> comments;
    private LocalDateTime postingTime;
    
    public Post(User posting, String file) {
        this.postingAccount = posting;
        this.imageFile = file;
        likes = 0;
        comments = new ArrayList<>();
        this.postingTime = LocalDateTime.now();
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

    /**
     * @return the comments
     */
    public ArrayList<String> getComments() {
        return comments;
    }
    
    /**
     * Add a like to the post
     */
    public void like() {
        likes++;
    }
}
