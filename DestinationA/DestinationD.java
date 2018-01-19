import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.Statement;

import javax.sound.sampled.AudioFormat.Encoding;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DestinationD implements ActionListener {
	public Font f = new Font("Times new roman", Font.BOLD, 20);

	public JLabel T4 = new JLabel();
	
	public JTextArea tf = new JTextArea();
	public JScrollPane pane = new JScrollPane();
	
	JPanel jp = new JPanel();
	JPanel jp1 = new JPanel();

	public JFrame jf;
	public Container c;
	
	DestinationD() {
		jf = new JFrame("Destination D::Behavioral Malware Detection in Delay Tolerant Networks");
		c = jf.getContentPane();
		c.setLayout(null);
		jf.setSize(500, 650);
		 c.setBackground(new Color(139,134, 130));


		jp.setBounds(40, 126, 400, 400);
		
		//jp1.setBackground(new Color(120,0,0));
		//jp1.setBounds(155, 124, 723, 453);

		
		

		tf.setColumns(20);

		tf.setForeground(Color.MAGENTA);
	    tf.setFont(f);
		tf.setRows(100);
		tf.setColumns(100);
		tf.setName("tf");
		pane.setName("pane");
		pane.setViewportView(tf);
		pane.setBounds(75, 146, 350, 350);


	
		jf.show();

		
		c.add(T4);

		c.add(pane, BorderLayout.CENTER);
		


		c.add(jp);
		c.add(jp1);

		
		
		
		jf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent win) {
				System.exit(0);
			}
		});
		
		
	
		
		int[] ports = new int[]{4564};
		for(int i=0;i<1;i++)
		{
			Thread th = new Thread(new PortListener(ports[i]));
			th.start();
		}
			
		
		
		

	}

	public void actionPerformed(ActionEvent e) {
		
			

	
		
		
	
			
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
			
			if(this.port==4564)
			{
				 try
					{
						ServerSocket server3 = new ServerSocket(4564);
		                Socket con2;
						while (true) 
						{
							con2 = server3.accept();
							DataInputStream dis11 = new DataInputStream(con2.getInputStream());
							
							String ct= dis11.readUTF();
							String fname= dis11.readUTF();
							
							tf.setText(ct);
							
							PrintStream out2 = null;
							try {
							    out2 = new PrintStream(new FileOutputStream("DestinationD\\"+fname));
							    out2.print(ct);
							    
							}
							finally {
							    if (out2 != null) out2.close();
							}
							
							
							
						}
					}catch(Exception es){System.out.println(es);}
			}
			
			
		}
	}

	public static void main(String args[]) {
		new DestinationD();
	}
}
