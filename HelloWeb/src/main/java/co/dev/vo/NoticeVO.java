package co.dev.vo;

import java.util.Date;

import lombok.Data;

@Data
public class NoticeVO {
	// notice 테이블의 데이터를 담아놓기 위한 객체.
	private int noticeId; //notice_id
	private String noticeWriter; //notice_writer
	private String noticeTitle; //notice_title
	private String noticeSubject; //notice_subject
	private Date createDate; //create_date
	private int hitCount; //hit_count
	private String attach; //attach
	
}
