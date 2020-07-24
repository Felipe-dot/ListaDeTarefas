package tarefasLista;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int aux = 0;
		int loop = 0;
		Scanner teclado = new Scanner(System.in);
		ArrayList<Tarefa> listaDeTarefa = new ArrayList<Tarefa>();
		
		do {
			System.out.println("====MENU=====");
			System.out.println("[1] cadastrar tarefa");
			System.out.println("[2] remover tarefa");
			System.out.println("[3] consultar tarefa");
			System.out.println("[4] alterar tarefa");
			System.out.println("[5] sair");
			aux = Integer.valueOf(teclado.nextLine());
			
			switch(aux) {
				case 1:
					Tarefa.cadastrarTarefa(listaDeTarefa);
					break;
				case 2:
					if(loop == 0) {
						System.out.println("Nenhuma tarefa cadastrada");
						break;
					}else {
						Tarefa.removerTarefa(listaDeTarefa);
						break;
					} 		
				case 3:
					Tarefa.mostrarTarefa(listaDeTarefa);
					break;
				case 4:
					if(loop == 0) {
						System.out.println("Nenhuma tarefa cadastrada");
						break;
					}else{
						Tarefa.atualizarTarefa(listaDeTarefa);
						break;
					}
			}
			
		}while(aux !=5);
		
		teclado.close();		
	}
	
}
