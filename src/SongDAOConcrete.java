import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class SongDAOConcrete implements SongDaoInterface{
	// connect to the database
	Connection connection = ConnectionManager.getInstance().getConnection();

	@Override
	public ArrayList<Song> getSongs() throws SQLException {

		// create an array list to hold songs
		ArrayList<Song> songs = new ArrayList<>();

		// create a SELECT SQL query
		String query = "SELECT * FROM song";

		// create a new ResultSet
		ResultSet rs = null;

		try (
		// java.sql.Statement
		Statement statement = connection.createStatement();) {

			// execute the query
			rs = statement.executeQuery(query);

			// add songs to the arrayList
			while (rs.next()) {
				songs.add(new Song(rs.getInt("songID"), 
						rs.getString("title"), 
						rs.getString("artist"), 
						rs.getString("album"),
						rs.getInt("year_released")));

				//System.out.println("Song: " + rs.getString("title")
						//+ " added to songs");
			}

		}

		return songs;
	}

	@Override
	public Song getSong(int songID) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSong(Song song) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSong(Song song) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSong() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printSong(Song song) {
		// TODO Auto-generated method stub
		
	}

}
