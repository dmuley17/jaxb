package com.dm.card.utility;

import static com.dm.card.utility.PatternUtility.non_digit;
import static com.dm.card.utility.PatternUtility.track1Pattern;
import static com.dm.card.utility.PatternUtility.track2Pattern;
import static com.dm.card.utility.PatternUtility.track3Pattern;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.left;
import static org.apache.commons.lang3.StringUtils.leftPad;
import static org.apache.commons.lang3.StringUtils.right;
import static org.apache.commons.lang3.StringUtils.rightPad;
import static org.apache.commons.lang3.StringUtils.trimToEmpty;
import static org.apache.commons.lang3.text.WordUtils.capitalizeFully;

import java.util.Arrays;
import java.util.Date;
import java.util.regex.Matcher;

import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.YearMonth;
import org.threeten.bp.ZoneId;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.temporal.ChronoUnit;



public class CardUtility implements PrimaryAccountNumber{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pan;
	private CardBrand cardBrand;
	private boolean passesLuhnCheck;
	private String lastFourDigits;
	private int accountNumberLength;
	private boolean isLengthValid;
	private boolean isPrimaryAccountNumberValid;
	private String issuerIdentificationNumber;
	
	private String cardHolderName;
	private String expirationDate;
	private String serviceCode;
	private String firstName;
	private String lastName;
	private YearMonth yearMonth;
	private String discretionaryData;
	private String rawTrack1Data;
	private String rawTrack2Data;
	private String rawTrack3Data;
	private String formatCode;
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMM");  
	  
