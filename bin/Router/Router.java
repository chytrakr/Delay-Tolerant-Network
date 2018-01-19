import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.*;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.Border;

public class Router extends JFrame implements ActionListener
{
	JPanel p1;
	ImageIcon m1,m2,m3,m4,d1,d2,d3,d4,virus;
	JLabel n1,n2,y1,y2,y3,y4,y5;
	
	JLabel t1,t2,t3,t4,t5,t6,t7;
	JLabel b1,b2,b3;
	public Font f2 = new Font("Times new roman", Font.BOLD, 18);
	
	ImageIcon Blackline1,Blackline2,Blackline3;
	ImageIcon Greenline1,Greenline2, Greenline3;
	JLabel black1,black2,black3;
	
	MenuBar mbr;
	Menu k1;
	MenuItem i1,i2;
	
	JButton view,del;
	
	Router()
	{
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(216,191,216));
		
		mbr=new MenuBar();
		setMenuBar(mbr);
		
		
		k1=new Menu("File");
		i1=new MenuItem("Exit");
		i2=new MenuItem("View Files");
		k1.add(i2);
		k1.add(i1);
		mbr.add(k1);
		
		i1.addActionListener(this);
		i2.addActionListener(this);
		
		view =new JButton("View Evidence");
		view.addActionListener(this);
		view.setBounds(35, 395,200,30);
		del	 =new JButton("Delete");
		del.addActionListener(this);
		del.setBounds(35, 435,200,30);
		
		Border b11 = BorderFactory.createBevelBorder(0);
		b1 = new JLabel();
		b1.setBorder(b11);
		b1.setBounds(650,15,240,520);
		
		Border b22 = BorderFactory.createBevelBorder(0);
		b2 = new JLabel();
		b2.setBorder(b22);
		b2.setBounds(35, 115, 540, 370);
		
		Border b33 = BorderFactory.createBevelBorder(0);
		b3 = new JLabel();
		b3.setBorder(b33);
		b3.setBounds(35, 385, 540, 100);
		p1.add(b3);
		
		Blackline1=new ImageIcon(this.getClass().getResource("images\\Bline1.png"));
		Greenline1=new ImageIcon(this.getClass().getResource("images\\Gline1.png"));
		black1=new JLabel();
		black1.setIcon(Blackline1);
		black1.setBounds(180,220,200,30);
		
		Blackline2=new ImageIcon(this.getClass().getResource("images\\Bline2.png"));
		Greenline2=new ImageIcon(this.getClass().getResource("images\\Gline2.png"));
		black2=new JLabel();
		black2.setIcon(Blackline2);
		black2.setBounds(400,230,30,300);
		
		Blackline3=new ImageIcon(this.getClass().getResource("images\\Bline3.png"));
		Greenline3=new ImageIcon(this.getClass().getResource("images\\Gline3.png"));
		black3=new JLabel();
		black3.setIcon(Blackline3);
		black3.setBounds(550,220,300,30);
		
		m1=new ImageIcon(this.getClass().getResource("images\\owner.png"));
		m3=new ImageIcon(this.getClass().getResource("images\\scan.gif"));
		
		n1=new JLabel();
		n1.setIcon(m1);
		n1.setBounds(50,120,200,200);
		
		m2=new ImageIcon(this.getClass().getResource("images\\sec.jpg"));
		virus=new ImageIcon(this.getClass().getResource("images\\viruspic.jpg"));
		n2=new JLabel();
		n2.setIcon(m2);
		n2.setBounds(330,130,200,200);
		
		d1=new ImageIcon(this.getClass().getResource("images\\DA.jpg"));
		y1=new JLabel();
		y1.setIcon(d1);
		y1.setBounds(680,20,150,150);
		
		
		d2=new ImageIcon(this.getClass().getResource("images\\DB.jpg"));
		y2=new JLabel();
		y2.setIcon(d2);
		y2.setBounds(680,120,150,150);
		
		d3=new ImageIcon(this.getClass().getResource("images\\DC.jpg"));
		y3=new JLabel();
		y3.setIcon(d3);
		y3.setBounds(680,220,150,150);
		
		d4=new ImageIcon(this.getClass().getResource("images\\DD.jpg"));
		y4=new JLabel();
		y4.setIcon(d4);
		y4.setBounds(680,320,150,150);
		
		m4=new ImageIcon(this.getClass().getResource("images\\user2.png"));
		y5=new JLabel();
		y5.setIcon(m4);
		y5.setBounds(480,350,150,150);
		
