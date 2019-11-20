package com.thp.spring.projetfinal.dto;

import java.util.Arrays;

import com.thp.spring.projetfinal.entities.TacheMissionEntity;

public class DBFileDTO extends MyDTO {

	private String id;
	private String fileName;
	private String fileType;
	private byte[] data;
	private TacheMissionEntity tacheMission;

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

	public DBFileDTO(String id, String fileName, String fileType, byte[] data, TacheMissionEntity tacheMission) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
		this.tacheMission = tacheMission;
	}

	public DBFileDTO(String fileName, String fileType, byte[] data, TacheMissionEntity tacheMission) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
		this.tacheMission = tacheMission;
	}

	public DBFileDTO() {
		super();
	}

	@Override
	public String toString() {
		return "DBFileDTO [id=" + id + ", fileName=" + fileName + ", fileType=" + fileType + ", data="
				+ Arrays.toString(data) + ", tacheMission=" + tacheMission + "]";
	}

}
