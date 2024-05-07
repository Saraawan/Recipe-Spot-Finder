/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acer
 */
public class UserDashboard extends javax.swing.JFrame {

    String databasepath = "Database.accdb";

    /**
     * Creates new form UserDashboard
     */
    public UserDashboard() {
        initComponents();

    }

    public UserDashboard(String username, String ID) {
        initComponents();

        setLocationRelativeTo(null);
        recipetableUpdate();
        allrecipestableUpdate();
        userpanelusername.setText(username);
        userid.setText(ID);
        closeicon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        minimizeicon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logoutbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        savedrecipebutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        searchbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        homebutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        profilebutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        managerecipeslabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        managerecipepanel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        backbutton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeicon2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        minimizeicon2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeicon1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        minimizeicon1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        backbutton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        minimizeicon2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeicon2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        backbutton3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        minimizeicon4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeicon4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        minimizeicon3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeicon3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        oldpassworderror.setText("");
        passnotmatch.setText("");

        this.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));

        String[] sentences = {
            "Enjoy your day!",
            "Have a wonderful day!",
            "Have a fantastic day!",
            "Have a splendid day!",
            "Have a productive day!",
            "I hope you have a good day!",
            "Have a lovely day!",
            "Have a cheerful day!",
            "Have a blessed day!",
            "Take care and have a good day!",
            "Make the most of your day!",
            "Have an amazing day ahead!",
            "Wish you all the best for the day!"
        };

        Random random = new Random();
        int index = random.nextInt(sentences.length);
        usergreetings.setText(sentences[index]);

        inputoldpassword.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                oldpassworderror.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                oldpassworderror.setText("");
            }
        });

        inputnewpassword.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                passnotmatch.setText("");

            }

            @Override
            public void focusLost(FocusEvent e) {
                passnotmatch.setText("");

            }
        });
        inputconfirmpassword.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                passnotmatch.setText("");

            }

            @Override
            public void focusLost(FocusEvent e) {
                passnotmatch.setText("");

            }
        });

        try {
            Connection con = null;
            PreparedStatement pst = null;
            ResultSet rs = null;
            String id = userid.getText();
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://" + databasepath);
            String query = "SELECT * FROM user where ID='" + id + "'";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();

            if (rs.next()) {

                String uname = rs.getString("Username");
                String email = rs.getString("Email");

                usernameprofile.setText(uname);
                emailprofile.setText(email);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
         try {
            Connection con = null;
            PreparedStatement pst = null;
            ResultSet rs = null;

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://" + databasepath);
            String query = "SELECT COUNT(*) FROM recipes";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            int count = 0;
            if (rs.next()) {
                count = rs.getInt(1);
                totalrecipes.setText("" + count);
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
        panelRound2 = new Clases.PanelRound();
        logoutbutton = new javax.swing.JLabel();
        homebutton = new javax.swing.JLabel();
        profilebutton = new javax.swing.JLabel();
        savedrecipebutton = new javax.swing.JLabel();
        userid = new javax.swing.JLabel();
        searchbutton = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        userpanelusername = new javax.swing.JLabel();
        usergreetings = new javax.swing.JLabel();
        closeicon = new javax.swing.JLabel();
        minimizeicon = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        panelRound5 = new Clases.PanelRound();
        jLabel10 = new javax.swing.JLabel();
        totalrecipes = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        managerecipepanel = new Clases.PanelRound();
        managerecipeslabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        backbutton2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        minimizeicon3 = new javax.swing.JLabel();
        closeicon3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        RecipieTable = new javax.swing.JTable();
        showrecipe = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        closeicon1 = new javax.swing.JLabel();
        minimizeicon1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        backbutton = new javax.swing.JLabel();
        panelRound4 = new Clases.PanelRound();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        usernameprofile = new javax.swing.JTextField();
        username1 = new javax.swing.JLabel();
        emailprofile = new javax.swing.JTextField();
        changepassword = new javax.swing.JButton();
        changeprofilebutton = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        backbutton1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        minimizeicon2 = new javax.swing.JLabel();
        closeicon2 = new javax.swing.JLabel();
        panelRound6 = new Clases.PanelRound();
        jLabel5 = new javax.swing.JLabel();
        inputnewpassword = new javax.swing.JPasswordField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        inputoldpassword = new javax.swing.JPasswordField();
        inputconfirmpassword = new javax.swing.JPasswordField();
        oldpassworderror = new javax.swing.JLabel();
        passnotmatch = new javax.swing.JLabel();
        chnagepasswordbutton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        AllRecipieTable = new javax.swing.JTable();
        showrecipe1 = new javax.swing.JButton();
        backbutton3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        closeicon4 = new javax.swing.JLabel();
        minimizeicon4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelRound1.setBackground(new java.awt.Color(0, 51, 51));
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound2.setBackground(new java.awt.Color(196, 181, 129));

        logoutbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/logoutgreen.png"))); // NOI18N
        logoutbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutbuttonMouseClicked(evt);
            }
        });

        homebutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/homegreen.png"))); // NOI18N
        homebutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homebuttonMouseClicked(evt);
            }
        });

        profilebutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/profilegreen.png"))); // NOI18N
        profilebutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profilebuttonMouseClicked(evt);
            }
        });

        savedrecipebutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/savedrecipe.png"))); // NOI18N
        savedrecipebutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                savedrecipebuttonMouseClicked(evt);
            }
        });

        userid.setForeground(new java.awt.Color(196, 181, 129));
        userid.setText("Id");

        searchbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/search.png"))); // NOI18N
        searchbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchbuttonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addComponent(logoutbutton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(homebutton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(profilebutton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(savedrecipebutton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                                .addComponent(userid)
                                .addGap(13, 13, 13))
                            .addComponent(searchbutton, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(userid)
                .addGap(18, 18, 18)
                .addComponent(homebutton)
                .addGap(18, 18, 18)
                .addComponent(searchbutton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(savedrecipebutton)
                .addGap(28, 28, 28)
                .addComponent(profilebutton)
                .addGap(26, 26, 26)
                .addComponent(logoutbutton)
                .addGap(32, 32, 32))
        );

        panelRound1.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 581));

        jPanel3.setBackground(new java.awt.Color(0, 51, 51));

        jLabel2.setBackground(new java.awt.Color(196, 181, 129));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(196, 181, 129));
        jLabel2.setText("Welcome Back");

        userpanelusername.setBackground(new java.awt.Color(196, 181, 129));
        userpanelusername.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        userpanelusername.setForeground(new java.awt.Color(196, 181, 129));
        userpanelusername.setText("Username");

        usergreetings.setBackground(new java.awt.Color(196, 181, 129));
        usergreetings.setForeground(new java.awt.Color(196, 181, 129));
        usergreetings.setText("Have a nice day.");

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

        jButton1.setBackground(new java.awt.Color(196, 181, 129));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 51, 51));
        jButton1.setText("Search Recipe");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        panelRound5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setBackground(new java.awt.Color(102, 102, 102));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 33)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 51));
        jLabel10.setText("Recipes");

        totalrecipes.setBackground(new java.awt.Color(102, 102, 102));
        totalrecipes.setFont(new java.awt.Font("Tahoma", 1, 33)); // NOI18N
        totalrecipes.setForeground(new java.awt.Color(0, 51, 51));
        totalrecipes.setText("0");

        jSeparator3.setForeground(new java.awt.Color(0, 51, 51));

        jLabel9.setBackground(new java.awt.Color(102, 102, 102));
        jLabel9.setForeground(new java.awt.Color(0, 51, 51));
        jLabel9.setText("Total Recipes:");

        managerecipepanel.setBackground(new java.awt.Color(196, 181, 129));
        managerecipepanel.setForeground(new java.awt.Color(196, 181, 129));
        managerecipepanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                managerecipepanelMouseClicked(evt);
            }
        });

        managerecipeslabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        managerecipeslabel.setForeground(new java.awt.Color(0, 51, 51));
        managerecipeslabel.setText("View all Recipes");
        managerecipeslabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                managerecipeslabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout managerecipepanelLayout = new javax.swing.GroupLayout(managerecipepanel);
        managerecipepanel.setLayout(managerecipepanelLayout);
        managerecipepanelLayout.setHorizontalGroup(
            managerecipepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, managerecipepanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(managerecipeslabel)
                .addGap(72, 72, 72))
        );
        managerecipepanelLayout.setVerticalGroup(
            managerecipepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, managerecipepanelLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(managerecipeslabel)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(managerecipepanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator3))
                    .addGroup(panelRound5Layout.createSequentialGroup()
                        .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound5Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(totalrecipes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10))
                            .addGroup(panelRound5Layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(jLabel9)))
                        .addGap(0, 53, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalrecipes)
                    .addComponent(jLabel10))
                .addGap(18, 39, Short.MAX_VALUE)
                .addComponent(managerecipepanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 48, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(panelRound5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(683, 683, 683))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(userpanelusername)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(usergreetings)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(minimizeicon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(closeicon)
                        .addGap(26, 26, 26))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(userpanelusername))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(usergreetings)
                    .addComponent(minimizeicon, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeicon))
                .addGap(40, 40, 40)
                .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(179, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", jPanel3);

        jPanel4.setBackground(new java.awt.Color(0, 51, 51));

        backbutton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/backbuttongold.png"))); // NOI18N
        backbutton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backbutton2MouseClicked(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(196, 181, 129));
        jLabel6.setFont(new java.awt.Font("Arial", 1, 23)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(196, 181, 129));
        jLabel6.setText("Saved Recipes");

        minimizeicon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/minimizegold.png"))); // NOI18N
        minimizeicon3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeicon3MouseClicked(evt);
            }
        });

        closeicon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/closegold.png"))); // NOI18N
        closeicon3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeicon3MouseClicked(evt);
            }
        });

        RecipieTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "CookingTime", "serves", "Calories"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(RecipieTable);

        showrecipe.setBackground(new java.awt.Color(196, 181, 129));
        showrecipe.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        showrecipe.setForeground(new java.awt.Color(0, 51, 51));
        showrecipe.setText("Show");
        showrecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showrecipeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(backbutton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(347, 347, 347)
                        .addComponent(minimizeicon3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap(114, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(showrecipe, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(83, 83, 83)))
                .addComponent(closeicon3)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(closeicon3)
                    .addComponent(minimizeicon3)
                    .addComponent(jLabel6)
                    .addComponent(backbutton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(showrecipe, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", jPanel4);

        jPanel5.setBackground(new java.awt.Color(0, 51, 51));

        closeicon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/closegold.png"))); // NOI18N
        closeicon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeicon1MouseClicked(evt);
            }
        });

        minimizeicon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/minimizegold.png"))); // NOI18N
        minimizeicon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeicon1MouseClicked(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(196, 181, 129));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 23)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(196, 181, 129));
        jLabel3.setText("Profile");

        backbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/backbuttongold.png"))); // NOI18N
        backbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backbuttonMouseClicked(evt);
            }
        });

        panelRound4.setBackground(new java.awt.Color(196, 181, 129));

        jDesktopPane1.setPreferredSize(new java.awt.Dimension(200, 200));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 166, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 186, Short.MAX_VALUE))
        );
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        username.setBackground(new java.awt.Color(196, 181, 129));
        username.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        username.setForeground(new java.awt.Color(0, 51, 51));
        username.setText("username:");

        username1.setBackground(new java.awt.Color(196, 181, 129));
        username1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        username1.setForeground(new java.awt.Color(0, 51, 51));
        username1.setText("Email:");

        changepassword.setBackground(new java.awt.Color(0, 51, 51));
        changepassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        changepassword.setForeground(new java.awt.Color(196, 181, 129));
        changepassword.setText("Change Password");
        changepassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changepasswordActionPerformed(evt);
            }
        });

        changeprofilebutton.setBackground(new java.awt.Color(0, 51, 51));
        changeprofilebutton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        changeprofilebutton.setForeground(new java.awt.Color(196, 181, 129));
        changeprofilebutton.setText("Update");
        changeprofilebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeprofilebuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound4Layout.createSequentialGroup()
                        .addComponent(changepassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(changeprofilebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(panelRound4Layout.createSequentialGroup()
                        .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usernameprofile)
                            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailprofile, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(username1))
                        .addContainerGap(245, Short.MAX_VALUE))))
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound4Layout.createSequentialGroup()
                        .addComponent(username)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(usernameprofile, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(username1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(emailprofile, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85)
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changepassword, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeprofilebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(backbutton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(395, 395, 395)
                .addComponent(minimizeicon1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(closeicon1)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(closeicon1)
                    .addComponent(minimizeicon1)
                    .addComponent(jLabel3)
                    .addComponent(backbutton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab3", jPanel5);

        jPanel8.setBackground(new java.awt.Color(0, 51, 51));

        backbutton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/backbuttongold.png"))); // NOI18N
        backbutton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backbutton1MouseClicked(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(196, 181, 129));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 23)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(196, 181, 129));
        jLabel4.setText("Change Password");

        minimizeicon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/minimizegold.png"))); // NOI18N
        minimizeicon2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeicon2MouseClicked(evt);
            }
        });

        closeicon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/closegold.png"))); // NOI18N
        closeicon2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeicon2MouseClicked(evt);
            }
        });

        panelRound6.setBackground(new java.awt.Color(196, 181, 129));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 51));
        jLabel5.setText("Enter old Password:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 51));
        jLabel13.setText("Enter New Password:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 51));
        jLabel14.setText("Confirm Password:");

        oldpassworderror.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        oldpassworderror.setForeground(new java.awt.Color(255, 0, 0));
        oldpassworderror.setText("old password error");

        passnotmatch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        passnotmatch.setForeground(new java.awt.Color(255, 0, 0));
        passnotmatch.setText("password not match");

        javax.swing.GroupLayout panelRound6Layout = new javax.swing.GroupLayout(panelRound6);
        panelRound6.setLayout(panelRound6Layout);
        panelRound6Layout.setHorizontalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound6Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(passnotmatch)
                    .addComponent(oldpassworderror)
                    .addGroup(panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel14)
                        .addComponent(jLabel13)
                        .addComponent(inputnewpassword)
                        .addComponent(jLabel5)
                        .addComponent(inputoldpassword)
                        .addComponent(inputconfirmpassword, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        panelRound6Layout.setVerticalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound6Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputoldpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(oldpassworderror)
                .addGap(10, 10, 10)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputnewpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputconfirmpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passnotmatch)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        chnagepasswordbutton.setBackground(new java.awt.Color(196, 181, 129));
        chnagepasswordbutton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        chnagepasswordbutton.setForeground(new java.awt.Color(0, 51, 51));
        chnagepasswordbutton.setText("Update");
        chnagepasswordbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chnagepasswordbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(backbutton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 332, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(302, 302, 302)
                .addComponent(minimizeicon2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(closeicon2)
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chnagepasswordbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(284, 284, 284)
                    .addComponent(panelRound6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(285, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(closeicon2)
                    .addComponent(minimizeicon2)
                    .addComponent(jLabel4)
                    .addComponent(backbutton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 456, Short.MAX_VALUE)
                .addComponent(chnagepasswordbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(70, 70, 70)
                    .addComponent(panelRound6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(124, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("tab4", jPanel8);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        AllRecipieTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "CookingTime", "serves", "Calories"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(AllRecipieTable);

        showrecipe1.setBackground(new java.awt.Color(196, 181, 129));
        showrecipe1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        showrecipe1.setForeground(new java.awt.Color(0, 51, 51));
        showrecipe1.setText("Show");
        showrecipe1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showrecipe1ActionPerformed(evt);
            }
        });

        backbutton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/backbuttongold.png"))); // NOI18N
        backbutton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backbutton3MouseClicked(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(196, 181, 129));
        jLabel7.setFont(new java.awt.Font("Arial", 1, 23)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(196, 181, 129));
        jLabel7.setText("All Recipes");

        closeicon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/closegold.png"))); // NOI18N
        closeicon4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeicon4MouseClicked(evt);
            }
        });

        minimizeicon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/minimizegold.png"))); // NOI18N
        minimizeicon4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeicon4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(showrecipe1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(118, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(backbutton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(362, 362, 362)
                .addComponent(minimizeicon4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(closeicon4)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(closeicon4)
                    .addComponent(minimizeicon4)
                    .addComponent(jLabel7)
                    .addComponent(backbutton3))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(showrecipe1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab5", jPanel1);

        panelRound1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, -30, -1, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, 1084, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void minimizeiconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeiconMouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizeiconMouseClicked

    private void closeiconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeiconMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_closeiconMouseClicked

    private void logoutbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutbuttonMouseClicked
        // TODO add your handling code here:
        LoginForm lf = new LoginForm();
        lf.show();
        dispose();
    }//GEN-LAST:event_logoutbuttonMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        String uname = userpanelusername.getText();
        String Id = userid.getText();

        searchfilter sf = new searchfilter(uname, Id);
        sf.show();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbuttonMouseClicked
        // TODO add your handling code here:
        String uname = userpanelusername.getText();
        String Id = userid.getText();

        searchfilter sf = new searchfilter(uname, Id);
        sf.show();
    }//GEN-LAST:event_searchbuttonMouseClicked

    private void closeicon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeicon1MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_closeicon1MouseClicked

    private void minimizeicon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeicon1MouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizeicon1MouseClicked

    private void backbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backbuttonMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_backbuttonMouseClicked

    private void changepasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changepasswordActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_changepasswordActionPerformed

    private void changeprofilebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeprofilebuttonActionPerformed
        // TODO add your handling code here:

        String username = usernameprofile.getText();
        String email = emailprofile.getText();
        int id = Integer.parseInt(userid.getText());

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://" + databasepath);
            String query = "UPDATE user SET Username = ?, Email = ? WHERE ID = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, email);
            pst.setInt(3, id);
            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showConfirmDialog(this, "Profile Updated Successfully", "Success", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showConfirmDialog(this, "something went wrong");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_changeprofilebuttonActionPerformed

    private void backbutton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backbutton1MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_backbutton1MouseClicked

    private void minimizeicon2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeicon2MouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizeicon2MouseClicked

    private void closeicon2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeicon2MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_closeicon2MouseClicked

     public String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    
    private void chnagepasswordbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chnagepasswordbuttonActionPerformed
        // TODO add your handling code here:
        int ID = Integer.parseInt(userid.getText());

        String oldpassword = new String(inputoldpassword.getPassword());
        String firstpassword = new String(inputnewpassword.getPassword());
        String secondpassword = new String(inputconfirmpassword.getPassword());
        
        String oldencryptedPassword = encryptPassword(oldpassword);

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        int passlength = secondpassword.length();

        if (firstpassword.isEmpty() || secondpassword.isEmpty() || oldpassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Fill up form Properly");
        } else if (passlength < 8) {
            JOptionPane.showMessageDialog(this, "password should be more than 8 chracters");
        } else if (passlength > 16) {
            JOptionPane.showMessageDialog(this, "password should be less than 16 chracters");
        } else if (!firstpassword.equals(secondpassword)) {
            passnotmatch.setText("Password does not match");
            inputnewpassword.setText("");
            inputconfirmpassword.setText("");
        } else if (firstpassword.equals(secondpassword)) {

            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                con = DriverManager.getConnection("jdbc:ucanaccess://" + databasepath);
                String query = "select Password from user where ID='" + ID + "'";
                
                String encryptedPassword = encryptPassword(firstpassword);
                
                pst = con.prepareStatement(query);
                rs = pst.executeQuery();

                if (rs.next()) {
                    String pass = rs.getString("Password");
                    if (pass.equals(oldencryptedPassword)) {

                        String query1 = "UPDATE user SET Password = ? WHERE ID = ?";
                        pst = con.prepareStatement(query1);
                        pst.setString(1, encryptedPassword);
                        pst.setInt(2, ID);

                        pst.executeUpdate();

                        JOptionPane.showConfirmDialog(this, "Password Updated Successfully", "Success", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        jTabbedPane1.setSelectedIndex(2);

                    } else {
                        oldpassworderror.setText("Old Password is incorrect.");
                        inputoldpassword.setText("");
                        inputnewpassword.setText("");
                        inputconfirmpassword.setText("");
                    }
                }

            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }//GEN-LAST:event_chnagepasswordbuttonActionPerformed

    private void profilebuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilebuttonMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_profilebuttonMouseClicked

    private void backbutton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backbutton2MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_backbutton2MouseClicked

    private void minimizeicon3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeicon3MouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizeicon3MouseClicked

    private void closeicon3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeicon3MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_closeicon3MouseClicked

    private void homebuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homebuttonMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_homebuttonMouseClicked

    private void savedrecipebuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savedrecipebuttonMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
        recipetableUpdate();
    }//GEN-LAST:event_savedrecipebuttonMouseClicked

    private void showrecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showrecipeActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) RecipieTable.getModel();
        int selectedIndex = RecipieTable.getSelectedRow();
        int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());

        String uname=userpanelusername.getText();
        String uid=userid.getText();

    
        Recipedetails srd=new Recipedetails(id,uname,uid);
        srd.show();
        
    }//GEN-LAST:event_showrecipeActionPerformed

    private void managerecipeslabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_managerecipeslabelMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(4);
        allrecipestableUpdate();
    }//GEN-LAST:event_managerecipeslabelMouseClicked

    private void managerecipepanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_managerecipepanelMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(4);
        allrecipestableUpdate();
    }//GEN-LAST:event_managerecipepanelMouseClicked

    private void showrecipe1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showrecipe1ActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel model = (DefaultTableModel) AllRecipieTable.getModel();
        int selectedIndex = AllRecipieTable.getSelectedRow();
        int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());

        String uname=userpanelusername.getText();
        String uid=userid.getText();

    
        Recipedetails srd=new Recipedetails(id,uname,uid);
        srd.show();
    }//GEN-LAST:event_showrecipe1ActionPerformed

    private void backbutton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backbutton3MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_backbutton3MouseClicked

    private void closeicon4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeicon4MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_closeicon4MouseClicked

    private void minimizeicon4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeicon4MouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizeicon4MouseClicked

    public void recipetableUpdate() {

        int c;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String uid = userid.getText();

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://" + databasepath);
            String query = "SELECT RecipeId FROM savedrecipes WHERE UserID = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, uid);
            rs = pst.executeQuery();

            //ArrayList to store the recipe ids
            ArrayList<Integer> recipeIds = new ArrayList<>();
            while (rs.next()) {
                recipeIds.add(rs.getInt("RecipeId"));
            }

            //For each recipe id, get the relevant information from the "recipesdata" table
            for (int id : recipeIds) {
                query = "SELECT * FROM recipes WHERE ID = ?";
               // query = "SELECT * FROM recipes";
                pst = con.prepareStatement(query);
                pst.setInt(1, id);
                rs = pst.executeQuery();

                ResultSetMetaData rsd = rs.getMetaData();
                c = rsd.getColumnCount();

                DefaultTableModel dft = (DefaultTableModel) RecipieTable.getModel();
                dft.setRowCount(0);

                while (rs.next()) {
                    Vector v2 = new Vector();

                    for (int i = 1; i <= c; i++) {

                        v2.add(rs.getInt("ID"));
                        v2.add(rs.getString("Name"));
                        v2.add(rs.getInt("CookingTime"));
                        v2.add(rs.getInt("Serves"));
                        v2.add(rs.getInt("Calories"));

                    }
                    dft.addRow(v2);
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public void allrecipestableUpdate() {

        int c;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String uid = userid.getText();

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://" + databasepath);
            String query = "SELECT * FROM recipes ";
               // query = "SELECT * FROM recipes";
                pst = con.prepareStatement(query);
               
                rs = pst.executeQuery();

                ResultSetMetaData rsd = rs.getMetaData();
                c = rsd.getColumnCount();

                DefaultTableModel dft = (DefaultTableModel) AllRecipieTable.getModel();
                dft.setRowCount(0);

                while (rs.next()) {
                    Vector v2 = new Vector();

                    for (int i = 1; i <= c; i++) {

                        v2.add(rs.getInt("ID"));
                        v2.add(rs.getString("Name"));
                        v2.add(rs.getInt("CookingTime"));
                        v2.add(rs.getInt("Serves"));
                        v2.add(rs.getInt("Calories"));

                    }
                    dft.addRow(v2);
                }
            

        } catch (Exception e) {
            System.out.println(e);
        }

    }

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
            java.util.logging.Logger.getLogger(UserDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AllRecipieTable;
    private javax.swing.JTable RecipieTable;
    private javax.swing.JLabel backbutton;
    private javax.swing.JLabel backbutton1;
    private javax.swing.JLabel backbutton2;
    private javax.swing.JLabel backbutton3;
    private javax.swing.JButton changepassword;
    private javax.swing.JButton changeprofilebutton;
    private javax.swing.JButton chnagepasswordbutton;
    private javax.swing.JLabel closeicon;
    private javax.swing.JLabel closeicon1;
    private javax.swing.JLabel closeicon2;
    private javax.swing.JLabel closeicon3;
    private javax.swing.JLabel closeicon4;
    private javax.swing.JTextField emailprofile;
    private javax.swing.JLabel homebutton;
    private javax.swing.JPasswordField inputconfirmpassword;
    private javax.swing.JPasswordField inputnewpassword;
    private javax.swing.JPasswordField inputoldpassword;
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel logoutbutton;
    private Clases.PanelRound managerecipepanel;
    private javax.swing.JLabel managerecipeslabel;
    private javax.swing.JLabel minimizeicon;
    private javax.swing.JLabel minimizeicon1;
    private javax.swing.JLabel minimizeicon2;
    private javax.swing.JLabel minimizeicon3;
    private javax.swing.JLabel minimizeicon4;
    private javax.swing.JLabel oldpassworderror;
    private Clases.PanelRound panelRound1;
    private Clases.PanelRound panelRound2;
    private Clases.PanelRound panelRound4;
    private Clases.PanelRound panelRound5;
    private Clases.PanelRound panelRound6;
    private javax.swing.JLabel passnotmatch;
    private javax.swing.JLabel profilebutton;
    private javax.swing.JLabel savedrecipebutton;
    private javax.swing.JLabel searchbutton;
    private javax.swing.JButton showrecipe;
    private javax.swing.JButton showrecipe1;
    private javax.swing.JLabel totalrecipes;
    private javax.swing.JLabel usergreetings;
    private javax.swing.JLabel userid;
    private javax.swing.JLabel username;
    private javax.swing.JLabel username1;
    private javax.swing.JTextField usernameprofile;
    private javax.swing.JLabel userpanelusername;
    // End of variables declaration//GEN-END:variables
}
