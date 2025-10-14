package learn.memories.data.mappers;

import learn.memories.models.Memory;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MemoryMapper implements RowMapper<Memory> {

    public Memory rowMap(ResultSet resultSet, int rowNum) throws SQLException {
        Memory memory = new Memory();

        memory.setId();
    }
}
