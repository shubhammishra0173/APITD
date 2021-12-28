package com.w2a.testingframeowrk.rough;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.w2a.utility.MonitoringMail;
import com.w2a.utility.TestConfig;

public class Testmail {
	private static String messageBody="";
	public static void main(String[] args) {
		try {
			messageBody="http://"+InetAddress.getLocalHost().getHostAddress()+":8089/job/APITestingFrameworkforPractice/Extent_20Reports/";
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// TODO Auto-generated method stub
MonitoringMail mail = new MonitoringMail();
try {
	mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
} catch (AddressException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (MessagingException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

}
