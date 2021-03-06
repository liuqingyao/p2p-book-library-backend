package org.springside.examples.bootapi.api;

import java.util.Collections;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springside.examples.bootapi.domain.Account;
import org.springside.examples.bootapi.dto.AccountDto;
import org.springside.examples.bootapi.dto.CredentialDto;
import org.springside.examples.bootapi.service.AccountService;
import org.springside.examples.bootapi.service.exception.ErrorCode;
import org.springside.examples.bootapi.service.exception.ServiceException;
import org.springside.modules.constants.MediaTypes;
import org.springside.modules.mapper.BeanMapper;

// Spring Restful MVC Controller的标识, 直接输出内容，不调用template引擎.
@RestController
public class AccountEndPoint {

	private static Logger logger = LoggerFactory.getLogger(AccountEndPoint.class);

	@Autowired
	private AccountService accountServcie;

    @RequestMapping(value = "/api/tokens", produces = MediaTypes.JSON_UTF_8)
    public AccountDto getByToken(@RequestParam(value = "token", required = true) String token) {
        Account currentUser = accountServcie.getLoginUser(token);
        return BeanMapper.map(currentUser, AccountDto.class);
    }

	@RequestMapping(value = "/api/accounts/login", produces = MediaTypes.JSON_UTF_8)
	public Map<String, String> login(@RequestParam("email") String email, @RequestParam("password") String password) {

		if (StringUtils.isEmpty(email) || StringUtils.isEmpty(password)) {
			throw new ServiceException("User or password empty", ErrorCode.BAD_REQUEST);
		}

		String token = accountServcie.login(email, password);

		return Collections.singletonMap("token", token);
	}

	@RequestMapping(value = "/api/accounts/logout")
	public void logout(@RequestParam(value = "token", required = false) String token) {
		accountServcie.logout(token);
	}

	@RequestMapping(value = "/api/accounts", method = RequestMethod.POST, consumes = MediaTypes.JSON_UTF_8)
	public ResponseEntity<?> register(@RequestBody final CredentialDto credentialDto) {

		if (StringUtils.isEmpty(credentialDto.email) || StringUtils.isEmpty(credentialDto.name) || StringUtils.isEmpty(credentialDto.password)) {
			throw new ServiceException("User or name or password empty", ErrorCode.BAD_REQUEST);
		}

		accountServcie.register(credentialDto.email, credentialDto.name, credentialDto.password);
        return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
