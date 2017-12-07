package com.sdj;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;


public class LibraryMenu  extends JFrame implements ActionListener {

	JMenuBar menu;
	JLabel wtm;
	JMenu li,bk,ex;
	JMenuItem al,dl,ul,ab,db,sb,exi;
    Font f = new Font("Dialog",Font.BOLD,26);

	
	public LibraryMenu(){
		
		wtm= new JLabel("             WELCOME TO LIBRARY MANAGEMENT SYSTEM FOR LIBRARIAN");
	    wtm.setFont(f);
		wtm.setBounds(200,200,2000,2000);
		add(wtm);
		wtm.setForeground(Color.black);
		menu  = new JMenuBar();
		li = new JMenu("Librarian");
		bk=new JMenu("Books");
		ex=new JMenu("Exit");
		menu.add(li);
		menu.add(bk);
		menu.add(ex);
		add(menu,BorderLayout.NORTH);
		al=new JMenuItem("Add Librarian");
		dl=new JMenuItem("Delete Librarian");
		ab =new JMenuItem("Add Books");
		db=new JMenuItem("Delete Books");
		ul=new JMenuItem("Update Librarian");
		sb=new JMenuItem("Search Books");
		exi=new JMenuItem("exit");
		li.add(al);
	    li.add(dl);
	    bk.add(ab);
	    bk.add(db);
	    li.add(ul);
	    bk.add(sb);
	    ex.add(exi);
	    al.addActionListener(this);
	    dl.addActionListener(this); 	
	    ab.addActionListener(this);  
	    db.addActionListener(this);
	    ul.addActionListener(this);
	    sb.addActionListener(this);
	    exi.addActionListener(this);
	    }
	
public void actionPerformed(ActionEvent e) {
		
		
	if(e.getSource()==exi){
		       System.exit(0);
	  }	
    
	if(e.getSource()== al){
     
    AddLibrarian ali = new AddLibrarian();
   	 ali.setVisible(true);
   	 ali.setSize(1200,700);
   	 ali.setTitle("Add Librarian");
        }
            
     if(e.getSource() == dl){
         	 DeleteLibrarian dle = new DeleteLibrarian();
        	 dle.setVisible(true);
        	 dle.setSize(1200,700);
        	 dle.setTitle("Delete Librarian");
             
          }
 
        if(e.getSource() == ab ){
       	      AddBooks ad = new AddBooks();
        	 ad.setVisible(true);
        	 ad.setSize(1200,700);
        	 ad.setTitle("Add Books");
                     }

     if(e.getSource() == db){
            DeleteBooks is= new DeleteBooks();
        	 is.setVisible(true);
        	 is.setSize(1200,700);
        	 is.setTitle("Delete Books");
                    
             }	
       if(e.getSource() == ul){
         UpdateLibrarian uli= new UpdateLibrarian();
     	 uli.setVisible(true);
     	 uli.setSize(1200,700);
     	 uli.setTitle("Update Librarian");
                 
        }	
     if(e.getSource() == sb){
         SearchBooks sbi= new SearchBooks();
     	 sbi.setVisible(true);
     	 sbi.setSize(1200,700);
     	 sbi.setTitle("Search Librarian");
                 
          }	


}


}
