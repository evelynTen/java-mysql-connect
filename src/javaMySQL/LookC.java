package javaMySQL;

import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class LookC extends JFrame{

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet res = null;
	
	
	JTable jtable;
	JScrollPane jscrollpane = new JScrollPane();
	
	Vector columnNames = null;
	Vector rowData = null;
	
	public LookC() {
		JPanel jpforbutton = new JPanel(new GridLayout(1,1));
 
		columnNames = new Vector();
		columnNames.add("CNO");
		columnNames.add("CNAME");
		rowData = new Vector();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javamysql?serverTimezone=UTC&characterEncoding=utf-8","root","liu102016@Liu");
			ps = conn.prepareStatement("SELECT * FROM C");
			res = ps.executeQuery();
			while (res.next())
			{
				Vector hang = new Vector();
				hang.add(res.getString(1));
				hang.add(res.getString(2));
				rowData.add(hang);
				
			}
		}catch (Exception q){
			q.printStackTrace();
		}finally{
			try{
				res.close();
				ps.close();
				conn.close();
			}catch (SQLException o){
				o.printStackTrace();
			}
		}
		
		
		
		
		jtable = new JTable(rowData,columnNames);
		jscrollpane = new JScrollPane(jtable);
		
		this.add(jscrollpane);
		this.setTitle("显示所有课程");
		this.setLayout(new GridLayout(2,5));
		this.add(jpforbutton);
		this.setLocation(300,300);
		this.setSize(500,300);
		this.setVisible(true);
		this.setResizable(false);
		
	}

	
}
