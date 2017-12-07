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

public class DeleteBooks extends JFrame implements ActionListener{

	JLabel nsd,slid;
	JTextField tid;
	JButton del,all;
	Font f = new Font("Dialog",Font.BOLD,26);
	Font f1 = new Font("Dialog",Font.BOLD,13);
	  public DeleteBooks(){
		 
		 setLayout(null);
		 nsd  =new JLabel("Delete Books");
		 nsd.setFont(f);
		 slid =new JLabel("Enter Book No:");
		 slid.setFont(f1);
     	 tid  = new JTextField(30);
		 nsd.setBounds(320, 20, 3000, 35);
		 add(nsd);
		 nsd.setForeground(Color.BLUE);
	     slid.setBounds(200,155,160, 20);
		 add(slid);
	     tid.setBounds(370, 155, 120, 20);
	     add(tid);
	     del  =new JButton("Delete");
		 all  =new JButton("Show");
		 del.setBounds(350,190, 80, 30);
		 add(del);
		 all.setBounds(500,190, 80, 30);
		 add(all);
		 del.addActionListener(this); 
		 all.addActionListener(this);

	  }	
	

	  public void actionPerformed(ActionEvent e){
		
	
		  if(e.getSource()==del)
		  {
		   Connection con  =null;
		   Statement stmt =null;
           System.out.println("Delete"); 
	       String min  =  tid.getText();   
		   System.out.println(min);
		  try
		   {
	       con  = DataBase.getConnect();
		   stmt  = con.createStatement();
		   String sql ="delete from books where Bookno = '"+ min +"'";
		   System.out.println(sql);
		   stmt.executeUpdate(sql);
		   JOptionPane.showConfirmDialog(null, "Your Data Has been Deleted", "Result", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
		   
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
					 jsp.setBounds(100,250,800,600);
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