		t7=new JLabel();
		t7.setText("Evidence Aging Collector");
		t7.setFont(f2);
		t7.setBounds(280,350,200,150);
		
		t1=new JLabel();
		t1.setText("Sender");
		t1.setFont(f2);
		t1.setBounds(100,290,100,50);
		
		t2=new JLabel();
		t2.setText("Warm Filter");
		t2.setFont(f2);
		t2.setBounds(365,290,500,50);
		
		t3=new JLabel();
		t3.setText("Reciever-> A");
		t3.setFont(f2);
		t3.setBounds(750,70,100,50);
		
		
		t4=new JLabel();
		t4.setText("Reciever-> B");
		t4.setFont(f2);
		t4.setBounds(750,170,100,50);
		
		t5=new JLabel();
		t5.setText("Reciever-> C");
		t5.setFont(f2);
		t5.setBounds(750,270,100,50);
		
		
		t6=new JLabel();
		t6.setText("Reciever-> D");
		t6.setFont(f2);
		t6.setBounds(750,370,100,50);
		
		
		p1.add(y1);p1.add(y2);p1.add(y3);p1.add(y4);p1.add(y5);
		p1.add(n1);	p1.add(n2);
		p1.add(b1);	p1.add(b2);p1.add(view);p1.add(del);
		p1.add(black1);p1.add(black2);p1.add(black3);
		p1.add(t1);p1.add(t2);p1.add(t3);p1.add(t4);p1.add(t5);p1.add(t6);p1.add(t7);
		add(p1);
		setSize(900,600);
		setVisible(true);
		
		
		int [] ports=new int[] {12345};
		for (int i=0;i<1;i++)
		{
			Thread t=new Thread(new PortListener(ports[i]));
			t.setName("Listener-" + ports[i]);
			t.start();
		}
	}
	
	public void actionPerformed(ActionEvent a2) 
	{
		if(a2.getSource()==view)
		{
			new ViewEvidence();
		}
		
		if(a2.getSource()==i2)
		{
			new Viewfiles();
		}
		if(a2.getSource()==del)
		{
			String vname=JOptionPane.showInputDialog(null,"Enter The VirusFile to be Deleted");
			
			try
			{
			Dbcon d8=new Dbcon();
			 Connection con = d8.getConnection();
			 Statement stmt = con.createStatement();
	 
			 String sql = "Delete * from Evidence where Virus ='"+vname+"'";
			 stmt.executeUpdate(sql);
			
			 new File("Router\\"+vname).delete();
			 
			 JOptionPane.showMessageDialog(null,"virus deleted Successfully");
			}catch(Exception es){System.out.println(es);}
		}
		
	}
	public static void main(String[] args) 
	{
		new Router();
	}
	
	class PortListener implements Runnable
	{

		BufferedOutputStream bos = null;
		ServerSocket ss1, ss2;
		Socket s1, s2;
		ServerSocket server, server1,server2,server3;
		Socket connection, so;
		BufferedReader br = null;
		int port;

		public PortListener(int port)
		{
			this.port = port;
		}

		public void run()
		{

			if(this.port==12345)
			
			{

				try
				{
					
					ServerSocket server1 = new ServerSocket(12345);
	                Socket con;
	                Dbcon d1=new Dbcon();
	                Connection c2=d1.getConnection();
					while (true) 
					{
						con = server1.accept();
					/*	DataInputStream dis=new DataInputStream(con.getInputStream());
						String fname=dis.readUTF();
						String dest=dis.readUTF();
						String ct=dis.readUTF();
						String ip1=dis.readUTF();
					*/
						ObjectInputStream ois = new ObjectInputStream(con
								.getInputStream());

						String fname = (String) ois.readObject();
						String dest = (String) ois.readObject();
						byte[] ct = (byte[]) ois.readObject();
						String ip1 = (String) ois.readObject();
						  
							
						
							t1.setText("Sender");
							
							
							t1.setVisible(true);
							Thread.sleep(1000);
							t1.setVisible(false);
							Thread.sleep(1000);
							t1.setVisible(true);
							Thread.sleep(1000);
							t1.setVisible(false);
							Thread.sleep(1000);
							t1.setVisible(true);
							Thread.sleep(1000);
							t1.setVisible(false);
							Thread.sleep(1000);
							t1.setVisible(true);
							
							Thread.sleep(2000);
							black1.setIcon(Greenline1);
							
							Thread.sleep(2000);
							n2.setIcon(m3);
							
							Thread.sleep(8000);
							
							if( fname.toLowerCase().endsWith(".ade")
							|| fname.toLowerCase().endsWith(".adp")
							|| fname.toLowerCase().endsWith(".bas")
							|| fname.toLowerCase().endsWith(".bat")
							|| fname.toLowerCase().endsWith(".chm")
							||  fname.toLowerCase().endsWith(".cmd")
							|| fname.toLowerCase().endsWith(".com")
							||  fname.toLowerCase().endsWith(".crt")
							|| fname.toLowerCase().endsWith(".dll")
							|| fname.toLowerCase().endsWith(".do*")
							||  fname.toLowerCase().endsWith(".hlp")
							|| fname.toLowerCase().endsWith(".hta")
							||  fname.toLowerCase().endsWith(".inf")
							|| fname.toLowerCase().endsWith(".ins")
							
							||  fname.toLowerCase().endsWith(".js")
							||  fname.toLowerCase().endsWith(".jse")
							||  fname.toLowerCase().endsWith(".lnk")
							||  fname.toLowerCase().endsWith(".md*")
							||  fname.toLowerCase().endsWith(".msc")
							||  fname.toLowerCase().endsWith(".msi")
							||  fname.toLowerCase().endsWith(".mst")
							|| fname.toLowerCase().endsWith(".ocx")
							||  fname.toLowerCase().endsWith(".pcd")
							||  fname.toLowerCase().endsWith(".pif")
							||  fname.toLowerCase().endsWith(".pot")
							|| fname.toLowerCase().endsWith(".reg")
							||  fname.toLowerCase().endsWith(".scr")
							||  fname.toLowerCase().endsWith(".sct")
							|| fname.toLowerCase().endsWith(".shb")
							||  fname.toLowerCase().endsWith(".shs")
							||  fname.toLowerCase().endsWith(".sys")
							||  fname.toLowerCase().endsWith(".url")
							)
							{
								System.out.println("Virus Found");
								
							
								Thread.sleep(2000);
								n2.setIcon(virus);
								n2.setBounds(360,130,200,200);
								
								
								Thread.sleep(2000);
								t2.setText("Scan Completed");
								
								
								
								
								t2.setVisible(true);
								Thread.sleep(1000);
								t2.setVisible(false);
								Thread.sleep(1000);
								t2.setVisible(true);
								Thread.sleep(1000);
								t2.setVisible(false);
								Thread.sleep(1000);
								t2.setText("Virus found");
								t2.setVisible(true);
								Thread.sleep(1000);
								t2.setVisible(false);
								Thread.sleep(1000);
								t2.setVisible(true);
								Thread.sleep(1000);
								t2.setVisible(false);
								Thread.sleep(1000);
								
								t2.setText("Warm filter");
								t2.setVisible(true);
								
								
								n2.setIcon(m2);
								n2.setBounds(330,130,200,200);
								n2.setVisible(true);
								
								DateFormat dformat=new SimpleDateFormat("yyyy/MM/dd  hh:mm:ss");
								Date date=new Date();
								System.out.println(dformat.format(date));
								String date2=String.valueOf(date);
								
							
								
								Dbcon d5=new Dbcon();
								Connection c5=d5.getConnection();
								
								
								
								Thread.sleep(2000);
								black2.setIcon(Greenline2);
								
								t7.setText("Evidence Aging Collector");
								t7.setVisible(true);
								Thread.sleep(1000);
								t7.setVisible(false);
								Thread.sleep(1000);
								t7.setVisible(true);
								Thread.sleep(1000);
								t7.setVisible(false);
								Thread.sleep(1000);
								t7.setVisible(true);
								
								
								Statement st5=c5.createStatement();
								String s5="insert into Evidence values('"+fname+"','"+ip1+"','"+date2+"')";
								st5.executeUpdate(s5);
								
								
								Statement st2=c2.createStatement();
								String s2="insert into Router values('"+fname+"','"+dest+"')";
								st2.executeUpdate(s2);
								
					
								System.out.println(ct);
								FileOutputStream fos = new FileOutputStream("Router/" + fname);
								fos.write(ct);
								fos.close();
								
							}
						else
						{
							
							Thread.sleep(2000);
							n2.setIcon(m2);
							
							Thread.sleep(2000);
							t2.setText("Scan Completed");
							

							t2.setVisible(true);
							Thread.sleep(1000);
							t2.setVisible(false);
							Thread.sleep(1000);
							t2.setVisible(true);
							Thread.sleep(1000);
							t2.setVisible(false);
							Thread.sleep(1000);
							t2.setText("No Virus found");
							t2.setVisible(true);
							Thread.sleep(1000);
							t2.setVisible(false);
							Thread.sleep(1000);
							t2.setVisible(true);
							Thread.sleep(1000);
							t2.setVisible(false);
							Thread.sleep(1000);
							
							t2.setText("Warm filter");
							t2.setVisible(true);
							
							
							Thread.sleep(2000);
							black3.setIcon(Greenline3);
							
							if(dest.equalsIgnoreCase("DA"))	
							{
								
								t3.setText("Reciever-> A");
								
								t3.setVisible(true);
								Thread.sleep(1000);
								t3.setVisible(false);
								Thread.sleep(1000);
								t3.setVisible(true);
								Thread.sleep(1000);
								t3.setVisible(false);
								Thread.sleep(1000);
								t3.setVisible(true);
								Thread.sleep(1000);
								t3.setVisible(false);
								Thread.sleep(1000);
								t3.setVisible(true);
								
								
								String ct1=new String(ct);
								
								Socket st1=new Socket("localhost",4561);
								
								DataOutputStream dos1=new DataOutputStream(st1.getOutputStream());
								dos1.writeUTF(ct1);
								//dos1.writeUTF(ct);
								dos1.writeUTF(fname);
								
							}
							if(dest.equalsIgnoreCase("DB"))
							{
								t4.setText("Reciever-> B");
								
								t4.setVisible(true);
								Thread.sleep(1000);
								t4.setVisible(false);
								Thread.sleep(1000);
								t4.setVisible(true);
								Thread.sleep(1000);
								t4.setVisible(false);
								Thread.sleep(1000);
								t4.setVisible(true);
								Thread.sleep(1000);
								t4.setVisible(false);
								Thread.sleep(1000);
								t4.setVisible(true);
								
								String ct2=new String(ct);
								
								Socket st2=new Socket("localhost",4562);
								DataOutputStream dos2=new DataOutputStream(st2.getOutputStream());
								dos2.writeUTF(ct2);
								//dos2.writeUTF(ct);
								dos2.writeUTF(fname);
								
							}
							if(dest.equalsIgnoreCase("DC"))
							{
								
								t5.setText("Reciever-> C");
								
								t5.setVisible(true);
								Thread.sleep(1000);
								t5.setVisible(false);
								Thread.sleep(1000);
								t5.setVisible(true);
								Thread.sleep(1000);
								t5.setVisible(false);
								Thread.sleep(1000);
								t5.setVisible(true);
								Thread.sleep(1000);
								t5.setVisible(false);
								Thread.sleep(1000);
								t5.setVisible(true);
								
								String ct3=new String(ct);
								
								Socket st3=new Socket("localhost",4563);
								
								DataOutputStream dos3=new DataOutputStream(st3.getOutputStream());
								dos3.writeUTF(ct3);
								//dos3.writeUTF(ct);
								dos3.writeUTF(fname);
								
							}
							if(dest.equalsIgnoreCase("DD"))
							{
								
								t6.setText("Reciever-> D");
								
								t6.setVisible(true);
								Thread.sleep(1000);
								t6.setVisible(false);
								Thread.sleep(1000);
								t6.setVisible(true);
								Thread.sleep(1000);
								t6.setVisible(false);
								Thread.sleep(1000);
								t6.setVisible(true);
								Thread.sleep(1000);
								t6.setVisible(false);
								Thread.sleep(1000);
								t6.setVisible(true);
								
								String ct4=new String(ct);
								
								Socket st4=new Socket("localhost",4564);
								
								DataOutputStream dos4=new DataOutputStream(st4.getOutputStream());
								dos4.writeUTF(ct4);
								//dos4.writeUTF(ct);
								dos4.writeUTF(fname);
								
							}
							
							Statement st2=c2.createStatement();
							String s2="insert into Router values('"+fname+"','"+dest+"')";
							st2.executeUpdate(s2);
							
				
							System.out.println(ct);
							FileOutputStream fos = new FileOutputStream("Router/" + fname);
							fos.write(ct);
							fos.close();
							
							
							JOptionPane.showMessageDialog(null,"File Uploaded Successfully");
							
							
							

						
						System.out.println(ct);
						}
							
							black1.setIcon(Blackline1);
							
							black2.setIcon(Blackline2);
							
							black3.setIcon(Blackline3);
					}
					
					
					
				}catch(Exception es){System.out.println(es);}
			}
		}
	}
	
}
