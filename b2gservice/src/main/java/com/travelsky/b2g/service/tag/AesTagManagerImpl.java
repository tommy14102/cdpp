package com.travelsky.b2g.service.tag;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.travelsky.b2g.interfaces.tag.AesTagManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


@Component("aesTagManager")
public class AesTagManagerImpl implements AesTagManager {
	
	private static final Logger log = LoggerFactory.getLogger(AesTagManagerImpl.class);


	@Override
	public String getMessage(String bundle, String key, String defalut) throws Exception {
		return null;
	}

	@Override
	public String getMessage(String bundle, String key, String defalut, Object[] args) throws Exception {
		return null;
	}

	@Override
	public String getMessage(String locale, String bundle, String key, String defalut) throws Exception {
		return null;
	}

	@Override
	public String getMessage(String locale, String airline, String bundle, String key, String defalut, Object[] objArray) throws Exception {
		return null;
	}

	@Override
	public Map<String, String> loadTagInfo_AES() {
		return null;
	}

	@Override
	public void refreshAll() throws Exception {

	}
}
