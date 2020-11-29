<template>
	<view>
		<h3>订单总价：{{total}}</h3>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				total:''
			}
		},
		onLoad(options) {
			if(options.total){
				this.total = options.total;
				console.log(this.total)
			}
		},
		methods: {
			
		}
	}
</script>

<style>
</style>