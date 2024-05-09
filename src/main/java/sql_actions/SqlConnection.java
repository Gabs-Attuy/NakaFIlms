package sql_actions;
import java.sql.*;

public class SqlConnection {
    private final static String url = "jdbc:mysql://localhost:3306/NakaFilms";
    private final static String username = "root";
    private final static String password = "GS24192197";
    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    private String nome = null, telefone = null;

    public static void main(String[] args) {
        SqlConnection db = new SqlConnection();
        db.openDB();
        db.closeDB();
    }
    public Connection openDB(){
        try{
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
            System.out.println("\nConexão estabelecida com sucesso!\n");
            return con;
        } catch (SQLException e){
            System.out.println("\nNão foi possivel estabelecer conexão " + e + "\n");
            System.exit(1);
            return null;
        }
    }
    public void closeDB(){
        try{
            con.close();
            stmt.close();
        } catch (SQLException e){
            System.out.println("\nNão foi possivel fechar conexão " + e + "\n");
            System.exit(1);
        }
    }
}
