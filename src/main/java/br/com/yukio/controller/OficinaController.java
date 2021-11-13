package br.com.yukio.controller;

import br.com.yukio.model.Oficina;
import br.com.yukio.persistence.OficinaDaoImp;

import java.util.List;

/**
 * @author Vinicius Yukio Vatanabi
 * @version 1.2
 * @since 12/11/2021 - 22:29
 **/
public class OficinaController {
    public void incluir(Oficina local) {
        OficinaDaoImp cd = new OficinaDaoImp();
        cd.incluir(local);
    }

    public void alterar(Oficina local) {
        OficinaDaoImp cd = new OficinaDaoImp();
        cd.alterar(local);
    }

    public void excluir(Oficina local) {
        OficinaDaoImp cd = new OficinaDaoImp();
        cd.excluir(local);
    }

    public List<Oficina> listarTodos() {
        OficinaDaoImp cd = new OficinaDaoImp();
        return cd.listarTodos();
    }
}
