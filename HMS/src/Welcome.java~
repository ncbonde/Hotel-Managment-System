import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Main extends Frame implements ActionListener
{
	
	Rectangle framesize;
	Main(String s)
	{
		super(s);
		addWindowListener(new WindowAdapter(){
			public void windowClosing (WindowEvent windowEvent)
			{
				System.exit(0);
			}});
		//a=  new ImageIcon("/home/nilesh/workspace/HMS/images/ctmwelcome_e0.gif");
		//setSize(a.getIconWidth(), a.getIconHeight());
		setSize(600,500);
		framesize = this.getBounds();
		panelCreate c=new panelCreate(framesize);            // "c" means center panel
		setLayout(new BorderLayout());
		Panel pn=new Panel();
		Panel ps=new Panel();
		Panel pw=new Panel();
		Panel pe=new Panel();
		add(BorderLayout.CENTER,c.pmain);
		add(BorderLayout.NORTH,pn);
		add(BorderLayout.SOUTH,ps);
		add(BorderLayout.EAST,pe);
		add(BorderLayout.WEST,pw);
	}
	public void actionPerformed(ActionEvent ae)
	{
		
	}
	
/*	public void paint(Graphics g) 
	{
        	super.paint(g);
        	g.drawImage(a.getImage(), 100, 100, this);
	}
*/
}
class Welcome
{
	public static void main(String []arg)
	{
		Main m=new Main("Hotel Managment System");
		m.setVisible(true);
		/*Register r=new Register();
		r.setVisible(true);
		m.add(BorderLayout.CENTER,r);*/
	}
}
