/**
 * Copyright 2014-2019 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.webank.webase.front.precompiledapi;

import com.alibaba.fastjson.JSON;
import com.webank.webase.front.base.enums.PrecompiledTypes;
import com.webank.webase.front.util.AbiUtil;
import org.fisco.bcos.web3j.protocol.core.methods.response.AbiDefinition;
import org.junit.Test;

import java.util.List;

public class PrecompiledCommonTest {

	@Test
	public void testCommonInfo() {
		String abiStr = PrecompiledCommonInfo.getAbi(PrecompiledTypes.PERMISSION);
		List<Object> contractAbi = JSON.parseArray(abiStr);
		String funcName = PrecompiledCommonInfo.FUNC_INSERT;
		AbiDefinition abiDefinition = AbiUtil.getAbiDefinition(funcName, JSON.toJSONString(contractAbi));
	}


}
