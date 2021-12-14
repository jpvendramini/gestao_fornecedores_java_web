package dominio;

import application.Dominio;

public class Produto extends Dominio{
	private TipoProduto tipoProduto;

	public Produto(String descricao, TipoProduto tipoProduto) {
		super();
		this.setDescricao(descricao);
		this.tipoProduto = tipoProduto;
	}

	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}
}
