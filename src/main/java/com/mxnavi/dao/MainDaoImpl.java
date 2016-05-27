package com.mxnavi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.mxnavi.dto.FormDto;
import com.mxnavi.dto.ListDto;

@Repository
public class MainDaoImpl implements MainDao {

    private NamedParameterJdbcTemplate jdbcTemplate = null;

    @Autowired
    public void setDatasource(DataSource ds) {
        jdbcTemplate = new NamedParameterJdbcTemplate(ds);
    }

    @Override
    public List<ListDto> select() {
        MapSqlParameterSource paramMap = new MapSqlParameterSource();

        StringBuilder sql = new StringBuilder();
        sql.append(" select ");
        sql.append(" * ");
        sql.append(" from ");
        sql.append(" content ");
        sql.append(" where ");
        sql.append(" 1=1 ");

        List<ListDto> list = jdbcTemplate.query(sql.toString(), paramMap, new ListRowMapper());
        return list;
    }

    protected class ListRowMapper implements RowMapper<ListDto> {
        @Override
        public ListDto mapRow(ResultSet rs, int arg1) throws SQLException {

            ListDto listDto = new ListDto();
            listDto.setId(rs.getInt("id"));
            listDto.setUrl(rs.getString("url"));
            listDto.setTitle(rs.getString("title"));
            listDto.setContent(rs.getString("content"));
            return listDto;
        }
    }

}
