<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>电子名片</title>
  <link rel="stylesheet" href="http://rs.static.quanc.com.cn/h5/lib/bootstrap/bootstrap.min.css">
  <link rel="stylesheet" href="./css/usercard2_20181205.css">
  <script src="http://rs.static.quanc.com.cn/h5/lib/vue/vue.js"></script>
  <script src="http://rs.static.quanc.com.cn/h5/lib/axios.min.js"></script>
  <script src="http://rs.static.quanc.com.cn/h5/lib/jquery/jquery-1.10.2.min.js"></script>
  <script type="text/javascript"
    src="http://rs.static.quanc.com.cn/h5/lib/jquery.mobile/jquery.mobile-1.4.5.min.js"></script>
  <script type="text/javascript" src="http://rs.static.quanc.com.cn/h5/lib/wx/jweixin-1.0.0.js"></script>
  <link rel="stylesheet" href="http://rs.static.quanc.com.cn/h5/lib/swiper/swiper.min.css">
  <script src="http://rs.static.quanc.com.cn/h5/lib/swiper/swiper4.3.5.min.js"></script>
  <script type="text/javascript" src="http://rs.static.quanc.com.cn/h5/lib/html2canvas/html2canvas.min.js"></script>
</head>

<body>
  <div id="tc1" class="container" :class="{noscroll:isShowPreview}">

    <!-- 名片信息 -->
    <div v-cloak class="r_cardinfo">
      <div class="jumbotron">
        <form class="form-horizontal">
          <div class="form-group" v-if="!isZhsy">
            <label for="inputEmail3" class="col-xs-3 control-label">项目</label>
            <div class="col-xs-6">
              {{cardinfo.projectname}}
            </div>
          </div>
          <div class="form-group" v-if="!isZhsy">
            <label for="inputEmail3" class="col-xs-3 control-label">地址</label>
            <div class="col-xs-6">
              {{cardinfo.ui_address}}
            </div>
          </div>
          <div class="form-group" v-if="isZhsy">
            <label for="inputEmail3" class="col-xs-3 control-label">姓名</label>
            <div class="col-xs-6">
              {{cardinfo.ui_name}}
            </div>
          </div>
          <div class="form-group">
            <label for="inputEmail3" class="col-xs-3 control-label">电话</label>
            <div class="col-xs-6">
              {{cardinfo.ui_mobile||cardinfo.mobile}}
            </div>
          </div>
          <div class="form-group">
            <label for="inputEmail3" class="col-xs-3 control-label">个人介绍</label>
            <div class="col-xs-6">
              {{cardinfo.ui_personalprofile}}
            </div>
          </div>
        </form>
      </div>
      <div class="myhead">
        <img :src="cardinfoHeadImg" alt="" @click="clickShowPreview">
        <span v-if="!isZhsy">{{cardinfo.roleid | formatRole}}</span>
        <span v-if="!isZhsy">{{cardinfo.ui_name}}</span>
      </div>
    </div>
    <!-- 名片操作栏 -->
    <div class="r_cardaction">
      <nav class="navbar navbar-default" v-bind:style="{ backgroundColor: pcConfig.cardBgColor}">
        <div class="container-fluid">
          <div class="navbar-header">
            <a class="navbar-brand" :href="'tel:'+(cardinfo.ui_mobile || cardinfo.mobile)">
              <div @click="clickCall">
                <img alt="Brand" src="http://rs.static.quanc.com.cn/h5/img/tc1_zhidian.png">
                <div>致电</div>
              </div>
            </a>
            <a class="navbar-brand" href="javascript:void(0)" v-if="!isZhsy">
              <div @click="clickNav">
                <img alt="Brand" src="http://rs.static.quanc.com.cn/h5/img/tc1_daohang.png">
                <div>导航</div>
              </div>
            </a>
            <a class="navbar-brand" href="javascript:void(0)">
              <div @click="clickAsk">
                <img alt="Brand" src="http://rs.static.quanc.com.cn/h5/img/tc1_zixun.png">
                <div>咨询</div>
              </div>
            </a>
            <a class="navbar-brand" href="javascript:void(0)">
              <div @click="clickCreateImg">
                <img alt="Brand" src="http://rs.static.quanc.com.cn/h5/img/tc1_cuntu2.png">
                <div>保存海报</div>
              </div>
            </a>
            <a class="navbar-brand" href="javascript:void(0)">
              <div @click="clickWx">
                <img alt="Brand" src="http://rs.static.quanc.com.cn/h5/img/tc1_weixin1.png">
                <div>添加微信</div>
              </div>
            </a>
          </div>
        </div>
      </nav>
    </div>
    <!-- 诚意推荐 -->
    <div class="r_recommend">
      <div class="panel panel-default">
        <div v-cloak class="panel-heading">诚意推荐
          <span>{{pcConfig.recommend}}</span>
        </div>

        <div class="panel-body">
          <div class="title"></div>

          <div class="swiper-container">
            <div class="swiper-wrapper">
              <div class="swiper-slide" v-for="item in pcConfig.projectImgList">
                <img @click="clickSwiper(item)" :src="item.main_img" alt="">
              </div>
            </div>
            <div class="swiper-pagination"></div>
          </div>
        </div>
        <div class="panel-footer">
          <nav class="navbar navbar-default">
            <div class="container-fluid">
              <div class="navbar-header">
                <div v-for="(item,index) in  pcConfig.btns">
                  <a v-if="index<5" class="navbar-brand" href="javascript:void(0)">
                    <div @click="clickBtn(item)">
                      <img alt="Brand" :src="item.btn_img">
                      <div>{{item.name}}</div>
                    </div>
                  </a>
                </div>
              </div>
            </div>
          </nav>
        </div>
      </div>
    </div>
    <!-- 推荐户型 -->
    <div class="r_housetype" v-if="pcConfig.houseimgs.length>0">
      <div class="panel panel-default">
        <div v-cloak class="panel-heading">推荐户型
          <span></span>
        </div>
      </div>
      <div class="panel-body">
        <div class="house">
          <div class="house_item" v-for="item in pcConfig.houseimgs" @click="clickHouse(item)">
            <img class="house_img" :src="item.main_img" alt="">
            <div class="house_tp">
              <div class="house_tags">
                <span class="house_tag" v-for="tag in item.tags">
                  {{tag}}
                </span>
              </div>
              <div class="house_price">
                {{item.price}}
              </div>
            </div>
          </div>
        </div>
      </div>

    </div>

    <!-- 客户评价 -->
    <div class="r_evaluate">
      <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading">客户评价 <span class="mid">浏览人次{{pvCount}}</span>
          <span class="right">
            <img src="http://rs.static.quanc.com.cn/h5/img/tc1_edit.png" alt="">
            <!-- <span>{{evaluateScore}}</span> -->
            <span @click="clickEvaluate">我也要评价</span>
          </span>
        </div>
        <div class="panel-body">
          <!-- List group -->
          <ul class="list-group">
            <li class="list-group-item" v-for="item in discuss">
              <div class="media">
                <div class="media-left">
                  <a href="javascript:void(0)">
                    <img class="media-object" :src="item.headimgurl " alt="">
                  </a>
                </div>
                <div class="media-body">
                  <div>
                    <img v-for="scoreitem in item.nub" src="http://rs.static.quanc.com.cn/h5/img/xing.png" alt="">
                    <span>{{item.nub | formatSatisfaction}}</span>
                  </div>
                  <h4>
                    <span v-for="labelitem in item.label">{{labelitem}}</span>
                  </h4>
                  <h5 class="media-heading">{{item.specialevaluation}}</h5>
                  {{item.createtime | formatTime}}
                </div>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </div>
    <div @click="clickCloseShare" class="share_mask" :class="{share_mask_show:isShowShare}">
      <div class="share_line">
        <span></span>
        <img src="http://rs.static.quanc.com.cn/h5/img/sharelight.png" alt="">
      </div>
      <div class="phone">
        <img src="http://rs.static.quanc.com.cn/h5/img/camera.png" alt="">
        <p>您的分享，我的荣光！<br>让我为您的更多朋友服务</p>
      </div>
    </div>

    <div class="qrwx " :class="{hide:!isShowQrwx}" @click="clickCloseQrwx">
      <img :src="userWxQrcode" alt="">
    </div>
    <div class="r_preview" :class="{hide:!isShowPreview}" @click="clickClosePreview">
      <img :src="cardinfoHeadImg" alt="">
    </div>
    <div id="btnSaveimg" class="r_saveimg">
      <img @click="clickShare" src="http://rs.static.quanc.com.cn/h5/img/tc1_tuijian.png" alt="">
    </div>





  </div>
  <!--特惠-->
  <div class="fav">
    <div class="subscribe hide">
      <div class="subscribe_time">点击选择预约时间</div>
      <input id="myInput" class="inputSubscribe" type="datetime-local">
    </div>
    <div class="form">
      <div class="left">
        <div class="inner">
          <div class="input">输入您的电话获得专属服务</div>
        </div>
      </div>
      <div class="right btn_submit">提交</div>
    </div>
    <div class="btns">
      <table cellpadding="0" cellspacing="0">
        <tr>
          <td class="mytd">1</td>
          <td class="mytd">2</td>
          <td class="mytd">3</td>
        </tr>
        <tr>
          <td class="mytd">4</td>
          <td class="mytd">5</td>
          <td class="mytd">6</td>
        </tr>
        <tr>
          <td class="mytd">7</td>
          <td class="mytd">8</td>
          <td class="mytd">9</td>
        </tr>
        <tr>
          <td class="td10"></td>
          <td class="td11">0</td>
          <td class="td12">
            &lt;</td>
        </tr>
      </table>
    </div>
  </div>

  <script src="./js/usercard2_20181205.js">
  </script>
  <script>
    // 本页面链接是 tc1.html?openid=xxx
    // openid

    if (wj.browser.versions.ios) {
      var parentHeight = window.parent.innerHeight;
      $('#tc1').css({
        height: parentHeight + 'px',
        overflow: 'auto',
        '-webkit-overflow-scrolling': 'touch',
      });
    }
    console.log("当前用户信息", MYINFO);
    console.log("名片人信息", CARDUSERINFO);
    var myAxios = axios.create({
      timeout: 5000
    });
    myAxios.interceptors.request.use(function (config) {
      var tmpParams = {
        "openid": MYINFO.openid,
        "passport": MYINFO.passport,
        "vericode": "",
        "url": location.href
      };
      wj.mixin(tmpParams, config.params);
      config.params = {
        j: JSON.stringify(tmpParams)
      }
      return config;
    });
    // 添加响应拦截器
    myAxios.interceptors.response.use(function (response) {
      // 对响应数据做点什么
      response = response.data;
      return response;
    }, function (error) {
      // 对响应错误做点什么
      return Promise.reject(error);
    });

    var app = new Vue({
      el: '#tc1',
      data: {
        cookieKeys: {
          cardid: "usercard2_cardid",
          uuid: "usercard2_uuid",
          masteropenid: "usercard2_masteropenid",
          projectid: "usercard2_projectid",
        },
        cookieDuration: 60 * 10,
        refereeopenid: "",//推荐人id
        cardinfo: {},//用户信息
        cardinfoHeadImg: "",//用户微信头像
        userWxQrcode: "",//用户微信二维码
        isShowShare: false,//点击分享控制器
        isShowQrwx: false,//是否显示个人微信二维码
        isShowPreview: false,//是否显示预览
        uuid: "",//前端生成的唯一id
        discuss: [
        ],//评论区
        pvCount: 0,//浏览数
        evaluateScore: 0,//平均分
        pcConfig: {
          cardBgColor: "#223b52",// 卡片操作台背景色
          nav: "",//导航地址
          recommend: "",//推荐语句
          projectImgList: [],//轮播图
          houseimgs: [],//户型图
          callBtn: null,//致电 btns type 8
          navBtn: null,// 导航 btns type 9
          askBtn: null,// 咨询 btns type 10
          btns: [],//自定义按钮
          card: null,//用户名片信息
        },
        projectId: "",
        isZhsy: false,//是否是中海沈阳定制
      },
      filters: {
        formatTime: function (time) {
          var date = new Date(time);
          var m = date.getMonth() + 1;
          m <= 9 ? m = '0' + m : m;
          d = date.getDate();
          d <= 9 ? d = '0' + d : d;
          h = date.getHours();
          h <= 9 ? h = '0' + h : h;
          m2 = date.getMinutes();
          m2 <= 9 ? m2 = '0' + m2 : m2;
          s = date.getSeconds();
          s <= 9 ? s = '0' + s : s;
          return date.getFullYear() + '-' + m + '-' + d + ' ' + h + ':' + m2 + ':' + s;
        },
        formatSatisfaction: function (value) {
          var arrLabel = ["非常不满意", "不满意", "一般", "比较满意", "非常满意"];
          return arrLabel[value - 1];
        },
        formatRole: function (value) {
          var tmpObj = {
            roleid: value,
            rolename: ""
          }
          if (tmpObj.roleid == 2011) {
            tmpObj.rolename = '销售顾问';
          } else if (tmpObj.roleid == 2012) {
            tmpObj.rolename = '案场经理';
          } else if (tmpObj.roleid == 2013) {
            tmpObj.rolename = '销售经理';
          } else if (tmpObj.roleid == 2015) {
            tmpObj.rolename = '案场管理人';
          }
          return tmpObj.rolename;
        }
      },
      methods: {
        base64: function (target, imgUrl) {
          myAxios.get(api.wx, {
            params: {
              action: '/global/Image/base64',
              requestParam: {
                imgUrl: imgUrl
              }
            }
          }).then(function (response) {
            if (response.obj) {
              var newSrc = "data:image/jpg;base64," + response.obj;
              if (target == "userWxQrcode") {
                app.userWxQrcode = newSrc;
              }
            }
          }).catch(function (error) {
            console.log(error);
          });
        },
        refreshWxUserInfo: function () {
          var that = this;
          // 刷新用户头像
          myAxios.get(api.wx, {
            params: {
              action: 'refreshWxUserInfo',
              requestParam: {
                obj: {
                  openid: CARDUSERINFO.openid
                }
              }
            }
          }).then(function (response) {
            if (response.obj) {
              // console.log(that.cardinfo)
              app.cardinfoHeadImg = that.cardinfo.ui_headimg || response.obj.headimgurl;
            }
          }).catch(function (error) {
            console.log(error);
          });
        },
        selectByOpenid: function () {
          // 获取用户信息
          myAxios.get(api.wx, {
            params: {
              action: '/hb/HbUserAction/fansInfo',
              requestParam: {
                obj: {
                  openid: CARDUSERINFO.openid
                }
              }
            }
          }).then(function (response) {
            if (response.obj) {
              app.cardinfo = response.obj;
              wj.cookie.set(app.cookieKeys.masteropenid, app.cardinfo.openid, app.cookieDuration)
              app.base64("userWxQrcode", response.obj.wxqr);
              // 包裹之后就不能通过名片页面设置分享了
              app.initWXJSSDK(response.obj);
              app.selectCardByProjectid(response.obj.projectid);
              wj.cookie.set(app.cookieKeys.projectid, response.obj.projectid, app.cookieDuration)
              app.projectId = response.obj.projectid;
            }
          }).catch(function (error) {
            console.log(error);
          });
        },
        selectCardByProjectid: function (projectid) {
          // 获取项目信息
          myAxios.get(api.wx, {
            params: {
              action: '/electroniccard/ElectronicCardAction/getElectronicCard',
              requestParam: {
                projectid: projectid,
                state: 1,
                masteropenid: app.cardinfo.openid
              }
            }
          }).then(function (response) {
            if (response.obj) {
              var data = response.obj;
              app.pcConfig.card = data;
              wj.cookie.set(app.cookieKeys.cardid, app.pcConfig.card.id, app.cookieDuration);

              app.saveCardLog();
              setInterval(() => {
                app.saveCardLog();
              }, 5000);
              app.pvCount = data.browsecount;//浏览人次
              app.pcConfig.cardBgColor = data.cardcoulor;//名片操作台底色
              app.pcConfig.nav = data.navigationurl;//导航链接
              app.pcConfig.recommend = data.sincerere;//诚意推荐语
              app.pcConfig.projectImgList = data.banner;//轮播图
              if (data.houseimgs) {
                data.houseimgs.forEach(function (e) {
                  if (e.tags) {
                    e.tags = e.tags.split(",");
                  }
                })
              }
              app.pcConfig.houseimgs = data.houseimgs;//户型图
              if (data.btns) {
                data.btns.forEach(function (e) {
                  if (e.type == 9) {
                    app.pcConfig.callBtn = e;
                  } else if (e.type == 10) {
                    app.pcConfig.navBtn = e;
                  } else if (e.type == 11) {
                    app.pcConfig.askBtn = e;
                  } else {
                    app.pcConfig.btns.push(e);
                  }

                })
              }

              app.initSwiper();
            }
          }).catch(function (error) {
            console.log(error);
          });
        },
        selectNubThanThird: function () {
          // 获取评论
          myAxios.get(api.wx, {
            params: {
              action: '/guext/EvaluationAction/selectNubThanThird',
              requestParam: {
                openid: CARDUSERINFO.openid
              }
            }
          }).then(function (response) {
            if (response.obj) {
              app.evaluateScore = response.obj.avg;
              var tmpList = [];
              if (response.obj.list && response.obj.list.length > 0) {
                response.obj.list.forEach(function (item) {
                  var labels = [];
                  if (item.service == 1) {
                    labels.push('服务周到');
                  }
                  if (item.familiarize == 1) {
                    labels.push('熟悉项目');
                  }
                  if (item.feedback == 1) {
                    labels.push('反馈积极');
                  }
                  if (item.appearance == 1) {
                    labels.push('形象良好');
                  }
                  if (item.commentary == 1) {
                    labels.push('解说精彩');
                  }
                  if (item.knowledge == 1) {
                    labels.push('知识全面');
                  }
                  item.label = labels;
                  tmpList.push(item);
                })
              }
              app.discuss = tmpList;
            }
          }).catch(function (error) {
            console.log(error);
          });
        },
        clickCall: function () {
          console.log("致电");
          // 调用拨打电话
          // 传btns里面type=8的id
          if (this.pcConfig.callBtn && this.pcConfig.callBtn.id) {
            this.saveBtnClick(this.pcConfig.callBtn.id);
          }

        },
        clickNav: function () {
          console.log("导航");
          // 传btns里面type=9的id
          if (this.pcConfig.navBtn && this.pcConfig.navBtn.id) {
            this.saveBtnClick(this.pcConfig.navBtn.id);
          }
          wj.goUrl(this.pcConfig.nav);
        },
        clickAsk: function () {
          console.log("咨询");
          if (this.pcConfig.askBtn && this.pcConfig.askBtn.id) {
            this.saveBtnClick(this.pcConfig.askBtn.id);
          }
          // 传btns里面type=10的id
          var url = '';
          url = `http://${cfg.host}/newcode/src/chat_room.html?openid=${MYINFO.openid}&passport=${MYINFO.passport}&receiveropenid=${CARDUSERINFO.openid}&nickname=&pageid=${CARDUSERINFO.pageid}&projectid=${app.projectId}`;
          // if (wj.cookie.get('openid') && wj.cookie.get('passport')) {
          //     url = `http://${cfg.host}/newcode/src/chat_room.html?openid=${MYINFO.openid}&passport=${MYINFO.passport}&receiveropenid=${CARDUSERINFO.openid}&nickname=&pageid=${CARDUSERINFO.pageid}&projectid=${app.projectId}`;
          // } else {
          //     url = "http://" + cfg.host + "/marketies/rc/rs-direction.html?type=chat&receiveropenid=" + CARDUSERINFO.openid +
          //         "&nickname=" + this.cardinfo.name + "&pageid=" + parseInt(CARDUSERINFO.pageid) + "&projectid=" + parseInt(app.projectId);
          // }
          wj.goUrl(url);
        },
        clickShare: function () {
          console.log("分享");
          this.isShowShare = true;
        },
        clickCloseShare: function () {
          this.isShowShare = false;
        },
        clickWx: function () {
          console.log("添加微信")
          if (app.userWxQrcode) {
            if (wj.browser.versions.ios) {
              var url = `./usercard_wxqrcode.html?openid=${CARDUSERINFO.openid}&myopenid=${MYINFO.openid}&mypassport=${MYINFO.passport}&pageid=${CARDUSERINFO.pageid}`;
              wj.goUrl(url);
            } else {
              app.isShowQrwx = true;
            }
          } else {
            alert("他/她还没上传微信二维码，您可以拨打电话联系！")
          }
        },
        clickCloseQrwx: function () {
          console.log("隐藏添加微信")
          app.isShowQrwx = false;
        },
        clickShowPreview: function () {
          app.isShowPreview = true;
        },
        clickClosePreview: function () {
          app.isShowPreview = false;
        },
        clickBtn: function (item) {
          // 1一般通用按钮，2调研，3抽奖按钮，4街景按钮，5周边，6线上商城，7预约，8留电，9致电，10线上咨询，11导航
          this.saveBtnClick(item.id);
          console.log(item);
          if (item.type == 7) {
            // 预约
            showCard(7);
          } else if (item.type == 8) {
            // 留电
            showCard(8);
          } else {
            if (item.redirect_url.indexOf(".quanc.com.cn/h5/t") > -1) {
              // 我们自己的h5
              wj.goUrl(item.redirect_url + "&from=card")
            } else {
              wj.goUrl(item.redirect_url)
            }

          }

        },
        clickHouse: function (item) {
          console.log(item);
          wj.goUrl(`./usercard_unit_details.html?id=${item.id}&cu_openid=${CARDUSERINFO.openid}`)
        },
        clickSwiper: function (item) {
          // 点击Swiper
          console.log(item);
          if (item && item.redirect_url) {
            wj.goUrl(item.redirect_url);
          }
        },
        clickEvaluate: function () {
          console.log("评价");
          var url = `./usercard_evaluate.html?openid=${CARDUSERINFO.openid}&myopenid=${MYINFO.openid}&mypassport=${MYINFO.passport}&pageid=${CARDUSERINFO.pageid}`;
          wj.goUrl(url);
        },
        clickCreateImg: function () {
          console.log("存图");
          var pageName = "";
          if (location.href.indexOf("zhbshf") > -1) {
            // 中海半山华府
            pageName = "usercard_createimg_zhbshf";
          } else if (location.href.indexOf("zhhp") > -1) {
            // 中海和平之门项目
            pageName = "usercard_createimg_zhhp";
          } else if (location.href.indexOf("zhsyzhc") > -1) {
            // 中海和悦府 沈阳中海城
            pageName = "usercard_createimg_zhsyzhc";
          } else if (location.href.indexOf("zhty") > -1) {
            // 中海天誉
            pageName = "usercard_createimg_zhty";
          } else if (location.href.indexOf("zhhytx") > -1) {
            // 中海寰宇天下
            pageName = "usercard_createimg_zhhytx";
          } else if (location.href.indexOf("zhhzhu.") > -1) {
            // 中海红著
            pageName = "usercard_createimg_zhhzhu";
          } else if (location.href.indexOf("qczhj.") > -1) {
            // 泉城中海家
            pageName = "usercard_createimg_qczhj";
          } else {
            pageName = "usercard_createimg";
          }
          var url = `./${pageName}.html?openid=${CARDUSERINFO.openid}&myopenid=${MYINFO.openid}&mypassport=${MYINFO.passport}&pageid=${CARDUSERINFO.pageid}&cardversion=1`;
          wj.goUrl(url);
        },

        saveCardLog: function (imageid = '', btnid = '') {
          myAxios.get(api.wx, {
            params: {
              action: '/electroniccard/ElectronicCardAction/saveCardLog',
              requestParam: {
                obj: {
                  cardid: app.pcConfig.card.id,//电子名片模板id
                  uuid: app.uuid,//前端生成的唯一标识
                  masteropenid: app.cardinfo.openid,//当前电子名片所属人的openid
                  imageid: imageid,//如果是浏览的户型图详情，需要提交户型图的id
                  btnid: btnid,//功能按钮的id
                  referenceopenid: app.refereeopenid,
                  projectid: app.projectId
                }
              }
            }
          }).then(function (response) {
            if (response.obj) {
              var data = response.obj;

            }
          }).catch(function (error) {
            console.log(error);
          });
        },
        saveBtnClick: function (btnid = '') {
          myAxios.get(api.wx, {
            params: {
              action: '/electroniccard/ElectronicCardAction/saveBtnClick',
              requestParam: {
                obj: {
                  cardid: app.pcConfig.card.id,//电子名片模板id
                  masteropenid: app.cardinfo.openid,//当前电子名片所属人的openid
                  uuid: app.uuid,//前端生成的唯一标识
                  btnid: btnid,//功能按钮的id
                }
              }
            }
          }).then(function (response) {
            if (response.obj) {
              var data = response.obj;

            }
          }).catch(function (error) {
            console.log(error);
          });
        },
        setUuid: function () {
          var uuid = wj.cookie.get(this.cookieKeys.uuid);
          if (uuid) {
            this.uuid = uuid;
          } else {
            this.uuid = wj.getGuid();
            wj.cookie.set(this.cookieKeys.uuid, this.uuid, this.cookieDuration);
          }
        },
        initSwiper: function () {
          var mySwiperWidth = $(".panel-body").width();
          $(".swiper-container").css("width", mySwiperWidth);
          $(".swiper-container").css("height", mySwiperWidth * (2 / 3));
          var mySwiper = new Swiper('.swiper-container', {
            pagination: {
              el: '.swiper-pagination',
            },
            autoplay: {
              delay: 2000,
            },
            observer: true,
            observeParents: true
          })
        },
        initWXJSSDK: function (cardinfo) {

          console.log("initweixin" + cardinfo);
          var shareLink = location.href.split("?")[0];
          shareLink += "?openid=" + CARDUSERINFO.openid + "&refereeopenid=" + MYINFO.openid;

          var shareTitle = `我是${cardinfo.gappname || cardinfo.projectname}的${cardinfo.ui_name || cardinfo.name || cardinfo.nickname}，欢迎您随时联系`;
          var shareDesc = `手机号：${cardinfo.ui_mobile || cardinfo.mobile}${cardinfo.ui_weixin ? "微信号：" + cardinfo.ui_weixin : ""}`;
          var shareImg = cardinfo.headimgurl;
          $.ajax({
            type: "GET",
            url: location.host.indexOf("fqjzw.") > -1 ? api.wx.replace('//fqjzw.', '//yqjisu.') : api.wx,
            data: {
              j: JSON.stringify({
                openid: location.host.indexOf("fqjzw.") > -1 ? 'oPg9r1Smqfm7L0xRQg31bv3QEurM' : MYINFO.openid,
                passport: location.host.indexOf("fqjzw.") > -1 ? 'b6ea31a39077f68fb85ba41109f51b40' : MYINFO.passport,
                "vericode": "",
                "url": location.href,
                "action": "getAppid",
                "requestParam": {}
              }),
              t: 6
            },
            success: function (data) {
              if (data.code < 0) {
                return;
              }
              wx.config({
                debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
                appId: data.obj, // 必填，公众号的唯一标识
                timestamp: data.jsParams.timestamp, // 必填，生成签名的时间戳
                nonceStr: data.jsParams.noncestr, // 必填，生成签名的随机串
                signature: data.jsParams.signature, // 必填，签名，见附录1
                jsApiList: [
                  'onMenuShareTimeline',
                  'onMenuShareAppMessage',
                  'onMenuShareQQ',
                  'onMenuShareWeibo',
                  'onMenuShareQZone'
                ] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
              });

              wx.ready(function () {
                wx.onMenuShareTimeline({
                  title: shareTitle, // 分享标题
                  link: shareLink, // 分享链接
                  imgUrl: shareImg, // 分享图标
                  success: function () {
                    // 用户确认分享后执行的回调函数
                    app.wxShare();
                  },
                  cancel: function () {
                    // 用户取消分享后执行的回调函数
                  }
                });

                wx.onMenuShareAppMessage({
                  title: shareTitle, // 分享标题
                  desc: shareDesc, // 分享描述
                  link: shareLink, // 分享链接
                  imgUrl: shareImg, // 分享图标
                  type: '', // 分享类型,music、video或link，不填默认为link
                  dataUrl: '', // 如果type是music或video，则要提供数据链接，默认为空
                  success: function () {
                    // 用户确认分享后执行的回调函数
                    app.wxShare();
                  },
                  cancel: function () {
                    // 用户取消分享后执行的回调函数
                  }
                });

                wx.onMenuShareQQ({
                  title: shareTitle, // 分享标题
                  desc: shareDesc, // 分享描述
                  link: shareLink, // 分享链接
                  imgUrl: shareImg, // 分享图标
                  success: function () {
                    // 用户确认分享后执行的回调函数
                    app.wxShare();
                  },
                  cancel: function () {
                    // 用户取消分享后执行的回调函数
                  }
                });

                wx.onMenuShareWeibo({
                  title: shareTitle, // 分享标题
                  desc: shareDesc, // 分享描述
                  link: shareLink, // 分享链接
                  imgUrl: shareImg, // 分享图标
                  success: function () {
                    // 用户确认分享后执行的回调函数
                    app.wxShare();
                  },
                  cancel: function () {
                    // 用户取消分享后执行的回调函数
                  }
                });

                wx.onMenuShareQZone({
                  title: shareTitle, // 分享标题
                  desc: shareDesc, // 分享描述
                  link: shareLink, // 分享链接
                  imgUrl: shareImg, // 分享图标
                  success: function () {
                    // 用户确认分享后执行的回调函数
                    app.wxShare();
                  },
                  cancel: function () {
                    // 用户取消分享后执行的回调函数
                  }
                });
              });
            }
          });
        },
        wxShare: function (imageid = '', btnid = '') {
          myAxios.get(api.wx, {
            params: {
              action: '/electroniccard/ElectronicCardAction/saveShare',
              requestParam: {
                obj: {
                  cardid: app.pcConfig.card.id,//电子名片模板id
                  masteropenid: app.cardinfo.openid,//当前电子名片所属人的openid
                  uuid: app.uuid,//前端生成的唯一标识
                  btnid: btnid,//功能按钮的id
                  imageid: imageid,//户型图id
                }
              }
            }
          }).then(function (response) {
            if (response.obj) {
              var data = response.obj;

            }
          }).catch(function (error) {
            console.log(error);
          });
        }
      },
      beforeCreate: function () {

      },
      created: function () {

        if (wj.cookie.get("refereeopenid")) {
          this.refereeopenid = wj.cookie.get("refereeopenid");
        }
        this.setUuid();

        this.refreshWxUserInfo();
        this.selectByOpenid();
        this.selectNubThanThird();
        if (location.href.indexOf("zhsy") > -1) {
          this.isZhsy = true;
        }

        $(".inputSubscribe").width($("body").width());
      },
      beforeMount: function () {
      },
      mounted: function () {
      },
      beforeUpdate: function () {

      },
      updated: function () {

      },
      beforeDestroy: function () {

      },
      destroyed: function () {

      }
    })

    var popObj = {
      isShow: false,
      type: '',//留电弹框类型 7预约 8留电

      strSubscribeVal: '',
    }
    //点击特惠-数字按钮
    $(".mytd").each(function (i, e) {
      if (i < 9) {
        $(e).on("tap", function () {
          enterNum(i);
        })
      }
    });
    $(".td11").on("tap", function () {
      enterNum(-1);
    })

    function enterNum(i) {
      var str = $(".input").text();
      if (!wj.isNumber(str)) {
        str = "";
      }
      $(".input").text(str + "" + (i + 1) + "");
    }

    $(".td12").on("tap", function () {
      var str = $(".input").text();
      if (str == "") {
        str = "输入您的电话获得专属服务";
      } else if (wj.isNumber(str) && str.length > 1) {
        str = str.substring(0, str.length - 1);
      } else if (str.length == 1) {
        str = "输入您的电话获得专属服务";
      }
      $(".input").text(str);
    })
    $(".td12").on("taphold", function () {
      $(".input").text("输入您的电话获得专属服务");
    })
    //点击特惠-提交
    $(".btn_submit").on("tap", function () {
      var strPhone = $(".input").text();
      var ordertime = "";
      if (strPhone == "" || strPhone == "输入您的电话获得专属服务") {
        alert("请填写手机号或电话号！");
        return false;
      } else if (!wj.isMobileNumber(strPhone)) {
        alert("请填写正确格式的手机号或电话号！");
        return false;
      } else if (popObj.type == 7) {
        if (!popObj.strSubscribeVal) {
          alert("请选择预约时间！");
          return false;
        }
        if (new Date() > new Date(popObj.strSubscribeVal)) {
          alert("预约时间不能早与当前时间！")
          return false;
        }
        ordertime = wj.getFullTime(popObj.strSubscribeVal);
      }

      $(".fav").css({
        height: "0rem"
      });

      myAxios.get(api.wx, {
        params: {
          action: '/electroniccard/ElectronicCardAction/saveMobile',
          requestParam: {
            uuid: app.uuid,
            mobile: strPhone,
            ordertime: ordertime
          }
        }
      }).then(function (response) {
        if (response.obj) {
          var data = response.obj;
          if (popObj.type == 7) {
            alert("预约成功！");
          } else if (popObj.type == 8) {
            alert("留电成功！")
          }

        }
      }).catch(function (error) {
        console.log(error);
      });
    });

    $(".inputSubscribe").change(function () {
      var strSubscribe = $(".inputSubscribe").val();
      if (strSubscribe) {
        popObj.strSubscribeVal = wj.getFullTime(strSubscribe);
        strSubscribe = wj.getFullTime3(strSubscribe);
        $(".subscribe_time").text(`预约时间：${strSubscribe.substring(0, 14)}`);

      } else {
        $(".subscribe_time").text(`点击选择预约时间`);
      }
    });

    $(".container").on("tap", function (e) {
      if (popObj.isShow == true) {
        popObj.isShow = false;
        closeCard();
        e.preventDefault();
      }

    })
    function showCard(type) {
      popObj.isShow = true;
      popObj.type = type;
      if (type == 7) {
        $(".subscribe").removeClass("hide");
        $(".fav").css({
          height: "28.6rem"
        });
      }
      if (type == 8) {
        $(".subscribe").addClass("hide");
        $(".fav").css({
          height: "24.6rem"
        });
      }
    }

    function closeCard() {
      popObj.isShow = false;
      $(".fav").css({
        height: "0rem"
      });
    }

    function add() {
      var input = document.getElementById('myInput');

      input.onclick = function () {
        var target = this;
        // 使用定时器是为了让输入框上滑时更加自然
        setTimeout(function () {
          target.scrollIntoView(true);
        }, 100);
      };
    }
    add();

    $(function () {
      //微信内置浏览器浏览H5页面弹出的键盘遮盖文本框的解决办法
      window.addEventListener("resize", function () {
        if (document.activeElement.tagName == "INPUT" || document.activeElement.tagName == "TEXTAREA") {
          window.setTimeout(function () {
            document.activeElement.scrollIntoViewIfNeeded();
          }, 0);
        }
      })
    })
  </script>
</body>

</html>