package com.assignment.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="blogs")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Blog {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	private String blogName;
	private String body;
}
