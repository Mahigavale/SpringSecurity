package com.Security.Entity;

import org.aspectj.lang.annotation.DeclareWarning;
import org.hibernate.annotations.Cascade;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class Cricketer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cricketerid;
	
	private String cricktername;
	private String cricketerteam;
	private String creciketernumber;
	
	@JoinColumn
	@OneToOne
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Cricketerfamily family;

	public int getCricketerid() {
		return cricketerid;
	}

	public void setCricketerid(int cricketerid) {
		this.cricketerid = cricketerid;
	}

	public String getCricktername() {
		return cricktername;
	}

	public void setCricktername(String cricktername) {
		this.cricktername = cricktername;
	}

	public String getCricketerteam() {
		return cricketerteam;
	}

	public void setCricketerteam(String cricketerteam) {
		this.cricketerteam = cricketerteam;
	}

	public String getCreciketernumber() {
		return creciketernumber;
	}

	public void setCreciketernumber(String creciketernumber) {
		this.creciketernumber = creciketernumber;
	}

	public Cricketerfamily getFamily() {
		return family;
	}

	public void setFamily(Cricketerfamily family) {
		this.family = family;
	}
	
	
	
}
