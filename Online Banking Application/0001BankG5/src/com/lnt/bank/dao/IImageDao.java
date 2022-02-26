package com.lnt.bank.dao;

import com.lnt.bank.model.Images;

public interface IImageDao {
	public Images addImage(Images images);
	public Images getImage(Long AccountNo);
}
