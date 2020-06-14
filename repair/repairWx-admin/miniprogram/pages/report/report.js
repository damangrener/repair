const app = getApp()
Page({
  data: {
    array: ['挂机', '柜机', '中央空调', '其他'],
    objectArray: [
      {
        id: 0,
        name: '挂机'
      },
      {
        id: 1,
        name: '柜机'
      },
      {
        id: 2,
        name: '中央空调'
      },
      {
        id: 3,
        name: '其他'
      }
    ],
    index: 0,

    date: '2016-09-01',
    time: '12:01',
    region: ['广东省', '广州市', '海珠区'],
    customItem: '全部',
    phone: '',
    desc: '',
    detail: ''

  },
  phoneInput: function (e) {
    this.data.phone = e.detail.value
  },
  descInput: function (e) {
    this.data.desc = e.detail.value
  },
  detailInput: function (e) {
    this.data.detail = e.detail.value
  },
  bindPickerChange: function(e) {
    console.log('picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      index: e.detail.value
    })
    this.data.style = e.detail.value
    console.log(this.data.style)
  },
  bindDateChange: function(e) {
    // console.log('picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      date: e.detail.value
    })
    this.data.date = e.detail.value
  },
  bindTimeChange: function(e) {
    console.log('picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      time: e.detail.value
    })
    this.data.time = e.detail.value
  },
  bindRegionChange: function (e) {
    console.log('picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      region: e.detail.value
    })
    this.data.city = e.detail.value[0] + e.detail.value[1]+ e.detail.value[2]
  },
  report: function () {
    var that = this;
    if (this.data.detail == '') {
      wx: wx.showToast({
        title: '请输入详细地址'
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
    
    // else if (this.data.date +" "+ this.data.time<Date.now) {
    //   wx: wx.showToast({
    //     title: '时间请大于当前'
    //   })
    // }
    else{
    
    wx.showLoading({
      title: '上报中...',
      mask: true
    })
    wx.request({
      url: app.globalData.host +'/api-service/api/service/report',
      method: 'POST',
      header: {
        'content-type': 'application/x-www-form-urlencoded',
        "Authorization": wx.getStorageSync('Authorization')
      },
      data: {
        phone: this.data.phone,
        type: this.data.style == null ? 0 : this.data.style,
        appointTime: this.data.date+" " + this.data.time+":00",
        problemDesc: this.data.desc,
        address: this.data.city + this.data.detail,
        account: wx.getStorageSync('userInfo').account
      },
      success: function (res) {
        console.log(res.data.data) // 服务器回包信息
        if (res.data.data != null && res.data.code == 200) {
          wx: wx.showToast({
            title: '上报成功'
          })
          wx.switchTab({
            url: "../repair/repair"
          })
        }
        else {
          wx: wx.showToast({
            title: '上报失败，请重试'
          })
        }
      }
    })}
  },
})