<template>
	<view class="container">
		<view class="banner">
		<image src="https://img-shop.qmimg.cn/s23107/2020/04/26/3eb7808bf105262604.jpg" class="bg"></image>
		<view class="intro">
			<view class="greet">您好，{{isLogin ? userInfo.nickName :'游客'}}</view>
			<view class="note">一杯奶茶，一口软欧包，在奈雪遇见两种美好</view>
			</view>
		</view>
		<view class="content"></view>
	</view>
</template>

<script>
	import {mapState} from 'vuex';
	export default {
		data() {
			return {
				title: 'Hello'
			}
		},
		comments:{
			...mapState(['isLogin','orderType','userInfo','choseStore'])
		},
		onLoad() {

		},
		methods: {

		}
	}
</script>

<style lang="scss">
	.banner{
		position: relative;
		height: 600rpx;
		width: 100%;
		.bg{
			height: 600rpx;
			width: 100%;
		}
		.intro{
			position: absolute;
			display: flex;
			flex-direction: column;
			color: #ffffff;
			top: calc(50rpx+var(--status-bar-height));
			left: 40rpx;
			.greet{
				font-size: $font-size-lg;
				margin-bottom: 10rpx;
			}
			.note{
				font-size: $font-size-sm;
			}
		}
	}
	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}

	.logo {
		height: 200rpx;
		width: 200rpx;
		margin-top: 200rpx;
		margin-left: auto;
		margin-right: auto;
		margin-bottom: 50rpx;
	}

	.text-area {
		display: flex;
		justify-content: center;
	}

	.title {
		font-size: 36rpx;
		color: #8f8f94;
	}
</style>
