package Utilities.Database;

import java.io.*;
import java.sql.*;

public class dbConnection {
    private static final String USERNAME = "dbuser";
    private static final String PASSWORD = "dbpassword";
    private static final String CONN = "jdbc:mysql://localhost/login";
    private static final String DBNAME = "OfficeElo.sqlite";

    private static Connection getConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection("jdbc:sqlite:" + getDatabaseLocation());
        } catch (ClassNotFoundException cnf) {
            cnf.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getDatabaseLocation() {
        String dir = new File(".").getAbsolutePath();
        return dir + DBNAME;
    }

    public static void checkUpdates() {
        String sql = "SELECT * from VERSION;";
        Connection connection;
        PreparedStatement pr = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            resultSet = connection.getMetaData().getTables(null, null, "version", null);
            if (!resultSet.next()) {
                createTables(connection);
            } else {
                pr = connection.prepareStatement(sql);
                resultSet = pr.executeQuery();
                updateDatabase(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateDatabase(int anInt) {
    }

    private static void createTables(Connection connection) {
        StringBuilder sb = new StringBuilder();
        try {
            Statement statement = connection.createStatement();
            BufferedReader br = new BufferedReader(new FileReader("src/Utilities/Database/Scripts/clean.sql"));
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                sb.append(currentLine);
            }
            String[] queries = sb.toString().split(";");
            for (String query : queries) {
                connection.createStatement().execute(query);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
