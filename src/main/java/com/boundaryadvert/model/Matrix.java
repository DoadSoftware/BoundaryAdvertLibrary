package com.boundaryadvert.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "Matrix")
public class Matrix
{
  @Id
  @Column(name = "MatrixId")
  private long matrixId;

  @Column(name = "Description")
  private String description;

  @ManyToOne(optional = true) // Set to true if nulls are allowed
  @JoinColumn(name = "ContainerOne")
  private Container containerOne;

  @ManyToOne(optional = true) // Set to true if nulls are allowed
  @JoinColumn(name = "ContainerTwo")
  private Container containerTwo;

  @ManyToOne(optional = true) // Set to true if nulls are allowed
  @JoinColumn(name = "ContainerThree")
  private Container containerThree;

public long getMatrixId() {
	return matrixId;
}

public void setMatrixId(long matrixId) {
	this.matrixId = matrixId;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public Container getContainerOne() {
	return containerOne;
}

public void setContainerOne(Container containerOne) {
	this.containerOne = containerOne;
}

public Container getContainerTwo() {
	return containerTwo;
}

public void setContainerTwo(Container containerTwo) {
	this.containerTwo = containerTwo;
}

public Container getContainerThree() {
	return containerThree;
}

public void setContainerThree(Container containerThree) {
	this.containerThree = containerThree;
}

@Override
public String toString() {
	return "Matrix [matrixId=" + matrixId + ", description=" + description + ", containerOne=" + containerOne
			+ ", containerTwo=" + containerTwo + ", containerThree=" + containerThree + "]";
}
  
}