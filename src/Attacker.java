import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.DigestInputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ProgressMonitor;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;

public class Attacker extends JFrame implements ActionListener {
	String mac;
	File path;
	int len;
	Cipher encoder = null;
	Key prKey;
	public static Key pubKey;
	public Font f = new Font("Times new roman", Font.BOLD, 16);
	public Font f1 = new Font("Times new roman", Font.BOLD, 28);
	public Font f2 = new Font("Times new roman", Font.BOLD, 18);
	public Font f3 = new Font("Engravers MT", Font.BOLD, 15);

	public JLabel l1 = new JLabel("File Name     :");
	
	String Selected="No";
	

	//public JTextArea tf = new JTextArea();
	public JButton add = new JButton("Upload File");
	public JButton browse = new JButton("Browse File");

	//public JTextArea tf1 = new JTextArea();

	//public JScrollPane pane1 = new JScrollPane();

	//public JTextArea tf2 = new JTextArea();

	public JScrollPane pane2 = new JScrollPane();
	public JTextField txt1 = new JTextField();
	public JTextField txt2 = new JTextField();
	public JTextField txt3 = new JTextField();


	public JFrame jf;
	public Container c;

	JPanel jp = new JPanel();
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	JPanel jp3 = new JPanel();
	JPanel jp6 = new JPanel();
	JPanel jp7 = new JPanel();

	JLabel image1,l2;
	ImageIcon im1;

