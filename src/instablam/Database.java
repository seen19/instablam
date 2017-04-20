package instablam; /**
 * Created by perts on 4/13/2017.
 */
import java.sql.*;
public class Database
{
    public static void startAndLoad()
    {
        Connection conn = null;
        Statement stmt = null;
        ResultSet result = null;

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306","root","toor");
            conn.setCatalog("instablam");
            stmt = conn.createStatement();
            String databaseQuery = "SELECT * FROM instablam.user_accounts";
            result = stmt.executeQuery(databaseQuery);
            while (result.next())
            {
                String currentUsername = result.getString("username");
                String currentPassword = result.getString("password");
                String currentProfile = result.getString("profile");
                User currentUser = new User(currentUsername , currentPassword);
                if (currentProfile != null)
                {
                    currentUser.setProfile(currentProfile);
                }
                Instablam.userAccounts.add(currentUser);
            }
            System.out.println("Upload Complete");
        }
        catch (SQLException e)
        {
            System.out.println("SQL Error");
        }
        catch (ClassNotFoundException e) {}

        finally
        {
            try
            {
                stmt.close();
            }
            catch (SQLException e) {}

        }
    }

    public static void saveAndShutdown()
    {
        Connection conn = null;
        Statement stmt = null;
        ResultSet result = null;

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306","root","toor");
            conn.setCatalog("instablam");
            stmt = conn.createStatement();
            String deleteUserTable = "DROP TABLE IF EXISTS user_accounts";
            stmt.executeUpdate(deleteUserTable);
            System.out.println("Table deleted");
            String createTable = "CREATE TABLE instablam.user_accounts" +
                    "(username VARCHAR(255) not NULL, " +
                    "password VARCHAR(255) not NULL, " +
                    "profile VARCHAR(500), " +
                    "PRIMARY KEY ( username ))";
            stmt.executeUpdate(createTable);
            System.out.println("Table Created");
            for (User user : Instablam.userAccounts)
            {
                String currentUsername = user.getUsername();
                String currentPassword = user.getPassword();
                String currentProfile = user.getProfile();
                String addRecord = "INSERT into user_accounts " +
                        "(username, password, profile) " +
                        "VALUES ('" + currentUsername + "', '" + currentPassword + "', '" + currentProfile + "')";
                stmt.executeUpdate(addRecord);
            }
            System.out.println("Users Saved!!");

            for (User user : Instablam.userAccounts)
            {
                String deletePostTable = "DROP TABLE IF EXISTS posts_from_" + user.getUsername();
                stmt.executeUpdate(deleteUserTable);
                System.out.println("Table deleted");
                String createPostTable = "CREATE TABLE instablam.posts_from_" + user.getUsername() +
                        "(file_path VARCHAR(255) not NULL, " +
                        "is_public VARCHAR(10) not NULL, " +
                        "number_likes INT not NULL, " +
                        "PRIMARY KEY ( username ))";
                stmt.executeUpdate(createTable);
                System.out.println("Table Created");
            }
        }
        catch (SQLException e)
        {
            System.out.println("SQL Error");
        } catch (ClassNotFoundException e) {}

        finally
        {
            try
            {
                stmt.close();
            }
            catch (SQLException e) {}

        }
    }



    public static void main(String[] args)
    {
        Database.saveAndShutdown();
        boolean alpha = true;
        String beta = String.valueOf(alpha);
    }
}
