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
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;

@Named
@RequestScoped
@Getter
public class DetalhesProdutoBean extends JSFUtil { //implements Serializable - Nao precisa pois ja esta no JSFUtil

    @Inject
    private ProdutoLogic logic;
    private Produto produto;

    @PostConstruct
    public void init() {
        try {
            int codigo = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id"));
            Produto produto = new Produto();
            produto.setId(codigo);
            this.produto = this.logic.buscarPorId(produto);
        } catch (ErroSistemaException ex) {
            addMensagemFatal(ex.getMessage());
        } catch (ErroNegocioException ex) {
            addMensagemErro(ex.getMessage());
        } catch (NumberFormatException ex) {

        }

    }

}
