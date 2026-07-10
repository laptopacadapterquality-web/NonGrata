package xyz.agaev.nongrata.database.hikari;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.File;

public class HikariProvider {

    private final File dataFolder;

    private HikariDataSource dataSource;

    public HikariProvider(File dataFolder) {
        this.dataFolder = dataFolder;
    }

    public void connect() {

        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }

        File database = new File(dataFolder, "database.db");

        HikariConfig config = new HikariConfig();

        config.setJdbcUrl("jdbc:sqlite:" + database.getAbsolutePath());

        config.setDriverClassName("org.sqlite.JDBC");

        config.setPoolName("NonGrataPool");

        config.setMaximumPoolSize(10);

        config.setMinimumIdle(2);

        config.setConnectionTimeout(10000);

        config.setIdleTimeout(600000);

        config.setMaxLifetime(1800000);

        config.addDataSourceProperty("foreign_keys", "true");

        dataSource = new HikariDataSource(config);

    }

    public HikariDataSource getDataSource() {
        return dataSource;
    }

    public void shutdown() {

        if (dataSource != null && !dataSource.isClosed()) {
            dataSource.close();
        }

    }

}
