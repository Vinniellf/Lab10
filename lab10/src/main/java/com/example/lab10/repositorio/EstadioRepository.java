package com.example.lab10.repositorio;

import com.example.lab10.entidad.Estadio;
import com.example.lab10.entidad.Jugador;
import com.example.lab10.entidad.Seleccion;

import java.sql.*;
import java.util.ArrayList;

public class EstadioRepository extends BaseRepository{
    public ArrayList<Estadio> listarEstadios(){
        ArrayList<Estadio> estadios = new ArrayList<>();
        String sql = "select *from estadio";

        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){

            while(rs.next()){
                Estadio e = new Estadio();
                EstadioRepository er = new EstadioRepository();
                e.setIdEstadio(rs.getInt("idEstadio"));
                e.setNombre(rs.getString(2));
                e.setProvincia(rs.getString(3));
                e.setClub(rs.getString(4));
                estadios.add(e);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return estadios;
    }

    public void eliminarEstadio(int id){
        String sql = "delete from estadio where idEstadio = ?";

        try(Connection conn = this.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void insertarEstadio(Estadio e){
        String sql = "insert into estadio (nombre, provincia, club) values (?, ?, ?)";

        try(Connection conn = this.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, e.getNombre());
            stmt.setString(2 , e.getProvincia());
            stmt.setString(3 , e.getClub());
            stmt.executeUpdate();

        } catch (SQLException a){
            a.printStackTrace();
        }
    }
}
