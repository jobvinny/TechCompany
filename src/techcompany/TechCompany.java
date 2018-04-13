package techcompany;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class TechCompany {

    //database connectivity.
    Connection con;//Setting up a Caonnection object called con
    Statement stmt;//statement object called stmt
    ResultSet rs;//resultset object called rs
    PreparedStatement pst = null;

    int curRow = 0;
    // byte x = 0;

    JButton Lstart, Login, back, forgot, info, badmin, buser, bstaff, next, previous, java, web, proceed, buy, print, cprint;
    JButton mstaff, mclient, mprojects, cprojects, uprojects, logout, profile, fprojects, pprojects;
    JLabel uname, password, admin, user, staff, label, projects;
    JPasswordField  tpass;
    JTextField tuname,name, id, Mnumber, location, address, tsearch, cname, cid, cMnumber, clocation, caddress, ctsearch;
    JLabel luname, lid, lMnumber, llocation, laddress;
    JButton delete, update, add, search, save, cancel, cdelete, cupdate, cadd, csearch, csave, ccancel;
    JLabel Selection, lcost, Grid;
    JRadioButton r1, r2, r3, r4;

    ImageIcon image = new ImageIcon("img/logo.png");
    ImageIcon image1 = new ImageIcon("img/members1.png");
    ImageIcon image2 = new ImageIcon("img/manage3.png");
    ImageIcon image3 = new ImageIcon("img/man.png");
    ImageIcon image4 = new ImageIcon("img/info.png");
    ImageIcon image5 = new ImageIcon("img/out.png");
    ImageIcon image6 = new ImageIcon("img/java.png");
    ImageIcon image7 = new ImageIcon("img/web.png");
    ImageIcon image8 = new ImageIcon("img/projects.png");

    JPanel Pmain = new JPanel(new BorderLayout());
    JPanel welcome = new JPanel(new GridBagLayout());
    JPanel sections = new JPanel(new GridBagLayout());
    JPanel Pmain1 = new JPanel(new BorderLayout());
    JPanel Padmin = new JPanel(new GridBagLayout());
    JPanel Pmain2 = new JPanel(new BorderLayout());
    JPanel Poperations = new JPanel(new GridBagLayout());
    JPanel operate = new JPanel(new GridBagLayout());
    JPanel card = new JPanel(new java.awt.CardLayout(10, 10));
    JPanel displayp = new JPanel(new CardLayout(10, 10));

    JFrame FWelcome, fadmin, Operations, fuser;

    void AdminOperations() {
        back = new JButton("back");
        mstaff = new JButton("Manage Staff");
        JLabel display = new JLabel("Manage Staff Members");
        display.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 16));
        //mstaff code start
        delete = new JButton("Delete");
        update = new JButton("Update");
        add = new JButton("Add");
        search = new JButton("Search");
        save = new JButton("Save");
        cancel = new JButton("Cancel");
        add.setEnabled(true);
        save.setEnabled(false);
        cancel.setEnabled(false);

        luname = new JLabel("Name");
        lid = new JLabel("National ID");
        lMnumber = new JLabel("Phone Number");
        llocation = new JLabel("Location");
        laddress = new JLabel("Address");

        name = new JTextField(12);
        id = new JTextField(12);
        Mnumber = new JTextField(12);
        location = new JTextField(12);
        address = new JTextField(12);
        tsearch = new JTextField(12);

        JPanel pstaff = new JPanel(new GridBagLayout());
        GridBagConstraints v = new GridBagConstraints();
        v.anchor = GridBagConstraints.LAST_LINE_END;
        v.insets = new Insets(0, 0, 70, 0);
        v.ipadx = 5;
        v.ipady = 5;
        v.gridx = 0;
        v.gridy = 0;
        pstaff.add(tsearch, v);
        v.gridx++;
        pstaff.add(search, v);
        v.gridx++;
        pstaff.add(display, v);

        v.anchor = GridBagConstraints.LINE_START;
        v.insets = new Insets(0, 0, 0, 0);
        v.ipadx = 5;
        v.ipady = 5;
        v.gridx = 0;
        v.gridy = 1;
        pstaff.add(luname, v);
        v.gridy++;
        pstaff.add(lid, v);
        v.gridy++;
        pstaff.add(lMnumber, v);
        v.gridy++;
        pstaff.add(llocation, v);
        v.gridy++;
        pstaff.add(laddress, v);
        v.gridy++;
        pstaff.add(add, v);
        v.gridy++;
        pstaff.add(save, v);
        v.gridy++;
        pstaff.add(cancel, v);

        v.anchor = GridBagConstraints.LINE_START;
        v.insets = new Insets(0, 0, 0, 100);
        v.ipadx = 5;
        v.ipady = 5;
        v.gridx = 2;
        v.gridy = 1;
        pstaff.add(name, v);
        v.gridy++;
        pstaff.add(id, v);
        v.gridy++;
        pstaff.add(Mnumber, v);
        v.gridy++;
        pstaff.add(location, v);
        v.gridy++;
        pstaff.add(address, v);
        v.anchor = GridBagConstraints.LAST_LINE_END;
        v.gridy++;
        pstaff.add(update, v);
        v.gridy++;
        pstaff.add(delete, v);
        print = new JButton("Print");
        v.gridy++;
        pstaff.add(print, v);
        print.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PrinterJob job = PrinterJob.getPrinterJob();
                job.setJobName("Staff Details");

                job.setPrintable(new Printable() {
                    public int print(Graphics pg, PageFormat pf, int pageNum) {
                        if (pageNum > 0) {
                            return Printable.NO_SUCH_PAGE;
                        }

                        Graphics2D g = (Graphics2D) pg;
                        g.translate(pf.getImageableX(), pf.getImageableY());
                        JPanel pprint = new JPanel(new GridBagLayout());
                        JLabel ldetails = new JLabel("Staff Details");
                        v.anchor = GridBagConstraints.LINE_START;
                        v.insets = new Insets(0, 0, 0, 0);
                        v.ipadx = 5;
                        v.ipady = 5;
                        v.gridx = 0;
                        v.gridy = 1;
                        pprint.add(ldetails, v);
                        v.gridy++;
                        pprint.add(luname, v);
                        v.gridy++;
                        pprint.add(lid, v);
                        v.gridy++;
                        pprint.add(lMnumber, v);
                        v.gridy++;
                        pprint.add(llocation, v);
                        v.gridy++;
                        pprint.add(laddress, v);

                        v.anchor = GridBagConstraints.LINE_START;
                        v.insets = new Insets(0, 0, 0, 100);
                        v.ipadx = 5;
                        v.ipady = 5;
                        v.gridx = 2;
                        v.gridy = 2;
                        pprint.add(name, v);
                        v.gridy++;
                        pprint.add(id, v);
                        v.gridy++;
                        pprint.add(Mnumber, v);
                        v.gridy++;
                        pprint.add(location, v);
                        v.gridy++;
                        pprint.add(address, v);

                        JFrame fprint = new JFrame();
                        fprint.add(pprint);
                        fprint.pack();
                        //fprint.setVisible(true);
                        pprint.paint(g);
                       
                        return Printable.PAGE_EXISTS;
                    }
                });
                boolean ok = job.printDialog();
                if (ok) {
                    try {
                        job.print();
                    } catch (PrinterException ex) {

                    }
                }
            }
        });
        //printing code end

         //DATABASE CODE.......******
        /*The database Kilo lines of Code KLOC*/
        ///creating connection to the database
        try {
            String host = "jdbc:derby://localhost:1527/TechCompany";
            String uName = "Vincent";
            String uPass = "java";
            con = DriverManager.getConnection(host, uName, uPass);
            //execute sql and load the records into resultset
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM Staff";
            rs = stmt.executeQuery(sql);
            ////move the cursor to the first record and set the data
            rs.next();
            String dbname = rs.getString("Name");
            int nid = rs.getInt("ID");
            String dbid = Integer.toString(nid);
            String dbmnumber = rs.getString("Mobile");
            String dblocation = rs.getString("Location");
            String dbaddress = rs.getString("Address");

            //display the fisrt record in the text fields.
            name.setText(dbname);
            id.setText(dbid);
            Mnumber.setText(dbmnumber);
            location.setText(dblocation);
            address.setText(dbaddress);

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Failed To Connect To The GridTechDB...");

        }
        //adding code
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    curRow = rs.getRow();/*getrow gets which row the cursor is currently pointing.This allows
                     you to store the row number that the cursor is currently on*/

                    id.setText("");
                    name.setText("");
                    Mnumber.setText("");
                    location.setText("");
                    address.setText("");

                    add.setEnabled(false);

                    save.setEnabled(true);
                    cancel.setEnabled(true);
                } catch (SQLException err) {
                    JOptionPane.showMessageDialog(null, "Coonection Failure.");
                }
            }
        });
        //saving code
        try {
            save.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    save.setToolTipText("Click To Save.");

                    String dbname = name.getText();
                    String dbid = id.getText();
                    int nid = Integer.parseInt(dbid);
                    String dbmnumber = Mnumber.getText();
                    String dblocation = location.getText();
                    String dbaddress = address.getText();

                    try {
                        rs.moveToInsertRow();
                        rs.updateString("Name", dbname);
                        rs.updateInt("ID", nid);
                        rs.updateString("Mobile", dbmnumber);
                        rs.updateString("Location", dblocation);
                        rs.updateString("Address", dbaddress);
                        //inserts a new row
                        rs.insertRow();

                        stmt.close();
                        rs.close();
                        JOptionPane.showMessageDialog(null, name.getText() + "  has been registered successifully...");
                        stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        String sql = "SELECT * FROM Staff";
                        rs = stmt.executeQuery(sql);

                        rs.next();
                        dbname = rs.getString("Name");
                        nid = rs.getInt("ID");
                        dbid = Integer.toString(nid);
                        dbmnumber = rs.getString("Mobile");
                        dblocation = rs.getString("Location");
                        dbaddress = rs.getString("Address");

                        //display the fisrt record in the text fields.
                        name.setText(dbname);
                        id.setText(dbid);
                        Mnumber.setText(dbmnumber);
                        location.setText(dblocation);
                        address.setText(dbaddress);

                        add.setEnabled(true);

                        save.setEnabled(false);
                        cancel.setEnabled(false);
                    } catch (SQLException err) {
                        JOptionPane.showMessageDialog(null, "Please Enter Values To Register...");
                    }
                }
            });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection Failure...");
        }
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    cancel.setToolTipText("Click To Cancel");
                    rs.absolute(curRow);
                    uname.setText(rs.getString("Name"));
                    id.setText(Integer.toString(rs.getInt("ID")));
                    Mnumber.setText(rs.getString("Mobile"));
                    location.setText(rs.getString("Location"));
                    address.setText(rs.getString("Address"));

                    add.setEnabled(true);

                    save.setEnabled(false);
                    cancel.setEnabled(false);
                } catch (SQLException err) {
                    JOptionPane.showMessageDialog(null, err.getMessage());
                }
            }
        });
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {
                    delete.setToolTipText("Delete Record...");
                    rs.deleteRow();
                    stmt.close();
                    rs.close();

                    stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    String sql = "SELECT * FROM Staff";
                    rs = stmt.executeQuery(sql);

                    rs.next();
                    String dbname = rs.getString("Name");
                    int nid = rs.getInt("ID");
                    String dbid = Integer.toString(nid);
                    String dbmnumber = rs.getString("Mobile");
                    String dblocation = rs.getString("Location");
                    String dbaddress = rs.getString("Address");

                    //display the fisrt record in the text fields.
                    name.setText(dbname);
                    id.setText(dbid);
                    Mnumber.setText(dbmnumber);
                    location.setText(dblocation);
                    address.setText(dbaddress);

                } catch (SQLException err) {
                    JOptionPane.showMessageDialog(null, "Record Deleted Succesifully...");
                }
            }
        });
        update.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update.setToolTipText("Update Record....");
                String dbname = name.getText();
                String dbid = id.getText();
                //casting
                int nid = Integer.parseInt(dbid);
                String dbmnumber = Mnumber.getText();
                String dblocation = location.getText();
                String dbaddress = address.getText();

                try {
                    rs.updateString("Name", dbname);
                    rs.updateInt("ID", nid);
                    rs.updateString("Mobile", dbmnumber);
                    rs.updateString("Location", dblocation);
                    rs.updateString("Address", dbaddress);
                    rs.updateRow();//tis code updates the database changes
                    JOptionPane.showMessageDialog(null, "Update has been successifully");
                } catch (SQLException err) {
                    JOptionPane.showMessageDialog(null, err.getMessage());
                }
            }
        });
        //search code
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String sql = "SELECT Name,ID,Mobile,Location,Address FROM staff WHERE ID =?";
                    pst = con.prepareStatement(sql);
                    pst.setString(1, tsearch.getText());

                    rs = pst.executeQuery();
                    if (rs.next()) {
                        tsearch.setText(rs.getString("ID"));
                        name.setText(rs.getString("Name"));
                        id.setText(rs.getString("ID"));
                        id.setBackground(Color.red);
                        Mnumber.setText(rs.getString("Mobile"));
                        location.setText(rs.getString("Location"));
                        address.setText(rs.getString("Address"));

                    } else {
                        id.setBackground(Color.white);
                        JOptionPane.showMessageDialog(null, "Missing in the Tech Dtabase");
                    }
                } catch (SQLException et) {
                    JOptionPane.showMessageDialog(null, "Please Enter The ID to Search");

                }
            }
        });
        //end of database code
        //mstaff code end
        mclient = new JButton("Manage Clients");
        //code for client
        JLabel display1 = new JLabel("Manage Client");
        display1.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 16));
        cdelete = new JButton("Delete");
        cupdate = new JButton("Update");
        cadd = new JButton("Add");
        csearch = new JButton("Search");
        csave = new JButton("Save");
        ccancel = new JButton("Cancel");
        csave.setEnabled(false);
        ccancel.setEnabled(false);

        luname = new JLabel("Name");
        lid = new JLabel("National ID");
        lMnumber = new JLabel("Phone Number");
        llocation = new JLabel("Location");
        laddress = new JLabel("Address");

        cname = new JTextField(12);
        cid = new JTextField(12);
        cMnumber = new JTextField(12);
        clocation = new JTextField(12);
        caddress = new JTextField(12);
        ctsearch = new JTextField(12);

        JPanel pclient = new JPanel(new GridBagLayout());
        v.anchor = GridBagConstraints.LAST_LINE_END;
        v.insets = new Insets(0, 0, 70, 0);
        v.ipadx = 5;
        v.ipady = 5;
        v.gridx = 0;
        v.gridy = 0;
        pclient.add(ctsearch, v);
        v.gridx++;
        pclient.add(csearch, v);
        v.gridx++;
        pclient.add(display1, v);

        v.anchor = GridBagConstraints.LINE_START;
        v.insets = new Insets(0, 0, 0, 0);
        v.ipadx = 5;
        v.ipady = 5;
        v.gridx = 0;
        v.gridy = 1;
        pclient.add(luname, v);
        v.gridy++;
        pclient.add(lid, v);
        v.gridy++;
        pclient.add(lMnumber, v);
        v.gridy++;
        pclient.add(llocation, v);
        v.gridy++;
        pclient.add(laddress, v);
        v.gridy++;
        pclient.add(cadd, v);
        v.gridy++;
        pclient.add(csave, v);
        v.gridy++;
        pclient.add(ccancel, v);

        v.anchor = GridBagConstraints.LINE_START;
        v.insets = new Insets(0, 0, 0, 100);
        v.ipadx = 5;
        v.ipady = 5;
        v.gridx = 2;
        v.gridy = 1;
        pclient.add(cname, v);
        v.gridy++;
        pclient.add(cid, v);
        v.gridy++;
        pclient.add(cMnumber, v);
        v.gridy++;
        pclient.add(clocation, v);
        v.gridy++;
        pclient.add(caddress, v);
        v.anchor = GridBagConstraints.LAST_LINE_END;
        v.gridy++;
        pclient.add(cupdate, v);
        v.gridy++;
        pclient.add(cdelete, v);
        cprint = new JButton("Print");
        v.gridy++;
        pclient.add(cprint, v);
        //printing code start
        cprint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PrinterJob job = PrinterJob.getPrinterJob();
                job.setJobName("Client Details");

                job.setPrintable(new Printable() {
                    public int print(Graphics pg, PageFormat pf, int pageNum) {
                        if (pageNum > 0) {
                            return Printable.NO_SUCH_PAGE;
                        }

                        Graphics2D g = (Graphics2D) pg;
                        g.translate(pf.getImageableX(), pf.getImageableY());
                        JPanel pprint = new JPanel(new GridBagLayout());
                        JLabel ldetails = new JLabel("Client Details");
                        v.anchor = GridBagConstraints.LINE_START;
                        v.insets = new Insets(0, 0, 0, 0);
                        v.ipadx = 5;
                        v.ipady = 5;
                        v.gridx = 0;
                        v.gridy = 1;
                        pprint.add(ldetails, v);
                        v.gridy++;
                        pprint.add(luname, v);
                        v.gridy++;
                        pprint.add(lid, v);
                        v.gridy++;
                        pprint.add(lMnumber, v);
                        v.gridy++;
                        pprint.add(llocation, v);
                        v.gridy++;
                        pprint.add(laddress, v);

                        v.anchor = GridBagConstraints.LINE_START;
                        v.insets = new Insets(0, 0, 0, 100);
                        v.ipadx = 5;
                        v.ipady = 5;
                        v.gridx = 2;
                        v.gridy = 2;
                        pprint.add(cname, v);
                        v.gridy++;
                        pprint.add(cid, v);
                        v.gridy++;
                        pprint.add(cMnumber, v);
                        v.gridy++;
                        pprint.add(clocation, v);
                        v.gridy++;
                        pprint.add(caddress, v);

                        JFrame fprint = new JFrame();
                        fprint.add(pprint);
                        fprint.pack();
                        //fprint.setVisible(true);
                        pprint.paint(g);
                       
                        return Printable.PAGE_EXISTS;
                    }
                });
                boolean ok = job.printDialog();
                if (ok) {
                    try {
                        job.print();
                    } catch (PrinterException ex) {

                    }
                }
            }
        });
        //printing code end
        //DATABASE CODE.......******
        /*The database Kilo lines of Code KLOC*/
        ///creating connection to the database
        try {
            String host = "jdbc:derby://localhost:1527/TechCompany";
            String uName = "Vincent";
            String uPass = "java";
            con = DriverManager.getConnection(host, uName, uPass);
            //execute sql and load the records into resultset
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM Client";
            rs = stmt.executeQuery(sql);
            ////move the cursor to the first record and set the data
            rs.next();
            String dbname = rs.getString("Name");
            int nid = rs.getInt("ID");
            String dbid = Integer.toString(nid);
            String dbmnumber = rs.getString("Mobile");
            String dblocation = rs.getString("Location");
            String dbaddress = rs.getString("Address");

            //display the fisrt record in the text fields.
            cname.setText(dbname);
            cid.setText(dbid);
            cMnumber.setText(dbmnumber);
            clocation.setText(dblocation);
            caddress.setText(dbaddress);

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Failed To Connect To The GridTechDB...");

        }
        //adding code
        cadd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    curRow = rs.getRow();/*getrow gets which row the cursor is currently pointing.This allows
                     you to store the row number that the cursor is currently on*/

                    cid.setText("");
                    cname.setText("");
                    cMnumber.setText("");
                    clocation.setText("");
                    caddress.setText("");

                    cadd.setEnabled(false);

                    csave.setEnabled(true);
                    ccancel.setEnabled(true);
                } catch (SQLException err) {
                    JOptionPane.showMessageDialog(null, "Coonection Failure.");
                }
            }
        });
        //saving code
        try {
            csave.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    csave.setToolTipText("Click To Save.");

                    String dbname = cname.getText();
                    String dbid = cid.getText();
                    int nid = Integer.parseInt(dbid);
                    String dbmnumber = cMnumber.getText();
                    String dblocation = clocation.getText();
                    String dbaddress = caddress.getText();

                    try {
                        rs.moveToInsertRow();
                        rs.updateString("Name", dbname);
                        rs.updateInt("ID", nid);
                        rs.updateString("Mobile", dbmnumber);
                        rs.updateString("Location", dblocation);
                        rs.updateString("Address", dbaddress);
                        //inserts a new row
                        rs.insertRow();

                        stmt.close();
                        rs.close();
                        JOptionPane.showMessageDialog(null, cname.getText() + "  has been registered successifully...");
                        stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        String sql = "SELECT * FROM Client";
                        rs = stmt.executeQuery(sql);

                        rs.next();
                        dbname = rs.getString("Name");
                        nid = rs.getInt("ID");
                        dbid = Integer.toString(nid);
                        dbmnumber = rs.getString("Mobile");
                        dblocation = rs.getString("Location");
                        dbaddress = rs.getString("Address");

                        //display the fisrt record in the text fields.
                        cname.setText(dbname);
                        cid.setText(dbid);
                        cMnumber.setText(dbmnumber);
                        clocation.setText(dblocation);
                        caddress.setText(dbaddress);

                        cadd.setEnabled(true);

                        csave.setEnabled(false);
                        ccancel.setEnabled(false);
                    } catch (SQLException err) {
                        JOptionPane.showMessageDialog(null, "Please Enter Values To Register...");
                    }
                }
            });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection Failure...");
        }
        ccancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    ccancel.setToolTipText("Click To Cancel");
                    rs.absolute(curRow);
                    uname.setText(rs.getString("Name"));
                    cid.setText(Integer.toString(rs.getInt("ID")));
                    cMnumber.setText(rs.getString("Mobile"));
                    clocation.setText(rs.getString("Location"));
                    caddress.setText(rs.getString("Address"));

                    cadd.setEnabled(true);

                    csave.setEnabled(false);
                    ccancel.setEnabled(false);
                } catch (SQLException err) {
                    JOptionPane.showMessageDialog(null, err.getMessage());
                }
            }
        });
        cdelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {
                    cdelete.setToolTipText("Delete Record...");
                    rs.deleteRow();
                    stmt.close();
                    rs.close();

                    stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    String sql = "SELECT * FROM Client";
                    rs = stmt.executeQuery(sql);

                    rs.next();
                    String dbname = rs.getString("Name");
                    int nid = rs.getInt("ID");
                    String dbid = Integer.toString(nid);
                    String dbmnumber = rs.getString("Mobile");
                    String dblocation = rs.getString("Location");
                    String dbaddress = rs.getString("Address");

                    //display the fisrt record in the text fields.
                    cname.setText(dbname);
                    cid.setText(dbid);
                    cMnumber.setText(dbmnumber);
                    clocation.setText(dblocation);
                    caddress.setText(dbaddress);

                } catch (SQLException err) {
                    JOptionPane.showMessageDialog(null, "Record Deleted Succesifully...");
                }
            }
        });
        cupdate.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cupdate.setToolTipText("Update Record....");
                String dbname = cname.getText();
                String dbid = cid.getText();
                //casting
                int nid = Integer.parseInt(dbid);
                String dbmnumber = cMnumber.getText();
                String dblocation = clocation.getText();
                String dbaddress = caddress.getText();

                try {
                    rs.updateString("Name", dbname);
                    rs.updateInt("ID", nid);
                    rs.updateString("Mobile", dbmnumber);
                    rs.updateString("Location", dblocation);
                    rs.updateString("Address", dbaddress);
                    rs.updateRow();//tis code updates the database changes
                    JOptionPane.showMessageDialog(null, "Update has been successifully");
                } catch (SQLException err) {
                    JOptionPane.showMessageDialog(null, err.getMessage());
                }
            }
        });
        //search code
        csearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String sql = "SELECT Name,ID,Mobile,Location,Address FROM Client WHERE ID =?";
                    pst = con.prepareStatement(sql);
                    pst.setString(1, ctsearch.getText());

                    rs = pst.executeQuery();
                    if (rs.next()) {
                        ctsearch.setText(rs.getString("ID"));
                        cname.setText(rs.getString("Name"));
                        cid.setText(rs.getString("ID"));
                        cid.setBackground(Color.red);
                        cMnumber.setText(rs.getString("Mobile"));
                        clocation.setText(rs.getString("Location"));
                        caddress.setText(rs.getString("Address"));

                    } else {
                        cid.setBackground(Color.white);
                        JOptionPane.showMessageDialog(null, "Missing in the Tech Dtabase");
                    }
                } catch (SQLException et) {
                    JOptionPane.showMessageDialog(null, "Please Enter The ID to Search");

                }
            }
        });
        //end of database code
        //end of code client
        mprojects = new JButton("Applied Projects");
        cprojects = new JButton("Company Projects");

        logout = new JButton("Logout");
        next = new JButton("Next");
        previous = new JButton("Previous");
        JLabel show = new JLabel(image3);
        label = new JLabel(image);

        Pmain2.add("West", Poperations);
        v.anchor = GridBagConstraints.LINE_START;
        v.insets = new Insets(0, 0, 10, 0);
        v.ipadx = 5;
        v.ipady = 5;
        v.gridx = 0;
        v.gridy = 0;
        Poperations.add(show, v);
        v.gridy++;
        Poperations.add(mstaff, v);
        v.gridy++;
        Poperations.add(mclient, v);

        v.insets = new Insets(0, 0, 0, 0);
        v.ipadx = 5;
        v.ipady = 5;
        v.gridx = 0;
        v.gridy = 5;
        Poperations.add(previous, v);
        v.gridx++;
        v.anchor = GridBagConstraints.LAST_LINE_END;
        Poperations.add(next, v);

        v.insets = new Insets(100, 0, 0, 0);
        v.ipadx = 5;
        v.ipady = 5;
        v.gridx = 0;
        v.gridy = 6;
        Poperations.add(back, v);
        v.gridx++;
        v.anchor = GridBagConstraints.LAST_LINE_END;
        Poperations.add(logout, v);
        Poperations.setBorder(new TitledBorder("Admin Operations"));
        Poperations.setBackground(Color.lightGray);

        v.anchor = GridBagConstraints.LINE_START;
        v.insets = new Insets(10, 0, 10, 100);
        v.ipadx = 5;
        v.ipady = 5;
        v.gridx = 0;
        v.gridy = 0;
        operate.add(label, v);
        card.add(operate);
        card.add(pstaff);
        card.add(pclient);
        java.awt.CardLayout cardLayout = (java.awt.CardLayout) (card.getLayout());
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.first(card);

            }
        });
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.next(card);

            }
        });

        previous.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.previous(card);

            }
        });
        Pmain2.add("East", card);
        Operations = new JFrame("Admin");
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            UIManager.put("nimbusBase", Color.blue);
        } catch (Exception c) {
        }
        Operations.add(Pmain2);
        Operations.setVisible(true);
        Operations.setSize(800, 500);
        Operations.setLocationRelativeTo(null);
        Operations.setResizable(false);
        Operations.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Operations.setVisible(false);
                JOptionPane.showMessageDialog(null, "Successifully Logged Out");
                TechCompany GT = new TechCompany();
                GT.Welcome();

            }
        });
    }

    void UserOperations() {
        back = new JButton("back");

        profile = new JButton("Edit Profile");
        //code for client
        JLabel display1 = new JLabel("Personal Details");
        display1.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 16));
        cupdate = new JButton("Update");

        luname = new JLabel("Name");
        lid = new JLabel("National ID");
        lMnumber = new JLabel("Phone Number");
        llocation = new JLabel("Location");
        laddress = new JLabel("Address");

        cname = new JTextField(12);
        cname.setEditable(false);
        cname.setToolTipText("You Can't Change your Name");
        cid = new JTextField(12);
        cid.setEditable(false);
        cid.setToolTipText("You Can't Change your Id_NO");
        cMnumber = new JTextField(12);
        clocation = new JTextField(12);
        caddress = new JTextField(12);
        tsearch = new JTextField(12);

        JPanel pclient = new JPanel(new GridBagLayout());
        GridBagConstraints v = new GridBagConstraints();
        v.anchor = GridBagConstraints.LAST_LINE_END;
        v.insets = new Insets(0, 0, 0, 0);
        v.ipadx = 5;
        v.ipady = 5;
        v.gridx = 0;
        v.gridy = 0;
        pclient.add(display1, v);

        v.anchor = GridBagConstraints.LINE_START;
        v.insets = new Insets(0, 0, 0, 0);
        v.ipadx = 5;
        v.ipady = 5;
        v.gridx = 0;
        v.gridy = 1;
        pclient.add(luname, v);
        v.gridy++;
        pclient.add(lid, v);
        v.gridy++;
        pclient.add(lMnumber, v);
        v.gridy++;
        pclient.add(llocation, v);
        v.gridy++;
        pclient.add(laddress, v);

        v.anchor = GridBagConstraints.LINE_START;
        v.insets = new Insets(0, 0, 0, 100);
        v.ipadx = 5;
        v.ipady = 5;
        v.gridx = 2;
        v.gridy = 1;
        pclient.add(cname, v);
        v.gridy++;
        pclient.add(cid, v);
        v.gridy++;
        pclient.add(cMnumber, v);
        v.gridy++;
        pclient.add(clocation, v);
        v.gridy++;
        pclient.add(caddress, v);
        v.anchor = GridBagConstraints.LAST_LINE_END;
        v.insets = new Insets(20, 0, 0, 100);
        v.gridy++;
        pclient.add(cupdate, v);
        //database start point
        //DATABASE CODE.......******
        /*The database Kilo lines of Code KLOC*/
        ///creating connection to the database
        try {
            String host = "jdbc:derby://localhost:1527/TechCompany";
            String uName = "Vincent";
            String uPass = "java";
            con = DriverManager.getConnection(host, uName, uPass);
            //execute sql and load the records into resultset
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM Client";
            rs = stmt.executeQuery(sql);
            ////move the cursor to the first record and set the data
            rs.next();
            String dbname = rs.getString("Name");
            int nid = rs.getInt("ID");
            String dbid = Integer.toString(nid);
            String dbmnumber = rs.getString("Mobile");
            String dblocation = rs.getString("Location");
            String dbaddress = rs.getString("Address");

            //display the fisrt record in the text fields.
            cname.setText(dbname);
            cid.setText(dbid);
            cMnumber.setText(dbmnumber);
            clocation.setText(dblocation);
            caddress.setText(dbaddress);

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Failed To Connect To The GridTechDB...");

        }
        cupdate.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cupdate.setToolTipText("Update Record....");
                String dbname = cname.getText();
                String dbid = cid.getText();
                //casting
                int nid = Integer.parseInt(dbid);
                String dbmnumber = cMnumber.getText();
                String dblocation = clocation.getText();
                String dbaddress = caddress.getText();

                try {
                    rs.updateString("Name", dbname);
                    rs.updateInt("ID", nid);
                    rs.updateString("Mobile", dbmnumber);
                    rs.updateString("Location", dblocation);
                    rs.updateString("Address", dbaddress);
                    rs.updateRow();//tis code updates the database changes
                    JOptionPane.showMessageDialog(null, "Update has been successifully");
                } catch (SQLException err) {
                    JOptionPane.showMessageDialog(null, err.getMessage());
                }
            }
        });
        //end of db connection
        //end of code client
        uprojects = new JButton("Apply Projects");
        cprojects = new JButton("Company Projects");
        //code for company projects
        JPanel grid, showp;

        //start of ppanel web
        Selection = new JLabel("SELECT SOFTWARE");
        lcost = new JLabel("COST");
        Grid = new JLabel("Company Projects");
        Grid.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 20));
        r1 = new JRadioButton("AirLine Booking System");
        r2 = new JRadioButton("Network System");
        r3 = new JRadioButton("Garage System");
        r4 = new JRadioButton("E_Commerce System");
        ButtonGroup group1 = new ButtonGroup();
        group1.add(r1);
        group1.add(r2);
        group1.add(r3);
        group1.add(r4);
        JTextField costweb = new JTextField(15);
        costweb.setEditable(false);
        costweb.setText("Web System Cost");
        costweb.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 16));
        buy = new JButton("Purchase");
        buy.setEnabled(false);
        proceed = new JButton("Proceed");
        proceed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean select1 = r1.isSelected();
                boolean select2 = r2.isSelected();
                boolean select3 = r3.isSelected();
                boolean select4 = r4.isSelected();
                if (select1 == true) {
                    costweb.setText("$50,000");
                    buy.setEnabled(true);
                } else if (select2 == true) {
                    costweb.setText("$80,000");
                    buy.setEnabled(true);
                } else if (select3 == true) {
                    costweb.setText("$150,000");
                    buy.setEnabled(true);
                } else if (select4 == true) {
                    costweb.setText("$20,000");
                    buy.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Please Select?");
                }
            }

        });
        web = new JButton(image6);
        web.setBackground(Color.LIGHT_GRAY);
        projects = new JLabel(image8);
        grid = new JPanel(new BorderLayout());
        showp = new JPanel(new GridBagLayout());

        v.anchor = GridBagConstraints.LINE_START;
        v.anchor = GridBagConstraints.LINE_START;
        v.insets = new Insets(50, 0, 0, 0);
        v.ipadx = 5;
        v.ipady = 5;
        v.gridx = 0;
        v.gridy = 0;
        showp.add(Grid, v);

        v.insets = new Insets(0, 0, 0, 0);
        v.ipadx = 5;
        v.ipady = 5;
        v.gridx = 0;
        v.gridy = 1;
        showp.add(web, v);
        grid.add("North", showp);
        //start of sofware panel
        JPanel pweb = new JPanel(new GridBagLayout());
        v.anchor = GridBagConstraints.LINE_START;
        v.insets = new Insets(0, 0, 0, 120);
        v.ipadx = 5;
        v.ipady = 5;
        v.gridx = 0;
        v.gridy = 0;
        pweb.add(Selection, v);
        v.gridy++;
        pweb.add(r1, v);
        v.gridy++;
        pweb.add(r2, v);
        v.gridy++;
        pweb.add(r3, v);
        v.gridy++;
        pweb.add(r4, v);
        v.gridy++;
        pweb.add(proceed, v);

        v.anchor = GridBagConstraints.LINE_START;
        v.insets = new Insets(0, 0, 0, 10);
        v.ipadx = 5;
        v.ipady = 5;
        v.gridx = 2;
        v.gridy = 0;
        pweb.add(lcost, v);
        v.gridy++;
        pweb.add(costweb, v);
        v.anchor = GridBagConstraints.LAST_LINE_END;
        v.gridy++;
        pweb.add(buy, v);
        pweb.setBorder(new TitledBorder("Web Projects"));
        //end of panel web
        JPanel gridlogo = new JPanel(new GridBagLayout());
        v.anchor = GridBagConstraints.LINE_START;
        v.insets = new Insets(0, 0, 50, 50);
        v.ipadx = 5;
        v.ipady = 5;
        v.gridx = 0;
        v.gridy = 0;
        gridlogo.add(projects, v);
        displayp.add(gridlogo);
        //displayp.add(pjava);
        displayp.add(pweb);
        java.awt.CardLayout card1 = (java.awt.CardLayout) (displayp.getLayout());
        web.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                card1.last(displayp);

            }
        });
        grid.add("South", displayp);
        //end of code company projects
        logout = new JButton("Logout");
        next = new JButton("Next");
        previous = new JButton("Previous");
        JLabel show = new JLabel(image1);
        label = new JLabel(image);

        Pmain2.add("West", Poperations);
        v.anchor = GridBagConstraints.LINE_START;
        v.insets = new Insets(0, 0, 10, 0);
        v.ipadx = 5;
        v.ipady = 5;
        v.gridx = 0;
        v.gridy = 0;
        Poperations.add(show, v);
        v.gridy++;
        Poperations.add(profile, v);
        v.gridy++;
        Poperations.add(cprojects, v);

        v.insets = new Insets(0, 0, 0, 0);
        v.ipadx = 5;
        v.ipady = 5;
        v.gridx = 0;
        v.gridy = 5;
        Poperations.add(previous, v);
        v.gridx++;
        v.anchor = GridBagConstraints.LAST_LINE_END;
        Poperations.add(next, v);

        v.insets = new Insets(100, 0, 0, 0);
        v.ipadx = 5;
        v.ipady = 5;
        v.gridx = 0;
        v.gridy = 6;
        Poperations.add(back, v);
        v.gridx++;
        v.anchor = GridBagConstraints.LAST_LINE_END;
        Poperations.add(logout, v);
        Poperations.setBorder(new TitledBorder("User Operations"));
        Poperations.setBackground(Color.lightGray);

        v.anchor = GridBagConstraints.LINE_START;
        v.insets = new Insets(10, 0, 10, 20);
        v.ipadx = 5;
        v.ipady = 5;
        v.gridx = 0;
        v.gridy = 0;
        operate.add(label, v);
        card.add(operate);
        card.add(pclient);
        card.add(grid);
        java.awt.CardLayout cardLayout = (java.awt.CardLayout) (card.getLayout());
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.first(card);

            }
        });
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.next(card);

            }
        });

        previous.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.previous(card);

            }
        });
        Pmain2.add("East", card);
        Operations = new JFrame("User");
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            UIManager.put("nimbusBase", Color.blue);
        } catch (Exception c) {
        }
        Operations.add(Pmain2);
        Operations.setVisible(true);
        Operations.setSize(800, 500);
        Operations.setLocationRelativeTo(null);
        Operations.setResizable(false);
        Operations.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Operations.setVisible(false);
                JOptionPane.showMessageDialog(null, "Successifully Logged Out");
                TechCompany GT = new TechCompany();
                GT.Welcome();

            }
        });
    }

    void print() {

    }

    void Admin() {
        label = new JLabel(image);
        uname = new JLabel("Username");
        tuname = new JTextField(15);
        password = new JLabel("passkey");
        tpass = new JPasswordField(15);

        Login = new JButton("Login");
        forgot = new JButton("Reset password");

        Pmain1.add("North", label);
        GridBagConstraints v = new GridBagConstraints();
        v.anchor = GridBagConstraints.LINE_START;
        v.insets = new Insets(0, 0, 10, 0);
        v.ipadx = 5;
        v.ipady = 5;
        v.gridx = 0;
        v.gridy = 0;
        Padmin.add(uname, v);
        v.gridy++;
        Padmin.add(password, v);
        v.gridy++;
        Padmin.add(Login, v);

        v.anchor = GridBagConstraints.LINE_START;
        v.insets = new Insets(0, 0, 10, 0);
        v.ipadx = 5;
        v.ipady = 5;
        v.gridx = 1;
        v.gridy = 0;
        Padmin.add(tuname, v);
        v.gridy++;
        Padmin.add(tpass, v);
        v.anchor = GridBagConstraints.LAST_LINE_END;
        v.gridy++;
        //Padmin.add(forgot, v);
        Padmin.setBorder(new TitledBorder("Admin Section"));
        Padmin.setBackground(Color.lightGray);
        Pmain1.add("South", Padmin);
        fadmin = new JFrame("Admin Login");
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            UIManager.put("nimbusBase", Color.blue);
        } catch (Exception c) {
        }
        fadmin.add(Pmain1);
        fadmin.setVisible(true);
        fadmin.setSize(400, 350);
        fadmin.setLocationRelativeTo(null);
        fadmin.setResizable(false);
        fadmin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        Login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent err) {
                String UNAME = tuname.getText();
                String PASS = tpass.getText();
                if(UNAME.equals("Tech") && PASS.equals("2016")){
                fadmin.setVisible(false);
                TechCompany adop = new TechCompany();
                adop.AdminOperations();
                }
                else if(UNAME == (null) || PASS == (null)){
                    JOptionPane.showMessageDialog(null, "Enter Entries");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Wrong Entries");
                }
            }
        });

    }

    //user method
    void User() {
        label = new JLabel(image);
        uname = new JLabel("Username");
        tuname = new JTextField(15);
        password = new JLabel("passkey");
        tpass = new JPasswordField(15);

        Login = new JButton("Login");
        forgot = new JButton("Reset password");

        Pmain1.add("North", label);
        GridBagConstraints v = new GridBagConstraints();
        v.anchor = GridBagConstraints.LINE_START;
        v.insets = new Insets(0, 0, 10, 0);
        v.ipadx = 5;
        v.ipady = 5;
        v.gridx = 0;
        v.gridy = 0;
        Padmin.add(uname, v);
        v.gridy++;
        Padmin.add(password, v);
        v.gridy++;
        Padmin.add(Login, v);

        v.anchor = GridBagConstraints.LINE_START;
        v.insets = new Insets(0, 0, 10, 0);
        v.ipadx = 5;
        v.ipady = 5;
        v.gridx = 1;
        v.gridy = 0;
        Padmin.add(tuname, v);
        v.gridy++;
        Padmin.add(tpass, v);
        v.anchor = GridBagConstraints.LAST_LINE_END;
        v.gridy++;
        //Padmin.add(forgot, v);
        Padmin.setBorder(new TitledBorder("User Section"));
        Padmin.setBackground(Color.lightGray);
        Pmain1.add("South", Padmin);
        fuser = new JFrame("User Login");
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            UIManager.put("nimbusBase", Color.blue);
        } catch (Exception c) {
        }
        fuser.add(Pmain1);
        fuser.setVisible(true);
        fuser.setSize(400, 350);
        fuser.setLocationRelativeTo(null);
        fuser.setResizable(false);
        fuser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent err) {
                String UNAME = tuname.getText();
                String PASS = tpass.getText();
                if(UNAME.equals("Tech") && PASS.equals("2016")){
                fuser.setVisible(false);
                TechCompany op = new TechCompany();
                op.UserOperations();
                }
                else if(UNAME == (null) || PASS == (null)){
                    JOptionPane.showMessageDialog(null, "Enter Entries");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Wrong Entries");
                }
            }
        });

    }

    void Welcome() {
        JLabel logo = new JLabel(image);
        Lstart = new JButton("Let's Get Started");
        Lstart.setBackground(Color.lightGray);
        Lstart.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 14));
        /*code for moving welcome*/
        String s = "WELCOME";
        marquee mp = new marquee(s, 10);
        mp.setBackground(Color.lightGray);
        mp.start();
        GridBagConstraints v = new GridBagConstraints();
        v.anchor = GridBagConstraints.LINE_START;
        v.insets = new Insets(0, 0, 0, 0);
        v.ipadx = 5;
        v.ipady = 5;
        v.gridx = 0;
        v.gridy = 0;
        welcome.add(mp, v);
        v.gridy++;
        welcome.add(logo, v);
        v.gridy++;
        welcome.add(Lstart, v);
        welcome.setBackground(Color.lightGray);
        Pmain.add("North", welcome);
        FWelcome = new JFrame("GridTech");
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            UIManager.put("nimbusBase", Color.blue);
        } catch (Exception c) {
        }
        FWelcome.add(Pmain);
        FWelcome.setVisible(true);
        FWelcome.setSize(800, 260);
        FWelcome.setLocationRelativeTo(null);
        FWelcome.setResizable(false);
        FWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Lstart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent err) {
                FWelcome.setSize(800, 554);
                FWelcome.setLocationRelativeTo(null);
                //login icons
                v.anchor = GridBagConstraints.LINE_START;
                v.ipadx = 5;
                v.ipady = 5;
                v.gridx = 0;
                v.gridy = 0;
                admin = new JLabel(image3);
                user = new JLabel(image1);
                //staff = new JLabel(image2);
                info = new JButton(image4);
                info.setToolTipText("Get More Information");
                info.setBackground(Color.lightGray);
                info.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent err) {
                        JOptionPane.showMessageDialog(null, "The Software was build with the late utilities.");
                    }
                });
                badmin = new JButton("Admin Login");
                badmin.setToolTipText("login admin only");
                badmin.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent err) {
                        FWelcome.setVisible(false);
                        TechCompany ladmin = new TechCompany();
                        ladmin.Admin();
                    }
                });
                buser = new JButton("User Login");
                buser.setToolTipText("login user only");
                buser.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent err) {
                        FWelcome.setVisible(false);
                        TechCompany luser = new TechCompany();
                        luser.User();
                    }
                });

                v.anchor = GridBagConstraints.LINE_START;
                v.insets = new Insets(20, 0, 20, 100);
                v.gridy = 0;
                v.gridx = 0;
                sections.add(info, v);
                v.gridy++;
                v.gridx++;
                sections.add(admin, v);
                v.gridx++;
                sections.add(user, v);
                /* v.gridx++;
                 sections.add(staff, v);*/

                v.anchor = GridBagConstraints.LINE_START;
                v.insets = new Insets(20, 0, 20, 100);
                v.gridy = 2;
                v.gridx = 1;
                sections.add(badmin, v);
                v.gridx++;
                sections.add(buser, v);
                /*v.gridx++;
                 sections.add(bstaff, v);*/

                sections.setBackground(Color.lightGray);
                sections.setBorder(new TitledBorder("Login Section"));
                Pmain.add("South", sections);

            }
        });

    }

    public static void main(String[] args) {
        TechCompany tech = new TechCompany();
        tech.Welcome();
    }

}
