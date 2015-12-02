package com.networkmi.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.networkmi.facade.UsuarioService;
import com.networkmi.model.Usuario;
import com.networkmi.model.to.UsuarioVO;
import com.networkmi.teste.ProdutoVO;


@RestController
@RequestMapping("/service/produtos/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {
	
	private static List<ProdutoVO> produtos = new ArrayList<ProdutoVO>(); 
	
	static {
		produtos.add(new ProdutoVO(1, "Adoçante Molhado", new Double("3.49"), "789835741", "Alimento", "ASSUGRIN", "http://www.paodeacucar.com.br/img/uploads/1/403/474403x200x200.jpg"));
		produtos.add(new ProdutoVO(2, "Molho Frances de Tomate Provincial", new Double("11.25"), "789835742", "Alimento", "CASINO", "http://www.paodeacucar.com.br/img/uploads/1/463/339463x200x200.jpg"));
		produtos.add(new ProdutoVO(3, "Vaca Enlatada", new Double("7.35"), "789835743", "Alimento", "BORDON", "http://www.paodeacucar.com.br/img/uploads/1/538/504538x200x200.jpg"));
		produtos.add(new ProdutoVO(4, "Ervilha Zuada", new Double("4.19"), "789835744", "Enlatado", "CASINO", "http://www.paodeacucar.com.br/img/uploads/1/424/474424x200x200.jpg"));
		produtos.add(new ProdutoVO(5, "Meus Bago", new Double("3.12"), "789835745", "Alimento", "GALINHAX", "http://www.paodeacucar.com.br/img/uploads/1/354/473354x200x200.jpg"));
	}
	
	 
    @GET
	@RequestMapping("/todos")
	public List<ProdutoVO> getTodosProdutos(){
		List<ProdutoVO> retorno = produtos; 
		return retorno;
	}
	
	@RequestMapping(value = "/obterproduto/{codigoBarra}" , method = RequestMethod.GET)
	public ProdutoVO obterProduto(@PathVariable String codigoBarra){
		ProdutoVO retorno = null;
		if (codigoBarra != null){
			for (ProdutoVO produtoVO : produtos) {
				if (codigoBarra.equals(produtoVO.getCodigoBarra())){
					retorno = produtoVO;
					break;
				}
			}
		}
		return retorno;		
	}
	
	@RequestMapping(value =  "/inserirproduto" , method = RequestMethod.POST)
	public ProdutoVO inserirProduto( @RequestBody ProdutoVO produto){
		try {
			produtos.add(produto);
		} catch (Exception e){
			System.out.println("Erro:" + e);
		}
		return produto;
	}
	
	@RequestMapping(value =  "/deletarproduto/{codigoBarra}", method = RequestMethod.GET)
	public ProdutoVO deletarProduto(@PathVariable String codigoBarra){
		ProdutoVO retorno = null;
		try {
			if (codigoBarra != null){
				for (ProdutoVO produtoVO : produtos) {
					if (codigoBarra.equals(produtoVO.getCodigoBarra())){
						retorno = produtoVO;
						produtos.remove(produtoVO);
						break;
					}
				}
			}
		} catch (Exception e){
			System.out.println("Erro:" + e);
		}
		return retorno;
	}
}


	

