import java.sql.SQLException;
import java.util.ArrayList;


public class SongDaoDemo {

	public static void main(String[] args) throws SQLException {
		SongDAOConcrete songDAO = new SongDAOConcrete();
		
		System.out.println("Welcome! Enter password if you are admin: ");
		java.util.Scanner input = new java.util.Scanner(System.in);
		String psw = input.nextLine();
		
		if(psw.equals("admin")){
			int choice=6;
			do{
				System.out.println("Press 0 to see all songs\n 1 to see one specific song:"
						+ "\n 2 to update specific song"
						+ "\n 3 to delete specific song"
						+ "\n 4 to add specific song"
						+ "\n 5 to exit");
				
				choice = input.nextInt();
				
				switch (choice){
					case 0:
						//get all songs
						ArrayList<Song> songs = songDAO.getSongs();
	
						//print all songs
						for (Song e : songs) {
							songDAO.printSong(e);
						}
	
						break;
					case 1:
						System.out.println("Enter the id of the song: ");
						int id = input.nextInt();
						//print song
						songDAO.printSong(songDAO.getSong(id));
						break;
					case 2:
						System.out.println("Enter the id of the song: ");
						id = input.nextInt();
						//update song
						songDAO.updateSong(songDAO.getSong(id));	
						break;
					case 3:
						System.out.println("Enter the id of the song: ");
						id = input.nextInt();
						//delete song
						songDAO.deleteSong(songDAO.getSong(id));
						break;
					case 4:
						//add a song
						songDAO.addSong();
						break;
					case 6:
						System.out.println("Goodbye");
						break;
					default:
						System.out.println("Wrong input");
				}
				
			}while(choice!=5);
		}else{
			int choice=3;
			while(choice!=2){
				System.out.println("Press 0 to see all songs"
						+ "\n 1 to to see one specific song"
						+ "\n 2 to exit");
				
				choice = input.nextInt();
				switch (choice){
					case 0:
						//get all songs
						ArrayList<Song> songs = songDAO.getSongs();
	
						//print all songs
						for (Song e : songs) {
							songDAO.printSong(e);
						}
						break;
					case 1:
						System.out.println("Enter the id of the song: ");
						int id = input.nextInt();
						//print song
						songDAO.printSong(songDAO.getSong(id));
						break;
					case 2:
						System.out.println("Goodbye");
						break;
					default:
						System.out.println("Wrong input");
				}
			}
		}
		input.close();
		//close the connection
		ConnectionManager.getInstance().close();

	}

}
