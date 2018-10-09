package org.library.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="Books")
public class Book {

	@Id
	@Column(name = "Code", nullable = false)
	private int code;
	
	@Column(name = "Name", length = 255, nullable = false)
	private String name;
	
	@Column(name = "Author", length = 255, nullable = false)
	private String author;
	
	@Column(name = "Version", nullable = false)
	private double version;
	
/*	@Lob
    @Column(name = "Image", length = Integer.MAX_VALUE, nullable = true)
	private byte[] image;
	
*/	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Create_Date", nullable = false)
	@Transient
	private Date createDate;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getVersion() {
		return version;
	}
	public void setVersion(double version) {
		this.version = version;
	}
/*	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
*/	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
