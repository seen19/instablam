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
            stmt = conn.createStatement();

            //result = stmt.executeQuery("SELECT FROM ")
            System.out.println("All good so far");
        }
        catch (SQLException e)
        {
            System.out.println("SQL Error");
        } catch (ClassNotFoundException e) {} finally
        {
            try
            {
                stmt.close();
            }
            catch (SQLException e) {}

            try
            {
                result.close();
            }
            catch (SQLException e) {}
        }
    }
}
