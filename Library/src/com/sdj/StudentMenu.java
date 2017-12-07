package com.sdj;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class StudentMenu  extends JFrame implements ActionListener {


	   JLabel wm;
       JButton ib,rb,ex;

       Font f = new Font("Dialog",Font.BOLD,20);
        	    
     public StudentMenu(){
        
		setLayout(null);
		
		wm= new JLabel("WELCOME TO LIBRARY MANAGEMENT SYSTEM FOR STUDENT");
		wm.setBounds(300,5,1000,50);
		add(wm);
		wm.setForeground(Color.black);
		wm.setFont(f);
	    
		ib  =new JButton("Issue Books");
		rb  =new JButton("Return Books");
		ex  =new JButton("Exit");
		ib.setBounds(300,200,150,30);
		add(ib);
		rb.setBounds(500,200,150,30);
		add(rb);
		ex.setBounds(700,200,150,30);
		add(ex);
	    ib.addActionListener(this);
	    rb.addActionListener(this); 	
	    ex.addActionListener(this);
	
     }
   	
public void actionPerformed(ActionEvent e) {
		
		
	
	if(e.getSource() == ib){
     
	 IssueBooks ibe = new IssueBooks();
   	 ibe.setVisible(true);
   	 ibe.setSize(1200,700);
   	 ibe.setTitle("Issue Books");
     
	}
            
     if(e.getSource() == rb){
        
    	     ReturnBooks rb = new ReturnBooks();
        	 rb.setVisible(true);
        	 rb.setSize(1200,700);
        	 rb.setTitle("Return Books");
             
          }

     if(e.getSource()==ex){
	       System.exit(0);
} 

}

}
