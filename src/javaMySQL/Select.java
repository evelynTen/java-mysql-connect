package javaMySQL;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Select extends JFrame{
	
	JLabel jlnumber = new JLabel("SNO：");
	JLabel jlname = new JLabel("SNAME：");
	JLabel jlsex = new JLabel("SEX：");
	JLabel jlage = new JLabel("AGE：");
	
	JTextField jtnumber = new JTextField("",20);
	JLabel jname = new JLabel();
	JLabel jsex = new JLabel();
	JLabel jage = new JLabel();
	
	JButton buttonselect = new JButton("查询");
	JButton buttonreturn = new JButton("返回");

	public Select()
	{
		JPanel jpnumber = new JPanel();
		JPanel jpname = new JPanel();
		JPanel jpsex = new JPanel();
		JPanel jpage = new JPanel();
		
		JPanel jpforbutton = new JPanel(new GridLayout(1,1));
		
		jpnumber.add(jlnumber);
		jpnumber.add(jtnumber);
		
		jpname.add(jlname);
		jpname.add(jname);
		
		jpsex.add(jlsex);
		jpsex.add(jsex);
		
		jpage.add(jlage);
		jpage.add(jage);
		
		jpforbutton.add(buttonselect);
		jpforbutton.add(buttonreturn);

		buttonselect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Connection conn = null;
				ResultSet res = null;
				Statement stat = null;

				String sql = "SELECT SNO,SNAME,SEX,AGE FROM S;";
				try{
					Class.forName("com.mysql.cj.jdbc.Driver");
					
				}catch(Exception d){
					System.out.println("jdbc fall");
					d.printStackTrace();
				}
				try{
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/javamysql?serverTimezone=UTC&characterEncoding=utf-8","root","liu102016@Liu");
					stat=conn.createStatement();
					res=stat.executeQuery(sql);
					while (res.next())
					{
						if (res.getString(1).equals(jtnumber.getText()))
						{
							jname.setText(res.getString(2));
							jsex.setText(res.getString(3));
							jage.setText(res.getString(4));
 
							break;
						}
					}
				}
				catch (SQLException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				
				finally{
						try{
							conn.close();
						}catch(SQLException ar){
							ar.printStackTrace();
						}

				
			}}}
		);
		
		buttonreturn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				View v = new View();			
			}			
		});


		this.setTitle("查询学生信息");
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
