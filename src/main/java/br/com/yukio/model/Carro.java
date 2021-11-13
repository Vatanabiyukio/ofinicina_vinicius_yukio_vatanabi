package br.com.yukio.model;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

/**
 * @author Vinicius Yukio Vatanabi
 * @version 1.2
 * @since 12/11/2021 - 22:29
 **/
@Table(name = "carro", indexes = {
        @Index(name = "idx_carro_placa", columnList = "placa")
})
@Proxy(lazy = false)
@Entity(name = "Carro")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Carro implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
//    @GeneratedValue(generator="system-uuid")
//    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "placa")
    String placa;
    @Column(name = "cor")
    String cor;
    @Column(name = "ano")
    Integer ano;
    @Column(name = "anoModelo")
    Integer anoModelo;
    @Column(name = "marca")
    String marca;
    @Column(name = "modelo")
    String modelo;
    @ManyToOne(targetEntity = Cliente.class,
            cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Cliente cliente;
    @ManyToOne(targetEntity = Oficina.class,
            cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Oficina oficina;

    public Carro(String placa, String cor, Integer ano, Integer anoModelo, String marca, String modelo, Cliente cliente, Oficina oficina) {
        this.placa = placa;
        this.cor = cor;
        this.ano = ano;
        this.anoModelo = anoModelo;
        this.marca = marca;
        this.modelo = modelo;
        this.cliente = cliente;
        this.oficina = oficina;
    }

    public Carro(String placa, String cor, Integer ano, Integer anoModelo, String marca, String modelo) {
        this.placa = placa;
        this.cor = cor;
        this.ano = ano;
        this.anoModelo = anoModelo;
        this.marca = marca;
        this.modelo = modelo;
    }

    public Carro(String placa, Cliente cliente, Oficina oficina) {
        this.placa = placa;
        this.cliente = cliente;
        this.oficina = oficina;
    }

    public Carro(String placa) {
        this.placa = placa;
    }

    public Carro(String placa, Cliente cliente) {
        this.placa = placa;
        this.cliente = cliente;
    }

    public Carro() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Carro carro)) return false;

        if (getAno() != null ? !getAno().equals(carro.getAno()) : carro.getAno() != null) return false;
        if (getMarca() != null ? !getMarca().equals(carro.getMarca()) : carro.getMarca() != null) return false;
        return getCliente() != null ? getCliente().equals(carro.getCliente()) : carro.getCliente() == null;
    }

    @Override
    public int hashCode() {
        int result = getAno() != null ? getAno().hashCode() : 0;
        result = 31 * result + (getMarca() != null ? getMarca().hashCode() : 0);
        result = 31 * result + (getCliente() != null ? getCliente().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "placa='" + placa + '\'' +
                ", cor='" + cor + '\'' +
                ", ano=" + ano +
                ", anoModelo=" + anoModelo +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }
}