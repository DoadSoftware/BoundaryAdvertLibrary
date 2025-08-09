package com.boundaryadvert.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Configurations")
@XmlAccessorType(XmlAccessType.FIELD)
public class Configurations {
	
	@XmlElement(name="filename")
	private String filename;
	
	@XmlElement(name="broadcaster")
	private String broadcaster;
	
	@XmlElement(name="ipAddress")
	private String ipAddress;
	
	@XmlElement(name="portNumber")
	private String portNumber;
	
	@XmlElement(name="vizscene")
	private String vizscene;

	public Configurations(String filename, String broadcaster, String ipAddress, 
		String portNumber, String vizscene) {
		super();
		this.filename = filename;
		this.broadcaster = broadcaster;
		this.ipAddress = ipAddress;
		this.portNumber = portNumber;
		this.vizscene = vizscene;
	}
	
	public Configurations() {
		super();
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getBroadcaster() {
		return broadcaster;
	}

	public void setBroadcaster(String broadcaster) {
		this.broadcaster = broadcaster;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getPortNumber() {
		return portNumber;
	}

	public void setPortNumber(String portNumber) {
		this.portNumber = portNumber;
	}

	public String getVizscene() {
		return vizscene;
	}

	public void setVizscene(String vizscene) {
		this.vizscene = vizscene;
	}

	@Override
	public String toString() {
		return "Configurations [filename=" + filename + ", broadcaster=" + broadcaster + ", ipAddress=" + ipAddress
				+ ", portNumber=" + portNumber + ", vizscene=" + vizscene + "]";
	}

}
