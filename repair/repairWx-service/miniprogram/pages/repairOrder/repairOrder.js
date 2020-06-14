// pages/repairOrder/repairOrder.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    account: '',
    role: '',
    show: 0,
    pageNo: 1, // 设置加载的第几次，默认是第一次  
    pageSize: 20, //返回数据的个数  
    searchLoading: false, //"上拉加载"的变量，默认false，隐藏  
    searchLoadingComplete: false, //“没有数据”的变量，默认false，隐藏 
    repairOrder: '',
    array: [],
    a: 0,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var that = this
    that.setData({
      account: wx.getStorageSync('userInfo').account,
      role: wx.getStorageSync('userInfo').role
    })
    // var account = wx.getStorageSync('userInfo').account
    // var role = wx.getStorageSync('userInfo').account.role
    console.log("role" + wx.getStorageSync('userInfo').role)
    if (that.data.role == 1) {
      wx.request({
        url: app.globalData.host +'/api-service/api/service/getOrderByServiceMan',
        method: 'GET',
        header: {
          "Authorization": wx.getStorageSync('Authorization'),
          'content-type': 'application/x-www-form-urlencoded'
        },
        data: {
          account: that.data.account,
          pageNum: that.data.pageNo,
          pageSize: that.data.pageSize
        },
        success: function(res) {
          console.log(res.data) // 服务器回包信息
          that.setData({
            orders: res.data.data.list,
            show: that.data.show + 1
          })
          // wx.navigateTo({
          //   url: "../register/register?randomAccount=" + res.data.data
          // })
        }

      })
    }
    // console.log(that.data.show)
    else if (that.data.role == 2) {
      wx.request({
        url: app.globalData.host +'/api-service/api/service/getOrderByAccount',
        method: 'GET',
        header: {
          "Authorization": wx.getStorageSync('Authorization'),
          'content-type': 'application/x-www-form-urlencoded'
        },
        data: {
          account: that.data.account,
          pageNum: that.data.pageNo,
          pageSize: that.data.pageSize
        },
        success: function(res) {
          console.log(res.data) // 服务器回包信息
          that.setData({
            orders: res.data.data.list,
            show: that.data.show + 1
          })
          // wx.navigateTo({
          //   url: "../register/register?randomAccount=" + res.data.data
          // })
        }

      })
    } else if (that.data.role == 0) {
      wx.request({
        url: app.globalData.host +'/api-service/api/service/getAllOrder',
        method: 'GET',
        header: {
          "Authorization": wx.getStorageSync('Authorization'),
          'content-type': 'application/x-www-form-urlencoded'
        },
        data: {
          pageNum: that.data.pageNo,
          pageSize: that.data.pageSize
        },
        success: function(res) {
          console.log(res.data) // 服务器回包信息
          that.setData({
            orders: res.data.data.list,
            show: that.data.show + 1
          })
          // wx.navigateTo({
          //   url: "../register/register?randomAccount=" + res.data.data
          // })
        }

      })
      wx.request({
        url: app.globalData.host +'/api-user/api/userExtra/getAllUser',
        method: 'GET',
        header: {
          "Authorization": wx.getStorageSync('Authorization'),
          'content-type': 'application/x-www-form-urlencoded'
        },
        data: {
          role: 1
        },
        success: function(res) {
          that.setData({
            array: res.data.data.list,
          })
          // wx.navigateTo({
          //   url: "../register/register?randomAccount=" + res.data.data
          // })
        }

      })
      //

    }
  },
  bindPickerChange: function(e) {
    console.log('picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      a: e.detail.value,
    })
  },
  fenpai: function(e) {
    console.log(e)
    var that = this
    wx.request({
      url: app.globalData.host +'/api-service/api/service/assignServiceMan',
      method: 'POST',
      header: {
        "Authorization": wx.getStorageSync('Authorization'),
        'content-type': 'application/x-www-form-urlencoded'
      },
      data: {
        order: e.target.dataset.order,
        account: e.target.dataset.acc
      },

      success: function(res) {
        if (res.data.data != null && res.data.code == 200) {
          wx: wx.showToast({
            title: '分派成功'
          })
          
        }
        // that.setData({
        //   array: res.data.data.list,
        // })
        // wx.navigateTo({
        //   url: "../register/register?randomAccount=" + res.data.data
        // })
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