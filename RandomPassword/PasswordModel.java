
import java.util.Random;

// the model class 
public class PasswordModel{

	// attributes of the model
	private int size;
	private boolean caps;
	private boolean specChar;
	private boolean nums;
	private char[] cRay;
	
	// strings to iterate throught to make random password
	private static String alpha = "abcdefghijklmnopqrstuvwxyz";
	private static String numbers = "0123456789";
	private static String alphaCaps = "ABCDEFGHIJKLMONPQRSTUVWXYZ";
	private static String specials = "!@#$%&";
	
	// default constructor
	public PasswordModel(){
		size = 8;
		caps = false;
		specChar = false;
		nums = false;
		cRay = new char[ size ];
		
	}
	
	// * setters and getters for attributes of the PasswordModel object
	public void setSize( int size ){
		this.size = size;
	}
	
	public int getSize(){
		return size;
	}
	
	public void setCaps( boolean caps ){
		this.caps = caps;
	}
	
	public boolean getCaps(){
		return caps;
	}
	
	public void setNums( boolean nums ){
		this.nums = nums;
	}
	
	public boolean getNums(){
		return nums;
	}
	
	public void setSpec( boolean specChar ){
		this.specChar = specChar;
	}
	
	public boolean getSpec(){
		return specChar;
	} // end setters and getters
	
	// generates a random password based on size, caps, special chars and numbers
	public String generate(){
		String temp = "";
		temp = alpha;
		Random rnd = new Random();
		cRay = new char[ size ];
		
		if( caps == true ){
			temp += alphaCaps;
		}
		if( nums == true ){
			temp += numbers;
		}
		if( specChar == true ){
			temp += specials;
		}
		for( int i = 0; i < getSize(); i++){
			cRay[ i ] = temp.charAt( rnd.nextInt( temp.length() ) ); 
		}
		String x = new String( cRay );
		return x;
		
		
	}
	
	// to String
	public String toString(){
		
		return generate();
	}
	
}