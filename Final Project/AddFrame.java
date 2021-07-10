import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AddFrame extends JFrame
{
Container c;
JLabel lblName,lblRno,lblCgpi;
JTextField txtName,txtRno,txtCgpi;
JButton btnSave,btnBack;

AddFrame()
{
c = getContentPane();
c.setLayout(new FlowLayout());
lblName = new JLabel("Name ");
lblRno = new JLabel("Roll-No ");
lblCgpi = new JLabel("CGPI ");
txtName = new JTextField(10);
txtRno = new JTextField(10);
txtCgpi = new JTextField(10);
btnSave = new JButton("Save");
btnBack = new JButton("Back");
c.add(lblName);
c.add(txtName);
c.add(lblRno);
c.add(txtRno);
c.add(lblCgpi);
c.add(txtCgpi);
c.add(btnSave);
c.add(btnBack);
setSize(200,250);
setTitle("Add Student");
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

btnSave.addActionListener(new L1());
btnBack.addActionListener(new L1());
}
class CgpiNotProperException extends Exception
{
public CgpiNotProperException()
{
JOptionPane.showMessageDialog(new JDialog(),"CGPI is not proper");
txtName.setText("");
txtRno.setText("");
txtCgpi.setText("");
}
}
class L1 implements ActionListener
{
public void actionPerformed(ActionEvent ae)
{

if(ae.getSource()==btnSave)
{
try{

int sno = Integer.parseInt(txtRno.getText());
String sname =txtName.getText();
float scgpi = Float.parseFloat(txtCgpi.getText());
if( scgpi <0 || scgpi>10)
{
throw new CgpiNotProperException();
}
new DbHandler().addStudent(sno ,sname , scgpi);
txtName.setText("");
txtRno.setText("");
txtCgpi.setText("");
new Sound().playSound();
}
catch(Exception e)
{
JOptionPane.showMessageDialog(new JDialog()," Please Enter proper details");
txtName.setText("");
txtRno.setText("");
txtCgpi.setText("");
}
}

if(ae.getSource()==btnBack)
{
CURD c = new CURD();
dispose();
}

}
}

public static void main(String args[])
{
AddFrame a = new AddFrame();
}
}