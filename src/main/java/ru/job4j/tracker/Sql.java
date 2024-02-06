package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Sql implements Store {
    private Connection cn;

    public Sql(Connection connection) {
        this.cn = connection;
    }

    public void init() {
        try (InputStream in = Sql.class.getClassLoader()
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
        var sql = "Insert into items(name, created) values(?, ?)";
        try (var statement = cn.prepareStatement(sql, Statement
                .RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.execute();
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
        var sql = "update items set name = ?, created = ? where id = ?";
        try (var statement = cn.prepareStatement(sql)) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.setInt(3, id);
            rsl = statement.executeUpdate() > 0;
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public boolean delete(int id) {
        var rsl = false;
        var sql = "delete from items where id = ?;";
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
        var sql = "select * from items;";
        try (var statement = cn.prepareStatement(sql)) {
            try (var rslKey = statement.executeQuery()) {
                while (rslKey.next()) {
                    rsl.add(parseItem(rslKey));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public void reactFindAll(Observe<Item> observe) {
        var sql = "select * from items;";
        try (var statement = cn.prepareStatement(sql)) {
            try (var rslKey = statement.executeQuery()) {
                while (rslKey.next()) {
                    Thread.sleep(100);
                   observe.receive(parseItem(rslKey));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
     }

    @Override
    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        var sql = "select * from items where name = ?;";
        try (var statement = cn.prepareStatement(sql)) {
            statement.setString(1, key);
            try (var rslKey = statement.executeQuery()) {
                if (rslKey.next()) {
                    rsl.add(parseItem(rslKey));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public Item findById(int id) {
        String sql = "select * from items where id = ?;";
        try (PreparedStatement statement = cn.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet rslKey = statement.executeQuery()) {
                if (rslKey.next()) {
                    return parseItem(rslKey);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Item parseItem(ResultSet resultSet) throws SQLException {
        return new Item(resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getTimestamp("created").toLocalDateTime());
    }
}