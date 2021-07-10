import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
//import sun.audio.*;
import java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;


class Login extends JFrame
{
Container c;
JLabel lblUname,lblPassword;
JTextField txtUname;
JPasswordField txtPassword;
JButton btnSubmit;
Login()
{
c = getContentPane();
c.setLayout(new FlowLayout());
lblUname= new JLabel("Username");
lblPassword = new JLabel("Password");
txtUname = new JTextField(15);
txtPassword = new JPasswordField(15);
txtPassword.setEchoChar('*');
JButton btnSubmit = new JButton("Submit");
c.add(lblUname);
c.add(txtUname);
c.add(lblPassword);
c.add(txtPassword);
c.add(btnSubmit);

ActionListener a1 =(ae)->{
String s1,s2;
s1=txtUname.getText();
s2=txtPassword.getText();
if(s1.equals("Neelam") && s2.equals("123"))
{
CURD c = new CURD();
this.dispose();
}
else
{
JOptionPane.showMessageDialog(c,"Login Unsuccessful ");
txtUname.setText("");
txtPassword.setText("");
this.requestFocus();
}
};
btnSubmit.addActionListener(a1);

setSize(300,200);
setTitle("Student LogIn");
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
public static void main(String args[])
{
Login l = new Login();
}
}

class Sound
{
public void playSound()
 {
   try 
   {
    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("piano2.wav").getAbsoluteFile( ));
    Clip clip = AudioSystem.getClip( );
    clip.open(audioInputStream);
    clip.start( );
   }
   catch(Exception ex)
   {
     System.out.println("Error with playing sound.");
     ex.printStackTrace( );
   }
 }
}


class DbHandler
{
public void addStudent(int sno,String sname,float scgpi)
{
Connection conn=null;
try{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
String sql="insert into student values (? , ?, ?)";
PreparedStatement pstm = conn.prepareStatement(sql);
pstm.setInt(1,sno);
pstm.setString(2,sname);
pstm.setFloat(3,scgpi);
int result=pstm.executeUpdate();
JOptionPane.showMessageDialog(new JDialog()," Record SuccessFully Inserted ");
pstm.close();
}
catch(SQLException e)
{
JOptionPane.showMessageDialog(new JDialog(),"Sorry, something went wrong, Rnoll already exist!! ");
}
finally
{
try{
if ( conn!=null )
conn.close();
}
catch(SQLException e)
{
JOptionPane.showMessageDialog(new JDialog(),"Sorry, something went wrong, please check your connection ");
}
}
}
public String viewStudent()
{
Connection conn=null;
StringBuffer sb = new StringBuffer();
try
{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
Statement stm = conn.createStatement();
String sql = "select * from student";
ResultSet rs = stm.executeQuery(sql);
while(rs.next()){
int sno=rs.getInt(1);
String sname=rs.getString(2);
float scgpi=rs.getFloat(3);
sb.append("Student ~Name: " +sname +" Roll No.: " +sno +" CGPI: "+scgpi+"\n");
}
rs.close();
stm.close();
}
catch(SQLException e)
{
JOptionPane.showMessageDialog(new JDialog(),"Sorry, something went wrong, please check your connection ");
}
finally
{
try{
if ( conn!=null )
conn.close();
}
catch(SQLException e)
{
JOptionPane.showMessageDialog(new JDialog(),"Sorry, something went wrong, please check your connection ");
}
}
return sb.toString();
} 
public void updateStudent(int rollno,String name,float cgpi)
{
Connection conn=null;
try
{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
String sql="Update student set sname=?,scgpi=? where sno=?";
PreparedStatement pst = conn.prepareStatement(sql);
pst.setString(1,name);
pst.setFloat(2,cgpi);
pst.setInt(3,rollno);
int r=pst.executeUpdate();
if(r >0)
JOptionPane.showMessageDialog(new JDialog()," Updated Successfully ");
else
JOptionPane.showMessageDialog(new JDialog(),"Sorry Doesn't exist any such student ");
pst.close();
}
catch(SQLException e)
{
JOptionPane.showMessageDialog(new JDialog()," Roll Number does not exist ");
}
finally
{
try
{
if (conn != null)
conn.close();
}
catch(SQLException e)
{
JOptionPane.showMessageDialog(new JDialog()," Something went wrong ");
}
}
} 
public void deleteStudent(int rollno)
{
Connection conn=null;
try
{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
String sql="Delete from student where sno=?";
PreparedStatement pst = conn.prepareStatement(sql);
pst.setInt(1,rollno);
int ru = pst.executeUpdate();
if (ru >0)
JOptionPane.showMessageDialog(new JDialog()," Deleted successfully ");
else
JOptionPane.showMessageDialog(new JDialog(),"Student doesn't exist ");
pst.close();
}
catch(SQLException e)
{
JOptionPane.showMessageDialog(new JDialog()," Sorry, something is wrong"+ e);
}
finally
{
try
{
if (conn != null)
conn.close();
}
catch(SQLException e)
{
JOptionPane.showMessageDialog(new JDialog(),"Sorry, something went wrong!!");
}
}
}
}