package a9;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;

import javax.swing.*;

class LoginFrame extends JDialog {
	
    private static LoginFrame v;
  //  JFrame parent;
    public static LoginFrame V(JFrame parent) {
    	if (v == null)
    		v = new LoginFrame(parent);
    	return v;
    }
    private final JLabel lblUsername = new JLabel("Username");
    private final JLabel lblPassword = new JLabel("Password");

    private final JTextField txtUsername = new JTextField(15);
    private final JPasswordField txtPassword = new JPasswordField();

    private final JButton btnLogin = new JButton("Login");
    private final JButton btnCancel = new JButton("Cancel");
    


    LoginFrame() {
        this(null);
    }

    private LoginFrame(final JFrame parent) {
        super(parent, "Log in window");
       
       //code for creating the frame needed here...
             
        JPanel userInfo = new JPanel(new GridLayout(2,1));
        userInfo.add(lblUsername);
        userInfo.add(txtUsername);
        userInfo.add(lblPassword);
        userInfo.add(txtPassword);
        
        JPanel options = new JPanel(new FlowLayout());
        options.add(btnLogin);
        options.add(btnCancel);
        
        add(userInfo, BorderLayout.NORTH);
        add(options, BorderLayout.CENTER);
    	
        setSize(200,150);
		setLocationRelativeTo(null); 
		setVisible(false);
		
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//note how we get the password text from JTextPassword
            	String strPassword = String.valueOf(txtPassword.getPassword());
            	String strUsername = txtUsername.getText().trim();
                
                if (verifyLogin(strUsername, strPassword)) {
                    parent.setVisible(true);
                    ((MainWindow) parent).endableAll(); 
                    setVisible(false);
                } else {
                	JOptionPane.showMessageDialog(null, "Incorrect username/password", "Login", JOptionPane.ERROR_MESSAGE );
                }
            }

			private boolean verifyLogin(String strPassword, String strPass) {
				//write the logic here
				if (strPassword.equalsIgnoreCase("healthy") && strPass.equalsIgnoreCase("donut")) {
					return true;
				}
				return false;
			}
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	txtPassword.setText("");
            	txtUsername.setText("");
                setVisible(false);
            }
        });
    }	
}
