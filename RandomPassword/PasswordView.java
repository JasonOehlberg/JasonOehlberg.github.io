import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PasswordView extends JFrame{
	
	private JButton btn;
	private JRadioButton eight;
	private JRadioButton sixteen;
	private JRadioButton twentyFour;
	private JRadioButton thirtyTwo;
	private JCheckBox specialChar;
	private JCheckBox nums;
	private JCheckBox caps;
	private JTextField txt;
	
	public PasswordView(){
		super( "Random Password" );
		
		Font h = new Font( "Helvetica", Font.PLAIN, 18 );
		Color c = Color.decode( "#E1E8E7" );
		
		// instances of the buttons and field
		txt = new JTextField( "Push button for random password", 32 );
		txt.setHorizontalAlignment( JTextField.CENTER );
		txt.setFont( new Font( Font.SANS_SERIF,Font.BOLD, 20 ) );

		btn = new JButton( "Generate Password" );
		eight = new JRadioButton( "8 Characters", true );
		sixteen = new JRadioButton( "16 Characters", false );
		twentyFour = new JRadioButton( "24 Characters", false );
		thirtyTwo = new JRadioButton( "32 Characters", false );
		
		// font and background color
		eight.setFont( h );
		sixteen.setFont( h );
		twentyFour.setFont( h );
		thirtyTwo.setFont( h );
		eight.setBackground( c );
		sixteen.setBackground( c );
		twentyFour.setBackground( c );
		thirtyTwo.setBackground( c );
		btn.setFont( h );
		txt.setBackground( c );
		
		
		// button group for my radio buttons
		ButtonGroup rbg = new ButtonGroup();
		rbg.add( eight );
		rbg.add( sixteen );
		rbg.add( thirtyTwo );
		rbg.add( twentyFour );
		
		JPanel radBox = new JPanel();
		radBox.setLayout( new GridLayout( 4, 1 ) );
		// setting borders for the JPanel
		radBox.setBorder( BorderFactory.createLineBorder( Color.black) );
		radBox.add( eight );
		radBox.add( sixteen );
		radBox.add( twentyFour );
		radBox.add( thirtyTwo );
		
		
		
		// instances of check boxes
		specialChar = new JCheckBox( "Special Characters" );
		nums = new JCheckBox( "Numbers" );
		caps = new JCheckBox( "Capitals" );
		
		// fonts and background
		nums.setFont( h );
		caps.setFont( h );
		specialChar.setFont( h );
		nums.setBackground( c );
		caps.setBackground( c );
		specialChar.setBackground( c );
		
		// JPanel for check boxes
		JPanel chBox = new JPanel();
		chBox.setLayout( new GridLayout( 3, 1 ) );
		// setting borders for the JPanel
		chBox.setBorder( BorderFactory.createLineBorder( Color.black ));
		chBox.add( nums );
		chBox.add( caps );
		chBox.add( specialChar );
		
		JPanel buttons = new JPanel();
		buttons.setLayout( new BorderLayout( 3, 3 ) );
		buttons.add( chBox, BorderLayout.EAST );
		buttons.add( radBox, BorderLayout.WEST );
		
		// layout
		setLayout( new FlowLayout( FlowLayout.CENTER, 10 , 40 )  );
		add( txt );
		add( buttons );
		add( btn );
		
		setSize( 500, 450 );
		setResizable( false );
		setBackground( Color.BLUE );
		setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE );
		setVisible( true );
	}
	
	public void setController( PasswordController pc ){
		// connecting to the controller
		btn.addActionListener( pc );
		nums.addItemListener( pc );
		specialChar.addItemListener( pc );
		caps.addItemListener( pc );
		addWindowListener( pc );
	}
	
	// method sets txt in the field box
	public void updateP( String x ){
		txt.setText( x );
	}
	
	// method sets caps to true if selected
	public boolean selectCaps(){
		boolean x = false;
		if( caps.isSelected() )
			x = true;
		return x;
	}
	
	// mehtod sets special characters to true if selected
	public boolean selectSpecial(){
		boolean x = false;
		if( specialChar.isSelected() )
			x = true;
		return x;
	}
	
	// method sets numbers to true if selected
	public boolean selectNums(){
		boolean x = false;
		if( nums.isSelected() )
			x = true;
		return x;
	}
	
	// methods sets the size of password with the radio buttons
	public int selectSize(){
		int x = 0;
		if( eight.isSelected() )
			x = 8;
		else if( sixteen.isSelected() )
			x = 16;
		else if( twentyFour.isSelected() )
			x = 24;
		else if( thirtyTwo.isSelected() )
			x = 32;
		return x;
	}
}