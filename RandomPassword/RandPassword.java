
public class RandPassword{
	
	public static void main( String[] args ){
		
		// sets instances of the MVC and runs the program
		PasswordView v = new PasswordView();
		PasswordModel m = new PasswordModel();
		PasswordController c = new PasswordController( m, v );
		
	}
	
}