package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.ConectionByAndroid;
import model.Usuario;
import org.jetbrains.annotations.NotNull;


public class AppService {

    public void guardar(Usuario u) {
        try {
            var conection = new ConectionByAndroid();
            conection.crearUsuario(u);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Usuario activo(String ID) {
        ConectionByAndroid conection = null;
        try {
            conection = new ConectionByAndroid();
            var resultSet = conection.buscarUsuarioPorID(ID);
            while (resultSet.next()) {
                return (read(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param UsuarioData
     * @return Usuario
     */
    public Usuario create(ArrayList<String> UsuarioData) {
        var id = UsuarioData.get(0);
        var rut = UsuarioData.get(1);
        var nombre = UsuarioData.get(2);
        var apellido = UsuarioData.get(3);
        var correo = UsuarioData.get(4);
        var numero = UsuarioData.get(5);
        return new Usuario(id, rut, nombre, apellido, correo, numero);
    }

    public Usuario read(@NotNull ResultSet list) throws SQLException {
        var id = list.getString("id");
        var rut = list.getString("rut");
        var nombre = list.getString("nombre");
        var apellido = list.getString("apellido");
        var correo = list.getString("correo");
        var telefono = list.getString("numero");
        return new Usuario(id, rut, nombre, apellido, correo, telefono);
    }

    public ArrayList<Usuario> getAllUsuarios(){
        ArrayList<Usuario> array=new ArrayList<>();
        ConectionByAndroid conection = null;
        try {
            conection = new ConectionByAndroid();
            var resultSet = conection.leerTablaUsuarios();
            while (resultSet.next()){
                array.add(read(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return array;
    }

}
