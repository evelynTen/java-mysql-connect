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

		JFrame jf = new JFrame("ѧ����Ϣ��ѡ�ι���ϵͳ");
		jf.setSize(1000, 500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLayout(null);
		
		String[] str = {"��ѯѧ����Ϣ","���ѧ����Ϣ","ɾ��ѧ����Ϣ","�޸�ѧ����Ϣ","��ʾ����ѧ����Ϣ",
						"��ʾ���пγ�","��ʾѧ��ѡ����Ϣ���ɼ�"};
		JButton[] button = new JButton[str.length];
		
		//��һ��button
		JPanel jp1 = new JPanel();
		jp1.setLayout(new GridLayout(1, 7, 10, 5));
		jp1.setBounds(75, 100, 850, 100);
		
		int i;
		for(i = 0;i < str.length-2;i++)
		{
			button[i] = new JButton(str[i]);
			button[i].setFont(new Font("����", Font.PLAIN, 16));
			jp1.add(button[i]);
		}
		
		//�ڶ���button
		JPanel jp2 = new JPanel();
		jp2.setLayout(new GridLayout(1, 2, 10, 5));
		jp2.setBounds(100, 250, 800, 100);
		
		for(i = str.length-2;i < str.length;i++)
		{
			button[i] = new JButton(str[i]);
			button[i].setFont(new Font("����", Font.PLAIN, 18));
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
