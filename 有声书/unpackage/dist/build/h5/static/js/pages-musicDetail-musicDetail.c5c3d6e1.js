(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["pages-musicDetail-musicDetail"],{"176e":function(t,i,e){"use strict";var n={"uni-popup":e("acdd").default},a=function(){var t=this,i=t.$createElement,e=t._self._c||i;return e("v-uni-view",{class:t.nightStatus?"nightTheme":"",staticStyle:{height:"100vh"}},[e("page-title",{attrs:{Theme:t.nightStatus?"nightTheme":"bg-white"}},[t._v("音乐详情")]),e("v-uni-view",{staticClass:"d-inline-block w-100 text-center py-2"},[e("v-uni-view",[e("v-uni-text",{staticClass:"font"},[t._v("歌曲:")]),e("v-uni-text",{staticClass:"font-weight-bold"},[t._v(t._s(t.audioName))])],1),e("v-uni-view",[e("v-uni-text",{staticClass:"font"},[t._v("歌手:")]),e("v-uni-text",{staticClass:"font-weight-bold"},[t._v(t._s(t.singerName))])],1)],1),e("v-uni-view",{staticClass:"flex align-center justify-center"},[e("v-uni-image",{staticStyle:{"border-radius":"35rpx","box-shadow":"0 2rpx 6rpx 0",width:"600rpx",height:"380rpx"},attrs:{src:t.CurCover,"lazy-load":!0,mode:"aspectFill"}})],1),e("v-uni-view",{staticClass:"flex align-center justify-center font",staticStyle:{color:"#7a8388",height:"65rpx"}},[e("v-uni-view",[t._v(t._s(t._f("formatTime")(t.durationTime)))]),e("v-uni-view",{staticStyle:{width:"500rpx"}},[e("v-uni-slider",{attrs:{"block-size":"16",activeColor:"#e48267",backgroundColor:"#eef2f3",max:t.durationTime,value:t.currentTime},on:{change:function(i){arguments[0]=i=t.$handleEvent(i),t.sliderToPlay.apply(void 0,arguments)},changing:function(i){arguments[0]=i=t.$handleEvent(i),t.sliderToPlay.apply(void 0,arguments)}}})],1),e("v-uni-view",[t._v(t._s(t._f("formatTime")(t.currentTime)))])],1),e("v-uni-view",[e("v-uni-view",{staticClass:"flex align-center justify-center",staticStyle:{"padding-top":"50rpx"}},[e("v-uni-view",{staticClass:"mr-3",on:{click:function(i){arguments[0]=i=t.$handleEvent(i),t.PreOrNext("pre")}}},[e("my-icon",{attrs:{iconId:"icon-shangyixiang",iconSize:"85"}})],1),e("v-uni-view",{staticClass:"mx-5",on:{click:function(i){arguments[0]=i=t.$handleEvent(i),t.PlayOrPause.apply(void 0,arguments)}}},[e("my-icon",{attrs:{iconId:t.playStatus?"icon-zanting":"icon-bofang1",iconSize:"80"}})],1),e("v-uni-view",{staticClass:"ml-2",on:{click:function(i){arguments[0]=i=t.$handleEvent(i),t.PreOrNext("next")}}},[e("my-icon",{attrs:{iconId:"icon-xiayixiang",iconSize:"85"}})],1)],1),e("v-uni-view",{staticClass:"flex align-center justify-center font",staticStyle:{"padding-top":"50rpx"}},[e("v-uni-view",{staticClass:"flex flex-column align-center",on:{click:function(i){arguments[0]=i=t.$handleEvent(i),t.chageStatus("listStatus")}}},[e("my-icon",{attrs:{iconId:t.listStatus?"icon-liebiao":"icon-icon--",iconSize:"60"}}),e("v-uni-text",{staticClass:"pt-1"},[t._v("播放列表")])],1),e("v-uni-view",{staticClass:"flex flex-column align-center",staticStyle:{padding:"0 80rpx"},on:{click:function(i){arguments[0]=i=t.$handleEvent(i),t.chageStatus("collectStatus")}}},[e("my-icon",{attrs:{iconId:t.collectStatus?"icon-xihuan2":"icon-aixinfengxian",iconSize:"60"}}),e("v-uni-text",{staticClass:"pt-1"},[t._v("收藏")])],1),e("v-uni-view",{staticClass:"flex flex-column align-center",on:{click:function(i){arguments[0]=i=t.$handleEvent(i),t.chageStatus("nightStatus")}}},[e("my-icon",{attrs:{iconId:t.nightStatus?"icon-yueliang":"icon-yejianmoshi",iconSize:"60"}}),e("v-uni-text",{staticClass:"pt-1"},[t._v("夜间模式")])],1)],1)],1),e("v-uni-view",{directives:[{name:"show",rawName:"v-show",value:!t.listStatus,expression:"!listStatus"}],staticClass:"fixed-bottom shadow p-2 animated fadeInUp",staticStyle:{height:"260rpx","border-radius":"30rpx","z-index":"0"}},[e("v-uni-view",{staticClass:"flex justify-between"},[e("v-uni-view",[e("v-uni-view",[e("v-uni-text",{staticClass:"font"},[t._v("歌曲:")]),e("v-uni-text",{staticClass:"font-weight-bold"},[t._v(t._s(t.audioName))])],1),e("v-uni-view",[e("v-uni-text",{staticClass:"font"},[t._v("歌手:")]),e("v-uni-text",{staticClass:"font-weight-bold"},[t._v(t._s(t.singerName))])],1)],1),e("my-icon",{attrs:{iconId:"icon-jieshao",iconSize:"65"},on:{"my-click":function(i){arguments[0]=i=t.$handleEvent(i),t.showSingerSynopsis.apply(void 0,arguments)}}})],1),e("v-uni-view",[e("v-uni-view",{staticClass:"font-md pt-2"},[t._v("歌手简介:")]),e("v-uni-view",{staticClass:"text-ellipsis w-100"},[t._v(t._s(t.singerSynopsis))])],1)],1),e("v-uni-view",{directives:[{name:"show",rawName:"v-show",value:t.listStatus,expression:"listStatus"}],staticClass:"fixed-bottom shadow p-2 animated fadeInUp",staticStyle:{height:"260rpx","border-radius":"30rpx"}},[e("v-uni-view",{staticClass:"font-weight-bold font-md",staticStyle:{height:"50rpx"}},[t._v("列表选择")]),e("v-uni-scroll-view",{staticStyle:{height:"210rpx"},attrs:{"scroll-y":!0}},[t._l(t.audioList,(function(i,n){return[e("v-uni-view",{key:i.id+"_0",staticClass:"flex align-center font px-2",staticStyle:{height:"85rpx"},attrs:{"hover-class":"bg-light"},on:{click:function(e){arguments[0]=e=t.$handleEvent(e),t.selectPlay(i.id)}}},[e("v-uni-text",{staticClass:"flex-1 text-ellipsis"},[t._v(t._s(i.audioName))]),e("v-uni-text",{staticClass:"flex-1 text-ellipsis"},[t._v(t._s(i.singerName))]),e("v-uni-view",{staticClass:"flex-1 ml-3 flex align-center"},[i.playStatus?[e("v-uni-text",{staticClass:"mr-2"},[t._v(t._s(1===i.playStatus?"播放中":"播放"))]),e("my-icon",{attrs:{iconId:1===i.playStatus?"icon-bofangzhong2":"icon-bofangsanjiaoxing",iconSize:"35"}})]:t._e()],2)],1)]}))],2)],1),e("uni-popup",{ref:"popup"},[e("v-uni-view",{staticClass:"px-2 shadow",class:t.nightStatus?"nightTheme":"bg-white",staticStyle:{width:"600rpx",height:"850rpx","border-radius":"40rpx"}},[e("v-uni-text",{staticClass:"font"},[t._v(t._s(t.singerSynopsis))])],1)],1)],1)},s=[];e.d(i,"b",(function(){return a})),e.d(i,"c",(function(){return s})),e.d(i,"a",(function(){return n}))},"27f4":function(t,i,e){"use strict";e.r(i);var n=e("176e"),a=e("d04d");for(var s in a)"default"!==s&&function(t){e.d(i,t,(function(){return a[t]}))}(s);var c,o=e("f0c5"),r=Object(o["a"])(a["default"],n["b"],n["c"],!1,null,"b1d144fc",null,!1,n["a"],c);i["default"]=r.exports},"29c0":function(t,i,e){"use strict";Object.defineProperty(i,"__esModule",{value:!0}),i.default=void 0;var n={data:function(){return{statusBarHeight:this.$statusBarHeight}},props:{Theme:{type:String,default:"bg-white"}},methods:{quit:function(){uni.navigateBack({delta:1})}}};i.default=n},"5f53":function(t,i,e){"use strict";var n=e("4ea4");Object.defineProperty(i,"__esModule",{value:!0}),i.default=void 0,e("8e6e"),e("ac6a"),e("456d");var a=n(e("bd86")),s=e("2f62"),c=n(e("bcb2")),o=n(e("ce25")),r=n(e("acdd"));function u(t,i){var e=Object.keys(t);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(t);i&&(n=n.filter((function(i){return Object.getOwnPropertyDescriptor(t,i).enumerable}))),e.push.apply(e,n)}return e}function l(t){for(var i=1;i<arguments.length;i++){var e=null!=arguments[i]?arguments[i]:{};i%2?u(Object(e),!0).forEach((function(i){(0,a.default)(t,i,e[i])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(e)):u(Object(e)).forEach((function(i){Object.defineProperty(t,i,Object.getOwnPropertyDescriptor(e,i))}))}return t}var v={data:function(){return{listStatus:!1,collectStatus:!1,nightStatus:!1}},filters:{formatTime:function(t){return 100===t?c.default.formatTime(0):c.default.formatTime(t)}},components:{pageTitle:o.default,uniPopup:r.default},computed:l({},(0,s.mapState)({durationTime:function(t){var i=t.audio;return i.durationTime},currentTime:function(t){var i=t.audio;return i.currentTime},audioList:function(t){var i=t.audio;return i.audioList},playStatus:function(t){var i=t.audio;return i.playStatus}}),{},(0,s.mapGetters)(["audioName","singerName","singerSynopsis","CurCover"])),methods:l({},(0,s.mapActions)(["PlayOrPause","PreOrNext","sliderToPlay","selectPlay","init"]),{chageStatus:function(t){this[t]=!this[t]},showSingerSynopsis:function(){this.$refs.popup.open()}}),onLoad:function(){this.init()}};i.default=v},8673:function(t,i,e){"use strict";e.r(i);var n=e("29c0"),a=e.n(n);for(var s in n)"default"!==s&&function(t){e.d(i,t,(function(){return n[t]}))}(s);i["default"]=a.a},cba2:function(t,i,e){"use strict";var n,a=function(){var t=this,i=t.$createElement,e=t._self._c||i;return e("v-uni-view",{class:t.Theme},[e("v-uni-view",{class:t.Theme,style:{height:t.statusBarHeight+"px",paddingTop:"60rpx"}}),e("v-uni-view",{staticClass:"fixed-top",class:t.Theme,style:{height:t.statusBarHeight+"px"}}),e("v-uni-view",{staticClass:"flex align-center position-fixed w-100",class:t.Theme,staticStyle:{"z-index":"99"},style:{height:"60rpx",top:t.statusBarHeight+"px"}},[e("my-icon",{staticClass:"mx-2",attrs:{iconId:"icon-jiantou-copy"},on:{"my-click":function(i){arguments[0]=i=t.$handleEvent(i),t.quit.apply(void 0,arguments)}}}),e("v-uni-view",{staticClass:"font-lg"},[t._t("default")],2)],1)],1)},s=[];e.d(i,"b",(function(){return a})),e.d(i,"c",(function(){return s})),e.d(i,"a",(function(){return n}))},ce25:function(t,i,e){"use strict";e.r(i);var n=e("cba2"),a=e("8673");for(var s in a)"default"!==s&&function(t){e.d(i,t,(function(){return a[t]}))}(s);var c,o=e("f0c5"),r=Object(o["a"])(a["default"],n["b"],n["c"],!1,null,"1ed0f388",null,!1,n["a"],c);i["default"]=r.exports},d04d:function(t,i,e){"use strict";e.r(i);var n=e("5f53"),a=e.n(n);for(var s in n)"default"!==s&&function(t){e.d(i,t,(function(){return n[t]}))}(s);i["default"]=a.a}}]);