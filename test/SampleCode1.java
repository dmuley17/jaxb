package test;


import com.dm.card.utility.CardInfo;
import com.dm.card.utility.CardUtility;

import us.fatehi.creditcardnumber.AccountNumber;
import us.fatehi.creditcardnumber.BankCard;
import us.fatehi.creditcardnumber.PrimaryAccountNumber;
import us.fatehi.magnetictrack.bankcard.BankCardMagneticTrack;

public class SampleCode1
{

  public static void main(final String[] args)
  {
    /*
     final PrimaryAccountNumber pan = new AccountNumber("371449635398431");
    final BankCard card = new BankCard(pan);
    System.out.println(card);
     */
    final BankCardMagneticTrack track = BankCardMagneticTrack
    	      .from("%B5350290149345177^FATEHI/SUALEH^16042010000000000000000000000000000567001000?;5350290149345177=16042010000056700100?");
    	    System.out.println(track);
    	    
    	   
	  
	  /*CardInfo cardInfo=new CardInfo();
	  cardInfo.setPlainCard(true);
	  cardInfo.setPan("371449635398431");
	  CardUtility cardUtility=new CardUtility();
	  cardInfo=cardUtility.getCardInformation(cardInfo);
	  System.out.println("CardNumber:"+cardInfo.getPan());
	  System.out.println("Brand:"+cardInfo.getCardBrand());
	  System.out.println("CardValid:"+cardInfo.isPrimaryAccountNumberValid());
	  System.out.println("isCardNumberValid:"+cardInfo.getIssuerIdentificationNumber());*/
	  
	  /*CardInfo cardInfo=new CardInfo();
	  cardInfo.setPlainCard(false);
	  cardInfo.setTrack1Data(true);
	  cardInfo.setPan("371449635398431");
	  cardInfo.setTrack1Data("%B5350290149345177^FATEHI/SUALEH^16042010000000000000000000000000000567001000?;5350290149345177=16042010000056700100?");
	  cardInfo.setTrack1Data("%B4111111121111111^ANTONIEWICZ/BRAD^1103101000000001000000003000000?;4111111111111111=1103101000000300001?");
	  CardUtility cardUtility=new CardUtility();
	  cardInfo=cardUtility.getCardInformation(cardInfo);
	  System.out.println("CardNumber:"+cardInfo.getPan());
	  System.out.println("Brand:"+cardInfo.getCardBrand());
	  System.out.println("CardValid:"+cardInfo.isPrimaryAccountNumberValid());
	  System.out.println("issuer ID Num:"+cardInfo.getIssuerIdentificationNumber());
	  System.out.println("getServiceCode:"+cardInfo.getServiceCode());
	  System.out.println("getServiceCode:"+cardInfo.getCardHolderName());
	  System.out.println("getExpirationDate:"+cardInfo.getExpirationDate());
	  System.out.println("getExpirationDate:"+cardInfo.isCardExpired());*/
	  
	  
	  CardInfo cardInfo=new CardInfo();
	  cardInfo.setPlainCard(false);
	  cardInfo.setTrack2Data(true);
	  cardInfo.setTrack2Data(";5350290149345177=15042010000056700100?");
	  CardUtility cardUtility=new CardUtility();
	  cardInfo=cardUtility.getCardInformation(cardInfo);
	  System.out.println("CardNumber:"+cardInfo.getPan());
	  System.out.println("Brand:"+cardInfo.getCardBrand());
	  System.out.println("CardValid:"+cardInfo.isPrimaryAccountNumberValid());
	  System.out.println("issuer ID Num:"+cardInfo.getIssuerIdentificationNumber());
	  System.out.println("getServiceCode:"+cardInfo.getServiceCode());
	  System.out.println("getCardHolderName:"+cardInfo.getCardHolderName());
	  System.out.println("getExpirationDate:"+cardInfo.getExpirationDate());
	  System.out.println("isCardExpired:"+cardInfo.isCardExpired());
	  
	  
  }

}