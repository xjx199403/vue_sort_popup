

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
测试controller
**/
@RestController
@RequestMapping("/api")
public class CityDataController {
	
	@Autowired
	private CityDataMapper cityDataMapper;


	@PostMapping("/getData")
	public PageData<dataResult> getRouterIndexList(@RequestBody paramQuery paramQuery) {
		Page<dataResult> page = cityDataMapper.listQuery(paramQuery,paramQuery.Pageable());
		return new PageData<>(page);
	}
	
}


