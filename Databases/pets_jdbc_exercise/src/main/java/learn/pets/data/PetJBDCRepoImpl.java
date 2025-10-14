package learn.pets.data;

import com.mysql.cj.jdbc.MysqlDataSource;
import learn.pets.models.Pet;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetJBDCRepoImpl implements PetRepository{
    // DataSource for managing database connections
    private DataSource dataSource = initDataSource();
    /**
     * Initializes the DataSource object for database connection.
     * Uses MysqlDataSource to connect to a MySQL database.
     *
     * @return DataSource object configured with database URL, username, and
    password.
     */
    private DataSource initDataSource() {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/pet_management?serverTimezone=America/Chicago"); // Database connection URL
        ds.setUser("root"); // Change to your MySQL username
        ds.setPassword(""); // Password removed from Github, insert your local
        return ds;
    }

    @Override
    public List<Pet> findAll() {
        List<Pet> pets = new ArrayList<>();
        final String sql = "SELECT pet_id, name, type FROM pet;";
        try (Connection conn = dataSource.getConnection();
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            // Process each row in the result set
            while (rs.next()) {
                Pet pet = new Pet();
                pet.setPetId(rs.getInt("pet_id"));
                pet.setName(rs.getString("name"));
                pet.setType(rs.getString("type"));
                pets.add(pet);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Log exception details
        }
        return pets;
    }

    @Override
    public Pet findByName(String petName) {
        String sql = "SELECT pet_id, `name`, `type` FROM pet WHERE name = ?;";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setString(1,petName);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()){
                    Pet pet = new Pet();
                    pet.setPetId(rs.getInt("pet_id"));
                    pet.setName(rs.getString("name"));
                    pet.setType(rs.getString("type"));
                    return pet;
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Pet findById(int pet_id) {
        String sql = "SELECT pet_id, `name`, `type` FROM pet WHERE pet_id = ?;";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, pet_id);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()){
                    Pet pet = new Pet();
                    pet.setPetId(rs.getInt("pet_id"));
                    pet.setName(rs.getString("name"));
                    pet.setType(rs.getString("type"));
                    return pet;
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Pet add(Pet pet) {
        final String sql = "INSERT INTO pet (name, type) VALUES (?, ?);";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql,
                     Statement.RETURN_GENERATED_KEYS)) {
            // Setting parameters for the prepared statement
            statement.setString(1, pet.getName());
            statement.setString(2, pet.getType());
            // Execute the update and check if the insertion was successful
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted <= 0) return null;
            // Retrieve the auto-generated pet ID
            try (ResultSet keys = statement.getGeneratedKeys()) {
                if (keys.next()) {
                    pet.setPetId(keys.getInt(1));
                    return pet;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Log exception details
        }
        return null;
    }

    @Override
    public boolean update(Pet pet) {
        final String sql = "UPDATE pet SET name = ?, type = ? WHERE pet_id = ?;";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            // Setting parameters for the prepared statement
            statement.setString(1, pet.getName());
            statement.setString(2, pet.getType());
            statement.setInt(3, pet.getPetId());
            // Execute update and check if any rows were affected
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace(); // Log exception details
        }
        return false;
    }

    @Override
    public boolean delete(int pet_id) {
        final String sql = "DELETE FROM pet WHERE pet_id = ?;";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            // Setting the pet ID parameter for deletion
            statement.setInt(1, pet_id);
            // Execute delete and check if any rows were affected
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace(); // Log exception details
        }
        return false;
    }
}

