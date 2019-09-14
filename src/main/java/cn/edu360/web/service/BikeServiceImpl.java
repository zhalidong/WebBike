package cn.edu360.web.service;

import cn.edu360.web.dao.mapper.BikeMapper;
import cn.edu360.web.pojo.Bike;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.data.mongodb.core.query.Query;
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

	@Override
	public GeoResults<Bike> findNear(double longitude, double latitude) {
		//查找附近200米的未使用的单车,要求只显示最近的10辆
		NearQuery nearQuery = NearQuery.near(longitude,latitude,Metrics.KILOMETERS);
		nearQuery.maxDistance(0.2).query(new Query().addCriteria(Criteria.where("status").is(0)).limit(10));
		//GeoResults 不但封装了要查找的单车数据,还封装了距离
		GeoResults<Bike> bikes = mongoTemplate.geoNear(nearQuery, Bike.class);
		return bikes;
	}
}
