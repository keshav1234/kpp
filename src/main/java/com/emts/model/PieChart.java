package com.emts.model;

import java.io.Serializable;

import javax.persistence.Transient;

public class PieChart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Transient
	private String fromDate;
	@Transient
	private String toDate;
	@Transient
	private Integer clientId;
	@Transient
	private String storyCode;
	@Transient
	private String param;
	@Transient
	private Integer channelId;
	
	@Transient
	private Integer publicationId;
	/**
	 * @return the fromDate
	 */
	public String getFromDate() {
		return fromDate;
	}
	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	/**
	 * @return the toDate
	 */
	public String getToDate() {
		return toDate;
	}
	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	/**
	 * @return the clientId
	 */
	public Integer getClientId() {
		return clientId;
	}
	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	/**
	 * @return the storyCode
	 */
	public String getStoryCode() {
		return storyCode;
	}
	/**
	 * @param storyCode the storyCode to set
	 */
	public void setStoryCode(String storyCode) {
		this.storyCode = storyCode;
	}
	/**
	 * @return the param
	 */
	public String getParam() {
		return param;
	}
	/**
	 * @param param the param to set
	 */
	public void setParam(String param) {
		this.param = param;
	}
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
	 * @return the publicationId
	 */
	public Integer getPublicationId() {
		return publicationId;
	}
	/**
	 * @param publicationId the publicationId to set
	 */
	public void setPublicationId(Integer publicationId) {
		this.publicationId = publicationId;
	}
}
