package senai.br.sp.SportWear_API.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import senai.br.sp.SportWear_API.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	List<Produto> findByCategory(Integer category);


}
