package com.tibo.dev.main;

import javax.mail.*;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: tibo
 * Date: 05/06/11
 * Time: 17:42
 * To change this template use File | Settings | File Templates.
 */
public class POP3Manager {
    private Session openSession(){
        Properties props = new Properties();
        props.put("mail.host", "POP3.HOSTNAME");
        props.put("mail.store.protocole", "pop3");
        final String username = "";
        final String password = "";
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);    //To change body of overridden methods use File | Settings | File Templates.
            }
        };
        Session session = Session.getInstance(props, auth);
        return session;
    }

    public Message[] getMessages(String folderName) throws Exception {
        Session session = openSession();
        Store store = session.getStore("pop3");
        store.connect();
        Message[] messages  = null;
        if (store.isConnected()){
            Folder folder = store.getFolder(folderName);
            folder.open(Folder.READ_ONLY);
            messages = folder.getMessages();
        }
        return messages;
    }
}
