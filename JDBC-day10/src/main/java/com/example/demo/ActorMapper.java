package com.example.demo;

public class ActorMapper {
	public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {
		Actor actor = new Actor();
		actor.setFirstName(rs.getString("first_name"));
		actor.setLastName(rs.getString("last_name"));
		return actor;
	}
}
