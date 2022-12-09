package senai.br.sp.SportWear_API.controller.form;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import senai.br.sp.SportWear_API.model.Produto;

//Essa será a estrutura para manipular no JSON
public class ProdutoForm {
	@NotNull @NotEmpty
	private String title;
	@NotNull @NotEmpty
	private String img;
	@NotNull @NotEmpty
	private String price;
	@NotNull @NotEmpty
	private String category;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Produto converterProdutoForm() {
		Produto produto = new Produto(null, this.title, this.img, this.price, this.category);
		return produto;
	}

}
