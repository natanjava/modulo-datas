package modulo_datas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.time.format.DateTimeFormatter;

public class CompararDatas {

	public static void main(String[] args) throws ParseException, InterruptedException {
		// TODO Auto-generated method stub
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dataVencimentoBoleto = simpleDateFormat.parse("08/02/2022");
		Date dataAtualHoje = simpleDateFormat.parse("07/04/2021");
		
		if (dataVencimentoBoleto.after(dataAtualHoje)) {
			System.out.println("Boleto não venceu");			
		}
		else {
			System.out.println("Boleto vencido - entre em contato para regulariar a situação");
		}
		System.out.println("\n");	
		
		
		
		/* ------------- Somando valores a data -------------*/
		Calendar calendar = Calendar.getInstance(); // pega a data atual
		
		calendar.setTime(new SimpleDateFormat("dd-MM-yyy").parse("10-03-2021"));
		calendar.add(Calendar.DAY_OF_MONTH, 5);
		System.out.println("Somando 5 dias :"+new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime()));
		
		calendar.add(Calendar.MONTH, 5);
		System.out.println("Somando o mes :"+new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime()));
		
		
		
		/* --------- Calcular intervalo enre datas ------------- */		
		//Date dataPassada = new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2021");  não precisou
		long diasPassados = ChronoUnit.DAYS.between(LocalDate.parse("2023-02-01"), LocalDate.now());
		System.out.println("Possui "+diasPassados+" dias entre as datas.");
		System.out.println("\n \n");
		
		
		
		
		/* ------------- Gerar 12 parcelas de pagamentos -------------*/
		Date dataInicial = new SimpleDateFormat("dd-MM-yyy").parse("08-04-2021");
		Calendar outroCalendar  = Calendar.getInstance();
		outroCalendar.setTime(dataInicial);
		
		
		for (int parcela=1; parcela <=12; parcela++) {
			outroCalendar.add(Calendar.MONTH, 1);
			 System.out.println("Parcela número "+parcela+", vencimento em : "+new SimpleDateFormat("dd/MM/yyy")
					 .format(outroCalendar.getTime()));
		}
		System.out.println("\n \n");
		
		
		
		
		/* -------------  Nova API data e Hora -------------*/
		LocalDate dataLocal =  LocalDate.now();
		System.out.println(dataLocal); //data
		
		LocalTime horaAtual = LocalTime.now();
        System.out.println(horaAtual);  //hora  mostra nano segundos
        
        LocalDateTime dataHoraAtual = LocalDateTime.now();       
        System.out.println(dataHoraAtual); // data e hora
        
        //formatado
        System.out.println(dataHoraAtual.format(DateTimeFormatter.ISO_DATE));
        System.out.println(dataHoraAtual.format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println(dataHoraAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss")));
        System.out.println(horaAtual.format(DateTimeFormatter.ofPattern("HH:mm")));
        System.out.println("\n ");
		
        
        /* -------------  descobrir Dias, meses, anos com a nova API-------------*/
		LocalDate localDate = LocalDate.now();
		System.out.println("Data atual :"+localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		System.out.println("Dia da semana :"+localDate.getDayOfWeek().name());
		System.out.println("Dia da semana: "+localDate.getDayOfWeek().ordinal());
		System.out.println("Dia do mês: "+localDate.getDayOfMonth());
		System.out.println("Dia do ano: "+localDate.getDayOfYear());
		System.out.println("Mês do ano: "+localDate.getMonth()+" - Número do mês do ano :"+localDate.getMonth().ordinal());
		System.out.println("\n ");
		
		
		/* -------------  Classe Instant  
		 *                Quanto tempo um processo demora ser executado
		 *                    pacote java.Time-------------*/
		
		
		Instant iInicio = Instant.now(); 
		Thread.sleep(1000); // pode ser um processo com tempo qualquer que nao conhecemos
		Instant iFinal = Instant.now();
		Duration duracao = Duration.between(iInicio, iFinal);
		System.out.println("Duração em nano segundos :"+(duracao.toNanos()));
		
		System.out.println(duracao.toMinutes());
		System.out.println(duracao.toHours());
		System.out.println(duracao.toMillis());
		System.out.println("\n ");
	
		
		/* -------------   Faixa de tempo com Objeto Period ------------*/
		LocalDate dataAntiga = LocalDate.of(2020,2,7);
		LocalDate dataNova = LocalDate.of(2021,4,14);
		System.out.println("Data antiga é maior que data nova ? " + dataAntiga.isAfter(dataNova));
		System.out.println("Datas são iguais " + dataAntiga.isEqual(dataNova));
		Period periodo = Period.between(dataAntiga, dataNova);
		System.out.println("Quantos dias entre as duas datas: "+periodo.getYears()+" ano(s) "
				+periodo.getMonths()+" mes(es) e "+periodo.getDays()+" dia(s)");
		System.out.println("Total de meses: "+periodo.toTotalMonths());
		System.out.println("\n ");
		
		
		/* -------------  Mais funcionalidades com LocalDate   ------------*/
		LocalDate dataBase = LocalDate.parse("2019-10-05");
		System.out.println("Data base: "+dataBase);
		
		dataBase = dataBase.plusDays(5);
		System.out.println("Mais 5 dias: " +dataBase);
		
		dataBase = dataBase.plusWeeks(5);
		System.out.println("Mais 5 semanas: " +dataBase);
		
		dataBase = dataBase.plusYears(5);
		System.out.println("Mais 5 anos: " +dataBase);
		
		dataBase = dataBase.plusMonths(2);
		System.out.println("Mais 2 meses: " +dataBase);
		
		dataBase = dataBase.minusDays(1);
		System.out.println("Menos 1 dia: " +dataBase);
		System.out.println("\n ");
		
		
		/* -------------  Gerar boletos com DataTime   ------------*/
		LocalDate dataBase2 = LocalDate.parse("2019-10-05");
		
		
		for (int mes = 1; mes <=12; mes++) {
			dataBase2 = dataBase2.plusMonths(1);
			System.out.println("Data de vencimento: "+dataBase2.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) 
			+" dreferente à: "+mes+" parcela");
		}		
	}
}
