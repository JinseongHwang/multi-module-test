package study.jscode.delivery.domain;

import lombok.Getter;

@Getter
public enum ReadyStatus {
	PREPARING("배송준비중"), RELEASING("출고"), DELIVERING("배송중"), COMPLETION("배송완료");
	private final String message;

	ReadyStatus(String message) {
		this.message = message;
	}
}
