package com.cos.blog.model;

import java.sql.Timestamp;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity //User 클래스가 속성들을 읽어서 자동으로 MySql 에 테이블에 생성이 된다.
public class User {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	private int id; // auto_increment 전략
	
	@Column(nullable = false, length = 30)
	private String username;
	
	@Column(nullable = false, length = 100) // 해쉬로 변경하기에 넉넉하게
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
	@ColumnDefault("'user'")
	private String role; // Enum을 쓰는게 좋다.
	// Enum을 쓰면 기본적으로 도메인을 만들어 줄 수 있음
	// admin, user, manage
	// 위처럼 중요한 권한을 스트링으로 주면 위험할 수 있음
	// 그래서 위 3개 중 하나만 들어갈 수 있도록 도메인을 줄 수 있다. 범
	
	@CreationTimestamp // 시간이 자동 입력
	private Timestamp createDate;
}
