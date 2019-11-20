package com.thp.spring.projetfinal.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "files")
public class DBFile {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	private String fileName;

	private String fileType;

	@Lob
	private byte[] data;

	@OneToOne(mappedBy = "dbFile")
	private TacheMissionEntity tacheMission;

	public DBFile(String fileName, String fileType, byte[] data, TacheMissionEntity tacheMission) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
		this.tacheMission = tacheMission;
	}

	public DBFile(String id, String fileName, String fileType, byte[] data, TacheMissionEntity tacheMission) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
		this.tacheMission = tacheMission;
	}

	public DBFile(String fileName, String fileType, byte[] data) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
	}

	public DBFile() {
		super();

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public TacheMissionEntity getTacheMission() {
		return tacheMission;
	}

	public void setTacheMission(TacheMissionEntity tacheMission) {
		this.tacheMission = tacheMission;
	}

}
