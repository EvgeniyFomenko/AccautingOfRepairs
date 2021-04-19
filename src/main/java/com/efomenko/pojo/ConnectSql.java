package com.efomenko.pojo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ConnectSql extends AbstractDAO<Integer, Equip> {
    public static final String SQL_SELECT_ALL_EQUIPMENT = "SELECT * FROM equipment";
    public static final String SQL_SELECT_EQUIPMENT_ID = "SELECT * FROM equipment WHERE id=?";
    public static final String SQL_INSERT_EQUIPMENT = "INSERT INTO equipment (name,serialNumber, description, status, dateStart,dateFinish)"+" VALUES (?,?,?,?,?,?)";
    public static final String SQL_DELETE_EQUIPMENT = "DELETE FROM equipment WHERE idequipment = ?";
    public static final String SQL_UPDATE_EQUIPMENT = "UPDATE equipment SET name = ? , serialNumber = ? , status=? , description=? , dateStart=? , dateFinish=? WHERE idequipment = ?";
    @Override
    public List<Equip> findAll() {
        List<Equip> equips = new ArrayList<>();
        try {
            Connection connection = getNewConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_EQUIPMENT);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String serialNumber = rs.getString(3);
                String status = rs.getString(4);
                String description = rs.getString(5);
                String dateStart = rs.getString(6);
                String dateFinish = rs.getString(7);
                equips.add(new Equip(id, name, serialNumber, status, description, dateStart, dateFinish));
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return equips;
    }

    @Override
    public Equip findEntityById(Integer id) {
        Equip equip = null;
        try {
            Connection connection = getNewConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_EQUIPMENT_ID);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String name = rs.getString(2);
                String serialNumber = rs.getString(3);
                String status = rs.getString(4);
                String description = rs.getString(5);
                String dateStart = rs.getString(6);
                String dateFinish = rs.getString(7);
                equip = new Equip(id, name, serialNumber, status, description, dateStart, dateFinish);
            }
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equip;
    }

    @Override
    public boolean update(Equip entity) {
        try {
            Connection connection = getNewConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_EQUIPMENT);
            statement.setInt(7, entity.getId());
            statement.setString(1,entity.getName());
            statement.setString(2,entity.getSerialNumber());
            statement.setString(3,entity.getStatus());
            statement.setString(4,entity.getDescription());
            statement.setString(5,entity.getDateStart());
            statement.setString(6,entity.getDateFinish());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(int entity) {
        try {
            Connection connection = getNewConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_EQUIPMENT);
            statement.setInt(1, entity);
            statement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public Equip insert(Equip entity) {
        try {
            Connection connection = getNewConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_EQUIPMENT);
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getSerialNumber());
            statement.setString(3, entity.getDescription());
            statement.setString(4, entity.getStatus());
            statement.setString(5, entity.getDateStart());
            statement.setString(6, entity.getDateFinish());
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Connection getNewConnection() throws SQLException {
        ResourceBundle resource = ResourceBundle.getBundle("database");
        String url = resource.getString("db.url");
        String user = resource.getString("db.user");
        String pass = resource.getString("db.password");
        String dbName = resource.getString("db.name");
        return DriverManager.getConnection(url + dbName, user, pass);
    }
}

