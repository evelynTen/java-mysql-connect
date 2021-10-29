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

public class LookSC extends JFrame{

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet res = null;
	
	
	JTable jtable;
	JScrollPane jscrollpane = new JScrollPane();
	
	Vector columnNames = null;
	Vector rowData = null;
	
	public LookSC() {
		JPanel jpforbutton = new JPanel(new GridLayout(1,1));
 
		columnNames = new Vector();
		columnNames.add("SNO");
		columnNames.add("SNAME");
		columnNames.add("CNO");
		columnNames.add("CNAME");
		columnNames.add("GRADE");
		rowData = new Vector();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javamysql?serverTimezone=UTC&characterEncoding=utf-8","root","liu102016@Liu");
			ps = conn.prepareStatement("SELECT S.SNO,SNAME,C.CNO,CNAME,GRADE FROM S,C,SC\r\n" + 
					"WHERE S.SNO = SC.SNO AND C.CNO = SC.CNO ORDER BY S.SNO;");
			res = ps.executeQuery();
			while (res.next())
			{
				Vector hang = new Vector();
				hang.add(res.getString(1));
				hang.add(res.getString(2));
				hang.add(res.getString(3));
				hang.add(res.getString(4));
				hang.add(res.getString(5));
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
		this.setTitle("显示学生选课信息及成绩");
		this.setLayout(new GridLayout(2,5));
		this.add(jpforbutton);
		this.setLocation(300,300);
		this.setSize(500,300);
		this.setVisible(true);
		this.setResizable(false);
		
	}

	
}
