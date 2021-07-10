import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ViewFrame extends JFrame
{
Container c;
JButton btnBack;
TextArea taData;

ViewFrame()
{
c = getContentPane();
c.setLayout(new FlowLayout());
taData = new TextArea();
btnBack = new JButton("Back");
c.add(taData);
c.add(btnBack);
String data = new DbHandler().viewStudent();
taData.setText(data);

ActionListener e =(ae)->
{
CURD c = new CURD();
this.dispose();
};
btnBack.addActionListener(e);

setSize(500,300);
setTitle("View Student Details");
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}