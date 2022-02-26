package com.lnt.bank.service;

import java.sql.Blob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.lnt.bank.dao.IBlobDao;

@Service
public class BlobService implements IBlobService {
 IBlobDao blobDao;
 
	
	
	public IBlobDao getBlobDao() {
	return blobDao;
   }

@Autowired
public void setBlobDao(IBlobDao blobDao) {
	this.blobDao = blobDao;
}



	@Override
	@Transactional
	public Blob blobFormer(MultipartFile file) {
		// TODO Auto-generated method stub
		return blobDao.blobFormer(file);
	}

}
