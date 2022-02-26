package com.lnt.bank.service;

import com.lnt.bank.model.Images;

public interface IImageService {
	public Images addImage(Images images);
	public Images getImage(Long AccountNo);
}
