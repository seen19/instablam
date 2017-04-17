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
    private ArrayList<User> followers;
    private ArrayList<User> following;
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
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
    
    public String toString() {
        return username + " " + password;
    }
}
