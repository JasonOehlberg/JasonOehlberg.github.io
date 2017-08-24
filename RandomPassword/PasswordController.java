
import java.awt.event.*;
import javax.swing.*;

public class PasswordController implements ActionListener, ItemListener, WindowListener{
	
	private PasswordModel pm;
	private PasswordView pv;
	
	public PasswordController( PasswordModel pm, PasswordView pv ){
		this.pm = pm;
		this.pv = pv;
		pv.setController( this );
	}
	
	// window methods
	public void windowDeactivated(WindowEvent we){
		
	}
	
	public void windowActivated(WindowEvent we){
		
	}
	
	public void windowDeiconified(WindowEvent we){
		
	}
	
	public void windowIconified(WindowEvent we){
		
	}
	
	public void windowClosed(WindowEvent we){
		
	}
	
	public void windowClosing(WindowEvent we){
		// gives the user options before exiting the window
		int userInput = JOptionPane.showConfirmDialog(
			pv,
			"Please make sure to write down the password before closing.",
			"Are you sure you want to close?",
			JOptionPane.YES_NO_OPTION
		);
		if( userInput == JOptionPane.YES_OPTION ){
			System.exit( 0 );
		}
	}
	
	public void windowOpened(WindowEvent we){
		
	}// end of window methods
	
	public void actionPerformed( ActionEvent ae ){
		// sets the size if buttons pushed
		pm.setSize( pv.selectSize() );
		// updates the field based on selections
		pv.updateP( pm.toString() );
	}
	
	public void itemStateChanged( ItemEvent ie ){
		// sets the caps, nums and special characters when buttons is pushed
		pm.setCaps( pv.selectCaps() );
		pm.setNums( pv.selectNums() );
		pm.setSpec( pv.selectSpecial() );
		
		
	}
	
	
}