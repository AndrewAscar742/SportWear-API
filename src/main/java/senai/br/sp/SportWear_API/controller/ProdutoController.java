package senai.br.sp.SportWear_API.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import senai.br.sp.SportWear_API.controller.form.ProdutoForm;
import senai.br.sp.SportWear_API.model.Produto;
import senai.br.sp.SportWear_API.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin("http://localhost:3001/admin/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRep;

	@PostMapping
	@Transactional
	public ResponseEntity<Produto> adicionar(@RequestBody @Valid ProdutoForm produtoForm,
			UriComponentsBuilder uriBuilder) {
		
		Produto produto = produtoForm.converterProdutoForm();
		produtoRep.saveAndFlush(produto);

		URI uri = uriBuilder.path("produtos/{id}").buildAndExpand(produto.getId()).toUri();
		return ResponseEntity.created(uri).body(produto);
	}

	@GetMapping
	public List<Produto> listarTodos() {
		List<Produto> listaProdutos = produtoRep.findAll();
		return listaProdutos;
	}

	@GetMapping("/{id}")
	public List<Produto> ListarProduto(@PathVariable Integer category) {
		List<Produto> listaProdutos = produtoRep.findByCategory(category);
		return listaProdutos;
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<Produto> alterarProduto(@RequestBody @Valid ProdutoForm produtoWeb, @PathVariable Integer id) {
		Optional<Produto> optional = produtoRep.findById(id);
		
		if (optional.isPresent()) {
			Produto produto = produtoWeb.converterProdutoForm();
			produto.setId(id);
			produtoRep.saveAndFlush(produto);
			return ResponseEntity.ok(produto);
		}
		
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletarProduto(@PathVariable Integer id) {
		Optional<Produto> optional = produtoRep.findById(id);

		if (optional.isPresent()) {
			produtoRep.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();

	}

}
