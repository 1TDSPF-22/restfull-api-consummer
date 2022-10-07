package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.bo.ProdutoBO;
import br.com.fiap.to.ProdutoTO;

@Path("/produto")
public class ProdutoResource {

	ProdutoBO pb = new ProdutoBO();
	
	//GET-ALL
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProdutoTO> listaProdutos(){
		return pb.listar();
	}

	//GET-ID
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ProdutoTO listaProdutos(@PathParam("id") int id){
		return pb.listar(id);
	}
	
	//CADASTRAR PRODUTO
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(ProdutoTO produto, @Context UriInfo uriInfo) {
		
		//GERANDO O C�DIGO DO PRODUTO
		pb.cadastrar(produto);
		
		//CONSTRUIR A URI DE RETORNO
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		
		//PARSEANDO E CONCATENANDO O C�DIGO DO PRODUTO COM A URL
		builder.path(Integer.toString(produto.getCodigo()));
		
		//RETORNANDO A URL E TESTANDO A SOLICITA��O E REALIZANDO O POST.
		return Response.created(builder.build()).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(ProdutoTO produto, @PathParam("id") int id) {
		
		produto.setCodigo(id);
		pb.atualiza(produto);
		
		return Response.ok().build();
		
	}
	
	@DELETE
	@Path("/{id}")
	public void excluir(@PathParam("id") int id) {
		
		pb.remover(id);
	}
	
}





