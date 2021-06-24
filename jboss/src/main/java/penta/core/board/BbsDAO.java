package penta.core.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BbsDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<BbsDTO> list() {
		String query = "select * from board";
		List<BbsDTO> list = jdbcTemplate.query(query, new BeanPropertyRowMapper<BbsDTO>(BbsDTO.class));
		return list;
	}
}
