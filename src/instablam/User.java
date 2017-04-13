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
     * @param followers the followers to set
     */
    public void setFollowers(ArrayList<User> followers) {
        this.followers = followers;
    }

    /**
     * @return the following
     */
    public ArrayList<User> getFollowing() {
        return following;
    }

    /**
     * @param following the following to set
     */
    public void setFollowing(ArrayList<User> following) {
        this.following = following;
    }
    
    public String toString() {
        return username + " " + password;
    }
}
