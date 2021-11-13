package br.com.yukio.controller;

import br.com.yukio.model.Cliente;
import br.com.yukio.persistence.ClienteDaoImp;

import java.util.List;

/**
 * @author Vinicius Yukio Vatanabi
 * @version 1.2
 * @since 12/11/2021 - 22:29
 **/
public class ClienteController {
    public void incluir(Cliente humanoide) {
        ClienteDaoImp cd = new ClienteDaoImp();
        cd.incluir(humanoide);
    }

    public void alterar(Cliente humanoide) {
        ClienteDaoImp cd = new ClienteDaoImp();
        cd.alterar(humanoide);
    }

    public void excluir(Cliente humanoide) {
        ClienteDaoImp cd = new ClienteDaoImp();
        cd.excluir(humanoide);
    }

    public List<Cliente> listarTodos() {
        ClienteDaoImp cd = new ClienteDaoImp();
        return cd.listarTodos();
    }
}
