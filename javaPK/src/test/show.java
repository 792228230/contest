package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.SwingConstants;

import dao.StuinfoDAO;
import model.Stuinfo;

import java.awt.Font;

public class show extends JFrame  implements ActionListener{

	private JPanel contentPane;
	private JTextField stusex;
	private JTextField stuclass;
	private JTextField Id;
	private JTextField stuschool;
	private JTable table;

	private String contest1 = "数学竞赛";
	private String contest2 = "英语独白";
	private String contest3 = "语文精析";
	private String contest4 = "物理探究";
	private String contest5 = "化学反应";
	private JTextField stuname;
	private JTextField stutel;
	JButton deletebutton;
	private String name;
	private int ID;
	private String temp;
	private String school;
	private String grade;
	private String tel;
	private String sex;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					show frame = new show();
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
	public show() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(53, 45, 579, 315);
		contentPane.add(panel);
		panel.setLayout(null);

		stusex = new JTextField();
		stusex.setBounds(80, 117, 66, 21);
		panel.add(stusex);
		stusex.setColumns(10);

		stuclass = new JTextField();
		stuclass.setBounds(80, 148, 66, 21);
		panel.add(stuclass);
		stuclass.setColumns(10);

		Id = new JTextField();
		Id.setBounds(80, 179, 66, 21);
		panel.add(Id);
		Id.setColumns(10);

		stuschool = new JTextField();
		stuschool.setBounds(80, 221, 66, 21);
		panel.add(stuschool);
		stuschool.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(171, 97, 326, 108);
		panel.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] { 
				{ 1, contest1 },
				{ 2, contest2 }, 
				{ 3, contest3 },
				{ 4, contest4 },
				{ 5, contest5 }, }, new String[] { "竞赛编号", "竞赛项目" }));
		scrollPane.setViewportView(table);

		JButton confirmbutton = new JButton("\u786E\u8BA4");

		confirmbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				name = stuname.getText();
				sex = stusex.getText();
				school = stuschool.getText();
				temp = Id.getText();
				ID = Integer.parseInt(temp);
				grade = stuclass.getText();
				tel = stutel.getText();
				Stuinfo stuinfo=new Stuinfo();
				stuinfo.setClass_(grade);
				stuinfo.setId(ID);
				stuinfo.setSex(sex);
				stuinfo.setSchool(school);
				stuinfo.setTel(tel);
				stuinfo.setStuname(name);
				StuinfoDAO stuinfoDAO=new StuinfoDAO();
				stuinfoDAO.save(stuinfo);
				
				
			}
		});
		confirmbutton.addActionListener(this);
		confirmbutton.setBounds(476, 282, 93, 23);
		panel.add(confirmbutton);

		JLabel label = new JLabel("\u5B66\u751F\u59D3\u540D:");
		label.setBounds(27, 89, 54, 15);
		panel.add(label);

		JLabel lblNewLabel = new JLabel("    \u6027\u522B:");
		lblNewLabel.setBounds(27, 120, 54, 15);
		panel.add(lblNewLabel);

		JLabel label_1 = new JLabel("\u7ADE\u8D5B\u7F16\u53F7:");
		label_1.setBounds(16, 182, 66, 18);
		panel.add(label_1);

		JLabel label_2 = new JLabel("\u5B66\u6821\u540D\u79F0:");
		label_2.setBounds(16, 224, 65, 18);
		panel.add(label_2);

		stuname = new JTextField();
		stuname.setColumns(10);
		stuname.setBounds(80, 86, 66, 21);
		panel.add(stuname);

		stutel = new JTextField();
		stutel.setColumns(10);
		stutel.setBounds(80, 265, 66, 21);
		panel.add(stutel);

		JLabel lblNewLabel_1 = new JLabel("    \u5E74\u7EA7:");
		lblNewLabel_1.setBounds(27, 151, 54, 15);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("    \u7535\u8BDD:");
		lblNewLabel_2.setBounds(27, 268, 54, 15);
		panel.add(lblNewLabel_2);

		deletebutton = new JButton("\u5220\u9664\u4FE1\u606F");
		deletebutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.getSource() == deletebutton) {
					Delete a = new Delete();
					a.setVisible(true);
					
				
			}
			}
		});

		deletebutton.setBounds(336, 282, 93, 23);
		panel.add(deletebutton);

		JLabel lblNewLabel_3 = new JLabel(
				"\u6B22\u8FCE\u4F7F\u7528\u7ADE\u8D5B\u62A5\u540D\u7CFB\u7EDF");
		lblNewLabel_3.setFont(new Font("华文彩云", Font.PLAIN, 30));
		lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(137, 10, 309, 42);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel(
				"\u8BF7\u586B\u5165\u4F60\u7684\u4E2A\u4EBA\u4FE1\u606F");
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setFont(new Font("黑体", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(27, 47, 119, 32);
		panel.add(lblNewLabel_4);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(name!=""&&sex!=""&&school!=""&&temp!=""&&tel!=""&&grade!="")
		{
		JOptionPane.showMessageDialog(null, "传入成功", "系统信息",
				JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "传入失败", "系统信息",
					JOptionPane.WARNING_MESSAGE);
		}
	}




}
