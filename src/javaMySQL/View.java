package javaMySQL;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame jf = new JFrame("学生信息及选课管理系统");
		jf.setSize(1000, 500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLayout(null);
		
		String[] str = {"查询学生信息","添加学生信息","删除学生信息","修改学生信息","显示所有学生信息",
						"显示所有课程","显示学生选课信息及成绩"};
		JButton[] button = new JButton[str.length];
		
		//第一行button
		JPanel jp1 = new JPanel();
		jp1.setLayout(new GridLayout(1, 7, 10, 5));
		jp1.setBounds(75, 100, 850, 100);
		
		int i;
		for(i = 0;i < str.length-2;i++)
		{
			button[i] = new JButton(str[i]);
			button[i].setFont(new Font("宋体", Font.PLAIN, 16));
			jp1.add(button[i]);
		}
		
		//第二行button
		JPanel jp2 = new JPanel();
		jp2.setLayout(new GridLayout(1, 2, 10, 5));
		jp2.setBounds(100, 250, 800, 100);
		
		for(i = str.length-2;i < str.length;i++)
		{
			button[i] = new JButton(str[i]);
			button[i].setFont(new Font("宋体", Font.PLAIN, 18));
			jp2.add(button[i]);
		}
		
		jf.add(jp1);
		jf.add(jp2);
		jf.setVisible(true);
		
		button[0].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Select select = new Select();	
			}			
		});
		
		button[1].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Insert insert = new Insert();	
			}			
		});
		
		button[2].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Delete delete = new Delete();	
			}			
		});
		
		button[3].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Update update = new Update();	
			}			
		});
		
		button[4].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Look look = new Look();	
			}			
		});
		
		button[5].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LookC lookc = new LookC();	
			}			
		});
		
		button[6].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LookSC looksc = new LookSC();	
			}			
		});
		
		
	}

}
