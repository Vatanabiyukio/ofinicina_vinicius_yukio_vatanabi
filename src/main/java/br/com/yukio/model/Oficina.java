package br.com.yukio.model;


import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @author Vinicius Yukio Vatanabi
 * @version 1.2
 * @since 12/11/2021 - 22:29
 **/
@Table(indexes = {
        @Index(name = "idx_oficina_codigo", columnList = "codigo")
})
@Entity(name = "Oficina")
@Proxy(lazy = false)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Oficina implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "codigo", nullable = false)
    Integer codigo;
    @Column(name = "nome")
    String nome;
    @Column(name = "especialidade")
    String especialidade;
    @Column(name = "endereco")
    String endereco;
    @OneToMany(targetEntity = Carro.class,
            cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Carro> carros;

    public Oficina(Integer codigo, String nome, String especialidade, String endereco, List<Carro> carros) {
        this.codigo = codigo;
        this.nome = nome;
        this.especialidade = especialidade;
        this.endereco = endereco;
        this.carros = carros;
    }

    public Oficina(Integer codigo, String nome, String especialidade, String endereco) {
        this.codigo = codigo;
        this.nome = nome;
        this.especialidade = especialidade;
        this.endereco = endereco;
    }

    public Oficina(Integer codigo, String nome, String endereco) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
    }

    public Oficina(Integer codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Oficina(Integer codigo) {
        this.codigo = codigo;
    }

    public Oficina() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Oficina oficina)) return false;

        if (getCodigo() != null ? !getCodigo().equals(oficina.getCodigo()) : oficina.getCodigo() != null) return false;
        if (getNome() != null ? !getNome().equals(oficina.getNome()) : oficina.getNome() != null) return false;
        if (getEspecialidade() != null ? !getEspecialidade().equals(oficina.getEspecialidade()) : oficina.getEspecialidade() != null)
            return false;
        return getEndereco() != null ? getEndereco().equals(oficina.getEndereco()) : oficina.getEndereco() == null;
    }

    @Override
    public int hashCode() {
        int result = getCodigo() != null ? getCodigo().hashCode() : 0;
        result = 31 * result + (getNome() != null ? getNome().hashCode() : 0);
        result = 31 * result + (getEspecialidade() != null ? getEspecialidade().hashCode() : 0);
        result = 31 * result + (getEndereco() != null ? getEndereco().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Oficina{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", especialidade='" + especialidade + '\'' +
                ", endereco='" + endereco + '\'' +
                ", carros=" + carros +
                '}';
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }
}
