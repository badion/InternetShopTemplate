package ua.internetshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = AbsentGoods.GOODS_IS_ABSENT_IN_DATABASE)
public class AbsentGoods extends RuntimeException {

	static final String GOODS_IS_ABSENT_IN_DATABASE = "Goods is absent in database";

	private static final long serialVersionUID = 1L;

}
