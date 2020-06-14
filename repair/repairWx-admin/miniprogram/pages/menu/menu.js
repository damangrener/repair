// pages/menu/menu.js
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
    pageSize: 2, //返回数据的个数  
    searchLoading: false, //"上拉加载"的变量，默认false，隐藏  
    searchLoadingComplete: false, //“没有数据”的变量，默认false，隐藏 
    repairOrder: ''
  },
  passwordInput: function (e) {
    this.data.pwd = e.detail.value
  },
  //查看维修单
  getrepairOrders: function(){
    var that = this;
    var account = wx.getStorageSync('userInfo').account

    console.log(that.data.show)
    wx.request({
      url: app.globalData.host +'/api-service/api/service/getOrderByAccount',
      method: 'GET',
      header: {
        "Authorization": wx.getStorageSync('Authorization'),
        'content-type': 'application/x-www-form-urlencoded'
      },
      data: {
        account: account,
        pageNum: that.data.pageNo,
        pageSize: that.data.pageSize
      },
      success: function (res) {
        console.log(res.data)// 服务器回包信息
        that.setData({
          order: res.data.data.list,
          show: that.data.show + 1
        })
        // wx.navigateTo({
        //   url: "../register/register?randomAccount=" + res.data.data
        // })
      }

    })
  },
  getDetail: function (event) {
    var order = event.currentTarget.dataset.order;
    var that = this;
    // var order = that.data.repairOrder

    console.log(order)
    wx.request({
      url: app.globalData.host +'/api-service/api/service/getRepairStatus',
      method: 'GET',
      header: {
        "Authorization": wx.getStorageSync('Authorization'),
        'content-type': 'application/x-www-form-urlencoded'
      },
      data: {
        repairOrder: order,
        // pageNum: that.data.pageNo,
        // pageSize: that.data.pageSize
      },
      success: function (res) {
        console.log(res.data)// 服务器回包信息
        // that.setData({
        //   order: res.data.data.list,
          // show: that.data.show + 1
        // })
        // wx.navigateTo({
        //   url: "../register/register?randomAccount=" + res.data.data
        // })
      }

    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this
    that.setData({
      account: wx.getStorageSync('userInfo').account,
      role: wx.getStorageSync('userInfo').role
    })
    // wx.startPullDownRefresh();
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
    // this.setData({
    //   pageNo: this.data.pageNo,
    //   storelist: [],
    //   searchLoading: true, //"上拉加载"的变量，默认false，隐藏  
    //   searchLoadingComplete: false //“没有数据”的变量，默认false，隐藏  
    // })
    // this.getrepairOrders();
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
    if (!this.data.searchLoadingComplete) {
      var currentPageNo = this.data.pageNo;
      this.setData({
        pageNo: currentPageNo + 1,

      })
      this.getrepairOrders();
    }
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})