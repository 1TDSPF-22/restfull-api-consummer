package br.com.fiap.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.fiap.to.ProdutoTO;

public class ProdutoDAO {

	public static List<ProdutoTO> listaProduto;

	public ProdutoDAO() {
		
		if (listaProduto == null) {
			listaProduto = new ArrayList<ProdutoTO>();
			ProdutoTO pto = new ProdutoTO();
			pto.setCodigo(1);
			pto.setPreco(27.99);
			pto.setQuantidade(10);
			pto.setTitulo("Grampeador");
			listaProduto.add(pto);
			
			pto = new ProdutoTO();
			pto.setCodigo(2);
			pto.setPreco(56.89);
			pto.setQuantidade(23);
			pto.setTitulo("Planer");
			listaProduto.add(pto);
			
			pto = new ProdutoTO();
			pto.setCodigo(3);
			pto.setPreco(145.90);
			pto.setQuantidade(50);
			pto.setTitulo("Mouse");
			listaProduto.add(pto);
			
			pto = new ProdutoTO();
			pto.setCodigo(4);
			pto.setPreco(75.99);
			pto.setQuantidade(500);
			pto.setTitulo("Teclado");
			listaProduto.add(pto);
			
			pto = new ProdutoTO();
			pto.setCodigo(5);
			pto.setPreco(15.85);
			pto.setQuantidade(1500);
			pto.setTitulo("Clips");
			listaProduto.add(pto);

		}
	}
	
	//GET-ALL
	public List<ProdutoTO> select(){
		return listaProduto;
	}

	//GET-BYID
	public ProdutoTO select(int id){
		
		for (int i = 0; i < listaProduto.size(); i++) {
			if (listaProduto.get(i).getCodigo() == id ) {
				return listaProduto.get(i);
			}
		}
		return null;
	}
	
	//INSERT
	public boolean insert(ProdutoTO pto) {
		
		//GERANDO O C�DIGO DO PRODUTO
		pto.setCodigo(listaProduto.size() + 1);
		
		//INSERINDO O PRODUTO NA BASE E RECEBENDO
		// UM TRUE OU FALSE
		return listaProduto.add(pto);
		
	}
	
	//UPDATE
	public void update(ProdutoTO pto) {
		
		
		ProdutoTO produto = select(pto.getCodigo());
		
		produto.setTitulo(pto.getTitulo());
		produto.setPreco(pto.getPreco());
		produto.setQuantidade(pto.getQuantidade());
		
		//INSERINDO NA BASE DE DADOS
		for (int i = 0; i < listaProduto.size(); i++) {
			if(listaProduto.get(i) == produto) {
				listaProduto.set(i, produto);
			}
		}
		
	}
	
	
	//DELETE
	public void delete(int id) {
		
		listaProduto.remove(select(id));
		
	}
	
	
}