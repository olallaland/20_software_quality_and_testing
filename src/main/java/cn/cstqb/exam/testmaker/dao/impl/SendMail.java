package cn.cstqb.exam.testmaker.dao.impl;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.util.ArrayList;

public class SendMail {
    public void send(String email,String url,String password) throws AddressException, MessagingException
 {
        SimpleMailSender sms = new SimpleMailSender(email,password);
        String recipients = email;
        sms.send(recipients, "尊敬的用户"+url+ "。如果不是您本人操作，请忽略此消息。","");
        }



//         public static void main(String[] args) throws AddressException, MessagingException{
////         SimpleMailSender sms = new SimpleMailSender("1874442361@qq.com","18265704565");
//         ArrayList recipients = new ArrayList();
//         SendMail sendMail = new SendMail();
////             sendMail.send("1874442361@qq.com","","18265704565");
//         sendMail.send("yu1874442361@163.com","homeSeller/resetPassword.jsp+?uid=\" + userName + \"&validkey=\" + signature","BDBTJNDSTETFEXEZ");
////         recipients.add("2867870421@qq.com");
////
////         for(String recipient:recipients){
////             sms.send(recipient, "test测试,hello hrwhisper.");
////             }
//         }
}
