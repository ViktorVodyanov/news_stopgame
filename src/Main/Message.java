package Main;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Message {
    public static void main(String[] args) {
        final String username = "login";
        final String password = "password";
        final Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(properties);

        try (Transport tr = session.getTransport()) {

            javax.mail.Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("sanding address"));
            message.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse("receiving address"));
            message.setSubject("Тема письма");
            message.setText("Тело письма");

            tr.connect(username, password);
            tr.sendMessage(message, message.getAllRecipients());

            System.out.println("Done");

        } catch (Exception e) {
            System.err.println("Не удалось отправить сообщение " + e);
        }
    }
}

