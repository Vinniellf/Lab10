package com.example.lab10.repositorio;

import com.example.lab10.entidad.Jugador;
import com.example.lab10.entidad.Seleccion;

import java.sql.*;
import java.util.ArrayList;

public class JugadorRepository extends BaseRepository{
    public ArrayList<Jugador> listarJugadores(){
        ArrayList<Jugador> jugadores = new ArrayList<>();
        String sql = "select *from jugador";

        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){

            while(rs.next()){
                Jugador j = new Jugador();
                SeleccionRepository sr = new SeleccionRepository();

                j.setIdJugador(rs.getInt(1));
                j.setNombre(rs.getString("nombre"));
                j.setEdad(rs.getInt("edad"));
                j.setPosicion(rs.getString(4));
                j.setClub(rs.getString("club"));
                Seleccion s = sr.obtenerSeleccion(rs.getInt(6));
                j.setSeleccion(s);

                jugadores.add(j);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return jugadores;
    }

    public void eliminarJugador(int id){
        String sql = "delete from jugador where idJugador = ?";

        try(Connection conn = this.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void insertarJugador(Jugador j){
        String sql = "insert into jugador (nombre, edad, posicion, club, sn_idSeleccion) values (?, ?, ?, ?, ?)";

        try(Connection conn = this.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, j.getNombre());
            stmt.setInt(2 , j.getEdad());
            stmt.setString(3 , j.getPosicion());
            stmt.setString(4 , j.getClub());
            stmt.setInt(5, j.getSeleccion().getIdSeleccion());
            stmt.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
