package com.lnt.bank.dao;

import java.sql.Blob;

import org.springframework.web.multipart.MultipartFile;

public interface IBlobDao {
	public Blob blobFormer(MultipartFile file);
}
