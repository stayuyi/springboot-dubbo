package com.yy.provider1.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * TODO 2019/3/22
 *
 * @author yuyi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseException extends RuntimeException {
	private String errorCode;
	private String errMsg;
}
