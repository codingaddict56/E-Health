package com.ehealth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payment")
public class Payment 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="appointmentid")
	private int apid;
	@Column(name="ahname")
	private String ahname;
	@Column(name="upiid")
	private String upiid;
	@Column(name="eaccno")
	private String eaccno;
	@Column(name="uaccno")
	private String uaccno;
	@Column(name="ctype")
	private String ctype;
	@Column(name="cvv")
	private String cvv;
	@Column(name="cardex")
	private String cardex;
	@Column(name="cardnum")
	private String cardnum;
	@Column(name="amount")
	private int amount;
	public int getApid() {
		return apid;
	}
	public void setApid(int apid) {
		this.apid = apid;
	}
	public String getAhname() {
		return ahname;
	}
	public void setAhname(String ahname) {
		this.ahname = ahname;
	}
	public String getUpiid() {
		return upiid;
	}
	public void setUpiid(String upiid) {
		this.upiid = upiid;
	}
	public String getEaccno() {
		return eaccno;
	}
	public void setEaccno(String eaccno) {
		this.eaccno = eaccno;
	}
	public String getUaccno() {
		return uaccno;
	}
	public void setUaccno(String uaccno) {
		this.uaccno = uaccno;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getCardex() {
		return cardex;
	}
	public void setCardex(String cardex) {
		this.cardex = cardex;
	}
	public String getCardnum() {
		return cardnum;
	}
	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Payment(int apid, String ahname, String upiid, String eaccno, String uaccno, String ctype, String cvv,
			String cardex, String cardnum, int amount) {
		super();
		this.apid = apid;
		this.ahname = ahname;
		this.upiid = upiid;
		this.eaccno = eaccno;
		this.uaccno = uaccno;
		this.ctype = ctype;
		this.cvv = cvv;
		this.cardex = cardex;
		this.cardnum = cardnum;
		this.amount = amount;
	}
	public Payment() {
		super();
	}
	
	
}
