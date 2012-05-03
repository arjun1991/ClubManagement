import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MemberManagement extends JPanel{
	
	JLabel details;
	JPanel center,smo,addrm,modify;
	JLabel FirstLabel,LastLabel,yearLabel,joinLabel,positionLabel,filterLabel;
	JTextField FirstText,LastText,yearText,joinText,positionText,filterText;
	JButton backButton,displaylist,backButton2,backButton3,addrmButton,filterButton,commitButton;
	
	JTable table;
	JScrollPane tablepane;
	
	GridBagConstraints constraints;
	
	private static final MemberManagement singleton=new MemberManagement();
	public static MemberManagement getSingleton(){
		return singleton;
		
	}
	
	MemberManagement(){
		
		setLayout(new BorderLayout());
		constraints=new GridBagConstraints();
		
		
		
		backButton=new JButton("Back to mainpage");
		add(backButton,BorderLayout.NORTH);
		backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				MainFrame.getSingleton().lay.show(MainFrame.getSingleton().mainPanel,"mainPage");
			}
		});
		
		
		int i=0;
		Object [][] display=new Object[10][10];
		String[] colHeads={"ID","FirstName","LastName","JoinDate","Position","Address"}; 
		ResultSet testResult;
		Konnection test= Konnection.getSingleton();
		String testQuery="Select * from members;";
		testResult=test.query(testQuery);
		try{
			
			while(testResult.next()){
		
				display[i][0]=testResult.getString("ID");
				display[i][1]=testResult.getString("FirstName");
				display[i][2]=testResult.getString("LastName");
				display[i][3]=testResult.getString("JoinDate");
				display[i][4]=testResult.getString("Position");
				display[i][5]=testResult.getString("Address");
				
				System.out.println(display[i][0]+" "+display[i][1]+" "+display[i][2]+" "+display[i][3]+" ");
				i++;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		table=new JTable(display,colHeads);
		tablepane=new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		smo=new JPanel();
		
		smo.setLayout(new BorderLayout());
		smo.add(tablepane,BorderLayout.NORTH);
		
		JPanel smo_below=new JPanel();
		
		smo_below.add(filterButton=new JButton("Filter Name: "));
		smo_below.add(filterText=new JTextField(20));
		
		smo.add(smo_below,BorderLayout.CENTER);
		
		MainFrame.getSingleton().mainPanel.add(smo,"tablepane");
		
		smo.add(backButton2=new JButton("Back"),BorderLayout.SOUTH);
		
		center=new JPanel();
		center.setLayout(new GridLayout(0,3));
		
		center.add(displaylist=new JButton("display the member list"));
		center.add(addrmButton=new JButton("Add a Member"));
		center.add(filterButton=new JButton("Modify/Remove a Member"));
	    add(center,BorderLayout.CENTER);
		
		addrm=new JPanel();
		addrm.setLayout(new BorderLayout());
		JPanel addrm_above=new JPanel();
		
		addrm_above.setLayout(new GridBagLayout());
		constraints.gridx=0;
		constraints.gridy=0;
		addrm_above.add(FirstLabel=new JLabel("First Name:"),constraints);
		constraints.gridx=1;
		constraints.gridy=0;
		addrm_above.add(FirstText=new JTextField(20),constraints);
		constraints.gridx=0;
		constraints.gridy=1;
	    addrm_above.add(LastLabel=new JLabel("Last Name:"),constraints);
	    constraints.gridx=1;
		constraints.gridy=1;
	    addrm_above.add(LastText=new JTextField(20),constraints);
	    constraints.gridx=0;
		constraints.gridy=2;
	    addrm_above.add(yearLabel=new JLabel("Year:"),constraints);
	    constraints.gridx=1;
		constraints.gridy=2;
	    addrm_above.add(yearText=new JTextField(20),constraints);
	    constraints.gridx=0;
		constraints.gridy=3;
	    addrm_above.add(joinLabel=new JLabel("Join date:"),constraints);
	    constraints.gridx=1;
		constraints.gridy=3;
	    addrm_above.add(joinText=new JTextField(20),constraints);
	    constraints.gridx=0;
		constraints.gridy=4;
	    addrm_above.add(positionLabel=new JLabel("Position:"),constraints);
	    constraints.gridx=1;
		constraints.gridy=4;
	    addrm_above.add(positionText=new JTextField(20),constraints);
	    constraints.gridx=0;
	    constraints.gridy=5;
	    
	    constraints.gridheight=2;
	    constraints.gridwidth=2;
	    addrm_above.add(commitButton=new JButton("commit to database"),constraints);
	    addrm.add(backButton3=new JButton("Back"),BorderLayout.SOUTH);
	    addrm.add(addrm_above,BorderLayout.CENTER);
	    
	    
	    MainFrame.getSingleton().mainPanel.add(addrm,"add");
	    
	    
	    commitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
								MainFrame.getSingleton().lay.show(MainFrame.getSingleton().mainPanel,"tablepane");
			}
		});
			
	    displaylist.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				MainFrame.getSingleton().lay.show(MainFrame.getSingleton().mainPanel,"tablepane");
			}
		});
			
		backButton2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				MainFrame.getSingleton().lay.show(MainFrame.getSingleton().mainPanel,"mainPage");
			}
			
		});

		backButton3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				MainFrame.getSingleton().lay.show(MainFrame.getSingleton().mainPanel,"mainPage");
			}
			
		});
		
		addrmButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				MainFrame.getSingleton().lay.show(MainFrame.getSingleton().mainPanel,"add");
			}
			
		});
		
		filterButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				MainFrame.getSingleton().lay.show(MainFrame.getSingleton().mainPanel,"mainPage");
			}
			
		});
		
	
	}
}