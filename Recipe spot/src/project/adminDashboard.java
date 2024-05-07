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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.lang.Thread.sleep;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Random;
import javax.swing.JFrame;

/**
 *
 * @author Acer
 */
public class adminDashboard extends javax.swing.JFrame {

    String databasepath = "Database.accdb";

    /**
     * Creates new form adminDashboard
     */
    public adminDashboard() {
        initComponents();
        this.setTitle("Admin Dashboard");
        setLocationRelativeTo(null);

    }

    public adminDashboard(String username, String ID) {
        initComponents();
        this.setTitle("Admin Dashboard");
        setLocationRelativeTo(null);
        userstableUpdate();
        admintableUpdate();
        recipetableUpdate();
        clock();
        adminpanelusername.setText(username);
        userid.setText(ID);
        oldpassworderror.setText("");
        passnotmatch.setText("");

        this.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));

        closeicon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        minimizeicon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeicon1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        minimizeicon1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeicon2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        minimizeicon2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeicon3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        minimizeicon3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        logoutbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));

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
        admingreetings.setText(sentences[index]);

        homebutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        usersgold.setCursor(new Cursor(Cursor.HAND_CURSOR));
        recepibutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logoutbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        manageuserslabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        manageuserspanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        managerecipeslabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        managerecipepanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        manageadminlabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        manageadminpanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        profilebackbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        profilecloseicon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        profileminimizeicon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        profilebackbutton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        profilecloseicon1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        profileminimizeicon1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        manageadmins.setCursor(new Cursor(Cursor.HAND_CURSOR));
        profilebutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        recepibutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        changeprofilebutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        changepassword.setCursor(new Cursor(Cursor.HAND_CURSOR));

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
            String utype = "user";
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://" + databasepath);
            String query = "SELECT COUNT(*) FROM user WHERE usertype='" + utype + "'";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            int count = 0;
            if (rs.next()) {
                count = rs.getInt(1);
                totalusernumber.setText("" + count);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            Connection con = null;
            PreparedStatement pst = null;
            ResultSet rs = null;
            String utype = "admin";
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://" + databasepath);
            String query = "SELECT COUNT(*) FROM user WHERE usertype='" + utype + "'";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            int count = 0;
            if (rs.next()) {
                count = rs.getInt(1);
                totaladminnumber.setText("" + count);
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
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    public void recipetableUpdate() {

        int c;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://" + databasepath);
            String query = "SELECT * FROM recipes ";

            pst = con.prepareStatement(query);
            rs = pst.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();

            DefaultTableModel dft = (DefaultTableModel) managerecipestable.getModel();
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

        } catch (ClassNotFoundException | SQLException ce) {
            System.out.println(ce);
        }
    }

    public void userstableUpdate() {

        int c;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String utype = "user";

        try {

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://" + databasepath);
            String query = "select * FROM user WHERE usertype='" + utype + "'";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();

            DefaultTableModel dft = (DefaultTableModel) usertable.getModel();
            dft.setRowCount(0);
            while (rs.next()) {
                Vector v2 = new Vector();

                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getInt("ID"));
                    v2.add(rs.getString("Username"));
                    v2.add(rs.getString("Email"));
                    v2.add(rs.getString("PhoneNumber"));

                }
                dft.addRow(v2);
            }
        } catch (ClassNotFoundException | SQLException ce) {
            System.out.println(ce);
        }

    }

    public void admintableUpdate() {

        int c;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String utype = "admin";

        try {

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://" + databasepath);
            String query = "select * FROM user WHERE usertype='" + utype + "'";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();

            DefaultTableModel dft = (DefaultTableModel) admintable.getModel();
            dft.setRowCount(0);
            while (rs.next()) {
                Vector v2 = new Vector();

                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getInt("ID"));
                    v2.add(rs.getString("Username"));
                    v2.add(rs.getString("Email"));
                    v2.add(rs.getString("PhoneNumber"));

                }
                dft.addRow(v2);
            }
        } catch (ClassNotFoundException | SQLException ce) {
            System.out.println(ce);
        }

    }

    public void clock() {
        Thread clock = new Thread() {
            public void run() {
                try {
                    while (true) {
                        Calendar cal = new GregorianCalendar();
                        int day = cal.get(Calendar.DAY_OF_MONTH);
                        int month = cal.get(Calendar.MONTH) + 1;
                        int year = cal.get(Calendar.YEAR);
                        int second = cal.get(Calendar.SECOND);
                        int minute = cal.get(Calendar.MINUTE);
                        int hour = cal.get(Calendar.HOUR);

                        lbltime.setText(hour + ":" + minute + ":" + second);
                        lblDate.setText(day + "-" + month + "-" + year);
                        //  getTime=lbltime.getText();
                        // getDate=lbldate.getText();
                        sleep(1000);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, e);

                }
            }
        };
        clock.start();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound9 = new Clases.PanelRound();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        adminpanelusername = new javax.swing.JLabel();
        admingreetings = new javax.swing.JLabel();
        panelRound1 = new Clases.PanelRound();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        totalusernumber = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        manageuserspanel = new Clases.PanelRound();
        manageuserslabel = new javax.swing.JLabel();
        panelRound3 = new Clases.PanelRound();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        totaladminnumber = new javax.swing.JLabel();
        manageadminpanel = new Clases.PanelRound();
        manageadminlabel = new javax.swing.JLabel();
        panelRound5 = new Clases.PanelRound();
        jLabel10 = new javax.swing.JLabel();
        totalrecipes = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        managerecipepanel = new Clases.PanelRound();
        managerecipeslabel = new javax.swing.JLabel();
        closeicon = new javax.swing.JLabel();
        minimizeicon = new javax.swing.JLabel();
        panelRound2 = new Clases.PanelRound();
        lbltime = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usertable = new javax.swing.JTable();
        userdeletebutton = new javax.swing.JButton();
        makeadmin = new javax.swing.JButton();
        closeicon2 = new javax.swing.JLabel();
        minimizeicon2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        manageadmin = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        admintable = new javax.swing.JTable();
        deleteadmin = new javax.swing.JButton();
        makeuserbutton = new javax.swing.JButton();
        closeicon3 = new javax.swing.JLabel();
        minimizeicon3 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        manageadmin1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        managerecipestable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        addrecord = new javax.swing.JButton();
        updaterecipe = new javax.swing.JButton();
        closeicon1 = new javax.swing.JLabel();
        minimizeicon1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        profilebackbutton = new javax.swing.JLabel();
        profilecloseicon = new javax.swing.JLabel();
        profileminimizeicon = new javax.swing.JLabel();
        panelRound4 = new Clases.PanelRound();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        usernameprofile = new javax.swing.JTextField();
        username1 = new javax.swing.JLabel();
        emailprofile = new javax.swing.JTextField();
        changepassword = new javax.swing.JButton();
        changeprofilebutton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        profilebackbutton1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        profileminimizeicon1 = new javax.swing.JLabel();
        profilecloseicon1 = new javax.swing.JLabel();
        panelRound6 = new Clases.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        inputnewpassword = new javax.swing.JPasswordField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        inputoldpassword = new javax.swing.JPasswordField();
        inputconfirmpassword = new javax.swing.JPasswordField();
        oldpassworderror = new javax.swing.JLabel();
        passnotmatch = new javax.swing.JLabel();
        chnagepasswordbutton = new javax.swing.JButton();
        panelRound10 = new Clases.PanelRound();
        homebutton = new javax.swing.JLabel();
        usersgold = new javax.swing.JLabel();
        recepibutton = new javax.swing.JLabel();
        logoutbutton = new javax.swing.JLabel();
        manageadmins = new javax.swing.JLabel();
        profilebutton = new javax.swing.JLabel();
        userid = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound9.setBackground(new java.awt.Color(196, 181, 129));
        panelRound9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(196, 181, 129));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("Welcome Back");

        adminpanelusername.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        adminpanelusername.setForeground(new java.awt.Color(0, 51, 51));
        adminpanelusername.setText("Username");

        admingreetings.setForeground(new java.awt.Color(0, 51, 51));
        admingreetings.setText("Have a nice day.");

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setBackground(new java.awt.Color(102, 102, 102));
        jLabel4.setForeground(new java.awt.Color(0, 51, 51));
        jLabel4.setText("Total Users:");

        jSeparator1.setForeground(new java.awt.Color(0, 51, 51));

        totalusernumber.setBackground(new java.awt.Color(102, 102, 102));
        totalusernumber.setFont(new java.awt.Font("Tahoma", 1, 33)); // NOI18N
        totalusernumber.setForeground(new java.awt.Color(0, 51, 51));
        totalusernumber.setText("0");

        jLabel6.setBackground(new java.awt.Color(102, 102, 102));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 33)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 51));
        jLabel6.setText("Users");

        manageuserspanel.setBackground(new java.awt.Color(0, 51, 51));
        manageuserspanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manageuserspanelMouseClicked(evt);
            }
        });

        manageuserslabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        manageuserslabel.setForeground(new java.awt.Color(196, 181, 129));
        manageuserslabel.setText("Manage Users");
        manageuserslabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manageuserslabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout manageuserspanelLayout = new javax.swing.GroupLayout(manageuserspanel);
        manageuserspanel.setLayout(manageuserspanelLayout);
        manageuserspanelLayout.setHorizontalGroup(
            manageuserspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageuserspanelLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(manageuserslabel)
                .addContainerGap(84, Short.MAX_VALUE))
        );
        manageuserspanelLayout.setVerticalGroup(
            manageuserspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manageuserspanelLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(manageuserslabel)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(totalusernumber)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(manageuserspanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(90, 90, 90))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalusernumber)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(manageuserspanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelRound3.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator2.setForeground(new java.awt.Color(0, 51, 51));

        jLabel7.setBackground(new java.awt.Color(102, 102, 102));
        jLabel7.setForeground(new java.awt.Color(0, 51, 51));
        jLabel7.setText("Total Admin:");

        jLabel8.setBackground(new java.awt.Color(102, 102, 102));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 33)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 51));
        jLabel8.setText("Admin");

        totaladminnumber.setBackground(new java.awt.Color(102, 102, 102));
        totaladminnumber.setFont(new java.awt.Font("Tahoma", 1, 33)); // NOI18N
        totaladminnumber.setForeground(new java.awt.Color(0, 51, 51));
        totaladminnumber.setText("0");

        manageadminpanel.setBackground(new java.awt.Color(0, 51, 51));
        manageadminpanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manageadminpanelMouseClicked(evt);
            }
        });

        manageadminlabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        manageadminlabel.setForeground(new java.awt.Color(196, 181, 129));
        manageadminlabel.setText("Manage Admin");
        manageadminlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manageadminlabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout manageadminpanelLayout = new javax.swing.GroupLayout(manageadminpanel);
        manageadminpanel.setLayout(manageadminpanelLayout);
        manageadminpanelLayout.setHorizontalGroup(
            manageadminpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageadminpanelLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(manageadminlabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        manageadminpanelLayout.setVerticalGroup(
            manageadminpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manageadminpanelLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(manageadminlabel)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel7))
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(totaladminnumber)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(manageadminpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totaladminnumber)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(manageadminpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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

        managerecipepanel.setBackground(new java.awt.Color(0, 51, 51));
        managerecipepanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                managerecipepanelMouseClicked(evt);
            }
        });

        managerecipeslabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        managerecipeslabel.setForeground(new java.awt.Color(196, 181, 129));
        managerecipeslabel.setText("Manage Recipes");
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
                .addContainerGap()
                .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRound5Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel9)
                        .addGap(0, 64, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(totalrecipes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(managerecipepanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        closeicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/closegreen.png"))); // NOI18N
        closeicon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeiconMouseClicked(evt);
            }
        });

        minimizeicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/minimizegreen.png"))); // NOI18N
        minimizeicon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeiconMouseClicked(evt);
            }
        });

        panelRound2.setBackground(new java.awt.Color(0, 51, 51));
        panelRound2.setRoundBottomLeft(500);
        panelRound2.setRoundBottomRight(500);
        panelRound2.setRoundTopLeft(0);
        panelRound2.setRoundTopRight(0);

        lbltime.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbltime.setForeground(new java.awt.Color(196, 181, 129));
        lbltime.setText("Time");

        lblDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDate.setForeground(new java.awt.Color(196, 181, 129));
        lblDate.setText("Date");

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbltime)
                    .addComponent(lblDate))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(lblDate)
                .addGap(18, 18, 18)
                .addComponent(lbltime)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(adminpanelusername))
                            .addComponent(admingreetings)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(minimizeicon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closeicon)))
                .addGap(28, 28, 28))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(adminpanelusername))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(admingreetings))
                    .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(minimizeicon)
                            .addComponent(closeicon))))
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(240, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", jPanel3);

        jPanel4.setBackground(new java.awt.Color(196, 181, 129));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 51));
        jLabel5.setText("Manage Users:");

        jScrollPane1.setBackground(new java.awt.Color(196, 181, 129));
        jScrollPane1.setBorder(null);

        usertable.setBackground(new java.awt.Color(0, 51, 51));
        usertable.setForeground(new java.awt.Color(196, 181, 129));
        usertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Username", "Email", "Phone Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(usertable);

        userdeletebutton.setBackground(new java.awt.Color(102, 153, 255));
        userdeletebutton.setText("Delete");
        userdeletebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userdeletebuttonActionPerformed(evt);
            }
        });

        makeadmin.setText("Make Admin");
        makeadmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeadminActionPerformed(evt);
            }
        });

        closeicon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/closegreen.png"))); // NOI18N
        closeicon2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeicon2MouseClicked(evt);
            }
        });

        minimizeicon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/minimizegreen.png"))); // NOI18N
        minimizeicon2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeicon2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(638, 638, 638)
                        .addComponent(makeadmin, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(minimizeicon2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closeicon2))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(userdeletebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 737, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(minimizeicon2)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(closeicon2)
                            .addGap(15, 15, 15))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userdeletebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(makeadmin, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(222, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", jPanel4);

        jPanel5.setBackground(new java.awt.Color(196, 181, 129));

        manageadmin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        manageadmin.setForeground(new java.awt.Color(0, 51, 51));
        manageadmin.setText("Manage Admin:");

        admintable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Username", "Email", "Phone Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(admintable);

        deleteadmin.setText("Delete");
        deleteadmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteadminActionPerformed(evt);
            }
        });

        makeuserbutton.setText("Make User");
        makeuserbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeuserbuttonActionPerformed(evt);
            }
        });

        closeicon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/closegreen.png"))); // NOI18N
        closeicon3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeicon3MouseClicked(evt);
            }
        });

        minimizeicon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/minimizegreen.png"))); // NOI18N
        minimizeicon3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeicon3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(manageadmin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(minimizeicon3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closeicon3))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(deleteadmin, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(makeuserbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(manageadmin))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(minimizeicon3)
                            .addComponent(closeicon3))
                        .addGap(17, 17, 17)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deleteadmin, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(makeuserbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(169, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab3", jPanel5);

        jPanel8.setBackground(new java.awt.Color(196, 181, 129));

        manageadmin1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        manageadmin1.setForeground(new java.awt.Color(0, 51, 51));
        manageadmin1.setText("Manage Recipes:");

        managerecipestable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Cooking Time", "Serves", "Calories"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(managerecipestable);

        jButton1.setBackground(new java.awt.Color(0, 51, 51));
        jButton1.setForeground(new java.awt.Color(196, 181, 129));
        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        addrecord.setBackground(new java.awt.Color(0, 51, 51));
        addrecord.setForeground(new java.awt.Color(196, 181, 129));
        addrecord.setText("Add");
        addrecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addrecordActionPerformed(evt);
            }
        });

        updaterecipe.setBackground(new java.awt.Color(0, 51, 51));
        updaterecipe.setForeground(new java.awt.Color(196, 181, 129));
        updaterecipe.setText("Update");
        updaterecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updaterecipeActionPerformed(evt);
            }
        });

        closeicon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/closegreen.png"))); // NOI18N
        closeicon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeicon1MouseClicked(evt);
            }
        });

        minimizeicon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/minimizegreen.png"))); // NOI18N
        minimizeicon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeicon1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(manageadmin1)
                        .addGap(603, 603, 603)
                        .addComponent(minimizeicon1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closeicon1))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addrecord, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(235, 235, 235)
                            .addComponent(updaterecipe, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(manageadmin1)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(minimizeicon1)
                            .addComponent(closeicon1))
                        .addGap(30, 30, 30)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updaterecipe, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addrecord, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(166, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab4", jPanel8);

        jPanel1.setBackground(new java.awt.Color(196, 181, 129));

        jLabel11.setBackground(new java.awt.Color(196, 181, 129));
        jLabel11.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 51));
        jLabel11.setText("Profile");

        profilebackbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/backbuttongreen.png"))); // NOI18N
        profilebackbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profilebackbuttonMouseClicked(evt);
            }
        });

        profilecloseicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/closegreen.png"))); // NOI18N
        profilecloseicon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profilecloseiconMouseClicked(evt);
            }
        });

        profileminimizeicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/minimizegreen.png"))); // NOI18N
        profileminimizeicon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileminimizeiconMouseClicked(evt);
            }
        });

        panelRound4.setBackground(new java.awt.Color(0, 51, 51));

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
        username.setForeground(new java.awt.Color(196, 181, 129));
        username.setText("username:");

        username1.setBackground(new java.awt.Color(196, 181, 129));
        username1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        username1.setForeground(new java.awt.Color(196, 181, 129));
        username1.setText("Email:");

        changepassword.setBackground(new java.awt.Color(196, 181, 129));
        changepassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        changepassword.setForeground(new java.awt.Color(0, 51, 51));
        changepassword.setText("Change Password");
        changepassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changepasswordActionPerformed(evt);
            }
        });

        changeprofilebutton.setBackground(new java.awt.Color(196, 181, 129));
        changeprofilebutton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        changeprofilebutton.setForeground(new java.awt.Color(0, 51, 51));
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(profilebackbutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(284, 284, 284)
                        .addComponent(profileminimizeicon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(profilecloseicon)
                        .addGap(17, 17, 17)))
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(profilebackbutton)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(profileminimizeicon)
                        .addComponent(profilecloseicon)
                        .addComponent(jLabel11)))
                .addGap(18, 18, 18)
                .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab5", jPanel1);

        jPanel2.setBackground(new java.awt.Color(196, 181, 129));

        profilebackbutton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/backbuttongreen.png"))); // NOI18N
        profilebackbutton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profilebackbutton1MouseClicked(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(196, 181, 129));
        jLabel12.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 51));
        jLabel12.setText("Change Password");

        profileminimizeicon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/minimizegreen.png"))); // NOI18N
        profileminimizeicon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileminimizeicon1MouseClicked(evt);
            }
        });

        profilecloseicon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/closegreen.png"))); // NOI18N
        profilecloseicon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profilecloseicon1MouseClicked(evt);
            }
        });

        panelRound6.setBackground(new java.awt.Color(0, 51, 51));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(196, 181, 129));
        jLabel3.setText("Enter old Password:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(196, 181, 129));
        jLabel13.setText("Enter New Password:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(196, 181, 129));
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
                        .addComponent(jLabel3)
                        .addComponent(inputoldpassword)
                        .addComponent(inputconfirmpassword, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        panelRound6Layout.setVerticalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound6Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel3)
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
                .addContainerGap(26, Short.MAX_VALUE))
        );

        chnagepasswordbutton.setBackground(new java.awt.Color(0, 51, 51));
        chnagepasswordbutton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        chnagepasswordbutton.setForeground(new java.awt.Color(196, 181, 129));
        chnagepasswordbutton.setText("Update");
        chnagepasswordbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chnagepasswordbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(panelRound6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(204, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(profilebackbutton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addGap(212, 212, 212)
                        .addComponent(profileminimizeicon1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(profilecloseicon1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(chnagepasswordbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(67, 67, 67))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(profileminimizeicon1)
                        .addComponent(profilecloseicon1)
                        .addComponent(jLabel12))
                    .addComponent(profilebackbutton1))
                .addGap(31, 31, 31)
                .addComponent(panelRound6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(chnagepasswordbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab6", jPanel2);

        panelRound9.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, -30, 850, 610));

        panelRound10.setBackground(new java.awt.Color(0, 51, 51));
        panelRound10.setForeground(new java.awt.Color(0, 51, 51));

        homebutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/homegold.png"))); // NOI18N
        homebutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homebuttonMouseClicked(evt);
            }
        });

        usersgold.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/usersgold.png"))); // NOI18N
        usersgold.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usersgoldMouseClicked(evt);
            }
        });

        recepibutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/managerecipe.png"))); // NOI18N
        recepibutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recepibuttonMouseClicked(evt);
            }
        });

        logoutbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/logoutgold.png"))); // NOI18N
        logoutbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutbuttonMouseClicked(evt);
            }
        });

        manageadmins.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/admingold.png"))); // NOI18N
        manageadmins.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manageadminsMouseClicked(evt);
            }
        });

        profilebutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/profilegold.png"))); // NOI18N
        profilebutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profilebuttonMouseClicked(evt);
            }
        });

        userid.setForeground(new java.awt.Color(0, 51, 51));
        userid.setText("ID");

        javax.swing.GroupLayout panelRound10Layout = new javax.swing.GroupLayout(panelRound10);
        panelRound10.setLayout(panelRound10Layout);
        panelRound10Layout.setHorizontalGroup(
            panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound10Layout.createSequentialGroup()
                .addGroup(panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound10Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(homebutton)
                            .addComponent(usersgold)
                            .addComponent(manageadmins))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound10Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(recepibutton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(profilebutton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(logoutbutton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound10Layout.createSequentialGroup()
                                .addComponent(userid)
                                .addGap(13, 13, 13)))))
                .addContainerGap())
        );
        panelRound10Layout.setVerticalGroup(
            panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound10Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(userid)
                .addGap(18, 18, 18)
                .addComponent(homebutton)
                .addGap(24, 24, 24)
                .addComponent(usersgold)
                .addGap(24, 24, 24)
                .addComponent(manageadmins)
                .addGap(24, 24, 24)
                .addComponent(recepibutton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 218, Short.MAX_VALUE)
                .addComponent(profilebutton)
                .addGap(31, 31, 31)
                .addComponent(logoutbutton)
                .addGap(39, 39, 39))
        );

        panelRound9.add(panelRound10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, -1, 620));

        getContentPane().add(panelRound9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 970, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userdeletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userdeletebuttonActionPerformed
        // TODO add your handling code here:
        Connection con = null;
        PreparedStatement pst = null;
        int rowsAffected = 0;
        DefaultTableModel model = (DefaultTableModel) usertable.getModel();
        int selectedIndex = usertable.getSelectedRow();
        int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
        int dialogresult = JOptionPane.showConfirmDialog(this, "Do you want to delete the record?", "Warning", JOptionPane.YES_NO_OPTION);

        if (dialogresult == JOptionPane.YES_NO_OPTION) {
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                con = DriverManager.getConnection("jdbc:ucanaccess://" + databasepath);
                String query = "delete from user where ID='" + id + "'";
                pst = con.prepareStatement(query);

                rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Record Deleted.");
                    userstableUpdate();
                } else {
                    JOptionPane.showMessageDialog(this, "Something went wrong!.");
                }
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_userdeletebuttonActionPerformed

    private void makeadminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeadminActionPerformed
        // TODO add your handling code here:

        Connection con = null;
        PreparedStatement pst = null;
        int rowsAffected = 0;
        DefaultTableModel model = (DefaultTableModel) usertable.getModel();
        String utype = "admin";

        int selectedIndex = usertable.getSelectedRow();
        int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
        int dialogresult = JOptionPane.showConfirmDialog(this, "Do you want update user role?", "Warning", JOptionPane.YES_NO_OPTION);

        if (dialogresult == JOptionPane.YES_NO_OPTION) {
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                con = DriverManager.getConnection("jdbc:ucanaccess://" + databasepath);
                String query = "update user set usertype='" + utype + "' where ID='" + id + "'";
                pst = con.prepareStatement(query);

                rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Record Updated.");
                    userstableUpdate();
                } else {
                    JOptionPane.showMessageDialog(this, "Something went wrong!.");
                }
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_makeadminActionPerformed

    private void deleteadminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteadminActionPerformed
        // TODO add your handling code here:

        Connection con = null;
        PreparedStatement pst = null;
        int rowsAffected = 0;
        DefaultTableModel model = (DefaultTableModel) admintable.getModel();
        int selectedIndex = admintable.getSelectedRow();
        int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
        int dialogresult = JOptionPane.showConfirmDialog(this, "Do you want to delete the record?", "Warning", JOptionPane.YES_NO_OPTION);

        if (dialogresult == JOptionPane.YES_NO_OPTION) {
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                con = DriverManager.getConnection("jdbc:ucanaccess://" + databasepath);
                String query = "delete from user where ID='" + id + "'";
                pst = con.prepareStatement(query);

                rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Record Deleted.");
                    admintableUpdate();
                } else {
                    JOptionPane.showMessageDialog(this, "Something went wrong!.");
                }
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_deleteadminActionPerformed

    private void makeuserbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeuserbuttonActionPerformed
        // TODO add your handling code here:

        Connection con = null;
        PreparedStatement pst = null;
        int rowsAffected = 0;
        DefaultTableModel model = (DefaultTableModel) admintable.getModel();
        String utype = "user";

        int selectedIndex = admintable.getSelectedRow();
        int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
        int dialogresult = JOptionPane.showConfirmDialog(this, "Do you want update user role?", "Warning", JOptionPane.YES_NO_OPTION);

        if (dialogresult == JOptionPane.YES_NO_OPTION) {
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                con = DriverManager.getConnection("jdbc:ucanaccess://" + databasepath);
                String query = "update user set usertype='" + utype + "' where ID='" + id + "'";
                pst = con.prepareStatement(query);

                rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Record Updated.");
                    admintableUpdate();
                } else {
                    JOptionPane.showMessageDialog(this, "Something went wrong!.");
                }
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_makeuserbuttonActionPerformed

    private void closeiconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeiconMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_closeiconMouseClicked

    private void minimizeiconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeiconMouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizeiconMouseClicked

    private void closeicon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeicon1MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_closeicon1MouseClicked

    private void minimizeicon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeicon1MouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizeicon1MouseClicked

    private void closeicon2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeicon2MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_closeicon2MouseClicked

    private void minimizeicon2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeicon2MouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizeicon2MouseClicked

    private void closeicon3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeicon3MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_closeicon3MouseClicked

    private void minimizeicon3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeicon3MouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizeicon3MouseClicked

    private void logoutbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutbuttonMouseClicked
        // TODO add your handling code here:
        LoginForm lf = new LoginForm();
        lf.show();
        dispose();
    }//GEN-LAST:event_logoutbuttonMouseClicked

    private void homebuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homebuttonMouseClicked
        // TODO add your handling code here:

        jTabbedPane1.setSelectedIndex(0);
        userstableUpdate();
        admintableUpdate();

        try {
            Connection con = null;
            PreparedStatement pst = null;
            ResultSet rs = null;
            String utype = "user";
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://" + databasepath);
            String query = "SELECT COUNT(*) FROM user WHERE usertype='" + utype + "'";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            int count = 0;
            if (rs.next()) {
                count = rs.getInt(1);
                totalusernumber.setText("" + count);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            Connection con = null;
            PreparedStatement pst = null;
            ResultSet rs = null;
            String utype = "admin";
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://" + databasepath);
            String query = "SELECT COUNT(*) FROM user WHERE usertype='" + utype + "'";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            int count = 0;
            if (rs.next()) {
                count = rs.getInt(1);
                totaladminnumber.setText("" + count);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_homebuttonMouseClicked

    private void usersgoldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersgoldMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
        userstableUpdate();
    }//GEN-LAST:event_usersgoldMouseClicked

    private void manageadminsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageadminsMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
        admintableUpdate();
    }//GEN-LAST:event_manageadminsMouseClicked

    private void recepibuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recepibuttonMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(3);
        recipetableUpdate();
    }//GEN-LAST:event_recepibuttonMouseClicked

    private void manageuserspanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageuserspanelMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
        userstableUpdate();
    }//GEN-LAST:event_manageuserspanelMouseClicked

    private void manageuserslabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageuserslabelMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
        userstableUpdate();
    }//GEN-LAST:event_manageuserslabelMouseClicked

    private void managerecipepanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_managerecipepanelMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(3);
        recipetableUpdate();
    }//GEN-LAST:event_managerecipepanelMouseClicked

    private void managerecipeslabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_managerecipeslabelMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(3);
        recipetableUpdate();
    }//GEN-LAST:event_managerecipeslabelMouseClicked

    private void manageadminlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageadminlabelMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
        admintableUpdate();
    }//GEN-LAST:event_manageadminlabelMouseClicked

    private void manageadminpanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageadminpanelMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
        admintableUpdate();
    }//GEN-LAST:event_manageadminpanelMouseClicked

    private void addrecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addrecordActionPerformed
        // TODO add your handling code here:
        String username = adminpanelusername.getText();
        String Id=userid.getText();
        InsertRecipe ir = new InsertRecipe(username,Id);
        ir.show();
        dispose();

    }//GEN-LAST:event_addrecordActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        Connection con = null;
        PreparedStatement pst = null;
        int rowsAffected = 0;
        DefaultTableModel model = (DefaultTableModel) managerecipestable.getModel();
        int selectedIndex = managerecipestable.getSelectedRow();
        int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
        
        int dialogresult = JOptionPane.showConfirmDialog(this, "Do you want to delete the record?", "Warning", JOptionPane.YES_NO_OPTION);

        if (dialogresult == JOptionPane.YES_NO_OPTION) {
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                con = DriverManager.getConnection("jdbc:ucanaccess://" + databasepath);
                String query = "delete from recipes where ID='" + id + "'";
                pst = con.prepareStatement(query);

                rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Record Deleted.");
                    recipetableUpdate();
                } else {
                    JOptionPane.showMessageDialog(this, "Something went wrong!.");
                }
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void profilebuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilebuttonMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_profilebuttonMouseClicked

    private void profilebackbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilebackbuttonMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_profilebackbuttonMouseClicked

    private void profilecloseiconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilecloseiconMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_profilecloseiconMouseClicked

    private void profileminimizeiconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileminimizeiconMouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_profileminimizeiconMouseClicked

    private void profilebackbutton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilebackbutton1MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_profilebackbutton1MouseClicked

    private void profileminimizeicon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileminimizeicon1MouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_profileminimizeicon1MouseClicked

    private void profilecloseicon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilecloseicon1MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_profilecloseicon1MouseClicked

    private void changepasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changepasswordActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_changepasswordActionPerformed

    
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
                        jTabbedPane1.setSelectedIndex(4);

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
            pst.executeUpdate();
            
              if (rs.next()) {
                     JOptionPane.showConfirmDialog(this, "Profile Updated Successfully", "Success", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                }
              else
              {
                  JOptionPane.showConfirmDialog(this, "something went wrong");
              }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_changeprofilebuttonActionPerformed

    private void updaterecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updaterecipeActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) managerecipestable.getModel();
        int selectedIndex = managerecipestable.getSelectedRow();
        int recipeid = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
        
        String username = adminpanelusername.getText();
        String uId=userid.getText();
        UpdateRecipe ur=new UpdateRecipe(username,uId,recipeid);
        ur.show();
        dispose();
    }//GEN-LAST:event_updaterecipeActionPerformed

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
            java.util.logging.Logger.getLogger(adminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addrecord;
    private javax.swing.JLabel admingreetings;
    private javax.swing.JLabel adminpanelusername;
    private javax.swing.JTable admintable;
    private javax.swing.JButton changepassword;
    private javax.swing.JButton changeprofilebutton;
    private javax.swing.JButton chnagepasswordbutton;
    private javax.swing.JLabel closeicon;
    private javax.swing.JLabel closeicon1;
    private javax.swing.JLabel closeicon2;
    private javax.swing.JLabel closeicon3;
    private javax.swing.JButton deleteadmin;
    private javax.swing.JTextField emailprofile;
    private javax.swing.JLabel homebutton;
    private javax.swing.JPasswordField inputconfirmpassword;
    private javax.swing.JPasswordField inputnewpassword;
    private javax.swing.JPasswordField inputoldpassword;
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lbltime;
    private javax.swing.JLabel logoutbutton;
    private javax.swing.JButton makeadmin;
    private javax.swing.JButton makeuserbutton;
    private javax.swing.JLabel manageadmin;
    private javax.swing.JLabel manageadmin1;
    private javax.swing.JLabel manageadminlabel;
    private Clases.PanelRound manageadminpanel;
    private javax.swing.JLabel manageadmins;
    private Clases.PanelRound managerecipepanel;
    private javax.swing.JLabel managerecipeslabel;
    private javax.swing.JTable managerecipestable;
    private javax.swing.JLabel manageuserslabel;
    private Clases.PanelRound manageuserspanel;
    private javax.swing.JLabel minimizeicon;
    private javax.swing.JLabel minimizeicon1;
    private javax.swing.JLabel minimizeicon2;
    private javax.swing.JLabel minimizeicon3;
    private javax.swing.JLabel oldpassworderror;
    private Clases.PanelRound panelRound1;
    private Clases.PanelRound panelRound10;
    private Clases.PanelRound panelRound2;
    private Clases.PanelRound panelRound3;
    private Clases.PanelRound panelRound4;
    private Clases.PanelRound panelRound5;
    private Clases.PanelRound panelRound6;
    private Clases.PanelRound panelRound9;
    private javax.swing.JLabel passnotmatch;
    private javax.swing.JLabel profilebackbutton;
    private javax.swing.JLabel profilebackbutton1;
    private javax.swing.JLabel profilebutton;
    private javax.swing.JLabel profilecloseicon;
    private javax.swing.JLabel profilecloseicon1;
    private javax.swing.JLabel profileminimizeicon;
    private javax.swing.JLabel profileminimizeicon1;
    private javax.swing.JLabel recepibutton;
    private javax.swing.JLabel totaladminnumber;
    private javax.swing.JLabel totalrecipes;
    private javax.swing.JLabel totalusernumber;
    private javax.swing.JButton updaterecipe;
    private javax.swing.JButton userdeletebutton;
    private javax.swing.JLabel userid;
    private javax.swing.JLabel username;
    private javax.swing.JLabel username1;
    private javax.swing.JTextField usernameprofile;
    private javax.swing.JLabel usersgold;
    private javax.swing.JTable usertable;
    // End of variables declaration//GEN-END:variables
}
