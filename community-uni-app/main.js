import Vue from 'vue'
import store from 'store'
import App from './App'
import myIcon from './components/myIcon.vue'

Vue.config.productionTip = false

App.mpType = 'app'

Vue.prototype.$statusBarHeight=uni.getSystemInfoSync().statusBarHeight;
Vue.component('myIcon',myIcon)
Vue.prototype.$store=store
const app = new Vue({
	store,
    ...App
	
})
app.$mount()
