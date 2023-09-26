package modulo_datas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatasEmJava {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ParseException {
		
		Date date = new Date();   // old wal to declare
		
		System.out.println("Data formato padrão :" +date);
		System.out.println("Data em milisegundos :" +date.getTime());
		System.out.println("Dia do mes :" +date.getDate());
		System.out.println("Numero do dia da semana :" +date.getDay());
		System.out.println("Dia da Semana :" +date.getHours());
		System.out.println("Hora do dia :" +date.getHours());
		System.out.println("Minuto da hora :"+date.getMinutes());
		System.out.println("Segundos :"+date.getSeconds());
		System.out.println("Ano :"+(date.getYear()+1900));
		
		
		/*  ------------ Simple Dat Format -----------------
		          Get a Date and convert to Date Object
        */

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
		System.out.println("\n Data atual em formato padrão em String: "+simpleDateFormat.format(date));
		
		simpleDateFormat = new  SimpleDateFormat("yyyy/MM/dd"); 
		System.out.println("\n Data em formato Banco de Dados: "+simpleDateFormat.format(date));
				
		simpleDateFormat = new  SimpleDateFormat("HH:mm:ss");  
		System.out.println("\n Data em formato Horas: "+simpleDateFormat.format(date));
		
		simpleDateFormat = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		System.out.println("\n Recebe de uma String: "+simpleDateFormat.parse("1978-02-24 13:12:22"));
		
		
		/* ---------------- Calendar -------------------------*/
		Calendar calendar = Calendar.getInstance(); // Static Class from java.util;
		
		Date date2 = new Date(); 
		
		System.out.println("Data em milisegundos :"+ date2.getTime());
		System.out.println("Calendar em milisegundos :" +calendar.getTimeInMillis());
		System.out.println("Dia do mês :" +date2.getDate());
		System.out.println("Dia do mês :" +calendar.get(Calendar.DAY_OF_MONTH));
		System.out.println("Dia da Semana :"+date2.getDay());
		System.out.println("Dia da semana: "+(calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH)-1));
		System.out.println("Horas do dia :"+date2.getHours());
		System.out.println("Horas do dia :"+calendar.get(Calendar.HOUR_OF_DAY));
		System.out.println("Minuto da hora :"+date2.getMinutes());
		System.out.println("Minuto da hora :"+calendar.get(Calendar.MINUTE));
		System.out.println("Segundos :"+date2.getSeconds());
		System.out.println("Segundos :"+calendar.get(Calendar.SECOND));
		System.out.println("Ano :"+(date2.getYear()+1900));
		System.out.println("Ano :"+calendar.get(Calendar.YEAR));
		
		System.out.println("Calendar Formato Padrão e String:"+simpleDateFormat.format(calendar.getInstance().getTime()));
		
	}

}
