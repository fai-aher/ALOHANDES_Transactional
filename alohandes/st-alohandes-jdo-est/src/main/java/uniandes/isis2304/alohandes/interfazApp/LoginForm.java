package uniandes.isis2304.alohandes.interfazApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class LoginForm extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginForm() {
        setTitle("Inicio de sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        
        // Crear componentes
        JLabel usernameLabel = new JLabel("Usuario:");
        JLabel passwordLabel = new JLabel("Contraseña:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);

        loginButton = new JButton("Ingresar");
        JButton closeButton = new JButton("Cerrar");
        closeButton.setSize(new Dimension(200,30));

        // Crear panel de contenido
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(3, 2));
        contentPane.add(usernameLabel);
        contentPane.add(usernameField);
        contentPane.add(passwordLabel);
        contentPane.add(passwordField);
        contentPane.add(loginButton);
        contentPane.add(closeButton);

        // Agregar panel de contenido al frame
        setContentPane(contentPane);

        // Agregar acción al botón de cerrar
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
		            }
		        });
		    }  	
    
	//Getters:
    
    public JButton getBotonIngresar() {
        return loginButton;
    }

    public JTextField getUsuarioTextField() {
        return usernameField;
    }

    public JPasswordField getClavePasswordField() {
        return passwordField;
    }  

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LoginForm loginForm = new LoginForm();
                loginForm.setVisible(true);
            }
        });
    }
}
