package com.networkmi.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	private static final String PADRAO_DATA = "dd/MM/yyyy";
	private static final SimpleDateFormat SDF = new SimpleDateFormat(PADRAO_DATA);
	
	/**
	 * Formata Calendar para String no formato PADRAO_DATA
	 * 
	 * @param cal
	 * @return
	 */
	public static String format(Calendar cal){
		String retorno = null;
		if (cal != null){
			retorno = format(cal.getTime());
		}
		return retorno;
	}
	
	/**
	 * Formata Date para String no formato PADRAO_DATA
	 * 
	 * @param date
	 * @return
	 */
	public static String format(Date date){
		String retorno = null;
		if (date != null){
			retorno = SDF.format(date);
		}
		return retorno;
	}
	
	/**
	 * Faz parse de dateString no formato PADRAO_DATA para objeto Date
	 * 
	 * @param dateString
	 * @return
	 */
	public static Date parse(String dateString){
		Date retorno = null;
		if (dateString != null){
			try {
				retorno = SDF.parse(dateString);
			} catch (ParseException e){
				throw new RuntimeException(e);
			}
		}
		return retorno;
	}
}
