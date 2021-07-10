import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class CURD extends JFrame
{
Container c;
JButton btnAdd,btnView,btnUpdate,btnDelete;
CURD()
{
c = getContentPane();
c.setLayout(new FlowLayout());
JButton btnAdd = new JButton("Add");
JButton btnView = new JButton("View");
JButton btnUpdate = new JButton("Update");
JButton btnDelete = new JButton("Delete");
c.add(btnAdd);
c.add(btnView);
c.add(btnUpdate);
c.add(btnDelete);

ActionListener a1=(ae)->{
AddFrame a = new AddFrame();
this.dispose();
};
btnAdd.addActionListener(a1);

ActionListener a2=(ae)->{
ViewFrame v = new ViewFrame();
this.dispose();
};
btnView.addActionListener(a2);

ActionListener a3=(ae)->{
UpdateFrame u = new UpdateFrame();
this.dispose();
};
btnUpdate.addActionListener(a3);

ActionListener a4=(ae)->{
DeleteFrame d = new DeleteFrame();
this.dispose();
};
btnDelete.addActionListener(a4); 


setSize(300,100);
setTitle("Student Details");
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
public static void main(String args[])
{
CURD c = new CURD();
}
}