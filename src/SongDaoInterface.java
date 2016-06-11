import java.sql.SQLException;
import java.util.ArrayList;


public interface SongDaoInterface {
	
	//method to get all songs
	public ArrayList<Song> getSongs() throws SQLException;
	
	//method to get a specific song
	public Song getSong(int songID) throws SQLException;
	
	//method to update a specific song
	public void updateSong(Song song) throws SQLException;
	
	//method to delete a specific song
	public void deleteSong(Song song) throws SQLException;
	
	//method to add a song
	public void addSong() throws SQLException;
	
	//method to print a specific song
	public void printSong(Song song);
	
}
