package com.app.bps.entity;

import java.sql.Timestamp;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Mark entity
 * 
 * @author parth
 *
 */

@Entity
@Table(name = "MARKS")
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Mark {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MARK_ID")
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STUDENT_ID")
	@JsonBackReference
	private Student student;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUBJECT_ID")
	private Subject subject;

	@Column(name = "CREATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Timestamp timestamp;

	@Column(name = "MARK")
	private int mark;
	
	
	@PrePersist
    protected void onCreate() {
        timestamp = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    protected void onUpdate() {
        timestamp = new Timestamp(System.currentTimeMillis());
    }
}
