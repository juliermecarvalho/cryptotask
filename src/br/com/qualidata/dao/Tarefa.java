package br.com.qualidata.dao;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;

public class Tarefa extends Dao {

	@DatabaseField
	private String titulo;
	@DatabaseField
	private Date dataDeCriacao;
	@DatabaseField
	private Date dataDeVencimento;
	@DatabaseField
	private Date dataHoraDeCiencia;
	@DatabaseField
	private Date dataHoraDeCancelamentoOuFinalizacao;
	@DatabaseField
	private String descricao;
	@DatabaseField(foreign = true)
	private Pessoa dono;
	@DatabaseField(foreign = true)
	private Pessoa executor;
	@DatabaseField
	private SituacaoDaTarefa situacaoDaTarefa;
	@DatabaseField
	private UrgenciaDaTarefa urgenciaDaTarefa;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getDataDeCriacao() {
		return dataDeCriacao;
	}

	public void setDataDeCriacao(Date dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}

	public Date getDataDeVencimento() {
		return dataDeVencimento;
	}

	public void setDataDeVencimento(Date dataDeVencimento) {
		this.dataDeVencimento = dataDeVencimento;
	}

	public Date getDataHoraDeCiencia() {
		return dataHoraDeCiencia;
	}

	public void setDataHoraDeCiencia(Date dataHoraDeCiencia) {
		this.dataHoraDeCiencia = dataHoraDeCiencia;
	}

	public Date getDataHoraDeCancelamentoOuFinalizacao() {
		return dataHoraDeCancelamentoOuFinalizacao;
	}

	public void setDataHoraDeCancelamentoOuFinalizacao(
			Date dataHoraDeCancelamentoOuFinalizacao) {
		this.dataHoraDeCancelamentoOuFinalizacao = dataHoraDeCancelamentoOuFinalizacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Pessoa getDono() {
		return dono;
	}

	public void setDono(Pessoa dono) {
		this.dono = dono;
	}

	public Pessoa getExecutor() {
		return executor;
	}

	public void setExecutor(Pessoa executor) {
		this.executor = executor;
	}

	public SituacaoDaTarefa getSituacaoDaTarefa() {
		return situacaoDaTarefa;
	}

	public void setSituacaoDaTarefa(SituacaoDaTarefa situacaoDaTarefa) {
		this.situacaoDaTarefa = situacaoDaTarefa;
	}

	public UrgenciaDaTarefa getUrgenciaDaTarefa() {
		return urgenciaDaTarefa;
	}

	public void setUrgenciaDaTarefa(UrgenciaDaTarefa urgenciaDaTarefa) {
		this.urgenciaDaTarefa = urgenciaDaTarefa;
	}

}
