/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.*;

/**
 *
 * @author sLaDer_pH
 */
public class LoginWindow extends JFrame {
    
    JTextField email;
    JPasswordField password;
    
    
    public LoginWindow() {
        super();
        
        setTitle("Page de connexion"); // Set title of window.
        setVisible(true); // Make window visible.
        setResizable(false); // Disable resizing of window.

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close programm on closing window.
      
        createGUI();
        
        pack();
        setSize(1400, 900); // Set size of window.
        setLocationRelativeTo(null); // Set window in center of screen.
    }
    
    private void createGUI() {
        JPanel pane = new JPanel(new GridBagLayout());
        GridBagConstraints cons = new GridBagConstraints();
        
        this.getContentPane().add(pane);
        
        cons.weightx = 0.5;
        cons.anchor = GridBagConstraints.CENTER;
        
        // Create logo.
        cons.gridx = 0; 
        cons.gridy = 0;
        cons.gridwidth = 1;
        JLabel label = new JLabel(new ImageIcon(LoginWindow.class.getResource("/projet/images/ece_logo.png")));
        pane.add(label, cons);
        
        // Create mail zone.
        cons.gridx = 0;
        cons.gridy = 1;
        cons.gridwidth = 1;
        cons.insets = new Insets(100, 1, 20, 1);
        JPanel p = new JPanel();
        label = new JLabel("Email : ");
        label.setFont(new Font(this.getFont().getName(), Font.PLAIN, 30));
        JTextField txt = new JTextField(25);
        email = txt;
        txt.setFont(new Font(this.getFont().getName(), Font.PLAIN, 30));
        p.add(label);
        p.add(txt);
        pane.add(p, cons);
        
        // Create password zone.
        cons.gridx = 0;
        cons.gridy = 2;
        cons.gridwidth = 1;
        cons.insets = new Insets(50, 1, 20, 1);
        p = new JPanel();
        label = new JLabel("Mot de passe : ");
        label.setFont(new Font(this.getFont().getName(), Font.PLAIN, 30));
        final JPasswordField pass = new JPasswordField(25);
        password = pass;
        pass.setFont(new Font(this.getFont().getName(), Font.PLAIN, 30));
        JButton display = new JButton("Afficher mot de passe");
        display.setFont(new Font(this.getFont().getName(), Font.PLAIN, 20));
        
        display.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(LoginWindow.this, "Le mot de passe est : " + new String(password.getPassword()));
        });
        
        p.add(label);
        p.add(pass);
        p.add(display);
        pane.add(p, cons);
        
        // Create validation button and forgot password link.
        cons.gridy = 3;
        JButton btn = new JButton("Connexion");
        btn.setFont(new Font(this.getFont().getName(), Font.PLAIN, 30));
        pane.add(btn, cons);
        
        btn.addActionListener((ActionEvent e) -> {
            boolean ok = false;
            
            String id = email.getText();
            String ps = new String(password.getPassword());
            
            // Test if id and password are correct.
            ok = true;
            
            if (ok) {
                MainWindow win = new MainWindow();
                this.setVisible(false);
                dispose();
            } else {
                JOptionPane.showMessageDialog(LoginWindow.this, "Email et/ou mot de passe incorrect !");
                password.setText("");
                email.setText("");
            }
        });
        
        cons.insets = new Insets(1, 1, 20, 1);
        cons.gridy = 4;
        btn = new JButton("Mot de passe oublié");
        btn.setFont(new Font(this.getFont().getName(), Font.PLAIN, 20));
        
        btn.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(LoginWindow.this, "Tant pis pour toi !");
        });
        
        pane.add(btn, cons);
    }
    
}
