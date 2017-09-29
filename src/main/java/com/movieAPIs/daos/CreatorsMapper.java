package com.movieAPIs.daos;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.movieAPIs.beans.Creators;

public class CreatorsMapper implements RowMapper<Creators> {

	public Creators mapRow(ResultSet rs, int rowNum) throws SQLException {
		Creators creator= new Creators();
		creator.setIdCreators(rs.getInt("idCreators"));
		creator.setName(rs.getString("name"));
		creator.setImagePath(rs.getString("imagePath"));
		return creator;
	}

}
