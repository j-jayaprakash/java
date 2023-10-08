package com.jp.hibernate_mapping;

import com.jp.hibernate_mapping.entity.IpAddress;
import com.jp.hibernate_mapping.entity.SystemC;
import com.jp.hibernate_mapping.entity.SystemDao;
import com.jp.hibernate_mapping.entity.SystemDto;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
    	
    	
    	SystemC system = new SystemC();
    	
    	system.setOperatingSystem("win 11");
    	system.setSid(100);
    	system.setStorageType("ssd");
    	
    	
    	IpAddress ipAddress = new IpAddress();
    	
    	ipAddress.setVersion("ipv4");
    	ipAddress.setDnsName("new Dns");
    	
    	system.setIpAddress(ipAddress);
    	
    	
    	
    	SystemDao dao = new SystemDao();
    	
    	dao.saveSystemDetails(system);
    }
}
