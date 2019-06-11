package ro.mxp.booking.commons;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailService {

    public void sendEmail(String message, String mailAddress, String subject) {

        final String userName = "java2Iasi@gmail.com";
        final String password = "JavaIasi2018";

        //Setting up configurations for the email connection to the Google SMTP server using TLS

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }

        });

        try {

            Message message1 = new MimeMessage(session);
            message1.setFrom(new InternetAddress("java2Iasi@gmail.com"));
            message1.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailAddress));
            message1.setSubject(subject);
            message1.setText(message);

            Transport.send(message1);

            System.out.println("Done!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}


