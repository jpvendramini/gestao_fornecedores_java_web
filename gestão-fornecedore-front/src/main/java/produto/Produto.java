package produto;

import dominio.Dominio;

public class Produto extends Dominio{
	private TipoProduto tipoProduto;

	public Produto(TipoProduto tipoProduto) {
		super();
		this.tipoProduto = tipoProduto;
	}

	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}
}
