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
    
    static ArrayList<User> userAccounts;
    static User loggedInUser;
    
    static ArrayList<Post> posts;
    
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
    
    static void addPost(Post toAdd) {
        posts.add(0, toAdd);
    }
    
    static ArrayList<Post> getTimeline() {
        ArrayList<Post> timeline = new ArrayList<>();
        for (Post post : posts) {
            if (post.getPostingAccount().equals(loggedInUser)) {
                timeline.add(post);
            }
        }
        return timeline;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        userAccounts = new ArrayList<User>();
    }
    
}
