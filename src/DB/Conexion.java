package DB;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Caudillo
 */
public class Conexion {

    private static String hostname = "localhost";
    private static String port = "3306";
    private static String db = "inteppco";
    
    public static void main(String[] args) {
        createConnection();
    }
    /**
     * se crea la conexion a la base de datos inteppco
     *
     * @return conexion a bd
     */
    public static Connection createConnection() {

        Connection con = null;
        try {
            //jdbc:mysql://hostname:port/databasename            
            String connectionUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + db;
            String userName = "root";
            String userPass = "";
            con = DriverManager
                    .getConnection(connectionUrl, userName, userPass);
        } catch (SQLException e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Verifique que el servidor de base de datos \nse encuentre  funcionando correctamente.","",JOptionPane.WARNING_MESSAGE);
        }
        return con;
    }
    public static ResultSet consultar(String sql) {
        ResultSet resultado;
        try {
            Statement sentencia = createConnection().createStatement();
            resultado = sentencia.executeQuery(sql);
            
        } catch (SQLException e) {
            System.out.println(sql);
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Ocurrio un problema al consultar los datos.");
            return null;
        }        return resultado;
    }
    
    
    /**
     * @param nameTable nombre de la tabla en la cual se insertaran los datos
     * @param names nombres de los campos en la base de datos
     * @param values valores asigandos a los campos
     * @return -1  -> si no se inserto correctamente o el identificador del valor insertado
     */
    public static int insert(String nameTable,String[] names,String[] values) {
        int id=-1;
        if (names!=null&& values!=null) {
             
            if (names.length > 0) {
                Connection con = createConnection();
                String query = "insert into " + nameTable + " ( " + Arrays.toString(names);

                query += ") values ( ";
                if (values[0] == null) {
                    query += values[0];
                } else {
                    query += "'" + values[0] + "'";
                }
                for (int i = 1; i < values.length; i++) {

                    if (values[i] == null) {
                        query += ", '";
                    } else {
                        query += ", '" + values[i] + "'";
                    }
                }
                query += ")";
                query = query.replace('[', ' ');
                query = query.replace(']', ' ');

                try {
                    System.out.println("Conexion " + query);
                    PreparedStatement insertar = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
                   
                    insertar.executeUpdate();
                   ResultSet generate=insertar.getGeneratedKeys();
                   generate.next();
                    id= generate.getInt(1);
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return id;
    }

    
}
