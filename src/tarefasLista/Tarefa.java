package tarefasLista;

import java.util.ArrayList;
import java.util.Scanner;

public class Tarefa {
	static Scanner teclado = new Scanner(System.in);
	
	private String descricao;
	private Data dataLimite = new Data();
	private Boolean realizada;
	
	public Tarefa() {
		
	}
	
	public Tarefa(String descricao, int dia, int mes, int ano, boolean foiRealizada) {
		setDescricao(descricao);
		setDataLimite(dia,mes,ano);
		setRealizada(foiRealizada);
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDataLimite() {
		return dataLimite.getDia() + "/" + dataLimite.getMes() + "/" + dataLimite.getAno();
	}
	public void setDataLimite(int dia, int mes, int ano) {
		dataLimite.setDia(dia);
		dataLimite.setMes(mes);
		dataLimite.setAno(ano);	
	}
	public String getRealizada() {
		if(realizada.equals(true)) {
			return "Sim";
		}else
			return "Não";
		
	}
	public void setRealizada(Boolean realizada) {
		this.realizada = realizada;
	}
	
	//Métodos
	public static void cadastrarTarefa(ArrayList<Tarefa> listaDeTarefa) {
		int dia;
		int mes;
		int ano;
		System.out.println("Dê uma descrição para a tarefa:");
		String descricao = teclado.nextLine();
		do {
			System.out.println("Qual a data limite");
			System.out.println("Dia:");
			dia = Integer.valueOf(teclado.nextLine());
			System.out.println("Mes:");
			mes = Integer.valueOf(teclado.nextLine());
			System.out.println("Ano:");
			ano =  Integer.valueOf(teclado.nextLine());
		}while(eValida(dia,mes,ano));
	
		System.out.println("Foi realizada?");
		String  realizada = teclado.nextLine();
		
		if(realizada.toLowerCase().equals("sim")) {
			listaDeTarefa.add(new Tarefa(descricao,dia,mes,ano,true));
		}else
			listaDeTarefa.add(new Tarefa(descricao,dia,mes,ano,false));
	}
	
	public static void cadastrarTarefa(ArrayList<Tarefa> listaDeTarefa, int posicao) {
		int dia;
		int mes;
		int ano;
		System.out.println("Dê uma descrição para a tarefa:");
		String descricao = teclado.nextLine();
		do {
			System.out.println("Qual a data limite");
			System.out.println("Dia:");
			dia = Integer.valueOf(teclado.nextLine());
			System.out.println("Mes:");
			mes = Integer.valueOf(teclado.nextLine());
			System.out.println("Ano:");
			ano =  Integer.valueOf(teclado.nextLine());
		}while(eValida(dia,mes,ano));
		
		System.out.println("Foi realizada?");
		String  realizada = teclado.nextLine();
		
		if(realizada.toLowerCase().equals("sim")) {
			listaDeTarefa.set(posicao,new Tarefa(descricao,dia,mes,ano,true));
		}else
			listaDeTarefa.set(posicao,new Tarefa(descricao,dia,mes,ano,false));
	}
	
	public static void removerTarefa(ArrayList<Tarefa> listaDeTarefa) {
		mostrarTarefa(listaDeTarefa);
		System.out.println("Qual tarefa voce quer remover?");
		int posicao = Integer.valueOf(teclado.nextLine());
		listaDeTarefa.remove(posicao);
	}
	
	public static void mostrarTarefa(ArrayList<Tarefa> listaDeTarefa) {
		int cont = 0;
		System.out.println("\t =====Lista atual=====");
		System.out.println("DESCRICAO    "	+ "\t  DATA LIMITE " + " FOI REALIZADA ");
		for(Tarefa tarefa: listaDeTarefa) {
			System.out.println("|"+cont+"|" + tarefa.getDescricao() 
							+ "     " 
							+ (tarefa.getDataLimite())
							+ "      "   
							+ tarefa.getRealizada());
			cont++;
		}
		System.out.println("\n\n");
	}
	
	public static void atualizarTarefa(ArrayList<Tarefa> listaDeTarefa) {
		mostrarTarefa(listaDeTarefa);
		System.out.println("Qual tarefa voce quer alterar?");
		int posicao = Integer.valueOf(teclado.nextLine());
		cadastrarTarefa(listaDeTarefa, posicao);		
	}
	
	public static boolean eValida(int dia,int mes, int ano) {
		if(dia > 0 && dia <= 31  && mes > 0 && mes <= 12 && ano > 0) {
			return false;
		}else
			System.out.println("Valores invalidos, digite novamente");
			return true;		
	}

	public boolean equals(String testDescricao, String dataLimite, String testRealizada ) {
		if(getDescricao().equals(testDescricao) && getDataLimite().equals(dataLimite) && getRealizada().toLowerCase().equals(testRealizada)) {
			return true;
		}else
			return false;
		
	}
		
}
