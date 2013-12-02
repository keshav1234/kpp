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
@Table(name="channel") 
public class Chanel implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id  
	@GeneratedValue(strategy=GenerationType.AUTO)  
	@Column(name="CHANNEL_ID")  
	private Integer channelId; 

	@Column(name="CHANNEL_NAME")  
	private String channelName;

	@Column(name="CHANNEL_SHORT_NAME")  
	private String shortChannelName;

	@Column(name="IS_DELETED")  
	private Integer isDeleted;

	@ManyToOne
	@JoinColumn(name="STATE_ID")  
	private State state;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "CHANNEL_ID")
	private List<Tracking> trackingList;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "CHANNEL_ID")
	private List<AdvertisementTracking> advertisementTrackingList;
	
	/**
	 * @return the channelId
	 */
	public Integer getChannelId() {
		return channelId;
	}

	/**
	 * @param channelId the channelId to set
	 */
	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	/**
	 * @return the channelName
	 */
	public String getChannelName() {
		return channelName;
	}

	/**
	 * @param channelName the channelName to set
	 */
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	/**
	 * @return the shortChannelName
	 */
	public String getShortChannelName() {
		return shortChannelName;
	}

	/**
	 * @param shortChannelName the shortChannelName to set
	 */
	public void setShortChannelName(String shortChannelName) {
		this.shortChannelName = shortChannelName;
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
