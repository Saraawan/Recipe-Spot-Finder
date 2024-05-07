/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Color;
import java.awt.Cursor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import java.awt.Image;
import java.sql.Blob;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Atif Jalal
 */
public class Recipedetails extends javax.swing.JFrame {

    String databasepath = "Database.accdb";

    /**
     * Creates new form Recipedetails
     */
    public Recipedetails() {
        initComponents();

    }

    public Recipedetails(int id, String name, String uid) {
        initComponents();
        rid.setText("" + id);

        username.setText(name);
        userid.setText(uid);

        setLocationRelativeTo(null);
        closeicon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        minimizeicon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://" + databasepath);
            String query = "SELECT * FROM recipes where ID='"+id+"'";

            pst = con.prepareStatement(query);
            rs = pst.executeQuery();

            if (rs.next()) {
                String rname = rs.getString("Name");
                String recmethod = rs.getString("Method");

                String ingredient1 = rs.getString("Ingredient1");
                String ingredient2 = rs.getString("Ingredient2");
                String ingredient3 = rs.getString("Ingredient3");
                String addingredient = rs.getString("AdditionalIngredients");
                int recserves = rs.getInt("Serves");
                int recctime = rs.getInt("CookingTime");
                int reccalo = rs.getInt("CookingTime");

                ing1.setText(ingredient1);
                ing2.setText(ingredient2);
                ing3.setText(ingredient3);
                addingredientarea.setText(addingredient);

                Blob imageBlob = rs.getBlob("RecipeImage");
                Image image = ImageIO.read(imageBlob.getBinaryStream());
                recipename.setText(rname);
                rmethod.setText(recmethod);
                ImageIcon recipeicon = new ImageIcon(image);
                ricon.setIcon(recipeicon);
                cookingtime.setText(recctime + "");
                serves.setText(recserves + "");
                calories.setText(reccalo + "");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new Clases.PanelRound();
        recipename = new javax.swing.JLabel();
        panelRound2 = new Clases.PanelRound();
        jLabel5 = new javax.swing.JLabel();
        closeicon = new javax.swing.JLabel();
        minimizeicon = new javax.swing.JLabel();
        backbutton = new javax.swing.JLabel();
        rid = new javax.swing.JLabel();
        userid = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        ricon = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        rmethod = new javax.swing.JTextArea();
        recipename1 = new javax.swing.JLabel();
        recipename2 = new javax.swing.JLabel();
        ing1 = new javax.swing.JLabel();
        ing2 = new javax.swing.JLabel();
        ing3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        addingredientarea = new javax.swing.JTextArea();
        recipename3 = new javax.swing.JLabel();
        saverecipe = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cookingtime = new javax.swing.JLabel();
        serves = new javax.swing.JLabel();
        calories = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelRound1.setBackground(new java.awt.Color(196, 181, 129));

        recipename.setBackground(new java.awt.Color(196, 181, 129));
        recipename.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        recipename.setForeground(new java.awt.Color(0, 51, 51));
        recipename.setText("RecipeName");

        panelRound2.setBackground(new java.awt.Color(0, 51, 51));
        panelRound2.setForeground(new java.awt.Color(0, 51, 51));

        jLabel5.setBackground(new java.awt.Color(196, 181, 129));
        jLabel5.setFont(new java.awt.Font("Arial", 1, 23)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(196, 181, 129));
        jLabel5.setText("Recipe Details");

        closeicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/closegold.png"))); // NOI18N
        closeicon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeiconMouseClicked(evt);
            }
        });

        minimizeicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/minimizegold.png"))); // NOI18N
        minimizeicon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeiconMouseClicked(evt);
            }
        });

        backbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/backbuttongold.png"))); // NOI18N
        backbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backbuttonMouseClicked(evt);
            }
        });

        rid.setForeground(new java.awt.Color(0, 51, 51));
        rid.setText("jLabel1");

        userid.setForeground(new java.awt.Color(0, 51, 51));
        userid.setText("jLabel1");

        username.setForeground(new java.awt.Color(0, 51, 51));
        username.setText("jLabel2");

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(backbutton)
                .addGap(29, 29, 29)
                .addComponent(rid)
                .addGap(26, 26, 26)
                .addComponent(userid)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(username)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(373, 373, 373)
                .addComponent(minimizeicon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(closeicon)
                .addGap(18, 18, 18))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(rid)
                        .addComponent(userid)
                        .addComponent(username))
                    .addComponent(closeicon)
                    .addComponent(minimizeicon)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(backbutton)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jDesktopPane1.setPreferredSize(new java.awt.Dimension(400, 400));

        ricon.setForeground(new java.awt.Color(255, 255, 255));
        ricon.setText("jLabel1");

        jDesktopPane1.setLayer(ricon, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ricon, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ricon, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        jSeparator1.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator1.setForeground(new java.awt.Color(0, 51, 51));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        rmethod.setEditable(false);
        rmethod.setBackground(new java.awt.Color(0, 51, 51));
        rmethod.setColumns(20);
        rmethod.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        rmethod.setForeground(new java.awt.Color(196, 181, 129));
        rmethod.setRows(5);
        rmethod.setBorder(null);
        rmethod.setMaximumSize(new java.awt.Dimension(240, 75));
        rmethod.setMinimumSize(new java.awt.Dimension(240, 75));
        jScrollPane1.setViewportView(rmethod);

        recipename1.setBackground(new java.awt.Color(196, 181, 129));
        recipename1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        recipename1.setForeground(new java.awt.Color(0, 51, 51));
        recipename1.setText("Method:");

        recipename2.setBackground(new java.awt.Color(196, 181, 129));
        recipename2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        recipename2.setForeground(new java.awt.Color(0, 51, 51));
        recipename2.setText("Ingredients:");

        ing1.setBackground(new java.awt.Color(196, 181, 129));
        ing1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ing1.setForeground(new java.awt.Color(0, 51, 51));
        ing1.setText("Ingredients:");

        ing2.setBackground(new java.awt.Color(196, 181, 129));
        ing2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ing2.setForeground(new java.awt.Color(0, 51, 51));
        ing2.setText("Ingredients:");

        ing3.setBackground(new java.awt.Color(196, 181, 129));
        ing3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ing3.setForeground(new java.awt.Color(0, 51, 51));
        ing3.setText("Ingredients:");

        addingredientarea.setEditable(false);
        addingredientarea.setBackground(new java.awt.Color(196, 181, 129));
        addingredientarea.setColumns(20);
        addingredientarea.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        addingredientarea.setForeground(new java.awt.Color(0, 51, 51));
        addingredientarea.setRows(5);
        addingredientarea.setBorder(null);
        addingredientarea.setDisabledTextColor(new java.awt.Color(196, 181, 129));
        jScrollPane2.setViewportView(addingredientarea);

        recipename3.setBackground(new java.awt.Color(196, 181, 129));
        recipename3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        recipename3.setForeground(new java.awt.Color(0, 51, 51));
        recipename3.setText("Additional Ingredients:");

        saverecipe.setBackground(new java.awt.Color(0, 51, 51));
        saverecipe.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        saverecipe.setForeground(new java.awt.Color(196, 181, 129));
        saverecipe.setText("Save Recipe");
        saverecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saverecipeActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/clock.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/serves.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/calories.png"))); // NOI18N

        cookingtime.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cookingtime.setForeground(new java.awt.Color(0, 51, 51));
        cookingtime.setText("jLabel4");

        serves.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        serves.setForeground(new java.awt.Color(0, 51, 51));
        serves.setText("jLabel4");

        calories.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        calories.setForeground(new java.awt.Color(0, 51, 51));
        calories.setText("jLabel4");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 51));
        jLabel4.setText("mins");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 51));
        jLabel6.setText("calories");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recipename)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cookingtime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addGap(37, 37, 37)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(recipename1)
                            .addComponent(recipename3)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))
                        .addGap(25, 25, 25))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ing3)
                                    .addComponent(ing2)
                                    .addComponent(ing1)))
                            .addComponent(recipename2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(serves)
                                .addGap(142, 142, 142))
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelRound1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(saverecipe, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelRound1Layout.createSequentialGroup()
                                        .addComponent(calories)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(25, 25, 25))))))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(recipename)
                                .addGap(27, 27, 27)
                                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(panelRound1Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(cookingtime)
                                            .addComponent(jLabel4)))))
                            .addComponent(jSeparator1))
                        .addContainerGap(27, Short.MAX_VALUE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(recipename1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(recipename2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ing1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ing2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ing3))
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(serves)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelRound1Layout.createSequentialGroup()
                                        .addGap(39, 39, 39)
                                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel6)
                                            .addComponent(calories)))
                                    .addGroup(panelRound1Layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(jLabel3))))
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel2)))
                        .addGap(18, 18, 18)
                        .addComponent(recipename3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saverecipe, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeiconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeiconMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_closeiconMouseClicked

    private void minimizeiconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeiconMouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizeiconMouseClicked

    private void backbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backbuttonMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_backbuttonMouseClicked

    private void saverecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saverecipeActionPerformed
        // TODO add your handling code here:
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String uid = userid.getText();
        String recipeid = rid.getText();
        String uname = username.getText();

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://" + databasepath);
            String query = "select * from savedrecipes where UserID='" + uid + "' and RecipeId='" + recipeid + "'";

            pst = con.prepareStatement(query);
            rs = pst.executeQuery();

            if (rs.next()) {
                  JOptionPane.showMessageDialog(this, "Recipe Already Added.");  
            } else {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                con = DriverManager.getConnection("jdbc:ucanaccess://" + databasepath);
                String query1 = "insert into savedrecipes(UserID,RecipeId) values (?, ?)";
                pst = con.prepareStatement(query1);
                pst.setString(1, uid);
                pst.setString(2, recipeid);

                int rows = pst.executeUpdate();
                if (rows > 0) {
                    JOptionPane.showMessageDialog(this, "Recipe Saved");
                    UserDashboard ud = new UserDashboard(uname, uid);
                    ud.show();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Something wenwrong.");
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_saverecipeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Recipedetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Recipedetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Recipedetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Recipedetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Recipedetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea addingredientarea;
    private javax.swing.JLabel backbutton;
    private javax.swing.JLabel calories;
    private javax.swing.JLabel closeicon;
    private javax.swing.JLabel cookingtime;
    private javax.swing.JLabel ing1;
    private javax.swing.JLabel ing2;
    private javax.swing.JLabel ing3;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel minimizeicon;
    private Clases.PanelRound panelRound1;
    private Clases.PanelRound panelRound2;
    private javax.swing.JLabel recipename;
    private javax.swing.JLabel recipename1;
    private javax.swing.JLabel recipename2;
    private javax.swing.JLabel recipename3;
    private javax.swing.JLabel ricon;
    private javax.swing.JLabel rid;
    private javax.swing.JTextArea rmethod;
    private javax.swing.JButton saverecipe;
    private javax.swing.JLabel serves;
    private javax.swing.JLabel userid;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
