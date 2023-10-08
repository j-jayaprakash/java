package com.jp.hibernate_mapping.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Ip_info")
public class IpAddress implements Serializable {

	@Id
	@GenericGenerator(name = "reg_auto", strategy = "increment")
	@GeneratedValue(generator = "reg_auto")
	private int id;
	private String version;
	private String dnsName;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDnsName() {
		return dnsName;
	}

	public void setDnsName(String dnsName) {
		this.dnsName = dnsName;
	}

}
