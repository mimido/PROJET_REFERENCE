package routines;

import java.math.BigDecimal;
import java.util.Date;

/*
 * user specification: the function's comment should contain keys as follows: 1. write about the function's comment.but
 * it must be before the "{talendTypes}" key.
 * 
 * 2. {talendTypes} 's value must be talend Type, it is required . its value should be one of: String, char | Character,
 * long | Long, int | Integer, boolean | Boolean, byte | Byte, Date, double | Double, float | Float, Object, short |
 * Short
 * 
 * 3. {Category} define a category for the Function. it is required. its value is user-defined .
 * 
 * 4. {param} 's format is: {param} <type>[(<default value or closed list values>)] <name>[ : <comment>]
 * 
 * <type> 's value should be one of: string, int, list, double, object, boolean, long, char, date. <name>'s value is the
 * Function's parameter name. the {param} is optional. so if you the Function without the parameters. the {param} don't
 * added. you can have many parameters for the Function.
 * 
 * 5. {example} gives a example for the Function. it is optional.
 */
public class ConversionField {

    /**
     * helloExample: not return value, only print "hello" + message.
     * 
     * 
     * {talendTypes} String
     * 
     * {Category} User Defined
     * 
     * {param} string("world") input: The string need to be printed.
     * 
     * {example} helloExemple("world") # hello world !.
     */
    public static void helloExample(String message) {
        if (message == null) {
            message = "World"; //$NON-NLS-1$
        }
        System.out.println("Hello " + message + " !"); //$NON-NLS-1$ //$NON-NLS-2$
    }
    
    /**
     * excelStringToBigDecimal: cleaning string from excel and convert it to Big Decimal.
     * 
     * 
     * {talendTypes} String
     * 
     * {Category} User Defined
     * 
     * {param} string("(12 345,00)") input: The string need to be converted.
     * 
     * {example} excelStringToBigDecimal("(12 345,00)") # -12345.00.
     */
    public static BigDecimal excelStringToBigDecimal(String str) {
    	BigDecimal number;
        if (str != null && !str.isEmpty()){
        	// Case when the string contains a space
            str = str.replace(" ", "");
            //Case when the string contains a comma
            str = str.replace(",", "");
            //Case when the string contains parenthesis
            str = str.replace("(", "-").replace(")", "");
            if(str.matches("-?\\d*(\\.\\d+)?"))
            	number = BigDecimal.valueOf(Double.parseDouble(str));     
            else
            	number = null;
        }
        else {
        	 number = null;
        }
       return number;
    }
    
    
    /**
     * StringToInteger: cast a string to integer.
     * 
     * 
     * {talendTypes} String
     * 
     * {Category} User Defined
     * 
     * {param} string("15") input: The string need to be converted.
     * 
     * {example} StringToInteger("15") # 15.
     */   
    public static Integer StringToInteger(String str) {
        if (str.matches("\\d+")) {
        	return Integer.parseInt(str);
        }
        else {
        	return null;
        }
    }
    /**
     * StringToFloat: cast a string to float.
     * 
     * 
     * {talendTypes} String
     * 
     * {Category} User Defined
     * 
     * {param} string("-12.045") input: The string need to be converted.
     * 
     * {example} StringToFloat("-12.045") # -12.045.
     */
    public static Float StringToFloat(String str) {
    	if(str == null || str.isEmpty()) {
    		return null;
    	}
    	else if (str.matches("-?\\d*(\\.\\d+)?")) {
    				return Float.parseFloat(str);
    			}
    		else {
    			return null;
    		}
    	}
    
    /**
     * StringToBoolean: Convert the characters "O" or "N" to value True or False.
     * 
     * 
     * {talendTypes} String
     * 
     * {Category} User Defined
     * 
     * {param} string("O") input: The string need to be converted.
     * 
     * {example} StringToBoolean("O") # "TRUE".
     */
    public static String StringToBoolean(String str) {
    	str = str.toUpperCase();
        if (str.equals("O") || str.equals("OUI")) {
        	return "TRUE";
        }
        else if (str.equals("N") || str.equals("NON")) {
        	return "FALSE";
        }
        else {
        	return null;
        }
    }
    
