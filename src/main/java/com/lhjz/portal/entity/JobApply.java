/**
 * 立衡脊柱版权所有 (lhjz)
 */
package com.lhjz.portal.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.validator.constraints.NotBlank;

import com.lhjz.portal.pojo.Enum.Status;

/**
 * 
 * @author xi
 * 
 * @date 2015年3月28日 下午2:03:20
 * 
 */
@Entity
public class JobApply implements Serializable {

	/** serialVersionUID (long) */
	private static final long serialVersionUID = -7244230054736049452L;

	@Id
	@GeneratedValue
	private Long id;

	// 申请人
	@NotBlank
	private String claimer;
	private String phone;
	private String mail;
	private String address;
	@Column(length = 16777216)
	private String content;
	// 简历
	private String resume;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Status status = Status.Normal;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	@Version
	private long version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClaimer() {
		return claimer;
	}

	public void setClaimer(String claimer) {
		this.claimer = claimer;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "JobApply [id=" + id + ", claimer=" + claimer + ", phone="
				+ phone + ", mail=" + mail + ", address=" + address
				+ ", content=" + content + ", resume=" + resume + ", status="
				+ status + ", createDate=" + createDate + ", version="
				+ version + "]";
	}

}
