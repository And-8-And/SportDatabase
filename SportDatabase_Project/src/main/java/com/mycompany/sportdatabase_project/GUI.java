package com.mycompany.sportdatabase_project;

import java.util.List;

public class GUI extends javax.swing.JFrame 
{
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GUI.class.getName());
    
    public GUI() 
    {
        initComponents();
        loadSports();
    }
    
    private void loadSports()
    {
        jComboBox1.removeAllItems();
        
        List<Types_Of_Sports> sports = Api.getTypesOfSports();
        for (int i = 0; i < sports.size(); i++)
        {
            jComboBox1.addItem(sports.get(i).getName());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel1.setText("League Information");

        jLabel2.setText("Match  Information");

        jButton1.setText("Show Leagues");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Search");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel3.setText("Search Bar");

        jButton5.setText("Guide");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jComboBox1, 0, 120, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jTextField2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(157, 157, 157))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(169, 169, 169))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jButton5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String sport = jComboBox1.getSelectedItem().toString();
        
        jTextArea1.setText("");
        
        if (sport.equals("Soccer"))
        {
            List<League> leagues = Api.getSoccerLeagues();
            for (int i = 0; i < leagues.size(); i++)
            {
                League l = leagues.get(i);
                
                jTextArea1.append("League: " + l.getName() + ", Year: " + l.getSeason() + "\n");
            }
        }
        else if (sport.equals("Handball"))
        {
            List<League> leagues = Api.getHandballLeagues();
            for (int i = 0; i < leagues.size(); i++)
            {
                League l = leagues.get(i);
                
                jTextArea1.append("League: " + l.getName() + ", Year: " + l.getSeason() + "\n");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTextArea1.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String sport = jComboBox1.getSelectedItem().toString();
        String leagueName = jTextField1.getText().trim();
        
        String searchInput = jTextField1.getText().trim();
        
        jTextArea1.setText("");
        
        if (leagueName.isEmpty())
        {
            jTextArea1.setText("Please, type a league name");
            
            return;
        }
        
        String[] parts = searchInput.split(" ");
        
        if (parts.length < 2) 
        {
            jTextArea1.setText("Please, include both league name and season (e.g. 'Premier League 2024')");
            
            return;
        }
        
        String seasonPart = parts[parts.length - 1];
        String leagueNamePart = searchInput.substring(0, searchInput.lastIndexOf(" ")).trim();
        
        boolean found = false;
        
        if(sport.equals("Soccer")) 
        {
            List<League> leagues = Api.getSoccerLeagues();
            for (int i = 0; i < leagues.size(); i++)
            {
                League l = leagues.get(i);
                               
                if (l.getName().equalsIgnoreCase(leagueNamePart) && String.valueOf(l.getSeason()).equalsIgnoreCase(seasonPart))
                {
                    found = true;
                    
                    jTextArea1.append("===== LEAGUE =====\n\n");
                    jTextArea1.append(l.getName() + " ( " + l.getSeason() + " )\n");
                    
                    jTextArea1.append("\n===== LOCATIONS =====\n\n");
                    List<Location> locations = Api.getSoccerLocations(l.getLeague_id(), String.valueOf(l.getSeason()));
                    for (int j = 0; j < locations.size(); j++)
                    {
                        Location loc = locations.get(j);
                        jTextArea1.append("Stadium: " + loc.getStadium() + " - " + loc.getCity() + " ( " + loc.getCountry() + " )\n");
                    }
                    
                    jTextArea1.append("\n===== TEAMS =====\n\n");
                    List<Team> teams = Api.getSoccerTeams(l.getLeague_id(), String.valueOf(l.getSeason()));
                    for (int k = 0; k < teams.size(); k++)
                    {
                        Team t = teams.get(k);
                        jTextArea1.append(t.getName() + "\n");
                    }
                    
                    break;
                }
            }
        }
        else if (sport.equals("Handball"))
        {
            List<League> leagues = Api.getHandballLeagues();
            for(int i = 0; i < leagues.size(); i++)
            {
                League l = leagues.get(i);
                
                if (l.getName().equalsIgnoreCase(leagueNamePart) && String.valueOf(l.getSeason()).equalsIgnoreCase(seasonPart))
                {
                    found = true;
                    
                    jTextArea1.append("===== LEAGUE =====\n\n");
                    jTextArea1.append(l.getName() + " ( " + l.getSeason() + " )\n");
                    
                    jTextArea1.append("\n===== LOCATIONS =====\n\n");
                    List<Location> locations = Api.getHandballLocations(l.getLeague_id(), l.getSeason());
                    for (int j = 0; j < locations.size(); j++)
                    {
                        Location loc = locations.get(j);
                        jTextArea1.append("Stadium: " + loc.getStadium() + " - " + loc.getCity() + " ( " + loc.getCountry() + " )\n");
                    }
                    
                    jTextArea1.append("\n===== TEAMS =====\n\n");
                    List<Team> teams = Api.getHandballTeams(l.getLeague_id(), l.getSeason());
                    for (int k = 0; k < teams.size(); k++)
                    {
                        Team t = teams.get(k);
                        jTextArea1.append(t.getName() + "\n");
                    }
                    
                    break;
                }
            }
        }
        
        if (!found)
        {
            jTextArea1.setText("No league found with this name or season");
            
            return;
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String sport = jComboBox1.getSelectedItem().toString();
        String leagueName = jTextField1.getText().trim();
        String teamName = jTextField2.getText().trim();
        
        String searchInput = jTextField1.getText().trim();
        
        jTextArea1.setText("");
        
        if (leagueName.isEmpty() || teamName.isEmpty())
        {
            jTextArea1.setText("Please, type an input");
            
            return;
        }

        String[] parts = searchInput.split(" ");
        
        if (parts.length < 2) 
        {
            jTextArea1.setText("Please, include both league name and season (e.g. 'Premier League 2024')");
            
            return;
        }
        
        String seasonPart = parts[parts.length - 1];
        String leagueNamePart = searchInput.substring(0, searchInput.lastIndexOf(" ")).trim();

        boolean found = false;
        boolean matchFound = false;
        
        if (sport.equals("Soccer"))
        {
            List<League> leagues = Api.getSoccerLeagues();
            for (int i = 0; i < leagues.size(); i++)
            {
                League l = leagues.get(i);
                
                if (l.getName().equalsIgnoreCase(leagueNamePart) && String.valueOf(l.getSeason()).equalsIgnoreCase(seasonPart))
                {
                    int played = 0;
                    int wins = 0;
                    int losses = 0;
                    int draws = 0;
                    
                    found = true;
                    
                    jTextArea1.append("===== MATCHES =====\n\n");
                    List<Match> matches = Api.getSoccerMatches(l.getLeague_id(), String.valueOf(l.getSeason()));
                    for (int j = 0; j < matches.size(); j++)
                    {
                        Match m = matches.get(j);
                        
                        if (m.getHomeTeam().getName().equalsIgnoreCase(teamName) || m.getAwayTeam().getName().equalsIgnoreCase(teamName))
                        {
                            matchFound = true;
                            
                            played++;
                            
                            if (m.getHomeScore() > m.getAwayScore()) 
                            {
                                if (m.getHomeTeam().getName().equalsIgnoreCase(teamName)) 
                                {
                                    wins++;
                                }
                                else 
                                {
                                    losses++;
                                }
                            } 
                            else if (m.getHomeScore() < m.getAwayScore()) 
                            {
                                if (m.getAwayTeam().getName().equalsIgnoreCase(teamName)) 
                                {
                                    wins++;
                                }
                                else
                                {
                                    losses++;
                                }
                            }
                            else
                            {
                                draws++;
                            }
                            
                            String line = m.getHomeTeam().getName() + " " + m.getHomeScore() + " - " + m.getAwayScore() + " " + m.getAwayTeam().getName();
                        
                            if (m.getHomeScore() == m.getAwayScore())
                            {
                                line += " (Draw)";
                            }
                        
                            jTextArea1.append(line + "\n");
                        }
                    }
                    
                    if (matchFound) 
                    {
                        jTextArea1.append("\n===== STATS =====\n");
                        jTextArea1.append("Played: " + played + "\n");
                        jTextArea1.append("Wins: " + wins + "\n");
                        jTextArea1.append("Losses: " + losses + "\n");
                        jTextArea1.append("Draws: " + draws + "\n");
                    }
                    
                    break;
                }
            }
        }
        else if (sport.equals("Handball"))
        {
            List<League> leagues = Api.getHandballLeagues();
            for (int i = 0; i < leagues.size(); i++)
            {
                League l = leagues.get(i);
                
                if (l.getName().equalsIgnoreCase(leagueNamePart) && String.valueOf(l.getSeason()).equalsIgnoreCase(seasonPart))
                {
                    int played = 0;
                    int wins = 0;
                    int losses = 0;
                    int draws = 0;
                    
                    found = true;
                    
                    jTextArea1.append("===== MATCHES =====\n\n");
                    List<Match> matches = Api.getHandballMatches(l.getLeague_id(), l.getSeason());
                    for (int j = 0; j < matches.size(); j++)
                    {
                        Match m = matches.get(j);
                        
                        if (m.getHomeTeam().getName().equalsIgnoreCase(teamName) || m.getAwayTeam().getName().equalsIgnoreCase(teamName))
                        {
                            matchFound = true;
                            
                            played++;
                            
                            if (m.getHomeScore() > m.getAwayScore()) 
                            {
                                if (m.getHomeTeam().getName().equalsIgnoreCase(teamName)) 
                                {
                                    wins++;
                                }
                                else 
                                {
                                    losses++;
                                }
                            }
                            else if (m.getHomeScore() < m.getAwayScore()) 
                            {
                                if (m.getAwayTeam().getName().equalsIgnoreCase(teamName)) 
                                {
                                    wins++;
                                }
                                else
                                {
                                    losses++;
                                }
                            }
                            else
                            {
                                draws++;
                            }
                        
                        String line = m.getHomeTeam().getName() + " " + m.getHomeScore() + " - " + m.getAwayScore() + " " + m.getAwayTeam().getName();
                        
                        if (m.getHomeScore() == m.getAwayScore())
                        {
                            line += " (Draw)";
                        }
                        
                        jTextArea1.append(line + "\n");
                        }
                    }
                    if (matchFound) 
                    {
                        jTextArea1.append("\n===== STATS =====\n");
                        jTextArea1.append("Played: " + played + "\n");
                        jTextArea1.append("Wins: " + wins + "\n");
                        jTextArea1.append("Losses: " + losses + "\n");
                        jTextArea1.append("Draws: " + draws + "\n");
                    }
                    
                    break;
                }
            }
        }
        
        if (!found) 
        {
            jTextArea1.setText("No league found with this name or season");
            
            return;
        }
        
        if (!matchFound) 
        {
            jTextArea1.append("No matches found for this team in this league or season");
            
            return;
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jTextArea1.setText
        (
                """
                === SIMPLE GUIDANCE ===
                
                In the top left corner, you can select the type of sport you want to interest
                
                To type in 'League Information' use the format: LeagueName SeasonYear
                To type in 'Match Information' use the format: TeamName
                
                If any errors encountered, message is shown in the text area
                """
        );
    }//GEN-LAST:event_jButton5ActionPerformed

    public static void main(String args[]) 
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new GUI().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}