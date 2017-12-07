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

import com.sdj.DataBase;


public class IssueBooks extends JFrame implements ActionListener{

	JLabel nsd,sn,sadd,spno,seid,sci;
	JTextField tsn,tsadd,tspno,teid,tci;
	JButton Is,cle;
    JTable table;
	Font f = new Font("Dialog",Font.BOLD,26);
	Font f1 = new Font("Dialog",Font.BOLD,13);
	int s1;
	public IssueBooks(){
		 
		 setLayout(null);
		 nsd  =new JLabel("Issue Books");
		 nsd.setFont(f);
		 sn =new JLabel("Book No:");
		 sadd =new JLabel("Student id:");
		 spno = new JLabel("Student Name");
		 sn.setFont(f1);
		 sadd.setFont(f1);
		 spno.setFont(f1);
		 tsn  =  new JTextField(30);
		 tsadd = new JTextField(30);
		 tspno = new JTextField(30);
		 nsd.setBounds(320, 20, 3000, 35);
		 add(nsd);
		 nsd.setForeground(Color.BLUE);
		 sn.setBounds(200,120, 120, 20);
		 add(sn);
		 sadd.setBounds(200,155,110, 20);
		 add(sadd);
		 spno.setBounds(200,190,150,20);
		 add(spno);
		 tsn.setBounds(370, 120, 150, 20);
	     add(tsn);
	     tsadd.setBounds(370, 155, 150, 20);
	     add(tsadd);
	     tspno.setBounds(370,190,150,20);
	     add(tspno);
	     Is  =new JButton("ISSUE");
		 cle  =new JButton("CLEAR");
		 Is.setBounds(350,250, 80, 30);
		 add(Is);
		 cle.setBounds(500,250, 80, 30);
		 add(cle);
		 Is.addActionListener(this);
		 cle.addActionListener(this);
	  }
		
	  
	  public void actionPerformed(ActionEvent e) {
		
		  
		  if(e.getSource() == Is){
				  
				   Connection con=null;
				   Statement stmt =null;
				   System.out.println("SUBMIT");
				   String st   =  tspno.getText();  
				   String mid     =  tsadd.getText();
				   int mb      =  Integer.parseInt(tsn.getText()); 
				   System.out.println(st+":"+mid+":"+mb);
			  
				   try
				   {
			       con  = DataBase.getConnect();
				   stmt  = con.createStatement();
				   String sql ="insert into student values('"+st+"','"+mid+"',"+mb+")";
				   String sql1 ="UPDATE books SET Quantity = Quantity - 1 where Bookno = '"+mb+"'"; 
				   System.out.println(sql);
				   stmt.executeUpdate(sql);
				   System.out.println(sql1);
				   stmt.executeUpdate(sql1);
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

			  
			  
			 if (e.getSource() == cle ){
		           
				   //new DefaultTableModel().rowsRemoved(null);
				  
				    JOptionPane.showConfirmDialog(null, "Data has been removed", "Result", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
	                DefaultTableModel dm  = (DefaultTableModel)this.table.getModel();
				    dm.setRowCount(0); 
		     	   }
	    	  
	  }

}


