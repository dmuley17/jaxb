package com.dm.card.utility;

import java.io.Serializable;

public class CardInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pan;
	private String cardBrand;
	private String serviceCode;
	private String expirationDate;
	private String cardHolderName;
	
	private boolean passesLuhnCheck;
	private String lastFourDigits;
	private int accountNumberLength;
	private boolean isLengthValid;
	private boolean isPrimaryAccountNumberValid;
	
	private String track1Data;
	private String track2Data;
	private String track3Data;
	
	private boolean isPlainCard;
	private boolean isTrack1Data;
	private boolean isTrack2Data;
	private boolean isTrack3Data;
	
	private String majorIndustryIdentifier;
	private String issuerIdentificationNumber;
	
	private boolean isCardExpired;
	
	public String getPan() {
		return pan;
	}
	public String getCardBrand() {
		return cardBrand;
	}
	public String getServiceCode() {
		return serviceCode;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public String getTrack1Data() {
		return track1Data;
	}
	public String getTrack2Data() {
		return track2Data;
	}
	public String getTrack3Data() {
		return track3Data;
	}
	public boolean isPlainCard() {
		return isPlainCard;
	}
	public boolean isTrack1Data() {
		return isTrack1Data;
	}
	public boolean isTrack2Data() {
		return isTrack2Data;
	}
	public boolean isTrack3Data() {
		return isTrack3Data;
	}
	public String getMajorIndustryIdentifier() {
		return majorIndustryIdentifier;
	}
	public String getIssuerIdentificationNumber() {
		return issuerIdentificationNumber;
	}
	
	public boolean isCardExpired() {
		return isCardExpired;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public void setCardBrand(String cardBrand) {
		this.cardBrand = cardBrand;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public void setTrack1Data(String track1Data) {
		this.track1Data = track1Data;
	}
	public void setTrack2Data(String track2Data) {
		this.track2Data = track2Data;
	}
	public void setTrack3Data(String track3Data) {
		this.track3Data = track3Data;
	}
	public void setPlainCard(boolean isPlainCard) {
		this.isPlainCard = isPlainCard;
	}
	public void setTrack1Data(boolean isTrack1Data) {
		this.isTrack1Data = isTrack1Data;
	}
	public void setTrack2Data(boolean isTrack2Data) {
		this.isTrack2Data = isTrack2Data;
	}
	public void setTrack3Data(boolean isTrack3Data) {
		this.isTrack3Data = isTrack3Data;
	}
	public void setMajorIndustryIdentifier(String majorIndustryIdentifier) {
		this.majorIndustryIdentifier = majorIndustryIdentifier;
	}
	public void setIssuerIdentificationNumber(String issuerIdentificationNumber) {
		this.issuerIdentificationNumber = issuerIdentificationNumber;
	}
	public void setCardExpired(boolean isCardExpired) {
		this.isCardExpired = isCardExpired;
	}
	public boolean isPassesLuhnCheck() {
		return passesLuhnCheck;
	}
	public String getLastFourDigits() {
		return lastFourDigits;
	}
	public int getAccountNumberLength() {
		return accountNumberLength;
	}
	public boolean isLengthValid() {
		return isLengthValid;
	}
	public boolean isPrimaryAccountNumberValid() {
		return isPrimaryAccountNumberValid;
	}
	public void setPassesLuhnCheck(boolean passesLuhnCheck) {
		this.passesLuhnCheck = passesLuhnCheck;
	}
	public void setLastFourDigits(String lastFourDigits) {
		this.lastFourDigits = lastFourDigits;
	}
	public void setAccountNumberLength(int accountNumberLength) {
		this.accountNumberLength = accountNumberLength;
	}
	public void setLengthValid(boolean isLengthValid) {
		this.isLengthValid = isLengthValid;
	}
	public void setPrimaryAccountNumberValid(boolean isPrimaryAccountNumberValid) {
		this.isPrimaryAccountNumberValid = isPrimaryAccountNumberValid;
	}
	
	
	
}
