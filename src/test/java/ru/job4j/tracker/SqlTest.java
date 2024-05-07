package ru.job4j.tracker;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

public class SqlTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTest.class.getClassLoader()
                .getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        Sql tracker = new Sql(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenAddToDB() {
        Store tracker = new Sql(connection);
        Item item = new Item("item");
        Item addedItem = tracker.add(item);
        assertThat(addedItem).isEqualTo(item);
    }

    @Test
    public void whenDelete() {
        Store tracker = new Sql(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.delete(item.getId()));

    }

    @Test
    public void whenFindById() {
        Store tracker = new Sql(connection);
        Item item = new Item("item");
        Item item1 = new Item("item1");
        tracker.add(item);
        tracker.add(item1);
        assertThat(tracker.findById(item1.getId())).isEqualTo(item1);
    }

    @Test
    public void whenFindByName() {
        Store tracker = new Sql(connection);
        Item item = new Item("item");
        Item item1 = new Item("item1");
        tracker.add(item);
        tracker.add(item1);
        List<Item> items = new ArrayList<>();
        items.add(item);
        assertThat(tracker.findByName(item.getName())).isEqualTo(items);
    }

    @Test
    public void whenReplace() {
        Store tracker = new Sql(connection);
        Item item = new Item("item");
        tracker.add(item);
        int id = item.getId();
        Item item1 = new Item("item1");
        tracker.replace(id, item1);
        assertThat(tracker.findById(id).getName()).isEqualTo(item1.getName());
    }

    @Test
    public void whenFindAll() {
        Store tracker = new Sql(connection);
        Item item = new Item("item");
        Item item1 = new Item("item1");
        tracker.add(item);
        tracker.add(item1);
        assertThat(tracker.findAll()).isEqualTo(List.of(item, item1));
    }

}