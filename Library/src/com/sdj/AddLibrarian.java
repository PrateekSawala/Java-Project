package com.sdj;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class AddLibrarian extends JFrame implements ActionListener{

	JLabel nsd,sid,sn,sadd,spno,seid,sci;
	JTextField tid,tsn,tsadd,tspno,teid,tci;
	JButton save,all;
	Connection con=null;
	Statement stmt =null;
	Font f = new Font("Dialog",Font.BOLD,26);
	Font f1 = new Font("Dialog",Font.BOLD,13);
	  public AddLibrarian(){
		 setLayout(null);
		 nsd  =new JLabel("ADD New Librarian");
		 nsd.setFont(f);
		 sid =new JLabel("ID");
		 sn =new JLabel("Name");
		 sadd =new JLabel("Address");
		 spno =new JLabel("Phone no");
		 seid =new JLabel("Email id");
		 sci = new JLabel("City");
		 sid.setFont(f1);
		 sn.setFont(f1);
		 sadd.setFont(f1);
		 spno.setFont(f1);
		 seid.setFont(f1);
		 sci.setFont(f1);
		 tid  =  new JTextField(30);
		 tsn  =  new JTextField(30);
		 tsadd = new JTextField(30);
		 tspno = new JTextField(30);
		 teid  = new JTextField(30);
		 tci =   new JTextField(30);
		 nsd.setBounds(320, 20, 3000, 35);
		 add(nsd);
		 nsd.setForeground(Color.BLUE);
		 sid.setBounds(200,120, 120, 20);
		 add(sid);
		 sn.setBounds(200,155, 120, 20);
		 add(sn);
		 sadd.setBounds(200,190,110, 20);
		 add(sadd);
		 spno.setBounds(200,225,120,20);
		 add(spno);
		 seid.setBounds(200,260,120, 20);
		 add(seid);
		 sci.setBounds(200, 295, 110, 20);
		 add(sci);
		 tid.setBounds(370, 120, 150, 20);
	     add(tid);
	     tsn.setBounds(370, 155, 150, 20);
	     add(tsn);
	     tsadd.setBounds(370, 190, 250, 20);
	     add(tsadd);
	     tspno.setBounds(370, 225, 150, 20);
	     add(tspno);
	     teid.setBounds(370, 260, 250, 20);
	     add(teid);
	     tci.setBounds(370, 295 ,150, 20);
	     add(tci);
	     save  =new JButton("Save");
		 all  =new JButton("All");
		 save.setBounds(350,320, 80, 30);
		 add(save);
		 all.setBounds(500,320, 80, 30);
		 add(all);
		 save.addActionListener(this); 
		 all.addActionListener(this);
	  }
		
	  
	  public void actionPerformed(ActionEvent e) {
		
		  if(e.getSource()==save)
		  {
		   System.out.println("Save"); 
		   String mi  =  tid.getText();
	       String min  =  tsn.getText();
		   String mic  =  tsadd.getText();   
		   String msp =  tspno.getText();
		   String mei =  teid.getText();
		   String mir  =  tci.getText();
		   System.out.println(min+":"+mic+":"+msp+":"+mei+":"+mir);
		  try
		   {
	       con  = DataBase.getConnect();
		   stmt  = con.createStatement();
		   String sql ="insert into librarian values("+mi+",'"+min+"','"+mic+"','"+msp+"','"+mei+"','"+mir+"')";
		   System.out.println(sql);
		   stmt.executeUpdate(sql);
		   JOptionPane.showConfirmDialog(null, "Your Data Has been Inserted", "Result", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
		   
		   }
		   catch(Exception ex)
		   {
			   ex.printStackTrace();
			   JOptionPane.showConfirmDialog(null, "Problem in Database connectivity or Data", "Result", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);   		   
	 	       
		   }
		   finally
		   {
			   DataBase.closeResource(con, stmt);
		   }
		 }
		 if(e.getSource()==all)
		 {
			 System.out.println("all");
			 Connection con  =null;
			 Statement stmt =null;
			 JTable table=null;
			 DefaultTableModel dtm =null;
			 String sql  = "select *from librarian";
			 ResultSet rs  =null;//virtual table inside java
			 try
			 {
				 con  = DataBase.getConnect();
				 stmt  = con.createStatement();
				 rs  = stmt.executeQuery(sql);
				 dtm  =new DefaultTableModel();
				 table  =new JTable(dtm);
				 table.setBounds(15,400,500,600);
				 dtm.addColumn("L_ID");
				 dtm.addColumn("L_NAME");
				 dtm.addColumn("L_ADDRESS");
				 dtm.addColumn("M_PHONENO");
				 dtm.addColumn("M_EMAILID");
				 dtm.addColumn("M_CITY");
				int count=0;
				 while(rs.next())
				 {
					 dtm.insertRow(count,new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});
					 count++;
				 }
				 JScrollPane jsp  =new JScrollPane(table);
				 jsp.setBounds(100,360,800,600);
				/* JPanel jp =new JPanel();
				 jp.setBounds(150, 350, 300, 150);
				 jp.add(jsp);
				 add(jp);
				*/ 
				 add(jsp);
				 
				 
			 }
			 catch(Exception ex)
			 {
				 ex.printStackTrace();
			 }
		 } 
	  

	
	  
	  
	  
	  
	  }

}
