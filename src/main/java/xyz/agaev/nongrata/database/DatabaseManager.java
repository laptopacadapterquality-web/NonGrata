package xyz.agaev.nongrata.database;

import com.zaxxer.hikari.HikariDataSource;
import xyz.agaev.nongrata.database.hikari.HikariProvider;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseManager {

    private final HikariProvider hikariProvider;

    public DatabaseManager(File pluginFolder) {

        this.hikariProvider = new HikariProvider(pluginFolder);

    }

    public void connect() {

        hikariProvider.connect();

    }

    public Connection getConnection() throws SQLException {

        HikariDataSource dataSource = hikariProvider.getDataSource();

        return dataSource.getConnection();

    }

    public void disconnect() {

        hikariProvider.shutdown();

    }

}
