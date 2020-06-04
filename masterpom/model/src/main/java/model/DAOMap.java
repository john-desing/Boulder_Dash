package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Line;

/**
 * The Class DAOHelloWorld.
 *
 * @author Jean-Aymeric Diet
 */
class DAOMap extends DAOEntity<Line>{

	/**
	 * Instantiates a new DAO hello world.
	 *
	 * @param connection
	 *          the connection
	 * @throws SQLException
	 *           the SQL exception
	 */
	public DAOMap(final Connection connection) throws SQLException {
		super(connection);
	}


	public String find(int id, int map) {
		String line = " ";
		String name = "line" + map;	
		try {
			final String sql = "{call getLineMap1(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, id);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				line = resultSet.getString(name);
			}
			return line;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
