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
@Table(name="state") 
public class State implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id  
	@GeneratedValue(strategy=GenerationType.AUTO)  
	@Column(name="STATE_ID")  
	private Integer stateId; 

	@Column(name="STATE_NAME")  
	private String stateName;

	@Column(name="IS_DELETED")  
	private Integer isDeleted;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="COUNTRY_ID")  
	private Country country;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "STATE_ID")
	private List<City> cityList;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "STATE_ID")
	private List<Chanel> chanelList;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "STATE_ID")
	private List<Publication> publicationList;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "STATE_ID")
	private List<Tracking> trackingList;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "STATE_ID")
	private List<PrintTracking> printTrackingList;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "STATE_ID")
	private List<AdvertisementTracking> advertisementTrackingList;

	/**
	 * @return the stateId
	 */
	public Integer getStateId() {
		return stateId;
	}

	/**
	 * @param stateId the stateId to set
	 */
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	/**
	 * @return the stateName
	 */
	public String getStateName() {
		return stateName;
	}

	/**
	 * @param stateName the stateName to set
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName;
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
	 * @return the country
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(Country country) {
		this.country = country;
	}

	/**
	 * @return the cityList
	 */
	public List<City> getCityList() {
		return cityList;
	}

	/**
	 * @param cityList the cityList to set
	 */
	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}

	/**
	 * @return the chanelList
	 */
	public List<Chanel> getChanelList() {
		return chanelList;
	}

	/**
	 * @param chanelList the chanelList to set
	 */
	public void setChanelList(List<Chanel> chanelList) {
		this.chanelList = chanelList;
	}

	/**
	 * @return the publicationList
	 */
	public List<Publication> getPublicationList() {
		return publicationList;
	}

	/**
	 * @param publicationList the publicationList to set
	 */
	public void setPublicationList(List<Publication> publicationList) {
		this.publicationList = publicationList;
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
