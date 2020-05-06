package Common;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Email_Send {

    public void sendEmail(String subject, String reciever, String htmlcontent) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {

                    final String sender_mail = new Email_Data().getdata().email;
                    final String sender_password = new Email_Data().getdata().password;

                    Properties props = new Properties();
                    props.put("mail.smtp.auth", "true");
                    props.put("mail.smtp.starttls.enable", "true");
                    props.put("mail.smtp.host", "smtp.gmail.com");
                    props.put("mail.smtp.port", "587");

                    Session session = Session.getDefaultInstance(props,
                            new Authenticator() {
                                protected PasswordAuthentication getPasswordAuthentication() {
                                    return new PasswordAuthentication(
                                            new Email_Data().getdata().email, new Email_Data().getdata().password);
                                }
                            });
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(sender_mail));
                    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(reciever));

                    message.setSubject(subject);
                    // message.setText(msg_content);
                    message.setContent(htmlcontent, "text/html;charset=utf-8");

                    Transport.send(message);

                } catch (Exception e) {

                    e.printStackTrace();
                }
            }
        }).start();
    }
}
