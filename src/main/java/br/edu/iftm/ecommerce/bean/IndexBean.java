package br.edu.iftm.ecommerce.bean;

import br.edu.iftm.ecommerce.entity.Usuario;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class IndexBean implements Serializable {
    
    @Inject
    private MensagemBean mensagemBean;
    
    private String mensagem = "Funcionou estamos no JAVA....";

    public String getMensagem() {
        return mensagemBean.mensagem;
    }
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    
    
}
