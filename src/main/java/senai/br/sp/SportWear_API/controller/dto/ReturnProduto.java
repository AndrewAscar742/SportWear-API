package senai.br.sp.SportWear_API.controller.dto;

import senai.br.sp.SportWear_API.model.Produto;

public record ReturnProduto(Integer id, String title, String img, String price, String category) {
	
	public ReturnProduto(Produto produto) {
		this(produto.getId(), produto.getTitle(), produto.getImg(), produto.getPrice(), produto.getCategory());
	}
}
