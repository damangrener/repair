// pages/jtc/jtc.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    jcTime: '',
    order: '',
    over: '',
    desc: '',
    wxTime: '',
    address: '',
    appointTime: ''
  },
  descInput: function (e) {
    this.data.desc = e.detail.value
    // console.log(this.data.desc)
  },
  present: function (e) {
    var that = this;
    wx.request({
      url: app.globalData.host + '/api-service/api/service/signIn',
      data: {
        repairOrder: this.data.order,
        status: 3
      },
      method: 'POST',
      header: {
        'content-type': 'application/x-www-form-urlencoded',
        "Authorization": wx.getStorageSync('Authorization')
      },
      success: function (res) {
        console.log(res.data) // 服务器回包信息
        that.setData({
          presentTime: res.data.data
        })
      }

    })
  },
  over: function (e) {
    var that = this;
    wx.request({
      url: app.globalData.host + '/api-service/api/service/signIn',
      data: {
        repairOrder: this.data.order,
        status: 4
      },
      method: 'POST',
      header: {
        'content-type': 'application/x-www-form-urlencoded',
        "Authorization": wx.getStorageSync('Authorization')
      },
      success: function (res) {
        console.log(res.data) // 服务器回包信息
        if (res.data.code == 200) {
          that.setData({
            over: '订单状态已更新为完成'
          })
        }
      }

    })
  },
  cannotOver: function (e) {
    var that = this;
    wx.request({
      url: app.globalData.host + '/api-service/api/service/signIn',
      data: {
        repairOrder: this.data.order,
        status: 5
      },
      method: 'POST',
      header: {
        'content-type': 'application/x-www-form-urlencoded',
        "Authorization": wx.getStorageSync('Authorization')
      },
      success: function (res) {
        console.log(res.data) // 服务器回包信息
        if (res.data.code == 200) {
          that.setData({
            over: '订单状态已更新为无法解决'
          })
        }
      }

    })
  },
  leave: function (e) {
    var that = this;
    wx.request({
      url: app.globalData.host + '/api-service/api/service/leave',
      data: {
        repairOrder: this.data.order,
        status: 6,
        desc: this.data.desc
      },
      method: 'POST',
      header: {
        'content-type': 'application/x-www-form-urlencoded',
        "Authorization": wx.getStorageSync('Authorization')
      },
      success: function (res) {
        console.log(res.data) // 服务器回包信息
        if (res.data.code == 200) {
          that.setData({
            wxTime: res.data.data
          })
        }
      }

    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this
    that.setData({
      order: options.order,
      appointTime: options.appointTime,
      address: options.address
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})