package com.vti.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "target", catalog = "ideal")

public class Target {
 
    public Target() {
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    @Column(name = "name_target", length = 100, nullable = false, unique = true)
	private String name_target;


	public String getName_target() {
		return name_target;
	}

	public void setName_target(String name_target) {
		this.name_target = name_target;
	}

	@Column(name = "completion_rate", length = 100, nullable = false, unique = true)
   	private String completion_rate;
    @Column(name = "image", length = 200, nullable = false, unique = true)
  	private String image;
    
  	private Date target_date_completed;
	
    private Date create_date;
	
	@ManyToOne
	@JoinColumn(name = "account_id", nullable = false)
	@Cascade(value = { CascadeType.REMOVE, CascadeType.SAVE_UPDATE })
	private Account account;

	@OneToMany(mappedBy = "target", fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.REMOVE, CascadeType.SAVE_UPDATE })
	private List<SmallLeg> SmallLegs;
	
    public List<SmallLeg> getSmallLegs() {
		return SmallLegs;
	}

	public void setSmallLegs(List<SmallLeg> smallLegs) {
		this.SmallLegs = smallLegs;
	}
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompletion_rate() {
		return completion_rate;
	}

	public void setCompletion_rate(String completion_rate) {
		this.completion_rate = completion_rate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getTarget_date_completed() {
		return target_date_completed;
	}

	public void setTarget_date_completed(Date target_date_completed) {
		this.target_date_completed = target_date_completed;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	


	

	
    
    
    
}
