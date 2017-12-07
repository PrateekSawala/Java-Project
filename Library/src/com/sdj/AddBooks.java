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


public class AddBooks extends JFrame implements ActionListener{

	JLabel nsd,sn,sadd,spno,seid,sci;
	JTextField tsn,tsadd,tspno,teid,tci;
	JButton Add,all;
	Font f = new Font("Dialog",Font.BOLD,26);
	Font f1 = new Font("Dialog",Font.BOLD,13);
	  public AddBooks(){
		 setLayout(null);
		 nsd  =new JLabel("ADD Books");
		 nsd.setFont(f);
		 sn =   new JLabel("Book No:");
		 sadd=  new JLabel("Name of Books:");
		 spno = new JLabel("Author");
		 seid = new JLabel("Branch");
		 sci =  new JLabel("quantity");
		 sn.setFont(f1);
		 sadd.setFont(f1);
		 spno.setFont(f1);
		 seid.setFont(f1);
		 sci.setFont(f1);
		 tsn  =  new JTextField(30);
		 tsadd = new JTextField(30);
		 tspno = new JTextField(30);
		 teid  = new JTextField(30);
		 tci =   new JTextField(30);
		 nsd.setBounds(320, 20, 3000, 35);
		 add(nsd);
		 nsd.setForeground(Color.BLUE);
		 sn.setBounds(200,120, 120, 20);
		 add(sn);
		 sadd.setBounds(200,155,110, 20);
		 add(sadd);
		 spno.setBounds(200,190,120,20);
		 add(spno);
		 seid.setBounds(200,225,120, 20);
		 add(seid);
		 sci.setBounds(200, 260, 110, 20);
		 add(sci);
		 tsn.setBounds(370, 120, 150, 20);
	     add(tsn);
	     tsadd.setBounds(370, 155, 250, 20);
	     add(tsadd);
	     tspno.setBounds(370, 190, 150, 20);
	     add(tspno);
	     teid.setBounds(370, 225, 150, 20);
	     add(teid);
	     tci.setBounds(370,260,150, 20);
	     add(tci);
	     Add  =new JButton("Add");
		 all  =new JButton("Show");
		 Add.setBounds(350,290, 80, 30);
		 add(Add);
		 all.setBounds(500,290, 80, 30);
		 add(all);
		 Add.addActionListener(this); 
		 all.addActionListener(this);
	  }
		
	  
	  public void actionPerformed(ActionEvent e) {
		   
		  if(e.getSource()==Add)
		  {
		   Connection con  =null;
		   Statement stmt =null;
		   System.out.println("Add"); 
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
	       String sql ="insert into books values("+min+",'"+mic+"','"+msp+"','"+mei+"',"+mir+")";
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

