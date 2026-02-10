import java.sql.*;

public class EmployeeJDBC {

    static final String DB_URL = "jdbc:mysql://localhost:3306/advanced_java";
    static final String USER = "root";
    static final String PASS = "";

    public static void main(String[] args) {

        try {
            // Load MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create Connection
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

            // ------------------ CREATE TABLE ------------------
            String createTableSQL =
                    "CREATE TABLE IF NOT EXISTS employee (" +
                    "emp_id INT PRIMARY KEY," +
                    "emp_name VARCHAR(50)," +
                    "department VARCHAR(30)," +
                    "salary DOUBLE)";

            Statement stmt = con.createStatement();
            stmt.execute(createTableSQL);

            System.out.println("Employee table created successfully.");

            // ------------------ INSERT ------------------
            String insertSQL = "INSERT INTO employee VALUES (?, ?, ?, ?)";
            PreparedStatement psInsert = con.prepareStatement(insertSQL);

            psInsert.setInt(1, 101);
            psInsert.setString(2, "Sudip Lo");
            psInsert.setString(3, "IT");
            psInsert.setDouble(4, 60000);
            psInsert.executeUpdate();

            psInsert.setInt(1, 102);
            psInsert.setString(2, "Sujan Lama");
            psInsert.setString(3, "HR");
            psInsert.setDouble(4, 45000);
            psInsert.executeUpdate();

            System.out.println("Records inserted successfully.");

            // ------------------ UPDATE ------------------
            String updateSQL = "UPDATE employee SET salary = ? WHERE emp_id = ?";
            PreparedStatement psUpdate = con.prepareStatement(updateSQL);

            psUpdate.setDouble(1, 65000);
            psUpdate.setInt(2, 101);
            psUpdate.executeUpdate();

            System.out.println("Record updated successfully.");

            // ------------------ DELETE ------------------
            String deleteSQL = "DELETE FROM employee WHERE emp_id = ?";
            PreparedStatement psDelete = con.prepareStatement(deleteSQL);

            psDelete.setInt(1, 102);
            psDelete.executeUpdate();

            System.out.println("Record deleted successfully.");

            // ------------------ SELECT (IT Department) ------------------
            String selectSQL = "SELECT * FROM employee WHERE department = ?";
            PreparedStatement psSelect = con.prepareStatement(selectSQL);

            psSelect.setString(1, "IT");
            ResultSet rs = psSelect.executeQuery();

            System.out.println("\nEmployees in IT Department:");
            System.out.println("ID\tName\tDepartment\tSalary");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("emp_id") + "\t" +
                        rs.getString("emp_name") + "\t" +
                        rs.getString("department") + "\t" +
                        rs.getDouble("salary")
                );
            }

            // Close Connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
