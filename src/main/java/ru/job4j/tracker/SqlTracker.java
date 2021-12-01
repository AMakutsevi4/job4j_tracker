package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {
    private Connection cn;

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        String sql = "Insert into items(name) values(?)";
        try (var statement = cn.prepareStatement(sql, Statement
                .RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.execute();
            statement.setTimestamp('?', Timestamp.valueOf(item.getCreated()));
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean rsl = false;
        var sql = "update items set name = ? where id = ?";
        try (var statement = cn.prepareStatement(sql)) {
            statement.setString(1, item.getName());
            statement.setInt(2, id);
            statement.setTimestamp('?', Timestamp.valueOf(item.getCreated()));
            rsl = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public boolean delete(int id) {
        var rsl = false;
        var sql = "delete from items where id = ?";
        try (var statement = cn.prepareStatement(sql)) {
            statement.setInt(1, id);
            rsl = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public List<Item> findAll() {
        List<Item> rsl = new ArrayList<>();
        var sql = "select * from items";
        try (var statement = cn.prepareStatement(sql)) {
            try (var rslKey = statement.executeQuery()) {
                if (rslKey.next()) {
                    Item entry = parseItem(rslKey);
                    entry.getCreated();
                    rslKey.getTimestamp("created").toLocalDateTime();
                    rsl.add(entry);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        var sql = "select * from items where name = ?";
        try (var statement = cn.prepareStatement(sql)) {
            statement.setString(1, key);
            try (var rslKey = statement.executeQuery()) {
                if (rslKey.next()) {
                    Item entry = parseItem(rslKey);
                    entry.getCreated();
                    rslKey.getTimestamp("created").toLocalDateTime();
                    rsl.add(entry);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public Item findById(int id) {
        var sql = "select * from items where id = ?";
        try (var statement = cn.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (var rslKey = statement.executeQuery()) {
                if (rslKey.next()) {
                    Item entry = parseItem(rslKey);
                    entry.getCreated();
                    rslKey.getTimestamp("created").toLocalDateTime();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Item parseItem(int id, String name) {
        Item item = new Item(name);
        item.setId(id);
        return item;
    }
    private Item parseItem(ResultSet resultSet) throws SQLException {
        return new Item(resultSet.getString("name"), resultSet.getInt("id"));
    }
}