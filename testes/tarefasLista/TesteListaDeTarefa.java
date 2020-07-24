package tarefasLista;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TesteListaDeTarefa {

	ArrayList<Tarefa> listaDeTarefa;
	Tarefa testeTarefa;
	
	@Before 
	public void inicalizandoListaTarefa() {
		listaDeTarefa =  new ArrayList<Tarefa>();
		testeTarefa = new Tarefa();
	}
	
	@Test
	public void testeSeTenhoUmaLista() {
		//Dado que eu tenho uma lista de tarefa
		
		//Eu espero receber
		boolean resultado =  listaDeTarefa != null;
		
		assertTrue(resultado);
		
	}
	
	@Test
	public void testeSeTenhoUmaDescricao() {
		//Dado que eu tenho uma  tarefa
		testeTarefa.setDescricao("testando123");
		//Eu espero receber
		boolean resultado =  testeTarefa.getDescricao().equals("testando123");
		
		assertTrue(resultado);
		
	}
	
	@Test
	public void testeSeTenhoUmaDataLimite() {
		//Dado que eu tenho uma tarefa
		testeTarefa.setDataLimite(05, 7, 2017);
		//Eu espero receber
		boolean resultado =  testeTarefa.getDataLimite().equals(05 +"/" + 7 +"/" + 2017);
		
		assertTrue(resultado);
		
	}
	
	@Test
	public void testeSeFoiRealizada() {
		//Dado que eu tenho uma lista de tarefa
		testeTarefa.setRealizada(true);
		//Eu espero receber
		boolean resultado =  testeTarefa.getRealizada().toLowerCase().equals("sim");
		
		assertTrue(resultado);
		
	}
	
	@Test
	public void testeCadastrarTarefa() {
		//Dado que eu tenho uma lista de tarefa	
		listaDeTarefa.add(new Tarefa("teste321",7,8,2005,true));
		//Eu espero receber
		boolean resultado =  listaDeTarefa.get(0).equals("teste321",7+"/"+8+"/"+ 2005,"sim");
		
		assertTrue(resultado);
		
	}
	
	@Test
	//É Esperado receber a excessao de IndexOutOfBounds
	(expected = IndexOutOfBoundsException.class)
	public void testeRemoverTarefa() {
		//Dado que eu tenho uma lista de tarefa
		listaDeTarefa.add(new Tarefa("teste321",7,8,2005,true));
		listaDeTarefa.remove(0);
		//Eu espero receber
		listaDeTarefa.get(0);
		
		
	}
	
	
	@Test
	public void testeAtualizarTarefa() {
		//Dado que eu tenho uma lista de tarefa
		listaDeTarefa.add(new Tarefa("teste321",7,8,2005,true));
		listaDeTarefa.set(0, new Tarefa("teste123",7,9,2006,false));
		
		//Eu espero receber
		boolean resultado =  listaDeTarefa.get(0).equals("teste123",7+"/"+9+"/"+ 2006,"não");
		
		assertTrue(resultado);
		
	}
	
	@Test
	public void testeEValida() {
		//Dado que eu tenho uma lista de tarefa
		testeTarefa.setDataLimite(05, 8, 2005);
		//Eu espero receber
		boolean resultado = Tarefa.eValida(05, 12, 2005) == false;
		
		assertTrue(resultado);
		
	}
	
	@Test
	public void testeEValidaSendoInvalida() {
		//Dado que eu tenho uma lista de tarefa
		testeTarefa.setDataLimite(05, 8, 2005);
		//Eu espero receber
		boolean resultado = Tarefa.eValida(35, 22, -2005) == true;
		
		assertTrue(resultado);
		
	}
}
