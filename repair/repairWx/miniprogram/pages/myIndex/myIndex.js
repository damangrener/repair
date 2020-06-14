// pages/myIndex/myIndex.js
const app = getApp()
Page({
  /**
   * 页面的初始数据
   */
  data: {
    // 设置导航栏信息
    navType: [
      { key: 'recommend', name: '推荐', newMsgId: 1, keep: '' },
      { key: 'maintain', name: '保养tips', newMsgId: 2, keep: '' },
      { key: 'renew', name: '换新', newMsgId: 3, keep: '' },
      { key: 'tech', name: '科技', newMsgId: 4, keep: '' },
      { key: 'engineer', name: '金牌工程师', newMsgId: 5, keep: '' },
      // { key: 'upload', name: '上传文章', newMsgId: '', keep: '' }
    ],
    test: '',
    // 设置当前的导航栏选中值为：
    cursor: 'recommend',
    scrollHeight: '500',
    // 设置新闻内容
    newMsg: [],
    // 设置新闻请求数据ID
    newMsgId: 1,
    // 初始化页码数
    page: 1,
    // 设置请求的内容栏目(默认为推荐headline)
    requestKey: 'headline',

    // 下拉刷新设置
    pageAdd: 10,
    pageAddEnd: 20
  },
  // 切换导航栏选项底边框
  change: function (e) {
    this.setData({ cursor: e.target.dataset.key })
  },
  // swiper自带的bindchange事件
  swiperChange: function (e) {
    // console.log(e.detail.source)
    var that = this;
    // 判断是否是由于用户触摸引起的
    if (e.detail.source == 'touch') {
      // console.log(e.detail.currentItemId);
      // 设置到导航栏的切换
      this.setData({ cursor: e.detail.currentItemId })
    }
  },
  // scroll-view 触底事件
  scrollEnd: function (e) {
    var that = this;
    // 推荐新闻触底
    if (e.target.dataset.id == 'headline') {
      // console.log('触底了')
      this.setData({ page: this.data.page + 1 })
      // 请求数据
      var pageStart = (that.data.page - 1) * 10;
      var pageEnd = that.data.page * 10;
      wx.request({
        url: app.globalData.host +'/api-article/api/article/selectALLArticle?category=' + that.data.newMsgId + '&pageNum=' + pageStart + '&pageSize=' + pageEnd, //
        method: 'GET',
        dataType: 'json',
        data: {
        },
        header: {
          'content-type': 'application/json' // 默认值
        },
        success: function (res) {
          // console.log(res.data)
          // 获取原有的页面信息
          var News = that.data.navType[0].keep;
          // 请求的新的内容合并一起
          var sentData = News.concat(res.data.T1348647853363);
          // console.log(sentData)
          that.setData({
            "navType[0].keep": sentData
          })
        }
      })
    }
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    // 设置swiper占满屏幕高度
    wx.getSystemInfo({
      success: function (res) {
        var rh = res.windowHeight - 45 - 1;
        that.setData({ scrollHeight: rh })
      }
    });
    //调用初始化请求数据
    wx.request({
      url: app.globalData.host +'/api-article/api/article/selectALLArticle?category=1&pageNum=1&pageSize=10', //仅为示例，并非真实的接口地址
      method: 'GET',
      // dataType: 'json',
      data: {
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        // console.log(res.data)
        // 获取原有的页面信息
        var News = that.data.navType[0].keep;
        // 请求的新的内容合并一起
        var sentData = News.concat(res.data.T1348647853363);
        console.log(res.data)
        that.setData({
          "navType[0].keep": res.data.data.list
        })
      }
    });
    // 请求保养数据
    wx.request({
      url: app.globalData.host +'/api-article/api/article/selectALLArticle?category=2&pageNum=1&pageSize=10', //仅为示例，并非真实的接口地址
      method: 'GET',
      // dataType: 'json',
      data: {
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        // console.log(res.data)
        // 获取原有的页面信息
        var News = that.data.navType[0].keep;
        // 请求的新的内容合并一起
        var sentData = News.concat(res.data.T1348647853363);
        console.log(res.data)
        that.setData({
          "navType[1].keep": res.data.data.list
        })
      }
    });
    // 请求保养数据
    wx.request({
      url: app.globalData.host +'/api-article/api/article/selectALLArticle?category=3&pageNum=1&pageSize=10', //仅为示例，并非真实的接口地址
      method: 'GET',
      // dataType: 'json',
      data: {
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        // console.log(res.data)
        // 获取原有的页面信息
        var News = that.data.navType[0].keep;
        // 请求的新的内容合并一起
        var sentData = News.concat(res.data.T1348647853363);
        console.log(res.data)
        that.setData({
          "navType[2].keep": res.data.data.list
        })
      }
    });
    // 请求保养数据
    wx.request({
      url: app.globalData.host +'/api-article/api/article/selectALLArticle?category=4&pageNum=1&pageSize=10', //仅为示例，并非真实的接口地址
      method: 'GET',
      // dataType: 'json',
      data: {
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        // console.log(res.data)
        // 获取原有的页面信息
        var News = that.data.navType[0].keep;
        // 请求的新的内容合并一起
        var sentData = News.concat(res.data.T1348647853363);
        console.log(res.data)
        that.setData({
          "navType[3].keep": res.data.data.list
        })
      }
    });
    wx.request({
      url: app.globalData.host +'/api-article/api/article/selectALLArticle?category=5&pageNum=1&pageSize=10', //仅为示例，并非真实的接口地址
      method: 'GET',
      // dataType: 'json',
      data: {
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        // console.log(res.data)
        // 获取原有的页面信息
        var News = that.data.navType[0].keep;
        // 请求的新的内容合并一起
        var sentData = News.concat(res.data.T1348647853363);
        console.log(res.data)
        that.setData({
          "navType[4].keep": res.data.data.list
        })
      }
    });
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    var that = this;
    // 设置swiper占满屏幕高度
    wx.getSystemInfo({
      success: function (res) {
        var rh = res.windowHeight - 45 - 1;
        that.setData({ scrollHeight: rh })
      }
    });
    //调用初始化请求数据
    wx.request({
      url: app.globalData.host +'/api-article/api/article/selectALLArticle?category=1&pageNum=1&pageSize=10', //仅为示例，并非真实的接口地址
      method: 'GET',
      // dataType: 'json',
      data: {
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        // console.log(res.data)
        // 获取原有的页面信息
        var News = that.data.navType[0].keep;
        // 请求的新的内容合并一起
        var sentData = News.concat(res.data.T1348647853363);
        console.log(res.data)
        that.setData({
          "navType[0].keep": res.data.data.list
        })
      }
    });
    // 请求保养数据
    wx.request({
      url: app.globalData.host +'/api-article/api/article/selectALLArticle?category=2&pageNum=1&pageSize=10', //仅为示例，并非真实的接口地址
      method: 'GET',
      // dataType: 'json',
      data: {
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        // console.log(res.data)
        // 获取原有的页面信息
        var News = that.data.navType[0].keep;
        // 请求的新的内容合并一起
        var sentData = News.concat(res.data.T1348647853363);
        console.log(res.data)
        that.setData({
          "navType[1].keep": res.data.data.list
        })
      }
    });
    // 请求保养数据
    wx.request({
      url: app.globalData.host +'/api-article/api/article/selectALLArticle?category=3&pageNum=1&pageSize=10', //仅为示例，并非真实的接口地址
      method: 'GET',
      // dataType: 'json',
      data: {
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        // console.log(res.data)
        // 获取原有的页面信息
        var News = that.data.navType[0].keep;
        // 请求的新的内容合并一起
        var sentData = News.concat(res.data.T1348647853363);
        console.log(res.data)
        that.setData({
          "navType[2].keep": res.data.data.list
        })
      }
    });
    // 请求保养数据
    wx.request({
      url: app.globalData.host +'/api-article/api/article/selectALLArticle?category=4&pageNum=1&pageSize=10', //仅为示例，并非真实的接口地址
      method: 'GET',
      // dataType: 'json',
      data: {
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        // console.log(res.data)
        // 获取原有的页面信息
        var News = that.data.navType[0].keep;
        // 请求的新的内容合并一起
        var sentData = News.concat(res.data.T1348647853363);
        console.log(res.data)
        that.setData({
          "navType[3].keep": res.data.data.list
        })
      }
    });
    wx.request({
      url: app.globalData.host +'/api-article/api/article/selectALLArticle?category=5&pageNum=1&pageSize=10', //仅为示例，并非真实的接口地址
      method: 'GET',
      // dataType: 'json',
      data: {
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        // console.log(res.data)
        // 获取原有的页面信息
        var News = that.data.navType[0].keep;
        // 请求的新的内容合并一起
        var sentData = News.concat(res.data.T1348647853363);
        console.log(res.data)
        that.setData({
          "navType[4].keep": res.data.data.list
        })
      }
    });
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
    var that = this;
    // 设置swiper占满屏幕高度
    wx.getSystemInfo({
      success: function (res) {
        var rh = res.windowHeight - 45 - 1;
        that.setData({ scrollHeight: rh })
      }
    });
    //调用初始化请求数据
    wx.request({
      url: app.globalData.host +'/api-article/api/article/selectALLArticle?category=1&pageNum=1&pageSize=10', //仅为示例，并非真实的接口地址
      method: 'GET',
      // dataType: 'json',
      data: {
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        // console.log(res.data)
        // 获取原有的页面信息
        var News = that.data.navType[0].keep;
        // 请求的新的内容合并一起
        var sentData = News.concat(res.data.T1348647853363);
        console.log(res.data)
        that.setData({
          "navType[0].keep": res.data.data.list
        })
      }
    });
    // 请求保养数据
    wx.request({
      url: app.globalData.host +'/api-article/api/article/selectALLArticle?category=2&pageNum=1&pageSize=10', //仅为示例，并非真实的接口地址
      method: 'GET',
      // dataType: 'json',
      data: {
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        // console.log(res.data)
        // 获取原有的页面信息
        var News = that.data.navType[0].keep;
        // 请求的新的内容合并一起
        var sentData = News.concat(res.data.T1348647853363);
        console.log(res.data)
        that.setData({
          "navType[1].keep": res.data.data.list
        })
      }
    });
    // 请求保养数据
    wx.request({
      url: app.globalData.host +'/api-article/api/article/selectALLArticle?category=3&pageNum=1&pageSize=10', //仅为示例，并非真实的接口地址
      method: 'GET',
      // dataType: 'json',
      data: {
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        // console.log(res.data)
        // 获取原有的页面信息
        var News = that.data.navType[0].keep;
        // 请求的新的内容合并一起
        var sentData = News.concat(res.data.T1348647853363);
        console.log(res.data)
        that.setData({
          "navType[2].keep": res.data.data.list
        })
      }
    });
    // 请求保养数据
    wx.request({
      url: app.globalData.host +'/api-article/api/article/selectALLArticle?category=4&pageNum=1&pageSize=10', //仅为示例，并非真实的接口地址
      method: 'GET',
      // dataType: 'json',
      data: {
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        // console.log(res.data)
        // 获取原有的页面信息
        var News = that.data.navType[0].keep;
        // 请求的新的内容合并一起
        var sentData = News.concat(res.data.T1348647853363);
        console.log(res.data)
        that.setData({
          "navType[3].keep": res.data.data.list
        })
      }
    });
    wx.request({
      url: app.globalData.host +'/api-article/api/article/selectALLArticle?category=5&pageNum=1&pageSize=10', //仅为示例，并非真实的接口地址
      method: 'GET',
      // dataType: 'json',
      data: {
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        // console.log(res.data)
        // 获取原有的页面信息
        var News = that.data.navType[0].keep;
        // 请求的新的内容合并一起
        var sentData = News.concat(res.data.T1348647853363);
        console.log(res.data)
        that.setData({
          "navType[4].keep": res.data.data.list
        })
      }
    });
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