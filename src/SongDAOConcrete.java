import java.sql.Connection;
import java.sql.PreparedStatement;
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

		// null song
		Song song = null;

		// create an SELECT SQL query
		String query = "SELECT * FROM song WHERE songID = ?";

		// create a new ResultSet
		ResultSet rs = null;

		try (
		// java.sql.Statement
		PreparedStatement statement = connection.prepareStatement(query);) {

			// fill in the placeholders/parameters
			statement.setInt(1, songID);

			// execute the query
			rs = statement.executeQuery();

			// set the cursor
			if (rs.next()) {

				// populate song
				song = new Song(rs.getInt("songID"), 
						rs.getString("title"), 
						rs.getString("artist"), 
						rs.getString("album"),
						rs.getInt("year_released"));

				// close the ResultSet
				rs.close();
			}
		}

		return song;

	}

	@Override
	public void updateSong(Song song) throws SQLException {
		if (song != null) {

			// create an SELECT SQL query
			String query = "UPDATE song SET title = ?, artist = ?, album = ?, year_released = ? WHERE songID = ?";

			// new Scanner
			java.util.Scanner input = new java.util.Scanner(System.in);

			System.out.print("Set a new title for song (current: "
					+ song.getTitle() + " ): ");
			String title = input.nextLine();

			System.out.print("Set a new artist for song (current: "
					+ song.getArtist() + " ): ");
			String artist = input.nextLine();

			System.out.print("Set a new album for song (current: "
					+ song.getAlbum() + " ): ");
			String album = input.nextLine();

			System.out.print("Set a new year released for song (current: "
					+ song.getYearReleased() + " ): ");
			int year_released = input.nextInt();

			// close the scanner
			input.close();

			try (
			// java.sql.Statement
			PreparedStatement statement = connection.prepareStatement(query);) {

				// fill in the placeholders/parameters
				statement.setString(1, title);
				statement.setString(2, artist);
				statement.setString(3, album);
				statement.setInt(4, year_released);
				statement.setInt(5, song.getSongID());

				// execute the query
				statement.executeUpdate();

				System.out.println("Song updated in the database.");
			}
		}
		
	}

	@Override
	public void deleteSong(Song song) throws SQLException {
		if (song != null) {
			// create an SELECT SQL query
			String query = "DELETE FROM song WHERE songID = ?";

			try (
			// java.sql.Statement
			PreparedStatement statement = connection.prepareStatement(query);) {

				// fill in the place-holders/parameters
				statement.setInt(1, song.getSongID());

				// execute the query
				statement.executeUpdate();

				System.out.println("Song deleted from the database.");
			}
		}
	}

	@Override
	public void addSong() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printSong(Song song) {
		if (song != null) {
			System.out.println("songID: " + song.getSongID() 
					+ ", title: " + song.getTitle() 
					+ ", artist: " + song.getArtist() 
					+ ", album: " + song.getAlbum()
					+ ", year released: " + song.getYearReleased());
		} else {
			System.out.println("No song to print.");
		}	
	}

}
