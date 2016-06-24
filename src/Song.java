public class Song {
	private int songID;
	private String title;
	private String artist;
	private String album;
	private int year_released;
	
	public Song(int songID, String title, String artist, String album,
			int year_released) {
		super();
		this.songID = songID;
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.year_released = year_released;
	}
	
	public int getSongID() {
		return songID;
	}

	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}

	public String getAlbum() {
		return album;
	}

	public int getYearReleased() {
		return year_released;
	}

}
