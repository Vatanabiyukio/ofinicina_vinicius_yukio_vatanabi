package br.com.yukio;

import br.com.yukio.controller.CarroController;
import br.com.yukio.controller.ClienteController;
import br.com.yukio.controller.OficinaController;
import br.com.yukio.model.Carro;
import br.com.yukio.model.Cliente;
import br.com.yukio.model.Oficina;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Vinicius Yukio Vatanabi
 * @version 1.2
 * @since 12/11/2021 - 22:29
 **/
public class Main {
    public static void main(String[] args) {
        CarroController cc = new CarroController();
        ClienteController lc = new ClienteController();
        OficinaController oc = new OficinaController();

        Carro hb20 = new Carro();
        hb20.setPlaca("VFS-7623");
        hb20.setModelo("HB20");
        hb20.setAnoModelo(2016);
        hb20.setAno(2016);
        hb20.setMarca("Hyundai");
        hb20.setCor("Branco");

        Cliente yukio = new Cliente();
        yukio.setNome("Vinicius Yukio Vatanabi");
        yukio.setCpf("053.400.611-67");
        LocalDate birthDate = LocalDate.of(Integer.parseInt("2000"), Integer.parseInt("12"), Integer.parseInt("25"));
        yukio.setDataNascimento(birthDate);
        yukio.setCarros(List.of(new Carro[]{hb20}));

        Oficina veroster = new Oficina();
        veroster.setCodigo(345452);
        veroster.setEndereco("Av. Gabriel da Fonseca");
        veroster.setNome("Veroster Automóveis");
        veroster.setEspecialidade("Carros de Luxo");
        veroster.setCarros(List.of(new Carro[]{hb20}));

        cc.incluir(hb20);
        lc.incluir(yukio);
        oc.incluir(veroster);

        hb20.setCliente(yukio);
        hb20.setOficina(veroster);

        cc.alterar(hb20);

        System.out.println(hb20);
        System.out.println(yukio);
        System.out.println(veroster);
    }
}
