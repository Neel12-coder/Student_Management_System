import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class UpdateFrame extends JFrame
{
Container c;
JLabel lblName,lblRno,lblCgpi;
JTextField txtName,txtRno,txtCgpi;
JButton btnSave,btnBack;

UpdateFrame()
{
c = getContentPane();
c.setLayout(new FlowLayout());
lblName = new JLabel("Name ");
lblRno = new JLabel("Roll-No ");
lblCgpi = new JLabel("CGPI ");
txtName = new JTextField(10);
txtRno = new JTextField(10);
txtCgpi = new JTextField(10);
btnSave = new JButton("Update");
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
setTitle("Update Student");
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
JOptionPane.showMessageDialog(new JDialog(),"CGPI is not proper, it should be between 1 and 10");
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
int rollno = Integer.parseInt(txtRno.getText());
String name = txtName.getText();
float cgpi = Float.parseFloat(txtCgpi.getText());
if( cgpi <0 || cgpi>10)
{
throw new CgpiNotProperException();
}
new DbHandler().updateStudent(rollno , name, cgpi);
txtName.setText("");
txtRno.setText("");
txtCgpi.setText("");
}
catch (Exception e)
{
JOptionPane.showMessageDialog(new JDialog(),"Please Enter details in Proper Format!!!");
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
UpdateFrame a = new UpdateFrame();
}
}