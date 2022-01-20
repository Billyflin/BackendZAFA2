package data;

import model.Usuario;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConectionByAndroid extends ConectionData {
    private static final String DB_URL = "jdbc:mysql://181.226.106.35:3306/prueba1";
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
    public ResultSet leerTablaUsuarios() throws SQLException {
        QUERY = "SELECT * FROM prueba1.";
        return statement.executeQuery(QUERY);
    }
    public void crearUsuario(Usuario usuario) throws SQLException {
        QUERY = "INSERT INTO usuarios (id, rut, nombre, apellido, correo, numero) VALUES (?,?,?,?,?,?)";
        preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setString(1, usuario.getId());
        preparedStatement.setString(2, usuario.getRut());
        preparedStatement.setString(3, usuario.getNombre());
        preparedStatement.setString(4, usuario.getApellido());
        preparedStatement.setString(5, usuario.getCorreo());
        preparedStatement.setString(6, usuario.getNumero());
    }

    public ResultSet buscarUsuarioPorID(String id) throws SQLException {
        QUERY = "SELECT * FROM Prueba1.usuarios WHERE id = ?";
        preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setString(1, id);
        return preparedStatement.executeQuery();
    }
}
