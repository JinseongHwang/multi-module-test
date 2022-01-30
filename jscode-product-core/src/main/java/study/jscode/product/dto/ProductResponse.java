package study.jscode.product.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.jscode.product.domain.Product;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductResponse {
	private Long id;
	private Long viewCount;
	private Boolean exposureStatus;
	private String title;
	private String content;
	private Integer price;

	public static ProductResponse of(Product product) {
		return new ProductResponse(
			product.getId(), product.getViewCount(),
			product.getExposureStatus(), product.getTitle(),
			product.getContent(), product.getPrice()
		);
	}
}
