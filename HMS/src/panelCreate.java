import java.awt.*;
import java.util.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;


public class panelCreate implements ActionListener 
{
	ImageIcon a;
	Panel p1,p2,pmain;
	CardLayout card;
	JButton b1,b2;
	Register rg;
	SingIn si;
	Connection con;
	Statement stmt;
	
	panelCreate(Rectangle r)
	{
		card=new CardLayout();
		pmain=new Panel();
		//pmain.setSize(300,300);
		pmain.setLayout(card);
		p1=new Panel();
		p1.setBackground(Color.cyan);
		p1.setLayout(null);
		//p1.setSize(300, 300);
		//p2=new Panel();
		//p2.setBackground(Color.gray);
		//p2.setSize(300, 300);
		rg=new Register();
		si=new SingIn();
		
		 b1=new JButton("Sign In");
		 b2=new JButton("Register");
		//JButton b3=new JButton("Button3");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		rg.cancel.addActionListener(this);
		si.Bcancel.addActionListener(this);
		rg.submit.addActionListener(this);
		//b3.addActionListener(this);
		
		
		//p1.add(a);
		a=  new ImageIcon("/home/nilesh/workspace/HMS/images/ctmwelcome_e0.gif");
		JLabel L1=new JLabel(a);
		L1.setBounds((r.width/2)-(a.getIconWidth()/2), (r.height/2)-a.getIconHeight(), a.getIconWidth(), a.getIconHeight());
		b1.setBounds((r.width/2)-200, (r.height/2)+a.getIconHeight()+10,150, 40);
		b2.setBounds((r.width/2), (r.height/2)+a.getIconHeight()+10,150, 40);
		
		
		p1.add(b1);
		p1.add(L1);
		p1.add(b2);
		//p2.add(b3);
		//pmain.add("welcome",a);
		
		pmain.add("p1",p1);
		pmain.add("rg",rg);
		pmain.add("si",si);
		//pmain.add("p2",p2);
		
		connectdb();
		
		
}
	private void connectdb()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS","root","#justchill");
			stmt=con.createStatement();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
	}
private void Registeruser()
	{
		
			String fnm=rg.firstnm.getText();
			String mnm=rg.middelnm.getText();
			String lnm=rg.lastnm.getText();
			String unm=rg.tusernm.getText();
			String passwd=rg.tpasswd.getText();
			String email=rg.temail.getText();
			String nine1=rg.nine1.getText();
			String mo=rg.tmobile.getText();
			String gen=rg.buttonGroup2.getSelection().getActionCommand();
			try
			{
			
			ResultSet rs=stmt.executeQuery("insert into users(fname,mname,lname,username,passwd,email_id,contact,gender) values(fnm,mnm,lnm,unm,passwd,email,nine1+mo,gen)");
			/*while(rs.next())
			{
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)); 
			
			}*/
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
			
			
		
		
	
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == b1)
		{
			card.show(pmain, "si");
		}
		if(ae.getSource() == b2)
		{
			card.show(pmain, "rg");
		}
		if(ae.getSource() == rg.cancel)
		{
			card.show(pmain, "p1");
		}
		if(ae.getSource() == si.Bcancel)
		{
			card.show(pmain, "p1");
		}
		if(ae.getSource() == rg.submit)
		{
			Registeruser();
			
		}
		
			
			
	}
	
}