	public CardInfo getCardInformation(CardInfo cardInfo){
		if(cardInfo.isPlainCard()){
				this.pan					= non_digit.matcher(trimToEmpty(cardInfo.getPan())).replaceAll("");
				this.passesLuhnCheck 		= passesLuhnCheck();
			    this.cardBrand 				= CardBrand.from(this.pan);
			    this.lastFourDigits 		= getLastFourDigits();
			    this.cardBrand 				= getCardBrand();
			    this.accountNumberLength 	= getAccountNumberLength();
			    this.isLengthValid 			= isLengthValid();
			    this.isPrimaryAccountNumberValid =isPrimaryAccountNumberValid();
			    this.issuerIdentificationNumber =getIssuerIdentificationNumber();
			    
			    cardInfo.setPan(this.pan);
			    cardInfo.setPassesLuhnCheck(this.passesLuhnCheck);
			    cardInfo.setCardBrand(this.cardBrand.toString());
			    cardInfo.setLastFourDigits(this.lastFourDigits);
			    cardInfo.setAccountNumberLength(this.accountNumberLength);
			    cardInfo.setLengthValid(this.isLengthValid);
			    cardInfo.setPrimaryAccountNumberValid(this.isPrimaryAccountNumberValid);
			    cardInfo.setIssuerIdentificationNumber(issuerIdentificationNumber);
		}
		if(cardInfo.isTrack1Data()){
			Matcher matcher = track1Pattern.matcher(trimToEmpty(cardInfo.getTrack1Data()));
			if (matcher.matches()){
				rawTrack1Data = getGroup(matcher, 1);
				formatCode = getGroup(matcher, 2);
				pan = non_digit.matcher(trimToEmpty(getGroup(matcher, 3))).replaceAll("");
				rawName(getGroup(matcher, 4));
				cardHolderName = getFullName();
				rawExpirationDate(getGroup(matcher, 5));
				expirationDate = getExpirationDateAsString();
				serviceCode =getGroup(matcher, 6);
				discretionaryData = getGroup(matcher, 7);
				
				this.passesLuhnCheck 		= passesLuhnCheck();
				this.cardBrand 				= CardBrand.from(this.pan);
				this.lastFourDigits 		= getLastFourDigits();
				this.cardBrand 				= getCardBrand();
				this.accountNumberLength 	= getAccountNumberLength();
				this.isLengthValid 			= isLengthValid();
				this.isPrimaryAccountNumberValid =isPrimaryAccountNumberValid();
				this.issuerIdentificationNumber =getIssuerIdentificationNumber();
				
				cardInfo.setPan(this.pan);
				cardInfo.setPassesLuhnCheck(this.passesLuhnCheck);
				cardInfo.setCardBrand(this.cardBrand.toString());
				cardInfo.setLastFourDigits(this.lastFourDigits);
				cardInfo.setAccountNumberLength(this.accountNumberLength);
				cardInfo.setLengthValid(this.isLengthValid);
				cardInfo.setPrimaryAccountNumberValid(this.isPrimaryAccountNumberValid);
				cardInfo.setIssuerIdentificationNumber(issuerIdentificationNumber);
				cardInfo.setServiceCode(serviceCode);
				cardInfo.setCardHolderName(cardHolderName);
				cardInfo.setExpirationDate(expirationDate);
				cardInfo.setCardExpired(isExpired());
		    }else{
		    	cardInfo.setPassesLuhnCheck(false);
		    	cardInfo.setLengthValid(false);
		    	cardInfo.setPrimaryAccountNumberValid(false);
		    }
		}
		if(cardInfo.isTrack2Data()){
			Matcher matcher = track2Pattern.matcher(trimToEmpty(cardInfo.getTrack2Data()));
			if (matcher.matches()){
				rawTrack2Data = getGroup(matcher, 1);
				pan = non_digit.matcher(trimToEmpty(getGroup(matcher, 2))).replaceAll("");
				rawExpirationDate(getGroup(matcher, 3));
				expirationDate = getExpirationDateAsString();
				serviceCode =getGroup(matcher, 4);
				discretionaryData = getGroup(matcher, 5);


				this.passesLuhnCheck 		= passesLuhnCheck();
				this.cardBrand 				= CardBrand.from(this.pan);
				this.lastFourDigits 		= getLastFourDigits();
				this.cardBrand 				= getCardBrand();
				this.accountNumberLength 	= getAccountNumberLength();
				this.isLengthValid 			= isLengthValid();
				this.isPrimaryAccountNumberValid =isPrimaryAccountNumberValid();
				this.issuerIdentificationNumber =getIssuerIdentificationNumber();

				cardInfo.setPan(this.pan);
				cardInfo.setPassesLuhnCheck(this.passesLuhnCheck);
				cardInfo.setCardBrand(this.cardBrand.toString());
				cardInfo.setLastFourDigits(this.lastFourDigits);
				cardInfo.setAccountNumberLength(this.accountNumberLength);
				cardInfo.setLengthValid(this.isLengthValid);
				cardInfo.setPrimaryAccountNumberValid(this.isPrimaryAccountNumberValid);
				cardInfo.setIssuerIdentificationNumber(issuerIdentificationNumber);
				cardInfo.setServiceCode(serviceCode);
				//cardInfo.setCardHolderName(cardHolderName);
				cardInfo.setExpirationDate(expirationDate);
				cardInfo.setCardExpired(isExpired());
		    }else{
		    	cardInfo.setPassesLuhnCheck(false);
		    	cardInfo.setLengthValid(false);
		    	cardInfo.setPrimaryAccountNumberValid(false);
		    }
		}
		if(cardInfo.isTrack3Data()){
			Matcher matcher = track3Pattern.matcher(trimToEmpty(cardInfo.getTrack3Data()));
			if (matcher.matches()){
		      rawTrack3Data = getGroup(matcher, 1);
		      discretionaryData = getGroup(matcher, 2);
		    }
		    else
		    {
		      rawTrack3Data = null;
		      discretionaryData = "";
		    }
		}
		
		return cardInfo;
	}

	  @Override
	  public boolean passesLuhnCheck(){
	    final int length = pan.length();
	    int sum = 0;
	    boolean alternate = false;
	    for (int i = length - 1; i >= 0; i--)
	    {
	      int digit = Character.digit(pan.charAt(i), 10);
	      if (alternate)
	      {
	        digit = digit * 2;
	        digit = digit > 9? digit - 9: digit;
	      }
	      sum = sum + digit;
	      alternate = !alternate;
	    }
	    final boolean passesLuhnCheck = sum % 10 == 0;
	    return passesLuhnCheck;
	  }

