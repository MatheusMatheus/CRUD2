package br.com.teste;

import br.com.model.Curso;
import br.com.model.Endereco;
import br.com.model.Pessoa;
import br.com.model.PessoaFisica;
import br.com.model.PessoaJuridica;
import br.com.model.dao.CursoDAO;
import br.com.model.dao.PessoaDAO;

public class TestaConexao {
	
	public static Endereco criaEnd(String cep, String cidade, String logra, int numero) {
		Endereco endereco = new Endereco();
		endereco.setCep(cep);
		endereco.setCidade(cidade);
		endereco.setLogradouro(logra);
		endereco.setNumero(numero);
		return endereco;
	}
	
	public static Curso criaCurso(String nome, int duracao) {
		Curso curso = new Curso();
		curso.setDuracao(duracao);
		curso.setNome(nome);
		return curso;
	}
	
	public static PessoaFisica criaPF(Endereco end, String nome, String tel, String cpf) {
		PessoaFisica p = new PessoaFisica();
		p.setEndereco(end);
		p.setNome(nome);
		p.setTelefone(tel);
		p.setCpf(cpf);
		return p;
	}
	
	public static PessoaJuridica criaPJ(Endereco end, String nome, String tel, String cnpj) {
		PessoaJuridica pj = new PessoaJuridica();
		pj.setCnpj(cnpj);
		pj.setEndereco(end);
		pj.setNome(nome);
		pj.setTelefone(tel);	
		return pj;
	}
	
	public static void main(String[] args) {
		Endereco end1 = criaEnd("72302108", "Taguatinga", "Rua dos bobos", 0);
		Endereco end2 = criaEnd("4649879", "Tocantins", "Rua 50", 30);
		
		Pessoa pf1 = criaPF(end1, "Matheus", "953295623", "04408803197");
		Pessoa pf2 = criaPF(end2, "Joana", "15313513513", "12345678950");
		
		
		Curso c1 = criaCurso("Enchedor de pneu de trem", 658);
		c1.adiciona((PessoaFisica)pf1);
		c1.adiciona((PessoaFisica)pf2);
		
		PessoaDAO dao = new PessoaDAO();
		dao.inserir(pf1);
		dao.inserir(pf2);
	}
}
