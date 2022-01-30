package study.jscode.product.dto;

import org.springframework.data.domain.Page;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.jscode.product.domain.Product;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductAllResponse {
	private Long id;
	private Long viewCount;
	private String title;
	private Integer price;

	public static ProductAllResponse of(Product product) {
		return new ProductAllResponse(
			product.getId(), product.getViewCount(),
			product.getTitle(), product.getPrice()
		);
	}
	public static Page<ProductAllResponse> of(Page<Product> products) {
		return products.map(ProductAllResponse::of);
	}
}
