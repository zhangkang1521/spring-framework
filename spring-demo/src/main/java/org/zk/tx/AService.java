package org.zk.tx;

import org.springframework.transaction.annotation.Transactional;

public interface AService {

	@Transactional
	void save() throws Exception;

}
