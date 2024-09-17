package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob
	private String content; 
	
	@ColumnDefault("0")
	private int count;
	
	@ManyToOne // Many = Board, User = One. 연관관계 설정
	@JoinColumn(name="userId")
	private User user;
	// DB는 오브젝트를 저장할 수 없어서 FK를 사용하는데, 자바는 오브젝트를 저장가능
	// 그럼 서로 충돌이 남.그래서 자바가 DB에 맞춰서 키값을 저장하게 되는건데
	// ORM 을 사용하면 키값,포린키로 찾는게 아니라 그냥 오브젝트 넣으면 된다.
	
	@OneToMany
	@JoinColumn(name="replyId")
	private List<Reply> reply;
	
	@CreationTimestamp
	private Timestamp createDate;
}
