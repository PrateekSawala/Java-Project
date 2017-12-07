package com.sdj;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.font.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.sdj.DataBase;

public class UpdateLibrarian extends JFrame implements ActionListener {

	JLabel nsd,sn,sadd,spno;
	JTextField tsn,tsadd,tspno;
	JButton upd,all;
	Font f = new Font("Dialog",Font.BOLD,26);
	Font f1 = new Font("Dialog",Font.BOLD,13);
	  
	public UpdateLibrarian(){
		 setLayout(null);
		 nsd  =new JLabel("Update Librarian");
		 nsd.setFont(f);
		 sadd = new JLabel("Librarian New address");
		 spno =new JLabel("Librarian New phone no");
		 sn = new JLabel("Librarian Id");
		 sadd.setFont(f1);
		 spno.setFont(f1);
		 sn.setFont(f1);
	     tsn =new JTextField(30);
		 tsadd  =new JTextField(30);
		 tspno =new JTextField(30);
		 nsd.setBounds(320, 20, 3000, 35);
		 add(nsd);
		 nsd.setForeground(Color.BLUE);
		 sn.setBounds(200, 120, 120, 20);
		 add(sn);
		 sadd.setBounds(200, 155, 170, 20);
		 add(sadd);
		 spno.setBounds(200, 190, 170, 20);
		 add(spno);
		 tsn.setBounds(370, 120, 150, 20);
	     add(tsn);
	     tsadd.setBounds(370, 155, 150, 20);
	     add(tsadd);
	     tspno.setBounds(370, 190, 150, 20);
	     add(tspno);
	     upd  =new JButton("UPDATE");
		 all  =new JButton("All");
		 upd.setBounds(350,230, 80, 30);
		 add(upd);
		 all.setBounds(500, 230, 80, 30);
		 add(all);
		 upd.addActionListener(this); 
		 all.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource()==upd)
		  {
		   Connection con=null;
		   Statement stmt =null;
		   System.out.println("Update");
		   String mn =   tsn.getText();
	       String madd = tsadd.getText();   
		   String mph =  tspno.getText();
		   System.out.println(mn+":"+madd+":"+mph);
		  try
		   {
	       con  = DataBase.getConnect();
		   stmt  = con.createStatement();
		   String sql ="UPDATE librarian SET laddress='"+madd+"', lphoneno='"+mph+"' where lid = '"+mn+"'";
		   System.out.println(sql);
		   stmt.executeUpdate(sql);
		   JOptionPane.showConfirmDialog(null, "Your Data Has been UPDATED", "Result", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
		   
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
          
		if(e.getSource() == all){
	    	   
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
				 jsp.setBounds(100,400,800,600);
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
	
