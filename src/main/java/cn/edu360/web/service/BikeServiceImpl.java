package cn.edu360.web.service;

import cn.edu360.web.dao.mapper.BikeMapper;
import cn.edu360.web.pojo.Bike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service
public class BikeServiceImpl implements BikeService {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private BikeMapper bikeMapper;
	
	@Override
	public Bike getById(Long id) {
		return bikeMapper.getById(id);
	}

	@Override
	public List<Bike> findAll() {
		//调用mongo的模板查找数据，然后将数据
		return mongoTemplate.findAll(Bike.class);
	}

	@Override
	public void save(Bike Bike) {
		mongoTemplate.save(Bike);
	}

	@Override
	public void deleteByIds(Long[] ids) {
		bikeMapper.deleteByIds(ids);
	}

	@Override
	public void update(Bike Bike) {
		bikeMapper.update(Bike);
	}

}
