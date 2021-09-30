package com.vti.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "small_leg", catalog = "ideal")
public class SmallLeg {
	public SmallLeg() {

	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "small_leg", length = 100, nullable = false, unique = true)
	private String small_leg;
    private Date start_day;
    private Date finish_day;
    
	@ManyToOne
	@JoinColumn(name = "target_id", nullable = false)
	@Cascade(value = { CascadeType.REMOVE, CascadeType.SAVE_UPDATE })
	private Target target;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSmall_leg() {
		return small_leg;
	}

	public void setSmall_leg(String small_leg) {
		this.small_leg = small_leg;
	}

	public Date getStart_day() {
		return start_day;
	}

	public void setStart_day(Date start_day) {
		this.start_day = start_day;
	}

	public Date getFinish_day() {
		return finish_day;
	}

	public void setFinish_day(Date finish_day) {
		this.finish_day = finish_day;
	}

	public Target getTarget() {
		return target;
	}

	public void setTarget(Target target) {
		this.target = target;
	}
}
