/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package rebound;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


/**
 *
 * @author stimpy
 */
public class Rebound {
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Rebound");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                frame.add(new ReboundPanel());
                
                frame.setResizable(false);
                frame.pack();
                frame.setVisible(true);
                
                System.out.println(frame.getInsets().top);
                System.out.println(frame.getInsets().right);
                System.out.println(frame.getInsets().left);
                System.out.println(frame.getInsets().bottom);

                System.out.println(frame.getWidth());
                System.out.println(frame.getHeight());
                
                
            }
        });
        
    }
    
}
