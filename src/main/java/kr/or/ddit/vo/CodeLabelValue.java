package kr.or.ddit.vo;

import lombok.Data;

@Data
public class CodeLabelValue {

	private String label;
	private String value;
	
	public CodeLabelValue() {
		super();
	}
	public CodeLabelValue(String label,String value) {
		this.label = label; // 값
		this.value = value;	// 키
	}
}
