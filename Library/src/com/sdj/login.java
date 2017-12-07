package com.sdj;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
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
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.sdj.DataBase;

public class login  extends JFrame implements ActionListener  {


	    JLabel admin,uname,psswrd,use;
		JTextField uid,pwd,us;
		JButton login,exit;
		Font f = new Font("Dialog",Font.BOLD,30);
		Font f1 = new Font("Dialog",Font.BOLD,13);
		
		public boolean move; 		
		
		public login(){
		
		 setLayout(null);
		 admin  =new JLabel("Administrator");
		 admin.setFont(f);
		 uname = new JLabel("User Name:");
		 psswrd =new JLabel("Password:");
		 use  = new JLabel("User:");
		 uname.setFont(f1);
		 psswrd.setFont(f1);
		 use.setFont(f1);
		 uid = new JTextField(30);
		 pwd  =new JTextField(30);
		 us  = new JTextField(30);
		 admin.setBounds(290, 20, 3000, 35);
		 add(admin);
		 uname.setBounds(150, 120, 120, 20);
		 add(uname);
		 use.setBounds(150, 155, 100, 20);
		 add(use);
		 psswrd.setBounds(150,190,110, 20);
		 add(psswrd);
		 uid.setBounds(300, 120, 150, 20);
	     add(uid);
	     us.setBounds(300, 155, 150, 20);
	     add(us);
	     pwd.setBounds(300, 190, 150, 20);
	     add(pwd);
	     login  =new JButton("LOGIN");
		 login.setBounds(300,230,80, 30);
		 add(login);
		 exit  =new JButton("EXIT");
		 exit.setBounds(400,230, 80, 30);
		 add(exit);
		 login.addActionListener(this);
		 exit.addActionListener(this);
		 
		 
	} 
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==login)
			{
				   Connection con=null;
				   Statement stmt =null;
				   ResultSet rs  =null;
				  
				
				try
				{         con  = DataBase.getConnect();
					      stmt  = con.createStatement(); 
					      rs=stmt.executeQuery("select * from login where user_name = '"+uid.getText()+"';");
					      if(!rs.next())
					      {
					    	  JOptionPane.showMessageDialog(null,"Sorry!!!you are not a valid user...!!!","WARNING",JOptionPane.ERROR_MESSAGE);
					      }
					
					      else
					      {
					    	       
					    	         String s=pwd.getText();
					    	         String s1 =us.getText(); 
					    	     
					    	     if(s1.equals(rs.getString("user"))){
                                       					    	         
					    	         if(s.equals(rs.getString("psswrd"))){
					    	    	   
					    	    	   JOptionPane.showMessageDialog(null,"Welcome!!!you are valid user...!!!","Welcome",JOptionPane.INFORMATION_MESSAGE);					    	    	   
		                                
					    	    	    if(s1.equals("Student")){
		                            	   move = true;
		                            	   }
		                            
		                               if(s1.equals("Librarian")){
		                            	   move = false;
		                                  }
	                                      				    	       
					    	          }
					            }  
					    
					      }
					    
					    	       
					 }
							      
			     	catch(Exception ex)
				   {
					 ex.printStackTrace();
				   }
			  
			
		if(move == true)
		{		
		StudentMenu sm = new StudentMenu();
        sm.setVisible(true);
        sm.setTitle("studentMenu");
        sm.setSize(1200,700);
		} 
		
		if(move == false)
		{		
		LibraryMenu lm = new LibraryMenu();
        lm.setVisible(true);
        lm.setTitle("LibraryMenu");
        lm.setSize(1200,700);
		} 
		   
	}		
		
		if(e.getSource()==exit){
				
				System.exit(0);
				
			}
			
			
}			    	       
					    	       
public static void main(String args[])
     {
       login log = new login();
       log.setVisible(true);
       log.setTitle("Login");
       log.setSize(700,500);
     }

}
					     

