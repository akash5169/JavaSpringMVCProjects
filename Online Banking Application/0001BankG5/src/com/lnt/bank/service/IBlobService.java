package com.lnt.bank.service;

import java.sql.Blob;

import org.springframework.web.multipart.MultipartFile;

public interface IBlobService {

	public Blob blobFormer(MultipartFile file);
}
