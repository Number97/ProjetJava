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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author sLaDer_pH
 * 
 */
public class MainWindow extends JFrame {
    
    boolean planningModeList = false;
    JPanel mainPane;
    
    public MainWindow() {
        super();
        
        setTitle("Planning"); // Set title of window.
        setVisible(true); // Make window visible.
        setResizable(false); // Disable resizing of window.

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close programm on closing window.
        
        createMenu();
        //createPlanningZone();
        createLayouts();
        
        pack();
        setSize(1400, 900); // Set size of window.
        setLocationRelativeTo(null); // Set window in center of screen.
    }
    
    private void createLayouts() {
        JPanel pane = new JPanel(new GridBagLayout());
        mainPane = pane;
        this.getContentPane().add(pane);
        
        GridBagConstraints cons = new GridBagConstraints();
        cons.weightx = 0.5; // Avoid components being clumped together.
        cons.anchor = GridBagConstraints.CENTER;
        
        createChoiceZone(cons, pane);
        createWeekButtons(cons, pane);
        createPlanningZone(cons, pane);
        
    }
    
    private void createPlanningZone(GridBagConstraints cons, JPanel pane) {
        if (planningModeList == false) {
            createDayNamesZone(cons, pane);
            createHoursZone(cons, pane);
            createAllClasses(cons, pane);
        } else {
            createAllClassesList(cons, pane);
        }
    }
    
    private void createAllClassesList(GridBagConstraints cons, JPanel pane) {
        // Create all classes in a list.
        cons.insets = new Insets(0, 0, 0, 0);
        cons.weighty = 0.5;
        cons.gridy = 3;
        cons.gridx = 0;
        cons.gridwidth = 3;
        
        String[] days = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"};
        String[] hours = {"08h30 - 10h00", "10h15 - 11h45", "12h00 - 13h30", "13h45 - 15h15", "15h30 - 17h00", "17h15 - 18h45", "19h00 - 20h30"};
        String[] strs = {"Anglais", "Cours", "ANNULE", "Mr. Segado", "TD03 - Groupe A"};
        
        for (int i = 0; i < 3; i++) { // Each day.
            JPanel day_pane = new JPanel(new GridBagLayout());
            GridBagConstraints day_cons = new GridBagConstraints();
            day_cons.gridx = 0;
            day_cons.gridy = 0;
            
            cons.gridy = i + 3;
            
            JPanel p = new JPanel();
            JLabel label = new JLabel(days[i]);
            p.add(label);
            p.setBackground(Color.green);
            p.setBorder(BorderFactory.createLineBorder(Color.black));
            day_pane.add(p, day_cons);
            
            for (int j = 0; j < 7; j++) { // Each period of 1h30.
                day_cons.gridy = j + 1;
                
                p = new JPanel(new GridBagLayout());
                GridBagConstraints hour_cons = new GridBagConstraints();
                hour_cons.gridx = 0;
                hour_cons.gridy = 0;
                hour_cons.insets = new Insets(0, 10, 0, 0);
                label = new JLabel(hours[j]);
                p.add(label, hour_cons);
                
                for (int k = 0; k < 5; k++) {
                    hour_cons.gridx = k + 1;
                    label = new JLabel(strs[k]);
                    p.add(label, hour_cons);
                }
                p.setBorder(BorderFactory.createLineBorder(Color.black));
                
                if (j % 2 == 0) {
                    p.setBackground(Color.LIGHT_GRAY);
                } else {
                    p.setBackground(Color.GRAY);
                }
                
                day_pane.add(p, day_cons);
            }
            
            pane.add(day_pane, cons);
        }
        
        for (int i = 0; i < 3; i++) { // Each day.
            JPanel day_pane = new JPanel(new GridBagLayout());
            GridBagConstraints day_cons = new GridBagConstraints();
            day_cons.gridx = 0;
            day_cons.gridy = 0;
            
            cons.gridy = i + 3;
            cons.gridx = 4;
            
            JPanel p = new JPanel();
            JLabel label = new JLabel(days[i + 3]);
            p.add(label);
            p.setBackground(Color.green);
            p.setBorder(BorderFactory.createLineBorder(Color.black));
            day_pane.add(p, day_cons);
            
            for (int j = 0; j < 7; j++) { // Each period of 1h30.
                day_cons.gridy = j + 1;
                
                p = new JPanel(new GridBagLayout());
                GridBagConstraints hour_cons = new GridBagConstraints();
                hour_cons.gridx = 0;
                hour_cons.gridy = 0;
                hour_cons.insets = new Insets(0, 10, 0, 0);
                label = new JLabel(hours[j]);
                p.add(label, hour_cons);
                
                for (int k = 0; k < 5; k++) {
                    hour_cons.gridx = k + 1;
                    label = new JLabel(strs[k]);
                    p.add(label, hour_cons);
                }
                p.setBorder(BorderFactory.createLineBorder(Color.black));
                
                if (j % 2 == 0) {
                    p.setBackground(Color.LIGHT_GRAY);
                } else {
                    p.setBackground(Color.GRAY);
                }
                
                day_pane.add(p, day_cons);
            }
            
            pane.add(day_pane, cons);
        }
        cons.gridwidth = 1;
    }
    
