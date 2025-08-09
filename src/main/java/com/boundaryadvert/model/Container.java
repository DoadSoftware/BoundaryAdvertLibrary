package com.boundaryadvert.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "Container")
public class Container
{
  @Id
  @Column(name = "ContainerId")
  private long containerId;

  @Column(name = "Description")
  private String description;

  @Column(name = "ContainerName")
  private String name;
  
  @Column(name = "DataType")
  private String dataType;

  @Column(name = "DataPath")
  private String dataPath;
  
  @Column(name = "Width")
  private int width;
  
  @Column(name = "Height")
  private int height;

public long getContainerId() {
	return containerId;
}

public void setContainerId(long containerId) {
	this.containerId = containerId;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getDataType() {
	return dataType;
}

public void setDataType(String dataType) {
	this.dataType = dataType;
}

public String getDataPath() {
	return dataPath;
}

public void setDataPath(String dataPath) {
	this.dataPath = dataPath;
}

public int getWidth() {
	return width;
}

public void setWidth(int width) {
	this.width = width;
}

public int getHeight() {
	return height;
}

public void setHeight(int height) {
	this.height = height;
}

@Override
public String toString() {
	return "Container [containerId=" + containerId + ", description=" + description + ", name=" + name + ", dataType="
			+ dataType + ", dataPath=" + dataPath + ", width=" + width + ", height=" + height + "]";
}

}