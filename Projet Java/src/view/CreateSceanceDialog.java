/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author sLaDer_pH
 */
public class CreateSceanceDialog extends JDialog {
    
    public CreateSceanceDialog(JFrame owner) {
        super(owner, JDialog.ModalityType.APPLICATION_MODAL);
        
        this.setTitle("Creation de seance");
       
        createGUI();
        
        this.pack();
        this.setSize(800, 800);
        this.setLocationRelativeTo(null); // Set window in center of screen.
        this.setResizable(false);
        this.setVisible(true);
        
    }
    
    private void createGUI() {
        JPanel pane = new JPanel(new GridBagLayout());
        GridBagConstraints cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.weightx = 0.5;
        cons.gridy = 0;
        
        this.getContentPane().add(pane);
        
        // Semaine.
        JPanel p = new JPanel();
        JLabel label = new JLabel("Semaine : ");
        JTextField txt = new JTextField(5);
        label.setFont(new Font(this.getFont().getName(), Font.PLAIN, 20));
        txt.setFont(new Font(this.getFont().getName(), Font.PLAIN, 20));
        
        p.add(label);
        p.add(txt);
        pane.add(p, cons);
        
        // Date.
        cons.gridy = 1;
        p = new JPanel();
        label = new JLabel("Date (jj/mm/aaaa) : ");
        txt = new JTextField(5);
        label.setFont(new Font(this.getFont().getName(), Font.PLAIN, 20));
        txt.setFont(new Font(this.getFont().getName(), Font.PLAIN, 20));
        
        p.add(label);
        p.add(txt);
        pane.add(p, cons);
        
        // Hours.
        cons.gridy = 2;
        String[] hours = {"08h30 - 10h00", "10h15 - 11h45", "12h00 - 13h30", "13h45 - 15h15", "15h30 - 17h00", "17h15 - 18h45", "19h00 - 20h30"};
        p = new JPanel();
        label = new JLabel("Heures : ");
        JComboBox box = new JComboBox();
        
        for (String str : hours) {
            box.addItem(str);
        }
        
        label.setFont(new Font(this.getFont().getName(), Font.PLAIN, 20));
        box.setFont(new Font(this.getFont().getName(), Font.PLAIN, 20));
        
        p.add(label);
        p.add(box);
        pane.add(p, cons);
        
        // Hours.
        cons.gridy = 2;
        p = new JPanel();
        label = new JLabel("Heures : ");
        box = new JComboBox();
        
        for (String str : hours) {
            box.addItem(str);
        }
        
        label.setFont(new Font(this.getFont().getName(), Font.PLAIN, 20));
        box.setFont(new Font(this.getFont().getName(), Font.PLAIN, 20));
        
        p.add(label);
        p.add(box);
        pane.add(p, cons);
    }
    
}
