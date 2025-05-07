import java.sql.*;
import java.sql.Statement;
public class connect1 {
    Connection c;
    Statement s;
    public connect1()
    {
        try{
          //  Class.forName("com.mysql.cj.jdbc.Driver");
            c =DriverManager.getConnection("jdbc:mysql://localhost:3306/Banking","root","Kavya@123");
            s= c.createStatement();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
