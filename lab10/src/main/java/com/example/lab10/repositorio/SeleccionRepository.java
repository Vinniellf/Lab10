package com.example.lab10.repositorio;

import com.example.lab10.entidad.Jugador;
import com.example.lab10.entidad.Seleccion;

import java.net.ConnectException;
import java.sql.*;
import java.util.ArrayList;

public class SeleccionRepository extends BaseRepository{
    public Seleccion obtenerSeleccion(int id){
        Seleccion seleccion = new Seleccion();
        String sql = "select * from seleccion where idSeleccion = ?";

        try(Connection conn = this.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                seleccion.setIdSeleccion(rs.getInt("idSeleccion"));
                seleccion.setNombre(rs.getString("nombre"));
                seleccion.setTecnico(rs.getString(3));

            }

        } catch(SQLException e){
            e.printStackTrace();
        }
        return seleccion;
    }

    public ArrayList<Seleccion> obtenerSelecciones(){
        ArrayList<Seleccion> selecciones = new ArrayList<>();
        String sql = "select * from seleccion";

        try(Connection conn = this.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)){
            while(rs.next()){
                selecciones.add(obtenerSeleccion(rs.getInt("idSeleccion")));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return selecciones;
    }

}
