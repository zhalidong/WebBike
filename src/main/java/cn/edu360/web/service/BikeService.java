package cn.edu360.web.service;

import cn.edu360.web.pojo.Bike;

import java.util.List;


public interface BikeService {

	Bike getById(Long id);

	List<Bike> findAll();

	void save(Bike bike);

	void deleteByIds(Long[] ids);

	void update(Bike Bike);

}
