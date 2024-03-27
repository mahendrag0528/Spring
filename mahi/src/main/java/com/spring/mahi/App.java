package com.spring.mahi;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class App 
{
    public static void main( String[] args )
    {
//    	BeanFactory factory=new XmlBeanFactory(new FileSystemResource("spring.xml"));
//       Alien obj=(Alien)factory.getBean("alien");
//       obj.print();
    	ApplicationContext factory=new ClassPathXmlApplicationContext("spring.xml");
       Alien obj1=(Alien)factory.getBean("alien");
       obj1.print();
    }
}
 