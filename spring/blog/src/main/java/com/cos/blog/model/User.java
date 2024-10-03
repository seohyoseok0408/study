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
	
	@Column(nullable = false, length = 30, unique = true)
	private String username;
	
	@Column(nullable = false, length = 100) // 해쉬로 변경하기에 넉넉하게
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
	@Enumerated(EnumType.STRING) // DB는 RoleType이란게 없으니 String 이라고 알리기
	private RoleType role; 
	
	@CreationTimestamp 
	private Timestamp createDate;
}
