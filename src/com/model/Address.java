/**
 * 
 */
package com.model;

/**
 * @author brucewilliamwaynes
 *
 */
/**
 * 
 * Address model , to hold address details for a person and act as a user data structure
 *
 */


public class Address {
private String flatNumber;
private String buildingName;
private String streetNumber;
private String landMarkNearest;
private String city;
private String state;
private String pincode;

public Address(){
	this.flatNumber = "";
	this.buildingName = "";
	this.streetNumber = "";
	this.landMarkNearest = "";
	this.city = "";
	this.state = "";
	this.pincode = "";
}

/**
 * @return the flatNumber
 */
public String getFlatNumber() {
	return this.flatNumber;
}
/**
 * @param flatNumber the flatNumber to set
 */
public void setFlatNumber(String flatNumber) {
	this.flatNumber = flatNumber;
}
/**
 * @return the buildingName
 */
public String getBuildingName() {
	return this.buildingName;
}
/**
 * @param buildingName the buildingName to set
 */
public void setBuildingName(String buildingName) {
	this.buildingName = buildingName;
}
/**
 * @return the streetNumber
 */
public String getStreetNumber() {
	return this.streetNumber;
}
/**
 * @param streetNumber the streetNumber to set
 */
public void setStreetNumber(String streetNumber) {
	this.streetNumber = streetNumber;
}
/**
 * @return the landMarkNearest
 */
public String getLandMarkNearest() {
	return this.landMarkNearest;
}
/**
 * @param landMarkNearest the landMarkNearest to set
 */
public void setLandMarkNearest(String landMarkNearest) {
	this.landMarkNearest = landMarkNearest;
}
/**
 * @return the city
 */
public String getCity() {
	return this.city;
}
/**
 * @param city the city to set
 */
public void setCity(String city) {
	this.city = city;
}
/**
 * @return the state
 */
public String getState() {
	return this.state;
}
/**
 * @param state the state to set
 */
public void setState(String state) {
	this.state = state;
}
/**
 * @return the pincode
 */
public String getPincode() {
	return this.pincode;
}
/**
 * @param pincode the pincode to set
 */
public void setPincode(String pincode) {
	this.pincode = pincode;
}
}
