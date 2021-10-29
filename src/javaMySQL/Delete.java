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

public class Delete extends JFrame{

	JLabel jlnumber = new JLabel("SNO：");
	JTextField jtnumber = new JTextField("",20);
	
	JButton buttondelete = new JButton("删除");
	JButton buttonreturn = new JButton("返回");

	public Delete() {
		JPanel jpnumber = new JPanel();
		JPanel jpforbutton = new JPanel(new GridLayout(1,1));
		
		jpnumber.add(jlnumber);
		jpnumber.add(jtnumber);
		
		jpforbutton.add(buttondelete);
		jpforbutton.add(buttonreturn);
		
		buttondelete.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				String number = jtnumber.getText();
				
				Connection conn = null;
				ResultSet res = null;
				Statement stat = null;
				String sql = "DELETE FROM S WHERE SNO='"+number+"'";
				
				try{
					Class.forName("com.mysql.cj.jdbc.Driver");
				}catch(Exception a){
					a.printStackTrace();
				}
				try{
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/javamysql?serverTimezone=UTC&characterEncoding=utf-8","root","liu102016@Liu");
					stat = conn.createStatement();
					stat.executeUpdate(sql);
				}catch(SQLException h){
					h.printStackTrace();
					
				}finally{
					try{
						conn.close();
						System.out.println("删除成功!");
					}catch(SQLException j){
					    j.printStackTrace();
					}
					
				}
				
			}
			
			
		});
		
		buttonreturn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				View v = new View();			
			}			
		});
		
		
		this.setTitle("删除学生信息");
		this.setLayout(new GridLayout(9,1));
		this.add(jpnumber);
		this.add(jpforbutton);
		this.setLocation(400,300);
		this.setSize(350,300);
		this.setVisible(true);
		
		
	}
	
    
    
}


	
	

