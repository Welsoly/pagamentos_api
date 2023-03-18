package uea.pagamentos_api.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
import uea.pagamentos_api.models.Categoria;
import uea.pagamentos_api.services.CategoriaService;

@RestController //controladora de rotas
@RequestMapping("/categorias")  //define a rota, que é "categorias"
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> listar () {
		List<Categoria> categorias = categoriaService.listar();
		
		return ResponseEntity
				.ok()
				.body(categorias);
				
	}
	
	@PostMapping
	public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria categoria) {
		Categoria novacategoria = categoriaService.criar(categoria);
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{codigo}")
				.buildAndExpand(novacategoria.getCodigo())
				.toUri();
		
		return ResponseEntity
				.created(uri)
				.body(novacategoria);
	}

}
