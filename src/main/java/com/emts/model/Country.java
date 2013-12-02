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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity  
@Table(name="country") 
public class Country implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id  
	@GeneratedValue(strategy=GenerationType.AUTO)  
	@Column(name="COUNTRY_ID")  
	private Integer countryId;  

	@Column(name="COUNTRY_NAME")  
	private String countryName;

	@Column(name="IS_DELETED")  
	private int isDeleted;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "COUNTRY_ID")
	private List<State> stateList;

	/**
	 * @return the countryId
	 */
	public Integer getCountryId() {
		return countryId;
	}

	/**
	 * @param countryId the countryId to set
	 */
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	/**
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * @param countryName the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	/**
	 * @return the isDeleted
	 */
	public int getIsDeleted() {
		return isDeleted;
	}

	/**
	 * @param isDeleted the isDeleted to set
	 */
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * @return the stateList
	 */
	public List<State> getStateList() {
		return stateList;
	}

	/**
	 * @param stateList the stateList to set
	 */
	public void setStateList(List<State> stateList) {
		this.stateList = stateList;
	}
}
