// pages/loginIn/loginIn.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    account: '',
    pwd: ''
  },
  phoneInput: function(e) {
    this.data.account = e.detail.value
  },
  passwordInput: function(e) {
    this.data.pwd = e.detail.value
  },
  login: function() {
    wx.showLoading({
      title: '登陆中。。。',
      mask: true
    })
    var that = this;
    wx.request({
      url: app.globalData.host +'/api-user/api/user/loginIn',
      method: 'POST',
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      data: {
        accountOrPhone: this.data.account,
        pwd: this.data.pwd
      },
      success: function(res) {
        console.log(res.data.data) // 服务器回包信息
        if (res.data.data != null && res.data.code == 200) {
          wx: wx.showToast({
            title: '欢迎'
          })
          wx.clearStorage('Authorization');
          wx.setStorage({
            key: 'Authorization',
            data: res.data.data.map.token,
            success: function(res) {
              wx.switchTab({
                url: '../repair/repair'
              })
            }
          })
          wx.setStorage({
            key: 'userInfo',
            data: res.data.data,
          })
        }
        else {
          wx: wx.showToast({
            title: '登录失败，请重试'
          })
        }
      }
    })
  },
  //点击注册获取随机账号
  register: function() {
    wx.showLoading({
      title: '生成账号中',
      mask: true
    })
    var that = this;
    wx.request({
      url: app.globalData.host +'/api-user/api/user/getAccount',
      method: 'GET',
      success: function(res) {
        console.log(res.data) // 服务器回包信息
        that.setData({
          randomAccount: res.data.data
        })
        wx.navigateTo({
          url: "../register/register?randomAccount=" + res.data.data
        })
        wx.hideLoading()
      }

    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var that = this
    that.setData({
      account: options.account
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  }
})