package pl.coderslab.beans;
import java.sql.*;

public class DBUtil {
    private static final String DB_URL_DIAG = "jdbc:mysql://localhost:3306/DIAG?useSSL=false&characterEncoding=utf8&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "coderslab";

    public static Connection connectDiagnostics() throws SQLException {
        return DriverManager.getConnection(DB_URL_DIAG, DB_USER, DB_PASS);
    }
    public static int insert(Connection conn, String query, String... params) {
        try (PreparedStatement statement = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            for (int i = 0; i < params.length; i++) {
                statement.setString(i + 1, params[i]);
            }
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static void printData(Connection conn, String query, String... columnNames) throws SQLException {
        try (PreparedStatement statement = conn.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery();) {
            while (resultSet.next()) {
                for (String columnName : columnNames) {
                    System.out.println(resultSet.getString(columnName));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static final String DELETE_QUERY = "DELETE FROM tableName where id = ?";

    public static void remove(Connection conn, String tableName, int id) {
        try (PreparedStatement statement =
                     conn.prepareStatement(DELETE_QUERY.replace("tableName", tableName));) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static final String QUERY_TO_EDIT = "update cinemas SET NAME = ? , ADDRESS = ? WHERE ID = ? ;";

    public static void editTable(Connection conn, String nazwa, String ulica, int edit) {
        try (PreparedStatement statement =
                     conn.prepareStatement(QUERY_TO_EDIT)) {
            statement.setString(1, nazwa);
            statement.setString(2, ulica);
            statement.setInt(3, edit);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}