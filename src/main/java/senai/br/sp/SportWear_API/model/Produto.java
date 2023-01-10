package senai.br.sp.SportWear_API.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import senai.br.sp.SportWear_API.controller.form.ProdutoForm;

@Entity
@Table(name = "produtos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String img;
	private String price;
	private String category;
	
	public Produto(ProdutoForm produtoForm) {
		this.title = produtoForm.getTitle();
		this.img = produtoForm.getImg();
		this.price = produtoForm.getPrice();
		this.category = produtoForm.getCategory();
	}
	
	
	public void atualizarInformacoes(ProdutoForm produtoWeb) {
		if (produtoWeb.getTitle() != null) {
			this.title = produtoWeb.getTitle();
		} 
		
		if (produtoWeb.getImg() != null) {
			this.img = produtoWeb.getImg();
		} 
		
		if (produtoWeb.getPrice() != null) {
			this.price = produtoWeb.getPrice();
		}
		
		if (produtoWeb.getCategory() != null) {
			this.category = produtoWeb.getCategory();
		}
		
	}


	
	

	

}
