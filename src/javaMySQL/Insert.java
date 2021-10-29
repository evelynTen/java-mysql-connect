package javaMySQL;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Insert extends JFrame{

	JLabel jlnumber = new JLabel("SNO：");
	JLabel jlname = new JLabel("SNAME：");
	JLabel jlsex = new JLabel("SEX：");
	JLabel jlage = new JLabel("AGE：");
	
	JTextField jtnumber = new JTextField("",20);
	JTextField jtname = new JTextField("",20);
	JTextField jtsex = new JTextField("",20);
	JTextField jtage = new JTextField("",20);
	
	JButton buttoninsert = new JButton("添加");
	JButton buttonreturn = new JButton("返回");
	
	public Insert()
	{
		JPanel jpnumber = new JPanel();
		JPanel jpname = new JPanel();
		JPanel jpsex = new JPanel();
		JPanel jpage = new JPanel();
		
		JPanel jpforbutton = new JPanel(new GridLayout(1,1));
		
		jpnumber.add(jlnumber);
		jpnumber.add(jtnumber);
		
		jpname.add(jlname);
		jpname.add(jtname);
		
		jpsex.add(jlsex);
		jpsex.add(jtsex);
		
		jpage.add(jlage);
		jpage.add(jtage);

		jpforbutton.add(buttoninsert);
		jpforbutton.add(buttonreturn);

		buttoninsert.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				Connection conn = null; 
				Statement stat = null;
				PreparedStatement ps=null;
				String sql = "INSERT INTO S(SNO,SNAME,SEX,AGE) "
						+ "values(?,?,?,?)";
				try{
					Class.forName("com.mysql.cj.jdbc.Driver");
				}catch(Exception a){
					System.out.println("jdbc fall");
					a.printStackTrace();
				}
				try{
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/javamysql?serverTimezone=UTC&characterEncoding=utf-8","root","liu102016@Liu");
					ps=conn.prepareStatement(sql);
					
					ps.setString(1,jtnumber.getText());
					ps.setString(2,jtname.getText());
					ps.setString(3,jtsex.getText());
					ps.setString(4,jtage.getText());
					
 
					ps.executeUpdate();
					
					
				}catch (SQLException b){
					b.printStackTrace();
				}
				
				finally{
					try{
						conn.close();	
						System.out.println("添加成功!");
					}catch (SQLException c){
						c.printStackTrace();
					}
					
				}
					
					
		}}

			
		
				);
		
		buttonreturn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				View v = new View();			
			}			
		});

		this.setTitle("添加学生信息");
		this.setLayout(new GridLayout(9,1));
		this.add(jpnumber);
		this.add(jpname);
		this.add(jpsex);
		this.add(jpage);
		this.add(jpforbutton);
		this.setLocation(400,300);
		this.setSize(350,300);
		this.setVisible(true);
		
		
	}
	
	
}
