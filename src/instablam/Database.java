package instablam; /**
 * Created by perts on 4/13/2017.
 */
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

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
            String testUserExist = "SHOW TABLES IN instablam LIKE 'user_accounts'";
            result = stmt.executeQuery(testUserExist);
            if (result.first() == false)
            {
                String createTable = "CREATE TABLE instablam.user_accounts" +
                        "(username VARCHAR(255) not NULL, " +
                        "password VARCHAR(255) not NULL, " +
                        "profile VARCHAR(500), " +
                        "PRIMARY KEY ( username ))";
                stmt.executeUpdate(createTable);
                System.out.println("Table Created");
            }
            else
            {
                String databaseQuery = "SELECT * FROM instablam.user_accounts";
                result = stmt.executeQuery(databaseQuery);
                while (result.next()) {
                    String currentUsername = result.getString("username");
                    String currentPassword = result.getString("password");
                    String currentProfile = result.getString("profile");
                    User currentUser = new User(currentUsername, currentPassword);
                    if (currentProfile != null) {
                        currentUser.setProfile(currentProfile);
                    }
                    Instablam.userAccounts.add(currentUser);
                }
                System.out.println("Upload Complete");
            }
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
            int i = Instablam.userAccounts.size();
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
                String currentUser = user.getUsername();
                String deletePostTable = "DROP TABLE IF EXISTS posts_from_" + currentUser;
                stmt.executeUpdate(deletePostTable);
                System.out.println("Table deleted");
                String createPostTable = "CREATE TABLE instablam.posts_from_" + currentUser +
                        "(id int NOT NULL AUTO_INCREMENT," +
                        "file_path VARCHAR(255) not NULL, " +
                        "is_public VARCHAR(10) not NULL, " +
                        "number_likes INT not NULL, " +
                        "caption VARCHAR(200)," +
                        "comments VARCHAR(1000)," +
                        "date_created VARCHAR(100) not NULL," +
                        "PRIMARY KEY ( id ))";
                stmt.executeUpdate(createPostTable);
                System.out.println("Table Created for a user's post");
                ArrayList<Post> userHoldPost = user.getPosts();
                for (Post post : userHoldPost)
                {
                    String currentImageFile = post.getImageFile();
                    boolean currentIsPublic = post.isPublicPost();
                    int currentLikes = post.getLikes();
                    String currentCaption = post.getCaption();
                    String convertedComment = Database.fromArrayToString(post.getComments());
                    String convertedDate = Database.fromTimeToString(post.getPostingTime());

                    String postSQL = "INSERT into instablam.posts_from_" + currentUser +
                            " (file_path, is_public, number_likes, caption, comments, date_created)" +
                            " values ('"+currentImageFile+"', '"+currentIsPublic+"', '"+currentLikes+"', '"+currentCaption+"', '"+convertedComment+"', '"+convertedDate+"')";
                    stmt.executeUpdate(postSQL);
                    System.out.println("added a user post");

                }
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

    private static String fromArrayToString (ArrayList<String> stringArray)
    {
        String combinedString = null;
        for (int i = 0; i < stringArray.size(); i++)
        {
            combinedString = combinedString + stringArray.get(i) + "^";
        }
        return combinedString;
    }

    private static String fromTimeToString(LocalDateTime time)
    {
       return time.format(DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm:ss"));
    }


    public static void main(String[] args)
    {
        Database.saveAndShutdown();
        boolean alpha = true;
        String beta = String.valueOf(alpha);
    }
}
