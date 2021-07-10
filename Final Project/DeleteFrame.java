import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DeleteFrame extends JFrame
{
Container c;
JLabel lblRno;
JTextField txtRno;
JButton btnSave,btnBack;

DeleteFrame()
{
c = getContentPane();
c.setLayout(new FlowLayout());
lblRno = new JLabel("Roll-No ");
txtRno = new JTextField(10);
btnSave = new JButton("Save");
btnBack = new JButton("Back");
c.add(lblRno);
c.add(txtRno);
c.add(btnSave);
c.add(btnBack);
setSize(200,150);
setTitle("Delete Student");
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
btnSave.addActionListener(new L1());
btnBack.addActionListener(new L1());
}

class L1 implements ActionListener
{
public void actionPerformed(ActionEvent ae)
{

if(ae.getSource()==btnSave)
{
try
{
int rollno = Integer.parseInt(txtRno.getText());
new DbHandler().deleteStudent(rollno);
txtRno.setText("");
}
catch(Exception e)
{
JOptionPane.showMessageDialog(new JDialog(),"Enter roll-no properly");
txtRno.setText("");
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
DeleteFrame a = new DeleteFrame();
}
}