    /**
     * stringToDate: Convert the string to a Date.
     * 
     * 
     * {talendTypes} String
     * 
     * {Category} User Defined
     * 
     * {param} string("2020-06-05 13:45:00.000") input: The string need to be converted.
     * 
     * {example} stringToDate("2020-06-05 13:45:00.000") # 2020-06-05 13:45:00.000.
     */
    public static Date stringToDate(String str) {	
        if (TalendDate.isDate(str, "yyyy-MM-dd HH:mm:ss.SSS")) {
        	return TalendDate.parseDate("yyyy-MM-dd HH:mm:ss.SSS", str);
        }
        else if (TalendDate.isDate(str, "dd-MM-yyyy'T'HH:mm:ss.SSSXXX")) {
        	return TalendDate.parseDate("dd-MM-yyyy'T'HH:mm:ss.SSSXXX", str);
        }
        else if (TalendDate.isDate(str, "yyyy-MM-dd HH:mm:ss")) {
        	return TalendDate.parseDate("yyyy-MM-dd HH:mm:ss", str);
        }
        else if (TalendDate.isDate(str, "yyyy-MM-dd")) {
        	return TalendDate.parseDate("yyyy-MM-dd", str);
        }
        else if (TalendDate.isDate(str, "yyyyMMddHHmmss")) {
        	return TalendDate.parseDate("yyyyMMddHHmmss", str);
        }
        else if (TalendDate.isDate(str, "yyyyMMddHHmm")) {
        	return TalendDate.parseDate("yyyyMMddHHmm", str);
        }
        else if (TalendDate.isDate(str, "yyyyMMddHHmmssSSS")) {
        	return TalendDate.parseDate("yyyyMMddHHmmssSSS", str);
        }
        else if (TalendDate.isDate(str, "yyyyMMdd")) {
        	return TalendDate.parseDate("yyyyMMdd", str);
        }
        else if (TalendDate.isDate(str, "yyyyMMdd_HHmmss")) {
        	return TalendDate.parseDate("yyyyMMdd_HHmmss", str);
        }
        else if (TalendDate.isDate(str, "dd/MM/yyyy hh:mm:ss a")) {
        	return TalendDate.parseDate("dd/MM/yyyy hh:mm:ss a", str);
        }
        else if (TalendDate.isDate(str, "dd/M/yyyy h:mm:ss a")) {
        	return TalendDate.parseDate("dd/M/yyyy h:mm:ss a", str);
        }
        else if (TalendDate.isDate(str, "dd/M/yyyy")) {
        	return TalendDate.parseDate("dd/M/yyyy", str);
        }
        else if (TalendDate.isDate(str, "dd/M/yyyy HH:mm:ss")) {
        	return TalendDate.parseDate("dd/M/yyyy HH:mm:ss", str);
        }
        else if (TalendDate.isDate(str, "dd/MM/yyyy")) {
        	return TalendDate.parseDate("dd/MM/yyyy", str);
        }
        else if (TalendDate.isDate(str, "dd/MM/yyyy HH:mm:ss")) {
        	return TalendDate.parseDate("dd/MM/yyyy HH:mm:ss", str);
        }
        else if (TalendDate.isDate(str, "dd-MMMM-yy")) {
        	return TalendDate.parseDate("dd-MMMM-yy", str);
        }
        else if (TalendDate.isDate(str, "dd-MMMM-yyyy")) {
        	return TalendDate.parseDate("dd-MMMM-yyyy", str);
        }
        else if (TalendDate.isDate(str, "dd-MMMM yyyy")) {
        	return TalendDate.parseDate("dd-MMMM yyyy", str);
        }
        else if (TalendDate.isDate(str, "dd-MMMM yy")) {
        	return TalendDate.parseDate("dd-MMMM yy", str);
        }
        else if (TalendDate.isDate(str, "dd-MM-yyyy")) {
        	return TalendDate.parseDate("dd-MM-yyyy", str);
        }
        else {
        	return null;
        }
    }
    
