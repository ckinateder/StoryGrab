package main;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;
import keeptoo.Drag;

/**
 * Main class
 * @author Calvin Kinateder
 * git log --date=short --pretty=format:"Work on code,%s, ,%ad %ar"               
 * https://youtu.be/TOgTPm_AU_c
 * 
 */
public class LoginWindow extends javax.swing.JFrame {

    /**
     * Creates new form
     */
    public LoginWindow() {
        initComponents();
        verbosebtn.setSelected(true);
        verbosebtn.setText("X");
        setVerbose(true);
        setIcon();
        panelSwitcher(1);        
        updateSources();
        refreshChild.execute();
    }    
    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoginPanel = new keeptoo.KGradientPanel();
        userfield = new javax.swing.JTextField();
        pwdfield = new javax.swing.JPasswordField();
        orlabel = new javax.swing.JLabel();
        closelbl = new javax.swing.JLabel();
        helpbtn1 = new keeptoo.KButton();
        loginbtn = new keeptoo.KButton();
        profilelblicon = new javax.swing.JLabel();
        nouserwithname = new javax.swing.JLabel();
        pwdlbl = new javax.swing.JLabel();
        mainlogowithicon = new javax.swing.JLabel();
        userlbl1 = new javax.swing.JLabel();
        MainPanel = new keeptoo.KGradientPanel();
        closelbl1 = new javax.swing.JLabel();
        profileiconlbl = new javax.swing.JLabel();
        usertitlelbl = new javax.swing.JLabel();
        logoutbtn1 = new keeptoo.KButton();
        helpbtn = new keeptoo.KButton();
        extractorpanel = new javax.swing.JPanel();
        sourceslist = new javax.swing.JLabel();
        largeoutput = new javax.swing.JLabel();
        maincontrolpanel = new javax.swing.JPanel();
        extractbtn = new keeptoo.KButton();
        depthtogglepanel = new javax.swing.JPanel();
        depthlbl = new javax.swing.JLabel();
        plusdepthbtn = new keeptoo.KButton();
        dynamicdepthlbl = new javax.swing.JLabel();
        minusdepthbtn = new keeptoo.KButton();
        keywordfield = new javax.swing.JTextField();
        stopbtn = new keeptoo.KButton();
        statuslbl = new javax.swing.JLabel();
        htslbl = new javax.swing.JLabel();
        verbosepanel = new javax.swing.JPanel();
        cblbl2 = new javax.swing.JLabel();
        verbosebtn = new keeptoo.KButton();
        onelineout = new javax.swing.JLabel();
        websitelbl8 = new javax.swing.JLabel();
        sourceslbl = new javax.swing.JLabel();
        addsourcebtn2 = new keeptoo.KButton();
        addsourcebtn = new keeptoo.KButton();
        tipsbtnpanel = new javax.swing.JPanel();
        cblbl3 = new javax.swing.JLabel();
        tipsbtn = new keeptoo.KButton();
        stopbtn1 = new keeptoo.KButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("StoryGrab");
        setLocation(new java.awt.Point(0, 0));
        setLocationByPlatform(true);
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, 870, 600, 20, 20));
        setSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LoginPanel.setBackground(new Color(0,0,0,0));
        LoginPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        LoginPanel.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        LoginPanel.setkBorderRadius(20);
        LoginPanel.setkEndColor(new java.awt.Color(51, 51, 140));
        LoginPanel.setkGradientFocus(250);
        LoginPanel.setkStartColor(new java.awt.Color(83, 97, 112));
        LoginPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                LoginPanelMouseDragged(evt);
            }
        });
        LoginPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LoginPanelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                LoginPanelMouseReleased(evt);
            }
        });
        LoginPanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LoginPanelKeyPressed(evt);
            }
        });
        LoginPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userfield.setBackground(new Color(0,0,0,0));
        userfield.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        userfield.setForeground(new java.awt.Color(255, 255, 255));
        userfield.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        userfield.setCaretColor(new java.awt.Color(255, 255, 255));
        userfield.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        userfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userfieldActionPerformed(evt);
            }
        });
        LoginPanel.add(userfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 350, 30));
        userfield.getAccessibleContext().setAccessibleName("");

        pwdfield.setBackground(new Color(0,0,0,0));
        pwdfield.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        pwdfield.setForeground(new java.awt.Color(255, 255, 255));
        pwdfield.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        pwdfield.setCaretColor(new java.awt.Color(255, 255, 255));
        LoginPanel.add(pwdfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, 350, 30));

        orlabel.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        orlabel.setForeground(new java.awt.Color(255, 255, 255));
        orlabel.setText("or");
        LoginPanel.add(orlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 460, -1, -1));

        closelbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        closelbl.setForeground(new java.awt.Color(255, 255, 255));
        closelbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-cancel-32.png"))); // NOI18N
        closelbl.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                closelblMouseDragged(evt);
            }
        });
        closelbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                closelblMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                closelblMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closelblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closelblMouseEntered(evt);
            }
        });
        LoginPanel.add(closelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 30, 30));

        helpbtn1.setText("Help");
        helpbtn1.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        helpbtn1.setkAllowTab(false);
        helpbtn1.setkBackGroundColor(new java.awt.Color(255, 255, 255));
        helpbtn1.setkBorderRadius(40);
        helpbtn1.setkEndColor(new java.awt.Color(0, 204, 51));
        helpbtn1.setkHoverEndColor(new java.awt.Color(78, 160, 143));
        helpbtn1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        helpbtn1.setkHoverStartColor(new java.awt.Color(63, 167, 89));
        helpbtn1.setkIndicatorThickness(0);
        helpbtn1.setkPressedColor(new java.awt.Color(167, 69, 199));
        helpbtn1.setkSelectedColor(new java.awt.Color(163, 62, 167));
        helpbtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                helpbtn1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                helpbtn1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                helpbtn1MouseReleased(evt);
            }
        });
        helpbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpbtn1ActionPerformed(evt);
            }
        });
        helpbtn1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                helpbtn1KeyPressed(evt);
            }
        });
        LoginPanel.add(helpbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 450, 150, 40));

        loginbtn.setText("Login");
        loginbtn.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        loginbtn.setkAllowTab(false);
        loginbtn.setkBorderRadius(40);
        loginbtn.setkEndColor(new java.awt.Color(0, 204, 51));
        loginbtn.setkHoverEndColor(new java.awt.Color(78, 160, 143));
        loginbtn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        loginbtn.setkHoverStartColor(new java.awt.Color(63, 167, 89));
        loginbtn.setkIndicatorThickness(0);
        loginbtn.setkPressedColor(new java.awt.Color(167, 69, 199));
        loginbtn.setkSelectedColor(new java.awt.Color(163, 62, 167));
        loginbtn.setName(""); // NOI18N
        loginbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loginbtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                loginbtnMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginbtnMouseClicked(evt);
            }
        });
        loginbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbtnActionPerformed(evt);
            }
        });
        LoginPanel.add(loginbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 450, 150, 40));

        profilelblicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-male-user-50.png"))); // NOI18N
        LoginPanel.add(profilelblicon, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, -1, -1));

        nouserwithname.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        nouserwithname.setForeground(new java.awt.Color(255, 255, 255));
        LoginPanel.add(nouserwithname, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, 400, 20));

        pwdlbl.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        pwdlbl.setForeground(new java.awt.Color(255, 255, 255));
        pwdlbl.setText("password");
        LoginPanel.add(pwdlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 70, -1));

        mainlogowithicon.setFont(new java.awt.Font("Ubuntu", 0, 28)); // NOI18N
        mainlogowithicon.setForeground(new java.awt.Color(255, 255, 255));
        mainlogowithicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-news-50.png"))); // NOI18N
        mainlogowithicon.setText(" StoryGrab");
        LoginPanel.add(mainlogowithicon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 230, 60));

        userlbl1.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        userlbl1.setForeground(new java.awt.Color(255, 255, 255));
        userlbl1.setText("username");
        LoginPanel.add(userlbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 70, -1));

        getContentPane().add(LoginPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 600));

        MainPanel.setBackground(new Color(0,0,0,0));
        MainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        MainPanel.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        MainPanel.setkBorderRadius(20);
        MainPanel.setkEndColor(new java.awt.Color(51, 51, 140));
        MainPanel.setkGradientFocus(250);
        MainPanel.setkStartColor(new java.awt.Color(83, 97, 112));
        MainPanel.setOpaque(false);
        MainPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                MainPanelMouseDragged(evt);
            }
        });
        MainPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MainPanelMousePressed(evt);
            }
        });
        MainPanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                MainPanelKeyPressed(evt);
            }
        });
        MainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        closelbl1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        closelbl1.setForeground(new java.awt.Color(255, 255, 255));
        closelbl1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-cancel-32.png"))); // NOI18N
        closelbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                closelbl1MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closelbl1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closelbl1MouseEntered(evt);
            }
        });
        MainPanel.add(closelbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 30, 30));

        profileiconlbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-news-50.png"))); // NOI18N
        MainPanel.add(profileiconlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 60));

        usertitlelbl.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        usertitlelbl.setForeground(new java.awt.Color(255, 255, 255));
        usertitlelbl.setText("ckinateder");
        MainPanel.add(usertitlelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 320, 30));

        logoutbtn1.setText("Logout");
        logoutbtn1.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        logoutbtn1.setkAllowTab(false);
        logoutbtn1.setkBorderRadius(40);
        logoutbtn1.setkEndColor(new java.awt.Color(0, 204, 51));
        logoutbtn1.setkFillButton(false);
        logoutbtn1.setkHoverColor(new java.awt.Color(255, 255, 0));
        logoutbtn1.setkHoverEndColor(new java.awt.Color(78, 160, 143));
        logoutbtn1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        logoutbtn1.setkHoverStartColor(new java.awt.Color(63, 167, 89));
        logoutbtn1.setkIndicatorThickness(0);
        logoutbtn1.setkPressedColor(new java.awt.Color(167, 69, 199));
        logoutbtn1.setkSelectedColor(new java.awt.Color(163, 62, 167));
        logoutbtn1.setName(""); // NOI18N
        logoutbtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logoutbtn1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                logoutbtn1MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutbtn1MouseClicked(evt);
            }
        });
        logoutbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutbtn1ActionPerformed(evt);
            }
        });
        MainPanel.add(logoutbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, 100, 40));

        helpbtn.setText("Help");
        helpbtn.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        helpbtn.setkAllowTab(false);
        helpbtn.setkBackGroundColor(new java.awt.Color(255, 255, 255));
        helpbtn.setkBorderRadius(40);
        helpbtn.setkEndColor(new java.awt.Color(0, 204, 51));
        helpbtn.setkHoverEndColor(new java.awt.Color(78, 160, 143));
        helpbtn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        helpbtn.setkHoverStartColor(new java.awt.Color(63, 167, 89));
        helpbtn.setkIndicatorThickness(0);
        helpbtn.setkPressedColor(new java.awt.Color(167, 69, 199));
        helpbtn.setkSelectedColor(new java.awt.Color(163, 62, 167));
        helpbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                helpbtnMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                helpbtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                helpbtnMouseReleased(evt);
            }
        });
        helpbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpbtnActionPerformed(evt);
            }
        });
        helpbtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                helpbtnKeyPressed(evt);
            }
        });
        MainPanel.add(helpbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 550, 120, 40));

        extractorpanel.setOpaque(false);
        extractorpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sourceslist.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        sourceslist.setForeground(new java.awt.Color(255, 255, 255));
        sourceslist.setText("Add a source");
        sourceslist.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        sourceslist.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        sourceslist.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                sourceslistMouseWheelMoved(evt);
            }
        });
        extractorpanel.add(sourceslist, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 300, 210));

        largeoutput.setFont(new java.awt.Font("Ubuntu Mono", 0, 14)); // NOI18N
        largeoutput.setForeground(new java.awt.Color(255, 255, 255));
        largeoutput.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        largeoutput.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        extractorpanel.add(largeoutput, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 470, 210));

        maincontrolpanel.setOpaque(false);
        maincontrolpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        extractbtn.setText("Extract");
        extractbtn.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        extractbtn.setkAllowTab(false);
        extractbtn.setkBorderRadius(40);
        extractbtn.setkEndColor(new java.awt.Color(0, 204, 51));
        extractbtn.setkHoverColor(new java.awt.Color(255, 102, 204));
        extractbtn.setkHoverEndColor(new java.awt.Color(78, 160, 143));
        extractbtn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        extractbtn.setkHoverStartColor(new java.awt.Color(63, 167, 89));
        extractbtn.setkIndicatorThickness(0);
        extractbtn.setkPressedColor(new java.awt.Color(167, 69, 199));
        extractbtn.setkSelectedColor(new java.awt.Color(163, 62, 167));
        extractbtn.setName(""); // NOI18N
        extractbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                extractbtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                extractbtnMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                extractbtnMouseClicked(evt);
            }
        });
        extractbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extractbtnActionPerformed(evt);
            }
        });
        maincontrolpanel.add(extractbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 100, 40));

        depthtogglepanel.setOpaque(false);

        depthlbl.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        depthlbl.setForeground(new java.awt.Color(255, 255, 255));
        depthlbl.setText("Depth");

        plusdepthbtn.setText("+");
        plusdepthbtn.setFont(new java.awt.Font("Ubuntu", 0, 30)); // NOI18N
        plusdepthbtn.setkAllowTab(false);
        plusdepthbtn.setkBorderRadius(40);
        plusdepthbtn.setkEndColor(new java.awt.Color(0, 204, 51));
        plusdepthbtn.setkHoverEndColor(new java.awt.Color(78, 160, 143));
        plusdepthbtn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        plusdepthbtn.setkHoverStartColor(new java.awt.Color(63, 167, 89));
        plusdepthbtn.setkIndicatorThickness(0);
        plusdepthbtn.setkPressedColor(new java.awt.Color(167, 69, 199));
        plusdepthbtn.setkSelectedColor(new java.awt.Color(163, 62, 167));
        plusdepthbtn.setName(""); // NOI18N
        plusdepthbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plusdepthbtnMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                plusdepthbtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                plusdepthbtnMouseReleased(evt);
            }
        });
        plusdepthbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusdepthbtnActionPerformed(evt);
            }
        });

        dynamicdepthlbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        dynamicdepthlbl.setForeground(new java.awt.Color(255, 255, 255));
        dynamicdepthlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dynamicdepthlbl.setText("0");

        minusdepthbtn.setText("-");
        minusdepthbtn.setToolTipText("");
        minusdepthbtn.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        minusdepthbtn.setkAllowTab(false);
        minusdepthbtn.setkBorderRadius(40);
        minusdepthbtn.setkEndColor(new java.awt.Color(0, 204, 51));
        minusdepthbtn.setkHoverEndColor(new java.awt.Color(78, 160, 143));
        minusdepthbtn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        minusdepthbtn.setkHoverStartColor(new java.awt.Color(63, 167, 89));
        minusdepthbtn.setkIndicatorThickness(0);
        minusdepthbtn.setkPressedColor(new java.awt.Color(167, 69, 199));
        minusdepthbtn.setkSelectedColor(new java.awt.Color(163, 62, 167));
        minusdepthbtn.setName(""); // NOI18N
        minusdepthbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minusdepthbtnMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                minusdepthbtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                minusdepthbtnMouseReleased(evt);
            }
        });
        minusdepthbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minusdepthbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout depthtogglepanelLayout = new javax.swing.GroupLayout(depthtogglepanel);
        depthtogglepanel.setLayout(depthtogglepanelLayout);
        depthtogglepanelLayout.setHorizontalGroup(
            depthtogglepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(depthtogglepanelLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(depthlbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(minusdepthbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(dynamicdepthlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(plusdepthbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        depthtogglepanelLayout.setVerticalGroup(
            depthtogglepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(depthtogglepanelLayout.createSequentialGroup()
                .addGroup(depthtogglepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(plusdepthbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dynamicdepthlbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(minusdepthbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(depthlbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 5, Short.MAX_VALUE))
        );

        maincontrolpanel.add(depthtogglepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, -1));

        keywordfield.setBackground(new Color(0,0,0,0));
        keywordfield.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        keywordfield.setForeground(new java.awt.Color(255, 255, 255));
        keywordfield.setText("trump");
        keywordfield.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        keywordfield.setCaretColor(new java.awt.Color(255, 255, 255));
        keywordfield.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        keywordfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keywordfieldActionPerformed(evt);
            }
        });
        maincontrolpanel.add(keywordfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 440, 30));

        stopbtn.setText("Stop");
        stopbtn.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        stopbtn.setkAllowTab(false);
        stopbtn.setkBorderRadius(40);
        stopbtn.setkEndColor(new java.awt.Color(0, 204, 51));
        stopbtn.setkHoverColor(new java.awt.Color(255, 102, 204));
        stopbtn.setkHoverEndColor(new java.awt.Color(78, 160, 143));
        stopbtn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        stopbtn.setkHoverStartColor(new java.awt.Color(63, 167, 89));
        stopbtn.setkIndicatorThickness(0);
        stopbtn.setkPressedColor(new java.awt.Color(167, 69, 199));
        stopbtn.setkSelectedColor(new java.awt.Color(163, 62, 167));
        stopbtn.setName(""); // NOI18N
        stopbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                stopbtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                stopbtnMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stopbtnMouseClicked(evt);
            }
        });
        stopbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopbtnActionPerformed(evt);
            }
        });
        maincontrolpanel.add(stopbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 100, 40));

        statuslbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        statuslbl.setForeground(new java.awt.Color(255, 255, 255));
        maincontrolpanel.add(statuslbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 130, 20));

        htslbl.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        htslbl.setForeground(new java.awt.Color(255, 255, 255));
        maincontrolpanel.add(htslbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 60, 30));

        verbosepanel.setOpaque(false);

        cblbl2.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cblbl2.setForeground(new java.awt.Color(255, 255, 255));
        cblbl2.setText("Verbose");

        verbosebtn.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        verbosebtn.setIconTextGap(0);
        verbosebtn.setkAllowTab(false);
        verbosebtn.setkEndColor(new java.awt.Color(0, 204, 51));
        verbosebtn.setkHoverColor(new java.awt.Color(249, 153, 217));
        verbosebtn.setkHoverEndColor(new java.awt.Color(78, 160, 143));
        verbosebtn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        verbosebtn.setkHoverStartColor(new java.awt.Color(63, 167, 89));
        verbosebtn.setkIndicatorThickness(0);
        verbosebtn.setkPressedColor(new java.awt.Color(163, 62, 167));
        verbosebtn.setkSelectedColor(new java.awt.Color(163, 62, 167));
        verbosebtn.setMargin(new java.awt.Insets(2, 2, 2, 2));
        verbosebtn.setName(""); // NOI18N
        verbosebtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verbosebtnMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                verbosebtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                verbosebtnMouseReleased(evt);
            }
        });
        verbosebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verbosebtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout verbosepanelLayout = new javax.swing.GroupLayout(verbosepanel);
        verbosepanel.setLayout(verbosepanelLayout);
        verbosepanelLayout.setHorizontalGroup(
            verbosepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(verbosepanelLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(verbosebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cblbl2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        verbosepanelLayout.setVerticalGroup(
            verbosepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(verbosepanelLayout.createSequentialGroup()
                .addGroup(verbosepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(verbosebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(cblbl2, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addGap(0, 5, Short.MAX_VALUE))
        );

        maincontrolpanel.add(verbosepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 90, -1));

        onelineout.setFont(new java.awt.Font("Ubuntu Mono", 0, 14)); // NOI18N
        onelineout.setForeground(new java.awt.Color(255, 255, 255));
        maincontrolpanel.add(onelineout, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 410, 40));

        websitelbl8.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        websitelbl8.setForeground(new java.awt.Color(255, 255, 255));
        websitelbl8.setText("Keyword");
        maincontrolpanel.add(websitelbl8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, -1));

        extractorpanel.add(maincontrolpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 780, 180));

        sourceslbl.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        sourceslbl.setForeground(new java.awt.Color(255, 255, 255));
        sourceslbl.setText("Sources");
        extractorpanel.add(sourceslbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 100, 30));

        MainPanel.add(extractorpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 810, 440));

        addsourcebtn2.setText("Output");
        addsourcebtn2.setEnabled(false);
        addsourcebtn2.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        addsourcebtn2.setkAllowTab(false);
        addsourcebtn2.setkBorderRadius(40);
        addsourcebtn2.setkEndColor(new java.awt.Color(0, 204, 51));
        addsourcebtn2.setkHoverColor(new java.awt.Color(255, 102, 204));
        addsourcebtn2.setkHoverEndColor(new java.awt.Color(78, 160, 143));
        addsourcebtn2.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        addsourcebtn2.setkHoverStartColor(new java.awt.Color(63, 167, 89));
        addsourcebtn2.setkIndicatorThickness(0);
        addsourcebtn2.setkPressedColor(new java.awt.Color(167, 69, 199));
        addsourcebtn2.setkSelectedColor(new java.awt.Color(163, 62, 167));
        addsourcebtn2.setName(""); // NOI18N
        addsourcebtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addsourcebtn2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addsourcebtn2MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addsourcebtn2MouseClicked(evt);
            }
        });
        addsourcebtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addsourcebtn2ActionPerformed(evt);
            }
        });
        MainPanel.add(addsourcebtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 550, 100, 40));

        addsourcebtn.setText("Sources Editor");
        addsourcebtn.setEnabled(false);
        addsourcebtn.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        addsourcebtn.setkAllowTab(false);
        addsourcebtn.setkBorderRadius(40);
        addsourcebtn.setkEndColor(new java.awt.Color(0, 204, 51));
        addsourcebtn.setkHoverColor(new java.awt.Color(255, 102, 204));
        addsourcebtn.setkHoverEndColor(new java.awt.Color(78, 160, 143));
        addsourcebtn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        addsourcebtn.setkHoverStartColor(new java.awt.Color(63, 167, 89));
        addsourcebtn.setkIndicatorThickness(0);
        addsourcebtn.setkPressedColor(new java.awt.Color(167, 69, 199));
        addsourcebtn.setkSelectedColor(new java.awt.Color(163, 62, 167));
        addsourcebtn.setName(""); // NOI18N
        addsourcebtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addsourcebtnMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addsourcebtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addsourcebtnMouseReleased(evt);
            }
        });
        addsourcebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addsourcebtnActionPerformed(evt);
            }
        });
        MainPanel.add(addsourcebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 550, 120, 40));

        tipsbtnpanel.setOpaque(false);

        cblbl3.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cblbl3.setForeground(new java.awt.Color(255, 255, 255));
        cblbl3.setText("Tips");

        tipsbtn.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        tipsbtn.setIconTextGap(0);
        tipsbtn.setkAllowTab(false);
        tipsbtn.setkEndColor(new java.awt.Color(0, 204, 51));
        tipsbtn.setkHoverColor(new java.awt.Color(249, 153, 217));
        tipsbtn.setkHoverEndColor(new java.awt.Color(78, 160, 143));
        tipsbtn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        tipsbtn.setkHoverStartColor(new java.awt.Color(63, 167, 89));
        tipsbtn.setkIndicatorThickness(0);
        tipsbtn.setkPressedColor(new java.awt.Color(163, 62, 167));
        tipsbtn.setkSelectedColor(new java.awt.Color(163, 62, 167));
        tipsbtn.setMargin(new java.awt.Insets(2, 2, 2, 2));
        tipsbtn.setName(""); // NOI18N
        tipsbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tipsbtnMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tipsbtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tipsbtnMouseReleased(evt);
            }
        });
        tipsbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipsbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tipsbtnpanelLayout = new javax.swing.GroupLayout(tipsbtnpanel);
        tipsbtnpanel.setLayout(tipsbtnpanelLayout);
        tipsbtnpanelLayout.setHorizontalGroup(
            tipsbtnpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tipsbtnpanelLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(tipsbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cblbl3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tipsbtnpanelLayout.setVerticalGroup(
            tipsbtnpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tipsbtnpanelLayout.createSequentialGroup()
                .addGroup(tipsbtnpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tipsbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(cblbl3, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addGap(0, 5, Short.MAX_VALUE))
        );

        MainPanel.add(tipsbtnpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 560, -1, -1));

        stopbtn1.setText("Quit");
        stopbtn1.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        stopbtn1.setkAllowTab(false);
        stopbtn1.setkBorderRadius(40);
        stopbtn1.setkEndColor(new java.awt.Color(0, 204, 51));
        stopbtn1.setkHoverColor(new java.awt.Color(255, 102, 204));
        stopbtn1.setkHoverEndColor(new java.awt.Color(78, 160, 143));
        stopbtn1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        stopbtn1.setkHoverStartColor(new java.awt.Color(63, 167, 89));
        stopbtn1.setkIndicatorThickness(0);
        stopbtn1.setkPressedColor(new java.awt.Color(167, 69, 199));
        stopbtn1.setkSelectedColor(new java.awt.Color(163, 62, 167));
        stopbtn1.setName(""); // NOI18N
        stopbtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                stopbtn1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                stopbtn1MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stopbtn1MouseClicked(evt);
            }
        });
        stopbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopbtn1ActionPerformed(evt);
            }
        });
        MainPanel.add(stopbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 550, 100, 40));

        getContentPane().add(MainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // <editor-fold defaultstate="collapsed" desc="Label and Button Functions">
    private void userfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userfieldActionPerformed
        // TODO add your handling code here:
     
    }//GEN-LAST:event_userfieldActionPerformed

    private void LoginPanelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LoginPanelKeyPressed
        // TODO add your handling code here:
        //
       
        
    }//GEN-LAST:event_LoginPanelKeyPressed

    private void LoginPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginPanelMouseDragged
        // TODO add your handling code here:
        //drag here
        new Drag(LoginPanel).moveWindow(evt);
    }//GEN-LAST:event_LoginPanelMouseDragged

    private void LoginPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginPanelMousePressed
        // TODO add your handling code here:
         new Drag(LoginPanel).onPress(evt);
         //use mouse always 
    }//GEN-LAST:event_LoginPanelMousePressed

    private void closelblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closelblMouseClicked
        // TODO add your handling code here:
        quit();
    }//GEN-LAST:event_closelblMouseClicked

    private void closelblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closelblMouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_closelblMouseEntered

    private void helpbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpbtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_helpbtn1ActionPerformed

    private void loginbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginbtnActionPerformed

    private void loginbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginbtnMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_loginbtnMouseClicked

    private void closelbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closelbl1MouseClicked
        // TODO add your handling code here:
        quit();
    }//GEN-LAST:event_closelbl1MouseClicked

    private void closelbl1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closelbl1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_closelbl1MouseEntered

    private void MainPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MainPanelMouseDragged
        // TODO add your handling code here:
        new Drag(LoginPanel).moveWindow(evt);

    }//GEN-LAST:event_MainPanelMouseDragged

    private void MainPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MainPanelMousePressed
        // TODO add your handling code here:
        new Drag(LoginPanel).onPress(evt);
    
    }//GEN-LAST:event_MainPanelMousePressed

    private void MainPanelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MainPanelKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_MainPanelKeyPressed

    private void helpbtn1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_helpbtn1KeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_helpbtn1KeyPressed

    private void helpbtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpbtn1MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_helpbtn1MouseClicked

    private void loginbtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginbtnMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_loginbtnMousePressed

    private void closelblMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closelblMousePressed
        // TODO add your handling code here:
        //quit();
    }//GEN-LAST:event_closelblMousePressed

    private void closelblMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closelblMouseDragged
        // TODO add your handling code here:
        quit();
    }//GEN-LAST:event_closelblMouseDragged

    private void closelblMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closelblMouseReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_closelblMouseReleased

    private void helpbtn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpbtn1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_helpbtn1MousePressed

    private void helpbtn1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpbtn1MouseReleased
        // TODO add your handling code here:
        //resetAllFields();
        //panelSwitcher(3);
        help();
    }//GEN-LAST:event_helpbtn1MouseReleased

    private void loginbtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginbtnMouseReleased
        // TODO add your handling code here:
        //CreateAccountPanel.setVisible(false);
        //change to ref not val
        login();
    }//GEN-LAST:event_loginbtnMouseReleased

    private void closelbl1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closelbl1MouseReleased
        // TODO add your handling code here:
        quit();
    }//GEN-LAST:event_closelbl1MouseReleased

    private void LoginPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginPanelMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginPanelMouseReleased

    private void logoutbtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutbtn1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_logoutbtn1MouseClicked

    private void logoutbtn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutbtn1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_logoutbtn1MousePressed

    private void logoutbtn1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutbtn1MouseReleased
        // TODO add your handling code here:
        logout();
    }//GEN-LAST:event_logoutbtn1MouseReleased

    private void logoutbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutbtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logoutbtn1ActionPerformed

    private void minusdepthbtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minusdepthbtnMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_minusdepthbtnMousePressed

    private void minusdepthbtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minusdepthbtnMouseReleased
        // TODO add your handling code here:
        changeDepth(-1);
        dynamicdepthlbl.setText(""+loader.getMaxDepth());
    }//GEN-LAST:event_minusdepthbtnMouseReleased

    private void minusdepthbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minusdepthbtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_minusdepthbtnMouseClicked

    private void minusdepthbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minusdepthbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_minusdepthbtnActionPerformed

    private void extractbtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_extractbtnMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_extractbtnMousePressed

    private void extractbtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_extractbtnMouseReleased
        
        try {
            // TODO add your handling code here:            
            extract();
        } catch (InterruptedException ex) {
            Logger.getLogger(LoginWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_extractbtnMouseReleased

    private void extractbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_extractbtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_extractbtnMouseClicked

    private void extractbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_extractbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_extractbtnActionPerformed

    private void plusdepthbtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plusdepthbtnMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_plusdepthbtnMousePressed

    private void plusdepthbtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plusdepthbtnMouseReleased
        // TODO add your handling code here:
        changeDepth(1);
        dynamicdepthlbl.setText(""+loader.getMaxDepth());

    }//GEN-LAST:event_plusdepthbtnMouseReleased

    private void plusdepthbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plusdepthbtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_plusdepthbtnMouseClicked

    private void plusdepthbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusdepthbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_plusdepthbtnActionPerformed

    private void keywordfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keywordfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_keywordfieldActionPerformed

    private void stopbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stopbtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_stopbtnMouseClicked

    private void stopbtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stopbtnMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_stopbtnMousePressed

    private void stopbtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stopbtnMouseReleased
        try {
            // TODO add your handling code here:
            stopExtract();
        } catch (InterruptedException ex) {
            Logger.getLogger(LoginWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_stopbtnMouseReleased

    private void stopbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stopbtnActionPerformed

    private void addsourcebtn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addsourcebtn2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_addsourcebtn2MouseClicked

    private void addsourcebtn2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addsourcebtn2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_addsourcebtn2MousePressed

    private void addsourcebtn2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addsourcebtn2MouseReleased
        try {
            // TODO add your handling code here:
            openOutput();
        } catch (IOException ex) {
            Logger.getLogger(LoginWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addsourcebtn2MouseReleased

    private void addsourcebtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addsourcebtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addsourcebtn2ActionPerformed

    private void sourceslistMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_sourceslistMouseWheelMoved
        // TODO add your handling code here:
        sourceScroller.scrollSources(evt);
    }//GEN-LAST:event_sourceslistMouseWheelMoved

    private void verbosebtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verbosebtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_verbosebtnMouseClicked

    private void verbosebtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verbosebtnMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_verbosebtnMousePressed

    private void verbosebtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verbosebtnMouseReleased
        // TODO add your handling code here:
        if(verbosebtn.isSelected()){
            verbosebtn.setSelected(false);
            verbosebtn.setText("");
            setVerbose(false);
        }
        else{
            verbosebtn.setSelected(true);
            verbosebtn.setText("X");
            setVerbose(true);
        }
    }//GEN-LAST:event_verbosebtnMouseReleased

    private void verbosebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verbosebtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_verbosebtnActionPerformed

    private void tipsbtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tipsbtnMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipsbtnMousePressed

    private void tipsbtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tipsbtnMouseReleased
        // TODO add your handling code here:
        if(tipsbtn.isSelected()){
            tipsbtn.setSelected(false);
            tipsbtn.setText("");
            setTips(false);
        }
        else{
            tipsbtn.setSelected(true);
            tipsbtn.setText("X");
            setTips(true);            
        }
    }//GEN-LAST:event_tipsbtnMouseReleased

    private void tipsbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tipsbtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tipsbtnMouseClicked

    private void tipsbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipsbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipsbtnActionPerformed

    private void addsourcebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addsourcebtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addsourcebtnActionPerformed

    private void addsourcebtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addsourcebtnMouseReleased
        try {
            // TODO add your handling code here:
            //sourcesEditor();
            openSources();
        } catch (IOException ex) {
            Logger.getLogger(LoginWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addsourcebtnMouseReleased

    private void addsourcebtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addsourcebtnMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_addsourcebtnMousePressed

    private void addsourcebtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addsourcebtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_addsourcebtnMouseClicked

    private void stopbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopbtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stopbtn1ActionPerformed

    private void stopbtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stopbtn1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_stopbtn1MouseClicked

    private void stopbtn1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stopbtn1MouseReleased
        // TODO add your handling code here:
        quit();
    }//GEN-LAST:event_stopbtn1MouseReleased

    private void stopbtn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stopbtn1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_stopbtn1MousePressed

    private void helpbtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpbtnMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_helpbtnMousePressed

    private void helpbtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpbtnMouseReleased
        // TODO add your handling code here:
        help();
    }//GEN-LAST:event_helpbtnMouseReleased

    private void helpbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpbtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_helpbtnMouseClicked

    private void helpbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_helpbtnActionPerformed

    private void helpbtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_helpbtnKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_helpbtnKeyPressed
    
    // </editor-fold> 
    
    String iconFile = "/icons/icons8-news-50.png";
    String sourceFile = "sources.txt";
    String outputFile = "out/storygrab.html";
    User currentusr;
    BackgroundRunner loader = new BackgroundRunner();
    SwingWorker backburner = loader.createWorker();
    Scroller sourceScroller = new Scroller(loader);
    ArrayList<Link> linkset = new ArrayList<>(); //fill with links
    AutomaticScrollUpdater refresher =
            new AutomaticScrollUpdater(sourceScroller);
    SwingWorker refreshChild = refresher.createWorker();
    /**
     * Resets all text fields.
     */
    public void resetAllFields(){
        pwdfield.setText("");
        userfield.setText("");
        nouserwithname.setText("");
        usertitlelbl.setText("");
        dynamicdepthlbl.setText(""+loader.getMaxDepth());
        statuslbl.setText("");
    }
    /**
     * Changes the BackgroundRunner object depth.
     * @param t depth to change to
     */
    public void changeDepth(int t){
        loader.setMaxDepth(loader.getMaxDepth()+t);
    }
    /**
     * Sets whether output is verbose or not.
     * @param t boolean to set to
     */
    public void setVerbose(boolean t){
        loader.setVerbose(t);
    }
    /**
     * Opens text file containing the sources to search.
     * @throws IOException if desktop not supported
     */
    public void openSources() throws IOException{
        openFile(sourceFile);
    }
    public void openFile(String f) throws IOException {
        if(!loader.isRunning()){
            File file = new File(f);
            //first check if Desktop is supported by Platform or not
            if(!Desktop.isDesktopSupported()){
                System.out.println("Desktop is not supported");
                return;
            }
            Desktop desktop = Desktop.getDesktop();
            if(file.exists()) desktop.open(file);
        }
        else{
            //send messsage
        }
    }
    /**
     * Sets the toolTipText for everything.
     * @param t boolean whether it should be on or off
     */
    public void setTips(boolean t){
        if(t){
            //add all the tooltiptexts
            userfield.setToolTipText("Use AEP username");
            pwdfield.setToolTipText("Use AEP password\nNone of this is stored"
                    + " outside of the JVM");
            loginbtn.setToolTipText("Open the operations window");
            sourceslist.setToolTipText("All sources");
            keywordfield.setToolTipText("Keyword to search for");
            depthtogglepanel.setToolTipText("Set how deep the extractor will "
                    + "recursively explore");
            verbosepanel.setToolTipText("Verbose output");
            extractbtn.setToolTipText("Start extracting");
            stopbtn.setToolTipText("Stop extracting");
            tipsbtnpanel.setToolTipText("Tips");
            logoutbtn1.setToolTipText("Logout");
            addsourcebtn.setToolTipText("Edit sources");
        }
        else{
            userfield.setToolTipText(null);
            pwdfield.setToolTipText(null);                    
            loginbtn.setToolTipText(null);
            sourceslist.setToolTipText(null);
            keywordfield.setToolTipText(null);
            depthtogglepanel.setToolTipText(null);
            verbosepanel.setToolTipText(null);
            extractbtn.setToolTipText(null);
            stopbtn.setToolTipText(null);
            tipsbtnpanel.setToolTipText(null);
            logoutbtn1.setToolTipText(null);
            addsourcebtn.setToolTipText(null);
        }
    }
    /**
     * Switches the screen from the main to login and login to main
     * @param sw int to switch to; 1 for login, 2 for main
     */
    public void panelSwitcher(int sw){
        resetAllFields();
        sourceScroller.setLabel(sourceslist);
        updateSources();
        //1 for login,2 for main
        switch(sw){
            case 1:
                LoginPanel.setVisible(true);
                MainPanel.setVisible(false);
                break;
            case 2:
                LoginPanel.setVisible(false);
                MainPanel.setVisible(true);
                usertitlelbl.setText(currentusr.screenName);                
                break;
        }
        
    }
    /**
     * Switches to login screen.
     */
    public void login(){//SECURE VERSION      
        currentusr = new User(userfield.getText(),
                new String(pwdfield.getPassword()));        
        panelSwitcher(2);
    }
    /**
     * Logs out the user and switches to the login screen.
     */
    public void logout(){
        currentusr = null;
        panelSwitcher(1);
    }
    /**
     * Opens the help menu.
     */
    public void help(){
        //HelpMenu hw = new HelpMenu();
        String[] sg = new String[0];
        HelpMenu.main(sg);
    }
    /**
     * Opens the output HTML file.
     * @throws IOException if desktop not supported
     */
    public void openOutput() throws IOException{        
        openFile(outputFile);
    }/**
     * Starts the extraction process.
     * @throws InterruptedException if thread is interrupted
     */
    public void extract() throws InterruptedException{
        if(!loader.isRunning()){
            loader.res();
            loader.setVerbose(true);
            backburner = loader.createWorker(); //move these to extract.
            loader.passVec(linkset);
            loader.passLbl(statuslbl);
            loader.passInitializedOP(onelineout);
            loader.passBigOut(largeoutput);
            loader.passHitsLbl(htslbl);
            updateSources();    
            loader.setBefore(keywordfield.getText(),currentusr);//add depth here             
            backburner.execute();
            statuslbl.setText("Extracting...");            
        }
    }
    /**
     * Stops the extraction process.
     * @throws InterruptedException if thread is interrupted
     */
    public void stopExtract() throws InterruptedException{
        loader.broStop();
    }
    /**
     * Updates sources.
     */
    public void updateSources(){        
        sourceScroller.updateSources();
    }
    /**
     * Sets window icon.
     */
    private void setIcon() {        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(iconFile)));
    }
    /**
     * Quits the program.
     */
    public void quit(){
        dispose();
        //loader.cleanup();
        System.exit(0);
    }
    /**
     * Main function.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
            java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
           
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginWindow().setVisible(true);
                
            }            
        });
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private keeptoo.KGradientPanel LoginPanel;
    private keeptoo.KGradientPanel MainPanel;
    private keeptoo.KButton addsourcebtn;
    private keeptoo.KButton addsourcebtn2;
    private javax.swing.JLabel cblbl2;
    private javax.swing.JLabel cblbl3;
    private javax.swing.JLabel closelbl;
    private javax.swing.JLabel closelbl1;
    private javax.swing.JLabel depthlbl;
    private javax.swing.JPanel depthtogglepanel;
    private javax.swing.JLabel dynamicdepthlbl;
    private keeptoo.KButton extractbtn;
    private javax.swing.JPanel extractorpanel;
    private keeptoo.KButton helpbtn;
    private keeptoo.KButton helpbtn1;
    private javax.swing.JLabel htslbl;
    private javax.swing.JTextField keywordfield;
    private javax.swing.JLabel largeoutput;
    private keeptoo.KButton loginbtn;
    private keeptoo.KButton logoutbtn1;
    private javax.swing.JPanel maincontrolpanel;
    private javax.swing.JLabel mainlogowithicon;
    private keeptoo.KButton minusdepthbtn;
    private javax.swing.JLabel nouserwithname;
    private javax.swing.JLabel onelineout;
    private javax.swing.JLabel orlabel;
    private keeptoo.KButton plusdepthbtn;
    private javax.swing.JLabel profileiconlbl;
    private javax.swing.JLabel profilelblicon;
    private javax.swing.JPasswordField pwdfield;
    private javax.swing.JLabel pwdlbl;
    private javax.swing.JLabel sourceslbl;
    private javax.swing.JLabel sourceslist;
    private javax.swing.JLabel statuslbl;
    private keeptoo.KButton stopbtn;
    private keeptoo.KButton stopbtn1;
    private keeptoo.KButton tipsbtn;
    private javax.swing.JPanel tipsbtnpanel;
    private javax.swing.JTextField userfield;
    private javax.swing.JLabel userlbl1;
    private javax.swing.JLabel usertitlelbl;
    private keeptoo.KButton verbosebtn;
    private javax.swing.JPanel verbosepanel;
    private javax.swing.JLabel websitelbl8;
    // End of variables declaration//GEN-END:variables

    
}