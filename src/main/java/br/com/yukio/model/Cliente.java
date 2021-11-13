package br.com.yukio.model;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Vinicius Yukio Vatanabi
 * @version 1.2
 * @since 12/11/2021 - 22:29
 **/
@Table(name = "cliente", indexes = {
        @Index(name = "idx_cliente_cpf", columnList = "cpf")
})
@Entity(name = "Cliente")
@Proxy(lazy = false)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Cliente implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "cpf")
//    @GenericGenerator(name="system-uuid", strategy = "uuid")
//    @GeneratedValue(generator="system-uuid")
    String cpf;
    @Column(name = "nome")
    String nome;
    @Column(name = "dataNascimento")
    LocalDate dataNascimento;
    @OneToMany(targetEntity = Carro.class,
            cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Carro> carros;

    public Cliente(String cpf, String nome, LocalDate dataNascimento, List<Carro> carros) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.carros = carros;
    }

    public Cliente(String cpf, String nome, List<Carro> carros) {
        this.cpf = cpf;
        this.nome = nome;
        this.carros = carros;
    }

    public Cliente(String cpf, List<Carro> carros) {
        this.cpf = cpf;
        this.carros = carros;
    }

    public Cliente(String cpf) {
        this.cpf = cpf;
    }

    public Cliente() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;

        if (getNome() != null ? !getNome().equals(cliente.getNome()) : cliente.getNome() != null) return false;
        return getDataNascimento() != null ? getDataNascimento().equals(cliente.getDataNascimento()) : cliente.getDataNascimento() == null;
    }

    @Override
    public int hashCode() {
        int result = getNome() != null ? getNome().hashCode() : 0;
        result = 31 * result + (getDataNascimento() != null ? getDataNascimento().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", carros=" + carros +
                '}';
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }
}