    private void createAllClasses(GridBagConstraints cons, JPanel pane) {
      // Create all classes. x1:6 - y3:9  
      cons.insets = new Insets(0, 0, 0, 0); // Padding.
      
      String[] strs = {"", "Anglais", "Cours", "ANNULE", "Mr. Segado", "TD03 - Groupe A"};
      for (int x = 0; x < 6; x++) { // Each day.
          
          for (int y = 3; y < 10; y++) { // Each period of 1h30.
              
              JPanel p = new JPanel(new GridBagLayout());
              GridBagConstraints c = new GridBagConstraints();
              cons.gridx = x + 1;
              cons.gridy = y;
              cons.gridheight = 1;
              cons.gridwidth = 1;
              c.gridx = 0;
              c.fill = GridBagConstraints.HORIZONTAL;
              
              for (int i = 0; i < 6; i++) {
                  c.gridy = i;
                  JLabel label = new JLabel(strs[i]);
                  p.add(label, c);
              }
              p.setBorder(BorderFactory.createLineBorder(Color.black));
              pane.add(p, cons);
          }
          
      }
      
    }
    
    private void createHoursZone(GridBagConstraints cons, JPanel pane) {
        // Create zone for hours. x0 - y3:9.
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 3;
        cons.insets = new Insets(0, 0, 0, 0); // Padding.
        cons.gridwidth = 1;
        
        String[] hours = {"08h30 - 10h00", "10h15 - 11h45", "12h00 - 13h30", "13h45 - 15h15", "15h30 - 17h00", "17h15 - 18h45", "19h00 - 20h30"};
        
        for (int i = 0; i < 7; i++) {
            cons.gridy = i + 3;
            
            JPanel p = new JPanel(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            c.gridx = 0;
            
            for (int j = 0; j < 5; j++) {
                JLabel label;
                c.gridy = j;
                c.fill = GridBagConstraints.HORIZONTAL;
                
                if (j == 2) {
                    label = new JLabel(hours[i]);
                } else {
                    label = new JLabel(" ");
                }
                
                p.add(label, c);
                
            }
            
//            p.setBackground(Color.yellow);
            p.setBorder(BorderFactory.createLineBorder(Color.black));
            pane.add(p, cons);
        }
    }
    
    private void createDayNamesZone(GridBagConstraints cons, JPanel pane) {
        // Create zone for names of the days. y2.
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 2;
        cons.insets = new Insets(20, 0, 0, 0); // Padding.
        cons.gridwidth = 1;
        
        String[] days = {" ", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"};
        for (int i = 0; i < 7; i++) {
            JPanel p = new JPanel(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
        //        c.insets = new Insets(1, 50, 1, 50); // Padding.
//            p.setBackground(Color.GREEN);
            
            c.gridx = i;
            c.gridy = 0;
            cons.gridx = i;
            JPanel place = new JPanel();
            JLabel label = new JLabel(days[i]);
            label.setFont(new Font("Arial", Font.PLAIN, 20));
            
            place.add(label);
            p.add(place, c);
            
            c.gridy = 1;
            place = new JPanel();
            
            if (i != 0) {
                label = new JLabel("31/12/2020");
            } else {
                label = new JLabel(" ");
            }
            place.add(label);
            p.add(place, c);
            
            p.setBorder(BorderFactory.createLineBorder(Color.black));
            pane.add(p, cons);
        }
    }
    
    private void createWeekButtons(GridBagConstraints cons, JPanel pane) {
        // Create Buttons for weeks. y1.
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 1;
        cons.insets = new Insets(1, 1, 1, 1); // Padding.
        cons.gridwidth = 7;
        JPanel p = new JPanel(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(1, 1, 1, 1); // Padding.
        for (int i = 0; i < 52; i++) {
            c.gridx = i;
            c.gridy = 0;
            JButton btn = new JButton();
            btn.setText(Integer.toString(i + 1));
            btn.setMargin(new Insets(1, 2, 1, 2));
            btn.setVisible(true);
            System.out.println(i);
            System.out.println(btn);
            p.add(btn, c);
        }
        pane.add(p, cons); // Add to panel.
    }
    
    private void createChoiceZone(GridBagConstraints cons, JPanel pane) {
        // x0 - y0.
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridwidth = 2;
        cons.gridx = 0;
        cons.gridy = 0;
        cons.insets = new Insets(50, 50, 50, 50); // Padding of 50 everywhere.
        
        JPanel p = new JPanel(); // Panel.
        JLabel label = new JLabel("Type d'affichage : "); // Label.
        label.setVisible(true);
        p.add(label); // Add label to panel.
        final JComboBox box = new JComboBox();
        box.addItem("En grille");
        box.addItem("En liste");
        
        if (this.planningModeList == true) {
            box.setSelectedIndex(1);
        }
        
        box.addActionListener((ActionEvent e) -> {
            if ("En grille".equals(box.getSelectedItem().toString())) { // Mode grid.
                planningModeList = false;
            } else {
                planningModeList = true;
            }
            
            this.remove(this.mainPane);
            this.createLayouts();
            
            this.revalidate();
            this.repaint();
        });
        
        p.add(box);
        
        
        pane.add(p, cons); // Add to panel.
        
        // x1 - y0.
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 2;
        cons.gridy = 0;
        
        p = new JPanel(); // Panel.
        label = new JLabel("Trier par salles : "); // Label.
        label.setVisible(true);
        p.add(label); // Add label to panel.
        JComboBox bbox = new JComboBox();
        bbox.addItem("P345");
        bbox.addItem("P340");
        p.add(bbox);
        
        pane.add(p, cons); // Add to panel.
        
        // x2 - y0.
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 4;
        cons.gridy = 0;
        
        p = new JPanel(); // Panel.
        label = new JLabel("Trier par profs : "); // Label.
        label.setVisible(true);
        p.add(label); // Add label to panel.
        bbox = new JComboBox();
        bbox.addItem("Mr. Segado");
        bbox.addItem("Mr. Dupont");
        p.add(bbox);
        
        pane.add(p, cons); // Add to panel.
    }
    
    private void createMenu() {
        JMenuBar menubar = new JMenuBar();
        this.setJMenuBar(menubar);

        // OPTIONS.
        JMenu m = new JMenu("Options");
        menubar.add(m);
        
        JMenuItem mmi = new JMenuItem("Déconnexion");
        
        mmi.addActionListener((ActionEvent e) -> {
            try {
                LoginWindow log = new LoginWindow();
            } catch (SQLException ex) {
                System.out.println("Erreur sql !");
            }
            this.setVisible(false);
            dispose();
        });
        
        m.add(mmi);
        
        // COURS.
        JMenu menu = new JMenu("Cours");
        menubar.add(menu);

        JMenuItem mi = new JMenuItem("Emploi du temps");
        menu.add(mi);
        mi = new JMenuItem("Récapitulatif des cours");
        menu.add(mi);
        
        // VIE SCOLAIRE.
        menu = new JMenu("Vie scolaire");
        menubar.add(menu);
        
        mi = new JMenuItem("Relevé d'absences");
        menu.add(mi);
        mi = new JMenuItem("Liste d'intervenants");
        menu.add(mi);
        mi = new JMenuItem("Scolarité");
        menu.add(mi);
        mi = new JMenuItem("Calendrier scolaire");
        menu.add(mi);
        
        // PROMOTIONS.
        menu = new JMenu("Promotions");
        menubar.add(menu);
        
        mi = new JMenuItem("Intervenants");
        menu.add(mi);
        
        // SALLES.
        menu = new JMenu("Salles");
        menubar.add(menu);
        
        mi = new JMenuItem("Emploi du temps");
        menu.add(mi);
        mi = new JMenuItem("Salles libres");
        menu.add(mi);
    }
    
}
