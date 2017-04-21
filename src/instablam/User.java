/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instablam;

import java.util.ArrayList;

/**
 *
 * @author james
 */
public class User {
    
    private String username;
    private String password;
    private String profile;
    private ArrayList<User> followers;
    private ArrayList<User> following;
    public ArrayList<Post> userPosts;
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        userPosts = new ArrayList<Post>();
    }
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * @return the profile
     */
    public String getProfile() {
        return profile;
    }

    /**
     * @param profile the profile to set
     */
    public void setProfile(String profile) {
        this.profile = profile;
    }

    /**
     * @return the followers
     */
    public ArrayList<User> getFollowers() {
        return followers;
    }

    /**
     * @return the following
     */
    public ArrayList<User> getFollowing() {
        return following;
    }
    
    /*public ArrayList<Post> getPosts() {
    }*/
    
    public void addFollower(User follower) {
        followers.add(follower);
    }
    
    public void removeFollower(User follower) {
        followers.remove(follower);
    }
    
    public void addFollowing(User toFollow) {
        following.add(toFollow);
    }
    
    public void removeFollowing(User toFollow) {
        following.remove(toFollow);
    }
    
    public boolean equals(User other) {
        if (username.equals(other.getUsername())) {
            return true;
        }
        return false;
    }
    
    public String toString() {
        return username + " " + password;
    }

    public void addPostToUser(Post newPost)
    {
        userPosts.add(0 , newPost);
    }
    public ArrayList<Post> getPosts() {return userPosts;}
}
