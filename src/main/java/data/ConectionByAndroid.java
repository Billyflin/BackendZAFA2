package data;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionByAndroid extends ConectionData{
    private static final String DB_URL = "jdbc:mysql://181.226.110.208:3306/DrSearch";
    private static final String USER = "root";
    private static final String PASS = "0208";


    public ConectionByAndroid() throws SQLException {
        conectar();
    }

    @Override
    public void conectar() throws SQLException {
        connection = DriverManager.getConnection(DB_URL, USER, PASS);
        statement = connection.createStatement();
    }

    public void cerrarConexion() throws SQLException {

        if (statement != null) {
            statement.close();
        }

        if (preparedStatement != null) {
            preparedStatement.close();
        }

        if (connection != null) {
            connection.close();
        }
    }
}
