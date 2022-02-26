package com.lnt.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lnt.bank.dao.IImageDao;
import com.lnt.bank.model.Images;

@Service
public class ImageService implements IImageService {

	private IImageDao imageDao;
	
	public IImageDao getImageDao() {
		return imageDao;
	}

	@Autowired
	public void setImageDao(IImageDao imageDao) {
		this.imageDao = imageDao;
	}

	@Override
	@Transactional
	public Images addImage(Images images) {
		// TODO Auto-generated method stub
		return this.imageDao.addImage(images);
	}

	@Override
	@Transactional
	public Images getImage(Long AccountNo) {
		// TODO Auto-generated method stub
		return this.imageDao.getImage(AccountNo);
	}

}
