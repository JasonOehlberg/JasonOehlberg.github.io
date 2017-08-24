public class RandPassword{
	
	public static void main( String[] args ){
		
		// sets instances of the MVC and runs the program
		PasswordModel m = new PasswordModel();
		PasswordView v = new PasswordView();
		PasswordController c = new PasswordController( m, v );
		
	}
	
}