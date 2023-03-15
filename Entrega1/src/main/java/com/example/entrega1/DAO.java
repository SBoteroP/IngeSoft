package com.example.entrega1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    private Connection conn;

    public DAO(String url, String user, String password) throws SQLException {
        conn = DriverManager.getConnection(url, user, password);
    }

    public boolean checkUsername(String username) throws SQLException {
        String sql = "SELECT COUNT(*) FROM usuarios WHERE username = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        int count = rs.getInt(1);
        return count > 0;
    }

    public void createUser(String username, String password) throws SQLException {
        String sql = "INSERT INTO usuarios (username, password) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, username);
        stmt.setString(2, password);
        stmt.executeUpdate();
    }

    public boolean authenticate(String username, String password) throws SQLException {
        String sql = "SELECT COUNT(*) FROM usuarios WHERE username = ? AND password = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, username);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        int count = rs.getInt(1);
        return count > 0;
    }

    public List<Service> getServices() throws SQLException {
        List<Service> services = new ArrayList<>();
        String sql = "SELECT nombre_servicio, costo, proveedor_servicio FROM services";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String name = rs.getString("nombre_servicio");
            double price = rs.getDouble("costo");
            String provider = rs.getString("proveedor_servicio");
            Service service = new Service(name, price, provider);
            services.add(service);
        }
        return services;
    }

    public void close() throws SQLException {
        conn.close();
    }
}

