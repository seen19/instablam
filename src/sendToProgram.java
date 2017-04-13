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
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306" + "user=root&password=toor");
            stmt = conn.createStatement();

        }
        catch (SQLException e)
        {
            System.out.println("SQL Error");
        }
        finally
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