	@Override
	public String getAccountNumber() {
		return this.pan;
	}

	@Override
	public int getAccountNumberLength() {
		return this.pan.length();
	}

	@Override
	public CardBrand getCardBrand() {
		return cardBrand;
	}

	@Override
	public String getIssuerIdentificationNumber() {
		return rightPad(left(this.pan, 6), 6, "0");
	}

	@Override
	public String getLastFourDigits() {
		return leftPad(right(this.pan, 4), 4, "0");
	}

	/*@Override
	public MajorIndustryIdentifier getMajorIndustryIdentifier() {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public boolean hasPrimaryAccountNumber() {
		return !isBlank(this.pan);
	}

	@Override
	public boolean isLengthValid() {
		return Arrays.asList(13, 14, 15, 16, 19).contains(getAccountNumberLength());
	}

	@Override
	public boolean isPrimaryAccountNumberValid() {
		  return hasPrimaryAccountNumber() && isLengthValid() && passesLuhnCheck() && cardBrand != null && cardBrand != CardBrand.Unknown;
	}
	protected static String getGroup(final Matcher matcher, final int group)
	  {
	    final int groupCount = matcher.groupCount();
	    if (groupCount > group - 1)
	    {
	      return matcher.group(group);
	    }
	    else
	    {
	      return null;
	    }
	  }
	  public void rawName(String rawName)
	  {
	    String[] splitName = trimToEmpty(rawName).split("/");
	    this.firstName = name(splitName, 1);
	    this.lastName = name(splitName, 0);
	  }
	  
	  private String name(final String[] splitName, final int position)
	  {
	    String name;
	    if (splitName.length > position)
	    {
	      name = capitalizeFully(trimToEmpty(splitName[position]), new char[] {
	          '.', '\'', ' '
	      });
	    }
	    else
	    {
	      name = "";
	    }

	    return name;
	  }
	  
	  public String getFullName()
	  {
	    final StringBuilder buffer = new StringBuilder();
	    if (hasFirstName())
	    {
	      buffer.append(trimToEmpty(firstName));
	    }
	    if (hasFullName())
	    {
	      buffer.append(" ");
	    }
	    if (hasLastName())
	    {
	      buffer.append(trimToEmpty(lastName));
	    }
	    return buffer.toString();
	  }
	  
	  public boolean hasFirstName()
	  {
	    return !isBlank(firstName);
	  }
	  public boolean hasLastName()
	  {
	    return !isBlank(lastName);
	  }
	  public boolean hasFullName()
	  {
	    return hasFirstName() && hasLastName();
	  }
	  
	  public void rawExpirationDate(String rawExpirationDate)
	  {
	    final String expirationDateString = non_digit.matcher(trimToEmpty(rawExpirationDate)).replaceAll("");
	    YearMonth expirationDate;
	    try
	    {
	      expirationDate = YearMonth.parse(expirationDateString, formatter);
	    }
	    catch (final Exception e)
	    {
	      expirationDate = null;
	    }
	    this.yearMonth = expirationDate;
	  }
	  public String getExpirationDateAsString()
	  {
	    if (hasExpirationDate())
	    {
	      final LocalDateTime endOfMonth = yearMonth.atEndOfMonth()
	        .atStartOfDay().plus(1, ChronoUnit.DAYS).minus(1, ChronoUnit.NANOS);
	      final Instant instant = endOfMonth.atZone(ZoneId.systemDefault())
	        .toInstant();
	      final Date date = new Date(instant.toEpochMilli());
	      return date.toString();
	    }
	    else
	    {
	      return null;
	    }
	  }
	  public boolean hasExpirationDate()
	  {
	    return yearMonth != null;
	  }
	  public boolean isExpired()
	  {
	    if (!hasExpirationDate())
	    {
	      return true;
	    }
	    else
	    {
	      return yearMonth.atEndOfMonth().isBefore(LocalDate.now());
	    }
	  }
}
