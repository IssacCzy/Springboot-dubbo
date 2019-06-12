package org.spring.springboot.dubbo.impl;

import org.spring.springboot.domain.City;
import org.spring.springboot.dubbo.CityDubboService;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
@Component
public class CityDubboServiceImpl implements CityDubboService {

    public City findCityByName(String cityName) {
        return new City(1L,2L,"温岭","是我的故乡");
    }
}
