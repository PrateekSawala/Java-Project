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

public class ReturnBooks extends JFrame implements ActionListener{

	JLabel nsd,sed;
	JTextField ted;
	JButton ret,cle;
	JTable table;
	Font f = new Font("Dialog",Font.BOLD,26);
	Font f1 = new Font("Dialog",Font.BOLD,13);
	  
	public ReturnBooks(){
		 setLayout(null);
		 nsd  =new JLabel("Return Books");
		 nsd.setFont(f);
		 sed =new JLabel("Book no:");
		 sed.setFont(f1);
		 ted  =  new JTextField(30);
		 nsd.setBounds(320, 20, 3000, 35);
		 add(nsd);
		 nsd.setForeground(Color.BLUE);
		 sed.setBounds(200,120,150, 20);
		 add(sed);
	     ted.setBounds(370, 120, 120, 20);
	     add(ted);
	     ret  =new JButton("Return");
		 cle  =new JButton("Clear");
		 ret.setBounds(350,150, 80, 30);
		 add(ret);
		 cle.setBounds(500,150, 80, 30);
		 add(cle);
		 ret.addActionListener(this); 
		 cle.addActionListener(this);

	  }	
	

	  public void actionPerformed(ActionEvent e){
		
	
          if(e.getSource()== ret){

           Connection con  =null;
   		   Statement stmt =null;
           System.out.println("Delete"); 
   	       int min  = Integer.parseInt(ted.getText());   
   		   System.out.println(min);
   		  try
   		   {
   	       con  = DataBase.getConnect();
   		   stmt  = con.createStatement();
   		   String sql ="delete from Student where Bookno = '"+ min +"'";
   		   String sql1 ="UPDATE books SET Quantity = Quantity + 1 where Bookno = '"+min+"'";
   		   System.out.println(sql);
   		   stmt.executeUpdate(sql);
   		   System.out.println(sql1);
		   stmt.executeUpdate(sql1);
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
		   
        	  
     
          if (e.getSource() == cle){
	           
			   //new DefaultTableModel().rowsRemoved(null);
			  
			    JOptionPane.showConfirmDialog(null, "Data has been removed", "Result", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                DefaultTableModel dm  = (DefaultTableModel)this.table.getModel();
			    dm.setRowCount(0); 
			    
			    
               
		   }
 

	  
	  

	  }




}
