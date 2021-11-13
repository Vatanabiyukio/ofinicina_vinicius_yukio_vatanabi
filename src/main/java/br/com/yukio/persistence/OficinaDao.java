package br.com.yukio.persistence;

import br.com.yukio.model.Oficina;

import java.util.List;

/**
 * @author Vinicius Yukio Vatanabi
 * @version 1.2
 * @since 12/11/2021 - 22:29
 **/
public interface OficinaDao {
    void incluir(Oficina local);

    void alterar(Oficina local);

    void excluir(Oficina local);

    List<Oficina> listarTodos();
}
