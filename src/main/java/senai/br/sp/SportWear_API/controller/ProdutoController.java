package senai.br.sp.SportWear_API.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
import senai.br.sp.SportWear_API.controller.dto.ReturnProduto;
import senai.br.sp.SportWear_API.controller.form.ProdutoForm;
import senai.br.sp.SportWear_API.model.Produto;
import senai.br.sp.SportWear_API.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin("http://localhost:3000")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRep;

	@PostMapping
	@Transactional
	public ResponseEntity<ReturnProduto> adicionar(@RequestBody @Valid ProdutoForm produtoForm,
			UriComponentsBuilder uriBuilder) {
		
		var produto = new Produto(produtoForm);
		produtoRep.save(produto);

		URI uri = uriBuilder.path("produtos/{id}").buildAndExpand(produto.getId()).toUri();
		return ResponseEntity.created(uri).body(new ReturnProduto(produto));
	}

	@GetMapping
	public ResponseEntity<Page<ReturnProduto>> listarProdutos(@PageableDefault(
			size = 10, sort = {"title"}) Pageable paginacao) {
		
		var produto = produtoRep.findAll(paginacao).map(ReturnProduto::new);
		return ResponseEntity.ok(produto);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ReturnProduto> ListarProdutos(@PathVariable String id) {
		var produto = produtoRep.getReferenceById(Integer.parseInt(id));
		
		return ResponseEntity.ok(new ReturnProduto(produto));
		
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ReturnProduto> alterarProduto(@RequestBody @Valid ProdutoForm produtoWeb,
			@PathVariable String id) {
		
		var produto = produtoRep.getReferenceById(Integer.parseInt(id));
		produto.atualizarInformacoes(produtoWeb);
		
		return ResponseEntity.ok(new ReturnProduto(produto));
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletarProduto(@PathVariable String id) {
		produtoRep.deleteById(Integer.parseInt(id));
		return ResponseEntity.noContent().build();

	}

}
