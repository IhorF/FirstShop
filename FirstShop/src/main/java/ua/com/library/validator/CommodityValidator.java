package ua.com.library.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.library.dao.CommodityDao;
import ua.com.library.entity.Commodity;

@Component("commodityValidator")
public class CommodityValidator implements Validator {
	@Autowired
	private CommodityDao commodityDao;

	@Override
	public void validate(Object object) throws Exception {
		Commodity commodity = (Commodity) object;
		if (commodityDao.commodityExistsByArticul(commodity.getArticul())) {
			throw new ValidationException(ValidationMessages.ARTICUL_ALREADY_EXIST);
		}
		if (commodity.getPrice() == 0) {
			throw new ValidationException(ValidationMessages.PRICE_IS_NULL);
		}
		if (commodity.getArticul().isEmpty()) {
			throw new ValidationException(ValidationMessages.EMPTY_ARTICUL_FIELD);
		}
	}
}
