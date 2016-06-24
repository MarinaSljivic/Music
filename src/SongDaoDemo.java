import java.sql.SQLException;
import java.util.ArrayList;


public class SongDaoDemo {

	public static void main(String[] args) throws SQLException {
		SongDAOConcrete songDAO = new SongDAOConcrete();

		//get all songs
		ArrayList<Song> songs = songDAO.getSongs();

		//print all songs
		for (Song e : songs) {
			songDAO.printSong(e);
		}
		
		//print song
		songDAO.printSong(songDAO.getSong(1));
		
		//update song
		songDAO.updateSong(songDAO.getSong(3));	
		
		//delete song
		songDAO.deleteSong(songDAO.getSong(1));
		
		//add a song
		songDAO.addSong();
		
		//close the connection
		ConnectionManager.getInstance().close();

	}

}
