package br.com.yukio.persistence;

import br.com.yukio.model.Cliente;

import java.util.List;

/**
 * @author Vinicius Yukio Vatanabi
 * @version 1.2
 * @since 12/11/2021 - 22:29
 **/
public interface ClienteDao {
    void incluir(Cliente humanoide);

    void alterar(Cliente humanoide);

    void excluir(Cliente humanoide);

    List<Cliente> listarTodos();
}
