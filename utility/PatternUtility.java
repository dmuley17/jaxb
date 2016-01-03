package com.dm.card.utility;

import java.util.regex.Pattern;

public interface PatternUtility {
	  Pattern non_digit = Pattern.compile("[^0-9]");
	  Pattern track1Pattern = Pattern
			    .compile("(%?([A-Z])([0-9]{1,19})\\^([^\\^]{2,26})\\^([0-9]{4}|\\^)([0-9]{3}|\\^)?([^\\?]+)?\\??)[\t\n\r ]{0,2}.*");
	  Pattern track2Pattern = Pattern
			    .compile(".*[\\t\\n\\r ]?(;([0-9]{1,19})=([0-9]{4})([0-9]{3})(.*)\\?).*");
	  Pattern track3Pattern = Pattern
			    .compile(".*?[\t\n\r ]{0,2}(\\+(.*)\\?)");
	  
	  
}
