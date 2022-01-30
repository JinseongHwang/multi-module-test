package study.jscode.product.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.Data;
import study.jscode.product.domain.Product;

@Data
public class ProductRequest {
	@NotNull(message = "상품 노출 여부를 입력해주세요.")
	private Boolean exposureStatus;

	@NotBlank(message = "제목을 입력해주세요.")
	@Size(max=255,message="제목은 255자까지 입력할 수 있습니다.")
	private String title;

	@NotBlank(message = "내용을 입력해주세요.")
	@Size(max=65535,message="내용이 너무 깁니다.")
	private String content;

	@NotNull(message = "가격을 입력해주세요.")
	@Range(max=Integer.MAX_VALUE, message = "가격이 너무 큽니다.")
	private Integer price;

	public Product toProduct() {
		return Product.of(exposureStatus,title,content,price);
	}
}
