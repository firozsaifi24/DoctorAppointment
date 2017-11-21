/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import com.sun.mail.smtp.SMTPSaslAuthenticator;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Firoz Saifi
 */
@Stateless
public class MailSender {

    public String somethingWrong="CONNECT";
            
    public void sendEmail(String fromEmail, String username, String password,
                            String toEmail, String subject, String message)
    {
        try {
            Properties props=System.getProperties();
            props.put("mail.smtp.host","smtp.gmail.com");
            props.put("mail.smtp.auth","true");
            props.put("mail.smtp.port","465");
            props.setProperty("mail.smtp.ssl.enable", "true");
            //props.setProperty("mail.smtp.starttls.enable", "true"); //for this, port will be 587. if ssl, then 465.
            //also remove the below socketFactory lines if using tls 
            props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.port","465");
            props.put("mail.smtp.socketFactory.fallback","false");
            
            Session mailSession = Session.getDefaultInstance(props);
            mailSession.setDebug(false);
            
            Message mailMessage= new MimeMessage(mailSession);
            
            mailMessage.setFrom(new InternetAddress(fromEmail));
            mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            mailMessage.setContent(message, "text/html");
            mailMessage.setSubject(subject);
            
            Transport transport= mailSession.getTransport("smtp");
            //transport.connect("smtp.gmail.com", username, password);
            transport.connect("smtp.gmail.com", 465, username, password);
            
            transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
            transport.close();
            
            
        } 
        catch (Exception ex) {
            somethingWrong="NOTCONNECT";
            Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
