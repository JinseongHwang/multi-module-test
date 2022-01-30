package study.jscode.product.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// 조회수
	private Long viewCount;
	// 상품 노출 여부
	private Boolean exposureStatus;
	//상품명
	private String title;
	// 상품 내용
	@Column(columnDefinition = "TEXT")
	private String content;
	//가격
	private Integer price;

	private Product(Boolean exposureStatus, String title, String content, Integer price) {
		validateDefaultValue(exposureStatus,title,content,price);
		this.exposureStatus = exposureStatus;
		this.title = title;
		this.content = content;
		this.price = price;
		this.viewCount = 0L;
	}

	public static Product of(Boolean exposureStatus, String title, String content, Integer price) {
		return new Product(exposureStatus,title,content,price);
	}

	public void update(Product product) {
		validateDefaultValue(product.exposureStatus, product.title, product.content, product.price);
		this.exposureStatus = product.exposureStatus;
		this.title = product.title;
		this.content = product.content;
		this.price = product.price;
	}

	private void validateDefaultValue(Boolean exposureStatus, String title, String content, Integer price) {
		Objects.requireNonNull(exposureStatus);
		Objects.requireNonNull(title);
		Objects.requireNonNull(content);
		Objects.requireNonNull(price);
	}
}
