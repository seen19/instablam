/**
 * Created by perts on 4/13/2017.
 */
import java.sql.*;
public class sendToProgram
{
    public static void main(String[] args)
    {
        Connection conn = null;
        Statement stmt = null;
        ResultSet result = null;

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306","root","toor");
            conn.setCatalog("demo");
            stmt = conn.createStatement();
            String newTable = "CREATE TABLE demo.USER_Bob " +
                            "(id INTEGER not NULL, " +
                            "first VARCHAR(255), " +
                            "last VARCHAR(255), " +
                            "age INTEGER, " +
                            "PRIMARY KEY ( id ))";
            stmt.executeUpdate(newTable);
            System.out.println("update successful");
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
}
