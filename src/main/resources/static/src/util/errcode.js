/*
 * Copyright 2014-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
let errCode = {
    "101001": {
        en: "system error",
        cn: '系统异常'
    },
    "101002": {
        en: "param valid fail",
        cn: '参数校验异常'
    },
    "102000": {
        en: "system exception",
        cn: '系统异常'
    },
    

    "201001": {
        en: "groupId cannot be empty",
        cn: 'groupId不能为空'
    },
    "201002": {
        en: "user cannot be empty",
        cn: '用户编号不能为空'
    },
    "201003": {
        en:  "useAes cannot be empty",
        cn: 'useAes不能为空'
    },
    "201004": {
        en: "version cannot be empty",
        cn: '版本号不能为空'
    },
    "201005": {
        en: "funcName cannot be empty",
        cn: '方法名不能为空'
    },
    "201006": {
        en: "abiInfo cannot be empty",
        cn: 'abi内容不能为空'
    },
    "201007": {
        en: "contractBin cannot be empty",
        cn: '合约bin不能为空'
    },
    "201008": {
        en: "contract's current version has been deployed",
        cn: '合同的当前版本已部署'
    },
    "201009": {
        en: "contract is not deployed",
        cn: '合约未部署'
    },
    "201010": {
        en: "save abi error",
        cn: 'abi保存错误'
    },
    "201011": {
        en: "contract's parameter is error",
        cn: '合约参数错误'
    },
    "201012": {
        en: "requst blockNumber is greater than latest",
        cn: '请求块高大于最新块高'
    },
    "201013": {
        en: "get abi from chain error",
        cn: '从链上获取abi失败'
    },
    "201014": {
        en: "contract deploy error",
        cn: '合约部署错误'
    },
    "201015": {
        en: "user's privateKey is null",
        cn: '用户私钥为空'
    },
    "201016": {
        en: "file is not exist",
        cn: '文件不存在'
    },
    "201017": {
        en: "failed to get node config",
        cn: '获取节点配置失败'
    },
    "201018": {
        en: "blockNumber and pbftView unchanged",
        cn: '块高和pbftview没有发生变化'
    },
    "201019": {
        en: "request function is error",
        cn: '请求错误'
    },
    "201020": {
        en: "transaction query from chain failed",
        cn: '链中的事务查询失败'
    },
    "201021": {
        en: "transaction send to chain failed",
        cn: '事务发送到链失败'
    },
    "201022": {
        en: "node request failed",
        cn: '节点请求失败'
    },
    "201023": {
        en: "contract already exists",
        cn: '合同已存在'
    },
    "201024": {
        en: "contract name cannot be repeated",
        cn: '合同名称不能重复'
    },
    "201025": {
        en: "invalid contract id",
        cn: '合同ID无效'
    },
    "201026": {
        en: "contract has been deployed",
        cn: '合同已部署'
    },
    "201027": {
        en: "send abiInfo fail",
        cn: '发送abi失败'
    },
    "201028": {
        en: "contractbin is null",
        cn: '合约bin为空'
    },
    "201029": {
        en: "contractAddress is null",
        cn: '合约地址为空'
    },
    "201030": {
        en: "contractAddress invalid",
        cn: '合约地址无效'
    },
    "201031": {
        en: "privateKey decode fail",
        cn: '私钥解码失败'
    },
    "201032": {
        en: "not found config of keyServer",
        cn: '找不到keyServer的配置'
    },
    "201033": {
        en: "cloud sign fail",
        cn: '云标志失败'
    },
    "201034": {
        en: "groupId not exist",
        cn: 'groupId不存在'
    },
    "201035": {
        en: "version and address cannot all be  null",
        cn: '合约地址不能为空'
    },
    // "201036": {
    //     en: "contract no change",
    //     cn: '合约没有改变'
    // },
    "202000": {
        en: "invalid node info",
        cn: '无效的节点信息'
    },
    "202001": {
        en: "database exception",
        cn: '数据库异常'
    },
    "202002": {
        en: "organization already exists",
        cn: '组织已经存在'
    },
    "202003": {
        en: "organization not exists",
        cn: '组织信息不存在'
    },
    "202004": {
        en: "node already exists",
        cn: '节点已经存在'
    },
    "202005": {
        en: "network id cannot be empty",
        cn: '网络编号不能为空'
    },
    "202006": {
        en: "invalid network id",
        cn: '无效的网络编号'
    },
    "202007": {
        en: "organization id cannot be empty",
        cn: '组织编号不能为空'
    },
    "202008": {
        en: "invalid organization id",
        cn: '无效的组织编号'
    },
    "202009": {
        en: "network_organization_mapping already exists",
        cn: '已有该网络和组织的关联'
    },
    "202010": {
        en: "network_organization_mapping not exist",
        cn: '没有该组织和网络的关联信息'
    },
    "202011": {
        en: "did not find the current organization",
        cn: '未找到本组织信息'
    },
    "202012": {
        en: "user id cannot be empty",
        cn: '用户编号不能为空'
    },
    "202013": {
        en: "invalid user id",
        cn: '无效的用户编号'
    },
    "202014": {
        en: "user already exists",
        cn: '用户信息已经存在'
    },
    "202015": {
        en: "contract already exists",
        cn: '合约信息已经存在'
    },
    "202016": {
        en: "contract id cannot be empty",
        cn: '合约编号不能为空'
    },
    "202017": {
        en: "invalid contract id",
        cn: '无效的合约编号'
    },
    "202018": {
        en: "invalid param info",
        cn: '无效的入参信息'
    },
    "202019": {
        en: "did not find node info",
        cn: '未找到节点信息'
    },
    "202020": {
        en: "current organization already exist",
        cn: '已存在本组织信息'
    },
    "202021": {
        en: "invalid organization type",
        cn: '无效的组织类型'
    },
    "202022": {
        en: "unable to delete deployed contract",
        cn: '不能删除已部署的合约'
    },
    "202023": {
        en: "node ip cannot be empty",
        cn: '节点编号不能为空'
    },
    "202024": {
        en: "node p2p port cannot be empty",
        cn: '节点p2p端口不能为空'
    },
    "202025": {
        en: "did not find node log",
        cn: '找不到节点日志'
    },
    "202026": {
        en: "account info already exists",
        cn: '该帐号已经存在'
    },
    "202027": {
        en: "ccount info not exists",
        cn: '该帐号不存在'
    },
    "202028": {
        en: "account name empty",
        cn: '帐号名称不能为空'
    },
    "202029": {
        en: "invalid account name",
        cn: '无效的账号名称'
    },
    "202030": {
        en: "password error",
        cn: '密码错误'
    },
    "202031": {
        en: "role id cannot be empty",
        cn: '角色编号不能为空'
    },
    "202032": {
        en: "invalid role id",
        cn: '无效的角色编号'
    },
    "202033": {
        en: "invalid attr",
        cn: '无效的attr值'
    },
    "202034": {
        en: "login fail",
        cn: '登录失败'
    },
    "202035": {
        en: "contract has been deployed",
        cn: '该合约已经部署'
    },
    "202036": {
        en: "publicKey cannot be empty",
        cn: '公钥不能为空'
    },
    "202037": {
        en: "user does not exist",
        cn: '用户信息不存在'
    },
    "202038": {
        en: "interface does not exist",
        cn: '接口不存在'
    },
    "202039": {
        en: "do not save this block height",
        cn: '不保存该块高信息'
    },
    "202040": {
        en: "contract deploy not success",
        cn: '合约部署失败'
    },
    "202041": {
        en: "invalid user index",
        cn: '不能删除已部署的合约'
    },
    "202042": {
        en: "invalid contract index",
        cn: '无效的合约索引'
    },
    "202043": {
        en: "did not found system contract:contractDetail",
        cn: '找不到系统合约【contractDetail】'
    },
    "202044": {
        en: "did not found system contract:user",
        cn: '找不到系统合约【user】'
    },
    "202045": {
        en: "the new password cannot be same as old",
        cn: '新旧密码不能一致'
    },
    "202046":{
        en: "contract has not compiled",
        cn: "合约的abi或bin不存在"
    },
    "202047":{
        en: "did not found system contract:node",
        cn: "找不到系统合约【node】"
    },
    "202048":{
        en: "invalid node index",
        cn: "无效的节点索引"
    },
    "202049":{
        en: "contract name is empty",
        cn: "合约名为空"
    },
    "202050": {
        en: "publicKey's length is 130,address's length is 42",
        cn: "公钥长度为130，公钥地址长度为42"
    },
    "202051": {
        en: "invalid node ip",
        cn: "IP或者端口错误"
    },
    "202052": {
        en: "did not find current node info",
        cn: "找不到当前节点信息"
    },
    "202053": {
        en: "system user has not been initialized yet",
        cn: "系统用户尚未初始化"
    },
    "202054": {
        en: "contract had not deploy",
        cn: "合约尚未部署"
    },
    "202055": {
        en: "invalid contract",
        cn: "无效的合约"
    },
    "202058": {
        en: "not support transaction",
        cn: "不支持发交易"
    },

    "302000": {
        en: "user not logged in",
        cn: '未登录的用户'
    },
    "302001":{
        en: "access denied",
        cn: "没有权限"
    },
}
export default {
    errCode
}