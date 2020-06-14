// pages/orderLog/orderLog.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    order: '',
    img1: 'cloud://wtf-qw2i7.7774-wtf-qw2i7-1301635625/cloudImg/jxz.png',
    img2: 'cloud://wtf-qw2i7.7774-wtf-qw2i7-1301635625/cloudImg/jxz.png',
    img3: 'cloud://wtf-qw2i7.7774-wtf-qw2i7-1301635625/cloudImg/jxz.png',
    img4: 'cloud://wtf-qw2i7.7774-wtf-qw2i7-1301635625/cloudImg/jxz.png',
    orderVo: '',
    order1: '',
    order2: '',
    order3: '',
    order4: '',
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var that = this
    var img1s = ['cloud://wtf-qw2i7.7774-wtf-qw2i7-1301635625/cloudImg/jxz.png', 'cloud://wtf-qw2i7.7774-wtf-qw2i7-1301635625/cloudImg/ywc.png']
    that.setData({
      order: options.order
    })
    wx.request({
      url: app.globalData.host +'/api-service/api/service/getOrderLog',
      data: {
        order: this.data.order,
      },
      method: 'GET',
      header: {
        'content-type': 'application/x-www-form-urlencoded',
        "Authorization": wx.getStorageSync('Authorization')
      },
      success: function(res) {
        console.log(res.data) // 服务器回包信息
        if (res.data.code == 200) {
          console.log("console.log(res.data.data[2]),"+res.data.data[2]),
          that.setData({
            img1: img1s[res.data.data[0].flag],
            img2: img1s[res.data.data[1].flag],
            img3: img1s[res.data.data[2].flag],
            img4: img1s[res.data.data[3].flag],
            order1: res.data.data[0].flag == 0 ? '' : res.data.data[0],
            order2: res.data.data[1].flag == 0 ? '' : res.data.data[1],
            order3: res.data.data[2].flag == 0 ? '' : res.data.data[2],
            order4: res.data.data[3].flag == 0 ? '' : res.data.data[3],
          })
        }
      }

    })
    wx.request({
      url: app.globalData.host +'/api-service/api/service/getRepairStatus',
      data: {
        order: this.data.order,
      },
      method: 'GET',
      header: {
        'content-type': 'application/x-www-form-urlencoded',
        "Authorization": wx.getStorageSync('Authorization'),
      },
      success: function(res) {
        console.log(res.data) // 服务器回包信息
        if (res.data.code == 200) {
          that.setData({
            orderVo: res.data.data.list[0]
          })
        }
      }

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