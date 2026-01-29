import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class LibraryDB {

    public static Connection connect() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:library.db");

            Statement st = con.createStatement();

            st.execute("CREATE TABLE IF NOT EXISTS books (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "title TEXT," +
                    "author TEXT," +
                    "quantity INTEGER)");

            st.execute("CREATE TABLE IF NOT EXISTS users (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT)");

            st.execute("CREATE TABLE IF NOT EXISTS issues (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "book_id INTEGER," +
                    "user_id INTEGER," +
                    "issue_date TEXT)");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