    /**
     * ZeroLeftPadding: left pad a String with Zero.
     * 
     * 
     * {talendTypes} String
     * 
     * {Category} User Defined
     * 
     * {param} string("str") input: The string need to be converted.
     * 
     * {example} ZeroLeftPadding("1234",6) # "001234".
     */
    public static String ZeroLeftPadding(String str,Integer n) {
        if (!(str.equals("NULL"))) {
        	return String.format("%0"+n+"d",Integer.parseInt(str));
        }
        else {
        	return null;
        }

    }
    
    /**
     * StringNull: apply the value null if string equals "NULL".
     * 
     * 
     * {talendTypes} String
     * 
     * {Category} User Defined
     * 
     * {param} string("str") input: The string need to be converted.
     * 
     * {example} StringNull("NULL") # null.
     */
    public static String StringNull(String str) {
        if (str.equals("NULL") || (str.equals(""))) {
        	return null;
        }
        else {
        	return str;
        }

    }
    
    
    /**
     * StringToDouble: cast a string to double.
     * 
     * 
     * {talendTypes} String
     * 
     * {Category} User Defined
     * 
     * {param} string("-12.045") input: The string need to be converted.
     * 
     * {example} StringToDouble("-12.045") # -12.045.
     */
    public static Double StringToDouble(String str) {
        if (str.matches("-?\\d*(\\.\\d+)?")) {
        	return Double.parseDouble(str);
        }
        else {
        	return null;
        }
    }
    
    /**
     * StringToDouble: check if string is double format.
     * 
     * 
     * {talendTypes} String
     * 
     * {Category} User Defined
     *
     * {param} string("120.04055") input: The string need to be converted.
     * 
     * {example} isDouble("120.04055") # True.
     */
    public static boolean isDouble(String str) {
    	if(str == null) {
    		return false;
    	}
    	try {
    		Double.parseDouble(str);
        	return true;
        } catch (NumberFormatException e) {
        		return false;
        }
    }
    
    
    /**
     * StringToInteger: check if string is Integer format.
     * 
     * 
     * {talendTypes} String
     * 
     * {Category} User Defined
     *
     * {param} string("120") input: The string need to be converted.
     * 
     * {example} isInteger("120") # True.
     */
    public static boolean isInteger(String str) {
    	if(str == null) {
    		return false;
    	}
    	try {
    		Integer.parseInt(str);
        	return true;
        } catch (NumberFormatException e) {
        		return false;
        }
    }
    
   
    /**
     * removeDuplicateDot: remove duplicate symbol dot from a string.
     * 
     * 
     * {talendTypes} String
     * 
     * {Category} User Defined
     * 
     * {param} string(".0.04055") input: The string need to be converted.
     * 
     * {example} removeDuplicateDot(".0.04055") # "0.04055".
     */
    public static String removeDuplicateDot(String str) {
    	Integer count = str.length() - str.replace(".", "").length();
    	if(count == 2){
    		return str.replaceFirst("\\.", "");
    	}
    	return str;
    }
    
    /**
     * checkGUID: check a given string is a valid GUID.
     * 
     * 
     * {talendTypes} String
     * 
     * {Category} User Defined
     * 
     * {param} string("01234567-aaaa-bbbb-cccc-0123456789AB") input: The string to be check.
     * 
     * {example} checkGUID("01234567-aaaa-bbbb-cccc-0123456789AB") # true.
     */
    
   public static Boolean checkGUID(String str) {
   	return str.matches("^[{]?[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}[}]?$"); 
   }
}