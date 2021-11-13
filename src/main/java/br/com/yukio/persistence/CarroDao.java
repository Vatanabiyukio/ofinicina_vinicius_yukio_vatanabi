package br.com.yukio.persistence;

import br.com.yukio.model.Carro;

import java.util.List;

/**
 * @author Vinicius Yukio Vatanabi
 * @version 1.2
 * @since 12/11/2021 - 22:29
 **/
public interface CarroDao {
    void incluir(Carro veiculo);

    void alterar(Carro veiculo);

    void excluir(Carro veiculo);

    List<Carro> listarTodos();

    Carro buscarPelaPlaca(String placa);
}
