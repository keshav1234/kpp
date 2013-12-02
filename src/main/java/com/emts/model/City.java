package com.emts.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity  
@Table(name="city")
public class City implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id  
	@GeneratedValue(strategy=GenerationType.AUTO)  
	@Column(name="CITY_ID")  
	private Integer cityId; 

	@Column(name="CITY_NAME")  
	private String cityName;

	@Column(name="IS_DELETED")  
	private Integer isDeleted;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="STATE_ID")  
	private State state;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "CITY_ID")
	private List<Tracking> trackingList;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "CITY_ID")
	private List<PrintTracking> printTrackingList;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "CITY_ID")
	private List<AdvertisementTracking> advertisementTrackingList;
	
	/**
	 * @return the cityId
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * @param cityId the cityId to set
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * @return the isDeleted
	 */
	public Integer getIsDeleted() {
		return isDeleted;
	}

	/**
	 * @param isDeleted the isDeleted to set
	 */
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * @return the state
	 */
	public State getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(State state) {
		this.state = state;
	}

	/**
	 * @return the trackingList
	 */
	public List<Tracking> getTrackingList() {
		return trackingList;
	}

	/**
	 * @param trackingList the trackingList to set
	 */
	public void setTrackingList(List<Tracking> trackingList) {
		this.trackingList = trackingList;
	}

	/**
	 * @return the printTrackingList
	 */
	public List<PrintTracking> getPrintTrackingList() {
		return printTrackingList;
	}

	/**
	 * @param printTrackingList the printTrackingList to set
	 */
	public void setPrintTrackingList(List<PrintTracking> printTrackingList) {
		this.printTrackingList = printTrackingList;
	}

	/**
	 * @return the advertisementTrackingList
	 */
	public List<AdvertisementTracking> getAdvertisementTrackingList() {
		return advertisementTrackingList;
	}

	/**
	 * @param advertisementTrackingList the advertisementTrackingList to set
	 */
	public void setAdvertisementTrackingList(
			List<AdvertisementTracking> advertisementTrackingList) {
		this.advertisementTrackingList = advertisementTrackingList;
	}
}
