package br.com.fiap.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/dados")
public class PessoaResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String[][] listar(){
		
		String[][] nomes = new String[5][3];
		
		nomes[0][0] = "Alê";
		nomes[0][1] = "123456789000";
		nomes[0][2] = "profale@fiap.com.br";
		
		nomes[1][0] = "Lili";
		nomes[1][1] = "00000000000";
		nomes[1][2] = "lilicarabina@fiap.com.br";
		
		nomes[2][0] = "Ruanzito";
		nomes[2][1] = "66666666666";
		nomes[2][2] = "ruru@fiap.com.br";
		
		nomes[3][0] = "Rodrigo";
		nomes[3][1] = "121212121212";
		nomes[3][2] = "jorge@fiap.com.br";
		
		nomes[4][0] = "Giovana";
		nomes[4][1] = "33333333333";
		nomes[4][2] = "gigi@fiap.com.br";
		
		return nomes;
	}
}
