package gan.homeworks.ChatLesson1;

import org.w3c.dom.css.RGBColor;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowChat extends JFrame {
    JTextArea txtMessageList;
    JTextField txtMessageSend;


    public WindowChat(){
     setTitle("Мой чат");
     setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
     setBounds(300,300,421,422);

     JPanel mainPanel = new JPanel();
     JButton btnSend = new JButton("Отправить сообщение");
     JLabel lbMessageList = new JLabel("Чат");
     JLabel lbMessageListSend = new JLabel("Отправить сообщение: ");
     txtMessageList = new JTextArea();
     txtMessageSend = new JTextField();

     mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

     mainPanel.setBackground(new Color(17,30,36));
     mainPanel.setBorder(new LineBorder(Color.WHITE,1));

     txtMessageList.setBackground(new Color(9,16,21));
     txtMessageList.setBorder(new LineBorder(new Color(112,132,153),0));
     txtMessageList.setPreferredSize(new Dimension(377,252));
     txtMessageList.setForeground(new Color(200,200,200));
     txtMessageList.setLineWrap(true);
     txtMessageList.setEditable(false);

     txtMessageSend.setBackground(new Color(9,16,21));
     txtMessageSend.setBorder(new LineBorder(new Color(112,132,153),0));
     txtMessageSend.setPreferredSize(new Dimension(377,27));
     txtMessageSend.setForeground(new Color(200,200,200));
     txtMessageSend.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             onSendMessage();
         }
     });

     lbMessageList.setForeground(new Color(200,200,200));
     lbMessageListSend.setForeground(new Color(200,200,200));

     btnSend.setBackground(new Color(41,221,126));
     btnSend.setForeground(new Color(9,16,21));
     btnSend.setFocusPainted(false);
     btnSend.setMargin(new Insets(10,10,10,10));
     btnSend.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             onSendMessage();
         }
     });

     add(mainPanel);
     mainPanel.add(lbMessageList);
     mainPanel.add(txtMessageList);
     mainPanel.add(lbMessageListSend);
     mainPanel.add(txtMessageSend);
     mainPanel.add(btnSend);

     setVisible(true);
    }

    private void onSendMessage(){
        if (txtMessageSend.getText().length() == 0){
            JOptionPane.showMessageDialog(null, "Введите текст сообщения!");
        }else{
            if(txtMessageList.getText().length() == 0){
                txtMessageList.setText(txtMessageSend.getText());
            }else{
                txtMessageList.setText(txtMessageList.getText() + "\n" + txtMessageSend.getText());
            }
        }
        txtMessageSend.setText("");
    }
}
