package learn.memories.data;

import learn.memories.models.Memory;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class MemoryJDBCRepoImpl implements MemoryRepository {
    private final JdbcTemplate jdbcTemplate;

    public MemoryJDBCRepoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Memory> findAll() throws DataAccessException {
        return null;
    }
    public Memory findById(int memoryId) throws DataAccessException {
        return null;
    }
    public List<Memory> findShareable(boolean shareable) throws DataAccessException {
        return null;
    }
    public Memory add(Memory memory) throws DataAccessException {
        return null;
    }
    public boolean update(Memory memory) throws DataAccessException {
        return false;
    }
    public boolean deleteById(int memoryId) throws DataAccessException {
        return false;
    }

    private String getSelectQuery() {
        return "SELECT memory.memory_id," +
                "user.user_name," +
                "memory.date_time_created," +
                "memory.memoryText," +
                "memory.is_public" +
        "FROM memory" +
        "INNER JOIN user ON memory.user_id_created = user.user_id;";
    }
}
