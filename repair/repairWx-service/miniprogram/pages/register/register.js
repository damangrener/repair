// pages/register/register.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    randomAccount: '',
    serName: '',
    name: '',
    phone: '',
    pwd: '',
    pwd1: ''
  },
  phoneInput: function(e) {
    this.data.phone = e.detail.value
  },
  passwordInput: function(e) {
    this.data.pwd = e.detail.value
  },
  accountInput: function(e) {
    this.data.randomAccount = e.detail.value
  },
  serInput: function(e) {
    this.data.serName = e.detail.value
  },
  nameInput: function(e) {
    this.data.name = e.detail.value
  },
  passwordInput1: function(e) {
    this.data.pwd1 = e.detail.value
  },
  //注册
  register: function() {
    var that = this;
    if (this.data.randomAccount == '') {
      wx: wx.showToast({
        title: '请输入账号'
      })
    }
    else if (this.data.phone == '') {
      wx: wx.showToast({
        title: '请输入手机号'
      })
    }
    else if (!(/^((13[0-9])|(14[0-9])|(15[0-9])|(17[0-9])|(18[0-9]))\d{8}$/.test(this.data.phone))) {
      wx: wx.showToast({
        title: '手机号格式有误'
      })
    }
    else if (this.data.serName == '') {
      wx: wx.showToast({
        title: '请输入姓氏'
      })
    }
    else if (this.data.pwd == '') {
      wx: wx.showToast({
        title: '请输入密码'
      })
    }
    else if (this.data.pwd.length < 6) {
      wx: wx.showToast({
        title: '密码需大于6位'
      })
    }
    else if (this.data.pwd != this.data.pwd1) {
      wx: wx.showToast({
        title: '两次密码不一致'
      })
    }
    else {
      wx.request({
        url: app.globalData.host+'/api-user/api/user/signIn',
        method: 'POST',
        header: {
          'content-type': 'application/x-www-form-urlencoded'
        },
        // header: { 'content-type': 'application/json' },

        data: {
          account: this.data.randomAccount,
          pwd: this.data.pwd,
          phone: this.data.phone,
          surname: this.data.serName,
          name: this.data.name,
        },

        success: function(res) {
          console.log(res.data.data) // 服务器回包信息
          // that.setData({
          //   presentTime: res.data.data
          // })
          if (res.data.data.account == '2') {
            wx: wx.showToast({
              title: '手机号已注册过'
            })
          }
          else {
            wx.navigateTo({
              url: "../loginIn/loginIn?account=" + res.data.data.phone
            })
          }
        }
      })
    }
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var that = this
    that.setData({
      randomAccount: options.randomAccount
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