	Attacker() {

		jf = new JFrame("Neighborhood Watch --->Behavioral Malware Detection in Delay Tolerant Networks");
		c = jf.getContentPane();
		c.setLayout(null);
		jf.setSize(600, 700);
		c.setBackground(new Color( 	156,102,31));
		txt1.setBounds(270, 150, 170, 30);
		txt2.setBounds(270, 200, 170, 30);
		txt3.setBounds(270, 250, 170, 30);
		txt1.setFont(f);
		txt1.setForeground(new Color(10, 79, 6));
		l1.setBounds(100, 150, 150, 35);
		l2=new JLabel();
		l2.setText("");
		l2.setBounds(100, 500, 200,30);
		l2.setFont(f);
		c.add(l2);
		
		//tf=new JTextArea();
		//pane1=new JScrollPane();
		//pane1.setViewportView(tf);
		//tf.setRows(50);
	//	tf.setColumns(50);
	//	pane1.setBounds(250, 350, 200,200);
	//	c.add(pane1);
		
		browse.setBounds(150, 200, 130, 30);
		browse.setFont(f2);
		l1.setForeground(Color.RED);
	
		l1.setFont(f2);
		add.setBounds(300, 200, 130, 30);
		add.setFont(f2);
		

		
		jp.setBounds(40, 60, 480, 575);
		jp.setBackground(new Color(212, 250, 218));
		jp1.setBackground(Color.DARK_GRAY);
		jp1.setBounds(35, 55, 970, 600);

		jp2.setBounds(86, 90, 390, 220);
		jp2.setBackground(new Color(212, 250, 218));
		jp3.setBounds(85, 89, 392, 222);
		jp3.setBackground(Color.BLACK);

		jp6.setBounds(86, 330, 390, 250);
		jp6.setBackground(new Color(212, 250, 218));
		
		
		im1=new ImageIcon(this.getClass().getResource(""));
		image1=new JLabel();
		image1.setIcon(im1);
		image1.setBounds(120, 220, 400,400);
		c.add(image1);

		add.addActionListener(this);
		

		jf.setVisible(true);

		c.add(txt1);
		

		c.add(browse);
		
		c.add(add);
		c.add(l1);

		c.add(jp2);
		c.add(jp3);
		c.add(jp6);
		c.add(jp7);
		c.add(jp);

		java.util.Date td = new java.util.Date();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dt = sdf.format(td).toString();

		txt3.setText(dt);

		browse.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {

		String content="empty";
		if (e.getSource() == add) {

			
			Dbcon db=new Dbcon();
			Connection c1=db.getConnection();
			
			
			String fname = txt1.getText();
			//content=tf.getText();
			
			String dest=JOptionPane.showInputDialog(null,"Enter the Destination Name");

			try {
				
				InetAddress ia = InetAddress.getLocalHost();
				String ip1 = ia.getHostAddress();
				
				if(Selected.equalsIgnoreCase("yes"))
				{
					FileInputStream fis = new FileInputStream(path);
					System.out.println(path);
					byte b[] = new byte[fis.available()];
					

					FileOutputStream fos = new FileOutputStream("Owner/" + fname);
					fos.write(b);
					fos.close();
					
					
					fis.read(b);

					
					String data=new String(b);
					

					Statement st=c1.createStatement();
					String s1="insert into Sender values('"+fname+"','"+dest+"')";
					st.executeUpdate(s1);
					
					String ip=JOptionPane.showInputDialog(null,"Enter the Ip address of Router");
					
					Socket socket1 = new Socket(ip, 12345);
				/*	DataOutputStream dos1=new DataOutputStream(socket1.getOutputStream());
					
					dos1.writeUTF(fname);
					dos1.writeUTF(dest);
					dos1.writeUTF(data);
					dos1.writeUTF(ip1);
					
					*/
					
					ObjectOutputStream oos = new ObjectOutputStream(socket1
							.getOutputStream());

					oos.writeObject(fname);
					oos.writeObject(dest);
					oos.writeObject(b);
					oos.writeObject(ip1);
					
					JOptionPane.showMessageDialog(null,
							"File Uploaded Successfully ");

					txt1.setText("");
					txt2.setText("");
					txt3.setText("");
				}
				
				else
					
				{
					FileOutputStream fos = new FileOutputStream("Owner/" + fname);
					fos.write(content.getBytes());
					fos.close();
					
					
					FileInputStream fis = new FileInputStream("Owner/" + fname);
					byte b[] = new byte[fis.available()];
					fis.read(b);
					
					String data=new String(b);
					MessageDigest md = MessageDigest.getInstance("SHA1");
					FileInputStream in1 = new FileInputStream("Owner\\" + fname);
					DigestInputStream dis2 = new DigestInputStream(in1, md);
					BufferedInputStream bd = new BufferedInputStream(dis2);

					while (true) {
						int b2 = bd.read();
						if (b2 == -1)
							break;
					}

					BigInteger bi2 = new BigInteger(md.digest());
					mac = bi2.toString(16);
					System.out.println("mac address" + mac);


					Statement st=c1.createStatement();
					String s1="insert into Sender values('"+fname+"','"+dest+"')";
					st.executeUpdate(s1);


					Socket socket1 = new Socket("localhost", 12345);

					 /*DataOutputStream dos1=new DataOutputStream(socket1.getOutputStream());
					
					dos1.writeUTF(fname);
					dos1.writeUTF(dest);
					dos1.writeUTF(data);
					dos1.writeUTF(ip1);
					*/
					ObjectOutputStream oos = new ObjectOutputStream(socket1
							.getOutputStream());

					oos.writeObject(fname);
					oos.writeObject(dest);
					oos.writeObject(b);
					oos.writeObject(ip1);
					

					JOptionPane.showMessageDialog(null,
							"File Uploaded Successfully ");

					txt1.setText("");
					txt2.setText("");
					txt3.setText("");
					
					
				}
				

			} catch (Exception e1) {

				e1.printStackTrace();
			}
		}
		

		if (e.getSource() == browse) {

			JFileChooser chooser = new JFileChooser("Database");

			chooser.setMultiSelectionEnabled(true);

			chooser.setFileFilter(new FileFilter() {

				public boolean accept(File f) {

					return f.getName().toLowerCase().endsWith(".avi")
							|| f.getName().toLowerCase().endsWith(".mpg")
							|| f.getName().toLowerCase().endsWith(".doc")
							|| f.getName().toLowerCase().endsWith(".jpeg")
							|| f.getName().toLowerCase().endsWith(".png")
							|| f.getName().toLowerCase().endsWith(".gif")
							|| f.getName().toLowerCase().endsWith(".ade")
							|| f.getName().toLowerCase().endsWith(".adp")
							|| f.getName().toLowerCase().endsWith(".bas")
							|| f.getName().toLowerCase().endsWith(".bat")
							|| f.getName().toLowerCase().endsWith(".chm")
							|| f.getName().toLowerCase().endsWith(".cmd")
							|| f.getName().toLowerCase().endsWith(".com")
							|| f.getName().toLowerCase().endsWith(".crt")
							|| f.getName().toLowerCase().endsWith(".dll")
							|| f.getName().toLowerCase().endsWith(".do*")
							|| f.getName().toLowerCase().endsWith(".hlp")
							|| f.getName().toLowerCase().endsWith(".hta")
							|| f.getName().toLowerCase().endsWith(".inf")
							|| f.getName().toLowerCase().endsWith(".ins")
							
							|| f.getName().toLowerCase().endsWith(".js")
							|| f.getName().toLowerCase().endsWith(".jse")
							|| f.getName().toLowerCase().endsWith(".lnk")
							|| f.getName().toLowerCase().endsWith(".md*")
							|| f.getName().toLowerCase().endsWith(".msc")
							|| f.getName().toLowerCase().endsWith(".msi")
							|| f.getName().toLowerCase().endsWith(".mst")
							|| f.getName().toLowerCase().endsWith(".ocx")
							|| f.getName().toLowerCase().endsWith(".pcd")
							|| f.getName().toLowerCase().endsWith(".pif")
							|| f.getName().toLowerCase().endsWith(".pot")
							|| f.getName().toLowerCase().endsWith(".reg")
							|| f.getName().toLowerCase().endsWith(".scr")
							|| f.getName().toLowerCase().endsWith(".sct")
							|| f.getName().toLowerCase().endsWith(".shb")
							|| f.getName().toLowerCase().endsWith(".shs")
							|| f.getName().toLowerCase().endsWith(".sys")
							|| f.getName().toLowerCase().endsWith(".url")
							
							
							
							|| f.isDirectory();

				}

				public String getDescription() {
					return "Files";
				}
			});

			int check = chooser.showOpenDialog(browse);

			try {
				if (check == JFileChooser.APPROVE_OPTION) {

					path = chooser.getSelectedFile();
					txt1.setText(path.getName());

				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

	
	}
	
	public static void main(String[] args) 
	{
		new Attacker();
	}
}
