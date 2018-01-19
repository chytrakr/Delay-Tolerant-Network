import java.awt.Color;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

 class Viewfiles extends JFrame implements ActionListener
{
	JPanel p1;
	JButton b1;
	JScrollPane pane;
	

	

	Vector data,Heading;
	Viewfiles ()
	{
		
		
		p1=new JPanel();
		p1.setLayout(null);
		
		b1=new JButton(" * View file Details *");
		b1.setBounds(250,330,200,30);
		b1.addActionListener(this);
		
		
		p1.add(b1);
		p1.setBackground(Color.RED);
		setTitle(" View Files .....");
		add(p1);
		
		Heading=new Vector();
		Heading.addElement("File-Name");
		Heading.addElement("Destination");
		
		 Vector data=new Vector();
		 try
		 {
			 Dbcon d5=new Dbcon();
			 Connection connect=d5.getConnection();
			 Statement stmt = connect.createStatement();
         
         
         String query = "SELECT * FROM Router";
         ResultSet rs = stmt.executeQuery(query);
         ResultSetMetaData rsm=rs.getMetaData();
     	int col=rsm.getColumnCount();



     	            while(rs.next())
     	             {
				         	Vector row = new Vector();
				         	  for(int i = 1; i <=col; i++)
				         	  {
				         	    row.addElement(rs.getObject(i));

     	            
				         	  }

				         	  data.addElement(row);
     	             }
     			  
     			JTable table = new JTable(data,Heading);
     			  
     			  pane = new JScrollPane(table);
     			 
     			  pane.setBounds(50,50,650,200);
     			  p1.add(pane);
     			
     	 } 
     	 catch(Exception ex) {ex.printStackTrace();} 	
		
		
		
		setSize(750, 600);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource()==b1)
		{
			
			
			
			
		}
		
		
	}
	public static void main(String[] args) 
	{
		new ViewEvidence();
		
	}
}