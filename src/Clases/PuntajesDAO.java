package Clases;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PuntajesDAO {
   
    public PuntajesDAO(){
    
    }
    // Guardar puntaje en la base de datos
    public void guardarPuntaje(String nombre, int puntaje) {
        try (Connection conexion = Conexion.obtenerConexion()) {
            String sql = "INSERT INTO Puntajes (name, puntaje, fecha) VALUES (?, ?, ?)";
            try (PreparedStatement statement = conexion.prepareStatement(sql)) {
                statement.setString(1, nombre);
                statement.setInt(2, puntaje);
                statement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
                statement.executeUpdate();
            }
            Conexion.cerrarConexion(conexion);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Obtener todos los puntajes ordenados por puntaje de manera descendente
    public List<Puntajes> obtenerTodosLosPuntajes() {
        List<Puntajes> listaPuntajes = new ArrayList<>();

        try (Connection conexion = Conexion.obtenerConexion()) {
            String sql = "SELECT * FROM Puntajes ORDER BY puntaje DESC";
            try (PreparedStatement statement = conexion.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Puntajes puntaje = new Puntajes(
                                resultSet.getString("name"),
                                resultSet.getInt("puntaje"),
                                resultSet.getTimestamp("fecha")
                        );
                        puntaje.setIdPuntajes(resultSet.getInt("idPuntajes"));
                        listaPuntajes.add(puntaje);
                    }
                }
                Conexion.cerrarConexion(conexion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaPuntajes;
    }
}