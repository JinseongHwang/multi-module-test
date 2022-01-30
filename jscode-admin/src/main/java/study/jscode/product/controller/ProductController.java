package study.jscode.product.controller;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import study.jscode.product.dto.ProductAllResponse;
import study.jscode.product.dto.ProductRequest;
import study.jscode.product.dto.ProductResponse;
import study.jscode.product.service.ProductService;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;

	@PostMapping
	public ResponseEntity<Long> save(@RequestBody @Valid ProductRequest request) {
		return ResponseEntity.ok(productService.save(request.toProduct()));
	}

	@PatchMapping("/{productId}")
	public ResponseEntity<Void> update(
		@PathVariable Long productId,
		@RequestBody @Valid ProductRequest request
	) {
		productService.update(productId, request.toProduct());
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{productId}")
	public ResponseEntity<ProductResponse> find(@PathVariable Long productId) {
		return ResponseEntity.ok(productService.find(productId));
	}

	@GetMapping
	public ResponseEntity<Page<ProductAllResponse>> findAll(@RequestParam(defaultValue = "0") int page) {
		PageRequest pageRequest = PageRequest.of(page,5);
		return ResponseEntity.ok(productService.findAll(pageRequest));
	}

	@DeleteMapping("/{productId}")
	public ResponseEntity<Void> delete(@PathVariable Long productId) {
		productService.delete(productId);
		return ResponseEntity.ok().build();
	}
}
