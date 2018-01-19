import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.*;

public class EvidenceCollector extends JFrame implements ActionListener
{
	JPanel p1;
	
	ImageIcon i1,i2,i3,i4;
	JLabel b1,b2,b3,b4;
	JButton view;
	
	JLabel t;
	MenuBar mbr;
	Menu k1;
	MenuItem n1,n2;
	
	public Font f2 = new Font("Times new roman", Font.BOLD, 18);
	
	
	EvidenceCollector()
	{
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBackground(Color.darkGray);
		
		
		mbr=new MenuBar();
		setMenuBar(mbr);
		
		k1=new Menu("File");
		n1=new MenuItem("Exit");
		n2=new MenuItem("View Files");
		k1.add(n2);
		k1.add(n1);
		mbr.add(k1);
		
		n1.addActionListener(this);
		n2.addActionListener(this);
		
		i1=new ImageIcon(this.getClass().getResource("images\\Router1.png"));
		i2=new ImageIcon(this.getClass().getResource("images\\Router2.png"));
		i3=new ImageIcon(this.getClass().getResource("images\\user2.png"));
		i4=new ImageIcon(this.getClass().getResource("images\\Gline1.png"));
		
		
		b1=new JLabel();
		b1.setIcon(i1);
		b1.setBounds(50,50,300,300);
		p1.add(b1);
		
		b2=new JLabel();
		b2.setIcon(i3);
		b2.setBounds(400,40,300,300);
		p1.add(b2);
		
		t=new JLabel("E.A.C :: Behavioral Malware Detection in Delay Tolerant Networks");
		t.setBounds(15,45,600,30);
		t.setForeground(Color.RED);
		t.setFont(f2);
		p1.add(t);
		
		b3=new JLabel();
		b3.setText("Evidence Aging Collector");
		b3.setBounds(350,245,300,30);
		b3.setForeground(Color.white);
		b3.setFont(f2);
		p1.add(b3);
		
		b4=new JLabel();
		b4.setBounds(230,180,300,30);
		p1.add(b4);
	
		add(p1);
		setSize(600,400);
		setVisible(true);
		
		int[] ports = new int[]{9797};
		for(int i=0;i<1;i++)
		{
			Thread th = new Thread(new PortListener(ports[i]));
			th.start();
		}
			
	}
	
	public static void main(String[] args) 
	{
		new EvidenceCollector();
	}
	
	class PortListener implements Runnable {
		
		BufferedOutputStream bos = null;

		ServerSocket server;
		Socket con;
		BufferedReader br = null;
		int port;

		public PortListener(int port) {
			this.port = port;
		}

		@Override
		public void run() 
		{
			
			if(this.port==9797)
			{
				 try
					{
						ServerSocket server3 = new ServerSocket(9797);
		                Socket con2;
						while (true) 
						{
							con2 = server3.accept();
							DataInputStream dis11 = new DataInputStream(con2.getInputStream());
							
							String fname= dis11.readUTF();
							String ip= dis11.readUTF();
							String date2= dis11.readUTF();
							
							
							
							
							Dbcon d5=new Dbcon();
							Connection c5=d5.getConnection();
							
							
							
							String res="Cleaned";
							
							Statement st5=c5.createStatement();
							String s5="insert into Evidence values('"+fname+"','"+ip+"','"+date2+"','"+res+"')";
							st5.executeUpdate(s5);
							
							System.out.println("Evidence Collected");
							
							
							Thread.sleep(2000);
							b1.setIcon(i2);
							
							Thread.sleep(2000);
							b4.setIcon(i4);
							
							b3.setText("Evidence Aging Collector");
							b3.setVisible(true);
							Thread.sleep(1000);
							b3.setVisible(false);
							Thread.sleep(1000);
							b3.setVisible(true);
							Thread.sleep(1000);
							b3.setVisible(false);
							Thread.sleep(1000);
							b3.setVisible(true);
							Thread.sleep(1000);
							b3.setVisible(false);
							Thread.sleep(1000);
							b3.setVisible(true);
							
							
							Thread.sleep(2000);
							b1.setIcon(i1);
							
							Thread.sleep(2000);
							b4.setIcon(i4);
							b4.setBounds(0,0,0,0);
							
							DataOutputStream dos5=new DataOutputStream(con2.getOutputStream());
							
							dos5.writeUTF("Clean");
							
							
							
						}
					}catch(Exception es){System.out.println(es);}
			}
			
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent a5) 
	{
		if(a5.getSource()==n2)
		{
			new ViewEvidence();
		}
	}
	
}
