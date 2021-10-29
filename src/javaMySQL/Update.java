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

public class Update extends JFrame{

	JLabel jlnumber = new JLabel("SNO：");
	JLabel jlname = new JLabel("SNAME：");
	JLabel jlsex = new JLabel("SEX：");
	JLabel jlage = new JLabel("AGE：");
	
	JTextField jtnumber = new JTextField("",20);
	JTextField jtname = new JTextField("",20);
	JTextField jtsex = new JTextField("",20);
	JTextField jtage = new JTextField("",20);
	
	JButton buttonupdate = new JButton("修改");
	JButton buttonreturn = new JButton("返回");
	
	public Update()
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

		jpforbutton.add(buttonupdate);
		jpforbutton.add(buttonreturn);
		
		buttonupdate.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				String number = jtnumber.getText();
				String name = jtname.getText();
				String sex = jtsex.getText();
				String age = jtage.getText();
				
				
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
                        try{
							Class.forName("com.mysql.cj.jdbc.Driver");
						}catch(Exception d){
							System.out.println("jdbc fall");
							d.printStackTrace();
						}
							
							String sql2="UPDATE S SET SNAME='"+name+"'  WHERE SNO='"+jtnumber.getText()+"'";
							String sql3="UPDATE S SET SEX='"+sex+"'  WHERE SNO='"+jtnumber.getText()+"'";
							String sql4="UPDATE S SET AGE='"+age+"'  WHERE SNO='"+jtnumber.getText()+"'";
							
							try {
								conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/javamysql?serverTimezone=UTC&characterEncoding=utf-8","root","liu102016@Liu");
								stat=conn.createStatement();
								stat.executeUpdate(sql2);
								stat.executeUpdate(sql3);
								stat.executeUpdate(sql4);
								
							} catch (SQLException g) {
								// TODO Auto-generated catch block
								g.printStackTrace();
							}try{
								stat.close();
								conn.close();
								System.out.println("修改成功!");
							}catch(SQLException ar){
								ar.printStackTrace();
						}
 
							break;
						}
						
					//change end
					}
				}catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				
				
			}
				finally{
					try{
						conn.close();
					}catch(SQLException ar){
						ar.printStackTrace();
					}
			
				}
				
			}
			
			
		});
		
		
		buttonreturn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				View v = new View();			
			}			
		});
		
		this.setTitle("修改学生信息");
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
