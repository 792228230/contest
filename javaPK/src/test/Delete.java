package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import dao.StuinfoDAO;
import model.Stuinfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class Delete extends JFrame{

	private JPanel contentPane;
	private JTextField NAME;
	private String name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete frame = new Delete();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Delete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 384, 241);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u8981\u5220\u9664\u7684\u7528\u6237\u59D3\u540D");
		label.setBounds(46, 104, 139, 23);
		panel.add(label);
		
		NAME = new JTextField();
		NAME.setBounds(195, 105, 66, 21);
		panel.add(NAME);
		NAME.setColumns(10);
		
		JButton button = new JButton("\u786E\u8BA4");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				name=NAME.getText();

				StuinfoDAO stuinfoDAO=new StuinfoDAO();
				try
				{	
				List name1  = stuinfoDAO.findByStuname(name);
				Stuinfo stu1=(Stuinfo)name1.get(0);
				if(stu1!=null)
				{
					JOptionPane.showMessageDialog(null, "删除成功", "系统信息",
					JOptionPane.INFORMATION_MESSAGE);
				}
				stuinfoDAO.delete(stu1);
				} catch(Exception e1){					
					JOptionPane.showMessageDialog(null, "删除失败请,确认该用户名是否存在！", "系统信息",
					JOptionPane.WARNING_MESSAGE);
				throw e1;}
			}
		});
		button.setBounds(253, 208, 93, 23);
		panel.add(button);
	}


}
