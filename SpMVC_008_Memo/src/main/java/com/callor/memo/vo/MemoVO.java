package com.callor.memo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemoVO {

	private int m_seq;
	private String m_author;
	private String m_data;
	private String m_time;
	private String m_memo;
	private String m_image;

}
