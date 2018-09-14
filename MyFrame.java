
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MyFrame extends JFrame {

	Connection conn = null;
	PreparedStatement state = null;

	JTable table = new JTable();
	JScrollPane scroller = new JScrollPane(table);

	JTable table1 = new JTable();
	JScrollPane scroller1 = new JScrollPane(table1);

	JTable table2 = new JTable();
	JScrollPane scroller2 = new JScrollPane(table2);

	JTable tableQuerry = new JTable();
	JScrollPane scrollerS = new JScrollPane(tableQuerry);

	JTable tableQuerry2 = new JTable();
	JScrollPane scrollerS1 = new JScrollPane(tableQuerry2);

	JComboBox comboBox = new JComboBox();
	JComboBox comboBox1 = new JComboBox();

	JTabbedPane tab = new JTabbedPane();
	JPanel games = new JPanel();
	JPanel creator = new JPanel();
	JPanel type = new JPanel();
	JPanel querry = new JPanel();
	JPanel querry2 = new JPanel();

	JPanel upPanel = new JPanel();
	JPanel midPanel = new JPanel();
	JPanel downPanel = new JPanel();

	JPanel creatorUpPanel = new JPanel();
	JPanel creatorMidPanel = new JPanel();
	JPanel creatorDownPanel = new JPanel();

	JPanel typeUpPanel = new JPanel();
	JPanel typeMidPanel = new JPanel();
	JPanel typeDownPanel = new JPanel();

	JPanel querryUpPanel = new JPanel();
	JPanel querryMidPanel = new JPanel();
	JPanel querryDownPanel = new JPanel();

	JPanel querry2UpPanel = new JPanel();
	JPanel querry2MidPanel = new JPanel();
	JPanel querry2DownPanel = new JPanel();

	JLabel titleLabel = new JLabel("Title");
	JLabel typeLabel = new JLabel("Type_ID");
	JLabel yearLabel = new JLabel("Release Year");
	JLabel creatorLabel = new JLabel("Creator_ID");

	JTextField titleTField = new JTextField();
	JTextField typeTField = new JTextField();
	JTextField yearTField = new JTextField();
	JTextField creatorTField = new JTextField();

	JButton add = new JButton("Add");
	JButton edit = new JButton("Edit");
	JButton delete = new JButton("Delete");

	JLabel fNameLabel = new JLabel("First Name");
	JLabel lNameLabel = new JLabel("Last Name");
	JLabel nationalityLabel = new JLabel("Nationality");
	JLabel ageLabel = new JLabel("Age");
	JLabel netWorthLabel = new JLabel("Net Worth (mln.)");

	JTextField fNameTField = new JTextField();
	JTextField lNameTField = new JTextField();
	JTextField nationalityTField = new JTextField();
	JTextField ageTField = new JTextField();
	JTextField netWorthTField = new JTextField();

	JButton add1 = new JButton("Add");
	JButton edit1 = new JButton("Edit");
	JButton delete1 = new JButton("Delete");

	JLabel nameLabel = new JLabel("Name");

	JTextField nameTField = new JTextField();

	JButton add2 = new JButton("Add");
	JButton edit2 = new JButton("Edit");
	JButton delete2 = new JButton("Delete");

	JLabel age = new JLabel("Enter age");
	JTextField ageTF = new JTextField();
	JButton sort = new JButton("Show");

	JLabel yearOfGameLabel = new JLabel("Year of game");
	JTextField yearT = new JTextField();
	JLabel typeILabel = new JLabel("Type");
	JTextField typeT = new JTextField();
	JButton sort2 = new JButton("Show");

	public MyFrame() {

		this.setVisible(true);
		this.setSize(700, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.add(tab);
		tab.add("Games", games);

		tab.add("Creator", creator);
		tab.add("Game Type", type);
		
		tab.add("Querry 1", querry);
		tab.add("Querry 2", querry2);
		
		getComboBox();
		getComboBoxActors();
		
		tab.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				
				JTabbedPane pan = (JTabbedPane) arg0.getSource();
				int index = pan.getSelectedIndex();
				
				switch(index){
				case 0: 
					getComboBox();
					getComboBoxActors();
					
				}
			}
		});

		games.setLayout(new GridLayout(3, 1));
		games.add(upPanel);
		games.add(midPanel);
		games.add(downPanel);

		upPanel.setLayout(new GridLayout(4, 2));
		upPanel.add(typeLabel);
		upPanel.add(comboBox);
		upPanel.add(creatorLabel);
		upPanel.add(comboBox1);
		upPanel.add(titleLabel);
		upPanel.add(titleTField);
		upPanel.add(yearLabel);
		upPanel.add(yearTField);

		midPanel.add(add);
		add.addActionListener(new AddAction());
		midPanel.add(edit);
		edit.addActionListener(new EditActionMovies());
		midPanel.add(delete);
		delete.addActionListener(new DeleteActionMovies());

		downPanel.add(scroller);
		scroller.setPreferredSize(new Dimension(450, 140));
		table.setModel(DBUtil.getAllModel());

		creator.setLayout(new GridLayout(3, 1));
		creator.add(creatorUpPanel);
		creator.add(creatorMidPanel);
		creator.add(creatorDownPanel);

		creatorUpPanel.setLayout(new GridLayout(5, 2));
		creatorUpPanel.add(fNameLabel);
		creatorUpPanel.add(fNameTField);
		creatorUpPanel.add(lNameLabel);
		creatorUpPanel.add(lNameTField);
		creatorUpPanel.add(nationalityLabel);
		creatorUpPanel.add(nationalityTField);
		creatorUpPanel.add(ageLabel);
		creatorUpPanel.add(ageTField);
		creatorUpPanel.add(netWorthLabel);
		creatorUpPanel.add(netWorthTField);

		creatorMidPanel.add(add1);
		add1.addActionListener(new AddActionActors());
		creatorMidPanel.add(edit1);
		edit1.addActionListener(new EditActionActors());
		creatorMidPanel.add(delete1);
		delete1.addActionListener(new DeleteActionActors());

		creatorDownPanel.add(scroller1);
		scroller1.setPreferredSize(new Dimension(450, 140));
		table1.setModel(DBUtil.getAllCreator());

		type.setLayout(new GridLayout(3, 1));
		type.add(typeUpPanel);
		type.add(typeMidPanel);
		type.add(typeDownPanel);

		typeUpPanel.setLayout(new GridLayout(1, 2));

		typeUpPanel.add(nameLabel);
		typeUpPanel.add(nameTField);

		typeMidPanel.add(add2);
		add2.addActionListener(new AddActionGenre());
		typeMidPanel.add(edit2);
		edit2.addActionListener(new EditActionGenre());
		typeMidPanel.add(delete2);
		delete2.addActionListener(new DeleteActionGenre());

		typeDownPanel.add(scroller2);
		scroller2.setPreferredSize(new Dimension(450, 140));
		table2.setModel(DBUtil.getAllType());

		querry.setLayout(new GridLayout(3, 1));
		querry.add(querryUpPanel);
		querry.add(querryMidPanel);
		querry.add(querryDownPanel);

		querryUpPanel.setLayout(new GridLayout(1, 1));
		querryUpPanel.add(age);
		querryUpPanel.add(ageTF);

		querryMidPanel.add(sort);
		sort.addActionListener(new Sort1Action());

		querryDownPanel.add(scrollerS);
		scrollerS.setPreferredSize(new Dimension(450, 140));
		tableQuerry.setModel(DBUtil.getAllCreator());

		querry2.setLayout(new GridLayout(3, 1));
		querry2.add(querry2UpPanel);
		querry2.add(querry2MidPanel);
		querry2.add(querry2DownPanel);

		querry2UpPanel.setLayout(new GridLayout(2, 1));
		querry2UpPanel.add(yearOfGameLabel);
		querry2UpPanel.add(yearT);
		querry2UpPanel.add(typeILabel);
		querry2UpPanel.add(typeT);

		querry2MidPanel.add(sort2);
		sort2.addActionListener(new Sort2Action());

		querry2DownPanel.add(scrollerS1);
		scrollerS1.setPreferredSize(new Dimension(450, 140));

		this.setVisible(true);

	}

	public void resetComplexSort() {
		yearT.setText("");
		typeT.setText("");
	}

	public void resetSimpleSort() {
		ageTF.setText("");
	}

	public void resetGames() {
		titleTField.setText("");
		typeTField.setText("");
		yearTField.setText("");
		creatorTField.setText("");
	}

	public void resetType() {
		nameTField.setText("");
	}

	public void resetCreator() {
		fNameTField.setText("");
		lNameTField.setText("");
		nationalityTField.setText("");
		ageTField.setText("");
		netWorthTField.setText("");
	}

	
  private void getComboBox(){
	  conn = DBUtil.getConnected();
	    try {
	        String sql = "SELECT * FROM TYPE";
	        PreparedStatement state = conn.prepareStatement(sql);
	        ResultSet result = null;
	        result = state.executeQuery();
	        
	        comboBox.removeAllItems();
	        while (result.next()) {
	        	int id = result.getInt(1);
	            String name = result.getString(2);
	            String item = "ID: " + id + " " + name;
	            comboBox.addItem(item);
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
  }
  
  private void getComboBoxActors(){
	  conn = DBUtil.getConnected();
	    try {
	        String sql = "SELECT * FROM Creator";
	        PreparedStatement state = conn.prepareStatement(sql);
	        ResultSet result = null;
	        result = state.executeQuery();
	        
	        comboBox1.removeAllItems();
	        while (result.next()) {
	        	int creatorId = result.getInt(1);
	            String name = result.getString(2);
	            String item = "ID " + creatorId + " " + name;
	            comboBox1.addItem(item);
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
  }

	class Sort2Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int year = 0;
			String type = typeT.getText();

			try {

				year = Integer.parseInt(yearT.getText());

			} catch (NumberFormatException ex) {

				yearT.setText("Enter only numbers,please!");

			}
			Connection conn = null;
			conn = DBUtil.getConnected();

			String sql = "SELECT TITLE,YEAR, NAME FROM TYPE T JOIN GAMEZ G ON T.TYPE_ID = G.TYPE_ID WHERE YEAR="
					+ year + "AND NAME='" + type + "';";
			try {
				PreparedStatement state = conn.prepareStatement(sql);
				// state.setInt(1, year);
				// state.setString(2, type);
				state.executeQuery();
				tableQuerry2.setModel(DBUtil.getComplexSorting(year, type));
				resetComplexSort();

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

	class Sort1Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int age = 0;

			try {

				age = Integer.parseInt(ageTF.getText());

			} catch (NumberFormatException ex) {

				ageTF.setText("Enter only numbers!");

			}

			Connection conn = null;
			conn = DBUtil.getConnected();

			String sql = "select * from creator where age=?";
			ResultSet result = null;
			MyModel model = null;

			try {
				PreparedStatement state = conn.prepareStatement(sql);
				state.setInt(1, age);
				result = state.executeQuery();
				model = new MyModel(result);
				tableQuerry.setModel(model);
				resetSimpleSort();

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

	class AddAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String title = titleTField.getText();
			
			String genre = (String) comboBox.getSelectedItem();
			String[] typeArray = genre.split(" ");
			int typeId = Integer.parseInt(typeArray[1]);
			
			int year = 0;
			
			String creator = (String) comboBox1.getSelectedItem();
			String[] creatorArray = creator.split(" ");
			int creatorId = Integer.parseInt(creatorArray[1]);
			try {
				year = Integer.parseInt(yearTField.getText());

			} catch (NumberFormatException ex) {
				yearTField.setText("Enter only numbers!");
			}

			conn = DBUtil.getConnected();
			if (conn == null) {
				return;
			}
			String sql = "insert into gamez values (null,?,?,?,?);";

			try {
				state = conn.prepareStatement(sql);

				state.setInt(1, typeId);

				state.setInt(2, creatorId);
				state.setString(3, title);
				state.setInt(4, year);
				state.execute();
				table.setModel(DBUtil.getAllModel());
				resetGames();

			} catch (SQLException e1) {

				e1.printStackTrace();
			}
		}

	}

	class AddActionActors implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String fname = fNameTField.getText();
			String lname = lNameTField.getText();
			String nationality = nationalityTField.getText();
			int age = 0;
			float netWorth = 0.0f;

			try {

				age = Integer.parseInt(ageTField.getText());
				netWorth = Float.parseFloat(netWorthTField.getText());

			} catch (NumberFormatException ex) {

				ageTField.setText("Enter only numbers,please!");

			}

			conn = DBUtil.getConnected();
			if (conn == null) {
				return;
			}
			String sql = "insert into creator values (null,?,?,?,?,?);";

			try {
				state = conn.prepareStatement(sql);

				state.setString(1, fname);
				state.setString(2, lname);
				state.setString(3, nationality);
				state.setInt(4, age);
				state.setFloat(5, netWorth);
				state.execute();
				table1.setModel(DBUtil.getAllCreator());
				resetCreator();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
		}

	}

	class AddActionGenre implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String name = nameTField.getText();

			conn = DBUtil.getConnected();
			if (conn == null) {
				return;
			}
			String sql = "insert into type values (null,?);";

			try {
				state = conn.prepareStatement(sql);

				state.setString(1, name);

				state.execute();
				table2.setModel(DBUtil.getAllType());
				resetType();

			} catch (SQLException e1) {

				e1.printStackTrace();
			}

		}
	}

	class EditActionGenre implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String name = nameTField.getText();

			conn = DBUtil.getConnected();
			if (conn == null) {
				return;
			}

			String sql = "update type set name='" + name + "'" + "WHERE TYPE_ID ="
					+ table2.getValueAt(table2.getSelectedRow(), 0) + ";";

			try {
				state = conn.prepareStatement(sql);

				state.execute();
				table2.setModel(DBUtil.getAllType());
				resetType();

			} catch (SQLException e1) {

				e1.printStackTrace();
			}
		}

	}

	class EditActionMovies implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String type = typeTField.getText();
			String creator = creatorTField.getText();
			String title = titleTField.getText();
			int year = 0;

			try {
				year = Integer.parseInt(yearTField.getText());

			} catch (NumberFormatException ex) {
				yearTField.setText("Enter only numbers!");
			}

			conn = DBUtil.getConnected();
			if (conn == null) {
				return;
			}

			String sql = "update gamez set type_id='" + type + "',creator_id='" + creator + "',title='" + title
					+ "',year=" + year + "WHERE game_id=" + table.getValueAt(table.getSelectedRow(), 0) + ";";

			try {
				state = conn.prepareStatement(sql);

				state.execute();
				table.setModel(DBUtil.getAllModel());
				resetGames();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
		}
	}

	class EditActionActors implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String fname = fNameTField.getText();
			String lname = lNameTField.getText();
			String nationality = nationalityTField.getText();
			int age = 0;
			float netWorth = 0.0f;

			try {

				age = Integer.parseInt(ageTField.getText());
				netWorth = Float.parseFloat(netWorthTField.getText());

			} catch (NumberFormatException ex) {
				ageTField.setText("Enter only numbers,please!");
				netWorthTField.setText("Enter only numbers,please!");
			}

			conn = DBUtil.getConnected();
			if (conn == null) {
				return;
			}

			String sql = "update creator set fname='" + fname + "',lname='" + lname + "',nationality='" + nationality
					+ "',age='" + age + "',net_worth=" + netWorth + "WHERE creator_id ="
					+ table1.getValueAt(table1.getSelectedRow(), 0) + ";";

			try {
				state = conn.prepareStatement(sql);

				state.execute();
				table1.setModel(DBUtil.getAllCreator());
				resetCreator();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}

		}
	}

	class DeleteActionMovies implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String name = (table.getValueAt(table.getSelectedRow(), 0)).toString();
			String sql = "DELETE FROM GAMEZ " + "WHERE game_id='" + name + "';";

			conn = DBUtil.getConnected();
			if (conn == null) {
				return;
			}

			try {
				state = conn.prepareStatement(sql);

				state.execute();
				table.setModel(DBUtil.getAllModel());

			} catch (SQLException e1) {

				e1.printStackTrace();
			}
		}

	}

	class DeleteActionActors implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String name = (table1.getValueAt(table1.getSelectedRow(), 0)).toString();
			String sql = "DELETE FROM creator " + "WHERE creator_id='" + name + "';";

			conn = DBUtil.getConnected();
			if (conn == null) {
				return;
			}

			try {
				state = conn.prepareStatement(sql);

				state.execute();
				table1.setModel(DBUtil.getAllCreator());

			} catch (SQLException e1) {

				e1.printStackTrace();
			}
		}

	}

	class DeleteActionGenre implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String nameid = (table2.getValueAt(table2.getSelectedRow(), 0)).toString();

			String sql = "DELETE FROM type WHERE type_id= " + nameid + ";";

			conn = DBUtil.getConnected();
			if (conn == null) {
				return;
			}

			try {
				state = conn.prepareStatement(sql);

				state.execute();
				table2.setModel(DBUtil.getAllType());

			} catch (SQLException e1) {

				e1.printStackTrace();
			}
		}
	}

}
