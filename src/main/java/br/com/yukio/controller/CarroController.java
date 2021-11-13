package br.com.yukio.controller;

import br.com.yukio.model.Carro;
import br.com.yukio.persistence.CarroDaoImp;

import java.util.List;

/**
 * @author Vinicius Yukio Vatanabi
 * @version 1.2
 * @since 12/11/2021 - 22:29
 **/
public class CarroController {
    public void incluir(Carro veiculo) {
        CarroDaoImp cd = new CarroDaoImp();
        cd.incluir(veiculo);
    }

    public void alterar(Carro veiculo) {
        CarroDaoImp cd = new CarroDaoImp();
        cd.alterar(veiculo);
    }

    public void excluir(Carro veiculo) {
        CarroDaoImp cd = new CarroDaoImp();
        cd.excluir(veiculo);
    }

    public List<Carro> listarTodos() {
        CarroDaoImp cd = new CarroDaoImp();
        return cd.listarTodos();
    }

    public Carro buscarPelaPlaca(String placa) {
        CarroDaoImp cd = new CarroDaoImp();
        return cd.buscarPelaPlaca(placa);
    }
}
