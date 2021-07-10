import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Main extends JFrame
{
Container c;
JButton btnLogIn ;
JLabel hl;
Main()
{
c=getContentPane();
c.setLayout(new FlowLayout());
JButton btnLogIn = new JButton("LogIn");
c.add(btnLogIn);
ActionListener a1=(ae)->{
Login l = new Login();
this.dispose();
};
btnLogIn.addActionListener(a1);
this.addWindowListener(new L());
//hl.addMouseListener(new MouseAdapter());
setSize(350,150);
setTitle("S.M.S");
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
class L implements WindowListener
{
public void windowActivated(WindowEvent we){}
public void windowDeactivated(WindowEvent we){}
public void windowOpened(WindowEvent we)
{
JOptionPane.showMessageDialog(c,"Welcome To Student ManageMent System");
}
public void windowClosed(WindowEvent we){}
public void windowIconified(WindowEvent we){}
public void windowDeiconified(WindowEvent we){}
public void windowClosing(WindowEvent we)
{
int output=JOptionPane.showConfirmDialog(c," Do you want to exit");
if( output == JOptionPane.YES_OPTION)
{
System.exit(1);
}
}
}


public static void main(String args[])
{
Main m = new Main();
}
}