/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postossm;

import javax.swing.SwingUtilities;
import postossm.view.PostossmView;

/**
 *
 * @author Rafa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
	    public void run() {
		new PostossmView().setVisible(true);
	    }
	});
        // TODO code application logic here
    }
    
}
