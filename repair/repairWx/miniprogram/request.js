//这里是你备案的域名信息
var host = 'https://localhost:9020';

var tokenKey = "Authorization";
// 登录地址, 根据这个地址来设置token
var logInUrl = "/api-user/api/user/loginIn";
// 例外不用token的地址
var exceptionAddrArr = [
  'http://localhost:9020/api-user/api/user',
];
/**
 * POST请求，
 * URL：接口
 * data：参数，json类型
 * success：成功的回调函数
 * fail：失败的回调函数
 */
function postData(requestHandler) {
  wx.request({
    //项目的真正接口，通过字符串拼接方式实现
    url: host + requestHandler.url,
    header: {
      "content-type": "application/json;charset=UTF-8"
    },
    data: requestHandler.data,
    method: 'POST',
    success: function (res) {
      if (url === logInUrl) {
        wx.setStorage({
          key: tokenKey,
          data: res.data.data.token
        })
      }
      //直接将返回的数据传入
      requestHandler.success(res.data);
    },
    fail: function () {
      requestHandler.fail();
    },
  })
}

//GET请求，直接URL调用，在url后面加参数
function getData(requestHandler) {
  wx.request({
    url: host + requestHandler.url,
    header: {
      "content-type": "application/json;charset=UTF-8"
    },
    method: 'GET',
    success: function (res) {
      requestHandler.success(res.data);
    },
    fail: function () {
      requestHandler.fail();
    },
  })
}

/**
 * module.exports用来导出代码
 */
module.exports.postData = postData;
module.exports.getData = getData;
