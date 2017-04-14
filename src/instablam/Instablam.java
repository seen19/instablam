/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instablam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author james
 */
public class Instablam {
    
    static ArrayList<User> userAccounts;
    static User loggedInUser;
    
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        userAccounts = new ArrayList<User>();
    }
    
}
