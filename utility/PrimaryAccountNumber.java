package com.dm.card.utility;

import java.io.Serializable;

public interface PrimaryAccountNumber extends Serializable{
	
  String getAccountNumber();

  int getAccountNumberLength();

  CardBrand getCardBrand();

  String getIssuerIdentificationNumber();

  String getLastFourDigits();

  //MajorIndustryIdentifier getMajorIndustryIdentifier();

  boolean hasPrimaryAccountNumber();

  boolean isLengthValid();

  boolean isPrimaryAccountNumberValid();

  boolean passesLuhnCheck();

}