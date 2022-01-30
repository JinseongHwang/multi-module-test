package study.jscode.delivery.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Delivery {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long productId;

	@Enumerated(value= EnumType.STRING)
	private ReadyStatus readyStatus;

	private String location;

	private Delivery(Long productId) {
		this.productId = productId;
		this.readyStatus = ReadyStatus.PREPARING;
		this.location = "";
	}

	public static Delivery of(Long productId) {
		return new Delivery(productId);
	}

	public void release(String location) {
		if(this.readyStatus != ReadyStatus.PREPARING) {
			throw new IllegalStateException("출고할 수 없습니다.");
		}
		this.readyStatus = ReadyStatus.RELEASING;
		this.location = location;
	}

	public void ship(String location) {
		if(this.readyStatus == ReadyStatus.RELEASING) {
			this.readyStatus = ReadyStatus.DELIVERING;
		} else if(this.readyStatus != ReadyStatus.DELIVERING) {
			throw new IllegalStateException("배송이 불가능합니다.");
		}
		this.location = location;
	}

	public void complete() {
		if(this.readyStatus != ReadyStatus.DELIVERING) {
			throw new IllegalStateException("배송을 완료할 수 없습니다.");
		}
		this.readyStatus = ReadyStatus.COMPLETION;
	}


}
