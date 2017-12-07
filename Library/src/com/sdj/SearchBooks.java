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


public class SearchBooks extends JFrame implements ActionListener  {

	JLabel nsd,sid,sn,sadd,spno,seid;
	JTextField tid,tsn,tsadd,tspno,teid;
	JButton ser,all;
    Font f = new Font("Dialog",Font.BOLD,26);
	Font f1 = new Font("Dialog",Font.BOLD,13);
	  
	
	public SearchBooks(){
		 setLayout(null);
		 nsd  =new JLabel("Search Books");
		 nsd.setFont(f);
		 sn =new JLabel("Search Book name");
		 sn.setFont(f1);
		 tsn  =new JTextField(30);
		 nsd.setBounds(320, 20, 3000, 35);
		 add(nsd);
		 nsd.setForeground(Color.BLUE);
		 sn.setBounds(200, 120, 150, 20);
		 add(sn);
		 tsn.setBounds(370, 120, 250, 20);
	     add(tsn);
	     ser  =new JButton("Search");
		 all  =new JButton("All");
		 ser.setBounds(350,150, 80, 30);
		 add(ser);
		 all.setBounds(500, 150, 80, 30);
		 add(all);
		 ser.addActionListener(this); 
		 all.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
	
		
		if(e.getSource()==ser)
		  {
			   System.out.println("Search");      
			   String mn  =  tsn.getText();
			   System.out.println(mn); 
			   Connection con=null;
			   Statement stmt =null;
		       ResultSet rs = null;
			   DefaultTableModel dtm =null;
			   JTable table=null;
	 		   String sql  = "select *from books where Nameofbooks='" + mn + "' ";
	          try{
	        	  con  = DataBase.getConnect();
	 			  stmt  = con.createStatement();
	 			  rs  = stmt.executeQuery(sql);
	 		      dtm  =new DefaultTableModel();
	 		      table  =new JTable(dtm);
 				  table.setBounds(15,170,600,100);
 				 dtm.addColumn("B_NO");
 				 dtm.addColumn("B_NAME");
 				 dtm.addColumn("B_AUTHOR");
 				 dtm.addColumn("B_BRANCH");
 				 dtm.addColumn("B_QUANTITY"); 				  
 				 int count=0;
 				  while(rs.next())
 				 {     
 					   
 						   dtm.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)});
 						   count++; 					  
  				}
 					
 				  if(count == 0){
 						
 						 JOptionPane.showConfirmDialog(null, "Name not found ", "Result", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);	
 					}
 					    
 				if(count == 1){
 					
 					 JOptionPane.showConfirmDialog(null, "Name found ", "Result", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
 				}
 				else
 				{
 					 JOptionPane.showConfirmDialog(null, "Name found ", "Result", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
 				}
 				 
 		       
 				JScrollPane jsp  =new JScrollPane(table);
 			    jsp.setBounds(100,200,800,600);
 				/* JPanel jp =new JPanel();
 				 jp.setBounds(150, 350, 300, 150);
 				 jp.add(jsp);
 				 add(jp);*/
 				 add(jsp); 
 				
	          
	          }
		   
	           catch(Exception ex)
			   {
				   ex.printStackTrace();
				   JOptionPane.showConfirmDialog(null, "Problem in DataBase Connectivity ", "Result", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);   		   
		 	       
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
			 String sql  = "select *from books";
			 ResultSet rs  =null;//virtual table inside java
			 try
			 {
				 con  = DataBase.getConnect();
				 stmt  = con.createStatement();
				 rs  = stmt.executeQuery(sql);
				 dtm  =new DefaultTableModel();
				 table  =new JTable(dtm);
				 table.setBounds(15,400,500,600);
				 dtm.addColumn("B_NO");
				 dtm.addColumn("B_NAME");
				 dtm.addColumn("B_AUTHOR");
				 dtm.addColumn("B_BRANCH");
				 dtm.addColumn("B_QUANTITY");
				int count=0;
				 while(rs.next())
				 {
					 dtm.insertRow(count,new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)});
					 count++;
				 }
				 JScrollPane jsp  =new JScrollPane(table);
				 jsp.setBounds(100,200,800,600);
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
	
