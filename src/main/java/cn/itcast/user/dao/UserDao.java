package cn.itcast.user.dao;

import cn.itcast.user.domain.User;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;

public class UserDao {
    private String path = "F:/project/User/src/main/resources/users.xml";
    public User findByUsername(String username) {
        SAXReader reader = new SAXReader();
//        URL url = UserDao.class.getClassLoader().getResource("users.xml");
        try {
            Document doc = reader.read(path);
            Element element = (Element)doc.selectSingleNode("//user[@username='" + username + "']");
            if (element == null){
                return null;
            }
            User user = new User();
            String usernameValue = element.attributeValue("username");
            String passwordValue = element.attributeValue("password");
            user.setUsername(usernameValue);
            user.setPassword(passwordValue);
            return user;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void add(User user){
        SAXReader reader = new SAXReader();
//        URL url = UserDao.class.getClassLoader().getResource("users.xml");
        try {
            Document doc = reader.read(path);
            Element root = doc.getRootElement();
            Element userEle = root.addElement("user");
            userEle.addAttribute("username", user.getUsername());
            userEle.addAttribute("password", user.getPassword());
            OutputFormat format = new OutputFormat("\t",true);
            format.setTrimText(true);
            XMLWriter writer = null;
            try {
                writer= new XMLWriter(
                        new OutputStreamWriter(
                                new FileOutputStream(path),"UTF-8"),format);
                writer.write(doc);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                if (writer != null){
                    try {
                        writer.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }
}
