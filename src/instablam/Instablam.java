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
public class Instablam {
    
    public static ArrayList<User> userAccounts;
    static User loggedInUser;
    
    public static ArrayList<Post> posts;
    
    static void register(String username, String password)
            throws UsernameAlreadyInUseException {
        for (User user : userAccounts) {
            if (user.getUsername().equals(username)) {
                throw new UsernameAlreadyInUseException();
            }
        }
        userAccounts.add(new User(username, password));
    }
    
    static void login(String username, String password)
            throws UsernameNotFoundException, IncorrectPasswordException {
        for (User user : userAccounts) {
            if (user.getUsername().equals(username)) {
                if (user.getPassword().equals(password)) {
                    loggedInUser = user;
                    return;
                } else {
                    throw new IncorrectPasswordException();
                }
            }
        }
        throw new UsernameNotFoundException();
    }
    
     public static void addPost(Post toAdd, User userPosting)
    {
        posts.add(0, toAdd);
    }
    
    static void commentOnPost(Post post, String comment) {
        post.addComment(loggedInUser.getUsername() + ": " + comment);
    }
    
    static ArrayList<Post> getTimeline() {
        ArrayList<Post> timeline = new ArrayList<>();
        for (Post post : posts) {
            if (post.getPostingAccount().getFollowers().contains(loggedInUser)) {
                timeline.add(post);
            }
        }
        return timeline;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        userAccounts = new ArrayList<User>();
        Database.startAndLoad();
        //User alpha = new User("test","root");
        //User beta = new User("karly","onlytest");
        //beta.setProfile("blah blab");
        Post charlie = new Post("C:/test/pics/apic.jpeg" , false);
        Post delta = new Post("D:/blah/blah/stuff.png" , false);
        userAccounts.get(0).addPostToUser(charlie);
        userAccounts.get(1).addPostToUser(delta);
        //ArrayList<Post> alphaPosts = alpha.getPosts();
        //ArrayList<Post> betaPost = beta.getPosts();
        Database.saveAndShutdown();
    }
    
}
