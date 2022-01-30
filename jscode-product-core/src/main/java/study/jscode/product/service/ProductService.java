package study.jscode.product.service;

import java.util.NoSuchElementException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import study.jscode.product.domain.Product;
import study.jscode.product.domain.ProductRepository;
import study.jscode.product.dto.ProductAllResponse;
import study.jscode.product.dto.ProductResponse;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {
	private final ProductRepository productRepository;

	@Transactional
	public Long save(Product product) {
		return productRepository.save(product).getId();
	}

	@Transactional
	public void update(Long id, Product product) {
		Product original = findById(id);
		original.update(product);
	}

	public ProductResponse find(Long productId) {
		Product product = findById(productId);
		return ProductResponse.of(product);
	}

	public Page<ProductAllResponse> findAll(PageRequest pageRequest) {
		return ProductAllResponse.of(productRepository.findAll(pageRequest));
	}

	@Transactional
	public void delete(Long productId) {
		productRepository.deleteById(productId);
	}

	private Product findById(Long id) {
		return productRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

}
