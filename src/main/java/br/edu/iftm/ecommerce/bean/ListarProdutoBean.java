/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.iftm.ecommerce.bean;

import br.edu.iftm.ecommerce.entity.Produto;
import br.edu.iftm.ecommerce.logic.ProdutoLogic;
import br.edu.iftm.ecommerce.util.exception.ErroNegocioException;
import br.edu.iftm.ecommerce.util.exception.ErroSistemaException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;

@Named
@RequestScoped
@Getter
public class ListarProdutoBean extends JSFUtil{
    
    @Inject
    private ProdutoLogic logic;
    
    private List<Produto> produtos;
    
    
    @PostConstruct
    public void init(){
        try {
            
            this.produtos = this.logic.buscar(null);
        } catch (ErroSistemaException ex) {
            addMensagemFatal(ex.getMessage());
        } catch (ErroNegocioException ex) {
            addMensagemErro(ex.getMessage());
        }
        
    
    
    }
    
    
    
}
