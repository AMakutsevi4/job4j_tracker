package ru.job4j.tracker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader()
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

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenAddToDB() {
        Store tracker = new SqlTracker(connection);
        Item item = new Item("item");
        Item addedItem = tracker.add(item);
        assertThat(addedItem, is(item));
    }

    @Test
    public void whenDelete() {
        Store tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertTrue(tracker.delete(item.getId()));
    }

    @Test
    public void whenFindById() {
        Store tracker = new SqlTracker(connection);
        Item item = new Item("item");
        Item item1 = new Item("item1");
        tracker.add(item);
        tracker.add(item1);
        assertThat(tracker.findById(item1.getId()), is(item1));
    }

    @Test
    public void whenFindByName() {
        Store tracker = new SqlTracker(connection);
        Item item = new Item("item");
        Item item1 = new Item("item1");
        tracker.add(item);
        tracker.add(item1);
        List<Item> items = new ArrayList<>();
        items.add(item);
        assertThat(tracker.findByName(item.getName()), is(items));
    }

    @Test
    public void whenReplace() {
        Store tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        int id = item.getId();
        Item item1 = new Item("item1");
        tracker.replace(id, item1);
        assertThat(tracker.findById(id).getName(), is("item1"));
    }

    @Test
    public void whenFindAll() {
        Store tracker = new SqlTracker(connection);
        Item item = new Item("item");
        Item item1 = new Item("item1");
        tracker.add(item);
        tracker.add(item1);
        assertThat(tracker.findAll(), is(List.of(item, item1)));
    }
}